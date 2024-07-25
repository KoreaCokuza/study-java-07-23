import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    Scanner scanner;
    int lastQuotationid;
    List<Quotation> quotations;

    App(){      // run안에서 기능이 너무 많기 때문에 나눠주기 위해 만들었다.
        lastQuotationid = 0;
        scanner = new Scanner(System.in);
        quotations = new ArrayList<>();
    }
    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");

            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                actioWrite();
                System.out.printf("%d번 명언이 등록되었습니다.\n", lastQuotationid);
            }
            else if (cmd.equals("목록")) {
                actionList();
            }
        }
    }
    void actioWrite(){
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String authorName = scanner.nextLine();
        lastQuotationid++;

        int id = lastQuotationid;
        Quotation quotation = new Quotation(id, content,authorName);
        quotations.add(quotation);
    }

    void actionList(){
        System.out.println("번호 / 작가 / 명언");

        System.out.println("----------------------");

        if (quotations.isEmpty()) { // 비어있다면
            System.out.println("등록된 명언이 없습니다.");    // 비어있다면 출력문 출력.
        }
        for (int i = quotations.size() - 1; i >= 0; i--) {
            Quotation quotation = quotations.get(i);    // 데이터를 가져온다.
            System.out.printf("%d / %s / %s\n",quotation.id, quotation.authorName, quotation.content);
            // 처음에 저장된 Quotation클래스에서 정보를 가져온다.
        }
    }
}