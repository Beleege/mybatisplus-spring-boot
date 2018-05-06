package com.baomidou.springboot.test.ctrl;

import com.alibaba.fastjson.JSON;
import com.baomidou.springboot.entity.User;
import com.baomidou.springboot.entity.enums.AgeEnum;
import com.baomidou.springboot.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.springboot.Application;
import com.baomidou.springboot.test.ctrl.base.TestBase;

import java.util.List;

/**
 * <p>
 * 使用rest-assured框架，测试controller
 * </p>
 *
 * @author yuxiaobin
 * @date 2017/8/1
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserCtrlTest extends TestBase {

    @Autowired
    private IUserService userService;

    /**
     * sample：
     * <p>
     * 使用rest-assured框架，测试/user/test 这个URL的结果是否正确
     */
    @Test
    @Ignore
    public void testUserListPage() {
        JSONObject result = httpGet("/user/test");
//        Integer total = result.getInteger("total");
//        Assert.assertTrue(0 != total);
//        Assert.assertNotNull(result.get("records"));
        System.out.println(result);
    }

    @Test
    public void test() {
        List<User> u = userService.selectByName("a");
        log.info("=============================================");
        log.info(JSON.toJSONString(u));
        log.info("=============================================");
    }

    @Test
    public void addTest() {
        User u = new User("张晓龙", AgeEnum.ONE, 123);
        userService.insert(u);
    }

}
