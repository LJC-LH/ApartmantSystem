package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.apartment.domain.FzuDormitoryInfo;
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
import com.ruoyi.system.domain.FzuStudentDormitory;
import com.ruoyi.system.service.IFzuStudentDormitoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/system/student_dormitory")
public class FzuStudentDormitoryController extends BaseController
{
    @Autowired
    private IFzuStudentDormitoryService fzuStudentDormitoryService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:dormitory:list')")
    @GetMapping("/list")
    public TableDataInfo list(FzuStudentDormitory fzuStudentDormitory)
    {
        startPage();
        List<FzuStudentDormitory> list = fzuStudentDormitoryService.selectFzuStudentDormitoryList(fzuStudentDormitory);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:dormitory:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FzuStudentDormitory fzuStudentDormitory)
    {
        List<FzuStudentDormitory> list = fzuStudentDormitoryService.selectFzuStudentDormitoryList(fzuStudentDormitory);
        ExcelUtil<FzuStudentDormitory> util = new ExcelUtil<FzuStudentDormitory>(FzuStudentDormitory.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dormitory:query')")
    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return success(fzuStudentDormitoryService.selectFzuStudentDormitoryByStudentId(studentId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:dormitory:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FzuDormitoryInfo fzuDormitoryInfo)
    {
        return toAjax(fzuStudentDormitoryService.insertFzuStudentDormitory(fzuDormitoryInfo));
    }

//    /**
//     * 修改【请填写功能名称】
//     */
//    @PreAuthorize("@ss.hasPermi('system:dormitory:edit')")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@RequestBody FzuStudentDormitory fzuStudentDormitory)
//    {
//        return toAjax(fzuStudentDormitoryService.updateFzuStudentDormitory(fzuStudentDormitory));
//    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:dormitory:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable Long[] studentIds)
    {
        return toAjax(fzuStudentDormitoryService.deleteFzuStudentDormitoryByStudentIds(studentIds));
    }
}
