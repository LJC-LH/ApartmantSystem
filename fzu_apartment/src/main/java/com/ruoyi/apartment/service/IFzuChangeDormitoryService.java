package com.ruoyi.apartment.service;

import java.util.List;
import com.ruoyi.apartment.domain.FzuChangeDormitory;

/**
 * 宿舍调整Service接口
 * 
 * @author ljc
 * @date 2023-04-24
 */
public interface IFzuChangeDormitoryService 
{
    /**
     * 查询宿舍调整
     * 
     * @param changeId 宿舍调整主键
     * @return 宿舍调整
     */
    public FzuChangeDormitory selectFzuChangeDormitoryByChangeId(Long changeId);

    /**
     * 查询宿舍调整列表
     * 
     * @param fzuChangeDormitory 宿舍调整
     * @return 宿舍调整集合
     */
    public List<FzuChangeDormitory> selectFzuChangeDormitoryList(FzuChangeDormitory fzuChangeDormitory);

    /**
     * 新增宿舍调整
     * 
     * @param fzuChangeDormitory 宿舍调整
     * @return 结果
     */
    public int insertFzuChangeDormitory(FzuChangeDormitory fzuChangeDormitory);

    /**
     * 修改宿舍调整
     * 
     * @param fzuChangeDormitory 宿舍调整
     * @return 结果
     */
    public int updateFzuChangeDormitory(FzuChangeDormitory fzuChangeDormitory);

    /**
     * 批量删除宿舍调整
     * 
     * @param changeIds 需要删除的宿舍调整主键集合
     * @return 结果
     */
    public int deleteFzuChangeDormitoryByChangeIds(Long[] changeIds);

    /**
     * 删除宿舍调整信息
     * 
     * @param changeId 宿舍调整主键
     * @return 结果
     */
    public int deleteFzuChangeDormitoryByChangeId(Long changeId);
}
