package com.bobo.springboot.lean.dao.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by bobo on 2018/8/27/21:48.
 */
@Data
@Slf4j
public class User {

    private String name;

    private String address;

    public static void main(String[] args) {
        User user =new User();
        user.setName("wuxiaobo");
        user.setAddress("北京市");
        log.info(user.toString());
    }
}
