package com.example.application.utils;

import com.example.application.model.Author;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.lang.reflect.Field;

/**
 * GenerateMybatisAnnotation 生成mybatis的注解
 * @author zhouqiang
 * @date   2018/7/3 13:43
 * */
public class GenerateMybatisAnnotation {

    /**
     * 用于获取结果集的映射关系.
     * @param origin 源实体类
     * @return 结果集的映射关系
     * @author zhouqiang
     */
    public static String getResultsStr(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : origin.getDeclaredFields()) {
            String property = field.getName();
            // 映射关系：对象属性(驼峰)->数据库字段(下划线)
            String column = new PropertyNamingStrategy.SnakeCaseStrategy().translate(field.getName());
            stringBuilder.append(String.format("@Result(property = \"%s\", column = \"%s\"),%n", property, column));
        }
        stringBuilder.append("})");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(GenerateMybatisAnnotation.getResultsStr(Author.class));
    }
}
