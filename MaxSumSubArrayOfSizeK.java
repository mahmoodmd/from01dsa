class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        // TODO: Write your code here
        int[] result = new int[arr.length -k +1];
        int windowStart = 0;
        int windowSum =0;
        int maxSumIndex =0;
        for(int windowEnd =0; windowEnd < arr.length-1; windowEnd++){
            windowSum += arr[windowEnd];
            //first window, at kth element
            if(windowEnd >= k-1 ){
                result[windowStart] = windowSum;
                //maxSum compare
                if(windowStart > 0 & result[maxSumIndex] < result[windowStart]){
                    maxSumIndex = windowStart;
                }
                //Prep for next round: minus out going element (first element of window)
                windowSum -=arr[windowStart];
                windowStart++; //new window
            }
        }
        return result[maxSumIndex];
    }

    public static int findMaxSumSubArray_v1(int k, int[] arr) {
        int maxSum = 0, windowSum;
        for (int i = 0; i <= arr.length - k; i++) {
            windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static int findMaxSumSubArray_v2(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return maxSum;
    }

    public static void main(String[] args)  {
        /**
         * Input: [2, 1, 5, 1, 3, 2], k=3
         * Output: 9
         * Explanation: Subarray with maximum sum is [5, 1, 3].
         */
        int result = MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 });
        System.out.println("Max sum of subarrays of size K: " + Integer.toString(result));
    }

}
