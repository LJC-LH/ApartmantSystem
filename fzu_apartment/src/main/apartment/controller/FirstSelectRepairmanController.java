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
import com.ruoyi.apartment.domain.FirstSelectRepairman;
import com.ruoyi.apartment.service.IFirstSelectRepairmanService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 一次派单Controller
 * 
 * @author ljc
 * @date 2023-04-24
 */
@RestController
@RequestMapping("/apartment/firstSelectRepairman")
public class FirstSelectRepairmanController extends BaseController
{
    @Autowired
    private IFirstSelectRepairmanService firstSelectRepairmanService;

    /**
     * 查询一次派单列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:firstSelectRepairman:list')")
    @GetMapping("/list")
    public TableDataInfo list(FirstSelectRepairman firstSelectRepairman)
    {
        startPage();
        List<FirstSelectRepairman> list = firstSelectRepairmanService.selectFirstSelectRepairmanList(firstSelectRepairman);
        return getDataTable(list);
    }

    /**
     * 导出一次派单列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:firstSelectRepairman:export')")
    @Log(title = "一次派单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FirstSelectRepairman firstSelectRepairman)
    {
        List<FirstSelectRepairman> list = firstSelectRepairmanService.selectFirstSelectRepairmanList(firstSelectRepairman);
        ExcelUtil<FirstSelectRepairman> util = new ExcelUtil<FirstSelectRepairman>(FirstSelectRepairman.class);
        util.exportExcel(response, list, "一次派单数据");
    }

    /**
     * 获取一次派单详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:firstSelectRepairman:query')")
    @GetMapping(value = "/{repairId}")
    public AjaxResult getInfo(@PathVariable("repairId") Long repairId)
    {
        return success(firstSelectRepairmanService.selectFirstSelectRepairmanByRepairId(repairId));
    }

    /**
     * 新增一次派单
     */
    @PreAuthorize("@ss.hasPermi('apartment:firstSelectRepairman:add')")
    @Log(title = "一次派单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FirstSelectRepairman firstSelectRepairman)
    {
        return toAjax(firstSelectRepairmanService.insertFirstSelectRepairman(firstSelectRepairman));
    }

    /**
     * 修改一次派单
     */
    @PreAuthorize("@ss.hasPermi('apartment:firstSelectRepairman:edit')")
    @Log(title = "一次派单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FirstSelectRepairman firstSelectRepairman)
    {
        return toAjax(firstSelectRepairmanService.updateFirstSelectRepairman(firstSelectRepairman));
    }

    /**
     * 删除一次派单
     */
    @PreAuthorize("@ss.hasPermi('apartment:firstSelectRepairman:remove')")
    @Log(title = "一次派单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{repairIds}")
    public AjaxResult remove(@PathVariable Long[] repairIds)
    {
        return toAjax(firstSelectRepairmanService.deleteFirstSelectRepairmanByRepairIds(repairIds));
    }
}
