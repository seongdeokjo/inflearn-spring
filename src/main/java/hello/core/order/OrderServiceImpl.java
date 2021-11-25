package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    //  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @Autowired  // 생성자 주입 : 생성자 호출시점에 딱 1번만 호출되는 것이 보장된다.
                // 불변, 필수 의존관계에 사용
                // *생성자가 딱 1개만 있으면 @Autowired를 생략해도 자동 주입 된다. 단, 스프링 빈에만 해당한다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

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
