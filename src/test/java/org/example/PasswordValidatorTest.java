package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

/**
    [요구사항]

    1. 비밀번호는 최소 8자 이상 12자 이하여야 함
    2. 비밀번호가 8자 미만 또는 12자 초과인 경우 IIlegalArgumentException 예외를 발생 시킴
    3. 경계조건에 대해 테스트 코드를 작성해야 함
 */
public class PasswordValidatorTest {
    // Test Method add
    // DisplayName : 메소드 의도의 이름 -> 문서화 역할을 함!(어떤의미 인지를 말해줌)
    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않음!")
    @Test
    void validatePasswordTest() {
        // TDD 과정!
        // PasswordValidator Object 에서 validate 에 있는 값을 불러옴 그러나 예외는 발생시키지 않음!
        // 1. Class 가 없어서 에러가 난거임
        // 2. Method 가 없어서 에러가 난거임
        // 3. Class, Method 생성 후 에러가 나지 않는지 확인
        // 4. 에러가 나지 않으면 TDD 과정 끝
        assertThatCode(() -> PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 or 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    void validatePasswordTest2() {
        // 메서드가 호출 되는데, 해당 인젝션 타입은 인스턴스 타입은 IllegalArgumentException.class 이고
        // 해당 메세지를 보여준다!
        assertThatCode(() -> PasswordValidator.validate("aabb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
