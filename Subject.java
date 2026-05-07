
/**
 * Subject 클래스의 설명을 작성하세요.
 *과목 객체 클래스
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Subject
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private String sjName; //과목명
    private double midtermEx; //중간점수
    private double finalEx; //기말점수
    private double assignment; //과제점수
    private double attend; //출석점수

    /**
     * Subject 클래스의 객체 생성자
     */
    public Subject(String sjName, double midtermEx, double finalEx, double assignment, double attend)
    {
        // 인스턴스 변수 초기화
        this.sjName = sjName;
        this.midtermEx = midtermEx;
        this.finalEx = finalEx;
        this.assignment = assignment;
        this.attend = attend;
    }

    /**
     * 과목명을 반환하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public String getSubjectName()
    {
        return sjName;
    }

    
    /**
     * 합계를 반환하는 메소드
     *
     * @return    중간, 기말, 과제, 출석 점수의 합
     */
    public double calculateTotal(){
        return midtermEx + finalEx + assignment + attend;
    }

    /**
     * 과목등급을 반환하는 메소드
     *
     * @return    과목 등급
     */
    public String getGrade()
    {
        double total = calculateTotal();
        if(95 <= total && total <= 100){
            return "A+";
        } else if(90 <= total && total <= 94){
            return "A0";
        } else if(85 <= total && total <= 89){
            return "B+";
        } else if(80 <= total && total<= 84){
            return "B0";
        } else if(75 <= total && total<= 79){
            return "C+";
        } else if(70 <= total && total <= 74){
            return "C0";
        } else if(65 <= total && total <= 69){
            return "D+";
        } else if(60 <= total && total <= 64){
            return "D0";
        } else {
            return "F";
        }
    }

    /**
     * 과목 평점(4.5 만점) 반환하는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public double getScore()
    {
        String grade = getGrade();
        switch(grade){
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            default:
                return 0.0;
        }
    }

}