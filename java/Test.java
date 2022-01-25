import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
      int[] result=new int[2];
      HashMap<Integer,Integer> history=new HashMap<Integer,Integer>();
      for(int i=0;i<nums.length;i++){
          int compliment=target-nums[i];
          if(history.containsKey(compliment)){
              result[0]=history.get(compliment);
              result[1]=i;
              return result;
          }
          history.put(nums[i], i);
      }
      return result;
    }

}
public class Test{
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] numset=new int[]{1,2,3,4,5,6};
        System.out.println(s.twoSum(numset,7));
    }
}