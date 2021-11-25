package hello.core;

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

}
