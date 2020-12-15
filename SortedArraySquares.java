class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int end = arr.length-1;
        int rightIndex = arr.length-1;
        int leftIndex = 0;
        int leftSquare;
        int rightSquare;
        while(leftIndex <= rightIndex && end >=0 ){
            leftSquare = arr[leftIndex] * arr[leftIndex];
            rightSquare = arr[rightIndex] *  arr[rightIndex];
            if(rightSquare >= leftSquare){
                squares[end--] = rightSquare;
                rightIndex--;
            }else {
                squares[end--] = leftSquare;
                leftIndex++;
            }
        }
        return squares;
    }

    /**
     * Original impl
     * @param arr
     * @return
     */
    public static int[] makeSquares_V0(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIdx = n - 1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }
        return squares;
    }


    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -1, 0, 1, 2, 3, 5 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { 1, 2, 3, 5 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }

}