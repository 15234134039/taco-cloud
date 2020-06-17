package com.it.tacocloud.data;

import com.it.tacocloud.pojo.Ingredient;

/**
 * @author gxp
 * @version 1.0
 * @date 2020/6/17 11:33
 */
public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);



}
