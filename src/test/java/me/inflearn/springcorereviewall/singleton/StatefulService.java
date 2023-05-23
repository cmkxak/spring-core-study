package me.inflearn.springcorereviewall.singleton;

public class StatefulService {
    private int price; //상태를 유지하는 필드

    //지역변수를 사용하도록 수정
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제
        return price;
    }
//
//    public int getPrice() {
//        return this.price;
//    }
}
