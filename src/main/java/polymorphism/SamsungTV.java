package polymorphism;

import org.springframework.stereotype.Component;

@Component("samsungTV")
public class SamsungTV implements TV{
//	SonySpeaker speaker = new SonySpeaker(); // 만약 이렇게 쓰면 speak객체를 쓰던 안쓰던 SamsungTV객체가 호출될 때, 같이 만들어짐
//	private SonySpeaker speaker;
	private Speaker speaker; // 인터페이스 Speaker 
	private int price;
//	public void initMethod() {
//		System.out.println("객체 초기화 작업 처리.."); // 컨테이너가 구동되어 SamsungTV 객체가 생성된 직후 호출
//	}
//	
//	public void destroyMethod() {
//		System.out.println("객체 삭제 전에 처리할 로직 처리..."); // 컨테이터 종료되기 직전 
//	}
	
	public SamsungTV() { // 기본 생성자 호출
		System.out.println("===> SamsungTV 객체 생성");
	}
	
	

	
//	public SamsungTV(Speaker speaker) {
//		System.out.println("===> SamsungTV(생성자 인젝션)객체 생성");
//		this.speaker = speaker;
//	}
//	
//	// 다중 변수 매핑
//	public SamsungTV(Speaker speaker, int price) {
//		System.out.println("===> SamsungTV(생성자 인젝션 + 다중 변수)객체 생성");
//		this.speaker = speaker;
//		this.price = price;
//	}


	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}


	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}


	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
//	
//	public void volumeUp() {
//		System.out.println("SamsunTV---소리 올린다.");
//	}
//	
//	public void volumeDown() {
//		System.out.println("SamsunTV---소리 내린다.");
//	}
	
	public void volumeUp() {
//		speaker = new SonySpeaker(); // 여기서 객체 생성함으로써 호출될때만 객체 생성하게끔 함
//		speaker.volumeUp();
		System.out.println("SamsungTV---소리 올린다.");
	}
	
	public void volumeDown() {
//		speaker = new SonySpeaker();
//		speaker.volumeDown();
		System.out.println("SamsungTV---소리 내린다.");
	}

}
