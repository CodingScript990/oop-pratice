package org.example.calculator;

import org.example.calculator.Calculator;
import org.example.calculator.operator.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
    [요구사항]
    1. 간단한 사칙연산을 할 수 있어야함
    2. 양수로만 계산 할 수 있어야함
    3. 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시켜야 함
    4. MVC 패턴(Model-View-Controller) 기반으로 구현 해야함
 */
public class CalculatorTest {

    /**
        P(연산자) + P(연산자) -> Calculator 에 전달하는 역할!
        1 + 1 > 2 (Public Interface 로 연산자들이 실행될때 마다 Calculator 에게 상속받아 재활용되기 좋도록 작업해줌)
        Test Method add
        Test 의도? -> 덧셈 연산 수행
    */
//    @DisplayName("덧셈 연산을 수행한다.")
//    @Test
//    void additionTest() {
//        // Calculator 에게 calculate Method 를 전달 받도록 함
//        int result = Calculator.calculate(1, "+", 1);
//        // Calculator 가 True 인지를 Test!
//        assertThat(result).isEqualTo(2);
//    }

    /**
        P(연산자) - P(연산자) -> Calculator 에 전달하는 역할!
        2 - 1 > 1 (Public Interface 로 연산자들이 실행될때 마다 Calculator 에게 상속받아 재활용되기 좋도록 작업해줌)
        Test Method add
        Test 의도? -> 뺄셈 연산 수행
     */
//    @DisplayName("뺄셈 연산을 수행한다.")
//    @Test
//    void subtractionTest() {
//        // Calculator 에게 calculate Method 를 전달 받도록 함
//        int result = Calculator.calculate(2, "-", 1);
//        // Calculator 가 True 인지를 Test!
//        assertThat(result).isEqualTo(1);
//    }
    // Test 연산자 계산을 매번 Test Method 를 생성해서 하지 않고 한번에 사용할 수 있도록 해줌
    // ParameterizedTest : Annotation 을 추가하는 것을 말함, 테스트를 효율적으로 사용하기 위함
    // MethodSource : 복잡한 인수들을 Parameter 로 넘기는 것을 말함, Stream 를 반환하는 Static Method 를 작성함
    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    // formulaAndResult -> 피연산자1, 2 와 연산자 계산을 할 수 있게 해주는 메소드 실행!
    @MethodSource("formulaAndResult")
    // void calculateTest(매개변수1, 매개변수2, ..., 매개변수n) : 매개변수로 받아서 return 타입 없이 결과 값을 되돌려주지 않고 결과 값만 바로 출력해주겠다는 의미임(void)
    void calculateTest(int operand1, String operator, int operand2, int result) {
        // 1. int calculateResult : 정수형 상태를 가진 변수를 생성하여
        // 2. Calculator Class 안에 calculate Method 속성을 이용하는데
        // 3. calculate 속성에 사용될 매개변수를 넣고
        // 4. calculate 결과 값들이 피연산자1,2 연산자가 잘 출력이 되도록 체크해줌(유효성 검사)
        int calculateResult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
        // assertThat : calculateResult parameter 값들을 비교하고자 할때 사용!
        // isEqualTo : result 값과 calculateResult 값을 비교하여 같은지 체크!
        assertThat(calculateResult).isEqualTo(result);
    }

    // formulaAndResult Method add
    /**
     * Stream
              1. 람다를 활용할 수 있는 기술 중 하나이며,
              2. java8 이전에는 Array or 컬렉션 instance 를 다루는 방법이 for or foreach 문을 돌면서 요소 하나    씩 꺼내서 다루는 방법 이었음,
              3. 간단한 경우에는 상관없는데, 로직이 복잡해 질 수 록 코드의 양이 많아져 여러 로직이 섞이게 되고,
              4. Method 를 나눌 경우 loop 를 여러번 도는 경우도 발생함
              5. Array or 컬렉션 instance 에 함수 여러개를 조합해 원하는 결과를 필터링 하고 가공된 결과를 얻을 수     있음
              6. 람다를 이용해 코드의 양을 줄이고 간결하게 표현 할 수 있음
              7. Array 와 컬렉션을 함수형으로 처리 할 수 있음
              8. 간단하게 multi-threading(병렬처리)가 가능함

     **Multi-Threading(병렬처리)
              - 하나의 작업을 둘 이상의 작업으로 잘게 나눠서 동시에 진행하는 것

     ** Stream 3가지
              1. 생성하기 -> 스트림 인스턴스 생성
              2. 가공하기 -> filtering or mapping 등 원하는 결과를 만들어가는 intermediate operations(중간작업)
              3. 결과만들기 -> 최종적으로 결과를 만들어내는 작업(terminal operations)
    */
    // private : 내부에서만 사용되게 해주는 것
    // Stream<Arguments> : Parameter 를 여러개 넘겨 반환해 주기 위한 것

