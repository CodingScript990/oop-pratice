package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

/**
    [요구사항]

    1. 비밀번호는 최소 8자 이상 12자 이하여야 함
    2. 비밀번호가 8자 미만 또는 12자 초과인 경우 IIlegalArgumentException 예외를 발생 시킴
    3. 경계조건에 대해 테스트 코드를 작성해야 함
 */
/**
    경계 조건은 아주 중요! 대부분 경계 조건에서 에러가 발생함!
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

    // Test Method add
    // ParameterizedTest : Annotation 을 추가하는 것을 제외하고 다른 Test 와 동일하게 만들어주는 역할
    // ValueSource : 1. 해당 Annotation 에 지정한 Array Parameter Value 로 순서대로 넘겨 주는 역할
    //               2. 풀이(문자열에서, 8자 미만 & 12자 초과시 경계값 조성)
    //               3. Test Method 실행 당 하나의 Argument(인수) 만을 전달할 때 사용되어 짐
    //               4. 리터럴 값의 Array 를 Test Method 에 전달해 줌
    @DisplayName("비밀번호가 8자 미만 or 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aabbccd", "aabbccddeeffg"})
    void validatePasswordTest2(String password) {
        // 메서드가 호출 되는데, 해당 인젝션 타입은 인스턴스 타입은 IllegalArgumentException.class 이고
        // 해당 메세지를 보여준다!
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
