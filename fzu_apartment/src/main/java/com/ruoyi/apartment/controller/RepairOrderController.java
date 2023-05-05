package com.ruoyi.apartment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.apartment.domain.FzuCompleteOrders;
import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.service.FzuFilesService;
import com.ruoyi.apartment.service.IFzuSysUserService;
import com.ruoyi.apartment.service.IRepairResultService;
import com.ruoyi.common.utils.SecurityUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.BeanUtils;
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
import com.ruoyi.apartment.domain.RepairOrder;
import com.ruoyi.apartment.service.IRepairOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生报修Controller
 *
 * @author ljc
 * @date 2023-04-23
 */
@RestController
@RequestMapping("/apartment/studentRepairApplication")
public class RepairOrderController extends BaseController
{
    @Autowired
    private IRepairOrderService repairOrderService;

    @Autowired
    private FzuFilesService fzuFilesService;

    @Autowired
    private IRepairResultService repairResultService;


    /**
     * 查询学生报修列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:studentRepairApplication:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepairOrder repairOrder)
    {
        startPage();
//        TODO:筛选条件
        repairOrder.setStudentId(SecurityUtils.getUserId());
        List<RepairOrder> list = repairOrderService.selectRepairOrderList(repairOrder);
        return getDataTable(list);
    }

//    /**
//     * 导出学生报修列表
//     */
//    @PreAuthorize("@ss.hasPermi('apartment:studentRepairApplication:export')")
//    @Log(title = "学生报修", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, RepairOrder repairOrder)
//    {
//        List<RepairOrder> list = repairOrderService.selectRepairOrderList(repairOrder);
//        ExcelUtil<RepairOrder> util = new ExcelUtil<RepairOrder>(RepairOrder.class);
//        util.exportExcel(response, list, "学生报修数据");
//    }

    /**
     * 获取学生报修详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:studentRepairApplication:query')")
    @GetMapping(value = "/{repairId}")
    public AjaxResult getInfo(@PathVariable("repairId") Long repairId)
    {
        return success(repairResultService.selectRepairResultByRepairId(repairId));
    }

    /**
     * 学生新增订单
     */
    @PreAuthorize("@ss.hasPermi('apartment:studentRepairApplication:add')")
    @Log(title = "学生报修", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FzuCompleteOrders fzuCompleteOrders)
    {
        fzuCompleteOrders.setStudentId(SecurityUtils.getUserId());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimeStr = now.format(formatter);
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(formattedTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        fzuCompleteOrders.setCreateAt(date);
        fzuCompleteOrders.setFixStatus("0");
        fzuCompleteOrders.setIsSecondDispatch("0");
        repairOrderService.insertRepairOrder(fzuCompleteOrders);
        fzuFilesService.setStuImage(fzuCompleteOrders);
        return toAjax(1);
    }

    @PreAuthorize("@ss.hasPermi('apartment:studentRepairApplication:query')")
    @PostMapping("/getUser")
    public AjaxResult getInfo()
    {
        return success(repairOrderService.selectInfo(SecurityUtils.getUserId()));
    }

    @PreAuthorize("@ss.hasPermi('apartment:studentRepairApplication:query')")
    @PostMapping("/updateEvaluate")
    public AjaxResult updateEvaluate(@RequestBody FzuCompleteOrders fzuCompleteOrders)
    {
        return success(repairOrderService.updateEvaluate(fzuCompleteOrders));
    }

//    /**
//     * 修改学生报修
//     */
//    @PreAuthorize("@ss.hasPermi('apartment:studentRepairApplication:edit')")
//    @Log(title = "学生报修", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@RequestBody RepairOrder repairOrder)
//    {
//        return toAjax(repairOrderService.updateRepairOrder(repairOrder));
//    }

    /**
     * 删除学生报修
     */
    @PreAuthorize("@ss.hasPermi('apartment:studentRepairApplication:remove')")
    @Log(title = "学生报修", businessType = BusinessType.DELETE)
	@DeleteMapping("/{repairIds}")
    public AjaxResult remove(@PathVariable Long[] repairIds)
    {
        return toAjax(repairOrderService.deleteRepairOrderByRepairIds(repairIds));
    }
}
