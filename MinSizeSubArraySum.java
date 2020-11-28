class MinSizeSubArraySum {
    public static int findMinSubArray_v0(int S, int[] arr) {
        int minLength = arr.length-1;
        int windowSum =0;
        int windowStart = 0;
        int windowEnd = 0;
        int arrLength = arr.length-1;
        while(windowStart < arrLength && windowEnd < arrLength ){
            //sum is less, keep adding from end
            if(windowSum < S) {
                windowSum += arr[windowEnd++];
            }// sum is more/equal, keep removing from start
            else{
                minLength = Math.min(minLength, (windowEnd - windowStart));
                windowSum -= arr[windowStart++];
            }
        }
        return minLength;
    }

    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


    /**
     * Input: [2, 1, 5, 2, 3, 2], S=7
     * Output: 2
     *
     *
     * findMinSubArray(7, [2, 1, 5, 2, 3, 2])	=> 2
     * findMinSubArray(8, [3, 4, 1, 1, 6])	    => 3
     * findMinSubArray(7, [2, 1, 5, 2, 8])	    => 1
     *
     */
    public static void main(String[] args){

        int minLength = 0;
        /*
        //Test-1
        minLength = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Min size of sub array with sum less S: " + Integer.toString(minLength));

        //Test-2
        minLength = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Min size of sub array with sum less S: " + Integer.toString(minLength));
    */

        //Test-3
        minLength = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Min size of sub array with sum less S: " + Integer.toString(minLength));

    }

}