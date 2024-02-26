package com.team_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.team_manage.controller.user.dto.PersonInfoDTO;
import com.team_manage.controller.user.query.PersonInfoQry;
import com.team_manage.controller.user.vo.PersonInfoVO;
import com.team_manage.entity.PersonInfo;

/**
 * <p>
 * 人员信息表 服务类
 * </p>
 *
 * @author XXX
 * @since 2023-11-14
 */
public interface PersonInfoService extends IService<PersonInfo> {

    /**
     * 分页查询人员信息
     *
     * @param qry 查询Qry
     * @return IPage<PersonInfoVO>
     */
    IPage<PersonInfoVO> pageByQry(PersonInfoQry qry);

    /**
     * 人员信息详情
     *
     * @param personId 人员ID
     * @return PersonInfoVO
     */
    PersonInfoVO detailById(Long personId);

    /**
     * 新增人员信息
     *
     * @param personInfoDTO 人员DTO
     * @return Boolean
     */
    Boolean add(PersonInfoDTO personInfoDTO);

    /**
     * 修改人员信息
     *
     * @param personId      人员ID
     * @param personInfoDTO 人员DTO
     * @return Boolean
     */
    Boolean edit(Long personId, PersonInfoDTO personInfoDTO);

    /**
     * 删除人员信息
     *
     * @param personId 人员ID
     * @return Boolean
     */
    Boolean del(Long personId);
}
