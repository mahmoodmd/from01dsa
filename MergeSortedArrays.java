public class MergeSortedArrays {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

        static void test1(){
            int nums1[] = {1,2,3,0,0,0};
            int nums2[] = {2,5,6};
            merge(nums1, 3, nums2, 3);
            printArray(nums1);
        }

        static void test2(){
            int nums1[] = {2, 0};
            int nums2[] = {1};
            merge(nums1, 1, nums2, 1);
            printArray(nums1);
        }


        static void test3(){
            int nums1[] = {1};
            int nums2[] = {};
            merge(nums1, 1, nums2, 0);
            printArray(nums1);
        }

        static void test4(){
            int nums1[] = {-1,0,0,3,3,3,0,0,0};
            int nums2[] = {1,2,2};
            merge(nums1, 6, nums2, 3);
            printArray(nums1);
        }

        static void merge3(int[] nums1, int m, int[] nums2, int n) {

            //edge cases
            if(n == 0)
                return;

            int i1 = 0; //1st array
            int i2 = 0; //2nd array
            while (i1 < m+n && i2 < n){
                //go over arr1

                //if nums1 > nums2 shiftRight nums1 i1 by 1, put nums2[j] & j++
                if(nums1[i1] > nums2[i2]){

                    //shift right by 1, //shiftRight(nums1, i1);
                    for(int s = nums1.length-1; s > i1; s--) {
                        System.out.println(nums1[s]);
                        nums1[s]=nums1[s-1];
                    }

                    nums1[i1]=nums2[i2++];
                }
                //else nums1 <= nums2 or
                //if zero or tail
                if(nums1[i1-1] > nums1[i1])
                    nums1[i1]=nums2[i2++];

                //go to next elm
                i1++;
            }

        }


        //TWO other solutions @ https://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
        static void merge1(int A[], int m, int B[], int n) {

            while(m > 0 && n > 0){
                if(A[m-1] > B[n-1]){
                    A[m+n-1] = A[m-1];
                    m--;
                }else{
                    A[m+n-1] = B[n-1];
                    n--;
                }
            }

            while(n > 0){
                A[m+n-1] = B[n-1];
                n--;
            }
        }


        static void merge(int A[], int m, int B[], int n) {
            int i = m - 1;
            int j = n - 1;
            int k = m + n - 1;

            while (k >= 0) {
                if (j < 0 || (i >= 0 && A[i] > B[j]))
                    A[k--] = A[i--];
                else
                    A[k--] = B[j--];
            }
        }


        static void printArray(int[] nums) {
            StringBuffer sb = new StringBuffer();
            for (int num:nums) {
                sb.append(String.valueOf(num)).append(", ");
            }
            System.out.println(sb.toString());
        }

}
