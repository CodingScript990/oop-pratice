package org.example.credit_calculator;

// Course Class -> 과목 클래스(생성자)
public class Course {
    // 각 Object 의 값을 초기화 해줌
    private final String subject; // 과목명
    private final int credit; // 학점명
    private final String grade; // 성적 (A+, A, B+, B, ...)
    // Course (parameter1(과목), parameter2(학점), parameter3(성적정보))
    public Course(String subject, int credit, String grade) {

        // 각각의 정보를 받아와 줌
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    // (학점수 X 교과목 평점)의 합계를 구해주는 작업! -> double type multiplyCreditAndCourseGrade()
    // 객체에게 전달받은 정보들을 multiplyCreditAndCourseGrade 에 해당되는 것들만 수정 및 할당해 줌
    public double multiplyCreditAndCourseGrade() {
        // 해당 Object 에게 값을 위임해주는 상태로 변경!
        // 여기에서 모든 작업이 이루어져서 다른 곳에서 까지 수정작업이 필요 없다는 의미!
        return credit * getGradeToNumber();
    }

    // 교과목 학점수 Method -> int type getCredit()
    public int getCredit() {
        // credit 의 값을 반환해줌 -> 학점을 return 받음
        return credit;
    }

    // String 상태를 double type 으로 변환하여 출력해주기 위한 Method -> double type getGradeToNumber()
    public double getGradeToNumber() {

        // 학점 초기값 설정
        double grade = 0;

        // switch 문으로 학점이(String) 에 해당되면 grade(변수) 에게 double 타입을 반환해서 break 문으로 종료!
        // 해당된 String(학점)값이 없으면 case 문에 해당되는 조건까지 내려가서 출력되도록 만듬
        switch (this.grade) {
            // A+(String) -> 4.5(double)
            case "A+":
                grade = 4.5;
                break;
            case "A":
                grade = 4.0;
                break;
            case "B+":
                grade = 3.5;
                break;
            case "B":
                grade = 3.0;
                break;
            case "C+":
                grade = 2.5;
                break;
            case "C":
                grade = 2.0;
                break;
        }
        return grade;
        // 만약 해당되는 학점수가 없다면? grade 값을 반환해줌!
    }
}
