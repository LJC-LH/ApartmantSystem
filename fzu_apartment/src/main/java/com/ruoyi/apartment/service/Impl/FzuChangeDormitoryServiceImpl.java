package com.ruoyi.apartment.service.Impl;

import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.FzuStuDormitory;
import com.ruoyi.apartment.mapper.FzuStuDormitoryMapper;
import com.ruoyi.apartment.mapper.FzuSysUserMapper;
import com.ruoyi.apartment.service.IFzuSysUserService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.FzuChangeDormitoryMapper;
import com.ruoyi.apartment.domain.FzuChangeDormitory;
import com.ruoyi.apartment.service.IFzuChangeDormitoryService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 宿舍调整Service业务层处理
 * 
 * @author ljc
 * @date 2023-04-24
 */
@Service
@Transactional
public class FzuChangeDormitoryServiceImpl implements IFzuChangeDormitoryService 
{
    @Autowired
    private FzuChangeDormitoryMapper fzuChangeDormitoryMapper;

    @Autowired
    private FzuSysUserMapper fzuSysUserMapper;

    @Autowired
    private IFzuSysUserService fzuSysUserService;

    @Autowired
    private FzuStuDormitoryMapper fzuStuDormitoryMapper;

    /**
     * 查询宿舍调整
     * 
     * @param changeId 宿舍调整主键
     * @return 宿舍调整
     */
    @Override
    public FzuChangeDormitory selectFzuChangeDormitoryByChangeId(Long changeId)
    {
        return fzuChangeDormitoryMapper.selectFzuChangeDormitoryByChangeId(changeId);
    }

    /**
     * 查询宿舍调整列表
     * 
     * @param fzuChangeDormitory 宿舍调整
     * @return 宿舍调整
     */
    @Override
    public List<FzuChangeDormitory> selectFzuChangeDormitoryList(FzuChangeDormitory fzuChangeDormitory)
    {
        return fzuChangeDormitoryMapper.selectFzuChangeDormitoryList(fzuChangeDormitory);
    }

