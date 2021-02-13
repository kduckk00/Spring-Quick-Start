package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// 핵심 로직 외의 공통 코드
@Service
@Aspect // Aspect = Pointcut + Advice
public class LogAdvice { // @Aspect 설정으로 LogAdvice객체를 애스팩트 객체로 인식
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))") // 포인트컷
	public void allPointcut() {}; // 포인트컷 메소드
	
	@Before("allPointcut()") // 어드바이스
	public void printLog() { // 어드바이스 메소드
		System.out.println("[공통로그] 비즈니스 로직 수행 전 동작");
	}
	// 포인트컷 메소드와 어드바이스 메소드에 의해 위빙처리
	
//	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
//	public void getPointcut() {};
	
//	public void printLog(JoinPoint jp) {
//		System.out.println("[공통로그] 비즈니스 로직(BoardService) 수행 전 동작"); // 이걸 사용할 수 있도록, BoardServiceImpl수정
//	}
}
