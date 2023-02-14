package com.ruoyi.apartment.conctoller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.apartment.domain.FzuStuDormitory;
import com.ruoyi.apartment.service.IFzuStuDormitoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍Controller
 * 
 * @author ruoyi
 * @date 2023-02-14
 */
@RestController
@RequestMapping("/apartment/studentdorm")
public class FzuStuDormitoryController extends BaseController
{
    @Autowired
    private IFzuStuDormitoryService fzuStuDormitoryService;

    /**
     * 查询宿舍列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:studentdorm:list')")
    @GetMapping("/list")
    public TableDataInfo list(FzuStuDormitory fzuStuDormitory)
    {
        startPage();
        String username = SecurityUtils.getUsername();
        List<FzuStuDormitory> list = fzuStuDormitoryService.selectFzuStuDormitoryList("222210141");
        return getDataTable(list);
    }

//    /**
//     * 导出宿舍列表
//     */
//    @PreAuthorize("@ss.hasPermi('apartment:studentdorm:export')")
//    @Log(title = "宿舍", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, FzuStuDormitory fzuStuDormitory)
//    {
//        List<FzuStuDormitory> list = fzuStuDormitoryService.selectFzuStuDormitoryList(fzuStuDormitory);
//        ExcelUtil<FzuStuDormitory> util = new ExcelUtil<FzuStuDormitory>(FzuStuDormitory.class);
//        util.exportExcel(response, list, "宿舍数据");
//    }

    /**
     * 获取宿舍详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:studentdorm:query')")
    @GetMapping(value = "/{dormId}")
    public AjaxResult getInfo(@PathVariable("dormId") Long dormId)
    {
        return success(fzuStuDormitoryService.selectFzuStuDormitoryByDormId(dormId));
    }

    /**
     * 新增宿舍
     */
    @PreAuthorize("@ss.hasPermi('apartment:studentdorm:add')")
    @Log(title = "宿舍", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FzuStuDormitory fzuStuDormitory)
    {
        return toAjax(fzuStuDormitoryService.insertFzuStuDormitory(fzuStuDormitory));
    }

    /**
     * 修改宿舍
     */
    @PreAuthorize("@ss.hasPermi('apartment:studentdorm:edit')")
    @Log(title = "宿舍", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FzuStuDormitory fzuStuDormitory)
    {
        return toAjax(fzuStuDormitoryService.updateFzuStuDormitory(fzuStuDormitory));
    }

    /**
     * 删除宿舍
     */
    @PreAuthorize("@ss.hasPermi('apartment:studentdorm:remove')")
    @Log(title = "宿舍", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dormIds}")
    public AjaxResult remove(@PathVariable Long[] dormIds)
    {
        return toAjax(fzuStuDormitoryService.deleteFzuStuDormitoryByDormIds(dormIds));
    }
}
