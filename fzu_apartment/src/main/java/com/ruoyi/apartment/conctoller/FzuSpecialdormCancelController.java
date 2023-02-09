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
import com.ruoyi.apartment.domain.FzuSpecialdormCancel;
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

    /**
     * 新增特殊退宿申请
     */
    @PreAuthorize("@ss.hasPermi('apartment:cancel:add')")
    @Log(title = "特殊退宿申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FzuSpecialdormCancel fzuSpecialdormCancel)
    {
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
}
