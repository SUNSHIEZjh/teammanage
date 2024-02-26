package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.introduction.query.WebIntroductionQry;
import com.team_manage.controller.introduction.query.WxIntroductionQry;
import com.team_manage.controller.introduction.query.WxUserIntroductionQry;
import com.team_manage.controller.introduction.vo.WxIntroductionInfoVO;
import com.team_manage.entity.IntroductionInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 攻略信息表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface IntroductionInfoMapper extends BaseMapper<IntroductionInfo> {

    /**
     * 攻略增加减少点赞数量
     *
     * @param introductionId 攻略ID
     * @param type           类型：1、点赞 2、收藏
     * @param change         点赞类型：1、增加 2、减少
     * @param num            数量
     * @return Boolean
     */
    Boolean setNum(@Param("introductionId") Long introductionId, @Param("type") Integer type, @Param("change") Integer change, @Param("num") Integer num);

    /**
     * 攻略信息分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return IPage<WxIntroductionInfoVO>
     */
    IPage<WxIntroductionInfoVO> pageByQry(@Param("qry") WxIntroductionQry qry, @Param("pages") IPage<WxIntroductionInfoVO> pages);

    /**
     * 我的攻略信息分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return IPage<WxIntroductionInfoVO>
     */
    IPage<WxIntroductionInfoVO> mine(@Param("qry") WxIntroductionQry qry, @Param("pages") IPage<WxIntroductionInfoVO> pages);

    /**
     * 攻略信息详情
     *
     * @param introductionId 攻略ID
     * @param userId         用户ID
     * @return WxIntroductionInfoVO
     */
    WxIntroductionInfoVO detail(@Param("introductionId") Long introductionId, @Param("userId") Long userId);

    /**
     * 攻略信息分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return IPage<WxIntroductionInfoVO>
     */
    IPage<WxIntroductionInfoVO> pageByQry1(@Param("qry") WebIntroductionQry qry, @Param("pages") IPage<WxIntroductionInfoVO> pages);

    /**
     * 用户攻略信息分页查询
     *
     * @param qry   qry
     * @param pages 分页信息
     * @return IPage<WxIntroductionInfoVO>
     */
    IPage<WxIntroductionInfoVO> user(@Param("qry") WxUserIntroductionQry qry, @Param("pages") IPage<WxIntroductionInfoVO> pages);
}
