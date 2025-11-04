package chucknorris;

import java.util.Scanner;

public class Main {
    static boolean isValid = true;

    public static void main(String[] args) {
        String instructions;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input operation (encode/decode/exit): ");


        while (sc.hasNextLine()) {
            instructions = sc.nextLine();
            if (instructions.equals("encode")) {
                System.out.println("Input String:");
                StringProcessor.input = sc.nextLine();
                StringProcessor.processor();
                System.out.println("Please input operation (encode/decode/exit): ");
            } else if (instructions.equals("decode")){
                System.out.println("Input encoded string:");
                StringProcessor.input = sc.nextLine();
                for (int i = 0; i < StringProcessor.input.length(); i ++) {
                    if (StringProcessor.input.charAt(i) != '0' && StringProcessor.input.charAt(i) != ' ') {
                        System.out.println("Encoded string is not valid");
                        System.out.println("Please input operation (encode/decode/exit):");
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    decoder.decode();
                    System.out.println("Please input operation (encode/decode/exit): ");
                }
            } else if (instructions.equals("exit")) {
                System.out.println("Bye!");
                System.exit(0);
            } else {
                System.out.println("There is no '" + instructions + "' operation\n");
                System.out.println("Please input operation (encode/decode/exit):");
            }

        }

    }

}