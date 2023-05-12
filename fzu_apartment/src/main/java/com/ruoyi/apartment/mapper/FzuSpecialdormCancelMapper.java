package com.ruoyi.apartment.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.entity.FzuSpecialdormCancel;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * 特殊退宿申请Mapper接口
 *
 * @author wsh
 * @date 2023-02-09
 */
public interface FzuSpecialdormCancelMapper
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
     * 删除特殊退宿申请
     *
     * @param cancelId 特殊退宿申请主键
     * @return 结果
     */
    public int deleteFzuSpecialdormCancelByCancelId(Long cancelId);

    /**
     * 批量删除特殊退宿申请
     *
     * @param cancelIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFzuSpecialdormCancelByCancelIds(Long[] cancelIds);

    List<SysUser> selectUserListByRoleId(SysUser sysUser);

//    List<FzuDormitoryInfo> selectDormIdByStudentId(FzuDormitoryInfo fzuDormitoryInfo);

    List<FzuDormitoryInfo> selectDormIdByStudentId(@Param("userId") Long userId, @Param("dormStatus") List<String> dormStatus);

//    public int deleteFzuSpecialStuDormitoryByDormId(Long dormId);

    public int findPendingApplicationByDormId(Long dormId);

//    public void changDeleteDormStatus1(Long dormId);
//    public void changDeleteDormStatus3(Long dormId);
//    public void changDeleteDormStatus5(Long dormId);
    public List<String> getDormIdsToUpdate(Map<String, Object> params);

    // This corresponds to the "updateBedStatus" statement.
    public void updateBedStatus(Map<String, Object> params);

    // This corresponds to the "getDormInfo" statement.
    public Map<String, Object> getDormInfo(Map<String, Object> params);

    // This corresponds to the "getBedCount" statement.
    public int getBedCount(Map<String, Object> params);

    // This corresponds to the "updateDormStatus" statement.
    public void updateDormStatus(Map<String, Object> params);
    public int deleteFzuSpecialStuDormitoryByDormId(Long dormId);

}
