class BinarySearch {

    public static int search(int[] arr, int key) {
        if(arr == null)
            return -1;
        int start = 0;
        int end = arr.length -1;
        int middle=0;
        boolean assendingList = arr[end] > arr[start];

        while(start <= end){
            middle = start + (end - start)/2;

            if(key == arr[middle])
                return middle;
            if(assendingList) {  //assending
                if(key > arr[middle])
                    start = middle +1;
                else
                    end = middle -1;
            }else {  //dessending
                if(key > arr[middle])
                    end = middle -1;
                else
                    start = middle +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}