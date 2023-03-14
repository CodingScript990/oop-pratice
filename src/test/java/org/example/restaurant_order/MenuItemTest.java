package org.example.restaurant_order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

// 메뉴 Type Test Class
public class MenuItemTest {
    // DisplayName -> 메뉴항목을 생성함
    // Test -> 메뉴 항목을 생성해주는 method add
    @DisplayName("메뉴항목을 생성한다.")
    @Test
    void createTest() {
        assertThatCode(() -> new MenuItem("만두", 7000))
                .doesNotThrowAnyException();
    }
}
