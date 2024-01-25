package org.cloud.sonic.controller.services.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.cloud.sonic.controller.mapper.DevicesLogMapper;
import org.cloud.sonic.controller.models.domain.Devices;
import org.cloud.sonic.controller.models.domain.DevicesLog;
import org.cloud.sonic.controller.models.domain.Users;
import org.cloud.sonic.controller.services.DevicesLogService;
import org.cloud.sonic.controller.services.UsersService;
import org.cloud.sonic.controller.services.impl.base.SonicServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@Slf4j
public class DevicesLogServiceImpl extends SonicServiceImpl<DevicesLogMapper, DevicesLog> implements DevicesLogService {
    @Autowired
    private UsersService usersService;
    @Autowired
    private DevicesServiceImpl devicesService;

    @Override
    public DevicesLog findByUdId(String udId) {
        //.isNull(DevicesLog::getEditTime)
        List<DevicesLog> devicesList = lambdaQuery().eq(DevicesLog::getDevicesId, udId).list();
        if (devicesList.size() > 0) {
            return devicesList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void saveDevicesLog(JSONObject jsonObject) {
        //获得当前登录用户；
        Users users = usersService.getUserInfo(jsonObject.getString("token"));
        DevicesLog dl = findByUdId(String.valueOf(jsonObject.getString("udId")));
        DevicesLog devicesLog =new DevicesLog();
        if(dl !=null){
            BeanUtils.copyProperties(dl, devicesLog);
            devicesLog.setEditTime(new Date());
        }else {
        devicesLog.setUser(users.getUserName());
        devicesLog.setDevicesId(jsonObject.getString("udId"));
        devicesLog.setCreateTime(new Date());
        }
        save(devicesLog);
    }
}
