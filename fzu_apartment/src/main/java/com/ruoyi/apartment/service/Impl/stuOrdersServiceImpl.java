package com.ruoyi.apartment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.stuOrdersMapper;
import com.ruoyi.apartment.domain.stuOrders;
import com.ruoyi.apartment.service.IstuOrdersService;

/**
 * 学生订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
@Service
public class stuOrdersServiceImpl implements IstuOrdersService 
{
    @Autowired
    private stuOrdersMapper stuOrdersMapper;

    /**
     * 查询学生订单
     * 
     * @param id 学生订单主键
     * @return 学生订单
     */
    @Override
    public stuOrders selectstuOrdersById(Long id)
    {
        return stuOrdersMapper.selectstuOrdersById(id);
    }

    /**
     * 查询学生订单列表
     * 
     * @param stuOrders 学生订单
     * @return 学生订单
     */
    @Override
    public List<stuOrders> selectstuOrdersList(stuOrders stuOrders)
    {
        return stuOrdersMapper.selectstuOrdersList(stuOrders);
    }

    /**
     * 新增学生订单
     * 
     * @param stuOrders 学生订单
     * @return 结果
     */
    @Override
    public int insertstuOrders(stuOrders stuOrders)
    {
        return stuOrdersMapper.insertstuOrders(stuOrders);
    }

    /**
     * 修改学生订单
     * 
     * @param stuOrders 学生订单
     * @return 结果
     */
    @Override
    public int updatestuOrders(stuOrders stuOrders)
    {
        return stuOrdersMapper.updatestuOrders(stuOrders);
    }

    /**
     * 批量删除学生订单
     * 
     * @param ids 需要删除的学生订单主键
     * @return 结果
     */
    @Override
    public int deletestuOrdersByIds(Long[] ids)
    {
        return stuOrdersMapper.deletestuOrdersByIds(ids);
    }

    /**
     * 删除学生订单信息
     * 
     * @param id 学生订单主键
     * @return 结果
     */
    @Override
    public int deletestuOrdersById(Long id)
    {
        return stuOrdersMapper.deletestuOrdersById(id);
    }
}
