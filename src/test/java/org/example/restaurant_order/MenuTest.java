package org.example.restaurant_order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

// 메뉴 Type Test Class
public class MenuTest {

    // DisplayName : 메뉴항목의 음식들을 확인하는 작업!
    @DisplayName("메뉴판에서 메뉴이름에 해당하는 메뉴를 반환한다.")
    @Test
    void chooseTest() {
        // new Menu 생성자를 이용하여, MenuItem 객체들을 menu variable 에 값을 반환해줌
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 8000), new MenuItem("치킨", 18000)));
        // menuItem 항목에서 menu 를 선택할 수 있게 항목들을 고를 수 있도록 만들어줌!
        // 즉, 손님이 메뉴판을 보면서 주문을 할 메뉴를 고르기 위해서 항목에 있는 메뉴들을 불러와줌!
        MenuItem menuItem = menu.choose("치킨");

        // 정말 손님이 본 메뉴판에 메뉴가 있는지와 메뉴판 있는 메뉴들도 존재하는지를 체크해주는 작업!
        // 즉, 손님이 메뉴판에 나와있는 음식을 시킬려는데, 주문한 음식이 메뉴판에 적혀있는데로 항목이 존재하는가를 체크한다는 의미! -> 흔히, 메뉴판에 적혀있는데, 최신화가 되지 않아 주문했는데, 그 해당 메뉴가 없다거나, 아니면 오타로 인하여 없는 메뉴인데 주문이 들어올때 등을 체크하기 위함임!(정확성)
        assertThat(menuItem).isEqualTo(new MenuItem("치킨", 18000));
    }

    // 메뉴판에 존재하지 않는 메뉴를 선택할 시 작업
    @DisplayName("메뉴판에 없는 메뉴를 선택할시 예외를 반환한다.")
    @Test
    void chooseTest2() {
        // 메뉴판에 있는 메뉴항목들을 불러와줌
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 8000), new MenuItem("치킨", 18000)));
        // 메뉴판에 없는 항목을 호출시, 예외처리 해주는 작업
        assertThatCode(() -> menu.choose("피자"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 이름입니다.");
    }
}
