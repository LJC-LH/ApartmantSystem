package com.ruoyi.apartment.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.FirstSelectRepairmanMapper;
import com.ruoyi.apartment.domain.FirstSelectRepairman;
import com.ruoyi.apartment.service.IFirstSelectRepairmanService;

/**
 * 一次派单Service业务层处理
 * 
 * @author ljc
 * @date 2023-04-24
 */
@Service
public class FirstSelectRepairmanServiceImpl implements IFirstSelectRepairmanService 
{
    @Autowired
    private FirstSelectRepairmanMapper firstSelectRepairmanMapper;

    /**
     * 查询一次派单
     * 
     * @param repairId 一次派单主键
     * @return 一次派单
     */
    @Override
    public FirstSelectRepairman selectFirstSelectRepairmanByRepairId(Long repairId)
    {
        return firstSelectRepairmanMapper.selectFirstSelectRepairmanByRepairId(repairId);
    }

    /**
     * 查询一次派单列表
     * 
     * @param firstSelectRepairman 一次派单
     * @return 一次派单
     */
    @Override
    public List<FirstSelectRepairman> selectFirstSelectRepairmanList(FirstSelectRepairman firstSelectRepairman)
    {
        return firstSelectRepairmanMapper.selectFirstSelectRepairmanList(firstSelectRepairman);
    }

    /**
     * 新增一次派单
     * 
     * @param firstSelectRepairman 一次派单
     * @return 结果
     */
    @Override
    public int insertFirstSelectRepairman(FirstSelectRepairman firstSelectRepairman)
    {
        return firstSelectRepairmanMapper.insertFirstSelectRepairman(firstSelectRepairman);
    }

    /**
     * 修改一次派单
     * 
     * @param firstSelectRepairman 一次派单
     * @return 结果
     */
    @Override
    public int updateFirstSelectRepairman(FirstSelectRepairman firstSelectRepairman)
    {
        return firstSelectRepairmanMapper.updateFirstSelectRepairman(firstSelectRepairman);
    }

    /**
     * 批量删除一次派单
     * 
     * @param repairIds 需要删除的一次派单主键
     * @return 结果
     */
    @Override
    public int deleteFirstSelectRepairmanByRepairIds(Long[] repairIds)
    {
        return firstSelectRepairmanMapper.deleteFirstSelectRepairmanByRepairIds(repairIds);
    }

    /**
     * 删除一次派单信息
     * 
     * @param repairId 一次派单主键
     * @return 结果
     */
    @Override
    public int deleteFirstSelectRepairmanByRepairId(Long repairId)
    {
        return firstSelectRepairmanMapper.deleteFirstSelectRepairmanByRepairId(repairId);
    }
}
