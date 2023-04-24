package com.ruoyi.apartment.mapper;

import java.util.List;
import com.ruoyi.apartment.domain.ManagerOpinion;

/**
 * 领导审批Mapper接口
 * 
 * @author ljc
 * @date 2023-04-24
 */
public interface ManagerOpinionMapper 
{
    /**
     * 查询领导审批
     * 
     * @param repairId 领导审批主键
     * @return 领导审批
     */
    public ManagerOpinion selectManagerOpinionByRepairId(Long repairId);

    /**
     * 查询领导审批列表
     * 
     * @param managerOpinion 领导审批
     * @return 领导审批集合
     */
    public List<ManagerOpinion> selectManagerOpinionList(ManagerOpinion managerOpinion);

    /**
     * 新增领导审批
     * 
     * @param managerOpinion 领导审批
     * @return 结果
     */
    public int insertManagerOpinion(ManagerOpinion managerOpinion);

    /**
     * 修改领导审批
     * 
     * @param managerOpinion 领导审批
     * @return 结果
     */
    public int updateManagerOpinion(ManagerOpinion managerOpinion);

    /**
     * 删除领导审批
     * 
     * @param repairId 领导审批主键
     * @return 结果
     */
    public int deleteManagerOpinionByRepairId(Long repairId);

    /**
     * 批量删除领导审批
     * 
     * @param repairIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteManagerOpinionByRepairIds(Long[] repairIds);
}
