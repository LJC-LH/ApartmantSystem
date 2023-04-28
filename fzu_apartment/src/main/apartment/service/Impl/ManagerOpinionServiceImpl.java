package com.ruoyi.apartment.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.ManagerOpinionMapper;
import com.ruoyi.apartment.domain.ManagerOpinion;
import com.ruoyi.apartment.service.IManagerOpinionService;

/**
 * 领导审批Service业务层处理
 * 
 * @author ljc
 * @date 2023-04-24
 */
@Service
public class ManagerOpinionServiceImpl implements IManagerOpinionService 
{
    @Autowired
    private ManagerOpinionMapper managerOpinionMapper;

    /**
     * 查询领导审批
     * 
     * @param repairId 领导审批主键
     * @return 领导审批
     */
    @Override
    public ManagerOpinion selectManagerOpinionByRepairId(Long repairId)
    {
        return managerOpinionMapper.selectManagerOpinionByRepairId(repairId);
    }

    /**
     * 查询领导审批列表
     * 
     * @param managerOpinion 领导审批
     * @return 领导审批
     */
    @Override
    public List<ManagerOpinion> selectManagerOpinionList(ManagerOpinion managerOpinion)
    {
        return managerOpinionMapper.selectManagerOpinionList(managerOpinion);
    }

    /**
     * 新增领导审批
     * 
     * @param managerOpinion 领导审批
     * @return 结果
     */
    @Override
    public int insertManagerOpinion(ManagerOpinion managerOpinion)
    {
        return managerOpinionMapper.insertManagerOpinion(managerOpinion);
    }

    /**
     * 修改领导审批
     * 
     * @param managerOpinion 领导审批
     * @return 结果
     */
    @Override
    public int updateManagerOpinion(ManagerOpinion managerOpinion)
    {
        return managerOpinionMapper.updateManagerOpinion(managerOpinion);
    }

    /**
     * 批量删除领导审批
     * 
     * @param repairIds 需要删除的领导审批主键
     * @return 结果
     */
    @Override
    public int deleteManagerOpinionByRepairIds(Long[] repairIds)
    {
        return managerOpinionMapper.deleteManagerOpinionByRepairIds(repairIds);
    }

    /**
     * 删除领导审批信息
     * 
     * @param repairId 领导审批主键
     * @return 结果
     */
    @Override
    public int deleteManagerOpinionByRepairId(Long repairId)
    {
        return managerOpinionMapper.deleteManagerOpinionByRepairId(repairId);
    }
}
