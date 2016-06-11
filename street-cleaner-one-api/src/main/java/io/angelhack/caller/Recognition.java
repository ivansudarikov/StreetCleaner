package io.angelhack.caller;

import com.asprise.ocr.Ocr;

import java.io.File;

public class Recognition {
    public static String recognize() {
        StringBuilder number = new StringBuilder();
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
        if (new File("test.jpg").exists()) {
            String s = ocr.recognize(new File[]{new File("test.jpg")},
                    Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT); // PLAINTEXT | XML | PDF | RTF
            ocr.stopEngine();
//            for (int i = 0; i < s.length(); i++ ) {
//                if ( (Character.isDigit(s.charAt(i)) && (number.length() < 11)) ) {
//                    number.append(s.charAt(i));
//                } else if ((s.charAt(i) == '*') && number.toString().startsWith("8")) {
//                    number.append(9);
//                }
//            }

            int index = s.indexOf("8 *");
            number.append(s.substring(index, index+15));
            return number.toString().replace("*", "9").replaceAll(" ", "");
        } else {
            System.out.println("false");
            return "NOOOOOO";
        }
    }

    public static void main(String[] args) {
        Caller.call(recognize());
    }
}
