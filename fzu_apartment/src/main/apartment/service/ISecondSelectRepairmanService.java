package com.ruoyi.apartment.service;

import java.util.List;
import com.ruoyi.apartment.domain.SecondSelectRepairman;

/**
 * 二次派单Service接口
 * 
 * @author ljc
 * @date 2023-04-24
 */
public interface ISecondSelectRepairmanService 
{
    /**
     * 查询二次派单
     * 
     * @param repairId 二次派单主键
     * @return 二次派单
     */
    public SecondSelectRepairman selectSecondSelectRepairmanByRepairId(Long repairId);

    /**
     * 查询二次派单列表
     * 
     * @param secondSelectRepairman 二次派单
     * @return 二次派单集合
     */
    public List<SecondSelectRepairman> selectSecondSelectRepairmanList(SecondSelectRepairman secondSelectRepairman);

    /**
     * 新增二次派单
     * 
     * @param secondSelectRepairman 二次派单
     * @return 结果
     */
    public int insertSecondSelectRepairman(SecondSelectRepairman secondSelectRepairman);

    /**
     * 修改二次派单
     * 
     * @param secondSelectRepairman 二次派单
     * @return 结果
     */
    public int updateSecondSelectRepairman(SecondSelectRepairman secondSelectRepairman);

    /**
     * 批量删除二次派单
     * 
     * @param repairIds 需要删除的二次派单主键集合
     * @return 结果
     */
    public int deleteSecondSelectRepairmanByRepairIds(Long[] repairIds);

    /**
     * 删除二次派单信息
     * 
     * @param repairId 二次派单主键
     * @return 结果
     */
    public int deleteSecondSelectRepairmanByRepairId(Long repairId);
}
