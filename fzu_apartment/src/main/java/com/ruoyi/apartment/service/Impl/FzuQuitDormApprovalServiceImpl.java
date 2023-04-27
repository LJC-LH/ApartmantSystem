package com.ruoyi.apartment.service.Impl;

import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.mapper.FzuSysUserMapper;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.FzuQuitDormApprovalMapper;
import com.ruoyi.apartment.domain.FzuQuitDormApproval;
import com.ruoyi.apartment.service.IFzuQuitDormApprovalService;

/**
 * 休学宿舍退宿Service业务层处理
 * 
 * @author ljc
 * @date 2023-04-26
 */
@Service
public class FzuQuitDormApprovalServiceImpl implements IFzuQuitDormApprovalService 
{
    @Autowired
    private FzuQuitDormApprovalMapper fzuQuitDormApprovalMapper;

    @Autowired
    private FzuSysUserMapper fzuSysUserMapper;

    /**
     * 查询休学宿舍退宿
     * 
     * @param quitId 休学宿舍退宿主键
     * @return 休学宿舍退宿
     */
    @Override
    public FzuQuitDormApproval selectFzuQuitDormApprovalByQuitId(Long quitId)
    {
        return fzuQuitDormApprovalMapper.selectFzuQuitDormApprovalByQuitId(quitId);
    }

    /**
     * 查询休学宿舍退宿列表
     * 
     * @param fzuQuitDormApproval 休学宿舍退宿
     * @return 休学宿舍退宿
     */
    @Override
    public List<FzuQuitDormApproval> selectFzuQuitDormApprovalList(FzuQuitDormApproval fzuQuitDormApproval)
    {
        return fzuQuitDormApprovalMapper.selectFzuQuitDormApprovalList(fzuQuitDormApproval);
    }

    /**
     * 新增休学宿舍退宿
     * 
     * @param fzuQuitDormApproval 休学宿舍退宿
     * @return 结果
     */
    @Override
    public int insertFzuQuitDormApproval(FzuQuitDormApproval fzuQuitDormApproval)
    {
        fzuQuitDormApproval.setCreateTime(DateUtils.getNowDate());
        return fzuQuitDormApprovalMapper.insertFzuQuitDormApproval(fzuQuitDormApproval);
    }

    /**
     * 修改休学宿舍退宿
     * 
     * @param fzuQuitDormApproval 休学宿舍退宿
     * @return 结果
     */
    @Override
    public int updateFzuQuitDormApproval(FzuQuitDormApproval fzuQuitDormApproval)
    {
        return fzuQuitDormApprovalMapper.updateFzuQuitDormApproval(fzuQuitDormApproval);
    }

    /**
     * 批量删除休学宿舍退宿
     * 
     * @param quitIds 需要删除的休学宿舍退宿主键
     * @return 结果
     */
    @Override
    public int deleteFzuQuitDormApprovalByQuitIds(Long[] quitIds)
    {
        return fzuQuitDormApprovalMapper.deleteFzuQuitDormApprovalByQuitIds(quitIds);
    }

    /**
     * 删除休学宿舍退宿信息
     * 
     * @param quitId 休学宿舍退宿主键
     * @return 结果
     */
    @Override
    public int deleteFzuQuitDormApprovalByQuitId(Long quitId)
    {
        return fzuQuitDormApprovalMapper.deleteFzuQuitDormApprovalByQuitId(quitId);
    }

    @Override
    public FzuDormitoryInfo getInfo(String userName) {
        FzuDormitoryInfo info = new FzuDormitoryInfo();
        info.setUserName(userName);
        Long userId = fzuSysUserMapper.selectUserIdByUserName(info);
        System.out.println("111111111111" + userId);
        info.setDormId(fzuSysUserMapper.getDormIdByUserId(userId));
        System.out.println("222222222222" + info);
        info.setUserId(userId);
        return fzuSysUserMapper.selectFzuSysUserByUserId(info);
    }

    @Override
    public int deleteAndUpdateDormInfo(FzuQuitDormApproval fzuQuitDormApproval) {
        FzuDormitoryInfo temp = new FzuDormitoryInfo();
        temp.setUserId(fzuQuitDormApproval.getStudentId());
        temp.setDormId(fzuQuitDormApproval.getDormId());
        int i = fzuSysUserMapper.deleteFzuSysUserByUserIds(temp);
        if(i > 0) {
            fzuSysUserMapper.changDeleteDormStatus(fzuQuitDormApproval.getDormId());
        }
        return i;
    }
}
