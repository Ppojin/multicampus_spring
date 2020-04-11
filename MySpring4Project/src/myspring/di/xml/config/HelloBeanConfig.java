package myspring.di.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
public class HelloBeanConfig {
	@Bean 
	// <bean id="stringPrinter" class="myspring.di.xml.StringPrinter">
	public Printer stringPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	// <bean id="ConsolePrinter" class="myspring.di.xml.ConsolePrinter">
	public Printer consolePrinter() {
		return new ConsolePrinter();
	}
	
	@Bean
	@Scope(value = "singleton")
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName("설정");
		hello.setPrinter(stringPrinter());
		return hello;
	}
}
