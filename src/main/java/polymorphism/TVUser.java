package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		// 1. Spring 컨테이너를 구동한다 -> 해당 xml에 등록된 bean의 class에 있는 클래스를 찾음 -> 기본 생성자 호출
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 필요한 객체를 요청한다.
		// id가 tv인 bean은 삼성TV를 호출
		// 기본이 singleton, 객체를 한 번만 생성.
		// prototype으로 하면 객체를 만들때마다 생성
//		TV tv1 = (TV)factory.getBean("lgTV");
//		TV tv2 = (TV)factory.getBean("samsungTV");
		TV tv3 = (TV)factory.getBean("tv");
		
//		System.out.println("tv1 : @Component id로 lgTV전달 - lgTV");
//		tv1.powerOn();
//		tv1.volumeUp();
//		tv1.volumeDown();
//		tv1.powerOff();
//		
//		System.out.println("tv2 : @Component id로 samsungTV전달 - samsungTV");
//		tv2.powerOn();
//		tv2.volumeUp();
//		tv2.volumeDown();
//		tv2.powerOff();
		
		// 3. Spring 컨테이너 종료
		factory.close();
	}

}
