package org.example.restaurant_order;

// 주문 받은 음식을 요리해주는 요리사 Type Class
public class Cooking {

    // 주문들어온 메뉴항목 음식을 Cooking 함!
    public Cook makeCook(MenuItem menuItem) {
        // 현재는 HardCoding 되어 있음!
        // Before return new Cook("돈까스", 8000);

        // After -> cook 생성자를 이용하여 menuItem 을 전달 받아오는 걸로 마무리 지어줌!
        // Menuitem 을 가지는 생성자까지 만들어줌!
        Cook cook = new Cook(menuItem);
        // 주문 받은 메뉴이름, 가격을 가져와 대입해줌 -> 즉, 주문받은 요리사는 음식을 요리한다는 의미!
        return cook;
    }
}
