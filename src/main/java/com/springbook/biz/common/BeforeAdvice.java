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
	// 위의 주석처리 된 코드 3줄이 아래 코드 한줄과 같은 역할, 단, 미리 Pointcut에 등록해야 함
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName(); // 시그니처 정보가 저장된 Signature객체 리턴/ 클라이언트가 호출한 메소드 이름 리턴
		Object[] args = jp.getArgs(); // 클라이언트가 메소드를 호출할 때 넘겨준 인자 목록을 Object배열로 리턴
		
		System.out.println("[사전처리]" + method + "()메소드 ARGS 정보 : " + args[0].toString());
	}
}
