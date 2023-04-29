package com.ruoyi.apartment.service.Impl;

import java.util.List;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.FzuStuDormitory;
import com.ruoyi.apartment.domain.FzuUserRoot;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.system.service.ISysConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.FzuSysUserMapper;
import com.ruoyi.apartment.domain.FzuSysUser;
import com.ruoyi.apartment.service.IFzuSysUserService;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;

/**
 * 用户信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-02-05
 */
@Service
@Transactional
public class FzuSysUserServiceImpl implements IFzuSysUserService
{
    private static final Logger log = LoggerFactory.getLogger(FzuStuDormitoryServiceImpl.class);

    @Autowired
    private FzuSysUserMapper fzuSysUserMapper;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    protected Validator validator;

    /**
     * 查询用户信息
     *
     * @return 用户信息
     */
    @Override
    public FzuDormitoryInfo selectFzuSysUserByUserId(FzuDormitoryInfo fzuDormitoryInfo)
    {
        return fzuSysUserMapper.selectFzuSysUserByUserId(fzuDormitoryInfo);
    }

    /**
     * 查询用户信息列表
     *
     * @param fzuSysUser 用户信息
     * @return 用户信息
     */
    @Override
    public List<FzuDormitoryInfo> selectFzuSysUserList(FzuDormitoryInfo fzuSysUser)
    {
        return fzuSysUserMapper.selectFzuSysUserList(fzuSysUser);
    }

    @Override
    public List<FzuDormitoryInfo> selectFdyUserList(FzuDormitoryInfo fzuSysUser)
    {
        return fzuSysUserMapper.selectFzuFdyUserList(fzuSysUser);
    }

    /**
     * 新增用户信息
     *
     * @param fzuSysUser 用户信息
     * @return 结果
     */
    @Override
    public int insertFzuSysUser(FzuDormitoryInfo fzuSysUser)
    {
//        fzuSysUser.setCreateTime(DateUtils.getNowDate());
        return fzuSysUserMapper.insertFzuSysUser(fzuSysUser);
    }

    /**
     * 修改用户信息
     *
     * @return 结果
     */
    @Override
    public int updateFzuSysUser(FzuDormitoryInfo fzuDormitoryInfo)
    {
        fzuDormitoryInfo.setUpdateTime(DateUtils.getNowDate());
        return fzuSysUserMapper.updateFzuSysUser(fzuDormitoryInfo);
    }

    /**
     *
     *
     * @return 结果
     */
    @Override
    public int deleteFzuSysUserByUserIds(FzuDormitoryInfo fzuDormitoryInfo)
    {
        return fzuSysUserMapper.deleteFzuSysUserByUserIds(fzuDormitoryInfo);
    }

