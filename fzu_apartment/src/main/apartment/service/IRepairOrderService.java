package com.ruoyi.apartment.service;

import java.util.List;

import com.ruoyi.apartment.domain.FzuCompleteOrders;
import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.RepairOrder;

/**
 * 学生报修Service接口
 * 
 * @author ljc
 * @date 2023-04-23
 */
public interface IRepairOrderService 
{
    /**
     * 查询学生报修
     * 
     * @param repairId 学生报修主键
     * @return 学生报修
     */
    public RepairOrder selectRepairOrderByRepairId(Long repairId);

    /**
     * 查询学生报修列表
     * 
     * @param repairOrder 学生报修
     * @return 学生报修集合
     */
    public List<RepairOrder> selectRepairOrderList(RepairOrder repairOrder);

    /**
     * 新增学生报修
     *
     * @return 结果
     */
    public int insertRepairOrder(FzuCompleteOrders fzuCompleteOrders);

    /**
     * 修改学生报修
     * 
     * @param repairOrder 学生报修
     * @return 结果
     */
    public int updateRepairOrder(RepairOrder repairOrder);

    /**
     * 批量删除学生报修
     * 
     * @param repairIds 需要删除的学生报修主键集合
     * @return 结果
     */
    public int deleteRepairOrderByRepairIds(Long[] repairIds);

    /**
     * 删除学生报修信息
     * 
     * @param repairId 学生报修主键
     * @return 结果
     */
    public int deleteRepairOrderByRepairId(Long repairId);

    public RepairOrder selectInfo(Long studentId);
}
