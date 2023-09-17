package ir.ac.kntu;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("menu: \n1 - Encode your file: \n2 - Decode your file: \n Enter number: ");
        int option = scanner.nextInt();
        if ( option == 1 ){ //encode
            System.out.println("Enter file address: ");
            String input = scanner.next();
            Haffman haffmanEncode = Haffman.fromTextFile(input);
            String encoded = haffmanEncode.encode(); //chera//
            System.out.println(encoded);
            //System.out.println(haffmanEncode.codes);
            //System.out.println(haffmanEncode.encodedString);
            haffmanEncode.writeEncodedToFile("encode"+"_"+input);
        }else{ //decode
            System.out.println("Enter file address: ");
            String input = scanner.next();
            Haffman haffmanDecode = Haffman.fromEncodedFile(input);
            //System.out.println(haffmanDecode.codes);
            //System.out.println(haffmanDecode.encodedString);
            //System.out.println(haffmanDecode.decode()); //chera//
            //haffmanDecode.writeDecodedToFile("decode"+"_"+input);
        }

    }
}
