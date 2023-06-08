package easy_questions;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIdx = m - 1;
        int nIdx = n - 1;
        int mergeIdx = m + n - 1;
        while (mIdx >= 0 && nIdx >= 0) {
            if (nums1[mIdx] > nums2[nIdx]) {
                nums1[mergeIdx] = nums1[mIdx];
                mIdx--;
            } else {
                nums1[mergeIdx] = nums2[nIdx];
                nIdx--;
            }
            mergeIdx--;
        }

        while (mIdx >= 0) {
            nums1[mergeIdx] = nums1[mIdx];
            mIdx--;
            mergeIdx--;
        }

        while (nIdx >= 0) {
            nums1[mergeIdx] = nums2[nIdx];
            nIdx--;
            mergeIdx--;
        }
    }
}
