package org.example;

public class User {
    // Private 접근 제어자를 활용해 User class 안에서만 접근 가능한 String 객체를 이용하게 함
    private String password;

    // Public 접근 제어자를 활용해서 initPassword Method 를 작성해줌 -> RandomPasswordGenerator Class 안에 Method 등을 활용하기 위한 작업!
    // initPassword 에서 PasswordGenerator 로 부터 passwordGenerator 매개변수가 상속 받게 만들건데?(상위 Interface)

    // [To-Be] -> PasswordGenerator passwordGenerator(상위 Interface 활용)
    public void initPassword(PasswordGenerator passwordGenerator) {
        // 이전에 만든 RandomPasswordGenerator 생성자를 활용함
        // TDD 에서 RandomPasswordGenerator 에서 문제가 발생 하지 않도록 작업을 실시함! -> 길이를 정해주는 작업!

        // RandomPasswordGenerator 생성자는 내부 메서드를 사용하기에 문제가 발생시키기도 함! 그래서 사용하지 않고, 상위 인터페이스를 생성하여 TDD 단계에서 문제가 발생되지 않도록 설정해줌! -> Test code 를 작성도중 쉬운 코드만을 활용하다보면 낮은 결합도를 가진 설계로 인하여 문제가 발생한다는 의미!
//  [As-Is]      RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // Password 를 생성하기 위한 작업
        // passwordGenerator 매개변수에서 generatePassword() 가 없음! -> PasswordGenerator 에 generatePassword Method 를 추가해줌!
        String password = passwordGenerator.generatePassword();
        /**
            비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        // if 조건문으로 password 가 조건에 해당되면? password 로 부터 초기화 작업 해줌!
        if(password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    // Getter Method -> getPassword
    public String getPassword() {
        // 초기화 작업을 해줌 -> password
        return password;
    }
}
