package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor    // final이 붙은 필드를 모아서 생성자를 자동 생성해준다.
public class OrderServiceImpl implements OrderService{
    //  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired  // 생성자 주입 : 생성자 호출시점에 딱 1번만 호출되는 것이 보장된다.
                // 불변, 필수 의존관계에 사용
                // *생성자가 딱 1개만 있으면 @Autowired를 생략해도 자동 주입 된다. 단, 스프링 빈에만 해당한다.
    // 생성자 주입을 선택하는 이유 :
        //  - 대부분의 의존관계 주입은 한번 일어나면 애플리케이션 종료시점까지 의존관계를 변경할 일이 없다. 오히려 대부분의 의존관계는 애플리케이션 종료 전까지 변하면 안된다.
        //  - 수정자 주입을 사용하면, setXxx, getXxx 메서드를 public으로 열어두어야 한다.
        //  - 누군가 실수로 변경할 수 도 있고, 변경하면 안되는 메서드를 열어두는 것은 좋은 설계 방법이 아니다.
        //  - 생성자 주입은 객체를 생성할 때  딱 1번만 호출되므로 이후에 호출되는 일이 없다.
        //  - final 키워드 사용 가능 : 생성자에서 혹시라도 값이 설정되지 않는 오류를 컴파일 시점에 막아준다.

//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order creatOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
