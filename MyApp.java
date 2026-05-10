
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
        
        System.out.println("=================성적 처리 프로그램=================");
        System.out.println("학번, 이름, 학과, 학년, 년도, 학기, 수강 과목 수를 입력하세요.");
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

        for (int i = 1; i <= subjectCount; i++){
            System.out.println(i + "번째 과목 정보를 입력하세요.");
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

        std.printInformation();
        scan.close();
    }
}