package com.team_manage.controller.attractions;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.team_manage.common.Result;
import com.team_manage.controller.attractions.dto.AttractionsInfoDTO;
import com.team_manage.controller.attractions.dto.AttractionsTicketDTO;
import com.team_manage.controller.attractions.query.AttractionsInfoQry;
import com.team_manage.controller.attractions.query.AttractionsTicketQry;
import com.team_manage.controller.attractions.vo.AttractionsInfoVO;
import com.team_manage.controller.attractions.vo.AttractionsTicketVO;
import com.team_manage.service.AttractionsInfoService;
import com.team_manage.service.AttractionsTicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
@RequestMapping("/web/attractions/ticket")
@Api(value = "WebAttractionsTicketController", tags = {"WEB-景点门票接口"})
public class WebAttractionsTicketController {
    /**
     * 景点门票信息Service
     */
    private final AttractionsTicketService attractionsTicketService;

    @ApiOperation("景点门票分页查询")
    @PostMapping("/page")
//    @SaCheckPermission("web:attractions:page")
    public Result<IPage<AttractionsTicketVO>> page(@RequestBody @Valid AttractionsTicketQry qry) {
        return Result.success(attractionsTicketService.pageByQry(qry));
    }

    @ApiOperation("景点门票详情")
    @GetMapping("/detail/{ticketId}")
//    @SaCheckPermission("web:attractions:ticket:detail")
    public Result<AttractionsTicketVO> detail(@PathVariable @NotNull(message = "门票ID") Long ticketId) {
        return Result.success(attractionsTicketService.detailById(ticketId));
    }

    @ApiOperation("新增景点门票")
    @PostMapping("/add")
//    @SaCheckPermission("web:attractions:ticket:add")
    public Result<Boolean> add(@RequestBody @Valid AttractionsTicketDTO attractionsTicketDTO) {
        return Result.success(attractionsTicketService.add(attractionsTicketDTO));
    }

    @ApiOperation("修改景点门票")
    @PostMapping("/edit/{ticketId}")
//    @SaCheckPermission("web:attractions:ticket:edit")
    public Result<Boolean> edit(@NotNull(message = "门票ID") @PathVariable Long ticketId,
                                @RequestBody @Valid AttractionsTicketDTO attractionsTicketDTO) {
        return Result.success(attractionsTicketService.edit(ticketId, attractionsTicketDTO));
    }

    @ApiOperation("删除景点门票")
    @DeleteMapping("/del/{ticketId}")
//    @SaCheckPermission("web:attractions:ticket:del")
    public Result<Boolean> del(@NotNull(message = "门票ID") @PathVariable Long ticketId) {
        return Result.success(attractionsTicketService.del(ticketId));
    }

    @ApiOperation("修改景点门票状态")
    @PostMapping("/status/{ticketId}")
//    @SaCheckPermission("web:attractions:ticket:status")
    public Result<Boolean> status(@NotNull(message = "门票ID") @PathVariable Long ticketId,
                                  @RequestParam @NotNull(message = "门票状态：1、正常 2、禁售") Integer status) {
        return Result.success(attractionsTicketService.status(ticketId, status));
    }
}

