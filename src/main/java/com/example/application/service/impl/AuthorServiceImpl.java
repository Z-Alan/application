package com.example.application.service.impl;

import com.example.application.dao.AuthorDAO;
import com.example.application.model.Author;
import com.example.application.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author service 实现
 *
 * @author zhouqiang
 */
@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorServiceImpl.class);

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public int add(Author author) {
        LOGGER.info("[- 入参 -] 添加作者信息 --- [- {} -]", author);
        return this.authorDAO.add(author);
    }

    @Override
    public int update(Author author) {
        LOGGER.info("[- 入参 -] 添加作者信息 --- [- {} -]", author);
        try {
            this.authorDAO.update(author);
        } catch (Exception e) {
            LOGGER.error("[- 异常 -] 操作备注 --- 异常类型 : [- {} -] --- 堆栈信息 : [- {} -]",e,e.getStackTrace());
        }
        return this.authorDAO.update(author);
    }

    @Override
    public int delete(Long id) {
        return this.authorDAO.delete(id);
    }

    @Override
    public Author findAuthor(Long id) {
        return this.authorDAO.findAuthor(id);
    }

    @Override
    public List<Author> findAuthorList() {
        return this.authorDAO.findAuthorList();
    }
}
