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


    public static void main(String[] args){

        int end = 0;
        /*
        	remove([2, 3, 3, 3, 6, 9, 9])	 => 4
            remove([2, 2, 2, 11])	         => 2


        //Test-1
        end = RemoveDuplicates.remove( new int[] { 2, 3, 3, 3, 6, 9, 9 });
        System.out.println("Non Dup array length : " + Integer.toString(end));
*/
        //Test-1
        end = RemoveDuplicates.remove( new int[] { 2, 2, 2, 11});
        System.out.println("Non Dup array length  : " + Integer.toString(end));

    }

}
