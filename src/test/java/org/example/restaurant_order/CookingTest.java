package org.example.restaurant_order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

// 요리사 Type Test Class
public class CookingTest {
    // 요리사 -- 해당 메뉴를 만듬!(손님이 주문한 메뉴판에 있는 음식을 말함)
    // 메뉴항목에 있는 음식을 요리하는 Method 를 생성
    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    @Test
    void makeCookTest() {
        /**
         * [순서도]
         * 1.        손님(손님)
         *            ↓
         * 2.     메뉴항목 주문(손님)
         *            ↓
         * 3.   요리사 메뉴항목 체크(요리사)
         *            ↓
         * 4. 손님이 주문한 메뉴음식 만듬(요리사)
         * */
        // after -> Cook Class 에서 Object value 를 비교할 수 있는 method add
        // 요리사 객체를 생성해줌!
        Cooking cooking = new Cooking();
        // 손님이 시킨 메뉴항목을 설정해줌!
        MenuItem menuItem = new MenuItem("돈까스", 8000);
        // 요리사 객체에게 손님이 주문한 메뉴항목 음식을 만들어라고 시킴!
        Cook cook = cooking.makeCook(menuItem);
        // 요리사가 만든 음식이 손님이 주문한 메뉴항목의 음식이 맞는지 체크!
        assertThat(cook).isEqualTo(new Cook("돈까스", 8000));
    }
}
