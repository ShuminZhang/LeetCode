import java.util.*;

public class Leet258 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        if (num < 10)
            System.out.println(num);

        // int ans = num;
        // int x = 0;
        while (num >= 10) {
            int x = 0;
            while (num > 0) {
                x += num % 10;
                num /= 10;
            }
            num = x;
        }
        System.out.println(num);

        sc.close();
    }
}
