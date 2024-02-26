package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.noticeinfo.dto.NoticeInfoDTO;
import com.team_manage.controller.noticeinfo.query.NoticeInfoQry;
import com.team_manage.controller.noticeinfo.vo.NoticeInfoVO;
import com.team_manage.entity.NoticeInfo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface NoticeInfoService extends IService<NoticeInfo> {


    /**
     * 修改用户信息
     *
     * @param noticeInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean edit(NoticeInfoDTO noticeInfoDTO);


    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    IPage<NoticeInfoVO> pageByQry(NoticeInfoQry qry);


    /**
     * 删除用户信息
     *
     * @param noticeId 用户ID
     * @return Boolean
     */
    Boolean del(Long noticeId);

    /**
     * 修改用户信息
     *
     * @param noticeId      用户ID
     * @param noticeInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean webEdit(Long noticeId, NoticeInfoDTO noticeInfoDTO);

    /**
     * 新增用户信息
     *
     * @param noticeInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean add(NoticeInfoDTO noticeInfoDTO);

    /**
     * 用户信息详情
     *
     * @param noticeId 用户ID
     * @return WebUserVO
     */
    NoticeInfoVO detail(Long noticeId);
}
