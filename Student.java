
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
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *과목 각각을 배열에 저장하는 메소드
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void saveSubject(Subject subject)
    {
        if (subjectCount < subjects.length){
            subjects[subjectCount++] = subject;
        } else{
            System.out.println("더 이상 입력할 수 있습니다.");
        }
    }
}