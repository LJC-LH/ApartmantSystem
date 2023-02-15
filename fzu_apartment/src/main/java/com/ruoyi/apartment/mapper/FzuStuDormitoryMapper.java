package com.ruoyi.apartment.mapper;

import java.util.List;
import com.ruoyi.apartment.domain.FzuStuDormitory;
import org.apache.ibatis.annotations.Param;

/**
 * 宿舍Mapper接口
 *
 * @author ruoyi
 * @date 2023-02-15
 */
public interface FzuStuDormitoryMapper
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
     * @param fzuStuDormitory 宿舍
     * @return 宿舍集合
     */
    public List<FzuStuDormitory> selectFzuStuDormitoryList(FzuStuDormitory fzuStuDormitory);

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
     * 删除宿舍
     *
     * @param dormId 宿舍主键
     * @return 结果
     */
    public int deleteFzuStuDormitoryByDormId(Long dormId);

    /**
     * 批量删除宿舍
     *
     * @param dormIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFzuStuDormitoryByDormIds(Long[] dormIds);

    public FzuStuDormitory selectFzuStuDormitoryByBuildNoAndRoomNo(@Param("buildingNo") String buildingNo,@Param("roomNo") String roomNo);
}
