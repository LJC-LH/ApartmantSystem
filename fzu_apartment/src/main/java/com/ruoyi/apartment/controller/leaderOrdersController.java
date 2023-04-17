package com.ruoyi.apartment.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.apartment.domain.FzuCompleteOrders;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.apartment.domain.leaderOrders;
import com.ruoyi.apartment.service.IleaderOrdersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 领导订单表Controller
 * 
 * @author ruoyi
 * @date 2023-04-05
 */
@RestController
@RequestMapping("/apartment/leaderOrders")
public class leaderOrdersController extends BaseController
{
    @Autowired
    private IleaderOrdersService leaderOrdersService;

    /**
     * 查询领导订单表列表
     */
    @PreAuthorize("@ss.hasPermi('apartment:leaderOrders:list')")
    @GetMapping("/list")
    public TableDataInfo list(leaderOrders leaderOrders)
    {
        startPage();
        List<FzuCompleteOrders> list = leaderOrdersService.selectleaderOrdersList(leaderOrders);
        return getDataTable(list);
    }

//    TODO
//    /**
//     * 导出领导订单表列表
//     */
//    @PreAuthorize("@ss.hasPermi('apartment:leaderOrders:export')")
//    @Log(title = "领导订单表", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, leaderOrders leaderOrders)
//    {
//        List<FzuCompleteOrders> list = leaderOrdersService.selectleaderOrdersList(leaderOrders);
//        ExcelUtil<leaderOrders> util = new ExcelUtil<leaderOrders>(leaderOrders.class);
//        util.exportExcel(response, list, "领导订单表数据");
//    }

    /**
     * 获取领导订单表详细信息
     */
    @PreAuthorize("@ss.hasPermi('apartment:leaderOrders:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(leaderOrdersService.selectleaderOrdersById(id));
    }

    /**
     * 新增领导订单表
     */
    @PreAuthorize("@ss.hasPermi('apartment:leaderOrders:add')")
    @Log(title = "领导订单表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody leaderOrders leaderOrders)
    {
        return toAjax(leaderOrdersService.insertleaderOrders(leaderOrders));
    }

    /**
     * 修改领导订单表
     */
    @PreAuthorize("@ss.hasPermi('apartment:leaderOrders:edit')")
    @Log(title = "领导订单表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody leaderOrders leaderOrders)
    {
        return toAjax(leaderOrdersService.updateleaderOrders(leaderOrders));
    }

    /**
     * 删除领导订单表
     */
    @PreAuthorize("@ss.hasPermi('apartment:leaderOrders:remove')")
    @Log(title = "领导订单表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(leaderOrdersService.deleteleaderOrdersByIds(ids));
    }

    /**
     * 头像上传，路径没有确定号
     * TODO：文件路径
     */
    @Log(title = "图片", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadImages")
    public AjaxResult avatar(@RequestParam("data") MultipartFile[] files) throws Exception
    {
        /*
        * TODO：缺少返回的封装ajax消息
        * */
        AjaxResult ajax = AjaxResult.success();
        for (MultipartFile file : files) {
            FileUploadUtils.upload("D:\\testUploadImages", file, MimeTypeUtils.IMAGE_EXTENSION);
//            ajax.put()
        }
        return ajax;
    }
}
