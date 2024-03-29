package com.ruoyi.apartment.service;

import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.entity.FzuSpecialdormApproval;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 特殊宿舍申请Service接口
 *
 * @author wsh
 * @date 2023-02-08
 */
public interface IFzuSpecialdormApprovalService
{
    /**
     * 查询特殊宿舍申请
     *
     * @param approvalId 特殊宿舍申请主键
     * @return 特殊宿舍申请
     */
    public FzuSpecialdormApproval selectFzuSpecialdormApprovalByApprovalId(Long approvalId);

    /**
     * 查询特殊宿舍申请列表
     *
     * @param fzuSpecialdormApproval 特殊宿舍申请
     * @return 特殊宿舍申请集合
     */
    public List<FzuSpecialdormApproval> selectFzuSpecialdormApprovalList(FzuSpecialdormApproval fzuSpecialdormApproval);

    /**
     * 新增特殊宿舍申请
     *
     * @param fzuSpecialdormApproval 特殊宿舍申请
     * @return 结果
     */
    public int insertFzuSpecialdormApproval(FzuSpecialdormApproval fzuSpecialdormApproval);

    /**
     * 修改特殊宿舍申请
     *
     * @param fzuSpecialdormApproval 特殊宿舍申请
     * @return 结果
     */
    public int updateFzuSpecialdormApproval(FzuSpecialdormApproval fzuSpecialdormApproval);

    /**
     * 批量删除特殊宿舍申请
     *
     * @param approvalIds 需要删除的特殊宿舍申请主键集合
     * @return 结果
     */
    public int deleteFzuSpecialdormApprovalByApprovalIds(Long[] approvalIds);

    /**
     * 删除特殊宿舍申请信息
     *
     * @param approvalId 特殊宿舍申请主键
     * @return 结果
     */
    public int deleteFzuSpecialdormApprovalByApprovalId(Long approvalId);

    /**
     * 查询角色userId列表
     *
     * @param sysUser 查询条件
     * @return 结果
     */
    public List<SysUser> selectUserListByRoleId(SysUser sysUser);



    public Integer insertFzuStudentDormitory(FzuDormitoryInfo fzuDormitoryInfo);

    /**
     * 查询用户信息
     *
     * @param userId 用户信息主键
     * @return 用户信息
     */
    public SysUser selectSysUserByUserId(Long userId);

    public void changAddDormStatus2(Long dormId);

    public void changAddDormStatus4(Long dormId);

    public void changAddDormStatus6(Long dormId);
}

