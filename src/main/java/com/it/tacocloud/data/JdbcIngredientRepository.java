package com.it.tacocloud.data;

import com.it.tacocloud.pojo.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author gxp
 * @version 1.0
 * @date 2020/6/17 11:37
 */
@Repository
public class JdbcIngredientRepository implements IngredientRepository{

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("select id, name, type from Ingredient", this::mapRowToIngredient);
    }

    @Override
    public Ingredient findOne(String id) {
        return jdbc.queryForObject("select id, name, type from Ingredient where id = ?", this::mapRowToIngredient, id);
    }


//    /**
//     * 使用显式RowMapper
//     * @param id
//     * @return
//     */
//    @Override
//    public Ingredient findOne(String id) {
//        return jdbc.queryForObject("select id, name, type from Ingredient where id = ?",
//                new RowMapper<Ingredient>() {
//                    @Override
//                    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        return new Ingredient(
//                                rs.getString("id"),
//                                rs.getString("name"),
//                                Ingredient.Type.valueOf(rs.getString("type")));
//                    };
//                }, id);
//    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbc.update("insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());

        return ingredient;
    }

    /**
     * Todo 参数rowNum的作用是什么，可以去掉吗
     */
    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }
}
