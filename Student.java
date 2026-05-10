
/**
 * Student 클래스의 설명을 작성하세요.
 *학생 객체 클래스
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Student
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private long stID; // 학번
    private String name; //학생 이름
    private String dept; //학과
    private int grade; //학년
    private int year; //년도
    private int term; //학기
    private Subject[] subjects; //과목 정보를 저장하는 배열
    private int subjectCount; //과목 수

    /**
     * Student 클래스의 객체 생성자
     */
    public Student(long stID, String name, String dept, int grade, int year, int term, int 
    maxSubjects)
    {
        // 인스턴스 변수 초기화
        this.stID = stID;
        this.name = name;
        this.dept = dept;
        this.grade = grade;
        this.year = year;
        this.term = term;
        this.subjects = new Subject[maxSubjects]; //과목 정보를 저장하는 배열
        this.subjectCount = 0; 
    }

    /**
     *과목 각각을 배열에 저장하는 메소드
     * @param  subject 과목 객체
     */
    public void saveSubject(Subject subject)
    {
        if (subjectCount < subjects.length){
            subjects[subjectCount++] = subject;
        } else{
            System.out.println("더 이상 입력할 수 없습니다.");
        }
    }

    /**
     * 총 과목 평점을 계산하는 메소드
     *
     * @return    총 과목 평점 / 과목수
     */
    public double calculateGPA()
    {
        if (subjectCount == 0){
            return 0.0;
        }

        double totalScore = 0.0;
        for (int i = 0; i < subjectCount; i++){
            totalScore += subjects[i].getGPA();
        }

        return totalScore / subjectCount;
    }

    /**
     * 성적을 출력하는 메소드
     *
     */
    public void printInformation()
    {
        System.out.println("=================종합 성적 공지=================");
        System.out.println("이름: " + name + ", 학번: " + stID + ", 학과: " + dept +
                                ", 학년: " + grade);
        System.out.println(year + "년, " + term + "학기");
        System.out.println();
        
        for (int i = 0; i < subjectCount; i++){
            String info = subjects[i].getSjInformation();
            System.out.println(info);
        }
        
        System.out.println("==========================================");
        System.out.println(stID + " " + name + "님의 종합 성적을 공지하겠습니다.");
        System.out.println("과목 수 " + subjectCount + "개, 학점 평점은 " + 
                            calculateGPA() + "입니다.");
    }

}