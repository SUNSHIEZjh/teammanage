package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.controller.topic.query.WxNotifyQry;
import com.team_manage.controller.topic.vo.NotifyInfoVO;
import com.team_manage.entity.NotifyInfo;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.NotifyInfoMapper;
import com.team_manage.service.NotifyInfoService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 消息通知表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class NotifyInfoServiceImpl extends ServiceImpl<NotifyInfoMapper, NotifyInfo> implements NotifyInfoService {

    /**
     * 用户消息通知分页查询
     *
     * @param qry 查询Qry
     * @return IPage<NotifyInfoVO>
     */
    @Override
    public IPage<NotifyInfoVO> pageByQry(WxNotifyQry qry) {
        // 设置登录用户ID
        qry.setUserId(StpUtil.getLoginIdAsLong());
        // 设置分页类
        IPage<NotifyInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return baseMapper.pageByQry(qry, pages);
    }

    /**
     * 批量已读消息
     *
     * @param notifyIds 通知ID列表
     * @return Boolean
     */
    @Override
    public Boolean batchRead(List<Long> notifyIds) {
        // 判断消息ID是否为空
        if (CollectionUtils.isEmpty(notifyIds)) {
            throw new ServiceException("通知ID不能为空!");
        }
        // 批量设置已读消息
        return new LambdaUpdateChainWrapper<>(baseMapper)
                .in(NotifyInfo::getNotifyId, notifyIds)
                .eq(NotifyInfo::getUserId, StpUtil.getLoginIdAsLong())
                .eq(NotifyInfo::getNotifyStatus, Constant.INTEGER_ONE)
                .set(NotifyInfo::getNotifyStatus, Constant.INTEGER_TWO)
                .update();
    }

    /**
     * 已读所有消息
     *
     * @return Boolean
     */
    @Override
    public Boolean readAll() {
        // 批量设置该用户所有已读消息
        return new LambdaUpdateChainWrapper<>(baseMapper)
                .eq(NotifyInfo::getUserId, StpUtil.getLoginIdAsLong())
                .eq(NotifyInfo::getNotifyStatus, Constant.INTEGER_ONE)
                .set(NotifyInfo::getNotifyStatus, Constant.INTEGER_TWO)
                .update();
    }
}
