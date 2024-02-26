package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.tranplaninfo.query.TranPlanInfoQry;
import com.team_manage.controller.tranplaninfo.vo.TranPlanInfoVO;
import com.team_manage.controller.user.query.WebUserQry;
import com.team_manage.controller.user.vo.WebUserVO;
import com.team_manage.entity.SysUser;
import com.team_manage.entity.TranPlanInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface TranPlanInfoMapper extends BaseMapper<TranPlanInfo> {

    /**
     * 用户信息分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return WebUserVO
     */
    IPage<TranPlanInfoVO> tranPlanInfoPageByQry(@Param("qry") TranPlanInfoQry qry, @Param("pages") IPage<TranPlanInfoVO> pages);


}
