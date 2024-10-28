import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();

        for(int x : nums) {
            set.add(0L + x);
        }
        Arrays.sort(nums);
        Set<Long> used = new HashSet<>();
        int res = -1;

        for(int i = 0; i < nums.length; i++) {
            if(used.contains(nums[i] + 0L)){
                continue;
            }
            used.add(nums[i] + 0L);
            long candidate = nums[i];
            int c = 1;
            while(candidate * candidate <= nums[nums.length - 1]) {
                if(set.contains(candidate * candidate)) {
                    used.add(candidate * candidate);
                    c++;
                    candidate = candidate * candidate;
                }else break;
            }
            if(c != 1){
                res = Math.max(res , c);
            }
            

        }

        return res;
    }
}

