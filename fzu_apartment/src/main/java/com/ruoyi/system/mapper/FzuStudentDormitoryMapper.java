package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.system.domain.FzuStudentDormitory;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
public interface FzuStudentDormitoryMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param studentId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FzuStudentDormitory selectFzuStudentDormitoryByStudentId(Long studentId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fzuStudentDormitory 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FzuStudentDormitory> selectFzuStudentDormitoryList(FzuStudentDormitory fzuStudentDormitory);

    /**
     * 新增【请填写功能名称】
     *
     * @return 结果
     */
    public int insertFzuStudentDormitory(FzuDormitoryInfo fzuDormitoryInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param fzuStudentDormitory 【请填写功能名称】
     * @return 结果
     */
    public int updateFzuStudentDormitory(FzuStudentDormitory fzuStudentDormitory);

    /**
     * 删除【请填写功能名称】
     * 
     * @param studentId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFzuStudentDormitoryByStudentId(Long studentId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param studentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFzuStudentDormitoryByStudentIds(Long[] studentIds);
}
