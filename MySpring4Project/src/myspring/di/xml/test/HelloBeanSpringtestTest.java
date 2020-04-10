package myspring.di.xml.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_bean.xml")
public class HelloBeanSpringtestTest {
	// Hello hello = factory.getBean("hello", Hello.class);
	@Autowired
	@Qualifier("helloC")
	Hello hello; 
	
	@Test
	public void Bean() {
		System.out.println(hello.sayHello());
		hello.print();
		List<String> names = hello.getNames();
		for(String name : names) {
			System.out.println(name);
		}
		
		// Map의 KeySet() 사용
		Map<String, Integer> ages = hello.getAges();
		for (String key : ages.keySet()) {
			System.out.println(key + " : " + ages.get(key));
		}

		// Map의 entrySet() 사용
		for(Map.Entry entry : ages.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}	
}