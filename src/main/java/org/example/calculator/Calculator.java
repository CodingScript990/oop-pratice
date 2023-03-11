package org.example.calculator;

import org.example.calculator.operator.*;

import java.util.List;

// 코드의 재활용성! -> Calculator Public Class
public class Calculator {
    // List 형태로 생성자들을 불러와서 피연산자들을 계산 할 수 있는 환경을 만들어 줌
    // Interface 를 이용하여 각 구현체들의 역할일때 사용할 수 있도록 해줌
    // 상위 Interface (NewArithmeticOperator) -> List.of method (new 생성자들 사용!)
    private static final List<NewArithmeticOperator> arithmeticOperator = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());
    // 덧셈 연산자를 사용 할 수 있게 calculate method 를 생성해줌
    // operand1, operand2 -> 피연산자!
    // operator -> 연산자!
    // operand1 +(operator) operand2 -> 이런식으로 사용하겠다는 것을 보여줌
    public static int calculate(int operand1, String operator, int operand2) {
        // 2. if 조건문에서 연산자가 해당되면, 결과물을 실행하라 -> 리팩토링 잘됨!
        // + 연산자 일때
        /**
        if ("+".equals(operator)) {
            // 피연산자 1,2 반환해줌
            return operand1 + operand2;
        } // - 연산자 일때
        else if ("-".equals(operator)) {
            // 피연산자 1,2 반환해줌
            return operand1 - operand2;
        } // * 연산자 일때
        else if ("*".equals(operator)) {
            // 피연산자 1,2 반환해줌
            return operand1 * operand2;
        } // / 연산자 일때
        else if ("/".equals(operator)) {
            // 피연산자 1,2 반환해줌
            return operand1 / operand2;
        }
        // return 으로 default value 설정
        return 0;
         */

        // 1. 피연산자만으로 연산자 없이 Calculator 하기 -> 리팩토링 잘됨!
//        return operand1 + operand2;

        // 3. ArithmeticOperator enum 을 활용하여 작업하게 함! 이전은 직접 작업했지만, 이번은 미리 짜놓은 코드를 재활용하는 것! -> 코드의 재활용성↑, 코드의 간결성↑, 결합도↑
//        return ArithmeticOperator.calculate(operand1, operator, operand2);

        // 4. 상위 Interface 를 이용하여 new 생성자들이 실행되면서 True 이면 동작하고 아니면 IllegalArgumentException("message") 까지 나오도록 작업해줌! 그리고 3번과 동일하게 filter 를 통해서 arithmeticOperator 의 연산자가 +,-,*,/ 이면 그에 맞게 동작해주는 역할을 해주고, map 을 통해서 피연산자 들이 연산자와 묶어 계산이 잘될 수 있게 진행해주는 작업을 해주고, 실행은 첫 번째 연산자 부터 이고, 실행중 False 이면 "올바른 사칙연산이 아닙니다." 문구가 나오게 해줌! -> 리팩토링
        return arithmeticOperator.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
