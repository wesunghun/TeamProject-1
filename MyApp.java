
/**
 * MyApp 클래스의 설명을 작성하세요.
 *성적 처리 프로그램
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
import java.util.Scanner;
public class MyApp
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("학생 수를 입력하세요.");
        int stdCount = scan.nextInt();

        Department AI = new Department(stdCount);

        System.out.println("=================성적 처리 프로그램=================");
        for (int i = 0; i < stdCount; i++){ // 정보 입력
            System.out.println((i+1) + "번째 학생의 학번, 이름, 학과, 학년, 년도, 학기, 수강 과목 수를 입력하세요.");
            System.out.print("학번: ");
            long stID = scan.nextLong();
            System.out.print("이름: ");
            String name = scan.next();
            System.out.print("학과: ");
            String dept = scan.next();
            System.out.print("학년: ");
            int grade = scan.nextInt();
            System.out.print("년도: ");
            int year = scan.nextInt();
            System.out.print("학기: ");
            int term = scan.nextInt();
            System.out.print("과목수: ");
            int subjectCount = scan.nextInt();

            Student std = new Student(stID, name, dept, grade, year, term, subjectCount);
            AI.saveStdInfo(std);
            for (int j = 1; j <= subjectCount; j++){
                System.out.println(j + "번째 과목 정보를 입력하세요.");
                System.out.print("과목명: ");
                String sjName = scan.next();
                System.out.print("중간점수: ");
                double midtermEx = scan.nextDouble();
                System.out.print("기말점수: ");
                double finalEx = scan.nextDouble();
                System.out.print("과제점수: ");
                double assign = scan.nextDouble();
                System.out.print("출석점수: ");
                double attend = scan.nextDouble();

                Subject subject = new Subject(sjName, midtermEx, finalEx, assign, attend);
                std.saveSubject(subject);
            }
        }

        while(true){ // 성적 조회
            System.out.println("조회할 학생의 학번을 입력하세요.");
            System.out.print("학번>>");
            long check = scan.nextLong();
            AI.searchStdInfo(check);
            
            System.out.print("추가 조회 하시겠습니까?(yes/no)>>");
            String answer = scan.next();
            if(answer.equals("yes")){
                continue;
            } else{
                break;
            }
        }

    }
}