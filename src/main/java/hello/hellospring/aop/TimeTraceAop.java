package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// aop(Aspect Oriented Programming) : 공통 관심 사항(cross-cutting concern) 분리
//                                    핵심 관심 사항(core concern)을 깔끔하게 유지할 수 있다.
//                                    변경이 필요하면 이 로직만 변경하면 된다.
//                                    원하는 적용 대상을 선택할 수 있다.
//  프록시를 통해 aop 사용
@Aspect
//@Component
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*())")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("Start : "+joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally{
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("end : "+joinPoint.toString()+" "+timeMs +"ms");
        }
    }

}
