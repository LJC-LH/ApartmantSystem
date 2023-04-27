package com.ruoyi.apartment.service;

import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.FzuQuitDormApproval;

/**
 * 休学宿舍退宿Service接口
 * 
 * @author ljc
 * @date 2023-04-26
 */
public interface IFzuQuitDormApprovalService 
{
    /**
     * 查询休学宿舍退宿
     * 
     * @param quitId 休学宿舍退宿主键
     * @return 休学宿舍退宿
     */
    public FzuQuitDormApproval selectFzuQuitDormApprovalByQuitId(Long quitId);

    /**
     * 查询休学宿舍退宿列表
     * 
     * @param fzuQuitDormApproval 休学宿舍退宿
     * @return 休学宿舍退宿集合
     */
    public List<FzuQuitDormApproval> selectFzuQuitDormApprovalList(FzuQuitDormApproval fzuQuitDormApproval);

    /**
     * 新增休学宿舍退宿
     * 
     * @param fzuQuitDormApproval 休学宿舍退宿
     * @return 结果
     */
    public int insertFzuQuitDormApproval(FzuQuitDormApproval fzuQuitDormApproval);

    /**
     * 修改休学宿舍退宿
     * 
     * @param fzuQuitDormApproval 休学宿舍退宿
     * @return 结果
     */
    public int updateFzuQuitDormApproval(FzuQuitDormApproval fzuQuitDormApproval);

    /**
     * 批量删除休学宿舍退宿
     * 
     * @param quitIds 需要删除的休学宿舍退宿主键集合
     * @return 结果
     */
    public int deleteFzuQuitDormApprovalByQuitIds(Long[] quitIds);

    /**
     * 删除休学宿舍退宿信息
     * 
     * @param quitId 休学宿舍退宿主键
     * @return 结果
     */
    public int deleteFzuQuitDormApprovalByQuitId(Long quitId);

    public FzuDormitoryInfo getInfo(String userName);

    int deleteAndUpdateDormInfo(FzuQuitDormApproval fzuQuitDormApproval);
}
