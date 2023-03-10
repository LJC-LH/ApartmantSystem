package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FzuDormitoryMapper;
import com.ruoyi.system.domain.FzuDormitory;
import com.ruoyi.system.service.IFzuDormitoryService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@Service
public class FzuDormitoryServiceImpl implements IFzuDormitoryService 
{
    @Autowired
    private FzuDormitoryMapper fzuDormitoryMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param dormId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FzuDormitory selectFzuDormitoryByDormId(Long dormId)
    {
        return fzuDormitoryMapper.selectFzuDormitoryByDormId(dormId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param fzuDormitory 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FzuDormitory> selectFzuDormitoryList(FzuDormitory fzuDormitory)
    {
        return fzuDormitoryMapper.selectFzuDormitoryList(fzuDormitory);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @return 结果
     */
    @Override
    public int insertFzuDormitory(FzuDormitoryInfo fzuDormitoryInfo)
    {
        return fzuDormitoryMapper.insertFzuDormitory(fzuDormitoryInfo);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @return 结果
     */
    @Override
    public int updateFzuDormitory(FzuDormitoryInfo fzuDormitoryInfo)
    {
        return fzuDormitoryMapper.updateFzuDormitory(fzuDormitoryInfo);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param dormIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFzuDormitoryByDormIds(Long[] dormIds)
    {
        return fzuDormitoryMapper.deleteFzuDormitoryByDormIds(dormIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param dormId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFzuDormitoryByDormId(Long dormId)
    {
        return fzuDormitoryMapper.deleteFzuDormitoryByDormId(dormId);
    }
}
