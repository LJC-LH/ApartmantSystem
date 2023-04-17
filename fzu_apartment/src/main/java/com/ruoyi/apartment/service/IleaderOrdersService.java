package com.ruoyi.apartment.service;

import java.util.List;

import com.ruoyi.apartment.domain.FzuCompleteOrders;
import com.ruoyi.apartment.domain.leaderOrders;
import org.apache.commons.beanutils.BeanUtils;

/**
 * 领导订单表Service接口
 * 
 * @author ruoyi
 * @date 2023-04-05
 */
public interface IleaderOrdersService 
{
    /**
     * 查询领导订单表
     * 
     * @param id 领导订单表主键
     * @return 领导订单表
     */
    public FzuCompleteOrders selectleaderOrdersById(Long id);

    /**
     * 查询领导订单表列表
     * 
     * @param leaderOrders 领导订单表
     * @return 领导订单表集合
     */
    public List<FzuCompleteOrders> selectleaderOrdersList(leaderOrders leaderOrders);

    /**
     * 新增领导订单表
     * 
     * @param leaderOrders 领导订单表
     * @return 结果
     */
    public int insertleaderOrders(leaderOrders leaderOrders);

    /**
     * 修改领导订单表
     * 
     * @param leaderOrders 领导订单表
     * @return 结果
     */
    public int updateleaderOrders(leaderOrders leaderOrders);

    /**
     * 批量删除领导订单表
     * 
     * @param ids 需要删除的领导订单表主键集合
     * @return 结果
     */
    public int deleteleaderOrdersByIds(Long[] ids);

    /**
     * 删除领导订单表信息
     * 
     * @param id 领导订单表主键
     * @return 结果
     */
    public int deleteleaderOrdersById(Long id);

}
