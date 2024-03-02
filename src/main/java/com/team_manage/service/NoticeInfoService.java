package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.noticeinfo.dto.NoticeInfoDTO;
import com.team_manage.controller.noticeinfo.query.NoticeInfoQry;
import com.team_manage.controller.noticeinfo.vo.NoticeInfoVO;
import com.team_manage.entity.NoticeInfo;

/**
 * <p>
 * 公告信息 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface NoticeInfoService extends IService<NoticeInfo> {


    /**
     * 修改公告信息信息
     *
     * @param noticeInfoDTO 公告信息DTO
     * @return Boolean
     */
    Boolean edit(NoticeInfoDTO noticeInfoDTO);


    /**
     * 公告信息信息分页查询
     *
     * @param qry 查询Qry
     * @return NoticeInfoVO
     */
    IPage<NoticeInfoVO> pageByQry(NoticeInfoQry qry);


    /**
     * 删除公告信息信息
     *
     * @param noticeId 公告信息ID
     * @return Boolean
     */
    Boolean del(Long noticeId);

    /**
     * 修改公告信息信息
     *
     * @param noticeId      公告信息ID
     * @param noticeInfoDTO 公告信息DTO
     * @return Boolean
     */
    Boolean webEdit(Long noticeId, NoticeInfoDTO noticeInfoDTO);

    /**
     * 新增公告信息信息
     *
     * @param noticeInfoDTO 公告信息DTO
     * @return Boolean
     */
    Boolean add(NoticeInfoDTO noticeInfoDTO);

    /**
     * 公告信息信息详情
     *
     * @param noticeId 公告信息ID
     * @return NoticeInfoVO
     */
    NoticeInfoVO detail(Long noticeId);
}
