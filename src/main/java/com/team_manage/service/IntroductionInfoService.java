package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.introduction.dto.AuditDTO;
import com.team_manage.controller.introduction.dto.WxIntroductionInfoDTO;
import com.team_manage.controller.introduction.query.WebIntroductionQry;
import com.team_manage.controller.introduction.query.WxIntroductionQry;
import com.team_manage.controller.introduction.query.WxUserIntroductionQry;
import com.team_manage.controller.introduction.vo.WxIntroductionInfoVO;
import com.team_manage.entity.IntroductionInfo;

/**
 * <p>
 * 攻略信息表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface IntroductionInfoService extends IService<IntroductionInfo> {

    /**
     * 攻略信息分页查询
     *
     * @param qry qry
     * @return IPage<WxIntroductionInfoVO>
     */
    IPage<WxIntroductionInfoVO> pageByQry(WxIntroductionQry qry);

    /**
     * 攻略信息分页查询
     *
     * @param qry qry
     * @return IPage<WxIntroductionInfoVO>
     */
    IPage<WxIntroductionInfoVO> pageByQry(WebIntroductionQry qry);

    /**
     * 我的攻略信息分页查询
     *
     * @param qry qry
     * @return IPage<WxIntroductionInfoVO>
     */
    IPage<WxIntroductionInfoVO> mine(WxIntroductionQry qry);

    /**
     * 攻略信息详情
     *
     * @param introductionId 攻略ID
     * @return WxIntroductionInfoVO
     */
    WxIntroductionInfoVO detail(Long introductionId);

    /**
     * 新增攻略信息
     *
     * @param introductionInfoDTO 攻略新增DTO
     * @return Boolean
     */
    Boolean add(WxIntroductionInfoDTO introductionInfoDTO);

    /**
     * 编辑攻略信息
     *
     * @param introductionId      攻略ID
     * @param introductionInfoDTO 攻略DTO
     * @return Boolean
     */
    Boolean edit(Long introductionId, WxIntroductionInfoDTO introductionInfoDTO);

    /**
     * 攻略信息审核
     *
     * @param auditDTO 审核DTO
     * @return Boolean
     */
    Boolean audit(AuditDTO auditDTO);

    /**
     * 用户攻略信息分页查询
     *
     * @param qry qry
     * @return IPage<WxIntroductionInfoVO>
     */
    IPage<WxIntroductionInfoVO> user(WxUserIntroductionQry qry);

    /**
     * 删除攻略信息
     *
     * @param introductionId 攻略ID
     * @return Boolean
     */
    Boolean del(Long introductionId);
}
