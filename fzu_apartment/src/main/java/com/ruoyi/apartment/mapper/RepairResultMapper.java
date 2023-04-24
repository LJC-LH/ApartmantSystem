package com.ruoyi.apartment.mapper;

import java.util.List;
import com.ruoyi.apartment.domain.RepairResult;

/**
 * 维修结果提交Mapper接口
 * 
 * @author ljc
 * @date 2023-04-24
 */
public interface RepairResultMapper 
{
    /**
     * 查询维修结果提交
     * 
     * @param repairId 维修结果提交主键
     * @return 维修结果提交
     */
    public RepairResult selectRepairResultByRepairId(Long repairId);

    /**
     * 查询维修结果提交列表
     * 
     * @param repairResult 维修结果提交
     * @return 维修结果提交集合
     */
    public List<RepairResult> selectRepairResultList(RepairResult repairResult);

    /**
     * 新增维修结果提交
     * 
     * @param repairResult 维修结果提交
     * @return 结果
     */
    public int insertRepairResult(RepairResult repairResult);

    /**
     * 修改维修结果提交
     * 
     * @param repairResult 维修结果提交
     * @return 结果
     */
    public int updateRepairResult(RepairResult repairResult);

    /**
     * 删除维修结果提交
     * 
     * @param repairId 维修结果提交主键
     * @return 结果
     */
    public int deleteRepairResultByRepairId(Long repairId);

    /**
     * 批量删除维修结果提交
     * 
     * @param repairIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepairResultByRepairIds(Long[] repairIds);
}
