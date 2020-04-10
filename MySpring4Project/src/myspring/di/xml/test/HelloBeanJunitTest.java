package myspring.di.xml.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanJunitTest {
	BeanFactory factory;
	
	@Before
	public void init() {
		//1. Spring Bean Container 생성
		//ResourceLocation = Spring Bean Config xml 정보를 설정
		factory = new GenericXmlApplicationContext("config/spring_bean.xml"); // <= 컨테이너 		
	}
	
	/*
	 * Test Case Method 를 선언할 때 규칙
	 * 1. Test Annotation 을 반드시 선언한다
	 * 2. 테스트 메서드의 접근 제한자는 반드시 public, return type 은 void
	 */
	@Test
	public void hello() {
		//2. container 에게 bean 으로 요청;
		Hello hello1 = (Hello) factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		System.out.println(hello1 == hello2);
		assertSame(hello1, hello2);
		assertEquals("Hello 스프링", hello1.sayHello());
		
		hello1.print();
		//3. Container에게 StringPrinter Bean을 요청
		Printer printer = factory.getBean("sPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
	}
	
	
}
