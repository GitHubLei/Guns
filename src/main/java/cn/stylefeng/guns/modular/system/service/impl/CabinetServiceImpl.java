package cn.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.*;
import cn.stylefeng.guns.modular.system.dao.*;
import cn.stylefeng.guns.modular.system.model.*;
import cn.stylefeng.guns.modular.system.service.*;
import org.springframework.stereotype.*;
import javax.annotation.*;
import org.springframework.transaction.annotation.*;
import com.baomidou.mybatisplus.plugins.*;
import java.util.*;

@Service("iCabinetService")
public class CabinetServiceImpl extends ServiceImpl<CabinetMapper, Cabinet> implements ICabinetService
{
    @Resource
    private CabinetMapper cabinetMapper;
    
    @Transactional
    public void saveOrUpdateCabinetInfo(final String content) {
        final String[] strs = content.split(";");
        final String cabinetCode = strs[0];
        final char[] boxs = strs[1].toCharArray();
        final Cabinet param = new Cabinet();
        param.setCabinetCode(cabinetCode);
        final List<Cabinet> list = new ArrayList<Cabinet>();
        for (int i = 0, j = 1; i < 32; i += 4, ++j) {
            final Cabinet cabinet = new Cabinet();
            cabinet.setCabinetCode(cabinetCode);
            cabinet.setDoorCode("LEFT-" + j);
            cabinet.setBoxCode("LEFT-" + j);
            cabinet.setLocker(Integer.valueOf(Character.toString(boxs[i])));
            cabinet.setStatus(Integer.valueOf(Character.toString(boxs[i + 1])));
            cabinet.setCreateTime(new Date());
            cabinet.setVersion(new Date());
            list.add(cabinet);
        }
        for (int i = 36, j = 1; i <= 128; i += 4, ++j) {
            final Cabinet cabinet = new Cabinet();
            cabinet.setCabinetCode(cabinetCode);
            cabinet.setDoorCode("RIGHT");
            cabinet.setBoxCode("RIGHT-" + j);
            cabinet.setLocker(Integer.valueOf(Character.toString(boxs[32])));
            cabinet.setStatus(Integer.valueOf(Character.toString(boxs[i])));
            cabinet.setCreateTime(new Date());
            cabinet.setVersion(new Date());
            list.add(cabinet);
        }
        for (final Cabinet cabinet2 : list) {
            final Cabinet params = new Cabinet();
            params.setBoxCode(cabinet2.getBoxCode());
            params.setCabinetCode(cabinet2.getCabinetCode());
            params.setDoorCode(cabinet2.getDoorCode());
            final Cabinet temp = (Cabinet)this.cabinetMapper.selectOne(params);
            if (temp == null) {
                this.cabinetMapper.insert(cabinet2);
            }
            else {
                temp.setLocker(cabinet2.getLocker());
                temp.setStatus(cabinet2.getStatus());
                this.cabinetMapper.updateAllColumnById(temp);
            }
        }
    }
    
    public List<Map<String, Object>> list(final Page<Map<String, Object>> page, final String cabinetCode) {
        return (List<Map<String, Object>>)((CabinetMapper)this.baseMapper).list((Page)page, cabinetCode);
    }
    
    public List<Map<String, Object>> cabinetCodeList() {
        return (List<Map<String, Object>>)((CabinetMapper)this.baseMapper).cabinetCodeList();
    }
}
