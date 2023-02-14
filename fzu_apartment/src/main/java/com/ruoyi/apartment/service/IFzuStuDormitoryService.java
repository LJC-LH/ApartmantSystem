package com.ruoyi.apartment.service;

import java.util.List;
import com.ruoyi.apartment.domain.FzuStuDormitory;

/**
 * 宿舍Service接口
 * 
 * @author ruoyi
 * @date 2023-02-14
 */
public interface IFzuStuDormitoryService 
{
    /**
     * 查询宿舍
     * 
     * @param dormId 宿舍主键
     * @return 宿舍
     */
    public FzuStuDormitory selectFzuStuDormitoryByDormId(Long dormId);

    /**
     * 查询宿舍列表
     *
     * @return 宿舍集合
     */
    public List<FzuStuDormitory> selectFzuStuDormitoryList(String username);

    /**
     * 新增宿舍
     * 
     * @param fzuStuDormitory 宿舍
     * @return 结果
     */
    public int insertFzuStuDormitory(FzuStuDormitory fzuStuDormitory);

    /**
     * 修改宿舍
     * 
     * @param fzuStuDormitory 宿舍
     * @return 结果
     */
    public int updateFzuStuDormitory(FzuStuDormitory fzuStuDormitory);

    /**
     * 批量删除宿舍
     * 
     * @param dormIds 需要删除的宿舍主键集合
     * @return 结果
     */
    public int deleteFzuStuDormitoryByDormIds(Long[] dormIds);

    /**
     * 删除宿舍信息
     * 
     * @param dormId 宿舍主键
     * @return 结果
     */
    public int deleteFzuStuDormitoryByDormId(Long dormId);
}
