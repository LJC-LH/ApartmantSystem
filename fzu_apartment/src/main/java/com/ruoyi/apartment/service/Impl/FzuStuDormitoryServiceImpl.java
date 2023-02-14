package com.ruoyi.apartment.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.FzuStuDormitoryMapper;
import com.ruoyi.apartment.domain.FzuStuDormitory;
import com.ruoyi.apartment.service.IFzuStuDormitoryService;

/**
 * 宿舍Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-14
 */
@Service
public class FzuStuDormitoryServiceImpl implements IFzuStuDormitoryService 
{
    @Autowired
    private FzuStuDormitoryMapper fzuStuDormitoryMapper;

    /**
     * 查询宿舍
     * 
     * @param dormId 宿舍主键
     * @return 宿舍
     */
    @Override
    public FzuStuDormitory selectFzuStuDormitoryByDormId(Long dormId)
    {
        return fzuStuDormitoryMapper.selectFzuStuDormitoryByDormId(dormId);
    }

    /**
     * 查询宿舍列表
     * 

     * @return 宿舍
     */
    @Override
    public List<FzuStuDormitory> selectFzuStuDormitoryList(String username)
    {
        return fzuStuDormitoryMapper.selectFzuStuDormitoryList(username);
    }

    /**
     * 新增宿舍
     * 
     * @param fzuStuDormitory 宿舍
     * @return 结果
     */
    @Override
    public int insertFzuStuDormitory(FzuStuDormitory fzuStuDormitory)
    {
        return fzuStuDormitoryMapper.insertFzuStuDormitory(fzuStuDormitory);
    }

    /**
     * 修改宿舍
     * 
     * @param fzuStuDormitory 宿舍
     * @return 结果
     */
    @Override
    public int updateFzuStuDormitory(FzuStuDormitory fzuStuDormitory)
    {
        return fzuStuDormitoryMapper.updateFzuStuDormitory(fzuStuDormitory);
    }

    /**
     * 批量删除宿舍
     * 
     * @param dormIds 需要删除的宿舍主键
     * @return 结果
     */
    @Override
    public int deleteFzuStuDormitoryByDormIds(Long[] dormIds)
    {
        return fzuStuDormitoryMapper.deleteFzuStuDormitoryByDormIds(dormIds);
    }

    /**
     * 删除宿舍信息
     * 
     * @param dormId 宿舍主键
     * @return 结果
     */
    @Override
    public int deleteFzuStuDormitoryByDormId(Long dormId)
    {
        return fzuStuDormitoryMapper.deleteFzuStuDormitoryByDormId(dormId);
    }
}
