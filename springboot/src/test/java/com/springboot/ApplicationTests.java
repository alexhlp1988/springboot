package com.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

//基于SpringRunner 单元测试类(Junit)
@RunWith(SpringRunner.class)
//说明spring boot测试类
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void hello(){
		ResponseEntity<String> entity = restTemplate.getForEntity("/hello",String.class);
//		System.out.println(entity.getBody());
		// 断言是编程术语，表示为一些布尔表达式，程序员相信在程序中的某个特定点该表达式值为真，可以在任何时候启用和禁用断言验证，因此可以在测试时启用断言而在部署时禁用断言。同样，程序投入运行后，最终用户在遇到问题时可以重新启用断言。
		//使用断言可以创建更稳定、品质更好且不易于出错的代码。当需要在一个值为FALSE时中断当前操作的话，可以使用断言。单元测试必须使用断言（Junit/JunitX）。
		//通过assertThat 进行断言判断
		assertThat(entity.getBody()).isEqualTo("Hello Spring Boot.");
		assertThat(entity.getStatusCodeValue()).isEqualTo(200);
	}

	/**
	 * 加载上下文
	 */
	@Test
	public void contextLoads() {
	}

}
