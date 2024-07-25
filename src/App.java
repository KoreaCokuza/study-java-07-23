import java.util.Scanner;

class App {
    void run() {

        System.out.println("== 명언 앱 ==");
        int lastQuotationid = 0;
        while (true) {
            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();

                System.out.print("작가 : ");
                String authorName = scanner.nextLine();
                lastQuotationid++;
                int id = lastQuotationid;   // id 값을 구해오는 것.
                Quotation quotation = new Quotation(id, content, authorName);
                // Quotation클래스로 id와 명언과 작가를 보낸다.

                System.out.printf("%d번 명언이 등록되었습니다.\n", lastQuotationid);
            }
        }
    }
}