package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", // 어디서부터 찾는지 지정 가능
        // 디폴트는 해당 클래스의 패키지

        //AppConfig 충돌을 방지하기 위해서 예외 처리 적용, @Configuration 보면 @ComponentScan 붙어 있음
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
