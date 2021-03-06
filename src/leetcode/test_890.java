package leetcode;

import java.util.*;

/**
 * @Description: 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，
 * 我们就得到了所需的单词，那么单词与模式是匹配的。
 * <p>
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * <p>
 * 返回 words 中与给定模式匹配的单词列表。
 * 你可以按任何顺序返回答案。
 * <p>
 * 示例：
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 * <p>
 * 提示：
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 * --------------------------------------
 * @ClassName: test_890.java
 * @Date: 2019/5/31 15:37
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_890 {
    public static void main(String[] args) {
        String[] words = new String[]{"abc", "deq", "mee", "aqq", "dkd", "lol", "ccc"};
        String pattern = "bab";
        Solution_890 solution = new Solution_890();
//        System.out.println(solution.findAndReplacePattern(words, pattern));
        System.out.println(solution.findAndReplacePatternTwo(words, pattern));
    }
}

class Solution_890 {
    /**
     * @Description: pattern字符set，word字符set，对应位置的拼接string(word[0]+pattern[0])字符串set
     * 三者长度相同才能满足要求
     * @Date: 2019/5/31 17:34
     * @Params:
     * @ReturnType:
     **/
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        Set parSet = new HashSet();
        for (int i = 0; i < pattern.length(); i++) {
            parSet.add(pattern.charAt(i));
        }
        for (String word : words) {
            // 长度不同不符合
            if (word.length() != pattern.length()) {
                continue;
            }
            Set wordSet = new HashSet();
            for (int i = 0; i < word.length(); i++) {
                wordSet.add(word.charAt(i));
            }
            Set duiying = new HashSet();
            for (int i = 0; i < pattern.length(); i++) {
                duiying.add(String.valueOf(pattern.charAt(i)) + String.valueOf(word.charAt(i)));
            }
            if (wordSet.size() == parSet.size() && wordSet.size() == duiying.size()) {
                result.add(word);
            }
        }
        return result;
    }


    /**
     * @Description:
     * word.indexOf(wordChars[i], i + 1) == pattern.indexOf(patternChars[i], i + 1)
     * 保证word与pattern中每个char在其index后出现的位置一致
     * @Date: 2019/5/31 17:38
     * @Params:
     * @ReturnType:
     **/
    public List<String> findAndReplacePatternTwo(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (isTar(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    public boolean isTar(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        char[] wordChars = word.toCharArray();
        char[] patternChars = pattern.toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            if (word.indexOf(wordChars[i], i + 1) !=
                    pattern.indexOf(patternChars[i], i + 1)) {
                return false;
            }
        }
        return true;
    }

}