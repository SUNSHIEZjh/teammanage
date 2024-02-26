package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.controller.matchinfo.dto.MatchInfoDTO;
import com.team_manage.controller.matchinfo.query.MatchInfoQry;
import com.team_manage.controller.matchinfo.vo.MatchInfoVO;
import com.team_manage.controller.noticeinfo.dto.NoticeInfoDTO;
import com.team_manage.controller.noticeinfo.query.NoticeInfoQry;
import com.team_manage.controller.noticeinfo.vo.NoticeInfoVO;
import com.team_manage.entity.MatchInfo;
import com.team_manage.entity.NoticeInfo;
import com.team_manage.mapper.MatchInfoMapper;
import com.team_manage.mapper.NoticeInfoMapper;
import com.team_manage.service.MatchInfoService;
import com.team_manage.service.NoticeInfoService;
import com.team_manage.utils.CopyUtils;
import com.team_manage.utils.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.apache.xmlbeans.impl.regex.Match;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class MatchInfoServiceImpl extends ServiceImpl<MatchInfoMapper, MatchInfo> implements MatchInfoService {

    /**
     * Redis工具
     */
    private final RedisUtil redisUtil;


    /**
     * 修改用户信息
     *
     * @param matchInfoDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean edit(MatchInfoDTO matchInfoDTO) {
        // 获取登录用户ID
        long matchInfoId = StpUtil.getLoginIdAsLong();
        // 转换用户实体类
        MatchInfo matchInfo = CopyUtils.classCopy(matchInfoDTO, MatchInfo.class);
        // 设置用户ID
        matchInfo.setKeyId(matchInfoId);
        // 根据ID更新信息
        this.updateById(matchInfo);
        // 返回成功
        return true;
    }


    /**
     * 用户信息分页查询
     *
     * @param qry 查询Qry
     * @return WebUserVO
     */
    @Override
    public IPage<MatchInfoVO> pageByQry(MatchInfoQry qry) {
        IPage<MatchInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        return getBaseMapper().matchInfoPageByQry(qry, pages);
    }


    /**
     * 删除用户信息
     *
     * @param noticeId 用户ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long matchInfoId) {
        // 删除用户信息
        return this.removeById(matchInfoId);
    }

    /**
     * 修改用户信息
     *
     * @param matchId  用户ID
     * @param matchInfoDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean webEdit(Long matchId, MatchInfoDTO matchInfoDTO) {
        // 修改用户信息
        MatchInfo matchInfo = CopyUtils.classCopy(matchInfoDTO, MatchInfo.class);
        matchInfo.setKeyId(matchId);
        return this.updateById(matchInfo);
    }

    /**
     * 新增用户信息
     *
     * @param matchInfoDTO 用户DTO
     * @return Boolean
     */
    @Override
    public Boolean add(MatchInfoDTO matchInfoDTO) {
        // 新增用户
        MatchInfo matchInfo = CopyUtils.classCopy(matchInfoDTO, MatchInfo.class);
        // // 新增用户信息
        this.save(matchInfo);
        return true;
    }

    /**
     * 用户信息详情
     *
     * @param matchId 用户ID
     * @return WebUserVO
     */
    @Override
    public MatchInfoVO detail(Long matchId) {
        return CopyUtils.classCopy(baseMapper.selectById(matchId), MatchInfoVO.class);
    }

}
