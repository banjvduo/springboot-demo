package com.banjvduo.demo.dao;

import com.banjvduo.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        userRepository.save(new User("a", 1));
        userRepository.save(new User("b", 2));
        userRepository.save(new User("c", 3));
        userRepository.save(new User("d", 4));
        userRepository.save(new User("e", 5));

        Assert.assertEquals(5, userRepository.count());
        Assert.assertEquals(3,userRepository.findByName("c").getAge().intValue());
        Assert.assertEquals(3,userRepository.findUser("c").getAge().intValue());
        Assert.assertNotNull(userRepository.findByNameAndAge("e",5));
        Assert.assertNull("e",userRepository.findByNameAndAge("e",6));

        userRepository.delete(userRepository.findByName("d"));

        Assert.assertEquals(4, userRepository.count());
        Assert.assertNull(userRepository.findByName("d"));

    }


}
