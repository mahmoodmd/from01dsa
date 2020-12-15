class RemoveElement {

    public static int remove(int[] arr, int key) {
        int nonKeyIndex = 0; // index of the next element which is not 'key'
        //[3, 2, 3, 6, 3, 10, 9, 3]
        //[2, 2, 3, 6, 3, 10, 9, 3]
        //[2, 6, 3, 6, 3, 10, 9, 3]
        for(int next=0; next < arr.length; next++ ){
            if(arr[next] != key)
                arr[nonKeyIndex++] = arr[next];
        }
        return nonKeyIndex;
    }

    public static int remove_v0(int[] arr) {
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
        int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
        System.out.println(RemoveElement.remove(arr, 3));

        arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(RemoveElement.remove(arr, 2));
    }
}