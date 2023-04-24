package com.ruoyi.apartment.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.SecondSelectRepairmanMapper;
import com.ruoyi.apartment.domain.SecondSelectRepairman;
import com.ruoyi.apartment.service.ISecondSelectRepairmanService;

/**
 * 二次派单Service业务层处理
 * 
 * @author ljc
 * @date 2023-04-24
 */
@Service
public class SecondSelectRepairmanServiceImpl implements ISecondSelectRepairmanService 
{
    @Autowired
    private SecondSelectRepairmanMapper secondSelectRepairmanMapper;

    /**
     * 查询二次派单
     * 
     * @param repairId 二次派单主键
     * @return 二次派单
     */
    @Override
    public SecondSelectRepairman selectSecondSelectRepairmanByRepairId(Long repairId)
    {
        return secondSelectRepairmanMapper.selectSecondSelectRepairmanByRepairId(repairId);
    }

    /**
     * 查询二次派单列表
     * 
     * @param secondSelectRepairman 二次派单
     * @return 二次派单
     */
    @Override
    public List<SecondSelectRepairman> selectSecondSelectRepairmanList(SecondSelectRepairman secondSelectRepairman)
    {
        return secondSelectRepairmanMapper.selectSecondSelectRepairmanList(secondSelectRepairman);
    }

    /**
     * 新增二次派单
     * 
     * @param secondSelectRepairman 二次派单
     * @return 结果
     */
    @Override
    public int insertSecondSelectRepairman(SecondSelectRepairman secondSelectRepairman)
    {
        return secondSelectRepairmanMapper.insertSecondSelectRepairman(secondSelectRepairman);
    }

    /**
     * 修改二次派单
     * 
     * @param secondSelectRepairman 二次派单
     * @return 结果
     */
    @Override
    public int updateSecondSelectRepairman(SecondSelectRepairman secondSelectRepairman)
    {
        return secondSelectRepairmanMapper.updateSecondSelectRepairman(secondSelectRepairman);
    }

    /**
     * 批量删除二次派单
     * 
     * @param repairIds 需要删除的二次派单主键
     * @return 结果
     */
    @Override
    public int deleteSecondSelectRepairmanByRepairIds(Long[] repairIds)
    {
        return secondSelectRepairmanMapper.deleteSecondSelectRepairmanByRepairIds(repairIds);
    }

    /**
     * 删除二次派单信息
     * 
     * @param repairId 二次派单主键
     * @return 结果
     */
    @Override
    public int deleteSecondSelectRepairmanByRepairId(Long repairId)
    {
        return secondSelectRepairmanMapper.deleteSecondSelectRepairmanByRepairId(repairId);
    }
}
