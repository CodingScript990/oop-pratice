package org.example;

// WrongFixedPasswordGenerator class -> 잘못 생성된 Generator 일때
public class WrongFixedPasswordGenerator implements PasswordGenerator {

    // generatePassword Method add
    // 잘못 생성된 Generator value 값을 반환 해줌
    @Override
    public String generatePassword() {
        // 2글자
        return "ab";
    }
}
