package com.ruoyi.apartment.service;

import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.entity.FzuSpecialdormCancel;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 特殊退宿申请Service接口
 *
 * @author wsh
 * @date 2023-02-09
 */
public interface IFzuSpecialdormCancelService
{
    /**
     * 查询特殊退宿申请
     *
     * @param cancelId 特殊退宿申请主键
     * @return 特殊退宿申请
     */
    public FzuSpecialdormCancel selectFzuSpecialdormCancelByCancelId(Long cancelId);

    /**
     * 查询特殊退宿申请列表
     *
     * @param fzuSpecialdormCancel 特殊退宿申请
     * @return 特殊退宿申请集合
     */
    public List<FzuSpecialdormCancel> selectFzuSpecialdormCancelList(FzuSpecialdormCancel fzuSpecialdormCancel);

    /**
     * 新增特殊退宿申请
     *
     * @param fzuSpecialdormCancel 特殊退宿申请
     * @return 结果
     */
    public int insertFzuSpecialdormCancel(FzuSpecialdormCancel fzuSpecialdormCancel);

    /**
     * 修改特殊退宿申请
     *
     * @param fzuSpecialdormCancel 特殊退宿申请
     * @return 结果
     */
    public int updateFzuSpecialdormCancel(FzuSpecialdormCancel fzuSpecialdormCancel);

    /**
     * 批量删除特殊退宿申请
     *
     * @param cancelIds 需要删除的特殊退宿申请主键集合
     * @return 结果
     */
    public int deleteFzuSpecialdormCancelByCancelIds(Long[] cancelIds);

    /**
     * 删除特殊退宿申请信息
     *
     * @param cancelId 特殊退宿申请主键
     * @return 结果
     */
    public int deleteFzuSpecialdormCancelByCancelId(Long cancelId);

    List<SysUser> selectUserListByRoleId(SysUser sysUser1);

    List<FzuDormitoryInfo> selectDormIdByStudentId(FzuDormitoryInfo fzuDormitoryInfo);

    public int deleteFzuSpecialStuDormitoryByDormId(Long dormId);
}
