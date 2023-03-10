package org.example;

@FunctionalInterface
// RandomPasswordGenerator 에 상속되는 인터페이스
public interface PasswordGenerator {

    // generatePassword Method add
    String generatePassword();
}
