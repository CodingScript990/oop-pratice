package org.example;

// CorrectFixedPasswordGenerator Class 는 PasswordGenerator 에게 상속 받음!
public class CorrectFixedPasswordGenerator implements PasswordGenerator {

    // FunctionalInterface 가 있으면 구현체를 만들 필요가 없었음!
    // generatePassword Method add
    @Override
    public String generatePassword() {
        // 올바른 generatePassword Value 을 설정해줌
        return "abcdefgh"; // 8글자
    }
}
