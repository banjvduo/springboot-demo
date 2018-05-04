package com.banjvduo.demo.property;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SystemPropertiesTest {

    @Autowired
    private SystemProperties systemProperties;

    @Test
    public void getHello() {
        Assert.assertEquals(systemProperties.getSystemName(),"springboot-demo");
//        Assert.assertEquals(systemProperties.getAuthor(),"banjvduo");
        System.out.println(systemProperties.getAuthor());
        int ranNum = systemProperties.getRanNum();
        System.out.println(ranNum);
        Assert.assertNotNull(ranNum);
        String ranStr = systemProperties.getRanStr();
        System.out.println(ranStr);
        Assert.assertNotNull(ranStr);
    }

}
