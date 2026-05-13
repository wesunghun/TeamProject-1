/**
 * Subject 클래스 - 과목의 성적 정보를 저장하고 관리하는 클래스
 * 과목 객체 클래스
 * @author Team#9_(2023320024 위성훈, 2023320045 김동균, 2023320017 정윤재, 2023320002 노승렬)
 * @version (2026.05.10.)
 */
public class Subject
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private String sjName; //과목명
    private String pfName; //담당 교수명
    private double midtermEx; //중간점수
    private double finalEx; //기말점수
    private double assign; //과제점수
    private double attend; //출석점수

    /**
     * Subject 클래스의 객체 생성자
     */
    public Subject(String sjName, String pfName, double midtermEx, double finalEx, double assign, 
    double attend)
    {
        // 인스턴스 변수 초기화
        this.sjName = sjName;
        this.pfName = pfName;
        this.midtermEx = midtermEx;
        this.finalEx = finalEx;
        this.assign = assign;
        this.attend = attend;
    }

    /**
     * 과목명을 반환하는 메소드
     *
     * @return    과목명
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
    public double calculateTotal()
    {
        return midtermEx + finalEx + assign + attend;
    }

    /**
     * 과목 등급을 반환하는 메소드
     *
     * @return    과목 등급
     */
    public String getGrade()
    {   
        // 총점 계산
        double total = calculateTotal();
        if (95 <= total && total <= 100){ // 총점을 기준으로 등급 반환
            return "A+";
        } else if(90 <= total && total <= 94){
            return "A0";
        } else if(85 <= total && total <= 89){
            return "B+";
        } else if(80 <= total && total <= 84){
            return "B0";
        } else if(75 <= total && total <= 79){
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
     * @return    과목 평점
     */
    public double getGPA()
    {   
        String grade = getGrade(); // 과목 등급 저장
        switch(grade){ // 등급 기준으로 평점 반환
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

    /**
     * 중간점수를 수정하는 메소드
     *
     * @param midtermEx 중간점수
     */
    public void setMidtermEx(double midtermEx)
    { 
        this.midtermEx = midtermEx; 
    }

    /**
     * 기말점수를 수정하는 메소드
     * 
     * @param finalEx 기말점수
     */
    public void setFinalEx(double finalEx)
    { 
        this.finalEx = finalEx; 
    }

    /**
     * 과제점수를 수정하는 메소드
     * 
     * @param assignment 과제점수
     */
    public void setAssignEx(double assign)
    { 
        this.assign = assign; 
    }

    /**
     * 출석점수를 수정하는 메소드
     * 
     * @param attend 출석점수
     */
    public void setAttendEx(double attend)
    { 
        this.attend = attend; 
    }

    /**
     * 과목의 정보를 반환하는 메소드
     *
     * @return   과목 정보
     */
    public String getSjInformation()
    {   // 과목별 성적 정보를 문자열 형태로 저장
        String information = sjName + " " +
            pfName + "교수 " +
            midtermEx + " " + 
            finalEx + " " +
            assign + " " +
            attend + " " +
            calculateTotal() + "점 " +
            getGrade();
        return information; 
    }

}