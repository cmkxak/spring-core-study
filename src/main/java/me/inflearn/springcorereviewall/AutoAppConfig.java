package me.inflearn.springcorereviewall;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        //붙히지 않으면 컴포넌트스캔이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
        basePackages = "me.inflearn.springcorereviewall", //컴포넌트를 탐색할 패키지의 시작 위치 지정
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
}
