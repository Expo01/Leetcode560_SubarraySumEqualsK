import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap< >();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

// 3,4,7,2,-3,1,4,2,1      k = 7
// suppose this scenario we need to find a prefixSum in map of currentSum - k and add the map value if the
// prefix sum found, otherwise map the currentSum and its frequency and update frequency whenever current sum found
// again. ultimately the prefix sum of 14 will have occured twice and map value will be (14,2). so when we get to
// final index and sum = 21 so 21-7 = 14. we note the prefixSum occured in two different ways, so we can say there
// are 2 different start indexes from the current index @ currentSum where a value increase of k (7) was found
// (2,-3,1,4,2,1) subarray == 7 and (4,2,1) == 7. so frequency added.
// but take for example how when 14 was found, a prefixSum of 7 existed and again we say count++ for each of those
// (3,4) and (3,4,7,2,-3,1) but not how each time 14 encountered that it was just count++. but suppose we came accross
// prefix product of 14 multiples times. this is not redundantly adding +=2. suppose
// 3,4,7,2,-3,1,4,2,1,4,-4 so Sum goes from 21,24,21. 21 will have prefix product of 14 so again from the first 21 Sum
// there are 2 preceding ways to make 14 and from the second 21 there are 2 more ways
//(2,-3,1,4,2,1,4,-4) subarray == 7 and (4,2,1,4,-4) == 7






// brute force for loops
// can't do for loop nested while loop 2 pointer since could be 1 element or all elements, etc.
// won't be a memo table sice no storing subproblems. just because we had a sum earlier doesn't help
// since different indexes?
// there are ways to reduce iterations of loop such as if current val > sum then continue but meh
//