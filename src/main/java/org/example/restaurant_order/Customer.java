package org.example.restaurant_order;

// 손님이 주문하는 Type Class
public class Customer {
    // 손님이 주문한 메뉴가 요리사에게 전달되어 요리가 되도록 해주는 Method add
    // 주문 Method 에서 받아오는 매개변수는 --> menuName, menu, cooking 임
    public void order(String menuName, Menu menu, Cooking cooking) {
        // 해당하는 메뉴가 있는지 체크 --> MenuItem 으로 메뉴를 반환!
        MenuItem menuItem = menu.choose(menuName);
        // 요리사에게 해당 메뉴를 요리해달라고 요청함!
        Cook cook = cooking.makeCook(menuItem);
    }
}
