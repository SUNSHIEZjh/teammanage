package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.introduction.query.WxIntroductionNodeQry;
import com.team_manage.controller.introduction.vo.WxIntroductionNodeVO;
import com.team_manage.entity.IntroductionNode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 攻略节点表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface IntroductionNodeMapper extends BaseMapper<IntroductionNode> {

    /**
     * 攻略节点分页查询
     *
     * @param nodeQry qry
     * @param pages   分页类
     * @return IPage<WxIntroductionNodeVO>
     */
    IPage<WxIntroductionNodeVO> pageByQry(@Param("nodeQry") WxIntroductionNodeQry nodeQry,
                                          @Param("pages") IPage<WxIntroductionNodeVO> pages);
}
