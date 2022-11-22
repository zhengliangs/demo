package com.zhengl.aop.service;

import com.zhengl.aop.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hero良
 */
@RequestMapping("/user")
@RestController
public class UserService {

    @GetMapping("/doAround")
    public String doAround(String name, int age) {

        return name + " - succeed";
    }

    @GetMapping("/doBefore")
    public String doBefore(String name) {

        return name + " - succeed";
    }


    @GetMapping("/doAfter")
    public String doAfter(String name) {

       return name + " - succeed";
    }

    @GetMapping("/doAfterReturning")
    public String doAfterReturning(String name) {

        return name + " - succeed";
    }

    @GetMapping("/doAfterThrowing")
    public String doAfterThrowing(int num){

        return 2/num + "";
    }

    @Log(title = "用户信息")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return id + "  -  删除成功";
    }

}
