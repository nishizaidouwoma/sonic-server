package org.cloud.sonic.controller.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.cloud.sonic.controller.models.base.TypeConverter;
import org.cloud.sonic.controller.models.domain.DevicesLog;

import java.io.Serializable;
import java.util.Date;
@Schema(name = "DevicesLogDTO 端模型")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DevicesLogDTO implements Serializable, TypeConverter<DevicesLogDTO, DevicesLog> {
    private Integer id ;
    private String devicesId;
    private String user;
    private Date editTime;
    private Date createTime;
}
