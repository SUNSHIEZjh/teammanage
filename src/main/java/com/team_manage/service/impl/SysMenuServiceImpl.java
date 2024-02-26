package com.team_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.common.Constant;
import com.team_manage.controller.role.query.MenuQry;
import com.team_manage.controller.role.vo.MenuVO;
import com.team_manage.entity.SysMenu;
import com.team_manage.mapper.SysMenuMapper;
import com.team_manage.service.SysMenuService;
import com.team_manage.utils.CopyUtils;
import com.team_manage.utils.SpecialCharacterUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-09
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    /**
     * 菜单分页查询
     *
     * @param menuQry 菜单查询Qry
     * @return IPage<MenuVO>
     */
    @Override
    public IPage<MenuVO> pageByQry(MenuQry menuQry) {
        IPage<SysMenu> pages = new Page<>(menuQry.getCurrent(), menuQry.getLimit());
        pages = new LambdaQueryChainWrapper<>(baseMapper)
                .like(StringUtils.isNotBlank(menuQry.getMenuName()),
                        SysMenu::getMenuName,
                        SpecialCharacterUtil.escapeStr(menuQry.getMenuName())
                ).eq(ObjectUtils.isNotEmpty(menuQry.getMenuType()) && !Constant.INTEGER_ZERO.equals(menuQry.getMenuType()),
                        SysMenu::getMenuType,
                        menuQry.getMenuType()
                ).page(pages);
        return CopyUtils.covertPage(pages, MenuVO.class);
    }

    /**
     * 菜单详情
     *
     * @param menuId 菜单ID
     * @return MenuVO
     */
    @Override
    public MenuVO detailById(Long menuId) {
        SysMenu menu = this.getById(menuId);
        return CopyUtils.classCopy(menu, MenuVO.class);
    }
}
