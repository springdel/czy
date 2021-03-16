package com.czy.sboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图书编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 书名
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社编号
     */
    @TableField("PublisherId")
    private Integer PublisherId;

    /**
     * 出版日期
     */
    @TableField("PublishDate")
    private LocalDateTime PublishDate;

    /**
     * 图片名称
     */
    @TableField("ISBN")
    private String isbn;

    /**
     * 价格
     */
    @TableField("UnitPrice")
    private Double UnitPrice;

    /**
     * 简介
     */
    @TableField("ContentDescription")
    private String ContentDescription;

    /**
     * 章节
     */
    @TableField("TOC")
    private String toc;

    /**
     * 图书类型编号
     */
    @TableField("CategoryId")
    private Integer CategoryId;

    /**
     * 点击量
     */
    @TableField("Clicks")
    private Integer Clicks;

    /**
     * 是否上架 0:不上架 1:上架
     */
    @TableField("IsSale")
    private Integer IsSale;

    /**
     * 上架时间
     */
    @TableField("saleTime")
    private LocalDateTime saleTime;

    /**
     * 预警库存
     */
    @TableField("warnStock")
    private Integer warnStock;

    /**
     * 总库存
     */
    @TableField("sumStock")
    private Integer sumStock;


}
