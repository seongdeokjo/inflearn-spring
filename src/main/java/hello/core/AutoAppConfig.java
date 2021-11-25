package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(     // @Component 어노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록
        // 기존 예제 코드를 최대한 남기고 유지하기 위해 필터로 @Configuration이 붙은 클래스들을 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
