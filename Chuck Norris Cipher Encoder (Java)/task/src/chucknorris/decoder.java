package chucknorris;
import java.util.ArrayList;
import java.util.List;

public class decoder {
    static String[] array = StringProcessor.input.split(" ");
    static String binary = "";
    static int arrayLength = decoder.array.length;

    public static void decode() {

        for (int h = 0; h < arrayLength; h+=2) {
            if (!array[h].equals("0") && !array[h].equals("00")) {
                System.out.println("Encoded string is not valid");
                System.out.println("Please input operation (encode/decode/exit):");
                return;
            }
        }


        for (int i = 0; i < array.length; i++) {
            if (i + 1 >= array.length) {
                break;
            } else if (array[i].equals("00")) {
                switch (array[i + 1]) {
                    case "0":
                        binary += "0";
                        i++;
                        break;

                    case "00":
                        binary += "00";
                        i++;
                        break;

                    case "000":
                        binary += "000";
                        break;

                    case "0000":
                        binary += "0000";
                        break;

                    case "00000":
                        binary += "00000";
                        break;

                    case "000000":
                        binary += "000000";
                        break;

                    case "0000000":
                        binary += "0000000";
                        break;

                }
            } else if (array[i].equals("0")) {

                switch (array[i + 1]) {
                    case "0":
                        binary += "1";
                        i++;
                        break;

                    case "00":
                        binary += "11";
                        i++;
                        break;

                    case "000":
                        binary += "111";
                        break;

                    case "0000":
                        binary += "1111";
                        break;

                    case "00000":
                        binary += "11111";
                        break;

                    case "000000":
                        binary += "111111";
                        break;

                    case "0000000":
                        binary += "1111111";
                        break;

                }
            }
        }

        if (decoder.binary.length() % 7 != 0) {
            Main.isValid = false;
            System.out.println("Encoded string is not valid");
            System.out.println("Please input operation (encode/decode/exit):");
            return;
        }

        String[] strings = new String[binary.length() / 7];
        int index = 0;
        for (int i = 0; i < strings.length; i++) {
            if (i >= binary.length()) {
                break;
            } else {
                strings[i] = "0" + (binary.substring(index, Math.min(index + 7, binary.length())));
                index += 7;
            }
        }
        int[] binaryOutput = new int[strings.length];
        for (int j = 0; j < strings.length; j++) {
            binaryOutput[j] = Integer.parseInt(strings[j], 2);
        }
        char[] characterConversion = new char[binaryOutput.length];
        String result = "";
        for (int i = 0; i < binaryOutput.length; i++){
            characterConversion[i] = (char) binaryOutput[i];
            result += characterConversion[i];
        }
        System.out.println("Decoded String:");
        System.out.println(result + "\n");
    }
}
