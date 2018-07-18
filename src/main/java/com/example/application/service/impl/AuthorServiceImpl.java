package com.example.application.service.impl;

import com.example.application.dao.AuthorDAO;
import com.example.application.model.Author;
import com.example.application.service.AuthorService;
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

    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO){
        this.authorDAO = authorDAO;
    }

    @Override
    public int add(Author author) {
        return this.authorDAO.add(author);
    }

    @Override
    public int update(Author author) {
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
