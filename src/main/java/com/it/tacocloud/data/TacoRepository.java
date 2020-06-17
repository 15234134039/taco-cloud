package com.it.tacocloud.data;

import com.it.tacocloud.pojo.Taco;

/**
 * @author gxp
 * @version 1.0
 * @date 2020/6/17 14:57
 */
public interface TacoRepository {

    Taco save(Taco design);
}
