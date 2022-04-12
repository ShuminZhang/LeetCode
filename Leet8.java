public class Leet8 {
    public int myAtoi(String s) {
        int i = 0; // 遍历用
        int sign = 1; // 记录正负数

        // 跳过开头空格
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        int start = i; // 记录数字的开头
        int res = 0; // 记录压缩后的数字
        for (i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i == start && ch == '+') {
                sign = 1;
            } else if (i == start && ch == '-') {
                sign = -1;
            } else if (Character.isDigit(ch)) {
                int num = ch - '0';
                if (res > (Integer.MAX_VALUE / 10)
                        || res == (Integer.MAX_VALUE / 10) && num > (Integer.MAX_VALUE % 10)) { // num前几位数与MAX_VALUE前几位数相等，但是当前获取的位数大于MAX_VALUE该位数，那么不需要得到之后的数了
                    return Integer.MAX_VALUE;
                } else if (res < (Integer.MIN_VALUE / 10)
                        || res == (Integer.MIN_VALUE / 10) && -num < (Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + sign * num;
            } else {// 不是数字，跳出循环
                break;
            }
        }

        return res;
    }
}
