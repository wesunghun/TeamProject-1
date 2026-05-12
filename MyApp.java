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

        System.out.println("=================================================");
        System.out.println("성적을 등록할 학생 수를 입력하세요."); //성적을 입력하고자 하는 학생 수 입력
        System.out.println("=================================================");
        System.out.print("학생 수>>");
        int stdCount = scan.nextInt();

        Department AI = new Department(stdCount); // 입력 받은 학생 수를 기준으로 Department 객체 생성

        while(true){
            System.out.println("=================================================");
            System.out.println("                [성적 처리 프로그램]               ");
            System.out.println("=================================================");
            System.out.println("[1] 학생 정보 등록");
            System.out.println("[2] 학생 성적 조회");
            System.out.println("[3] 석차 조회");
            System.out.println("[4] 프로그램 종료");
            System.out.println("=================================================");
            System.out.print("원하는 기능을 선택하세요.>>");
            String choice = scan.next();

            switch(choice){
                case "1": 
                    for (int i = 0; i < stdCount; i++){ 
                        System.out.println("=================================================");
                        System.out.println((i+1) + "번째 학생의 학번, 이름, 학과, 학년, 년도, 학기, 수강 과목 수를 입력하세요.");

                        // 학번 입력
                        long stID = -1;
                        while(stID == -1){
                            try{
                                System.out.print("학번: ");
                                stID = scan.nextLong();
                                if(AI.isDuplicateID(stID) == 1){
                                    System.out.println("이미 등록된 학번입니다. 다시 입력해주세요.");
                                    stID = -1;
                                }
                            }catch(InputMismatchException e){ // 숫자가 아니면 다시 입력
                                System.out.println("숫자만 입력 가능합니다.");
                                scan.nextLine();
                            }
                        }

                        System.out.print("이름: ");
                        String name = scan.next();
                        System.out.print("학과: ");
                        String dept = scan.next();

                        // 학년 입력
                        int grade = -1;
                        while(grade == -1){
                            try{
                                System.out.print("학년: ");
                                grade = scan.nextInt();
                            }catch(InputMismatchException e){ // 숫자가 아니면 다시 입력
                                System.out.println("숫자만 입력 가능합니다.");
                                scan.nextLine();
                            }
                        }

                        // 년도 입력
                        int year = -1;
                        while(year == -1){
                            try{
                                System.out.print("년도: ");
                                year = scan.nextInt();
                            }catch(InputMismatchException e){ // 숫자가 아니면 다시 입력
                                System.out.println("숫자만 입력 가능합니다.");
                                scan.nextLine();
                            }
                        }

                        // 학기 입력 
                        int term = -1;
                        while(term == -1){
                            try{
                                System.out.print("학기: ");
                                term = scan.nextInt();
                            }catch(InputMismatchException e){ // 숫자가 아니면 다시 입력
                                System.out.println("숫자만 입력 가능합니다.");
                                scan.nextLine();
                            }
                        }

                        // 과목수 입력 
                        int subjectCount = -1;
                        while(subjectCount == -1){
                            try{
                                System.out.print("과목수: ");
                                subjectCount = scan.nextInt();
                            }catch(InputMismatchException e){ // 숫자가 아니면 다시 입력
                                System.out.println("숫자만 입력 가능합니다.");
                                scan.nextLine();
                            }
                        }

                        Student std = new Student(stID, name, dept, grade, year, term, subjectCount); 
                        AI.saveStdInfo(std);

                        // 과목 수만큼 반복하여 과목 정보 입력 
                        for (int j = 1; j <= subjectCount; j++){ 
                            System.out.println("=================================================");
                            System.out.println(j + "번째 과목 정보를 입력하세요.");

                            System.out.print("과목명: ");
                            String sjName = scan.next();

                            System.out.print("담당교수명: ");
                            String pfName = scan.next();

                            try{
                                System.out.print("중간점수: ");
                                double midtermEx = scan.nextDouble();

                                System.out.print("기말점수: ");
                                double finalEx = scan.nextDouble();

                                System.out.print("과제점수: ");
                                double assign = scan.nextDouble();

                                System.out.print("출석점수: ");
                                double attend = scan.nextDouble();

                                if(midtermEx < 0 || midtermEx > 100 || finalEx < 0 || finalEx > 100 || 
                                assign < 0 || assign > 100 || attend < 0 || attend > 100){
                                    System.out.println("점수는 0~100 사이만 입력 가능합니다.");
                                    j--;
                                    continue;
                                }

                                Subject subject = new Subject(sjName, pfName, midtermEx, finalEx, assign, attend);
                                std.saveSubject(subject);

                            }catch(InputMismatchException e){
                                System.out.println("숫자만 입력 가능합니다.");
                                scan.nextLine();
                                j--;
                            }finally{
                                System.out.println("=================================================");
                            }
                        }
                    }
                    break;
                case "2":
                    while(true){
                        System.out.println("=================================================");
                        System.out.println("조회할 학생의 학번을 입력하세요.");
                        System.out.print("학번>>");
                        long check = scan.nextLong();
                        AI.searchStdInfo(check);
                        AI.searchRank(check);

                        System.out.println("=================================================");
                        System.out.print("추가 조회 하시겠습니까?(yes/no)>>");
                        String answer = scan.next();

                        if(answer.equals("yes")){
                            continue;
                        } else if(answer.equals("no")){
                            break;
                        }
                    }
                    break;
                case "3":
                    while(true){
                        System.out.println("=================================================");
                        System.out.println("               [ 석차 조회 메뉴 ]                ");
                        System.out.println("=================================================");
                        System.out.println("[1] 전체 평균 석차 조회");
                        System.out.println("[2] 과목별 석차 조회");
                        System.out.println("[3] 석차 조회에서 나가기");
                        System.out.println("=================================================");
                        System.out.print("원하는 기능을 선택하세요.>>");
                        String rankChoice = scan.next();

                        if (rankChoice.equals("1")) {
                            // 1번: 전체 평균 평점(GPA) 기준 석차 출력
                            AI.printAllRank(); // 전체 석차 출력 메소드 호출
                        } 
                        else if (rankChoice.equals("2")) {
                            // 2번: 특정 과목을 입력받아 해당 과목의 석차 출력
                            System.out.print("조회할 과목명을 입력하세요>>");
                            String sjName = scan.next();
                            AI.printSubjectRank(sjName); // 과목별 석차 출력 메소드 호출
                        } else if(rankChoice.equals("3")){
                            break;
                        } else {
                            System.out.println("잘못된 입력입니다. 메인 메뉴로 돌아갑니다.");
                            continue;
                        }
                        System.out.println("=================================================");
                        System.out.print("메인 화면으로 돌아가시겠습니까?(yes/no)>>");
                        String answer = scan.next(); 
                        if(answer.equals("yes")){
                            break;
                        } else if(answer.equals("no")){
                            continue;
                        }
                    }
                    break;
                case "4":
                    System.out.println("=================================================");
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("=================================================");
                    System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            }
        }
    }
}