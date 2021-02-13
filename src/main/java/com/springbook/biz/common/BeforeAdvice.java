package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
//	public void allPointcut() {}
//	
//	@Before("allPointcut()")
	// ���� �ּ�ó�� �� �ڵ� 3���� �Ʒ� �ڵ� ���ٰ� ���� ����, ��, �̸� Pointcut�� ����ؾ� ��
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName(); // �ñ״�ó ������ ����� Signature��ü ����/ Ŭ���̾�Ʈ�� ȣ���� �޼ҵ� �̸� ����
		Object[] args = jp.getArgs(); // Ŭ���̾�Ʈ�� �޼ҵ带 ȣ���� �� �Ѱ��� ���� ����� Object�迭�� ����
		
		System.out.println("[����ó��]" + method + "()�޼ҵ� ARGS ���� : " + args[0].toString());
	}
}
