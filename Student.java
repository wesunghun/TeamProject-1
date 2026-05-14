/**
 * Student 클래스 - 학생 정보와 과목 정보를 저장하고 관리하는 클래스 
 * 학생 객체 클래스
 * 
 * @author Team#9_(2023320024 위성훈, 2023320045 김동균, 2023320017 정윤재, 2023320002 노승렬)
 * @version (2026.05.15.)
 */
public class Student
{
    private long stID; // 학번
    private String name; //학생 이름
    private String dept; //학과
    private int grade; //학년
    private int year; //년도
    private int term; //학기
    private Subject[] subjects; //과목 정보를 저장하는 Subject 배열
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
        this.subjectCount = 0; // 저장된 과목 수를 0으로 초기화
    }

    /**
     * 과목 각각을 배열에 저장하는 메소드
     *
     * @param  subject 과목 객체
     */
    public void saveSubject(Subject subject)
    {
        // 현재 저장된 과목 수가 배열 크기보다 작은지 확인
        if (subjectCount < subjects.length){
            subjects[subjectCount++] = subject; // Subject 객체 배열에 과목 객체 저장
        } else{
            System.out.println("더 이상 입력할 수 없습니다."); // 배열 크기를 초과할 경우 출력
        }
    }

    /**
     * 총 과목 평점을 계산하는 메소드
     *
     * @return    총 과목 평점(GPA)
     */
    public double calculateGPA()
    {
        // 저장된 과목이 없을 경우 0.0 반환
        if (subjectCount == 0){
            return 0.0;
        }

        double totalScore = 0.0; //전체 평점

        // 저장된 과목 수만큼 반복
        for (int i = 0; i < subjectCount; i++){
            totalScore += subjects[i].getGPA(); //과목별 평점을 누적
        }
        double GPA = totalScore / subjectCount;
        return GPA; // 전체 평점을 과목 수로 나누어 평균 평점 반환
    }

    /**
     * 성적을 출력하는 메소드
     *
     */
    public void printInformation()
    {
        System.out.println("=================종합 성적 공지===================="); // 종합 성적 출력
        System.out.println("이름: " + name + ", 학번: " + stID + ", 학과: " + dept + 
            ", 학년: " + grade); // 학생 기본 정보 출력
        System.out.println(year + "년, " + term + "학기"); // 년도 및 학기 출력
        System.out.println();

        // 저장된 과목 수만큼 반복
        for (int i = 0; i < subjectCount; i++){
            String info = subjects[i].getSjInformation(); // 과목별 성적 정보 반환
            System.out.println(info); // 과목별 성적 출력
        }

        // 종합 성적 결과 출력
        System.out.println("=================================================");
        System.out.println(stID + " " + name + "님의 종합 성적은 다음과 같습니다.");
        System.out.printf("과목 수 %d개, 학점 평점은 %.1f, ", subjectCount, calculateGPA());
    }

    /**
     * 학번을 반환하는 메소드
     *
     * @return    학번
     */
    public long getStID()
    {
        // 학번 반환
        return this.stID;
    }

    /**
     * 이름을 반환하는 메소드
     *
     * @return    이름
     */
    public String getName()
    {
        // 이름 반환
        return this.name;
    }

    /**
     * 과목 객체를 반환하는 메소드
     *
     * @param  sjName 과목명
     * @return    subject 과목객체
     */
    public Subject getSubject(String sjName)
    {
        for (Subject subject : subjects){
            if (subject == null){
                break;
            }
            if (subject.getSubjectName() == sjName){
                return subject;
            }
        }
        return null; // 해당 과목을 수강하지 않은 경우
    }

    /**
     * 과목 수를 반환하는 메소드
     * 
     * @return    과목 수 
     */
    public int getSjCount()
    {
        return subjectCount; 
    }

    /**
     * 인덱스로 과목 객체를 반환하는 메소드
     *
     * @param index 과목 인덱스
     * @return    과목 객체
     */
    public Subject getSubject(int index)
    { 
        return subjects[index]; 
    }
}