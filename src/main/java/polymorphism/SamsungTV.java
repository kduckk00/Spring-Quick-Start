package polymorphism;

import org.springframework.stereotype.Component;

@Component("samsungTV")
public class SamsungTV implements TV{
//	SonySpeaker speaker = new SonySpeaker(); // ���� �̷��� ���� speak��ü�� ���� �Ⱦ��� SamsungTV��ü�� ȣ��� ��, ���� �������
//	private SonySpeaker speaker;
	private Speaker speaker; // �������̽� Speaker 
	private int price;
//	public void initMethod() {
//		System.out.println("��ü �ʱ�ȭ �۾� ó��.."); // �����̳ʰ� �����Ǿ� SamsungTV ��ü�� ������ ���� ȣ��
//	}
//	
//	public void destroyMethod() {
//		System.out.println("��ü ���� ���� ó���� ���� ó��..."); // �������� ����Ǳ� ���� 
//	}
	
	public SamsungTV() { // �⺻ ������ ȣ��
		System.out.println("===> SamsungTV ��ü ����");
	}
	
	

	
//	public SamsungTV(Speaker speaker) {
//		System.out.println("===> SamsungTV(������ ������)��ü ����");
//		this.speaker = speaker;
//	}
//	
//	// ���� ���� ����
//	public SamsungTV(Speaker speaker, int price) {
//		System.out.println("===> SamsungTV(������ ������ + ���� ����)��ü ����");
//		this.speaker = speaker;
//		this.price = price;
//	}


	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() ȣ��");
		this.speaker = speaker;
	}


	public void setPrice(int price) {
		System.out.println("===> setPrice() ȣ��");
		this.price = price;
	}


	public void powerOn() {
		System.out.println("SamsungTV---���� �Ҵ�.");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV---���� ����.");
	}
//	
//	public void volumeUp() {
//		System.out.println("SamsunTV---�Ҹ� �ø���.");
//	}
//	
//	public void volumeDown() {
//		System.out.println("SamsunTV---�Ҹ� ������.");
//	}
	
	public void volumeUp() {
//		speaker = new SonySpeaker(); // ���⼭ ��ü ���������ν� ȣ��ɶ��� ��ü �����ϰԲ� ��
//		speaker.volumeUp();
		System.out.println("SamsungTV---�Ҹ� �ø���.");
	}
	
	public void volumeDown() {
//		speaker = new SonySpeaker();
//		speaker.volumeDown();
		System.out.println("SamsungTV---�Ҹ� ������.");
	}

}
