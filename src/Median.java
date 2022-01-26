public class Median {

    // https://leetcode.com/problems/median-of-two-sorted-arrays/

    private static int[] mergeSorted(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int x = 0;

        while ((i < nums1.length) && (j < nums2.length)) {
            if (nums1[i] < nums2[j]) {
                result[x] = nums1[i];
                i++;
            } else {
                result[x] = nums2[j];
                j++;
            }
            x++;
        }
        while (j < nums2.length) {
            result[x] = nums2[j];
            x++;
            j++;
        }

        while (i < nums1.length) {
            result[x] = nums1[i];
            x++;
            i++;
        }


        return result;
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = mergeSorted(nums1, nums2);

        if(result.length % 2 == 0) {
            return ((double)result[result.length/2 -1] + (double)result[result.length/2]) / 2;
        } else {
            return result[result.length/2];
        }
    }



    public static void main(String[] args) {
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};

        System.out.println(findMedianSortedArrays(nums3, nums4));

    }
}