    // 이대로 실행하면 에러가남! 이유는?
    /**
        * 간단하게 static 이 붙는 변수와 static 이 붙지 않는 변수를 정리하겠음

        1. Static 이 붙는 변수
            - 전역변수이고
            - 직접 대입이 가능하며
            - public 이 사용이 된다는 점
            - private 를 사용하더라도 static 이 붙어야 함
            - Class Variable 이라고 불림
            - 메모리 공간은 자료형 크기만큼 임

        2. Static 이 붙지 않는 변수
            - 전역이 아니고, Instance Variable 임
            - 직접대입이 불가능하고, new 를 사용하여 Class 의 Instance 를 먼저 만들어야 사용이 가능함
            - private, public 과 관계가 없음
            - Instance(인스턴스) = Property(속성) = Member Variable(멤버변수) 라 불림
            - 메모리 공간은 new 로 생성된 수만큼 확보가 되고, 선언된 시점의 {} 안에서 유효하며, {} 바깥에서는 메모리에서 적절히 소멸이 됨

                -> 지역변수(Local Variable)?
                    - {} [Unit Block] 안에서 LifeCycle(생명주기)를 가지는 Variable 를 말함
                    - Static Method 의 {} 안에서 선언된 Varialbe 는 별개의 thread 에 의해 동시에 진입되더라도 독립된 메모리영역에서 생성되어진 값으로 사용됨
                    - static method 의 {} 안의 선언된 Variable 와 static 이 아닌 Method 의 {} 안의 선언된 Variable 는 똑같이 Local Variable 임
     */
//    private Stream<Arguments> formulaAndResult() { <- static 이 붙지 않아 에러남!
    // static 을 붙였을때!
    private static Stream<Arguments> formulaAndResult() {
        /**
            Stream.of()
            - 특정 Object를 요소로 갖는 Stream을 생성하고 싶을 때 사용함
        */
        return Stream.of(
                // 1. Arguments 는 연산자 + 피연산자 + 연산자를 가지겠다는 의미(+,-,*,/)
                // 2. *, / 기에서 에러난 이유는 Calculator Class 에서 calculate method 에서 if 조건문으로 *, / 값을 반환 해주는 작업을 안해줘서 에러남!
                arguments(1, "+", 1, 2),
                arguments(2, "-", 1, 1),
                arguments(2, "*", 2, 4),
                arguments(6, "/", 2, 3)
        );
    }

    // 3. PositiveNumber 에서 이미 0 이 될 수 없는 예외처리를 하였기에 TestCode 를 할 필요가 없으므로 제거해줌!
    // 나눗셈에서 0을 나누는 경우 예외를 발생시키는 작업
    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
    @Test
    void calculateExceptionTest() {
        // Calculator Class 에서 calculate method 속성 중 나눗셈 연산자 사용!
        // assertThatCode : calculateResult parameter 값들을 비교하고자 할때 사용!
        // 1. calculate method 에서 에러가남! -> Why?
        // 1-2. DivisionOperator Class 에서 에러사항을 수정작업해서 결과물이 정상 작동 되도록 하는 방법
        // 1-2. ArithmeticOperator enum 에서 Division 에서 return 값에서 수정 작업해주는 방법
        // 2. PositiveNumber 을 가지고 양수인지 아닌지 체크하는 작업 후 int type 까지 변환 후 결과물 실행!
        // 2-1. 에러난 이유는 PositiveNumber Type 으로 변환 해줌
        // 2-2. 에러 메세지가 나온 이유는 PositiveNumber 에서 validate method 에 설정한 value 값이 해당되기에 Output 으로 메세지가 출력되는 것임!
        // 2-3. 그래서 결론은 DivisionOperator Class 에서 calculate method 안에서 예외처리를 해주는 작업을 해줄 필요가 없기에 제거 해줌! -> why? 이유는 PositiveNumber 에서 예외처리를 해주기 때문임
        assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
                /**
                 * isInstanceOf
                    - Object Type 을 확인하는 연산자임
                    - 형변환 가능여부를 확인하며, True / False 로 결과를 반환함
                    - 주로 상속관계에 부모 Object 인지 자식 Object 인지 확인하는데 사용됨
                 */
                // isInstanceOf 는 IllegalArgumentException 에서 위의 Calculator 값이 올바르지 않으면 에러 메세지를 보여주는 역할을 해주거나, 일치하면 에러 메세지를 보여주지 않고, 정상 작동을 함!
                .isInstanceOf(IllegalArgumentException.class)
                //  hasMessage method 는 에러가 난다면 메세지를 Output 에 보여주는 역할을 하는 것임!(해당될때 실행됨!)
                .hasMessage("0으로는 나눌 수 없습니다.");
    }
}
