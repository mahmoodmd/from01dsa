class RemoveDuplicates {

    public static int remove(int[] arr) {
        int nonDupIndex =0;
        for(int next=1; next < arr.length; next++){
            //dont increment nonDupIndex until nonDup & next are different element.
            if(arr[nonDupIndex] != arr[next])
                arr[++nonDupIndex] = arr[next];
        }
        return nonDupIndex+1;
    }


    public static int remove_v1(int[] arr) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }

}
