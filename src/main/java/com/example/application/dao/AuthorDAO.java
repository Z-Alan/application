package com.example.application.dao;

import com.example.application.model.Author;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

// @Mapper注解：
// @Component注解：是为了解决在注入该bena时不报红，不写也不影响系统运行
/**
 * AuthorDAO.
 * author 数据持久接口
 *
 * @author zhouqiang
 */
@Mapper
@Component
public interface AuthorDAO {
    /*
     * 延伸：无论什么方式,如果涉及多个参数,则必须加上@Param注解,否则无法使用EL表达式获取参数。
     */
    /**
     * add.
     * @author       zhouqiang
     * @param        author     作者
     * @return       影响行数     int
     * @date   2018/7/5 10:51
     * */
    @Insert("insert into t_author(real_name,nick_name) values (#{author.nickName},#{author.realName})")
    int add(@Param("author")Author author);
    /**
     * add.
     * @author       zhouqiang
     * @param        author     作者
     * @return       影响行数     int
     * @date   2018/7/5 10:51
     * */
    @Update("update t_author set real_name = #{author.realName},nick_name = #{author.nickName}  where id  = #{author.id}")
    int update(@Param("author") Author author);
    /**
     * add.
     * @author       zhouqiang
     * @param        id         作者编号
     * @return       影响行数     int
     * @date   2018/7/5 10:51
     * */
    @Delete("delete from t_author where id = #{id}")
    int delete(@Param("id") Long id);
    /**
     * add.
     * @author       zhouqiang
     * @param        id         作者编号
     * @return       author     Author
     * @date   2018/7/5 10:51
     * */
    @Select("select * from t_author where id = #{id}")
    Author findAuthor(@Param("id") long id);
    /**
     * add.
     * @author       zhouqiang
     * @return       author     List
     * @date   2018/7/5 10:51
     * */
    @Select("select * from t_author")
    List<Author> findAuthorList();
}
