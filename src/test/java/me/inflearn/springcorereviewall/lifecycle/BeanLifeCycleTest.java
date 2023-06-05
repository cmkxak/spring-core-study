package me.inflearn.springcorereviewall.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    /**
     * 보통 애플리케이션 컨텍스트를 가져다 쓸 때 close 할 일이 별로 없어서
     * 기본 ApplicationContext에서 제공해주지 않고  하위의 인터페이스에서 제공하도록 한다.
     */
    @Test
    public void lifecycle_test() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); //이전 예제와 다른 점.
    }

    @Configuration
    static class LifeCycleConfig {

        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev"); //외부에서 값을 세팅하고 초기화를 호출해야할 때가 많다.
            return networkClient;
        }
    }
}
