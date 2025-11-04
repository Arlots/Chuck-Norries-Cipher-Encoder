package chucknorris;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor {
    public static String input;

    public static void processor() {
//convert string to charArray
        char[] array = input.toCharArray();
//convert char array to decimal decimal
        int[] decimalArray = new int[array.length];
        String binaryString = "";

        for (int i = 0; i < array.length; i++) {
            decimalArray[i] = (int) array[i];
        }
//convert char to binary
        String[] binaryValue = new String[decimalArray.length];
        for (int i = 0; i < decimalArray.length; i++) {
            binaryValue[i] = String.format("%7s", Integer.toBinaryString(decimalArray[i])).replace(' ', '0');
//binary value as string
            binaryString += binaryValue[i];
        }
        //iterate over string using charAT
        String toPrint = "";
            int counter = 0;
            for (int j = 0; j < binaryString.length(); j++) {
            String addDigits = "";
            switch (binaryString.charAt(j)) {
                case '0':
                    toPrint += "00";
                    counter++;
                    for (int k = j; k < binaryString.length(); k++) {
                        if ((j + 1 < binaryString.length()) && (binaryString.charAt(j + 1) == '0')) {
                            counter++;
                            j++;
                        } else {
                            break;
                        }
                    }
                    while (counter > 0) {
                        addDigits += "0";
                        counter--;
                    }
                    toPrint += " " + addDigits + " ";
                    break;

                case '1':
                    toPrint += "0";
                    counter++;
                    for (int k = j; k < binaryString.length(); k++) {
                        if ((j + 1 < binaryString.length()) && (binaryString.charAt(j + 1) == '1')) {
                            counter++;
                            j++;
                        } else {
                            break;
                        }
                    }
                    while (counter > 0) {
                        addDigits += "0";
                        counter--;
                    }
                    toPrint += " " + addDigits + " ";
                    break;
            }
        }
        System.out.println("Encoded String:");
        System.out.println(toPrint + "\n");
    }

}







        /* Incorrect answer, does characters individually

        //binaryValue[1] // 1 | 0000 | 11 -> 0 0 00 0000 0 00
        // Convert binary into character array in a loop,
        // (nested)loop over each character, get 0 or 1 count how many in a row
        String toPrint = "";
        for (int i = 0; i < binaryValue.length; i++) {
            char[] binaryChars = new char[7];
            binaryChars = binaryValue[i].toCharArray();
            int counter = 0;
            for(int j = 0; j < binaryChars.length; j++ ) {
                String addDigits = "";
                switch (binaryChars[j]){
                    case '0':
                        toPrint += "00";
                        counter++;
                        for (int k = j; k < binaryChars.length; k++) {
                            if ((j + 1 < binaryChars.length) && (binaryChars[j + 1] == '0')) {
                                counter++;
                                j++;
                            } else {
                                break;
                            }
                        }
                        while ( counter > 0) {
                            addDigits += "0";
                            counter--;
                        }
                        toPrint += " " + addDigits + " ";
                        break;

                    case '1':
                        toPrint += "0";
                        counter++;
                        for (int k = j; k < binaryChars.length; k++) {
                            if ((j + 1 < binaryChars.length) && (binaryChars[j + 1] == '1') ) {
                                j++;
                                counter++;
                            } else {
                                break;
                            }
                        }
                        while ( counter > 0) {
                            addDigits += "0";
                            counter--;
                        }
                        toPrint += " " + addDigits + " ";
                        break;

                }
            }
        }
        System.out.println(toPrint);
    }
}*/
