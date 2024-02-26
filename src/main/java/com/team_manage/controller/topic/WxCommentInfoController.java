package com.team_manage.controller.topic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.topic.dto.CommentDTO;
import com.team_manage.controller.topic.query.WxCommentQry;
import com.team_manage.controller.topic.vo.CommentInfoVO;
import com.team_manage.service.CommentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 评论信息表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wx/comment/info")
@Api(value = "WxCommentInfoController", tags = {"WX-评论信息接口"})
public class WxCommentInfoController {

    /**
     * 评论信息Service
     */
    private final CommentInfoService commentInfoService;

    @ApiOperation("评论信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("wx:comment:page")
    public Result<IPage<CommentInfoVO>> page(@RequestBody @Valid WxCommentQry qry) {
        return Result.success(commentInfoService.pageByTopic(qry));
    }

    @ApiOperation("新增评论")
    @PostMapping("/add")
//    @SaCheckPermission("wx:comment:add")
    public Result<CommentInfoVO> add(@RequestBody @Valid CommentDTO commentDTO) {
        return Result.success(commentInfoService.add(commentDTO));
    }

    @ApiOperation("删除评论信息")
    @DeleteMapping("/del")
//    @SaCheckPermission("wx:comment:del")
    public Result<Boolean> del(@RequestBody @NotNull(message = "评论ID列表") List<Long> commentIds) {
        return Result.success(commentInfoService.del(commentIds));
    }
}

