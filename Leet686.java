public class Leet686 {
    public int repeatedStringMatch(String a, String b) {
        int lena = a.length(), lenb = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        // b为a的子串
        if (lena - index >= lenb) {
            return 1;
        }

        // (lenb + (lena - index) - 1) / lena + 1 + 1的变形，最后一个加1是因为java除法下取整,题目需要上取整（2.5
        // 取3），因此加一
        return (lenb + index - lena - 1) / lena + 2;
    }

    // KMP算法
    public int strStr(String a, String b) {
        int lena = a.length(), lenb = b.length();
        if (lenb == 0) {
            return 0;
        }
        // a = " " + a;
        // b = " " + b;
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int[] next = new int[lenb];

        // 构造next数组
        for (int i = 1, j = 0; i < lenb; i++) {
            while (j > 0 && bb[i] != bb[j]) {
                j = next[j - 1];
            }

            if (bb[i] == bb[j]) {
                j++;
            }
            next[i] = j;
        }

        // 子串匹配
        for (int i = 0, j = 0; i - j < lena; i++) {
            while (j > 0 && aa[i % lena] != bb[j]) {
                j = next[j - 1];
            }

            if (aa[i % lena] == bb[j]) {
                j++;
            }

            if (j == lenb) {
                return i - lenb + 1;
            }
        }
        return -1;
    }
}
