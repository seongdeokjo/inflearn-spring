package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
//      1. 상태 유지 테스트 코드
//        // ThreadA : A사용자 10000원 주문
//       statefulService1.order("userA",10000);
//        // ThreadB : B사용자 20000원 주문
//        statefulService2.order("userB", 20000);
//
//        // ThreadA : 사용자A 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = "+price);   // 10000원을 기대했지만 20000원 출력
//
//        assertThat(statefulService1.getPrice()).isEqualTo(20000);

//        2. 무상태 테스트 코드
//         ThreadA : A사용자 10000원 주문
      int priceA =  statefulService1.order("userA",10000);
//         ThreadB : B사용자 20000원 주문
      int priceB =  statefulService2.order("userB", 20000);
        System.out.println("A사용자 : "+priceA);
        System.out.println("B사용자 : "+priceB);

        assertThat(priceA).isEqualTo(10000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}