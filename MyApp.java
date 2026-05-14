/**
 * MyApp 클래스 - 성적 처리 프로그램의 실행을 담당하는 메인 클래스
 * 학생수를 Student 객체를 생성하고, 과목 정보를 입력 받아 성적을 저장 및 관리한다.
 * 또한, 학번을 이용한 학생 성적 조회 기능을 수행한다.
 * 
 * @author Team#9_(2023320024 위성훈, 2023320045 김동균, 2023320017 정윤재, 2023320002 노승렬)
 * @version (2026.05.13.)
 */

import java.util.Scanner;
import java.util.InputMismatchException;
public class MyApp {
    /**
     * 메인메뉴를 출력하는 메소드
     */
    private static void printMainMenu()
    {
        System.out.println("\n=================================================");
        System.out.println("                [성적 처리 프로그램]                ");
        System.out.println("=================================================");
        System.out.println("[1] 학생 정보 등록");
        System.out.println("[2] 학생 성적 조회");
        System.out.println("[3] 석차 조회");
        System.out.println("[4] 학생 성적 수정");
        System.out.println("[5] 프로그램 종료");
        System.out.println("=================================================");
    }

    /**
     * 학생 정보를 입력하는 메소드
     *
     * @param  AI, stdCount
     */
    private static void inputStdInfo(Department AI, int stdCount)
    {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < stdCount; i++){
            System.out.println("=================================================");
            System.out.println((i + 1) + "번째 학생 정보를 입력하세요.");

            long stID = getValidStID(AI);
            System.out.print("이름: ");
            String name = scan.next();
            System.out.print("학과: ");
            String dept = scan.next();
            System.out.print("학년: ");
            int grade = getSafeInt();
            System.out.print("년도: ");
            int year = getSafeInt();
            System.out.print("학기: ");
            int term = getSafeInt();
            System.out.print("과목수: ");
            int subjectCount = getSafeInt();

            Student std = new Student(stID, name, dept, grade, year, term, subjectCount);
            AI.saveStdInfo(std);

            // 과목 입력 루프
            for (int j = 1; j <= subjectCount; j++){
                inputSjInfo(std, j);
            }
        }
        System.out.println("=================================================");
        System.out.println("학생 정보 등록이 완료되었습니다.");
    }

    /**
     * 특정 학생의 성적을 조회하는 메소드
     *
     * @param  AI
     */
    private static void searchStdGrade(Department AI)
    {
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("=================================================");
            System.out.print("조회할 학번>>");
            long check = scan.nextLong();
            AI.searchStdInfo(check);
            AI.searchRank(check);

            System.out.println("추가 조회 하시겠습니까? ([1] 예 / [2] 아니요)");
            int answerSearch = getSafeInt();
            if (answerSearch == 1){
                continue;
            } else if (answerSearch == 2){
                break;
            } else{
                System.out.println("올바른 번호를 입력하세요.");
            }
        } 
    }

    /**
     * 석차 조회 메뉴를 관리하는 메소드
     *
     * @param  AI
     */

    private static void manageRankMenu(Department AI)
    {
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("\n=================================================");
            System.out.println("                [ 석차 조회 메뉴 ]                ");
            System.out.println("=================================================");
            System.out.println("[1] 전체 평균 석차 조회");
            System.out.println("[2] 과목별 석차 조회");
            System.out.println("[3] 석차 조회 나가기");
            System.out.print("선택>>");
            int choice = scan.nextInt();
            switch(choice){
                case 1:
                    System.out.println("        [전체 성적 석차 리스트(합계기준)]       ");
                    AI.printAllRank();
                    break;
                case 2:
                    int subjectCount = AI.printSjList();
                    if (subjectCount == 0){
                        break; 
                    }
                    System.out.print("조회할 과목 번호>>");
                    int subjectNum = getSafeInt();
                    if (subjectNum < 1 || subjectNum > subjectCount){
                        System.out.println("올바른 과목 번호를 입력하세요.");
                        break;
                    }
                    AI.printSjRank(subjectNum);
                    break;
                case 3:
                    return;
            }
            while (true){
                System.out.println("석차 조회를 계속 이용하시겠습니까? ([1] 예 / [2] 아니요)");
                System.out.print(">>");
                int answerContinue = getSafeInt();
                if (answerContinue == 1){
                    break;
                } else if (answerContinue == 2){
                    return;
                } else{
                    System.out.println("올바른 번호를 입력하세요.");
                }
            }
        }
    }

    /**
     * 특정 학생의 성적을 수정하는 메소드
     *
     * @param  AI
     */
    private static void updateStdScore(Department AI)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("수정할 학생의 학번>>");
        long updateID = scan.nextLong();

        int stdCount = AI.getStdSjCount(updateID);
        if (stdCount == -1){
            System.out.println("해당 학생을 찾을 수 없습니다.");
            return;
        }

        System.out.println("수강 과목 목록 입니다.");
        for (int i = 0; i < stdCount; i++){
            System.out.println("[" + (i + 1) + "] " + AI.getStdSjName(updateID, i));
        }

        int subjectNum;
        do {
            System.out.print("수정할 과목 번호>>");
            subjectNum = getSafeInt();
            if (subjectNum < 1 || subjectNum > stdCount){
                System.out.println("올바른 과목 번호를 입력하세요.");
            }
        } while (subjectNum < 1 || subjectNum > stdCount);

        int subjectIndex = subjectNum - 1;

        System.out.print("중간점수: ");
        double midtermEx = getSafeDouble();
        System.out.print("기말점수: ");
        double finalEx = getSafeDouble();
        System.out.print("과제점수: ");
        double assignEx = getSafeDouble();
        System.out.print("출석점수: ");
        double attendEx = getSafeDouble();

        AI.updateScore(updateID, subjectIndex, midtermEx, finalEx, assignEx, attendEx);
    }

    /**
     * 학번을 입력받을 때 중복을 처리하는 메소드
     *
     * @param  AI
     * @return    stID 학번
     */
    private static long getValidStID(Department AI)
    {
        Scanner scan = new Scanner(System.in);
        while (true){
            try{
                System.out.print("학번: ");
                long stID = scan.nextLong();
                if (AI.isDuplicateID(stID) == 1){
                    System.out.println("이미 등록된 학번입니다.");
                    continue;
                }
                return stID;
            } catch (InputMismatchException e){
                System.out.println("숫자만 입력 가능합니다.");
                scan.nextLine();
            }
        }
    }

    /**
     * 과목 정보를 입력하는 메소드
     *
     * @param  std, index
     */
    private static void inputSjInfo(Student std, int index)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println(index + "번째 과목명/교수명/중간점수/기말점수/과제점수/출석점수 입력");
        System.out.print("과목명: ");
        String sjName = scan.next();
        System.out.print("교수명: ");
        String pfName = scan.next();
        System.out.print("중간점수: ");
        double midtermEx = getSafeDouble();
        System.out.print("기말점수: ");
        double finalEx = getSafeDouble();
        System.out.print("과제점수: ");
        double assignEx = getSafeDouble();
        System.out.print("출석점수: ");
        double attendEx = getSafeDouble();

        std.saveSubject(new Subject(sjName, pfName, midtermEx, finalEx, assignEx, attendEx));
    }

    /**
     * 숫자 외의 입력을 예외처리하는 메소드
     *
     * @param  prompt
     * @return    출력문
     */
    private static int getSafeInt()
    {
        Scanner scan = new Scanner(System.in);
        while (true){
            try{
                int input = scan.nextInt();
                return input;
            } catch (InputMismatchException e){
                System.out.println("숫자를 입력해주세요.");
                scan.nextLine();
            }
        }
    }

    /**
     * 과목 정보(과목 세부 점수)를 입력할 때 실수형 외의 입력을 예외처리하는 메소드
     *
     * @param  prompt
     * @return    출력문
     */
    private static double getSafeDouble()
    {
        Scanner scan = new Scanner(System.in);
        while (true){
            try{
                double input = scan.nextDouble();
                return input;
            } catch (InputMismatchException e){
                System.out.println("실수를 입력하세요.");
                scan.nextLine();
            }
        }
    }

    /**
     * 프로그램을 종료하는 메소드
     */
    private static void exitProgram()
    {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("=================================================");
        System.out.println("성적을 등록할 학생 수를 입력하세요.");
        System.out.println("=================================================");
        System.out.print("학생 수>>");

        int stdCount = getSafeInt();
        Department AI = new Department(stdCount);

        while (true){
            printMainMenu();
            System.out.print("원하는 기능을 선택하세요.>>");
            String choice = scan.next();

            switch (choice){
                case "1":
                    inputStdInfo(AI, stdCount);
                    break;
                case "2":
                    searchStdGrade(AI);
                    break;
                case "3":
                    manageRankMenu(AI);
                    break;
                case "4":
                    updateStdScore(AI);
                    break;
                case "5":
                    exitProgram();
                    break;
                default:
                    System.out.println("=================================================");
                    System.out.println("잘못된 번호입니다. 다시 입력하세요.");
            }
        }
    }
}