package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		// 1. Spring �����̳ʸ� �����Ѵ� -> �ش� xml�� ��ϵ� bean�� class�� �ִ� Ŭ������ ã�� -> �⺻ ������ ȣ��
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û�Ѵ�.
		// id�� tv�� bean�� �ＺTV�� ȣ��
		// �⺻�� singleton, ��ü�� �� ���� ����.
		// prototype���� �ϸ� ��ü�� ���鶧���� ����
//		TV tv1 = (TV)factory.getBean("lgTV");
//		TV tv2 = (TV)factory.getBean("samsungTV");
		TV tv3 = (TV)factory.getBean("tv");
		
//		System.out.println("tv1 : @Component id�� lgTV���� - lgTV");
//		tv1.powerOn();
//		tv1.volumeUp();
//		tv1.volumeDown();
//		tv1.powerOff();
//		
//		System.out.println("tv2 : @Component id�� samsungTV���� - samsungTV");
//		tv2.powerOn();
//		tv2.volumeUp();
//		tv2.volumeDown();
//		tv2.powerOff();
		
		// 3. Spring �����̳� ����
		factory.close();
	}

}
