package com.example.application.dao;

import com.example.application.model.Author;

import java.util.List;

/**
 * AuthorDAO.
 * author 数据持久接口
 *
 * @author zhouqiang
 */
public interface AuthorDAO {
    /**
     * add.
     * @author       zhouqiang
     * @param        author     作者
     * @return       影响行数     int
     * @date   2018/7/5 10:51
     * */
    int add(Author author);
    /**
     * add.
     * @author       zhouqiang
     * @param        author     作者
     * @return       影响行数     int
     * @date   2018/7/5 10:51
     * */
    int update(Author author);
    /**
     * add.
     * @author       zhouqiang
     * @param        id         作者编号
     * @return       影响行数     int
     * @date   2018/7/5 10:51
     * */
    int delete(Long id);
    /**
     * add.
     * @author       zhouqiang
     * @param        id         作者编号
     * @return       author     Author
     * @date   2018/7/5 10:51
     * */
    Author findAuthor(long id);
    /**
     * add.
     * @author       zhouqiang
     * @return       author     List
     * @date   2018/7/5 10:51
     * */
    List<Author> findAuthorList();
}
