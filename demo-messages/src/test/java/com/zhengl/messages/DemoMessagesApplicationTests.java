package com.zhengl.messages;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class DemoMessagesApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void contextLoads() {

        test1();
    }

    void test(){
        String url = "https://my.cnki.net/Register/Server.aspx";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mobile", "18920212036");
        jsonObject.put("operatetype", "2");
        jsonObject.put("imageCode", "yfu7");

        String s = restTemplate.postForObject(url, jsonObject, String.class);
        System.out.println(s);
    }

    void test1(){
        String url = "https://my.cnki.net/Register/Server.aspx?mobile=13820837894&operatetype=0&imageCode=yfu7";

        String s = restTemplate.postForObject(url, null, String.class);
        System.out.println(s);
    }

    void test2(){
        String url = "https://my.cnki.net/Register/Server.aspx?mobile=13820837894&operatetype=0&imageCode=yfu7";

        String s = restTemplate.postForObject(url, null, String.class);
        System.out.println(s);
    }


}
