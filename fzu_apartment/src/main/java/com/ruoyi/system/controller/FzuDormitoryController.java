package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.FzuDormitory;
import com.ruoyi.system.service.IFzuDormitoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/system/dormitory")
public class FzuDormitoryController extends BaseController
{
    @Autowired
    private IFzuDormitoryService fzuDormitoryService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:dormitory:list')")
    @GetMapping("/list")
    public TableDataInfo list(FzuDormitory fzuDormitory)
    {
        startPage();
        List<FzuDormitory> list = fzuDormitoryService.selectFzuDormitoryList(fzuDormitory);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:dormitory:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FzuDormitory fzuDormitory)
    {
        List<FzuDormitory> list = fzuDormitoryService.selectFzuDormitoryList(fzuDormitory);
        ExcelUtil<FzuDormitory> util = new ExcelUtil<FzuDormitory>(FzuDormitory.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dormitory:query')")
    @GetMapping(value = "/{dormId}")
    public AjaxResult getInfo(@PathVariable("dormId") Long dormId)
    {
        return success(fzuDormitoryService.selectFzuDormitoryByDormId(dormId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:dormitory:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FzuDormitory fzuDormitory)
    {
        return toAjax(fzuDormitoryService.insertFzuDormitory(fzuDormitory));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:dormitory:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FzuDormitory fzuDormitory)
    {
        return toAjax(fzuDormitoryService.updateFzuDormitory(fzuDormitory));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:dormitory:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dormIds}")
    public AjaxResult remove(@PathVariable Long[] dormIds)
    {
        return toAjax(fzuDormitoryService.deleteFzuDormitoryByDormIds(dormIds));
    }
}
