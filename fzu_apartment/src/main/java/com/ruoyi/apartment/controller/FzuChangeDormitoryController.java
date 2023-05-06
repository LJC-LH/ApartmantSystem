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
import com.ruoyi.apartment.domain.FzuChangeDormitory;
import com.ruoyi.apartment.service.IFzuChangeDormitoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍调整Controller
 *
 * @author ljc
 * @date 2023-04-24
 */
@RestController
@RequestMapping("/apartment/changeDorm")
public class FzuChangeDormitoryController extends BaseController
{
    @Autowired
    private IFzuChangeDormitoryService fzuChangeDormitoryService;

    /**
     * 查询宿舍调整列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:changeDorm:list')")
    @GetMapping("/list")
    public TableDataInfo list(FzuChangeDormitory fzuChangeDormitory)
    {
        startPage();
        List<FzuChangeDormitory> list = fzuChangeDormitoryService.selectFzuChangeDormitoryList(fzuChangeDormitory);
        return getDataTable(list);
    }

    /**
     * 导出宿舍调整列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:changeDorm:export')")
    @Log(title = "宿舍调整", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FzuChangeDormitory fzuChangeDormitory)
    {
        List<FzuChangeDormitory> list = fzuChangeDormitoryService.selectFzuChangeDormitoryList(fzuChangeDormitory);
        ExcelUtil<FzuChangeDormitory> util = new ExcelUtil<FzuChangeDormitory>(FzuChangeDormitory.class);
        util.exportExcel(response, list, "宿舍调整数据");
    }

    /**
     * 获取宿舍调整详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:changeDorm:query')")
    @GetMapping(value = "/{changeId}")
    public AjaxResult getInfo(@PathVariable("changeId") Long changeId)
    {
        return success(fzuChangeDormitoryService.selectFzuChangeDormitoryByChangeId(changeId));
    }

    /**
     * 新增宿舍调整
     */
    @PreAuthorize("@ss.hasPermi('apartment:changeDorm:add')")
    @Log(title = "宿舍调整", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FzuChangeDormitory fzuChangeDormitory)
    {
        int i = fzuChangeDormitoryService.insertFzuChangeDormitory(fzuChangeDormitory);
        if( i == -3){
            return error("请重新检查信息，填写数据异常");
        }
        else if( i == -2){
            return error("请重新检查信息，换入宿舍床位不为空");
        }
        else if(i == -1){
            return error("请重新检查信息，学生与宿舍信息不符");
        }
        else if (i == 0){
            return error("请重新检查信息，存在跨学院操作");
        }else{
            return toAjax(i);
        }
    }

    /**
     * 修改宿舍调整
     */
    @PreAuthorize("@ss.hasPermi('apartment:changeDorm:edit')")
    @Log(title = "宿舍调整", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FzuChangeDormitory fzuChangeDormitory)
    {
        return toAjax(fzuChangeDormitoryService.updateFzuChangeDormitory(fzuChangeDormitory));
    }

    /**
     * 删除宿舍调整
     */
    @PreAuthorize("@ss.hasPermi('apartment:changeDorm:remove')")
    @Log(title = "宿舍调整", businessType = BusinessType.DELETE)
	@DeleteMapping("/{changeIds}")
    public AjaxResult remove(@PathVariable Long[] changeIds)
    {
        return toAjax(fzuChangeDormitoryService.deleteFzuChangeDormitoryByChangeIds(changeIds));
    }
}
