package com.ruoyi.apartment.service.Impl;

import java.util.List;

import com.ruoyi.apartment.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.leaderOrdersMapper;
import com.ruoyi.apartment.service.IleaderOrdersService;

/**
 * 领导订单表Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-05
 */
@Service
public class leaderOrdersServiceImpl implements IleaderOrdersService 
{
    @Autowired
    private leaderOrdersMapper leaderOrdersMapper;


    /**
     * 查询领导订单表
     * 
     * @param id 领导订单表主键
     * @return 领导订单表
     */
    @Override
    public FzuCompleteOrders selectleaderOrdersById(Long id)
    {


        return leaderOrdersMapper.selectleaderOrdersById(id);
    }

    /**
     * 查询领导订单表列表
     * 
     * @param leaderOrders 领导订单表
     * @return 领导订单表
     */
    @Override
    public List<FzuCompleteOrders> selectleaderOrdersList(leaderOrders leaderOrders)
    {
        return leaderOrdersMapper.selectleaderOrdersList(leaderOrders);
    }

    /**
     * 新增领导订单表
     * 
     * @param leaderOrders 领导订单表
     * @return 结果
     */
    @Override
    public int insertleaderOrders(leaderOrders leaderOrders)
    {
        return leaderOrdersMapper.insertleaderOrders(leaderOrders);
    }

    /**
     * 修改领导订单表
     * 
     * @param leaderOrders 领导订单表
     * @return 结果
     */
    @Override
    public int updateleaderOrders(leaderOrders leaderOrders)
    {
        return leaderOrdersMapper.updateleaderOrders(leaderOrders);
    }

    /**
     * 批量删除领导订单表
     * 
     * @param ids 需要删除的领导订单表主键
     * @return 结果
     */
    @Override
    public int deleteleaderOrdersByIds(Long[] ids)
    {
        return leaderOrdersMapper.deleteleaderOrdersByIds(ids);
    }

    /**
     * 删除领导订单表信息
     * 
     * @param id 领导订单表主键
     * @return 结果
     */
    @Override
    public int deleteleaderOrdersById(Long id)
    {
        return leaderOrdersMapper.deleteleaderOrdersById(id);
    }
}
