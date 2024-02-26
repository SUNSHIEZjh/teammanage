package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.controller.topic.dto.CommentDTO;
import com.team_manage.controller.topic.query.WxCommentQry;
import com.team_manage.controller.topic.vo.CommentInfoVO;
import com.team_manage.entity.CommentInfo;
import com.team_manage.entity.NotifyInfo;
import com.team_manage.entity.SysUser;
import com.team_manage.entity.TopicInfo;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.CommentInfoMapper;
import com.team_manage.mapper.NotifyInfoMapper;
import com.team_manage.mapper.SysUserMapper;
import com.team_manage.mapper.TopicInfoMapper;
import com.team_manage.service.CommentInfoService;
import com.team_manage.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 评论信息表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class CommentInfoServiceImpl extends ServiceImpl<CommentInfoMapper, CommentInfo> implements CommentInfoService {

    /**
     * 话题Mapper
     */
    private final TopicInfoMapper topicInfoMapper;

    /**
     * 消息通知Mapper
     */
    private final NotifyInfoMapper notifyInfoMapper;

    /**
     * 用户Mapper
     */
    private final SysUserMapper sysUserMapper;

    /**
     * 新增评论
     *
     * @param commentDTO 评论DTO
     * @return Boolean
     */
    @Override
    public CommentInfoVO add(CommentDTO commentDTO) {
        // 用户ID
        long userId = StpUtil.getLoginIdAsLong();
        // 获取用户信息
        SysUser user = sysUserMapper.selectById(userId);
        // 获取评论顺序
        Integer count = baseMapper.countByTopicAndParent(commentDTO.getTopicId(), commentDTO.getCommentParent());
        // 组装评论信息
        CommentInfo commentInfo = CopyUtils.classCopy(commentDTO, CommentInfo.class);
        commentInfo.setUserId(userId)
                .setCommentTime(new Date())
                .setLikeNum(Constant.INTEGER_ZERO)
                // 评论顺序 = 库里面有的评论数量 + 1
                .setCommentSort(count + Constant.INTEGER_ONE);
        // 保存评论数据
        this.save(commentInfo);
        // 判断通知消息发送对象
        if (Constant.LONG_ZERO.equals(commentDTO.getCommentParent())) {
            // 查询帖子信息
            TopicInfo topicInfo = topicInfoMapper.selectById(commentDTO.getTopicId());
            if (ObjectUtils.isEmpty(topicInfo)) {
                throw new ServiceException("未获取到帖子信息,可能帖子已被删除!");
            }
            // 设置提醒用户ID
            notifyInfoMapper.insert(
                    new NotifyInfo()
                            .setBusinessId(commentDTO.getTopicId())
                            .setNotifyTime(new Date())
                            .setNotifyType(Constant.NOTIFY_TYPE_TOPIC)
                            .setUserId(topicInfo.getUserId())
                            .setNotifyContent("您的话题被用户[" + user.getUserName() + "]回复啦!")
                            .setNotifyStatus(Constant.INTEGER_ONE)
            );
        } else {
            // 查询被评论用户的评论
            CommentInfo parentComment = baseMapper.selectById(commentDTO.getCommentParent());
            if (ObjectUtils.isEmpty(parentComment)) {
                throw new ServiceException("未获取到评论信息,可能评论已被删除!");
            }
            // 设置提醒用户ID
            notifyInfoMapper.insert(
                    new NotifyInfo()
                            .setBusinessId(commentDTO.getTopicId())
                            .setNotifyTime(new Date())
                            .setNotifyType(Constant.NOTIFY_TYPE_TOPIC)
                            .setUserId(parentComment.getUserId())
                            .setNotifyContent("您的评论被用户[" + user.getUserName() + "]回复啦!")
                            .setNotifyStatus(Constant.INTEGER_ONE)
            );
        }
        // 返回成功后的数据信息
        return baseMapper.commentById(commentInfo.getCommentId(), userId);
    }

    /**
     * 评论信息分页查询
     *
     * @param qry 查询Qry
     * @return IPage<CommentInfoVO>
     */
    @Override
    public IPage<CommentInfoVO> pageByTopic(WxCommentQry qry) {
        // 设置用户ID
        try {
            qry.setUserId(StpUtil.getLoginIdAsLong());
        } catch (Exception e) {
            qry.setUserId(Constant.LONG_ZERO);
        }
        IPage<CommentInfoVO> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        // 分页查询评论信息
        pages = baseMapper.pageByTopic(qry, Constant.INTEGER_ONE, pages);
        // 如果查询内容为空，返回空分页
        if (CollectionUtils.isEmpty(pages.getRecords())){
            return pages;
        }
        // 查询该话题所有回复，准备组装评论的回复信息
        List<CommentInfoVO> list = baseMapper.listByTopic(qry, Constant.INTEGER_TWO);
        // 将分页查询的评论信息放入查询的回复列表中
        list.addAll(pages.getRecords());
        // 将组装好的树形列表放入分页类中
        pages.setRecords(setTree(Constant.LONG_ZERO, list));
        // 返回分页信息
        return pages;
    }

    /**
     * 删除评论信息
     *
     * @param commentIds 评论ID列表
     * @return Boolean
     */
    @Override
    public Boolean del(List<Long> commentIds) {
        return this.removeByIds(commentIds);
    }

    /**
     * 组装树形评论列表
     *
     * @param commentParent 父ID
     * @param list          评论列表
     * @return List<RoleMenuVO>
     */
    public List<CommentInfoVO> setTree(Long commentParent, List<CommentInfoVO> list) {
        List<CommentInfoVO> collect = list.stream().filter(comment -> commentParent.equals(comment.getCommentParent())).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(collect)) {
            for (CommentInfoVO commentInfoVO : collect) {
                commentInfoVO.setChildren(setTree(commentInfoVO.getCommentId(), list));
            }
        }
        return collect.stream().sorted(Comparator.comparing(CommentInfoVO::getCommentSort).thenComparing(CommentInfoVO::getCommentId)).collect(Collectors.toList());
    }
}
