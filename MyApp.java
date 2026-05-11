/**
 * MyApp 클래스 - 성적 처리 프로그램의 실행을 담당하는 메인 클래스
 * 학생수를 Student 객체를 생성하고, 과목 정보를 입력 받아 성적을 저장 및 관리한다.
 * 또한, 학번을 이용한 학생 성적 조회 기능을 수행한다.
 * 
 * @author Team#9_(2023320024 위성훈, 2023320045 김동균, 2023320017 정윤재, 2023320002 노승렬)
 * @version (2026.05.10.)
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class MyApp
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("성적을 등록할 학생 수를 입력하세요."); //성적을 입력하고자 하는 학생 수 입력
        System.out.print("학생 수>>");
        int stdCount = scan.nextInt();

        Department AI = new Department(stdCount); // 입력 받은 학생 수를 기준으로 Department 객체 생성

        while(true){
            System.out.println("=================================================");
            System.out.println("                 성적 처리 프로그램                ");
            System.out.println("=================================================");
            System.out.println("[1] 학생 정보 등록");
            System.out.println("[2] 학생 성적 조회");
            System.out.println("[3] 프로그램 종료");
            System.out.println("=================================================");
            System.out.print("원하는 기능을 선택하세요.>>");
            String choice = scan.next();

            switch(choice){
                case "1": 
                    for (int i = 0; i < stdCount; i++){ 
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

                        // 입력받은 학생 정보를 Student 기반으로 Student 객체 생성
                        Student std = new Student(stID, name, dept, grade, year, term, subjectCount); 

                        // 생성된 Student 객체를 Department 배열에 저장
                        AI.saveStdInfo(std);

                        // 과목 수만큼 반복하여 과목 정보 입력 
                        for (int j = 1; j <= subjectCount; j++){
                            boolean examine = false;
                            while(!examine){
                                try{
                                    System.out.println(j + "번째 과목 정보를 입력하세요.");
                                    System.out.print("과목명: ");
                                    String sjName = scan.next();
                                    System.out.print("담당교수명: ");
                                    String pfName = scan.next();
                                    System.out.print("중간점수: ");
                                    double midtermEx = scan.nextDouble();
                                    System.out.print("기말점수: ");
                                    double finalEx = scan.nextDouble();
                                    System.out.print("과제점수: ");
                                    double assign = scan.nextDouble();
                                    System.out.print("출석점수: ");
                                    double attend = scan.nextDouble();
                                    if(midtermEx < 0 || finalEx < 0 || assign < 0 || attend < 0){
                                        System.out.println("점수를 다시 입력하세요.");
                                        continue;
                                    }

                                    // 입력받은 과목 정보를 기반으로 Subject 객체 생성
                                    Subject subject = new Subject(sjName, pfName, midtermEx, finalEx, assign, attend);

                                    // 생성된 Subject 객체를 Student 배열에 저장
                                    std.saveSubject(subject);
                                    examine = true;
                                }catch(InputMismatchException e){
                                    System.out.println("숫자로 입력하세요.");
                                    scan.nextLine();
                                }
                            }
                        }
                    }
                    break;
                case "2":
                    while(true){ // 성적 조회 
                        // 조회할 학생의 학번 입력
                        System.out.println("조회할 학생의 학번을 입력하세요.");
                        System.out.print("학번>>");
                        long check = scan.nextLong();
                        AI.searchStdInfo(check);

                        // 추가 조회 여부 확인
                        System.out.println("=================================================");
                        System.out.print("추가 조회 하시겠습니까?(yes/no)>>");
                        String answer = scan.next();

                        // yes 입력 시 조회 반복
                        if(answer.equals("yes")){
                            System.out.println("=================================================");
                            continue;
                        } else{
                            break;
                        }
                    }
                    break;
                case "3":
                    System.out.println("=================================================");
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            }
        }
    }
}