package com.team_manage.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team_manage.controller.user.dto.PersonInfoDTO;
import com.team_manage.controller.user.query.PersonInfoQry;
import com.team_manage.controller.user.vo.PersonInfoVO;
import com.team_manage.entity.PersonInfo;
import com.team_manage.exception.ServiceException;
import com.team_manage.mapper.PersonInfoMapper;
import com.team_manage.service.PersonInfoService;
import com.team_manage.utils.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 人员信息表 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
@Service
@RequiredArgsConstructor
public class PersonInfoServiceImpl extends ServiceImpl<PersonInfoMapper, PersonInfo> implements PersonInfoService {

    /**
     * 分页查询人员信息
     *
     * @param qry 查询Qry
     * @return IPage<PersonInfoVO>
     */
    @Override
    public IPage<PersonInfoVO> pageByQry(PersonInfoQry qry) {
        IPage<PersonInfo> pages = new Page<>(qry.getCurrent(), qry.getLimit());
        pages = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(ObjectUtils.isNotEmpty(qry.getUserId()), PersonInfo::getUserId, qry.getUserId())
                .like(StringUtils.isNotEmpty(qry.getPersonName()), PersonInfo::getPersonName, qry.getPersonName())
                .like(StringUtils.isNotEmpty(qry.getPersonPhone()), PersonInfo::getPersonPhone, qry.getPersonPhone())
                .like(StringUtils.isNotEmpty(qry.getPersonCard()), PersonInfo::getPersonCard, qry.getPersonCard())
                .orderByAsc(PersonInfo::getPersonId)
                .page(pages);
        return CopyUtils.covertPage(pages, PersonInfoVO.class);
    }

    /**
     * 人员信息详情
     *
     * @param personId 人员ID
     * @return PersonInfoVO
     */
    @Override
    public PersonInfoVO detailById(Long personId) {
        PersonInfo personInfo = baseMapper.selectById(personId);
        return CopyUtils.classCopy(personInfo, PersonInfoVO.class);
    }

    /**
     * 新增人员信息
     *
     * @param personInfoDTO 人员DTO
     * @return Boolean
     */
    @Override
    public Boolean add(PersonInfoDTO personInfoDTO) {
        List<PersonInfo> list = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(PersonInfo::getUserId, StpUtil.getLoginIdAsLong())
                .eq(PersonInfo::getPersonName, personInfoDTO.getPersonName())
                .eq(PersonInfo::getPersonCard, personInfoDTO.getPersonCard())
                .list();
        if (!CollectionUtils.isEmpty(list)){
            throw new ServiceException("人员信息已存在,新增失败!");
        }
        PersonInfo personInfo = CopyUtils.classCopy(personInfoDTO, PersonInfo.class);
        personInfo.setUserId(StpUtil.getLoginIdAsLong());
        return this.save(personInfo);
    }

    /**
     * 修改人员信息
     *
     * @param personId      人员ID
     * @param personInfoDTO 人员DTO
     * @return Boolean
     */
    @Override
    public Boolean edit(Long personId, PersonInfoDTO personInfoDTO) {
        List<PersonInfo> list = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(PersonInfo::getUserId, StpUtil.getLoginIdAsLong())
                .eq(PersonInfo::getPersonName, personInfoDTO.getPersonName())
                .eq(PersonInfo::getPersonCard, personInfoDTO.getPersonCard())
                .ne(PersonInfo::getPersonId,personId)
                .list();
        if (!CollectionUtils.isEmpty(list)){
            throw new ServiceException("人员信息已存在,修改失败!");
        }
        PersonInfo personInfo = CopyUtils.classCopy(personInfoDTO, PersonInfo.class);
        personInfo.setUserId(StpUtil.getLoginIdAsLong());
        personInfo.setPersonId(personId);
        return this.updateById(personInfo);
    }

    /**
     * 删除人员信息
     *
     * @param personId 人员ID
     * @return Boolean
     */
    @Override
    public Boolean del(Long personId) {
        return this.removeById(personId);
    }
}
