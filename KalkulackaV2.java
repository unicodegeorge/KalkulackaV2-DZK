import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class KalkulackaV2 {
    String stringNum = "";
    int[] numbers = new int[2];
    char currentOperator = 0;
    int currentNumPos = 0;
    int tempResult = 0;
    String number = "";
    int result;

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        KalkulackaV2 kv2 = new KalkulackaV2();
        kv2.run();
    }

    public void addNumToString(char num) {
        stringNum += "" + num;
        run();

    }

    public void odradkuj() {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

    public void run() {
        odradkuj();
        System.out.println("Last result = " + result);
        System.out.println("[ Kalkulacka - DZK - George Dvorak ]");
        System.out.println(stringNum);
        System.out.println("[7] [8] [9]");
        System.out.println("[4] [5] [6]");
        System.out.println("[1] [2] [3]");
        System.out.println("[*] [/] [+]");
        System.out.println("[  0  ] [-]");
        System.out.println("[    =    ]");
        char selectedBtn = sc.nextLine().charAt(0);
        if (Character.isDigit(selectedBtn)) {
            number = number + "" + selectedBtn;

            addNumToString(selectedBtn);

        } else if (selectedBtn == '+' || selectedBtn == '-' || selectedBtn == '*' || selectedBtn == '/') {
            numbers[currentNumPos] = Integer.parseInt(number);
            if (numbers[1] == 0) {

                number = "";
                System.out.println("number na pozici " + currentNumPos + " je " + numbers[currentNumPos]);
                currentOperator = selectedBtn;
                currentNumPos++;
                addNumToString(selectedBtn);

            } else {

                switch (currentOperator) {

                case '+':

                    tempResult = numbers[0] + numbers[1];
                   
                  

                    break;

                case '-':

                    tempResult = numbers[0] - numbers[1];
                   

                   
                    break;

                case '*':

                    tempResult = numbers[0] * numbers[1];
                    

                   
                    break;

                case '/':

                    tempResult = numbers[0] / numbers[1];
                    

                   
                  
                    break;

                default:

                    break;

                }

                    currentOperator = selectedBtn;
                    stringNum = "" + tempResult + "" + currentOperator;
                    numbers[0] = tempResult;
                    currentNumPos = 1;
                    number = "";
                    run();
            }
        }

        else if (selectedBtn == '=') {
            numbers[1] = Integer.parseInt(number);
            System.out.println(numbers[0] + " " + numbers[1]);
            switch (currentOperator) {
            case '+':

                result = numbers[0] + numbers[1];

                stringNum = "";
                number = "";

                numbers[0] = 0;
                numbers[1] = 1;
                run();

                break;

            case '-':

                result = numbers[0] - numbers[1];

                stringNum = "";
                number = "";

                numbers[0] = 0;
                numbers[1] = 1;
                run();

                break;

            case '/':

                result = numbers[0] / numbers[1];

                stringNum = "";
                number = "";

                numbers[0] = 0;
                numbers[1] = 1;
                run();

                break;

            case '*':

                result = numbers[0] * numbers[1];

                stringNum = "";
                number = "";

                numbers[0] = 0;
                numbers[1] = 1;
                run();

                break;

            }
        }

    }
}
