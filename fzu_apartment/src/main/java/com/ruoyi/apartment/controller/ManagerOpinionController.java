package com.ruoyi.apartment.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.apartment.service.IFirstSelectRepairmanService;
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
import com.ruoyi.apartment.domain.ManagerOpinion;
import com.ruoyi.apartment.service.IManagerOpinionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 领导审批Controller
 *
 * @author ljc
 * @date 2023-04-24
 */
@RestController
@RequestMapping("/apartment/managerOpinion")
public class ManagerOpinionController extends BaseController
{
    @Autowired
    private IManagerOpinionService managerOpinionService;

    @Autowired
    private IFirstSelectRepairmanService firstSelectRepairmanService;

    /**
     * 查询领导审批列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:managerOpinion:list')")
    @GetMapping("/list")
    public TableDataInfo list(ManagerOpinion managerOpinion)
    {
        startPage();
        List<ManagerOpinion> list = managerOpinionService.selectManagerOpinionList(managerOpinion);
        return getDataTable(list);
    }

    /**
     * 导出领导审批列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:managerOpinion:export')")
    @Log(title = "领导审批", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ManagerOpinion managerOpinion)
    {
        List<ManagerOpinion> list = managerOpinionService.selectManagerOpinionList(managerOpinion);
        ExcelUtil<ManagerOpinion> util = new ExcelUtil<ManagerOpinion>(ManagerOpinion.class);
        util.exportExcel(response, list, "领导审批数据");
    }

    /**
     * 获取领导审批详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:managerOpinion:query')")
    @GetMapping(value = "/{repairId}")
    public AjaxResult getInfo(@PathVariable("repairId") Long repairId)
    {
        return success(managerOpinionService.selectManagerOpinionByRepairId(repairId));
    }

    /**
     * 新增领导审批
     */
    @PreAuthorize("@ss.hasPermi('apartment:managerOpinion:add')")
    @Log(title = "领导审批", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ManagerOpinion managerOpinion)
    {
        return toAjax(managerOpinionService.insertManagerOpinion(managerOpinion));
    }

    /**
     * 修改领导审批
     */
    @PreAuthorize("@ss.hasPermi('apartment:managerOpinion:edit')")
    @Log(title = "领导审批", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ManagerOpinion managerOpinion)
    {
        return toAjax(managerOpinionService.updateManagerOpinion(managerOpinion));
    }

    /**
     * 删除领导审批
     */
    @PreAuthorize("@ss.hasPermi('apartment:managerOpinion:remove')")
    @Log(title = "领导审批", businessType = BusinessType.DELETE)
    @DeleteMapping("/{repairIds}")
    public AjaxResult remove(@PathVariable Long[] repairIds)
    {
        return toAjax(managerOpinionService.deleteManagerOpinionByRepairIds(repairIds));
    }

    /**
     * 根据角色ID查询用户信息
     */
//    @PreAuthorize("@ss.hasPermi('apartment:firstSelectRepairman:selectUserByRoleId')")
    @GetMapping("/selectUserByRoleId/{roleId}")
    public List<SysUser> selectUserByRoleId(@PathVariable("roleId") Long roleId) {
        return firstSelectRepairmanService.selectUserByRoleId(roleId);
    }
}