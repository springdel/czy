package com.czy.sboot;

import com.czy.sboot.entity.Users;
import com.czy.sboot.redis.uitl.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class SbootApplicationTests {
    @Autowired
    RedisUtil redisUtil;
    @Test
    void contextLoads() {

    }
    /**
     * 上机1
     */
    @Test
    public void test1(){
        System.out.println(redisUtil.get("password"));
    }

    /**
     * 上机2
     */
    @Test
    public void test2(){
        Users users = new Users();
        redisUtil.set("user",users);
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        redisUtil.lSet("list",list);
    }


    /**
     * 上机3
     */
    @Test
    public void test3(){
        redisUtil.expire("user",10);
        redisUtil.expire("list",10);
    }

    /**
     * 上机4
     */
    @Test
    public void test4(){
        redisUtil.hset("hash","name","wang");
        redisUtil.set("string","chen");
    }
    /**
     * 上机5
     */
    @Test
    public void test5(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        redisUtil.lSet("lists",list);
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        redisUtil.sSet("set",set);
        System.out.println(redisUtil.lGet("lists",0,-1));
        System.out.println(redisUtil.sGet("set"));
    }

}
