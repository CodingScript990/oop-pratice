package org.example.restaurant_order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

// 요리 타입 Test Class
public class CookTest {
    // DisplayName -> 요리를 생성함
    // Test -> 요리를 생성해주는 method add
    @DisplayName("요리를 만든다.")
    @Test
    void createTest() {
        // 음식을 생성해주는 작업을 실시함!
        // new Cook 생성자를 가지고 음식이라는 객체를 생성해줌
        // doesNotThrowAnyException() : 어떠한 작업들이 일어나지 않도록 방지
        assertThatCode(() -> new Cook("만두", 7000))
                .doesNotThrowAnyException();
    }
}
