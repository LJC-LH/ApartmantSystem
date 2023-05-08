package com.ruoyi.apartment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.apartment.domain.FzuCompleteOrders;
import com.ruoyi.apartment.domain.FzuDormitoryInfo;
import com.ruoyi.apartment.service.FzuFilesService;
import com.ruoyi.apartment.service.IFzuSysUserService;
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
import com.ruoyi.apartment.domain.RepairResult;
import com.ruoyi.apartment.service.IRepairResultService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 维修结果提交Controller
 *
 * @author ljc
 * @date 2023-04-24
 */
@RestController
@RequestMapping("/apartment/repairResult")
public class RepairResultController extends BaseController
{
    @Autowired
    private IRepairResultService repairResultService;

    @Autowired
    private FzuFilesService fzuFilesService;

    @Autowired
    private IFzuSysUserService fzuSysUserService;

    /**
     * 查询维修结果提交列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairResult:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepairResult repairResult)
    {
        startPage();
        repairResult.setFirstRepairmanId(SecurityUtils.getUserId());
        List<FzuCompleteOrders> list = repairResultService.selectRepairResultList(repairResult);
        return getDataTable(list);
    }

    /**
     * 导出维修结果提交列表
     */
//    @PreAuthorize("@ss.hasPermi('apartment:repairResult:export')")
//    @Log(title = "维修结果提交", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, RepairResult repairResult)
//    {
//        List<RepairResult> list = repairResultService.selectRepairResultList(repairResult);
//        ExcelUtil<RepairResult> util = new ExcelUtil<RepairResult>(RepairResult.class);
//        util.exportExcel(response, list, "维修结果提交数据");
//    }

    /**
     * 获取维修结果提交详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairResult:query')")
    @GetMapping(value = "/{repairId}")
    public AjaxResult getInfo(@PathVariable("repairId") Long repairId)
    {
        return success(repairResultService.selectRepairResultByRepairId(repairId));
    }

    /**
     * 新增到图片保存数据库
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairResult:add')")
    @Log(title = "维修结果提交", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepairResult repairResult)
    {
        return toAjax(1);
    }

    /**
     * 修改订单信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairResult:edit')")
    @Log(title = "维修结果提交", businessType = BusinessType.UPDATE)
    @PutMapping("/solvable")
    public AjaxResult edit(@RequestBody FzuCompleteOrders fzuCompleteOrders)
    {
        /*
        * 需要判断的是订单的状态，维修情况说明的位置
        * 如果无法维修，则将订单状态改为3
        * 如果可以维修，分别对应第一次完成和第二次完成
        * TODO：时间戳还没设定
        * */
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimeStr = now.format(formatter);
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(formattedTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        fzuCompleteOrders.setFixStatus("4");
        if (Objects.equals(fzuCompleteOrders.getIsSecondDispatch(), "0")) {
            fzuCompleteOrders.setFirstRepairmanId(SecurityUtils.getUserId());
            fzuCompleteOrders.setFirstCompletionTime(date);
            repairResultService.changeFirstOrder(fzuCompleteOrders);
            fzuFilesService.setFirstRepairmanImage(fzuCompleteOrders);
        } else if (Objects.equals(fzuCompleteOrders.getIsSecondDispatch(), "1")) {
            fzuCompleteOrders.setSecondaryRepairmanId(SecurityUtils.getUserId());
            fzuCompleteOrders.setSecondActualCompletionTime(date);
            repairResultService.changeSecondOrder(fzuCompleteOrders);
            fzuFilesService.setSecondRepairmanImage(fzuCompleteOrders);
        }
        return toAjax(1);
    }

    /*
    * 处理不了的订单
    * */
    @PreAuthorize("@ss.hasPermi('apartment:repairResult:edit')")
    @Log(title = "维修结果提交", businessType = BusinessType.UPDATE)
    @PutMapping("/unsolvable")
    public AjaxResult unsolvable(@RequestBody FzuCompleteOrders fzuCompleteOrders)
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimeStr = now.format(formatter);
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(formattedTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        fzuCompleteOrders.setFirstCompletionTime(date);
        fzuCompleteOrders.setFixStatus("0");
        repairResultService.changeUnsolvableOrder(fzuCompleteOrders);
        fzuFilesService.setFirstRepairmanImage(fzuCompleteOrders);
        return toAjax(1);
    }

    /**
     * 删除维修结果提交
     */
    @PreAuthorize("@ss.hasPermi('apartment:repairResult:remove')")
    @Log(title = "维修结果提交", businessType = BusinessType.DELETE)
	@DeleteMapping("/{repairIds}")
    public AjaxResult remove(@PathVariable Long[] repairIds)
    {
        return toAjax(repairResultService.deleteRepairResultByRepairIds(repairIds));
    }

}
