package com.ruoyi.apartment.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.domain.FzuStuDormitory;
import com.ruoyi.apartment.domain.entity.FzuSpecialdormCancel;
import com.ruoyi.apartment.service.IFzuSpecialdormApprovalService;
import com.ruoyi.apartment.service.IFzuStuDormitoryService;
import com.ruoyi.apartment.service.IFzuSysUserService;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.apartment.service.IFzuSpecialdormCancelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 特殊退宿申请Controller
 *
 * @author wsh
 * @date 2023-02-09
 */
@RestController
@RequestMapping("/apartment/cancel")
public class FzuSpecialdormCancelController extends BaseController
{
    @Autowired
    private IFzuSpecialdormCancelService fzuSpecialdormCancelService;

    @Autowired
    private IFzuStuDormitoryService fzuStuDormitoryService;

    @Autowired
    private IFzuSpecialdormApprovalService fzuSpecialdormApprovalService;

    /**
     * 查询特殊退宿申请列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:cancel:list')")
    @GetMapping("/list")
    public TableDataInfo list(FzuSpecialdormCancel fzuSpecialdormCancel)
    {
        startPage();
        List<FzuSpecialdormCancel> list = fzuSpecialdormCancelService.selectFzuSpecialdormCancelList(fzuSpecialdormCancel);
        return getDataTable(list);
    }

    /**
     * 导出特殊退宿申请列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:cancel:export')")
    @Log(title = "特殊退宿申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FzuSpecialdormCancel fzuSpecialdormCancel)
    {
        List<FzuSpecialdormCancel> list = fzuSpecialdormCancelService.selectFzuSpecialdormCancelList(fzuSpecialdormCancel);
        ExcelUtil<FzuSpecialdormCancel> util = new ExcelUtil<FzuSpecialdormCancel>(FzuSpecialdormCancel.class);
        util.exportExcel(response, list, "特殊退宿申请数据");
    }

    /**
     * 获取特殊退宿申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:cancel:query')")
    @GetMapping(value = "/{cancelId}")
    public AjaxResult getInfo(@PathVariable("cancelId") Long cancelId)
    {
        return success(fzuSpecialdormCancelService.selectFzuSpecialdormCancelByCancelId(cancelId));
    }

//    /**
//     * 新增特殊退宿申请
//     */
//    @PreAuthorize("@ss.hasPermi('apartment:cancel:add')")
//    @Log(title = "特殊退宿申请", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody FzuSpecialdormCancel fzuSpecialdormCancel)
//    {
//        return toAjax(fzuSpecialdormCancelService.insertFzuSpecialdormCancel(fzuSpecialdormCancel));
//    }
    /**
     * 新增特殊退宿申请
     */
    @PreAuthorize("@ss.hasPermi('apartment:cancel:add')")
    @Log(title = "特殊退宿申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FzuSpecialdormCancel fzuSpecialdormCancel) {
        if (fzuSpecialdormCancelService.hasPendingApplication(fzuSpecialdormCancel.getDormId())) {
            return AjaxResult.error("该床位退宿审批中，请勿重复提交");
        }
        return toAjax(fzuSpecialdormCancelService.insertFzuSpecialdormCancel(fzuSpecialdormCancel));
    }


    /**
     * 修改特殊退宿申请
     */
    @PreAuthorize("@ss.hasPermi('apartment:cancel:edit')")
    @Log(title = "特殊退宿申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FzuSpecialdormCancel fzuSpecialdormCancel)
    {
        return toAjax(fzuSpecialdormCancelService.updateFzuSpecialdormCancel(fzuSpecialdormCancel));
    }

    /**
     * 删除特殊退宿申请
     */
    @PreAuthorize("@ss.hasPermi('apartment:cancel:remove')")
    @Log(title = "特殊退宿申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cancelIds}")
    public AjaxResult remove(@PathVariable Long[] cancelIds)
    {
        return toAjax(fzuSpecialdormCancelService.deleteFzuSpecialdormCancelByCancelIds(cancelIds));
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
        List<SysUser> sysUserList1 = fzuSpecialdormCancelService.selectUserListByRoleId(sysUser1);
        SysUser sysUser2 = new SysUser();
        sysUser2.setRoleId(xgcRoleId);
        List<SysUser> sysUserList2 = fzuSpecialdormCancelService.selectUserListByRoleId(sysUser2);
        SysUser sysUser3 = new SysUser();
        sysUser3.setRoleId(xqglRoleId);
        List<SysUser> sysUserList3 = fzuSpecialdormCancelService.selectUserListByRoleId(sysUser3);
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(sysUserList1);
        arrayList.add(sysUserList2);
        arrayList.add(sysUserList3);
        return getDataTable(arrayList);
    }

    @PostMapping("/getDormId")
    public TableDataInfo selectDormIdByStudentId(Long userId,@RequestParam List<String> dormStatus){
        FzuDormitoryInfo fzuDormitoryInfo = new FzuDormitoryInfo();
        if(userId == null){
            System.out.println("没有收到userId");
        }
        if(dormStatus == null){
            System.out.println("没有收到dormStatus");
        }
        List<FzuDormitoryInfo> list = fzuSpecialdormCancelService.selectDormIdByStudentId(userId, dormStatus);

        // 遍历查询结果，根据 dormStatus 设置 dormType
        for (FzuDormitoryInfo dorm : list) {
            String currentDormStatus = dorm.getDormStatus();
            String dormType;
            if ("3".equals(currentDormStatus) || "4".equals(currentDormStatus)) {
                dormType = "特殊宿舍";
            } else if ("5".equals(currentDormStatus) || "6".equals(currentDormStatus)) {
                dormType = "健康驿站";
            } else {
                dormType = "普通宿舍";
            }
            dorm.setDormType(dormType);

            // 将 dormType 添加到 dormName 中
            String newDormName = dorm.getDormName() + " (" + dormType + ")";
            dorm.setDormName(newDormName);
        }
        return getDataTable(list);
    }

    /**
     * 解除特殊宿舍绑定并更新宿舍状态
     */
    @PostMapping ("/removeAndUpdateStuDorm")
    public AjaxResult removeAndUpdateStuDorm(@RequestBody FzuDormitoryInfo fzuDormitoryInfo)
    {
        int result = fzuSpecialdormCancelService.removeAndUpdateStuDorm(fzuDormitoryInfo);
        if(result > 0){
            return toAjax(result);
        }else{
            return error("解绑失败！");
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

//    @PutMapping("/updateStudentdorm")
//    public AjaxResult updateStudentdorm(@RequestBody FzuStuDormitory fzuStuDormitory)
//    {
//        int i = fzuStuDormitoryService.updateFzuStuDormitory(fzuStuDormitory);
//        if(i>0){
//            return toAjax(i);
//        }else {
//            return warn("数据修改失败，请重新检查输入信息！");
//        }
//    }

    /**
     * 查询宿舍列表
     */
    @GetMapping("/listStudentdorm")
    public TableDataInfo listStudentdorm(FzuStuDormitory fzuStuDormitory)
    {
        startPage();
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
