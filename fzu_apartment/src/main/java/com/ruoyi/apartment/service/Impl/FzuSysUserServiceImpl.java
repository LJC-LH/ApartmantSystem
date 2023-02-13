package com.ruoyi.apartment.service.Impl;

import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.FzuUserRoot;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.FzuSysUserMapper;
import com.ruoyi.apartment.domain.FzuSysUser;
import com.ruoyi.apartment.service.IFzuSysUserService;

/**
 * 用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-05
 */
@Service
public class FzuSysUserServiceImpl implements IFzuSysUserService 
{
    @Autowired
    private FzuSysUserMapper fzuSysUserMapper;

    /**
     * 查询用户信息
     * 
     * @param userId 用户信息主键
     * @return 用户信息
     */
    @Override
    public FzuSysUser selectFzuSysUserByUserId(Long userId)
    {
        return fzuSysUserMapper.selectFzuSysUserByUserId(userId);
    }

    /**
     * 查询用户信息列表
     * 
     * @param fzuSysUser 用户信息
     * @return 用户信息
     */
    @Override
    public List<FzuDormitoryInfo> selectFzuSysUserList(FzuDormitoryInfo fzuSysUser)
    {
        return fzuSysUserMapper.selectFzuSysUserList(fzuSysUser);
    }

    /**
     * 新增用户信息
     * 
     * @param fzuSysUser 用户信息
     * @return 结果
     */
    @Override
    public int insertFzuSysUser(FzuDormitoryInfo fzuSysUser)
    {
//        fzuSysUser.setCreateTime(DateUtils.getNowDate());
        return fzuSysUserMapper.insertFzuSysUser(fzuSysUser);
    }

    /**
     * 修改用户信息
     *
     * @return 结果
     */
    @Override
    public int updateFzuSysUser(FzuDormitoryInfo fzuDormitoryInfo)
    {
        fzuDormitoryInfo.setUpdateTime(DateUtils.getNowDate());
        return fzuSysUserMapper.updateFzuSysUser(fzuDormitoryInfo);
    }

    /**
     * 批量删除用户信息
     * 
     * @param userIds 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteFzuSysUserByUserIds(Long[] userIds)
    {
        return fzuSysUserMapper.deleteFzuSysUserByUserIds(userIds);
    }

    /**
     * 删除用户信息信息
     * 
     * @param userId 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteFzuSysUserByUserId(Long userId)
    {
        return fzuSysUserMapper.deleteFzuSysUserByUserId(userId);
    }

    @Override
    public FzuUserRoot getRoot(String username) {
        return fzuSysUserMapper.getRoot(username);
    }
}
