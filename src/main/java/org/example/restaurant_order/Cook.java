package org.example.restaurant_order;

import java.util.Objects;

// 요리를 통해 음식(객체)을 만들어주는 Class
public class Cook {
    // name, price 을 가진 Object 값을 초기화 해줌
    private final String name;
    private final int price;

    // Public 접근 제한자에서 Cook 이라는 Basic 생성자에서 매개변수를 선언해주는데?
    // 매개변수 -> 1. String type : name(음식이름), 2. int type : price(음식가격)
    public Cook(String name, int price) {
        // 생성자에 Object 정보를 넣으면 대입되어 생성되도록 해주는 작업!
        /**
         1. new Cook("만두", 7000) 기입!
         2. public Cook(String "만두", int 7000) {} 이렇게 실행됨
         3. {
            this."만두" = "만두";
            this.7000 = 7000; 이렇게 대입해줌
         }
        */
        this.name = name;
        this.price = price;
    }

    // MenuItem 생성자를 이용하여 Cooking 에게 요리를 할 수 있도록 해줌
    public Cook(MenuItem menuItem) {
        // 주문 들어온 메뉴의 이름, 가격들이 대입됨 -> Cooking 에게 해당 MenuIem 에 있는 name, price 를 대입
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
    }

    // Object 끼리 비교를 할때에는 equals and hashcode 를 이용함
    // 즉, Object 값이 손님이 주문한 음식 Code 와 요리사가 만든 음식이 일치한지를 확인하기 위함이라고 생각하면 됨
    /**
     * Equals()
     * - Object 의 Value 가 일치한지 여부를 반환하는 Type 임

     * HashCode()
     * - Object 의 Address value 를 이용하여 Object 고유의 HashCode 를 return 하는 Function 임
     * */
    // Boolean type 으로 String customer food menu == String cooking make food 가 일치한지 체크!
    @Override
    public boolean equals(Object o) {
        // True 인지 체크
        if (this == o) return true;
        // False 인지 체크
        if (o == null || getClass() != o.getClass()) return false;
        // 확인된 food 를 대입
        Cook cook = (Cook) o;
        // 확인된 food price 도 대입
        return price == cook.price && Objects.equals(name, cook.name);
    }

    // Customer 과 Cooking 의 Food Code 가 일치한지 정확하게 알아보기 위해서 HashCode 로 변환작업! -> 정확도↑
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
