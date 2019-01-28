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
@RequestMapping({ "/cabinet" })
public class CabinetController extends BaseController
{
    private static String PREFIX;
    @Autowired
    ICabinetService iCabinetService;
    
    @RequestMapping({ "" })
    public String index() {
        return CabinetController.PREFIX + "cabinet.html";
    }
    
    @RequestMapping({ "/list" })
    @ResponseBody
    public Object list(@RequestParam(required = false) final String cabinetCode) {
        final Page<Map<String, Object>> page = (Page<Map<String, Object>>)new PageFactory().defaultPage();
        page.setSize(32);
        final List<Map<String, Object>> result = this.iCabinetService.list(page, cabinetCode);
        page.setRecords((List)result);
        return new PageInfoBT((Page)page);
    }
    
    @RequestMapping({ "/cabinetCodeList" })
    @ResponseBody
    public Object cabinetCodeList() {
        final List<Map<String, Object>> result = this.iCabinetService.cabinetCodeList();
        return result;
    }
    
    static {
        CabinetController.PREFIX = "/system/cabinet/";
    }
}
