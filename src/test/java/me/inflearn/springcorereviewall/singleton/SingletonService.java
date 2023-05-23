package me.inflearn.springcorereviewall.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance; //JVM이 실행될 때 private으로 생성한 인스턴스의 참조값을 메서드 안에 할당해줌.
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
