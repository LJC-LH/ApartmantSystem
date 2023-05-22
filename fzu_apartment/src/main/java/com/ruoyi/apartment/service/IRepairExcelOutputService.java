package com.ruoyi.apartment.service;

import java.util.List;
import com.ruoyi.apartment.domain.RepairExcelOutput;

/**
 * 维修明细Service接口
 * 
 * @author ljc
 * @date 2023-05-22
 */
public interface IRepairExcelOutputService 
{
    /**
     * 查询维修明细
     * 
     * @param repairId 维修明细主键
     * @return 维修明细
     */
    public RepairExcelOutput selectRepairExcelOutputByRepairId(Long repairId);

    /**
     * 查询维修明细列表
     * 
     * @param repairExcelOutput 维修明细
     * @return 维修明细集合
     */
    public List<RepairExcelOutput> selectRepairExcelOutputList(RepairExcelOutput repairExcelOutput);

    /**
     * 新增维修明细
     * 
     * @param repairExcelOutput 维修明细
     * @return 结果
     */
    public int insertRepairExcelOutput(RepairExcelOutput repairExcelOutput);

    /**
     * 修改维修明细
     * 
     * @param repairExcelOutput 维修明细
     * @return 结果
     */
    public int updateRepairExcelOutput(RepairExcelOutput repairExcelOutput);

    /**
     * 批量删除维修明细
     * 
     * @param repairIds 需要删除的维修明细主键集合
     * @return 结果
     */
    public int deleteRepairExcelOutputByRepairIds(Long[] repairIds);

    /**
     * 删除维修明细信息
     * 
     * @param repairId 维修明细主键
     * @return 结果
     */
    public int deleteRepairExcelOutputByRepairId(Long repairId);
}
