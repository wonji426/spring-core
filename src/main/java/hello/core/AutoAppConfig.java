package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
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

    // 수동 빈이 자동 빈을 오버라이딩 해버린다. 하지만 스프링 부트로 돌리면 에러를 보여준다.
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
