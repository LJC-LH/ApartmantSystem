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
import com.ruoyi.apartment.domain.stuOrders;
import com.ruoyi.apartment.service.IstuOrdersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生订单Controller
 * 
 * @author ruoyi
 * @date 2023-04-04
 */
@RestController
@RequestMapping("/apartment/stuOrders")
public class stuOrdersController extends BaseController
{
    @Autowired
    private IstuOrdersService stuOrdersService;

    /**
     * 查询学生订单列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:stuOrders:list')")
    @GetMapping("/list")
    public TableDataInfo list(stuOrders stuOrders)
    {
        startPage();
        List<stuOrders> list = stuOrdersService.selectstuOrdersList(stuOrders);
        return getDataTable(list);
    }

    /**
     * 导出学生订单列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:stuOrders:export')")
    @Log(title = "学生订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, stuOrders stuOrders)
    {
        List<stuOrders> list = stuOrdersService.selectstuOrdersList(stuOrders);
        ExcelUtil<stuOrders> util = new ExcelUtil<stuOrders>(stuOrders.class);
        util.exportExcel(response, list, "学生订单数据");
    }

    /**
     * 获取学生订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:stuOrders:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuOrdersService.selectstuOrdersById(id));
    }

    /**
     * 新增学生订单
     */
    @PreAuthorize("@ss.hasPermi('apartment:stuOrders:add')")
    @Log(title = "学生订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody stuOrders stuOrders)
    {
        return toAjax(stuOrdersService.insertstuOrders(stuOrders));
    }

    /**
     * 修改学生订单
     */
    @PreAuthorize("@ss.hasPermi('apartment:stuOrders:edit')")
    @Log(title = "学生订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody stuOrders stuOrders)
    {
        return toAjax(stuOrdersService.updatestuOrders(stuOrders));
    }

    /**
     * 删除学生订单
     */
    @PreAuthorize("@ss.hasPermi('apartment:stuOrders:remove')")
    @Log(title = "学生订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuOrdersService.deletestuOrdersByIds(ids));
    }
}
