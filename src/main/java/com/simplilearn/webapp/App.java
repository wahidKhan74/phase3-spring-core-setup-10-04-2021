package com.simplilearn.webapp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.simplilearn.webapp.bean.Employee;

public class App {
	
	public static void main(String[] args) {
		
		// Tightly coupled object
		// Employee employee = new Employee();
		// employee.setId(10001);
		// employee.setName("John Smith");
		// employee.setSalary(978675.34);
		// employee.setDetp("Engineering");
		
		// System.out.println(employee);
		
		// IOC : Inversion of control => DI  dependency Injection.
		// 1. Application Context container type
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		Employee emp1 = (Employee) context.getBean("emp1");
		Employee emp2 = context.getBean("emp2",Employee.class);
		
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println("------------");
		
		
		// 2. Bean Factory Container
		Resource resource = new ClassPathResource("appContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Employee empOne = (Employee)factory.getBean("emp1");
		Employee empTwo = factory.getBean("emp2",Employee.class);
		System.out.println(empOne);
		System.out.println(empTwo);
		
//		DefaultListableBeanFactory factory1 = new DefaultListableBeanFactory();
//		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory1);
//		reader.loadBeanDefinitions(new ClassPathResource("appContext.xml"));
//		Employee empA = (Employee)factory1.getBean("emp1");
//		System.out.println(empOne);
	}
}
