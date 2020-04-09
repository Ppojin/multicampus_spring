package myspring.di.xml.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;

public class HelloBeanJunitTest {
	/*
	 * Test Case Method 를 선언할 때 규칙
	 * 1. Test Annotation 을 반드시 선언한다
	 * 2. 테스트 메서드의 접근 제한자는 반드시 public, return type 은 void
	 */
	@Test
	public void hello() {
		//1. Spring Bean Container 생성
		//ResourceLocation = Spring Bean Config xml 정보를 설
		BeanFactory bean = new GenericXmlApplicationContext("config/spring_bean.xml");
		// container 에게 bean 으로 요청;
		Hello hello1 = (Hello) bean.getBean("hello");
		Hello hello2 = bean.getBean("hello", Hello.class);
		System.out.println(hello1 == hello2);
		assertSame(hello1, hello2);
		assertEquals("Hello 스프링", hello1.sayHello());
		
		hello1.print();
	}
}
