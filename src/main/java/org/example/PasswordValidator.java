package org.example;

public class PasswordValidator {
    // private static final : WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE 선언한 변수를 사용하면 재할당하지 못하며, 메모리에 한 번 올라가면 같은 값을 Class 내부의 전체 Field, Method 에서 공유 됨을 말함
    private static final String WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE = "비밀번호는 최소 8자 이상 12자 이하여야 한다.";

    public static void validate(String password) {
        // 리팩토링 과정!
        // int type length add => password length method
        int length = password.length();

        // 만약 length 가 8 보다 작거나 또는 length 가 12보다 크면?
        if (length < 8 || length > 12) {
            // throw : 강제로 오류를 발생 시키는데?
            // new : length 가 8 보다 작거나, 12보다 크면 new 연산자를 통해
            // IllegalArgumentException : 객체가 만들어짐!
            // 풀이하면? length 가 8 보다 작거나, 12보다 크면 강제로 오류 메세지가 발생한다는 의미!
            throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
