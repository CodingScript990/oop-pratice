package org.example.password;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

// Class 역할 -> Random 한 Password add 해주는 역할
// implements : 1. 상속을 의미하며
//              2. org.example.PasswordGenerator 는 RandomPasswordGenerator 에 상속된다는 의미임
//              3. 인터페이스가 Class 에 상속된다는 의미
public class RandomPasswordGenerator implements org.example.PasswordGenerator {
    /**
     * Special characters allowed in password
     */
    // private static final : ALLOWED_SPL_CHARACTERS 선언한 변수를 사용하면 재할당하지 못하며, 메모리에 한 번 올라가면 같은 값을 Class 내부의 전체 Field, Method 에서 공유 됨을 말함 -> 특수기호
    public static final String ALLOWED_SPL_CHARACTERS = "!@#$%^&*()_+";

    // private static final : ERROR_CODE 선언한 변수를 사용하면 재할당하지 못하며, 메모리에 한 번 올라가면 같은 값을 Class 내부의 전체 Field, Method 에서 공유 됨을 말함 -> 에러메시지
    public static final String ERROR_CODE = "ERRONEOUS_SPECIAL_CHARS";

    // generatePassword 멤버 함수를 사용할 것임!
    public String generatePassword() {
        // 패스워드 생성을 위해 new PasswordGenerator 생성자를 불러옴
        PasswordGenerator gen = new PasswordGenerator();

        // CharacterData 생성자에서 소문자를 기준으로 한 유효성 Check
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        // CharacterRule 생성자에서 소문자를 기준으로 한 규칙이 맞는지를 Check
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        // 소문자 규칙이 문자열상태에서 숫자형태로 소문자 규칙이 옳바른지 아닌지를 구분 짓기 위한 작업
        lowerCaseRule.setNumberOfCharacters(2);

        // CharacterData 생성자에서 대문자를 기준으로 한 유효성 Check
        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        // CharacterRule 생성자에서 대문자를 기준으로 한 규칙이 맞는지를 Check
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        // 대문자 규칙이 문자열상태에서 숫자형태로 대문자 규칙이 옳바른지 아닌지를 구분 짓기 위한 작업
        upperCaseRule.setNumberOfCharacters(2);

        // CharacterData 생성자에서 숫자와 문자 둘다를 기준으로 한 유효성 Check
        CharacterData digitChars = EnglishCharacterData.Digit;
        // CharacterRule 생성자에서 숫자와 문자 둘다를 기준으로 한 규칙이 맞는지를 Check
        CharacterRule digitRule = new CharacterRule(digitChars);
        // 문자, 숫자 둘다 규칙이 문자열상태에서 숫자형태로 무자,숫자 둘다의 규칙이 옳바른지 아닌지를 구분 짓기 위한 작업
        digitRule.setNumberOfCharacters(2);

        // 특수문자를 체크하기 위한 생성자 추가 및 new CharacterData Method 활용
        CharacterData specialChars = new CharacterData() {
            // getMethod 활용!
            // Error_Code 반환
            @Override
            public String getErrorCode() {
                return ERROR_CODE;
            }
            
            // getMethod 활용!
            // ALLOWED_SPL_CHARACTERS 반환
            @Override
            public String getCharacters() {
                return ALLOWED_SPL_CHARACTERS;
            }
        };
        // 특수문자의 유효성과 규칙이 맞는지를 Check 하기 위한 new CharacterRule Method 활용
        CharacterRule splCharRule = new CharacterRule(specialChars);
        // 특수문자 규칙이 맞는지를 최종 체크!
        splCharRule.setNumberOfCharacters(2);

        // 0 ~ 12
        // random Password 를 생성 해주는 작업
        return gen.generatePassword((int) (Math.random() * 13), splCharRule, lowerCaseRule, upperCaseRule, digitRule);
    }
}
