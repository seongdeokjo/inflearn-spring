package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//------@Primary -> @Autowired가 여러 개 일시 우선권을 가진다.----
// 코드에서 자주 사용하는 메인 데이터베이스의 커넥션을 획득하는 스프링 빈이 있고, 코드에서 특별한 기능으로 가끔 사용하는 서브 데이터베이스의 커넥션을 획득하는 스프링 빈이 있다고 생각해보자.
// 메인 데이터베이스 커넥션을 획득하는 스프링 빈은 '@Primary'를 적용해서 조회하는 곳에서 '@Qualifier' 지정 없이 편리하게 조회 하고,
// 서브 데이터베이스 커넥션 빈을 획득할 때는 '@Qualifier'를 지정해서 명시적으로 획득하는 방식으로 사용하면 코드를 깔끔하게 유지할 수 있다.
// 물론 이떄 메인데이터베이스의 스프링 빈을 등록할 때 '@Qualifier'를 지정해주는 것은 상관없다.

// *우선순위* : '@Primary'는 기본값 처럼 동작하는 것이고, '@Qulaifier'는 매우 상세하게 동작한다.
// 이런 경우 어떤 것이 우선권을 가져갈까? 스프링은 자동보다는 수동이, 넓은 범위의 선택권 보다는 좁은 범위의 선택권이 우선 순위가 높다.
// 여기서도 '@Qualifier'가 우선권이 높다.

//@Qualifier("mainDiscountPolicy")    // 추가 구분자를 붙여주는 방법, 주입시 추가적인 방법을 제공하는 것이지 빈 이름을 변경하는 것은 아니다.
// 만약 찾지못하게될경우 mainDiscountPolicy라는 이름의 스프링 빈을 추가로 찾는다. 하지만 @Qualifier는 @Qualifier를 찾는 용도로만 사용하는게 명확하고 좋다.
@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
