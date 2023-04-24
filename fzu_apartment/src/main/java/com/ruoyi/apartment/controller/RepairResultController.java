package com.ruoyi.apartment.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.apartment.domain.RepairResult;
import com.ruoyi.apartment.service.IRepairResultService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 维修结果提交Controller
 * 
 * @author ljc
 * @date 2023-04-24
 */
@RestController
@RequestMapping("/apartment/repairResult")
public class RepairResultController extends BaseController
{
    @Autowired
    private IRepairResultService repairResultService;

    /**
     * 查询维修结果提交列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairResult:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepairResult repairResult)
    {
        startPage();
        List<RepairResult> list = repairResultService.selectRepairResultList(repairResult);
        return getDataTable(list);
    }

    /**
     * 导出维修结果提交列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairResult:export')")
    @Log(title = "维修结果提交", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepairResult repairResult)
    {
        List<RepairResult> list = repairResultService.selectRepairResultList(repairResult);
        ExcelUtil<RepairResult> util = new ExcelUtil<RepairResult>(RepairResult.class);
        util.exportExcel(response, list, "维修结果提交数据");
    }

    /**
     * 获取维修结果提交详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairResult:query')")
    @GetMapping(value = "/{repairId}")
    public AjaxResult getInfo(@PathVariable("repairId") Long repairId)
    {
        return success(repairResultService.selectRepairResultByRepairId(repairId));
    }

    /**
     * 新增维修结果提交
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairResult:add')")
    @Log(title = "维修结果提交", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepairResult repairResult)
    {
        return toAjax(repairResultService.insertRepairResult(repairResult));
    }

    /**
     * 修改维修结果提交
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairResult:edit')")
    @Log(title = "维修结果提交", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepairResult repairResult)
    {
        return toAjax(repairResultService.updateRepairResult(repairResult));
    }

    /**
     * 删除维修结果提交
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairResult:remove')")
    @Log(title = "维修结果提交", businessType = BusinessType.DELETE)
	@DeleteMapping("/{repairIds}")
    public AjaxResult remove(@PathVariable Long[] repairIds)
    {
        return toAjax(repairResultService.deleteRepairResultByRepairIds(repairIds));
    }
}
