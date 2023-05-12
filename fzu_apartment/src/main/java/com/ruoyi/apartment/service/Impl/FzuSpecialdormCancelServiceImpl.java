package com.ruoyi.apartment.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.entity.FzuSpecialdormCancel;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.FzuSpecialdormCancelMapper;
import com.ruoyi.apartment.service.IFzuSpecialdormCancelService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 特殊退宿申请Service业务层处理
 *
 * @author wsh
 * @date 2023-02-09
 */
@Service
@Transactional
public class FzuSpecialdormCancelServiceImpl implements IFzuSpecialdormCancelService
{
    @Autowired
    private FzuSpecialdormCancelMapper fzuSpecialdormCancelMapper;

    /**
     * 查询特殊退宿申请
     *
     * @param cancelId 特殊退宿申请主键
     * @return 特殊退宿申请
     */
    @Override
    public FzuSpecialdormCancel selectFzuSpecialdormCancelByCancelId(Long cancelId)
    {
        return fzuSpecialdormCancelMapper.selectFzuSpecialdormCancelByCancelId(cancelId);
    }

    /**
     * 查询特殊退宿申请列表
     *
     * @param fzuSpecialdormCancel 特殊退宿申请
     * @return 特殊退宿申请
     */
    @Override
    public List<FzuSpecialdormCancel> selectFzuSpecialdormCancelList(FzuSpecialdormCancel fzuSpecialdormCancel)
    {
        return fzuSpecialdormCancelMapper.selectFzuSpecialdormCancelList(fzuSpecialdormCancel);
    }

    /**
     * 新增特殊退宿申请
     *
     * @param fzuSpecialdormCancel 特殊退宿申请
     * @return 结果
     */
    @Override
    public int insertFzuSpecialdormCancel(FzuSpecialdormCancel fzuSpecialdormCancel)
    {
        return fzuSpecialdormCancelMapper.insertFzuSpecialdormCancel(fzuSpecialdormCancel);
    }

    /**
     * 修改特殊退宿申请
     *
     * @param fzuSpecialdormCancel 特殊退宿申请
     * @return 结果
     */
    @Override
    public int updateFzuSpecialdormCancel(FzuSpecialdormCancel fzuSpecialdormCancel)
    {
        return fzuSpecialdormCancelMapper.updateFzuSpecialdormCancel(fzuSpecialdormCancel);
    }

    /**
     * 批量删除特殊退宿申请
     *
     * @param cancelIds 需要删除的特殊退宿申请主键
     * @return 结果
     */
    @Override
    public int deleteFzuSpecialdormCancelByCancelIds(Long[] cancelIds)
    {
        return fzuSpecialdormCancelMapper.deleteFzuSpecialdormCancelByCancelIds(cancelIds);
    }

    /**
     * 删除特殊退宿申请信息
     *
     * @param cancelId 特殊退宿申请主键
     * @return 结果
     */
    @Override
    public int deleteFzuSpecialdormCancelByCancelId(Long cancelId)
    {
        return fzuSpecialdormCancelMapper.deleteFzuSpecialdormCancelByCancelId(cancelId);
    }

    /**
     * 查询角色userId列表
     *
     * @param sysUser
     * @return 结果
     */

    @Override
    public List<SysUser> selectUserListByRoleId(SysUser sysUser) {
        return fzuSpecialdormCancelMapper.selectUserListByRoleId(sysUser);
    }

    /**
     * 查询studentId获取dormId
     *
     * @return 结果
     */
    @Override
    public List<FzuDormitoryInfo> selectDormIdByStudentId(Long userId, List<String> dormStatus){
        return fzuSpecialdormCancelMapper.selectDormIdByStudentId(userId, dormStatus);
    }

    @Transactional
    @Override
    public int removeAndUpdateStuDorm(FzuDormitoryInfo fzuDormitoryInfo) {
        int i = fzuSpecialdormCancelMapper.deleteFzuSpecialStuDormitoryByDormId(fzuDormitoryInfo.getDormId());

        if(i > 0) {
            Map<String, Object> params = new HashMap<>();
            params.put("dormId", fzuDormitoryInfo.getDormId());
            params.put("dormStatus", fzuDormitoryInfo.getDormStatus());
            fzuSpecialdormCancelMapper.updateBedStatus(params);
            Map<String, Object> dormInfo = fzuSpecialdormCancelMapper.getDormInfo(params);
            params.put("buildingNo", dormInfo.get("building_no"));
            params.put("roomNo", dormInfo.get("room_no"));
            int bedCount = fzuSpecialdormCancelMapper.getBedCount(params);
            System.out.println(bedCount);
            System.out.println(fzuDormitoryInfo.getDormStatus());
            if(bedCount == 4 && (fzuDormitoryInfo.getDormStatus().equals("1") || fzuDormitoryInfo.getDormStatus().equals("3") || fzuDormitoryInfo.getDormStatus().equals("5"))) {
                fzuSpecialdormCancelMapper.updateDormStatus(params);
            }
        }
        return i;
    }



//    /**
//     * 通过dormId删除学生与特殊宿舍绑定记录并更新宿舍状态
//     *
//     * @param fzuDormitoryInfo
//     * @return 结果
//     */
//    @Override
//    public int removeAndUpdateStuDorm(FzuDormitoryInfo fzuDormitoryInfo) {
//        int i = fzuSpecialdormCancelMapper.deleteFzuSpecialStuDormitoryByDormId(fzuDormitoryInfo.getDormId());
//        if(i>0){
//            if("1".equals(fzuDormitoryInfo.getDormStatus())){
//                fzuSpecialdormCancelMapper.changDeleteDormStatus1(fzuDormitoryInfo.getDormId());
//            } else if ("3".equals(fzuDormitoryInfo.getDormStatus())) {
//                fzuSpecialdormCancelMapper.changDeleteDormStatus3(fzuDormitoryInfo.getDormId());
//            } else if ("5".equals(fzuDormitoryInfo.getDormStatus())) {
//                fzuSpecialdormCancelMapper.changDeleteDormStatus5(fzuDormitoryInfo.getDormId());
//            }
//            return i;
//        }else{
//            return 0;
//        }
//    }

    @Override
    public boolean hasPendingApplication(Long dormId) {
        int count = fzuSpecialdormCancelMapper.findPendingApplicationByDormId(dormId);
        return count > 0;
    }

}
