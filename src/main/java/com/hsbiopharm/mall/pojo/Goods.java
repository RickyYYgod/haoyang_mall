package com.hsbiopharm.mall.pojo;

import javax.persistence.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.io.InputStream;

/**
 * @Description 
 * @Author Ricky
 * @Date 2022-12-14 
 */

@Entity
@ApiModel(description= "t_goods")
@Table(name = "t_goods")
public class Goods implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
   	@Basic
	@Column(name = "goods_id")
	@ApiModelProperty(value = "主键", required = false, dataType = "int")
	private Long goodsId;

	/**
	 * 商品内部编码
	 */
   	@Basic
	@Column(name = "goods_code")
	@ApiModelProperty(value = "商品内部编码", required = false, dataType = "varchar(255)")
	private String goodsCode;

	/**
	 * 商品标识（历史版本标识、系统ID）
	 */
   	@Basic
	@Column(name = "goods_number")
	@ApiModelProperty(value = "商品标识（历史版本标识、系统ID）", required = false, dataType = "varchar(255)")
	private String goodsNumber;

	/**
	 * 商品名称
	 */
   	@Basic
	@Column(name = "goods_name")
	@ApiModelProperty(value = "商品名称", required = false, dataType = "varchar(255)")
	private String goodsName;

	/**
	 * 商品类型：
01-定制服务商品;
02-标准商品
	 */
   	@Basic
	@Column(name = "goods_type")
	@ApiModelProperty(value = "商品类型：01-定制服务商品;02-标准商品", required = false, dataType = "int")
	private Long goodsType;

	/**
	 * 商品一级分类
	 */
   	@Basic
	@Column(name = "goods_class_one")
	@ApiModelProperty(value = "商品一级分类", required = false, dataType = "varchar(255)")
	private String goodsClassOne;

	/**
	 * 商品二级分类
	 */
   	@Basic
	@Column(name = "goods_class_two")
	@ApiModelProperty(value = "商品二级分类", required = false, dataType = "varchar(255)")
	private String goodsClassTwo;

	/**
	 * 商品三级分类
	 */
   	@Basic
	@Column(name = "goods_class_three")
	@ApiModelProperty(value = "商品三级分类", required = false, dataType = "varchar(255)")
	private String goodsClassThree;

	/**
	 * 01-新建;
02-上架;
03-下架;
99-历史;
	 */
   	@Basic
	@Column(name = "goods_state")
	@ApiModelProperty(value = "01-新建;02-上架;03-下架;99-历史;", required = false, dataType = "int")
	private Long goodsState;

	/**
	 * 商品描述
	 */
   	@Basic
	@Column(name = "goods_desc")
	@ApiModelProperty(value = "商品描述", required = false, dataType = "blob")
	private InputStream goodsDesc;

	/**
	 * 商品详情
	 */
   	@Basic
	@Column(name = "goods_details")
	@ApiModelProperty(value = "商品详情", required = false, dataType = "blob")
	private InputStream goodsDetails;

	/**
	 * 商品创建时间
	 */
   	@Basic
	@Column(name = "create_time")
	@ApiModelProperty(value = "商品创建时间", required = false, dataType = "datetime")
	private Date createTime;

	/**
	 * 商品创建人
	 */
   	@Basic
	@Column(name = "create_user")
	@ApiModelProperty(value = "商品创建人", required = false, dataType = "varchar(255)")
	private String createUser;

	/**
	 * 修改时间
	 */
   	@Basic
	@Column(name = "update_time")
	@ApiModelProperty(value = "修改时间", required = false, dataType = "datetime")
	private Date updateTime;

	/**
	 * 修改人
	 */
   	@Basic
	@Column(name = "update_user")
	@ApiModelProperty(value = "修改人", required = false, dataType = "varchar(255)")
	private String updateUser;

}
