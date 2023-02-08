package com.ruoyi.apartment.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.apartment.domain.entity.FzuSpecialdormApproval;
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
import com.ruoyi.apartment.domain.entity.FzuSpecialdormApproval;
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
}
