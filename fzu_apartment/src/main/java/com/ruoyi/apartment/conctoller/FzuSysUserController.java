package com.ruoyi.apartment.conctoller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.FzuUserRoot;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.FzuDormitory;
import com.ruoyi.system.domain.FzuStudentDormitory;
import com.ruoyi.system.service.IFzuDormitoryService;
import com.ruoyi.system.service.IFzuStudentDormitoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.apartment.domain.FzuSysUser;
import com.ruoyi.apartment.service.IFzuSysUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

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
    private IFzuDormitoryService fzuDormitoryService;
    private IFzuStudentDormitoryService fzuStudentDormitoryService;

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
     * 导出用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:user:export')")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FzuDormitoryInfo fzuDormitoryInfo)
    {
        List<FzuDormitoryInfo> list = fzuSysUserService.selectFzuSysUserList(fzuDormitoryInfo);
        ExcelUtil<FzuDormitoryInfo> util = new ExcelUtil<FzuDormitoryInfo>(FzuDormitoryInfo.class);
        util.exportExcel(response, list, "用户信息数据");
    }

    /**
     * 获取用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:user:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(fzuSysUserService.selectFzuSysUserByUserId(userId));
    }

    /**
     * 新增用户信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:user:add')")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FzuDormitoryInfo fzuDormitoryInfo)
    {

        fzuDormitoryInfo.setUserId(fzuSysUserService.selectUserIdByUserName(fzuDormitoryInfo));
        fzuDormitoryInfo.setDormId(fzuSysUserService.selectDormIdByRoomInfo(fzuDormitoryInfo));
        int i = fzuSysUserService.insertFzuStudentDormitory(fzuDormitoryInfo);
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
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(fzuSysUserService.deleteFzuSysUserByUserIds(userIds));
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
