package com.ruoyi.apartment.mapper;

import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.FzuSysUser;
import com.ruoyi.apartment.domain.FzuUserRoot;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-05
 */
public interface FzuSysUserMapper 
{
    /**
     * 查询用户信息
     *
     * @return 用户信息
     */
    public FzuDormitoryInfo selectFzuSysUserByUserId(FzuDormitoryInfo fzuDormitoryInfo);

    /**
     * 查询用户信息列表
     * 
     * @param fzuSysUser 用户信息
     * @return 用户信息集合
     */
    public List<FzuDormitoryInfo> selectFzuSysUserList(FzuDormitoryInfo fzuSysUser);

    public List<FzuDormitoryInfo> selectFzuFdyUserList(FzuDormitoryInfo fzuSysUser);

    /**
     * 新增用户信息
     *
     * @return 结果
     */
    public int insertFzuSysUser(FzuDormitoryInfo fzuDormitoryInfo);

    /**
     * 修改用户信息
     *
     * @return 结果
     */
    public int updateFzuSysUser(FzuDormitoryInfo fzuDormitoryInfo);

    /**
     * 删除用户信息
     * 
     * @param userId 用户信息主键
     * @return 结果
     */
    public int deleteFzuSysUserByUserId(Long userId);

    /**
     * 批量删除用户信息
     *
     * @return 结果
     */
    public int deleteFzuSysUserByUserIds(FzuDormitoryInfo fzuDormitoryInfo);

    public FzuUserRoot getRoot(String username);

    public int updateFzuDormitory(FzuDormitoryInfo fzuDormitoryInfo);

    public int updateFzuStudentDormitory(FzuDormitoryInfo fzuDormitoryInfo);

    public int insertFzuDormitory(FzuDormitoryInfo fzuDormitoryInfo);

    public int insertFzuStudentDormitory(FzuDormitoryInfo fzuDormitoryInfo);

    public Long getRolesDeptId(String username);

    public Long selectUserIdByUserName(FzuDormitoryInfo fzuDormitoryInfo);

    public Long selectDormIdByRoomInfo(FzuDormitoryInfo fzuDormitoryInfo);

    public FzuDormitoryInfo selectOne(FzuDormitoryInfo fzuDormitoryInfo);

    public void changAddDormStatus(Long dormId);

    public void changDeleteDormStatus(Long dormId);

    public Long getDormIdByUserId(Long userId);

    public List<Long> getDormIdList(Long dormId);

    public int changeDormStatusONE(Long dormId);
}
