package org.cloud.sonic.controller.services;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import org.cloud.sonic.controller.models.domain.DevicesLog;

public interface DevicesLogService extends IService<DevicesLog> {
    DevicesLog findByUdId(String udId);

    void saveDevicesLog(JSONObject jsonObject);
}
