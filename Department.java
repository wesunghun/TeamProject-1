
/**
 * Department 클래스 - 학생 객체를 저장하고 관리하는 클래스
 * 
 * @author Team#9_(2023320024 위성훈, 2023320045 김동균, 2023320017 정윤재, 2023320002 노승렬)
 * @version (2026.05.10.)
 */
public class Department
{
    // 인스턴스 변수 
    private Student[] students; 
    private int stdCount;

    /**
     * Department 클래스의 객체 생성자
     */
    public Department(int size)
    {
        // 인스턴스 변수 초기화
        this.stdCount = 0;
        // 입력 받은 학생 수 크기만큼 Student 배열 생성
        this.students = new Student[size];
    }

    /**
     * 학생 객체를 배열에 저장하는 메소드
     *
     * @param  std 학생객체
     */
    public void saveStdInfo(Student std)
    {
        if (stdCount < students.length){
            students[stdCount] = std;
            stdCount++;
            System.out.println("정보가 등록되었습니다.");
        } else{
            System.out.println("더 이상 입력할 수 없습니다.");
        }
    }

    /**
     * 학번 중복 여부 확인 메소드
     *
     * @param  stID 학번
     * @return  중복이면 1, 아니면 0
     */
    public int isDuplicateID(long stID)
    {
        for (int i = 0; i < stdCount; i++){
            if (students[i].getStID() == stID){
                return 1;
            }
        }
        return 0;
    }

    /**
     * 학번을 이용해서 학생 정보를 조회하는 메소드
     *
     * @param  stID 학번
     */
    public void searchStdInfo(long stID)
    {
        int count = 0;
        // 저장된 학생 수만큼 반복
        for (int i = 0; i < stdCount; i++){

            // 입력한 학번과 학생 배열의 학번 비교
            if(students[i].getStID() == stID){

                System.out.println(students[i].getStID() + " 학생의 정보입니다.");

                students[i].printInformation();

                count++;
                break;
            }
        }
        if(count == 0){
                System.out.println("학번이 " + stID +
                    "인 학생을 찾을 수 없습니다.");
        }
    }

    /**
     * 전체 석차를 출력하는 메소드
     * GPA 기준 내림차순으로 모든 학생의 순위를 출력한다.
     */
    public void printRanking()
    {
        if (stdCount == 0){
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        System.out.println("=================================================");
        System.out.println("                    전체 석차                    ");
        System.out.println("=================================================");

        for (int i = 1; i <= stdCount; i++){
            for (int j = 0; j < stdCount; j++){
                int rank = 1;
                for (int k = 0; k < stdCount; k++){
                    if (students[k].calculateGPA() > students[j].calculateGPA()){
                        rank++;
                    }
                }
                if (rank == i){
                    System.out.println(rank + "위 | " + students[j].getStID() + " | " + students[j].getName() + " | " + students[j].calculateGPA());
                }
            }
        }
        System.out.println("=================================================");
    }

    /**
     * 특정 학생의 석차를 조회하는 메소드
     *
     * @param  stID 학번
     */
    public void searchRank(long stID)
    {
        // 해당 학생의 GPA 조회 (없으면 -1)
        double myGPA = -1;
        for (Student s : students){
            if (s != null && s.getStID() == stID){
                myGPA = s.calculateGPA();
                break;
            }
        }
        if (myGPA == -1){
            return;
        }

        // 나보다 GPA가 높은 학생 수 + 1 = 석차
        int rank = 1;
        for (int i = 0; i < stdCount; i++){
            if (students[i].calculateGPA() > myGPA){
                rank++;
            }
        }

        System.out.println("전체 " + stdCount + "명 중 " + rank + "위입니다.");
        System.out.println("=================================================");
    }

}