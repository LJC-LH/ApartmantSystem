package com.ruoyi.apartment.mapper;

import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.entity.FzuSpecialdormApproval;
import com.ruoyi.common.core.domain.entity.SysUser;


/**
 * 特殊宿舍申请Mapper接口
 *
 * @author wsh
 * @date 2023-02-08
 */
public interface FzuSpecialdormApprovalMapper
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
     * 删除特殊宿舍申请
     *
     * @param approvalId 特殊宿舍申请主键
     * @return 结果
     */
    public int deleteFzuSpecialdormApprovalByApprovalId(Long approvalId);

    /**
     * 批量删除特殊宿舍申请
     *
     * @param approvalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFzuSpecialdormApprovalByApprovalIds(Long[] approvalIds);

    /**
     * 查询角色userId列表
     *
     * @param sysUser
     * @return 结果
     */
    public List<SysUser> selectUserListByRoleId(SysUser sysUser);

    /**
     * 添加学生宿舍
     *
     * @param fzuDormitoryInfo
     * @return 结果
     */
    public int insertFzuStudentDormitory(FzuDormitoryInfo fzuDormitoryInfo);

    /**
     * 查询用户信息
     *
     * @param userId 用户信息主键
     * @return 用户信息
     */
    public SysUser selectSysUserByUserId(Long userId);

    public Integer selectFzuStuDormitoryByDormId(Long dormId);

    public void changeAddBedStatus(Long dormId);

    public void changeDormStatus2(Long dormId);

    public void changeDormStatus4(Long dormId);

    public void changeDormStatus6(Long dormId);

    public List<Long> getDormIdList(Long dormId);
}
