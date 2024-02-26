package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.facilities.query.WxFeaturedProductQry;
import com.team_manage.controller.facilities.vo.FeaturedProductVO;
import com.team_manage.entity.FeaturedProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 特色商品表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface FeaturedProductMapper extends BaseMapper<FeaturedProduct> {

    /**
     * 特色商品信息分页查询（带门店）
     *
     * @param qry   查询qry
     * @param pages 分页类
     * @return IPage<FeaturedProductVO>
     */
    IPage<FeaturedProductVO> pageByQry1(@Param("qry") WxFeaturedProductQry qry, @Param("pages") IPage<FeaturedProductVO> pages);
}
