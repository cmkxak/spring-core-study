package me.inflearn.springcorereviewall.lifecycle;

import jakarta.annotation.PostConstruct; //Java 진영에서 공식적으로 지원하는 것 -> 스프링 이외의 컨테이너에서도 적용 가능
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
//        connect();
//        call("초기화 연결 메시지"); //초기화 작업 : 외부랑 일을 하는 것 -> 의존 관계 주입이 모두 완려되고 난 다음에 호출되어야 한다.
        //그럼 개발자가 의존관계 주입이 모두 완료된 시점을 어떻게 알까?
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 시 호출 : 즉, 의존관계 주입이 모두 완료된 시점에 스프링은 스프링 빈에게 콜백 메서드를 통해 초기화 시점을 알려줌.
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call : = " + url + " message = " + message);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close = " + url);
    }

    //의존관계 주입이 끝나면 호출함.
    //스프링 빈이 스프링 코드에 의존하지 않는다.
    //코드가 아니라 설정 정보를 사용하기 때문에 코드를 고칠 수 없는 외부 라이브러리에도 초기화, 종료 메서드를 적용할 수 있음
    @PostConstruct //의존관계 주입이 된 후에 (생성이 된 후에)
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 메시지");
    }

    @PreDestroy //빈이 소멸되기 전에
    public void shutdown(){
        System.out.println("NetworkClient.shutdown");
        disconnect();
    }
}
