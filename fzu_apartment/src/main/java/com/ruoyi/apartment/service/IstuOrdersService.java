package com.ruoyi.apartment.service;

import java.util.List;
import com.ruoyi.apartment.domain.stuOrders;

/**
 * 学生订单Service接口
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
public interface IstuOrdersService 
{
    /**
     * 查询学生订单
     * 
     * @param id 学生订单主键
     * @return 学生订单
     */
    public stuOrders selectstuOrdersById(Long id);

    /**
     * 查询学生订单列表
     * 
     * @param stuOrders 学生订单
     * @return 学生订单集合
     */
    public List<stuOrders> selectstuOrdersList(stuOrders stuOrders);

    /**
     * 新增学生订单
     * 
     * @param stuOrders 学生订单
     * @return 结果
     */
    public int insertstuOrders(stuOrders stuOrders);

    /**
     * 修改学生订单
     * 
     * @param stuOrders 学生订单
     * @return 结果
     */
    public int updatestuOrders(stuOrders stuOrders);

    /**
     * 批量删除学生订单
     * 
     * @param ids 需要删除的学生订单主键集合
     * @return 结果
     */
    public int deletestuOrdersByIds(Long[] ids);

    /**
     * 删除学生订单信息
     * 
     * @param id 学生订单主键
     * @return 结果
     */
    public int deletestuOrdersById(Long id);
}
