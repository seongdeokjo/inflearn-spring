package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(     // @Component 어노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록
//        basePackages = "hello.core.member", -> 탐색할 패키지의 시작 위치를 지정한다. 이 패키지를 포함해서 하위 패키지를 모두 탐색
//        basePackageClasses = AutoAppConfig.class, -> 지정한 클래스의 패키지를 탐색 시작 위로 지정한다.
//        만약 지정하지 않으면 '@ComponentScan'이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
//        권장하는 방법 : 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것이다. 최근 스프링 부트도 이 방법을 기본으로 제공한다.
        // 기존 예제 코드를 최대한 남기고 유지하기 위해 필터로 @Configuration이 붙은 클래스들을 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // 수동 빈 등록 --> 수동 빈 vs 자동 빈 : 수동 빈이 자동 빈을 오버라이딩 한다(수동 빈이 우선권을 가짐)
    // 하지만 스프링 부트에서는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하도록 기본 값을 바꾸었다.
    // 수동 빈 등록, 자동 빈 등록 충돌(오류)시 스프링 부트 에러
    // 에러 메시지 : 'Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding =true'
    // 기본 값은 false
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
