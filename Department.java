
/**
 * Department 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Department
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private Student[] students;
    private int stdCount;

    /**
     * Department 클래스의 객체 생성자
     */
    public Department(int size)
    {
        // 인스턴스 변수 초기화
        this.stdCount = 0;
        this.students = new Student[size];
    }

    /**
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void saveStdInfo(Student std)
    {
        if (stdCount < students.length){
            this.students[stdCount] = std;
            this.stdCount++;
            System.out.println("정보가 등록되었습니다.");
        } else{
            System.out.println("더 이상 입력할 수 없습니다.");
        }
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public void searchStdInfo(long stID)
    {
        // 여기에 코드를 작성하세요
        for (int i = 0; i < stdCount; i++){
            if(students[i].getStID() == stID){
                System.out.println(students[i].getStID() + " " + students[i].getName() +
                                    "님의 학생 정보입니다.");
                students[i].printInformation();
                break;
            } else{
                System.out.println("학번이 " + stID + "인 학생을 찾을 수 없습니다. 다시 입력하세요.");
            }
        }
    }

}