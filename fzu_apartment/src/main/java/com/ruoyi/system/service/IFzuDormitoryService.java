package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.system.domain.FzuDormitory;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface IFzuDormitoryService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param dormId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FzuDormitory selectFzuDormitoryByDormId(Long dormId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fzuDormitory 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FzuDormitory> selectFzuDormitoryList(FzuDormitory fzuDormitory);

    /**
     * 新增【请填写功能名称】
     * 
     *  【请填写功能名称】
     * @return 结果
     */
    public int insertFzuDormitory(FzuDormitoryInfo fzuDormitoryInfo);

    /**
     * 修改【请填写功能名称】
     *
     * @return 结果
     */
    public int updateFzuDormitory(FzuDormitoryInfo fzuDormitoryInfo);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param dormIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteFzuDormitoryByDormIds(Long[] dormIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param dormId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFzuDormitoryByDormId(Long dormId);
}
