package com.aben;

/**
 * @author sjp
 * @date 2020/07/24
 */
public class Sort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 7, 4, 8, 2, 9, 10, 4, 2, 6, 3};
        quickSort(nums);
        isSort(nums);
    }

    private static void isSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                throw new RuntimeException("排序错误");
            }
        }
    }


    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(nums, start, end);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (i <= end && nums[i] < nums[start]) {
                i++;
            }
            while (nums[j] > nums[start]) {
                j--;
            }
            if (j <= i) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, start, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
