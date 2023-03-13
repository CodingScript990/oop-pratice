package org.example.credit_calculator;

import java.util.List;

// 일급 컬렉션을 사용함!
// GradeCalculator 에서 courses 에게서 받은 정보들을 Courses Class 에서 작업해준다는 의미!
public class Courses {
    // List type courses variable 초기화 값 add
    private final List<Course> courses;

    // Courses List<Course> 생성자 add
    // 1. GradeCalculator 에게서 받은 Courses 정보들을 대입해주는 과정!
    public Courses(List<Course> courses) {
        // courses 를 받아 courses 로 대입 해줌!
        this.courses = courses;
    }

    // double type multiplyCreditAndCourseGrade()
    // 2. multiplyCreditAndCourseGrade 에서는 Courses 의 정보들을 모두 합쳐주는 작업!
    public double multiplyCreditAndCourseGrade() {
        // After
        // 2-1. 학점수 X 교과목 평점으 합계를 간편하게 작업해줌!
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();

        // Before
        // 2-1. double type variable add
        //double multipliedCreditAndCourseGrade = 0;

        // 향상된 확장 for 문을 이용하혀 List(자료형)타입 course(변수명)를 설정하여 courses(배열명)를 출력해 줌
        //for(Course course:courses) { // 2번
            // 2-2. 교과목 학점수를 나타내주는 Method 로 전달 받고, 교과목 숫자로 변경해주는 Method 로 값을 전달받고
            // 2-3. 2-2번을 가지고 합계를 나타내줌!

            // 에러사항이 있음! Course 에서 계산이 이루어 져야하는데, GradeCalculator 에서 작업이 이루어짐!
            // 즉, 원래라면 Course 에서 받는다면 문제가 없겠지만, GradeCalculator 에서 받는다면 만약에, 지금은 한 군데에서 작업이 이루어지지만, 여러 곳에서 일어나면 해당되는 곳에 모두 수정 작업을 해줘야하는 에러사항이 존재함! -> "응집도" 가 약하다는 것!

            // Before
            // getter 를 가지고 작업을 한 경우! -> 해당되는 곳 마다 수정작업을 각각 해줘야함!(에러사항)
            // multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();

            // After
            // getter 를 사용하지 않는 경우! -> 해당되는 객체의 정보만 넘겨줘서 처리해주는 작업을 실시함! 즉, 이전 방법과 다른 것은 각각 수정작업을 해주지 않고, 해당 정보의 객체가 정해놓은 메소드에서 만 할당 및 수정작업해 진행을 해주면 된다는 의미임! -> 유지보수에 용이하고, 코드의 유연성을 높여줌
            //multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
            //                           (정보를 가진 객체를?).(전달을 해주는데?)
        }
        // 해당되지 않으면 return!
        //return multipliedCreditAndCourseGrade;
    //}

    // 총학점 수를 합쳐주는 작업!
    public int calculateTotalCompletedCredit() {
        // 3. 수강신청 총 학점 수 구하기!
        // - int type totalCompletedCredit(변수명) 을 설정하여 courses 이수한 과목들을 전부 가져와서 합함!
        return
                // 3-1. courses 이수한 과목들을 불러오는데?
                courses.stream()
                        // 3-2. 전부 나열하여!
                        .mapToInt(Course::getCredit)
                        // 3-3. 나옇한 courses 들을 합함!
                        .sum();
    }
}
