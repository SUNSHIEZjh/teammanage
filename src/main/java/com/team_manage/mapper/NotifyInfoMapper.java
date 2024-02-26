package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.topic.query.WxNotifyQry;
import com.team_manage.controller.topic.vo.NotifyInfoVO;
import com.team_manage.entity.NotifyInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 消息通知表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface NotifyInfoMapper extends BaseMapper<NotifyInfo> {

    /**
     * 用户消息通知分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return IPage<NotifyInfoVO>
     */
    IPage<NotifyInfoVO> pageByQry(@Param("qry") WxNotifyQry qry, @Param("pages") IPage<NotifyInfoVO> pages);
}
