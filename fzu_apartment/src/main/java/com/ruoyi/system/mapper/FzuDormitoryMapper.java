package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FzuDormitory;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface FzuDormitoryMapper 
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
     * @param fzuDormitory 【请填写功能名称】
     * @return 结果
     */
    public int insertFzuDormitory(FzuDormitory fzuDormitory);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fzuDormitory 【请填写功能名称】
     * @return 结果
     */
    public int updateFzuDormitory(FzuDormitory fzuDormitory);

    /**
     * 删除【请填写功能名称】
     * 
     * @param dormId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFzuDormitoryByDormId(Long dormId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param dormIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFzuDormitoryByDormIds(Long[] dormIds);
}
