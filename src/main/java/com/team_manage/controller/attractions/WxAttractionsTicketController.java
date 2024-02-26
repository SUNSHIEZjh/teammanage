package com.team_manage.controller.attractions;


import com.team_manage.common.Result;
import com.team_manage.controller.attractions.query.AttractionsTicketQry;
import com.team_manage.controller.attractions.vo.AttractionsTicketVO;
import com.team_manage.service.AttractionsTicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 景点门票表 前端控制器
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wx/attractions/ticket")
@Api(value = "WxAttractionsTicketController", tags = {"WX-景点门票接口"})
public class WxAttractionsTicketController {

    /**
     * 景点门票Service
     */
    private final AttractionsTicketService attractionsTicketService;

    @ApiOperation("景点门票列表")
    @PostMapping("/list")
//    @SaCheckPermission("wx:attractions:list")
    public Result<List<AttractionsTicketVO>> list(@RequestBody @Valid AttractionsTicketQry qry) {
        return Result.success(attractionsTicketService.list(qry));
    }

    @ApiOperation("景点门票详情")
    @GetMapping("/detail/{ticketId}")
//    @SaCheckPermission("wx:attractions:ticket:detail")
    public Result<AttractionsTicketVO> detail(@PathVariable @NotNull(message = "门票ID") Long ticketId) {
        return Result.success(attractionsTicketService.detailById(ticketId));
    }
}

