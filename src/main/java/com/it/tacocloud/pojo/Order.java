package com.it.tacocloud.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Order
 * @author gxp
 * @version 1.0
 * @date 2020/6/16 15:10
 */
@Data
public class Order {

    private Long id;

    @NotNull(message = "姓名是必填的")
    private String name;

    @NotNull(message = "街道是必填的")
    private String street;

    @NotNull(message = "城市是必填的")
    private String city;

    @NotNull(message = "省份是必填的")
    private String state;

    @NotNull(message = "邮政编码是必填的")
    private String zip;

    /**
     * 信用卡号码
     */
    //@CreditCardNumber(message = "信用卡号码无效")
    private String ccNumber;

    /**
     * 信用卡到期时间
     */
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "必须是MM/YY格式")
    private String ccExpiration;

    /**
     * 信用卡CVV码
     * 验证字符串是否是符合指定格式的数字，interger指定整数精度，fraction指定小数精度。
     */
    @Digits(integer = 3, fraction = 0, message = "无效的CVV")
    private String ccCVV;

    /**
     * 创建日期
     */
    private Date placedAt;
}
