package com.banjvduo.demo.dao;

import com.banjvduo.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;


    @Test
    public void test() {

        stringRedisTemplate.opsForValue().set("fbb", "FengBaobao");
        Assert.assertEquals("FengBaobao", stringRedisTemplate.opsForValue().get("fbb"));
    }

    @Test
    public void testObject() {

        // 保存对象
        User user = new User("冯宝宝", 200);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new User("阿无", 15);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new User("张宝宝", 19);
        redisTemplate.opsForValue().set(user.getName(), user);

        Assert.assertEquals(200, redisTemplate.opsForValue().get("冯宝宝").getAge().intValue());
        Assert.assertEquals(15, redisTemplate.opsForValue().get("阿无").getAge().intValue());
        Assert.assertEquals(19, redisTemplate.opsForValue().get("张宝宝").getAge().intValue());

    }

}
