package com.team_manage.mapper;

import com.team_manage.controller.introduction.vo.WxNodeRecommendVO;
import com.team_manage.entity.NodeRecommend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 节点推荐表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface NodeRecommendMapper extends BaseMapper<NodeRecommend> {

    /**
     * 根据节点ID查询推荐列表
     *
     * @param nodeId 节点ID
     * @return List<WxNodeRecommendVO>
     */
    List<WxNodeRecommendVO> getListByNodeId(@Param("nodeId") Long nodeId);
}
