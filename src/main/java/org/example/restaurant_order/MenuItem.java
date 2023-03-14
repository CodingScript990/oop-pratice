package org.example.restaurant_order;

import java.util.Objects;

// Menu 를 통해서 항목을 생성해주는 Class
public class MenuItem {
    // name, price 을 가진 Object 값을 초기화 해줌
    private final String name;
    private final int price;

    // Public 접근 제한자에서 MenuItem 이라는 Basic 생성자에서 매개변수를 선언해주는데?
    // 매개변수 -> 1. String type : name(음식이름), 2. int type : price(음식가격)
    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // 메뉴 항목에 있는 메뉴가 있는가?(손님이 주문하는 메뉴판에 있는 메뉴와 메뉴판의 음식이 실제로 있는지 없는지 판단!)
    public boolean matches(String name) {
        return this.name.equals(name);
    }

    // name getter 생성
    public String getName() {
        return name;
    }

    // price getter 생성
    public int getPrice() {
        return price;
    }

    // Object 끼리 비교를 할때에는 equals and hashcode 를 이용함
    // 즉, Object 값이 손님이 메뉴판에서 주문한 음식이 있는지 없는지를 판단해주는 작업
    @Override
    public boolean equals(Object o) {
        // 메뉴판에 있는 음식이 있으면?
        if (this == o) return true;
        // 메뉴판에 있는 음식이 없으면?
        if (o == null || getClass() != o.getClass()) return false;

        // 메뉴판에 있는 메뉴 항목들을 대입 --> 메뉴판(메뉴항목 = 객체들)
        MenuItem menuItem = (MenuItem) o;

        // 메뉴(객체) --> 이름, 가격을 반환해줌!
        return price == menuItem.price && Objects.equals(name, menuItem.name);
    }

    // Customer 이 주문한 메뉴판의 음식, 가격이 일치한지 정확하게 알아보기 위해서 HashCode 로 변환작업! -> 정확도↑
    @Override
    public int hashCode() {
        //
        return Objects.hash(name, price);
    }
}
