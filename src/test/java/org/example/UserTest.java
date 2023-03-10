package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 프로덕션 코드가 만들어진 후 Test 작업을 하는 경우도 있음
class UserTest {

    // Test Method add
    // DisplayName 을 활용해서 어떤 의미인지 문서화 작업!
    @DisplayName("패스워드를 초기화한다.")
    @Test
    // passwordTest Method add
    void passwordTest() {
        // Given(주어 졌을때?)
        // User Class 를 passwordTest Method 에 불러옴
        User user = new User();

        // When(언제?어디에서?)
        // User class 에서 initPassword Method 를 불러옴
        // CorrectFixedPasswordGenerator Class 안에서 generatePassword Method 에 설정한 Value 값이 True 인 것을 셋팅 해줌 -> 결국 TDD 에서 에러가 나지 않도록 예방함 -> GeneratePassword Value -> 8글자(True)

        // FunctionalInterface (PasswordGenerator Interface) 을 사용하면 람다 형태로 구현체를 받도록 해줌!
        user.initPassword(() -> "abcdefgh");

        // Then(그 다음은?)
        // user Class 에서 Get Password Method 를 이용하여 값이 Null 값이 아닌 상태를 원함!
        assertThat(user.getPassword()).isNotNull();
    }

    // Test Method add
    // DisplayName 을 활용해서 어떤 의미인지 문서화 작업!
    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2(){
        // Given(주어 졌을때?)
        // User Class 를 passwordTest Method 에 불러옴
        User user = new User();

        // When(언제?어디에서?)
        // User class 에서 initPassword Method 를 불러옴
        // WrongFixedPasswordGenerator Class 안에서 generatePassword Method 에 설정한 Value 값이 False 인 것을 셋팅 해줌 -> GeneratePassword Value -> 2글자(False)

        // FunctionalInterface (PasswordGenerator Interface) 을 사용하면 람다 형태로 구현체를 받도록 해줌!
        user.initPassword(() -> "ab");

        // Then(그 다음은?)
        // user Class 에서 Get Password Method 를 이용하여 Null 값이 오는 것을 허용!
        assertThat(user.getPassword()).isNull();
    }
}
