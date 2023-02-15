package com.ruoyi.apartment.service.Impl;

import java.util.List;

import com.ruoyi.apartment.domain.entity.FzuSpecialdormCancel;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.FzuSpecialdormCancelMapper;
import com.ruoyi.apartment.service.IFzuSpecialdormCancelService;

/**
 * 特殊退宿申请Service业务层处理
 *
 * @author wsh
 * @date 2023-02-09
 */
@Service
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
}