    /**
     * 删除用户信息信息
     *
     * @param userId 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteFzuSysUserByUserId(Long userId)
    {
        return fzuSysUserMapper.deleteFzuSysUserByUserId(userId);
    }

    @Override
    public FzuUserRoot getRoot(String username) {
        return fzuSysUserMapper.getRoot(username);
    }

    @Override
    public int updateFzuDormitory(FzuDormitoryInfo fzuDormitoryInfo) {return fzuSysUserMapper.updateFzuDormitory(fzuDormitoryInfo);};

    @Override
    public int updateFzuStudentDormitory(FzuDormitoryInfo fzuDormitoryInfo) {return fzuSysUserMapper.updateFzuStudentDormitory(fzuDormitoryInfo);}

    @Override
    public int insertFzuStudentDormitory(FzuDormitoryInfo fzuDormitoryInfo)
    {
        return fzuSysUserMapper.insertFzuStudentDormitory(fzuDormitoryInfo);
    }

    public int insertFzuDormitory(FzuDormitoryInfo fzuDormitoryInfo)
    {
        return fzuSysUserMapper.insertFzuDormitory(fzuDormitoryInfo);
    }

    @Override
    public Long getRolesDeptId(String username) {
        return fzuSysUserMapper.getRolesDeptId(username);
    }

    @Override
    public Long selectUserIdByUserName(FzuDormitoryInfo fzuDormitoryInfo) {return fzuSysUserMapper.selectUserIdByUserName(fzuDormitoryInfo);}

    @Override
    public Long selectDormIdByRoomInfo(FzuDormitoryInfo fzuDormitoryInfo) {return fzuSysUserMapper.selectDormIdByRoomInfo(fzuDormitoryInfo);}

    @Override
    public void changAddDormStatus(Long dormId) {

        fzuSysUserMapper.changAddDormStatus(dormId);
        List<Long> dormIdList = fzuSysUserMapper.getDormIdList(dormId);
        for (Long aLong : dormIdList) {
            fzuSysUserMapper.changeDormStatusONE(aLong);
        }


    };
    @Override
    public void changDeleteDormStatus(Long dormId) {fzuSysUserMapper.changDeleteDormStatus(dormId);};

    @Override
    public Long getDormIdByUserId(Long userId) {
        return fzuSysUserMapper.getDormIdByUserId(userId);
    }

    public FzuDormitoryInfo selectOne(FzuDormitoryInfo fzuDormitoryInfo){
        return fzuSysUserMapper.selectOne(fzuDormitoryInfo);
    }


    /**
     * 导入学生宿舍数据
     *
     * @param fzuDormitoryInfoList        宿舍数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    @Override
    public String importFzuDormitoryInfo(List<FzuDormitoryInfo> fzuDormitoryInfoList, Boolean isUpdateSupport) {
        if (StringUtils.isNull(fzuDormitoryInfoList) || fzuDormitoryInfoList.size() == 0) {
            throw new ServiceException("导入学生宿舍数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (FzuDormitoryInfo fzuDormitoryInfo : fzuDormitoryInfoList) {
            try {
                Long userId = selectUserIdByUserName(fzuDormitoryInfo);
                Long dormId = selectDormIdByRoomInfo(fzuDormitoryInfo);
                fzuDormitoryInfo.setUserId(userId);
                fzuDormitoryInfo.setDormId(dormId);
                // 验证是否已经绑定了学生和宿舍
                FzuDormitoryInfo info = new FzuDormitoryInfo();
                info.setUserId(userId);
                info.setDormId(dormId);
                FzuDormitoryInfo f = null;
                if (userId != null && dormId != null) {
                    f = fzuSysUserMapper.selectOne(info);
                }else {
                    failureNum++;
                    failureMsg.append("<br/>" + successNum + "、宿舍 " + fzuDormitoryInfo.getBuildingNo()+"栋"+fzuDormitoryInfo.getRoomNo()+"不存在，或"+fzuDormitoryInfo.getUserName() + "数据不存在");
                    continue;
                }
                if (StringUtils.isNull(f)) {
                    BeanValidators.validateWithException(validator, fzuDormitoryInfo);
                    this.insertFzuStudentDormitory(fzuDormitoryInfo);
                    this.changAddDormStatus(fzuDormitoryInfo.getDormId());
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、宿舍 " + fzuDormitoryInfo.getBuildingNo()+"栋"+fzuDormitoryInfo.getRoomNo()+"关联"+fzuDormitoryInfo.getUserName() + "数据 导入成功");
                } else if (isUpdateSupport) {
                    BeanValidators.validateWithException(validator, fzuDormitoryInfo);
                    this.updateFzuStudentDormitory(fzuDormitoryInfo);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、宿舍 " + fzuDormitoryInfo.getBuildingNo()+"栋"+fzuDormitoryInfo.getRoomNo()+"关联"+fzuDormitoryInfo.getUserName() + "数据 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + successNum + "、宿舍 " + fzuDormitoryInfo.getBuildingNo()+"栋"+fzuDormitoryInfo.getRoomNo()+"关联"+fzuDormitoryInfo.getUserName() + "数据 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + successNum + "、宿舍 " + fzuDormitoryInfo.getBuildingNo()+"栋"+fzuDormitoryInfo.getRoomNo()+"关联"+fzuDormitoryInfo.getUserName() + "数据 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，以下数据导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}