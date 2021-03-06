package leetcode;

import java.util.Arrays;

/**
 * @Description: 数组拆分1
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 示例 1:
 * 输入: [1,4,3,2]
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * <p>
 * 提示:
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 * --------------------------------------
 * @ClassName: test_561.java
 * @Date: 2019/8/3 22:03
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_561 {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        Solution_561 solution = new Solution_561();
        System.out.println(solution.arrayPairSum(nums));
    }
}

class Solution_561 {
    /**
     * @Description: 排序取奇数，对应的和最大
     * @Date:        2019/8/3 22:28
     * @Params:
     * @ReturnType:
     **/
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}