package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.matchinfo.dto.MatchInfoDTO;
import com.team_manage.controller.matchinfo.query.MatchInfoQry;
import com.team_manage.controller.matchinfo.vo.MatchInfoVO;
import com.team_manage.entity.MatchInfo;

/**
 * <p>
 * 赛事表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface MatchInfoService extends IService<MatchInfo> {


    /**
     * 赛事信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    IPage<MatchInfoVO> pageByQry(MatchInfoQry qry);


    /**
     * 删除赛事信息
     *
     * @param matchId 赛事ID
     * @return Boolean
     */
    Boolean del(Long matchId);

    /**
     * 修改赛事信息
     *
     * @param noticeId     赛事户ID
     * @param matchInfoDTO 赛事DTO
     * @return Boolean
     */
    Boolean webEdit(Long noticeId, MatchInfoDTO matchInfoDTO);

    /**
     * 新增赛事信息
     *
     * @param matchInfoDTO 赛事DTO
     * @return Boolean
     */
    Boolean add(MatchInfoDTO matchInfoDTO);

    /**
     * 赛事信息详情
     *
     * @param matchId 赛事 ID
     * @return MatchInfoVO
     */
    MatchInfoVO detail(Long matchId);
}
