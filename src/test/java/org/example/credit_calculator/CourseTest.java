package org.example.credit_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

// 이수과목 Test Code
public class CourseTest {

    // 과목(코스)를 생성 해줌 -> createTest method add
    @DisplayName("과목(코스)를 생성한다.")
    @Test
    void createTest() {
        // 과목이 생성되는데? new 생성자에서 문제가 없다면? 어떠한 메세지도 남기지 않는 상태로 만들어라!
        // new Course : 과목을 생성해주는 new 생성자 -> new Course(value1,value2,value3)
        assertThatCode(() -> new Course("OOP", 3, "A+"))
                // doesNotThrowAnyException : 어떠한 상태도 발생하지 않도록 하는 Method 임
                .doesNotThrowAnyException();
    }
}
