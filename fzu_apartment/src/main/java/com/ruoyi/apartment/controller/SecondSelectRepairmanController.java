package com.ruoyi.apartment.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.apartment.service.IFirstSelectRepairmanService;
import com.ruoyi.apartment.service.IRepairResultService;
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
import com.ruoyi.apartment.domain.SecondSelectRepairman;
import com.ruoyi.apartment.service.ISecondSelectRepairmanService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 二次派单Controller
 *
 * @author ljc
 * @date 2023-04-24
 */
@RestController
@RequestMapping("/apartment/secondSelectRepairman")
public class SecondSelectRepairmanController extends BaseController
{
    @Autowired
    private ISecondSelectRepairmanService secondSelectRepairmanService;

    @Autowired
    private IFirstSelectRepairmanService firstSelectRepairmanService;


    /**
     * 查询二次派单列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:secondSelectRepairman:list')")
    @GetMapping("/list")
    public TableDataInfo list(SecondSelectRepairman secondSelectRepairman)
    {
        startPage();
        List<SecondSelectRepairman> list = secondSelectRepairmanService.selectSecondSelectRepairmanList(secondSelectRepairman);
        return getDataTable(list);
    }

    /**
     * 导出二次派单列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:secondSelectRepairman:export')")
    @Log(title = "二次派单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SecondSelectRepairman secondSelectRepairman)
    {
        List<SecondSelectRepairman> list = secondSelectRepairmanService.selectSecondSelectRepairmanList(secondSelectRepairman);
        ExcelUtil<SecondSelectRepairman> util = new ExcelUtil<SecondSelectRepairman>(SecondSelectRepairman.class);
        util.exportExcel(response, list, "二次派单数据");
    }

    /**
     * 获取二次派单详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:secondSelectRepairman:query')")
    @GetMapping(value = "/{repairId}")
    public AjaxResult getInfo(@PathVariable("repairId") Long repairId)
    {
        return success(secondSelectRepairmanService.selectSecondSelectRepairmanByRepairId(repairId));
    }

    /**
     * 新增二次派单
     */
    @PreAuthorize("@ss.hasPermi('apartment:secondSelectRepairman:add')")
    @Log(title = "二次派单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SecondSelectRepairman secondSelectRepairman)
    {
        return toAjax(secondSelectRepairmanService.insertSecondSelectRepairman(secondSelectRepairman));
    }

    /**
     * 修改二次派单
     */
    @PreAuthorize("@ss.hasPermi('apartment:secondSelectRepairman:edit')")
    @Log(title = "二次派单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SecondSelectRepairman secondSelectRepairman)
    {
        return toAjax(secondSelectRepairmanService.updateSecondSelectRepairman(secondSelectRepairman));
    }

    /**
     * 删除二次派单
     */
    @PreAuthorize("@ss.hasPermi('apartment:secondSelectRepairman:remove')")
    @Log(title = "二次派单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{repairIds}")
    public AjaxResult remove(@PathVariable Long[] repairIds)
    {
        return toAjax(secondSelectRepairmanService.deleteSecondSelectRepairmanByRepairIds(repairIds));
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
