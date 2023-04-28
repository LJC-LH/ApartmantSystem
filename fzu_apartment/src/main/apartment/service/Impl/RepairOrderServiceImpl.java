package com.ruoyi.apartment.service.Impl;

import java.util.List;

import com.ruoyi.apartment.domain.FzuCompleteOrders;
import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.RepairOrderMapper;
import com.ruoyi.apartment.domain.RepairOrder;
import com.ruoyi.apartment.service.IRepairOrderService;

/**
 * 学生报修Service业务层处理
 * 
 * @author ljc
 * @date 2023-04-23
 */
@Service
public class RepairOrderServiceImpl implements IRepairOrderService 
{
    @Autowired
    private RepairOrderMapper repairOrderMapper;

    /**
     * 查询学生报修
     * 
     * @param repairId 学生报修主键
     * @return 学生报修
     */
    @Override
    public RepairOrder selectRepairOrderByRepairId(Long repairId)
    {
        return repairOrderMapper.selectRepairOrderByRepairId(repairId);
    }

    /**
     * 查询学生报修列表
     * 
     * @param repairOrder 学生报修
     * @return 学生报修
     */
    @Override
    public List<RepairOrder> selectRepairOrderList(RepairOrder repairOrder)
    {
        return repairOrderMapper.selectRepairOrderList(repairOrder);
    }

    /**
     * 新增学生报修
     * 
     * @param repairOrder 学生报修
     * @return 结果
     */
    @Override
    public int insertRepairOrder(FzuCompleteOrders fzuCompleteOrders)
    {
        return repairOrderMapper.insertRepairOrder(fzuCompleteOrders);
    }

    /**
     * 修改学生报修
     * 
     * @param repairOrder 学生报修
     * @return 结果
     */
    @Override
    public int updateRepairOrder(RepairOrder repairOrder)
    {
        return repairOrderMapper.updateRepairOrder(repairOrder);
    }

    /**
     * 批量删除学生报修
     * 
     * @param repairIds 需要删除的学生报修主键
     * @return 结果
     */
    @Override
    public int deleteRepairOrderByRepairIds(Long[] repairIds)
    {
        return repairOrderMapper.deleteRepairOrderByRepairIds(repairIds);
    }

    /**
     * 删除学生报修信息
     * 
     * @param repairId 学生报修主键
     * @return 结果
     */
    @Override
    public int deleteRepairOrderByRepairId(Long repairId)
    {
        return repairOrderMapper.deleteRepairOrderByRepairId(repairId);
    }

    @Override
    public RepairOrder selectInfo(Long studentId){
        return repairOrderMapper.selectInfo(studentId);
    }
}
