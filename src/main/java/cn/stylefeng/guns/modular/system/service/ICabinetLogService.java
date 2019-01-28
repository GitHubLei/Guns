package cn.stylefeng.guns.modular.system.service;

import com.baomidou.mybatisplus.service.*;
import cn.stylefeng.guns.modular.system.model.*;
import com.baomidou.mybatisplus.plugins.*;
import java.util.*;

public interface ICabinetLogService extends IService<CabinetLog>
{
    List<Map<String, Object>> list(final Page<Map<String, Object>> p0, final String p1);
}
