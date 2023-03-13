package org.example.calculator;

import org.example.calculator.operator.PositiveNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatCode;

// CalculatorTest 에서 하지 않고 따로 Test 를 할 수 있는 곳에서 해줌
public class PositiveNumberTest {

    @ParameterizedTest
    // 0 과 -1 이 value 인데? createTest 에서 value 값으로 전달되어, assertThatCode method 에서 new 생성자안에 value 를 통해서 값이 정상적으로 잘 수행이 되었다면? True 의 값이 나올 것이고, 그게 아니라면 IllegalArgumentException.class 에서 예외처리 중 메세지를 남겨주는 코드를 실행해서 Output 에 보여줘라!
    @ValueSource(ints = {0, -1})
    void createTest(int value) {
        assertThatCode(() -> new PositiveNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 or 음수를 전달 할 수 있습니다.");
    }
}
