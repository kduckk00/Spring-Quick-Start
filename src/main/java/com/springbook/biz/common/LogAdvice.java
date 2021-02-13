package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// �ٽ� ���� ���� ���� �ڵ�
@Service
@Aspect // Aspect = Pointcut + Advice
public class LogAdvice { // @Aspect �������� LogAdvice��ü�� �ֽ���Ʈ ��ü�� �ν�
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))") // ����Ʈ��
	public void allPointcut() {}; // ����Ʈ�� �޼ҵ�
	
	@Before("allPointcut()") // �����̽�
	public void printLog() { // �����̽� �޼ҵ�
		System.out.println("[����α�] ����Ͻ� ���� ���� �� ����");
	}
	// ����Ʈ�� �޼ҵ�� �����̽� �޼ҵ忡 ���� ����ó��
	
//	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
//	public void getPointcut() {};
	
//	public void printLog(JoinPoint jp) {
//		System.out.println("[����α�] ����Ͻ� ����(BoardService) ���� �� ����"); // �̰� ����� �� �ֵ���, BoardServiceImpl����
//	}
}
