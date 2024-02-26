package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.matchinfo.dto.MatchInfoDTO;
import com.team_manage.controller.matchinfo.query.MatchInfoQry;
import com.team_manage.controller.matchinfo.vo.MatchInfoVO;
import com.team_manage.controller.noticeinfo.query.NoticeInfoQry;
import com.team_manage.entity.MatchInfo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface MatchInfoService extends IService<MatchInfo> {


    /**
     * 修改用户信息
     *x
     * @param matchInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean edit(MatchInfoDTO matchInfoDTO);


    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    IPage<MatchInfoVO> pageByQry(MatchInfoQry qry);


    /**
     * 删除用户信息
     *
     * @param matchId 用户ID
     * @return Boolean
     */
    Boolean del(Long matchId);

    /**
     * 修改用户信息
     *
     * @param noticeId     用户ID
     * @param matchInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean webEdit(Long noticeId, MatchInfoDTO matchInfoDTO);

    /**
     * 新增用户信息
     *
     * @param matchInfoDTO 用户DTO
     * @return Boolean
     */
    Boolean add(MatchInfoDTO matchInfoDTO);

    /**
     * 用户信息详情
     *
     * @param matchId 用户ID
     * @return WebUserVO
     */
    MatchInfoVO detail(Long matchId);
}
