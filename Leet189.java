import java.util.*;

public class Leet189 {
    public void rotate(int[] nums, int k) {

        // 数组反转解法
        int n = nums.length;
        k %= n; // 需要移动的位置大于数组长度，模除保证不超出界限
        reverse(0, n - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, n - 1, nums);

        for (int i = 0; i < n; i++) {
            System.out.print(" " + nums[i]);
        }

        // return nums;
    }

    public void reverse(int i, int j, int[] nums) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toString();
        String[] arr = str.split(",");
        int[] array = new int[arr.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }

        Scanner s = new Scanner(System.in);
        System.out.println("输入k:");
        int k = s.nextInt();

        Leet189 l = new Leet189();
        l.rotate(array, k);
        sc.close();
        s.close();
    }

}
