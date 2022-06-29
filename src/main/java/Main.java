import java.util.Scanner;

/* Main Class */
public class Main {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            Runner.askOptions(sc);
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}