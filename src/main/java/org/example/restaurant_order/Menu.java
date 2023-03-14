package org.example.restaurant_order;

import java.util.List;

// Menu 항목에 Menu Object 를  생성해주는 Class
public class Menu {
    // menuItems Field add
    private final List<MenuItem> menuItems;

    /**
     * Constructor (생성자)
     * - new 연산자를 통해서 Instance 를 생성할 때 반드시 Call 되고 제일 먼저 실행되는 일종의 Method 임
     * - Instance variable(Field value ...)를 초기화 시키는 역할을 함
     * - 선언 방법!
     * public Class (매개변수) { ... }
     * */
    public Menu(List<MenuItem> menuItems) {
        // menu 가 생성되면, menuItems 에 대입(menu 에 있는 음식들이 생성되면 메뉴판에 항목을 넣어준다는 의미!)
        this.menuItems = menuItems;
    }

    // 메뉴판에 있는 것을 고르면 해당 메뉴를 가져오는 작업!
    public MenuItem choose(String name) {
        // 해당 메뉴를 반환해줌!
        // Before HardCoding 으로 진행
//        return new MenuItem("치킨", 18000);
        // 1. 에러가 발생함! -> 이유? 객체끼리 비교해줄때는 이전에도 작업했듯이, Equals, hashcode 를 이용하여 해결!
        // menuItems 에서 메뉴판에 있는 메뉴의 음식의 이름이 존재하는가를 확인하고, 순서대로 항목별로 나열해줌!
        // 메뉴판에 있는 메뉴가 일치하지 않으면 에러 메세지를 남겨줌!
        return this.menuItems.stream()
                .filter(menuItem -> menuItem.matches(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 이름입니다."));
    }
}
