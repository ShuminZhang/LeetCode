
//寻找最近的回文数
import java.util.*;

class Leet564 {
    public String nearestPalindromic(String n) {
        long cur = Long.parseLong(n);
        int len = n.length();
        // 构造包含999...999和10000....001的候选集
        List<Long> candidates = new ArrayList<Long>() {
            {
                add((long) Math.pow(10, len - 1) - 1);
                add((long) Math.pow(10, len) + 1);
            }
        };

        // 判断字符串的前半部分，curPrefix-1，curPrefix，curPrefix+1，获取可能的相邻回文数，注意：subString()范围 左开右闭
        long curPrefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = curPrefix - 1; i <= curPrefix + 1; i++) {
            long temp = getNum(i, len % 2 == 0);// 根据长度判断是否为偶数长度字符串
            if (temp != cur) {
                candidates.add(temp);
            }
        }

        long ans = -1;// 解决字符串长度超过19，爆long的问题
        for (long c : candidates) {
            if (ans == -1) {
                ans = c;// 赋值为候选集中的以一个数
            }

            // 如果如果当前遍历到的结果c与传进来的数值距离更近，就更新ans为当前结果i的值
            else if (Math.abs(c - cur) < Math.abs(ans - cur)) {
                ans = c;
            }

            // 当结果集中有两个结果与传进来的值距离一样，并且当前的结果i的值更小，那么就将ans的值赋为当前结果c
            else if (Math.abs(c - cur) == Math.abs(ans - cur) && c < ans) {
                ans = c;
            }
        }
        return String.valueOf(ans);
    }

    public long getNum(long k, boolean isEven) {

        StringBuilder sb = new StringBuilder();
        sb.append(k);
        int n = sb.length();
        // 奇数串需要跳过中间的字符转置，偶数串不需要跳过
        int index = isEven ? n - 1 : n - 2;
        // 将前部分转置加到后面构成回文串
        while (index >= 0) {
            sb.append(sb.charAt(index));
            index--;
        }
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Leet564 l = new Leet564();
        System.out.println(l.nearestPalindromic(str));
        sc.close();
    }
}