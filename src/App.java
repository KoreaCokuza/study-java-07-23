import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    Scanner scanner;
    int lastQuotationid;
    List<Quotation> quotations;

    App() {
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
            } else if (cmd.equals("등록")) {
                actionWrite();
                System.out.printf("%d번 명언이 등록되었습니다.\n", lastQuotationid);
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제?")) {
                actionRemove(cmd);
            }
        }
    }
    void actionWrite() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String authorName = scanner.nextLine();

        lastQuotationid++;

        int id = lastQuotationid;

        Quotation quotation = new Quotation(id, content, authorName);
        quotations.add(quotation);
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");

        System.out.println("----------------------");

        if (quotations.isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
        }
        for (int i = quotations.size() - 1; i >= 0; i--) {
            Quotation quotation = quotations.get(i);
            System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
        }
    }
    /* 아래 코드를 만들어 준 이유는 나중에 ex)
    수정?id=4 또는 검색 => 전체, 검색?keyword=안녕, 검색?keyword=안녕&keywordType=all
    검색?keyword=안녕&keywordType=content
    콘텐트 중에서 내용이 안녕인 것을 전부 불러올 수 있게 한다.
    나중을 생각하면 이렇게 만들어 놓으면 어떤게 들어와도 id를 가지고 나누기 때문에 검색 및 활용이 가능하다.
     */
    void actionRemove(String cmd){
        String[] cmdBits = cmd.split("\\?", 2); // \\?기준으로 쪼갠다.
        String action = cmdBits[0];     // cmd 배열의 0번째
        String qeuryString = cmdBits[1];

        String[] qeuryStringBits = qeuryString.split("&");
        //queryStringBits[0] id = 1
        //queryStringBits[1] archive = true

        int id = 0;
        for(int i = 0; i < qeuryStringBits.length; i++) {
            String queryParamStr = qeuryStringBits[i];

            String[] queryParamStrBits = queryParamStr.split("=", 2);
            // 문자열들을 저장해야 되기 때문에 있어야 한다.

            String paramName = queryParamStrBits[0];
            String paramValue = queryParamStrBits[1];

            if (paramName.equals("id")) {
                id = Integer.parseInt(paramValue);
            }
        }
        System.out.printf("%d번 명언을 삭제합니다\n", id);
    }
}