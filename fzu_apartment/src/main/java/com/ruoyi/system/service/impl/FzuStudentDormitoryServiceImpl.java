package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FzuStudentDormitoryMapper;
import com.ruoyi.system.domain.FzuStudentDormitory;
import com.ruoyi.system.service.IFzuStudentDormitoryService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class FzuStudentDormitoryServiceImpl implements IFzuStudentDormitoryService 
{
    @Autowired
    private FzuStudentDormitoryMapper fzuStudentDormitoryMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param studentId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FzuStudentDormitory selectFzuStudentDormitoryByStudentId(Long studentId)
    {
        return fzuStudentDormitoryMapper.selectFzuStudentDormitoryByStudentId(studentId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fzuStudentDormitory 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FzuStudentDormitory> selectFzuStudentDormitoryList(FzuStudentDormitory fzuStudentDormitory)
    {
        return fzuStudentDormitoryMapper.selectFzuStudentDormitoryList(fzuStudentDormitory);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param fzuStudentDormitory 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFzuStudentDormitory(FzuStudentDormitory fzuStudentDormitory)
    {
        return fzuStudentDormitoryMapper.insertFzuStudentDormitory(fzuStudentDormitory);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param fzuStudentDormitory 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFzuStudentDormitory(FzuStudentDormitory fzuStudentDormitory)
    {
        return fzuStudentDormitoryMapper.updateFzuStudentDormitory(fzuStudentDormitory);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param studentIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFzuStudentDormitoryByStudentIds(Long[] studentIds)
    {
        return fzuStudentDormitoryMapper.deleteFzuStudentDormitoryByStudentIds(studentIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param studentId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFzuStudentDormitoryByStudentId(Long studentId)
    {
        return fzuStudentDormitoryMapper.deleteFzuStudentDormitoryByStudentId(studentId);
    }
}
