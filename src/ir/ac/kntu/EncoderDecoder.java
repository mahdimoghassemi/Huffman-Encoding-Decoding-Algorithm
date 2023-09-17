package ir.ac.kntu;

import java.util.LinkedList;

public class EncoderDecoder {

    LinkedList<Code> code;

    public EncoderDecoder(LinkedList<Code> code) {
        this.code = code;
    }

    // ===char migire code mide===

    private String getCodeFor(char c) {
        for (Code i : code)
            if (i.subject == c)
                return i.code;

        return "not found!";
    }

    public String encode(String target) {
        String result = "" ;

        for (char c : target.toCharArray()) {
            result += getCodeFor(c);
        }
        return result;
    }

    // === code migire char mide ===

    public char getCharFor(String code){
        for (Code i : this.code)
            if (i.code.equals(code))
                return (char)(i.subject);
        return 0;
    }

    // === cheak code decode ===

    public String decode(String target){
        String result = "";

        while (target.length() > 0){
//            System.out.println(target);
            for(int i = 1; ; i++){
                String current = target.substring(0,i);
                char testThis = getCharFor(current);
                if (testThis > 0){
                    target = target.substring(i);
                    result+=testThis;
                    break;
                }
            }
        }

        return result;
    }

}
