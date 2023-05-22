package com.ruoyi.apartment.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.RepairExcelOutputMapper;
import com.ruoyi.apartment.domain.RepairExcelOutput;
import com.ruoyi.apartment.service.IRepairExcelOutputService;

/**
 * 维修明细Service业务层处理
 *
 * @author ljc
 * @date 2023-05-22
 */
@Service
public class RepairExcelOutputServiceImpl implements IRepairExcelOutputService
{
    @Autowired
    private RepairExcelOutputMapper repairExcelOutputMapper;

    /**
     * 查询维修明细
     *
     * @param repairId 维修明细主键
     * @return 维修明细
     */
    @Override
    public RepairExcelOutput selectRepairExcelOutputByRepairId(Long repairId)
    {
        return repairExcelOutputMapper.selectRepairExcelOutputByRepairId(repairId);
    }

    /**
     * 查询维修明细列表
     *
     * @param repairExcelOutput 维修明细
     * @return 维修明细
     */
    @Override
    public List<RepairExcelOutput> selectRepairExcelOutputList(RepairExcelOutput repairExcelOutput)
    {
        return repairExcelOutputMapper.selectRepairExcelOutputList(repairExcelOutput);
    }

    /**
     * 新增维修明细
     *
     * @param repairExcelOutput 维修明细
     * @return 结果
     */
    @Override
    public int insertRepairExcelOutput(RepairExcelOutput repairExcelOutput)
    {
        return repairExcelOutputMapper.insertRepairExcelOutput(repairExcelOutput);
    }

    /**
     * 修改维修明细
     *
     * @param repairExcelOutput 维修明细
     * @return 结果
     */
    @Override
    public int updateRepairExcelOutput(RepairExcelOutput repairExcelOutput)
    {
        return repairExcelOutputMapper.updateRepairExcelOutput(repairExcelOutput);
    }

    /**
     * 批量删除维修明细
     *
     * @param repairIds 需要删除的维修明细主键
     * @return 结果
     */
    @Override
    public int deleteRepairExcelOutputByRepairIds(Long[] repairIds)
    {
        return repairExcelOutputMapper.deleteRepairExcelOutputByRepairIds(repairIds);
    }

    /**
     * 删除维修明细信息
     *
     * @param repairId 维修明细主键
     * @return 结果
     */
    @Override
    public int deleteRepairExcelOutputByRepairId(Long repairId)
    {
        return repairExcelOutputMapper.deleteRepairExcelOutputByRepairId(repairId);
    }
}