    /**
     * 新增宿舍调整
     * 
     * @param fzuChangeDormitory 宿舍调整
     * @return 结果
     */
    @Override
    public int insertFzuChangeDormitory(FzuChangeDormitory fzuChangeDormitory)
    {
        int i = 0;
        try {
            //获取原学生宿舍信息
            String oneUserName = fzuChangeDormitory.getOneUserName();
            FzuDormitoryInfo fzuDormitoryInfo1 = new FzuDormitoryInfo();
            fzuDormitoryInfo1.setUserName(oneUserName);
            Long userId1 = fzuSysUserMapper.selectUserIdByUserName(fzuDormitoryInfo1);
            Long dormId1 = fzuSysUserMapper.getDormIdByUserId(userId1);
            fzuDormitoryInfo1.setUserId(userId1);
            fzuDormitoryInfo1.setDormId(dormId1);
            FzuDormitoryInfo temp1 = fzuSysUserMapper.selectFzuSysUserByUserId(fzuDormitoryInfo1);//找出所属学院
            if(fzuChangeDormitory.getDeptId().longValue()!=temp1.getDeptId().longValue()){  //不是本学院，退出
                return 0;
            }
            String oneBedNo = fzuChangeDormitory.getOneBedNo();
            //获取新宿舍信息
            if(fzuChangeDormitory.getTwoUserName()!=null){    //如有学号进行宿舍交换
                System.out.println("有学号进行宿舍交换:"+fzuChangeDormitory);
                String twoUserName = fzuChangeDormitory.getTwoUserName();
                FzuDormitoryInfo fzuDormitoryInfo2 = new FzuDormitoryInfo();
                fzuDormitoryInfo2.setUserName(twoUserName);
                Long userId2 = fzuSysUserMapper.selectUserIdByUserName(fzuDormitoryInfo2);
                Long dormId2 = fzuSysUserMapper.getDormIdByUserId(userId2);
                fzuDormitoryInfo2.setUserId(userId2);
                fzuDormitoryInfo2.setDormId(dormId2);
                FzuDormitoryInfo temp2 = fzuSysUserMapper.selectFzuSysUserByUserId(fzuDormitoryInfo1);//找出所属学院
                if(fzuChangeDormitory.getDeptId().longValue()!=temp2.getDeptId().longValue()){  //不是本学院，退出
                    return 0;
                }
                String twoBedNo = fzuChangeDormitory.getTwoBedNo();
                //userId1学生更新更新为2的信息
                fzuDormitoryInfo1.setUserId(userId1);
                fzuDormitoryInfo1.setDormId(dormId2);
                fzuDormitoryInfo1.setBedNo(twoBedNo);
                //userId2学生更新更新为1的信息
                fzuDormitoryInfo2.setUserId(userId2);
                fzuDormitoryInfo2.setDormId(dormId1);
                fzuDormitoryInfo2.setBedNo(oneBedNo);
                //宿舍信息交换
                int i1 = fzuSysUserMapper.updateFzuStudentDormitory(fzuDormitoryInfo1);
                int i2 = fzuSysUserMapper.updateFzuStudentDormitory(fzuDormitoryInfo2);
                fzuChangeDormitory.setTwoStudentId(userId2);
                fzuChangeDormitory.setTwoDormId(dormId2);
            }else{        //无学号调整到空床位
                System.out.println("无学号调整到空床位:"+fzuChangeDormitory);
                FzuDormitoryInfo fzuDormitoryInfo2 = new FzuDormitoryInfo();
                fzuDormitoryInfo2.setBuildingNo(fzuChangeDormitory.getTwoBuildingNo());
                fzuDormitoryInfo2.setRoomNo(fzuChangeDormitory.getTwoRoomNo());
                fzuDormitoryInfo2.setBedNo(fzuChangeDormitory.getTwoBedNo());
                Long dormId2 = fzuSysUserMapper.selectDormIdByRoomInfo(fzuDormitoryInfo2);
                FzuStuDormitory temp3 = fzuStuDormitoryMapper.selectFzuStuDormitoryByDormId(dormId2);
                if(fzuChangeDormitory.getDeptId().longValue()!=temp3.getDeptId().longValue()){  //不是本学院，退出
                    return 0;
                }
                String twoBedNo = fzuChangeDormitory.getTwoBedNo();
                FzuDormitoryInfo temp4 = new FzuDormitoryInfo();
                temp4.setDormId(dormId2);
                temp4.setBedNo(twoBedNo);
                if(fzuChangeDormitoryMapper.selectDormByDormIdAndBedId(temp4) != null){  //床位不是为空，不能分配，退出
                    return 0;
                }
                fzuDormitoryInfo1.setUserId(userId1);
                fzuDormitoryInfo1.setDormId(dormId2);
                fzuDormitoryInfo1.setBedNo(twoBedNo);
                //插入空床位，更新新旧宿舍和床位状态
                int i1 = fzuSysUserMapper.updateFzuStudentDormitory(fzuDormitoryInfo1);
                fzuSysUserService.changDeleteDormStatus(dormId1);
                fzuSysUserService.changAddDormStatus(dormId2);
                fzuChangeDormitory.setTwoDormId(dormId2);
            }
            //把userId,dormId，createTime补充到实体保存到数据库中
            fzuChangeDormitory.setCreateTime(DateUtils.getNowDate());
            fzuChangeDormitory.setOneStudentId(userId1);
            fzuChangeDormitory.setOneDormId(dormId1);
            i = fzuChangeDormitoryMapper.insertFzuChangeDormitory(fzuChangeDormitory);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    /**
     * 修改宿舍调整
     * 
     * @param fzuChangeDormitory 宿舍调整
     * @return 结果
     */
    @Override
    public int updateFzuChangeDormitory(FzuChangeDormitory fzuChangeDormitory)
    {
        return fzuChangeDormitoryMapper.updateFzuChangeDormitory(fzuChangeDormitory);
    }

    /**
     * 批量删除宿舍调整
     * 
     * @param changeIds 需要删除的宿舍调整主键
     * @return 结果
     */
    @Override
    public int deleteFzuChangeDormitoryByChangeIds(Long[] changeIds)
    {
        return fzuChangeDormitoryMapper.deleteFzuChangeDormitoryByChangeIds(changeIds);
    }

    /**
     * 删除宿舍调整信息
     * 
     * @param changeId 宿舍调整主键
     * @return 结果
     */
    @Override
    public int deleteFzuChangeDormitoryByChangeId(Long changeId)
    {
        return fzuChangeDormitoryMapper.deleteFzuChangeDormitoryByChangeId(changeId);
    }
}
