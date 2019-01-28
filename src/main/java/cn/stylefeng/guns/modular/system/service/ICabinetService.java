package cn.stylefeng.guns.modular.system.service;

import com.baomidou.mybatisplus.service.*;
import cn.stylefeng.guns.modular.system.model.*;
import com.baomidou.mybatisplus.plugins.*;
import java.util.*;

public interface ICabinetService extends IService<Cabinet>
{
    void saveOrUpdateCabinetInfo(final String p0);
    
    List<Map<String, Object>> list(final Page<Map<String, Object>> p0, final String p1);
    
    List<Map<String, Object>> cabinetCodeList();
}
