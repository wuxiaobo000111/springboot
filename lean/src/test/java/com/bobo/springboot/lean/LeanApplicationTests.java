package com.bobo.springboot.lean;

import com.bobo.springboot.lean.commons.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeanApplicationTests {

	@Test
	public void contextLoads() {
		Long s =1532828044000L;
		Date date = new Date(s);
		try {
			String s1 = DateUtil.date2String2(date);
			System.out.println(s1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
