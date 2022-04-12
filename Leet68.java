import java.util.*;

public class Leet68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        // cnt记录该行单词和词尾空格的长度
        // bg 记录初始单词位置
        int cnt = 0, bg = 0;
        for (int i = 0; i < words.length; i++) {
            cnt += words[i].length() + 1;
            // 如果是最后一个单词，或者加上下一个词就超过长度了，即可凑成一行
            if (i + 1 == words.length || cnt + words[i + 1].length() > maxWidth) {
                // 对每行单词进行空格平均划分
                res.add(fillWords(words, bg, i, maxWidth, i + 1 == words.length));
                // 上一行已经划分结束，bg指向下一行的起始单词
                bg = i + 1;
                // cnt重新赋值为零，记录下一行的单词和词尾空格长度继续进行判断
                cnt = 0;
            }
        }
        return res;
    }

    /**
     * 对每行单词进行空格平均划分
     */
    private String fillWords(String[] words, int bg, int ed, int maxWidth, boolean lastLine) {
        // wordCount记录该行单词的个数，也是总共有多少的词尾空格
        int wordCount = ed - bg + 1;
        // spaceCount记录除了词尾空格外的额外空格，为方便将额外空格平均分配， 除去每个单词尾部空格， + 1 是最后一个单词的尾部空格的特殊处理
        int spaceCount = maxWidth + 1 - wordCount;
        for (int i = bg; i <= ed; i++) {
            // 除去所有单词的长度
            spaceCount -= words[i].length();
        }
        // 词尾空格
        int spaceSuffix = 1;
        // 额外空格的平均值 = 总空格数/间隙数
        int spaceAvg = (wordCount == 1) ? 1 : spaceCount / (wordCount - 1);
        // 额外空格的余数
        int spaceExtra = (wordCount == 1) ? 0 : spaceCount % (wordCount - 1);
        // 填入单词
        StringBuilder sb = new StringBuilder();
        for (int i = bg; i < ed; i++) {
            sb.append(words[i]);
            if (lastLine) {
                sb.append(" ");
                continue;
            }
            int n = spaceSuffix + spaceAvg + (((i - bg) < spaceExtra) ? 1 : 0);
            while (n-- > 0) {
                sb.append(" ");
            }
        }
        // 填入最后一个单词
        sb.append(words[ed]);
        // 补上这一行最后的空格
        int lastSpaceCnt = maxWidth - sb.length();
        while (lastSpaceCnt-- > 0) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
