public class Quotation {
    int id;
    String content;
    String authorName;

    public Quotation(int id, String content, String authorName){
        this.id = id;
        this.content = content;
        this.authorName = authorName;
    }
}
// 패키지 내에서 따로 Quotation을 만들어 줘야한다.