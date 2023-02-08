package com.ruoyi.apartment.conctoller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
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
     * 导出用户信息列表
     */
//    @PreAuthorize("@ss.hasPermi('apartment:user:export')")
//    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, FzuSysUser fzuDormitoryInfo)
//    {
//        List<FzuDormitoryInfo> list = fzuSysUserService.selectFzuSysUserList(fzuDormitoryInfo);
//        ExcelUtil<FzuSysUser> util = new ExcelUtil<FzuSysUser>(FzuSysUser.class);
//        util.exportExcel(response, list, "用户信息数据");
//    }

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
        fzuSysUserService.insertFzuSysUser(fzuDormitoryInfo);
//        System.out.println("-------------------------"+fzuDormitoryInfo.getUserId());
        Long userId = fzuDormitoryInfo.getUserId();
//        逻辑还没写完，student_domority主键
        return toAjax(fzuSysUserService.insertFzuSysUser(fzuDormitoryInfo));
    }

    /**
     * 修改用户信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:user:edit')")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FzuDormitoryInfo fzuDormitoryInfo)
    {
//        fzuStudentDormitory = fzuStudentDormitoryService.selectFzuStudentDormitoryByStudentId();
        return toAjax(fzuSysUserService.insertFzuSysUser(fzuDormitoryInfo));

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
}
