package com.ruoyi.apartment.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.RepairResultMapper;
import com.ruoyi.apartment.domain.RepairResult;
import com.ruoyi.apartment.service.IRepairResultService;

/**
 * 维修结果提交Service业务层处理
 * 
 * @author ljc
 * @date 2023-04-24
 */
@Service
public class RepairResultServiceImpl implements IRepairResultService 
{
    @Autowired
    private RepairResultMapper repairResultMapper;

    /**
     * 查询维修结果提交
     * 
     * @param repairId 维修结果提交主键
     * @return 维修结果提交
     */
    @Override
    public RepairResult selectRepairResultByRepairId(Long repairId)
    {
        return repairResultMapper.selectRepairResultByRepairId(repairId);
    }

    /**
     * 查询维修结果提交列表
     * 
     * @param repairResult 维修结果提交
     * @return 维修结果提交
     */
    @Override
    public List<RepairResult> selectRepairResultList(RepairResult repairResult)
    {
        return repairResultMapper.selectRepairResultList(repairResult);
    }

    /**
     * 新增维修结果提交
     * 
     * @param repairResult 维修结果提交
     * @return 结果
     */
    @Override
    public int insertRepairResult(RepairResult repairResult)
    {
        return repairResultMapper.insertRepairResult(repairResult);
    }

    /**
     * 修改维修结果提交
     * 
     * @param repairResult 维修结果提交
     * @return 结果
     */
    @Override
    public int updateRepairResult(RepairResult repairResult)
    {
        return repairResultMapper.updateRepairResult(repairResult);
    }

    /**
     * 批量删除维修结果提交
     * 
     * @param repairIds 需要删除的维修结果提交主键
     * @return 结果
     */
    @Override
    public int deleteRepairResultByRepairIds(Long[] repairIds)
    {
        return repairResultMapper.deleteRepairResultByRepairIds(repairIds);
    }

    /**
     * 删除维修结果提交信息
     * 
     * @param repairId 维修结果提交主键
     * @return 结果
     */
    @Override
    public int deleteRepairResultByRepairId(Long repairId)
    {
        return repairResultMapper.deleteRepairResultByRepairId(repairId);
    }
}
