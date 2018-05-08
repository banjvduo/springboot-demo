package com.banjvduo.demo.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Before
    public void setUp() {
        userDao.deleteAllUsers();
    }

    @Test
    public void test() {
        userDao.create("a", 1);
        userDao.create("b", 2);
        userDao.create("c", 3);
        userDao.create("d", 4);
        userDao.create("e", 5);

        Assert.assertEquals(5, userDao.getAllUsers().intValue());

        userDao.deleteByName("a");
        userDao.deleteByName("e");

        Assert.assertEquals(3, userDao.getAllUsers().intValue());

    }


}
