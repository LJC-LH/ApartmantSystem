package com.ruoyi.apartment.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.FzuStuDormitory;
import com.ruoyi.apartment.domain.entity.FzuSpecialdormApproval;
import com.ruoyi.apartment.service.IFzuStuDormitoryService;
import com.ruoyi.common.core.domain.entity.SysUser;
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
import com.ruoyi.apartment.service.IFzuSpecialdormApprovalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;


/**
 * 特殊宿舍申请Controller
 *
 * @author wsh
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/apartment/approval")
public class FzuSpecialdormApprovalController extends BaseController
{
    @Autowired
    private IFzuSpecialdormApprovalService fzuSpecialdormApprovalService;

    @Autowired
    private IFzuStuDormitoryService fzuStuDormitoryService;


    /**
     * 查询特殊宿舍申请列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:approval:list')")
    @GetMapping("/list")
    public TableDataInfo list(FzuSpecialdormApproval fzuSpecialdormApproval)
    {
        startPage();
        List<FzuSpecialdormApproval> list = fzuSpecialdormApprovalService.selectFzuSpecialdormApprovalList(fzuSpecialdormApproval);
        return getDataTable(list);
    }

    /**
     * 导出特殊宿舍申请列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:approval:export')")
    @Log(title = "特殊宿舍申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FzuSpecialdormApproval fzuSpecialdormApproval)
    {
        List<FzuSpecialdormApproval> list = fzuSpecialdormApprovalService.selectFzuSpecialdormApprovalList(fzuSpecialdormApproval);
        ExcelUtil<FzuSpecialdormApproval> util = new ExcelUtil<FzuSpecialdormApproval>(FzuSpecialdormApproval.class);
        util.exportExcel(response, list, "特殊宿舍申请数据");
    }

    /**
     * 获取特殊宿舍申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:approval:query')")
    @GetMapping(value = "/{approvalId}")
    public AjaxResult getInfo(@PathVariable("approvalId") Long approvalId)
    {
        return success(fzuSpecialdormApprovalService.selectFzuSpecialdormApprovalByApprovalId(approvalId));
    }

    /**
     * 新增特殊宿舍申请
     */
    @PreAuthorize("@ss.hasPermi('apartment:approval:add')")
    @Log(title = "特殊宿舍申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FzuSpecialdormApproval fzuSpecialdormApproval)
    {
        return toAjax(fzuSpecialdormApprovalService.insertFzuSpecialdormApproval(fzuSpecialdormApproval));
    }

    /**
     * 修改特殊宿舍申请
     */
    @PreAuthorize("@ss.hasPermi('apartment:approval:edit')")
    @Log(title = "特殊宿舍申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FzuSpecialdormApproval fzuSpecialdormApproval)
    {
        return toAjax(fzuSpecialdormApprovalService.updateFzuSpecialdormApproval(fzuSpecialdormApproval));
    }

    /**
     * 删除特殊宿舍申请
     */
    @PreAuthorize("@ss.hasPermi('apartment:approval:remove')")
    @Log(title = "特殊宿舍申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{approvalIds}")
    public AjaxResult remove(@PathVariable Long[] approvalIds)
    {
        return toAjax(fzuSpecialdormApprovalService.deleteFzuSpecialdormApprovalByApprovalIds(approvalIds));
    }

    /**
     * 根据指定角色类型获取用户列表
     */
    @PostMapping("/getRoleList")
    public TableDataInfo selectUserListByRoleId(Long fdyRoleId, Long xgcRoleId, Long xqglRoleId, Long deptId)
    {
        SysUser sysUser1 = new SysUser();
        sysUser1.setRoleId(fdyRoleId);
        sysUser1.setDeptId(deptId);
        List<SysUser> sysUserList1 = fzuSpecialdormApprovalService.selectUserListByRoleId(sysUser1);
        SysUser sysUser2 = new SysUser();
        sysUser2.setRoleId(xgcRoleId);
        List<SysUser> sysUserList2 = fzuSpecialdormApprovalService.selectUserListByRoleId(sysUser2);
        SysUser sysUser3 = new SysUser();
        sysUser3.setRoleId(xqglRoleId);
        List<SysUser> sysUserList3 = fzuSpecialdormApprovalService.selectUserListByRoleId(sysUser3);
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(sysUserList1);
        arrayList.add(sysUserList2);
        arrayList.add(sysUserList3);
        return getDataTable(arrayList);
    }

    /**
     * 添加student_dorm数据
     */
    @PostMapping("/addStudentDorm")
    public AjaxResult addStudentDorm(@RequestBody FzuDormitoryInfo fzuDormitoryInfo) {
        int i = fzuSpecialdormApprovalService.insertFzuStudentDormitory(fzuDormitoryInfo);
        if (i > 0){
            return toAjax(i);
        }else{
            return error("该床位不为空，请检查填写信息是否正确！");
        }
    }

    /**
     * 获取宿舍详细信息
     */
    @GetMapping(value = "/getStudentDorm/{dormId}")
    public AjaxResult getStudentDorm(@PathVariable("dormId") Long dormId)
    {
        return success(fzuStuDormitoryService.selectFzuStuDormitoryByDormId(dormId));
    }

    /**
     * 修改宿舍
     */
    @PutMapping("/updateStudentdorm")
    public AjaxResult updateStudentdorm(@RequestBody FzuStuDormitory fzuStuDormitory)
    {
        int i = fzuStuDormitoryService.updateFzuStuDormitory(fzuStuDormitory);
        if(i>0){
            return toAjax(i);
        }else {
            return warn("数据修改失败，请重新检查输入信息！");
        }
    }

    /**
     * 查询宿舍列表
     */
    @GetMapping("/listStudentdorm")
    public TableDataInfo listStudentdorm(FzuStuDormitory fzuStuDormitory)
    {
        List<FzuStuDormitory> list = fzuStuDormitoryService.selectFzuStuDormitoryList(fzuStuDormitory);
        return getDataTable(list);
    }

    /**
     * 获取用户信息详细信息
     */
    @GetMapping(value = "/getUser/{userId}")
    public AjaxResult getUser(@PathVariable("userId") Long userId)
    {
        return success(fzuSpecialdormApprovalService.selectSysUserByUserId(userId));
    }
}
