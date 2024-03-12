package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.controller.noticeinfo.dto.NoticeInfoDTO;
import com.team_manage.controller.noticeinfo.query.NoticeInfoQry;
import com.team_manage.controller.noticeinfo.vo.NoticeInfoVO;
import com.team_manage.entity.NoticeInfo;
import com.team_manage.mapper.NoticeInfoMapper;
import com.team_manage.service.NoticeInfoService;
import com.team_manage.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 公告信息 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class NoticeInfoServiceImpl extends ServiceImpl<NoticeInfoMapper, NoticeInfo> implements NoticeInfoService {

    /**
     * 修改公告信息信息
     *
     * @param noticeInfoDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean edit(NoticeInfoDTO noticeInfoDTO) {
        // 获取登录用户ID
        long tranPlanInfoId = StpUtil.getLoginIdAsLong();
        // 转换用户实体类
        NoticeInfo noticeInfo = CopyUtils.classCopy(noticeInfoDTO, NoticeInfo.class);
        // 设置用户ID
        noticeInfo.setKeyId(tranPlanInfoId);
        // 根据ID更新信息
        this.updateById(noticeInfo);
        // 返回成功
        return true;
    }


    /**
     * 公告信息分页查询
     *
     * @param qry 查询Qry
     * @return NoticeInfoVO
     */
    @Override
    public IPage<NoticeInfoVO> pageByQry(NoticeInfoQry qry) {
        IPage<NoticeInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return getBaseMapper().noticeInfoPageByQry(qry, pages);
    }


    /**
     * 删除公告信息信息
     *
     * @param noticeId 公告信息ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long noticeId) {
        // 删除用户信息
        return this.removeById(noticeId);
    }

    /**
     * 修改公告信息信息
     *
     * @param noticeId      公告信息ID
     * @param noticeInfoDTO 公告信息DTO
     * @return Boolean
     */
    @Override
    public Boolean webEdit(Long noticeId, NoticeInfoDTO noticeInfoDTO) {
        // 修改用户信息
        NoticeInfo noticeInfo = CopyUtils.classCopy(noticeInfoDTO, NoticeInfo.class);
        noticeInfo.setKeyId(noticeId);
        return this.updateById(noticeInfo);
    }

    /**
     * 新增公告信息信息
     *
     * @param noticeInfoDTO 公告信息DTO
     * @return Boolean
     */
    @Override
    public Boolean add(NoticeInfoDTO noticeInfoDTO) {
        // 新增用户
        NoticeInfo noticeInfo = CopyUtils.classCopy(noticeInfoDTO, NoticeInfo.class);
        // // 新增用户信息
        noticeInfo.setReleaseTime(new Date());
        this.save(noticeInfo);
        return true;
    }

    /**
     * 公告信息信息详情
     *
     * @param noticeId 公告信息ID
     * @return NoticeInfoVO
     */
    @Override
    public NoticeInfoVO detail(Long noticeId) {
        return CopyUtils.classCopy(baseMapper.selectById(noticeId), NoticeInfoVO.class);
    }

}
