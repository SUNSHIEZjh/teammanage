package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.introduction.query.WxIntroductionNodeQry;
import com.team_manage.controller.introduction.vo.WxIntroductionNodeVO;
import com.team_manage.entity.IntroductionNode;

/**
 * <p>
 * 攻略节点表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface IntroductionNodeService extends IService<IntroductionNode> {

    /**
     * 攻略节点分页查询
     *
     * @param nodeQry 查询Qry
     * @return IPage<WxIntroductionNodeVO>
     */
    IPage<WxIntroductionNodeVO> pageByQry(WxIntroductionNodeQry nodeQry);
}
