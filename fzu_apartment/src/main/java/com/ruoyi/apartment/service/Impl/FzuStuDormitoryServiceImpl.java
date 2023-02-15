package com.ruoyi.apartment.service.Impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.system.service.ISysConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.apartment.mapper.FzuStuDormitoryMapper;
import com.ruoyi.apartment.domain.FzuStuDormitory;
import com.ruoyi.apartment.service.IFzuStuDormitoryService;

import javax.validation.Validator;

/**
 * 宿舍Service业务层处理
 *
 * @author ruoyi
 * @date 2023-02-15
 */
@Service
public class FzuStuDormitoryServiceImpl implements IFzuStuDormitoryService
{
    private static final Logger log = LoggerFactory.getLogger(FzuStuDormitoryServiceImpl.class);

    @Autowired
    private FzuStuDormitoryMapper fzuStuDormitoryMapper;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    protected Validator validator;

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
     * @param fzuStuDormitory 宿舍
     * @return 宿舍
     */
    @Override
    public List<FzuStuDormitory> selectFzuStuDormitoryList(FzuStuDormitory fzuStuDormitory)
    {
        return fzuStuDormitoryMapper.selectFzuStuDormitoryList(fzuStuDormitory);
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

    /**
     * 导入宿舍数据
     *
     * @param fzuStuDormitoryList        宿舍数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    @Override
    public String importDormitory(List<FzuStuDormitory> fzuStuDormitoryList, Boolean isUpdateSupport) {
        if (StringUtils.isNull(fzuStuDormitoryList) || fzuStuDormitoryList.size() == 0) {
            throw new ServiceException("导入宿舍数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (FzuStuDormitory fzuStuDormitory : fzuStuDormitoryList) {
            try {
                // 验证是否存在这个宿舍
                FzuStuDormitory f = fzuStuDormitoryMapper.selectFzuStuDormitoryByBuildNoAndRoomNo(fzuStuDormitory.getBuildingNo(),fzuStuDormitory.getRoomNo());
                if (StringUtils.isNull(f)) {
                    BeanValidators.validateWithException(validator, fzuStuDormitory);
                    this.insertFzuStuDormitory(fzuStuDormitory);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、宿舍 " + fzuStuDormitory.getBuildingNo()+"栋"+fzuStuDormitory.getRoomNo() + " 导入成功");
                } else if (isUpdateSupport) {
                    BeanValidators.validateWithException(validator, fzuStuDormitory);
                    this.updateFzuStuDormitory(fzuStuDormitory);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、宿舍 " + fzuStuDormitory.getBuildingNo()+"栋"+fzuStuDormitory.getRoomNo() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、宿舍 " + fzuStuDormitory.getBuildingNo()+"栋"+fzuStuDormitory.getRoomNo() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、宿舍 " + fzuStuDormitory.getBuildingNo()+"栋"+fzuStuDormitory.getRoomNo() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
