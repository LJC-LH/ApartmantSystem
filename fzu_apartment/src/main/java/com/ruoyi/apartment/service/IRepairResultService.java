package com.ruoyi.apartment.service;

import java.util.List;

import com.ruoyi.apartment.domain.FzuCompleteOrders;
import com.ruoyi.apartment.domain.RepairResult;

/**
 * 维修结果提交Service接口
 * 
 * @author ljc
 * @date 2023-04-24
 */
public interface IRepairResultService 
{
    /**
     * 查询维修结果提交
     * 
     * @param repairId 维修结果提交主键
     * @return 维修结果提交
     */
    public FzuCompleteOrders selectRepairResultByRepairId(Long repairId);

    /**
     * 查询维修结果提交列表
     * 
     * @param repairResult 维修结果提交
     * @return 维修结果提交集合
     */
    public List<FzuCompleteOrders> selectRepairResultList(RepairResult repairResult);

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
     * 批量删除维修结果提交
     * 
     * @param repairIds 需要删除的维修结果提交主键集合
     * @return 结果
     */
    public int deleteRepairResultByRepairIds(Long[] repairIds);

    /**
     * 删除维修结果提交信息
     * 
     * @param repairId 维修结果提交主键
     * @return 结果
     */
    public int deleteRepairResultByRepairId(Long repairId);

    /*
    * 定义了不同的两种新增和修改语句，总共是三个
    * */

    public int changeFirstOrder(FzuCompleteOrders fzuCompleteOrders);

    public int changeSecondOrder(FzuCompleteOrders fzuCompleteOrders);

    public int changeUnsolvableOrder(FzuCompleteOrders fzuCompleteOrders);
}
