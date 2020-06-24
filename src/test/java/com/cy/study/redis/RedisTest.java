package com.cy.study.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * redis测试类
 *
 * @author cy
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void stringTest(){
        Set<Object> vv = RedisUtils.sGet("vv");
        System.out.println(vv.size());
    }

}
