package com.team_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.controller.noticeinfo.query.NoticeInfoQry;
import com.team_manage.controller.noticeinfo.vo.NoticeInfoVO;
import com.team_manage.entity.NoticeInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 公告信息表 Mapper 接口
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
public interface NoticeInfoMapper extends BaseMapper<NoticeInfo> {

    /**
     * 公告信息信息分页查询
     *
     * @param qry   查询Qry
     * @param pages 分页类
     * @return NoticeInfoVO
     */
    IPage<NoticeInfoVO> noticeInfoPageByQry(@Param("qry") NoticeInfoQry qry, @Param("pages") IPage<NoticeInfoVO> pages);


}
