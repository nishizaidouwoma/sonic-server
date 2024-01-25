package org.cloud.sonic.controller.models.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Schema(name ="DevicesLog对象", description = "")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("devices_log")
@TableComment("设备使用表")
@TableCharset(MySqlCharsetConstant.DEFAULT)
@TableEngine(MySqlEngineConstant.InnoDB)
public class DevicesLog {
  @TableId(value = "id", type = IdType.AUTO)
  @IsAutoIncrement
  private Integer id ;
  @TableField
  @Column(value = "devices_id", isNull = false, comment = "设备ID")
  private String devicesId;
  @TableField
  private String user;

  @Schema(description = "最后修改日期",  example = "2021-08-15 11:10:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField
  @Column(value = "create_time", type = MySqlTypeConstant.DATETIME,  comment = "控制时间")
  private Date createTime;
  @Schema(description = "最后修改日期", example = "2021-08-15 11:10:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @TableField
  @Column(value = "edit_time", type = MySqlTypeConstant.DATETIME, comment = "退出时间")
  private Date editTime;
}
