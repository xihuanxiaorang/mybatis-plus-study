package top.xiaorang.mybatisplusstudy.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiaorang
 * @since 2021-12-20
 */
@Getter
@Setter
@Builder
@ApiModel(value = "Goods对象", description = "")
public class Goods implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty("主键ID")
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private Long id;

  @ApiModelProperty(value = "商品名称", required = true)
  private String name;

  @ApiModelProperty(value = "编号", required = true)
  private String code;

  @ApiModelProperty(value = "单价", required = true)
  private BigDecimal price;

  @ApiModelProperty("备注")
  private String remark;

  @Version
  @ApiModelProperty("版本号")
  private Integer version;

  @TableLogic
  @ApiModelProperty("删除标识")
  private Integer deleted;

  @ApiModelProperty("更新时间")
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;

  @ApiModelProperty("创建时间")
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
}
