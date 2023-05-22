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
import com.ruoyi.apartment.domain.RepairExcelOutput;
import com.ruoyi.apartment.service.IRepairExcelOutputService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 维修明细Controller
 * 
 * @author ljc
 * @date 2023-05-22
 */
@RestController
@RequestMapping("/apartment/repairExcelOutput")
public class RepairExcelOutputController extends BaseController
{
    @Autowired
    private IRepairExcelOutputService repairExcelOutputService;

    /**
     * 查询维修明细列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairExcelOutput:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepairExcelOutput repairExcelOutput)
    {
        startPage();
        List<RepairExcelOutput> list = repairExcelOutputService.selectRepairExcelOutputList(repairExcelOutput);
        return getDataTable(list);
    }

    /**
     * 导出维修明细列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairExcelOutput:export')")
    @Log(title = "维修明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RepairExcelOutput repairExcelOutput)
    {
        List<RepairExcelOutput> list = repairExcelOutputService.selectRepairExcelOutputList(repairExcelOutput);
        ExcelUtil<RepairExcelOutput> util = new ExcelUtil<RepairExcelOutput>(RepairExcelOutput.class);
        util.exportExcel(response, list, "维修明细数据");
    }

    /**
     * 获取维修明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairExcelOutput:query')")
    @GetMapping(value = "/{repairId}")
    public AjaxResult getInfo(@PathVariable("repairId") Long repairId)
    {
        return success(repairExcelOutputService.selectRepairExcelOutputByRepairId(repairId));
    }

    /**
     * 新增维修明细
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairExcelOutput:add')")
    @Log(title = "维修明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepairExcelOutput repairExcelOutput)
    {
        return toAjax(repairExcelOutputService.insertRepairExcelOutput(repairExcelOutput));
    }

    /**
     * 修改维修明细
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairExcelOutput:edit')")
    @Log(title = "维修明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepairExcelOutput repairExcelOutput)
    {
        return toAjax(repairExcelOutputService.updateRepairExcelOutput(repairExcelOutput));
    }

    /**
     * 删除维修明细
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairExcelOutput:remove')")
    @Log(title = "维修明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{repairIds}")
    public AjaxResult remove(@PathVariable Long[] repairIds)
    {
        return toAjax(repairExcelOutputService.deleteRepairExcelOutputByRepairIds(repairIds));
    }
}
