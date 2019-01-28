package cn.stylefeng.guns.modular.system.dao;

import com.baomidou.mybatisplus.mapper.*;
import cn.stylefeng.guns.modular.system.model.*;
import com.baomidou.mybatisplus.plugins.*;
import org.apache.ibatis.annotations.*;
import java.util.*;

public interface CabinetLogMapper extends BaseMapper<CabinetLog>
{
    List<Map<String, Object>> list(@Param("page") final Page<Map<String, Object>> p0, @Param("cabinetCode") final String p1);
}
