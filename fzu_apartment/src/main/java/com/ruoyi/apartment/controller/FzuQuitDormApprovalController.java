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
import com.ruoyi.apartment.domain.FzuQuitDormApproval;
import com.ruoyi.apartment.service.IFzuQuitDormApprovalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 休学宿舍退宿Controller
 * 
 * @author ljc
 * @date 2023-04-26
 */
@RestController
@RequestMapping("/apartment/quitDormApproval")
public class FzuQuitDormApprovalController extends BaseController
{
    @Autowired
    private IFzuQuitDormApprovalService fzuQuitDormApprovalService;

    /**
     * 查询休学宿舍退宿列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:quitDormApproval:list')")
    @GetMapping("/list")
    public TableDataInfo list(FzuQuitDormApproval fzuQuitDormApproval)
    {
        startPage();
        List<FzuQuitDormApproval> list = fzuQuitDormApprovalService.selectFzuQuitDormApprovalList(fzuQuitDormApproval);
        return getDataTable(list);
    }

    /**
     * 导出休学宿舍退宿列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:quitDormApproval:export')")
    @Log(title = "休学宿舍退宿", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FzuQuitDormApproval fzuQuitDormApproval)
    {
        List<FzuQuitDormApproval> list = fzuQuitDormApprovalService.selectFzuQuitDormApprovalList(fzuQuitDormApproval);
        ExcelUtil<FzuQuitDormApproval> util = new ExcelUtil<FzuQuitDormApproval>(FzuQuitDormApproval.class);
        util.exportExcel(response, list, "休学宿舍退宿数据");
    }

    /**
     * 获取休学宿舍退宿详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:quitDormApproval:query')")
    @GetMapping(value = "/{quitId}")
    public AjaxResult getInfo(@PathVariable("quitId") Long quitId)
    {
        return success(fzuQuitDormApprovalService.selectFzuQuitDormApprovalByQuitId(quitId));
    }

    /**
     * 新增休学宿舍退宿
     */
    @PreAuthorize("@ss.hasPermi('apartment:quitDormApproval:add')")
    @Log(title = "休学宿舍退宿", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FzuQuitDormApproval fzuQuitDormApproval)
    {
        return toAjax(fzuQuitDormApprovalService.insertFzuQuitDormApproval(fzuQuitDormApproval));
    }

    /**
     * 修改休学宿舍退宿
     */
    @PreAuthorize("@ss.hasPermi('apartment:quitDormApproval:edit')")
    @Log(title = "休学宿舍退宿", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FzuQuitDormApproval fzuQuitDormApproval)
    {
        return toAjax(fzuQuitDormApprovalService.updateFzuQuitDormApproval(fzuQuitDormApproval));
    }

    /**
     * 删除休学宿舍退宿
     */
    @PreAuthorize("@ss.hasPermi('apartment:quitDormApproval:remove')")
    @Log(title = "休学宿舍退宿", businessType = BusinessType.DELETE)
	@DeleteMapping("/{quitIds}")
    public AjaxResult remove(@PathVariable Long[] quitIds)
    {
        return toAjax(fzuQuitDormApprovalService.deleteFzuQuitDormApprovalByQuitIds(quitIds));
    }

    @GetMapping("/getInfo/{userName}")
    public AjaxResult getInfo(@PathVariable String userName){
        return success(fzuQuitDormApprovalService.getInfo(userName));
    }

    @PostMapping("/deleteAndUpdateDormInfo")
    public AjaxResult deleteAndUpdateDormInfo(@RequestBody FzuQuitDormApproval fzuQuitDormApproval)
    {
        int i = fzuQuitDormApprovalService.deleteAndUpdateDormInfo(fzuQuitDormApproval);
        if(i > 0){
            return success("更新宿舍信息成功");
        }else {
            return error("请不要重复提交，信息已更新");
        }
    }
}
