package com.team_manage.controller.topic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
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
@RequestMapping("/web/comment/info")
@Api(value = "WebCommentInfoController", tags = {"WEB-评论信息接口"})
public class WebCommentInfoController {

    /**
     * 评论信息Service
     */
    private final CommentInfoService commentInfoService;

    @ApiOperation("评论信息分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("web:comment:page")
    public Result<IPage<CommentInfoVO>> page(@RequestBody @Valid WxCommentQry qry) {
        return Result.success(commentInfoService.pageByTopic(qry));
    }

    @ApiOperation("删除评论信息")
    @DeleteMapping("/del")
//    @SaCheckPermission("wx:comment:del")
    public Result<Boolean> del(@RequestBody @NotNull(message = "评论ID列表") List<Long> commentIds) {
        return Result.success(commentInfoService.del(commentIds));
    }
}

