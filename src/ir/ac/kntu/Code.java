package ir.ac.kntu;

public class Code {
    char subject;
    String code;

    public Code(char subject, String code) {
        this.subject = subject;
        this.code = code;
    }

    public String toString() {
        return "\""+subject +"\""+ ": " + "\""+code+"\"";
    }
}
