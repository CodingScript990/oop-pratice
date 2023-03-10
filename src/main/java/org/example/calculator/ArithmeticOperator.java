package org.example.calculator;

/**
 * enum
 * 1. 상수들의 집합임
 * 2. final 로 String 과 같은 문자열이나 숫자들을 나타내는 기본 자료형의 값을 고정 할 수 있음
 * 3. 상수만으로 작성되어 있으면 Class 로 선언할 필요 없음
 * 4. Class 로 선언된 부분에 enum 이라고 선언하면 Object 는 상수의 집합을 뜻함 -> 명시적 역할
 * 5. enumeration 이라는 셈, 계산, 열거, 목록 이라는 영어단어의 앞 부분만 따서 만든 예약어임

 * 예약어
 *  - 미리 정해둔 명령어를 말함
 *  - 등록되어 있어 의미가 약속되어 있는 명령어라는 뜻임
 *  - 불필요한 시행착오를 줄이기 위해 사용됨
 *  - 속성의 변수명, 메소드명으로 사용할 수 없으며, 프로그래밍 과정에서 특정 의미가 있는 단어를 프로그래머가 식별자로 사용하     게 되면 에러나 버그가 발생 할 수 있음

 * 예약어 종류
 *  - 기본 데이터 타입 : boolean, byte, char, short, int, logn, float, double
 *  - 접근 지정자 : private, protected, public
 *  - 클래스 관련 : class, abstract, interface, extends, implements, enum
 *  - 메서드 관련 : void, return
 *  - 제어문 관련 : if, else, switch, case, default, for, do, while, break, continue
 *  - 논리 리터럴 : true, false
 *  - 예외처리 관련 : try, catch, finally, throw, throws
 *  - 기타 : transient, volatile, package, import, synchronized, native, final, static, strictfp, assert

 * 예약어 특징
 *  - abstract : 추상클래스 or 추상메소드에 사용됨
 *  - boolean : 논리형 참(true)와 거짓(false) 디폴트값은 false
 *  - break : 반복문 or Switch 문을 벗어나거나 멈출 때 사용함
 *  - byte : 데이터 정수형 타입 1 byte = 8 bit 정수형 : byte < short < int < long
 *  - case : switch 조건문에서 사용함. case 문에서는 리터럴과 상수만 허용함
 *  - catch : try~catch~finally 문에서 사용, 예외처리 할 때 사용함
 *  - char : 데이터 문자형 타입 2byte
 *  - continue : 반복문, 루프를 돌 때 현재 루프를 끝낸 뒤에 내용을 무시하고 다시 앞으로 돌아감
 *  - default : 접근제어자 및 switch 문에서 쓰임. 접근제어자는 클래스, 메소드, 멤버변수 앞에 아무것도 선언을 안하면                   default. switch 문에서 default 는 case 문을 돌다가 해당하는 case 가 없으면 default 로 실행 됨
 *  - do : do~while 문에서 쓰임
 *  - double : 데이터 실수형(변수) 타입 8byte
 *  - else : if~else 문에서 쓰임
 *  - extends : 클래스 상속에 쓰임
 *  - false : 거짓이라는 뜻으로 쓰이며 0과 같음
 *  - finally : try~catch~finally 예외처리에 쓰임
 *  - float : 데이터 실수형 타입 4byte
 *  - for : 반복문 중 하나로 초기값과 조건식 증가값이 들어감
 *  - if : 일반적으로 사용되는 조건문
 *  - implements : 인터페이스를 구현 할 때 사용
 *  - import : 패키지 내의 클래스를 불러올 때 사용
 *  - instanceof : 객체타입 검사시 사용됨
 *  - int : 데이터 정수형 4byte
 *  - interface : 일종의 추상클래스로 상속을 목적으로 만들어짐
 *  - long : 데이터 정수형 8byte
 *  - native : 자바 외 다른 프로그래밍 언어로 구현되었음을 알려주는 예약어
 *  - new : 인스턴스, 객체를 만들 때 사용
 *  - null : 메모리에 할당 되지 않은 상태
 *  - package : 클래스를 모아둔 단위
 *  - private : 접근제어자로 같은 클래스 내에서만 접근 가능
 *  - protected : 접근제어자로 같은 패키지와 상속받은 클래스에서 접근 가능
 *  - public : 접근제어자 중 가장 제한이 없는 것
 *  - return : 메소드를 종료하거나 값을 반환
 *  - short : 데이터 정수형 타입 2byte
 *  - static : 정적변수 혹은 클래스 변수
 *  - super : 상위 클래스의 생성자를 호출
 *  - switch : 조건문 중 하나
 *  - synchronized : 쓰레드 동기화를 위해 사용
 *  - this : 인스턴스가 본인을 가리킬 때 사용함
 *  - throw/throws : 예외처리에 사용
 *  - true : 참이라는 뜻으로 1과 같음
 *  - try : try~catch~finally 문에서 사용
 *  - void : 리턴값이 없음
 *  - while : 반복문 중 하나임

 * 상수(constant)
 *  - 고정된 값을 상수라고 말함
 */
public enum ArithmeticOperator {
    //
    ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");
    //
    private final String operator;

    //
    ArithmeticOperator(String operator) {
        //
        this.operator = operator;
    }

}
