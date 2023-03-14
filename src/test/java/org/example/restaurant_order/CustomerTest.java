package org.example.restaurant_order;

// 음식점에서 음식 주문하는 과정 구현

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.example.restaurant_order.Menu;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 요구사항
 * 1. Domain 을 구성하는 Object 에는 어떤 것들이 있는지 고민해봄
 *  -> [Object] 손님, 메뉴판, 음식들, 요리사, 요리
 * 2. Object 들 간의 관계를 고민함
 *  -> 손님 -- 메뉴판
 *  -> 손님 -- 요리사
 *  -> 요리사 -- 요리
 * 3. 동적인 Object 를 정적인 Type 으로 Abstract 해서 Domain Modeling 하기
 *  -> 손님 -- 손님 타입
 *  -> 음식들 -- 요리 타입
 *  -> 메뉴판 -- 메뉴판 타입
 *  -> 메뉴 -- 메뉴 타입
 * 4. 협력을 설계하기
 * 5. Object 들을 포괄하는 Type 에 적절한 책임을 할당하기
 * 6. 구현하기
 * */

// 손님 Type Test Class
public class CustomerTest {
    // 메뉴이름에 해당하는 요리를 주문하는 작업
    @DisplayName("메뉴이름에 해당하는 요리를 주문한다.")
    @Test
    void orderTest() {
        // 손님 생성자를 불러옴 --> 1. 손님이 주문을 하는데? --> Customer 생성자
        Customer customer = new Customer();
        // 메뉴판에 메뉴들이 있는지 메뉴 리스트를 불러옴 --> Menu 생성자
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 8000), new MenuItem("치킨", 18000)));
        // 주문한 손님의 메뉴를 요리하기 위해 요리사를 불러옴 --> Cooking 생성자
        Cooking cooking = new Cooking();
        //                  --> 2. 메뉴판에 있는 메뉴를 주문하는데?
        //                  --> 3. 손님이 주문한 메뉴를 요리사가 요리를 함[문제가 없다면 요리를 진행함!]
        // 4. 메뉴판에 없는 메뉴면 에러코드를 보여주고, 메뉴판에 있는 메뉴면 정상 출력해줌!
        assertThatCode(() -> customer.order("치킨", menu, cooking))
                .doesNotThrowAnyException();
    }
}
