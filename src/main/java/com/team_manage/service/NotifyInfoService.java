package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.topic.query.WxNotifyQry;
import com.team_manage.controller.topic.vo.NotifyInfoVO;
import com.team_manage.entity.NotifyInfo;

import java.util.List;

/**
 * <p>
 * 消息通知表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface NotifyInfoService extends IService<NotifyInfo> {

    /**
     * 用户消息通知分页查询
     *
     * @param qry 查询Qry
     * @return IPage<NotifyInfoVO>
     */
    IPage<NotifyInfoVO> pageByQry(WxNotifyQry qry);

    /**
     * 批量已读消息
     *
     * @param notifyIds 通知ID列表
     * @return Boolean
     */
    Boolean batchRead(List<Long> notifyIds);

    /**
     * 已读所有消息
     *
     * @return Boolean
     */
    Boolean readAll();
}
