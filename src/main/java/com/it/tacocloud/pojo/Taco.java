package com.it.tacocloud.pojo;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Taco
 * @author gxp
 * @version 1.0
 * @date 2020/6/16 15:10
 */
@Data
public class Taco {

    private Long id;

    @NotNull
    @Size(min = 5, message = "名字长度至少是5个字符")
    private String name;

    @Size(min = 1, message = "你必须选择至少一个配料")
    private List<Ingredient> ingredients;

    /**
     * 创建日期
     */
    private Date createdAt;
}
