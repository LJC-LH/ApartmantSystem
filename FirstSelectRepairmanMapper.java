package com.ruoyi.apartment.mapper;

import java.util.List;
import com.ruoyi.apartment.domain.FirstSelectRepairman;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 一次派单Mapper接口
 *
 * @author ljc
 * @date 2023-04-24
 */
public interface FirstSelectRepairmanMapper
{
    /**
     * 查询一次派单
     *
     * @param repairId 一次派单主键
     * @return 一次派单
     */
    public FirstSelectRepairman selectFirstSelectRepairmanByRepairId(Long repairId);

    /**
     * 查询一次派单列表
     *
     * @param firstSelectRepairman 一次派单
     * @return 一次派单集合
     */
    public List<FirstSelectRepairman> selectFirstSelectRepairmanList(FirstSelectRepairman firstSelectRepairman);

    /**
     * 新增一次派单
     *
     * @param firstSelectRepairman 一次派单
     * @return 结果
     */
    public int insertFirstSelectRepairman(FirstSelectRepairman firstSelectRepairman);

    /**
     * 修改一次派单
     *
     * @param firstSelectRepairman 一次派单
     * @return 结果
     */
    public int updateFirstSelectRepairman(FirstSelectRepairman firstSelectRepairman);

    /**
     * 删除一次派单
     *
     * @param repairId 一次派单主键
     * @return 结果
     */
    public int deleteFirstSelectRepairmanByRepairId(Long repairId);

    /**
     * 批量删除一次派单
     *
     * @param repairIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFirstSelectRepairmanByRepairIds(Long[] repairIds);

    public List<SysUser> selectUserByRoleId(Long roleId);
}
