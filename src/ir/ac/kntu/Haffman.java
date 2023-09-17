package ir.ac.kntu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Haffman {
    LinkedList<Code> codes;
    String readString;
    String encodedString = "";

    private Haffman(String target){
        this.readString = target;
    }

    private Haffman(String encodedString, LinkedList<Code> codes){
        this.encodedString = encodedString;
        this.codes = codes;
    }

    private static Node makeTree(String target) {
        PriorityQueue<Node> result = Node.count(target);

        while (result.size() > 1) {
            Node minest = result.poll();
            Node minner = result.poll();

            Node newNode = new Node(minest.count + minner.count, minest, minner);
            result.add(newNode);
        }

        Node finalTree = result.poll();
        return finalTree;
    }

    static class TreeTraverse {
        LinkedList<Code> code = new LinkedList<>();

        public void traverseTree(Node tree, String currentCode) {
            if (tree.word > 0) {
                code.add(new Code(tree.word, currentCode));
                return;
            }

            traverseTree(tree.right, currentCode + "1");
            traverseTree(tree.left, currentCode + "0");
        }
    }

    public static LinkedList<Code> makeCode(String target) {
        Node tree = makeTree(target);

        TreeTraverse traverse = new TreeTraverse();
        traverse.traverseTree(tree, "");

        return traverse.code;
    }

    public static Haffman fromTextFile(String filePath) throws IOException {
        byte[] allBytes = Files.readAllBytes(Paths.get(filePath)); // read all byte
        String readString = new String(allBytes, StandardCharsets.UTF_8); // byte

        return new Haffman(readString);
    }

    public String encode(){
        codes = makeCode(readString);
        encodedString = new EncoderDecoder(codes).encode(readString);
        return encodedString;
    }

    public void writeEncodedToFile(String filePath) throws IOException {
        String header = codes.toString();
        String body = encodedString;
        String headerPlus = header+"=="; // final String

        FileOutputStream fos = new FileOutputStream(filePath , false);
        byte b[]=headerPlus.getBytes();//converting string into byte array
        fos.write(b);
        for( int i = 0 ; i < body.length() / 8 ; i++ ) {
            String sub = body.substring( i*Byte.SIZE , i*Byte.SIZE+Byte.SIZE );
            int sh = Integer.parseInt(sub,2);
            fos.write((byte)sh);

        }


        //Files.write(Paths.get(filePath), writeToFile.getBytes()); // get byte write byte
    }

    private static LinkedList<Code> codesFromString(String header) {
        LinkedList<Code> codes = new LinkedList<>();

        header = header.substring(2); // skip ["

        while (header.charAt(0) != ']') {
            char subject = header.charAt(0);
            header = header.substring(5); // skip "
            int matchLen = 0;
            while (header.charAt(matchLen) != '\"')
                matchLen++;
            String code = header.substring(0,matchLen);
            header = header.substring(matchLen);

            codes.add(new Code(subject, code));

            if (header.length()<3) {
                break;
            }
            header = header.substring(4);
        }
        return codes;
    }

    public static Haffman fromEncodedFile(String filePath) throws IOException {
        FileInputStream fos = new FileInputStream(filePath);
        int allBytes = fos.read();

//        byte[] allBytes = Files.readAllBytes(Paths.get(filePath)); // read all byte
        String readString = new String(String.valueOf(allBytes)); // byte

        System.out.println(readString);

        String[] splited = readString.split("==");
        String header = splited[0];
        String body = splited[1];

        LinkedList<Code> codes = codesFromString(header);

        //System.out.println(codes);
        //System.out.println(body);

        return new Haffman(body,codes);
    }

    public String decode(){
        readString = new EncoderDecoder(codes).decode(encodedString);
        return readString;
    }

    public void writeDecodedToFile(String filePath) throws IOException {
        Files.write(Paths.get(filePath), readString.getBytes());
    }
}
