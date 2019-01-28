package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.*;
import org.springframework.stereotype.*;
import cn.stylefeng.guns.modular.system.service.*;
import org.springframework.beans.factory.annotation.*;
import cn.stylefeng.guns.core.common.constant.factory.*;
import cn.stylefeng.guns.core.common.page.*;
import com.baomidou.mybatisplus.plugins.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({ "/cabinetLog" })
public class CabinetLogController extends BaseController
{
    private String PREFIX;
    @Autowired
    private ICabinetLogService cabinetLogService;
    
    public CabinetLogController() {
        this.PREFIX = "/system/cabinetLog/";
    }
    
    @RequestMapping({ "" })
    public String index() {
        return this.PREFIX + "cabinetLog.html";
    }
    
    @RequestMapping({ "/list" })
    @ResponseBody
    public Object list(@RequestParam(required = false) final String cabinetCode) {
        final Page<Map<String, Object>> page = (Page<Map<String, Object>>)new PageFactory().defaultPage();
        final List<Map<String, Object>> result = this.cabinetLogService.list(page, cabinetCode);
        page.setRecords((List)result);
        return new PageInfoBT((Page)page);
    }
}
