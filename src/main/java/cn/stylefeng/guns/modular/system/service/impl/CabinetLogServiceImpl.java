package cn.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.*;
import cn.stylefeng.guns.modular.system.dao.*;
import cn.stylefeng.guns.modular.system.model.*;
import cn.stylefeng.guns.modular.system.service.*;
import org.springframework.stereotype.*;
import javax.annotation.*;
import com.baomidou.mybatisplus.plugins.*;
import java.util.*;

@Service
public class CabinetLogServiceImpl extends ServiceImpl<CabinetLogMapper, CabinetLog> implements ICabinetLogService
{
    @Resource
    private CabinetLogMapper cabinetLogMapper;
    
    public List<Map<String, Object>> list(final Page<Map<String, Object>> page, final String cabinetCode) {
        return (List<Map<String, Object>>)this.cabinetLogMapper.list((Page)page, cabinetCode);
    }
}
