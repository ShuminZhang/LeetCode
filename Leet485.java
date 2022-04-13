public class Leet485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, m_ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                m_ans++;
            } else {
                ans = Math.max(ans, m_ans);
                m_ans = 0;
            }
            ans = Math.max(ans, m_ans);
        }
        return ans;
    }
}
