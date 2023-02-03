package com.ruoyi.apartment.conctoller;



import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author LJC
 * @create 2023-02-03 21:32
 */
@RestController
@RequestMapping("/apartment/data")
public class dataContoller extends BaseController {

    @GetMapping("/list")
    public TableDataInfo list()
    {
        HashMap<String, Object> data1 = new HashMap<>();
        data1.put("name","旗山校区");
        data1.put("value",100);
        HashMap<String, Object> data2 = new HashMap<>();
        data2.put("name","铜盘校区");
        data2.put("value",130);
        HashMap<String, Object> data3 = new HashMap<>();
        data3.put("name","怡山校区");
        data3.put("value",38);
        List<Object> data = new ArrayList<>();
        data.add(data1);
        data.add(data2);
        data.add(data3);
        return getDataTable(data);
    }
}
