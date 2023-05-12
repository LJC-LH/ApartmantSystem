package com.ruoyi.apartment.service.Impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.mapper.FzuSysUserMapper;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.FzuSpecialdormApprovalMapper;
import com.ruoyi.apartment.domain.entity.FzuSpecialdormApproval;
import com.ruoyi.apartment.service.IFzuSpecialdormApprovalService;

/**
 * 特殊宿舍申请Service业务层处理
 *
 * @author wsh
 * @date 2023-02-08
 */
@Service
public class FzuSpecialdormApprovalServiceImpl implements IFzuSpecialdormApprovalService
{
    @Autowired
    private FzuSpecialdormApprovalMapper fzuSpecialdormApprovalMapper;

    private FzuSysUserMapper fzuSysUserMapper;


    /**
     * 查询特殊宿舍申请
     *
     * @param approvalId 特殊宿舍申请主键
     * @return 特殊宿舍申请
     */
    @Override
    public FzuSpecialdormApproval selectFzuSpecialdormApprovalByApprovalId(Long approvalId)
    {
        return fzuSpecialdormApprovalMapper.selectFzuSpecialdormApprovalByApprovalId(approvalId);
    }

    /**
     * 查询特殊宿舍申请列表
     *
     * @param fzuSpecialdormApproval 特殊宿舍申请
     * @return 特殊宿舍申请
     */
    @Override
    public List<FzuSpecialdormApproval> selectFzuSpecialdormApprovalList(FzuSpecialdormApproval fzuSpecialdormApproval)
    {
        return fzuSpecialdormApprovalMapper.selectFzuSpecialdormApprovalList(fzuSpecialdormApproval);
    }

    /**
     * 新增特殊宿舍申请
     *
     * @param fzuSpecialdormApproval 特殊宿舍申请
     * @return 结果
     */
    @Override
    public int insertFzuSpecialdormApproval(FzuSpecialdormApproval fzuSpecialdormApproval)
    {
        return fzuSpecialdormApprovalMapper.insertFzuSpecialdormApproval(fzuSpecialdormApproval);
    }

    /**
     * 修改特殊宿舍申请
     *
     * @param fzuSpecialdormApproval 特殊宿舍申请
     * @return 结果
     */
    @Override
    public int updateFzuSpecialdormApproval(FzuSpecialdormApproval fzuSpecialdormApproval)
    {
        return fzuSpecialdormApprovalMapper.updateFzuSpecialdormApproval(fzuSpecialdormApproval);
    }

    /**
     * 批量删除特殊宿舍申请
     *
     * @param approvalIds 需要删除的特殊宿舍申请主键
     * @return 结果
     */
    @Override
    public int deleteFzuSpecialdormApprovalByApprovalIds(Long[] approvalIds)
    {
        return fzuSpecialdormApprovalMapper.deleteFzuSpecialdormApprovalByApprovalIds(approvalIds);
    }

    /**
     * 删除特殊宿舍申请信息
     *
     * @param approvalId 特殊宿舍申请主键
     * @return 结果
     */
    @Override
    public int deleteFzuSpecialdormApprovalByApprovalId(Long approvalId)
    {
        return fzuSpecialdormApprovalMapper.deleteFzuSpecialdormApprovalByApprovalId(approvalId);
    }

    /**
     * 查询角色userId列表
     *
     * @param sysUser
     * @return 结果
     */

    @Override
    public List<SysUser> selectUserListByRoleId(SysUser sysUser) {
        return fzuSpecialdormApprovalMapper.selectUserListByRoleId(sysUser);
    }

    @Override
    public Integer insertFzuStudentDormitory(FzuDormitoryInfo fzuDormitoryInfo) {
        if(fzuSpecialdormApprovalMapper.selectFzuStuDormitoryByDormId(fzuDormitoryInfo.getDormId()) == 0) {
            fzuDormitoryInfo.setCreateTime(DateUtils.getNowDate());
            return fzuSpecialdormApprovalMapper.insertFzuStudentDormitory(fzuDormitoryInfo);
        }else{
            return 0;
        }
    }

    /**
     * 查询用户信息
     *
     * @param userId 用户信息主键
     * @return 用户信息
     */
    @Override
    public SysUser selectSysUserByUserId(Long userId)
    {
        return fzuSpecialdormApprovalMapper.selectSysUserByUserId(userId);
    }

    @Override
    public void changAddDormStatus2(Long dormId) {

        fzuSpecialdormApprovalMapper.changeAddBedStatus(dormId);
        List<Long> dormIdList = fzuSpecialdormApprovalMapper.getDormIdList(dormId);
        for (Long aLong : dormIdList) {
            fzuSpecialdormApprovalMapper.changeDormStatus2(aLong);
        }
    };

    @Override
    public void changAddDormStatus4(Long dormId) {

        fzuSpecialdormApprovalMapper.changeAddBedStatus(dormId);
        List<Long> dormIdList = fzuSpecialdormApprovalMapper.getDormIdList(dormId);
        for (Long aLong : dormIdList) {
            fzuSpecialdormApprovalMapper.changeDormStatus4(aLong);
        }
    };

    @Override
    public void changAddDormStatus6(Long dormId) {

        fzuSpecialdormApprovalMapper.changeAddBedStatus(dormId);
        List<Long> dormIdList = fzuSpecialdormApprovalMapper.getDormIdList(dormId);
        for (Long aLong : dormIdList) {
            fzuSpecialdormApprovalMapper.changeDormStatus6(aLong);
        }
    };
}
