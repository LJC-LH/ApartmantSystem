package com.ruoyi.apartment.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.FzuSpecialdormApprovalMapper;
import com.ruoyi.apartment.domain.entity.FzuSpecialdormApproval;
import com.ruoyi.apartment.service.IFzuSpecialdormApprovalService;

/**
 * 特殊宿舍申请Service业务层处理
 *
 * @author wsh
 * @date 2023-02-08
 */
@Service
public class FzuSpecialdormApprovalServiceImpl implements IFzuSpecialdormApprovalService
{
    @Autowired
    private FzuSpecialdormApprovalMapper fzuSpecialdormApprovalMapper;

    /**
     * 查询特殊宿舍申请
     *
     * @param approvalId 特殊宿舍申请主键
     * @return 特殊宿舍申请
     */
    @Override
    public FzuSpecialdormApproval selectFzuSpecialdormApprovalByApprovalId(Long approvalId)
    {
        return fzuSpecialdormApprovalMapper.selectFzuSpecialdormApprovalByApprovalId(approvalId);
    }

    /**
     * 查询特殊宿舍申请列表
     *
     * @param fzuSpecialdormApproval 特殊宿舍申请
     * @return 特殊宿舍申请
     */
    @Override
    public List<FzuSpecialdormApproval> selectFzuSpecialdormApprovalList(FzuSpecialdormApproval fzuSpecialdormApproval)
    {
        return fzuSpecialdormApprovalMapper.selectFzuSpecialdormApprovalList(fzuSpecialdormApproval);
    }

    /**
     * 新增特殊宿舍申请
     *
     * @param fzuSpecialdormApproval 特殊宿舍申请
     * @return 结果
     */
    @Override
    public int insertFzuSpecialdormApproval(FzuSpecialdormApproval fzuSpecialdormApproval)
    {
        return fzuSpecialdormApprovalMapper.insertFzuSpecialdormApproval(fzuSpecialdormApproval);
    }

    /**
     * 修改特殊宿舍申请
     *
     * @param fzuSpecialdormApproval 特殊宿舍申请
     * @return 结果
     */
    @Override
    public int updateFzuSpecialdormApproval(FzuSpecialdormApproval fzuSpecialdormApproval)
    {
        return fzuSpecialdormApprovalMapper.updateFzuSpecialdormApproval(fzuSpecialdormApproval);
    }

    /**
     * 批量删除特殊宿舍申请
     *
     * @param approvalIds 需要删除的特殊宿舍申请主键
     * @return 结果
     */
    @Override
    public int deleteFzuSpecialdormApprovalByApprovalIds(Long[] approvalIds)
    {
        return fzuSpecialdormApprovalMapper.deleteFzuSpecialdormApprovalByApprovalIds(approvalIds);
    }

    /**
     * 删除特殊宿舍申请信息
     *
     * @param approvalId 特殊宿舍申请主键
     * @return 结果
     */
    @Override
    public int deleteFzuSpecialdormApprovalByApprovalId(Long approvalId)
    {
        return fzuSpecialdormApprovalMapper.deleteFzuSpecialdormApprovalByApprovalId(approvalId);
    }
}
