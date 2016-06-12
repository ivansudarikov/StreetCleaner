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

            System.out.println(s);
            int index = s.indexOf("8 *");
            if (index == -1) {
                index = s.indexOf("8 9");
            }

            number.append(s.substring(index, index+15));
            return number.toString().replace("*", "9").replaceAll(" ", "");
        } else {
            System.out.println("false");
            return "NOOOOOO";
        }
    }

    public static String recognize(File file) {
        StringBuilder number = new StringBuilder();
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
        String s = ocr.recognize(new File[]{file},
                Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT); // PLAINTEXT | XML | PDF | RTF
        ocr.stopEngine();
        System.out.println("Первичная распознанная строка" + s);
        int index = s.indexOf("8 *");
        if (index == -1) {
            index = s.indexOf("8*");
        }
        if (index == -1) {
            index = s.indexOf("8-*");
        }
        if (index == -1) {
            index = s.indexOf("+7*");
        }
        if (index == -1) {
            index = s.indexOf("+7 *");
        }
        if (index == -1) {
            index = s.indexOf("+7-*");
        }

        if (index == -1) {
            index = s.indexOf("8 9");
        }

        number = new StringBuilder(number.toString());
        number.append(s.substring(index, index+15).replaceAll(" ", ""));
        return number.toString().replace("*", "9");
    }




    public static void main(String[] args) {
        recognize();
        Caller.call(recognize());
    }
}
