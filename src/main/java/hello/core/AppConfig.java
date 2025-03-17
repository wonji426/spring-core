package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

    //생각
    //1. call AppConfig.memberService
    //2. call AppConfig.memberRepository
    //3. call AppConfig.memberRepository
    //4. call AppConfig.orderService
    //5. call AppConfig.memberRepository
    // 순서는 다르겠지만 결과적으로 memberRepository 3번 호출됨

    //실제
    //1. call AppConfig.memberService
    //2. call AppConfig.memberRepository
    //3. call AppConfig.orderService
    //스프링이 싱글톤을 보장해줌
    //@Configuration 제거하면 싱글톤 보장 안됨

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
