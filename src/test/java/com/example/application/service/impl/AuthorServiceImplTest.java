package com.example.application.service.impl;

import com.example.application.model.Author;
import com.example.application.service.AuthorService;
import com.example.application.service.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class AuthorServiceImplTest extends BaseServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    public void addTest() {
        Author author = new Author();
        author.setNickName("格子先生i");
        author.setRealName("格子");
        int row = authorService.add(author);
        assertEquals(1,row);
    }

    @Test
    public void updateTest() {
        Author author = new Author();
        author.setId(1L);
        author.setNickName("假名字");
        author.setRealName("真名字");
        int row = 0 ;
        row = authorService.update(author);
        author.setId(2L);
        author.setNickName("更远的以后");
        author.setRealName("周牧");
        row = authorService.update(author);
        assertEquals(1,row);
    }

    @Test
    public void deleteTest() {
    }

    @Test
    public void findAuthorTest() {
        Author author = authorService.findAuthor(2L);
        assertEquals("周牧",author.getRealName());
    }

    @Test
    public void findAuthorListTest() {
        List<Author> authorList = authorService.findAuthorList();
        assertEquals(3,authorList.size());
    }
}