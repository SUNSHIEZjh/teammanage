package com.team_manage.service;

import com.team_manage.controller.topic.dto.LikeDTO;
import com.team_manage.entity.LikeInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 点赞信息表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface LikeInfoService extends IService<LikeInfo> {

    /**
     * 点赞信息Service
     *
     * @param likeDTO 点赞DTO
     * @return Boolean
     */
    Boolean add(LikeDTO likeDTO);

    /**
     * 取消点赞
     *
     * @param businessId 业务ID
     * @return Boolean
     */
    Boolean cancel(Long businessId);
}
