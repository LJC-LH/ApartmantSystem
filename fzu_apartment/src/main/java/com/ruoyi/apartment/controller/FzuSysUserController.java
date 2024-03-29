package com.ruoyi.apartment.controller;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.FzuStuDormitory;
import com.ruoyi.apartment.domain.FzuUserRoot;
import com.ruoyi.apartment.service.IFzuStuDormitoryService;
import com.ruoyi.apartment.service.IFzuSysUserService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 用户信息Controller
 *
 * @author ruoyi
 * @date 2023-02-05
 */
@RestController
@RequestMapping("/apartment/user")
public class FzuSysUserController extends BaseController
{
    @Autowired
    private IFzuSysUserService fzuSysUserService;

    @Autowired
    private IFzuStuDormitoryService fzuStuDormitoryService;

    /**
     * 查询用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(FzuDormitoryInfo fzuDormitoryInfo)
    {
        startPage();
        List<FzuDormitoryInfo> list = fzuSysUserService.selectFzuSysUserList(fzuDormitoryInfo);
        return getDataTable(list);
    }

    /**
     * 查询fdy信息列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:fdy:list')")
    @GetMapping("/fdylist")
    public TableDataInfo Fdylist(FzuDormitoryInfo fzuDormitoryInfo)
    {
        startPage();
        List<FzuDormitoryInfo> list = fzuSysUserService.selectFdyUserList(fzuDormitoryInfo);
        return getDataTable(list);
    }

    /**
     * 导出学生宿舍信息列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:user:export')")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FzuDormitoryInfo fzuDormitoryInfo)
    {
        List<FzuDormitoryInfo> list = fzuSysUserService.selectFzuSysUserList(fzuDormitoryInfo);
        ExcelUtil<FzuDormitoryInfo> util = new ExcelUtil<FzuDormitoryInfo>(FzuDormitoryInfo.class);
        util.exportExcel(response, list, "学生宿舍信息数据");
    }

    /**
     * 导入学生宿舍列表
     */
    @Log(title = "学生宿舍", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('apartment:user:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<FzuDormitoryInfo> util = new ExcelUtil<FzuDormitoryInfo>(FzuDormitoryInfo.class);
        List<FzuDormitoryInfo> fzuDormitoryInfoList = util.importExcel(file.getInputStream());
        String message = fzuSysUserService.importFzuDormitoryInfo(fzuDormitoryInfoList, updateSupport);
        return success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<FzuDormitoryInfo> util = new ExcelUtil<FzuDormitoryInfo>(FzuDormitoryInfo.class);
        util.importTemplateExcel(response, "学生宿舍数据");
    }

    /**
     * 获取用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:user:query')")
    @PostMapping("/getUser")
    public AjaxResult getInfo(@RequestBody FzuDormitoryInfo fzuDormitoryInfo)
    {

        return success(fzuSysUserService.selectFzuSysUserByUserId(fzuDormitoryInfo));
    }

    /**
     * 新增用户信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:user:add')")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    @Transactional
    public AjaxResult add(@RequestBody FzuDormitoryInfo fzuDormitoryInfo)
    {
        Long userId = fzuSysUserService.selectUserIdByUserName(fzuDormitoryInfo);
        fzuDormitoryInfo.setUserId(userId);
        Long dormId = fzuSysUserService.selectDormIdByRoomInfo(fzuDormitoryInfo);
        fzuDormitoryInfo.setDormId(dormId);
        FzuStuDormitory temp = fzuStuDormitoryService.selectFzuStuDormitoryByDormId(dormId);
        if(Integer.parseInt(temp.getDormStatus()) > 2){
            return error("该宿舍为特殊宿舍无法直接分配");
        }
        fzuDormitoryInfo.setCreateTime(DateUtils.getNowDate());  //设置插入时间
        int i = fzuSysUserService.insertFzuStudentDormitory(fzuDormitoryInfo);
        if (i < 1){
            return error("该宿舍床位已使用，请检查输入信息");
        }
        fzuSysUserService.changAddDormStatus(fzuDormitoryInfo.getDormId());
        return toAjax(i);
    }

    /**
     * 修改用户信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:user:edit')")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FzuDormitoryInfo fzuDormitoryInfo)
    {
        int i = fzuSysUserService.updateFzuSysUser(fzuDormitoryInfo);
//        fzuDormitoryService.updateFzuDormitory(fzuDormitoryInfo);
        fzuSysUserService.updateFzuDormitory(fzuDormitoryInfo);
        fzuSysUserService.updateFzuStudentDormitory(fzuDormitoryInfo);

        return toAjax(i);
    }


    /**
     * 删除用户信息
     * 还没测试
     */
    @PreAuthorize("@ss.hasPermi('apartment:user:remove')")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
    @PostMapping("/delUser")
    public AjaxResult remove(@RequestBody FzuDormitoryInfo[] fzuDormitoryInfos)
    {
        int code = 0;
        Set<Long> dormIds = new HashSet<>();
        for (int i = 0; i < fzuDormitoryInfos.length; i++) {
            dormIds.add(fzuDormitoryInfos[i].getDormId());
            int num = fzuSysUserService.deleteFzuSysUserByUserIds(fzuDormitoryInfos[i]);
            code += num;
        }
        for(Long dormId : dormIds){
            fzuSysUserService.changDeleteDormStatus(dormId);
        }
        return toAjax(code);
    }


    //test
    @GetMapping("/root")
    public Integer GetRoot() {
        String username = SecurityUtils.getUsername();
        System.out.println(username);
        FzuUserRoot root = fzuSysUserService.getRoot(username);
        Date date = new Date();

        int i1 = date.compareTo(root.getStartTime());
        int i2 = date.compareTo(root.getEndTime());
        System.out.println("+++++++" + i1);
        System.out.println("+++++++" + i2);
        if (i1 == 1 && i2 == -1) {
            return 1;
        } else {
            return 0;
        }
    }

    @GetMapping("/rolesdeptid")
    public Long getRolesDeptId(String username) {
        return fzuSysUserService.getRolesDeptId(username);
    }

}
