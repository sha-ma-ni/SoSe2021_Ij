package Aufgaben.singleNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSingleNumber {
    int[] nums1 = {2, 2, 1};
    int[] nums2 = {2, 2, 1, 1,8};


    @Test
    void test() {
       assertTrue(1==singleNumber.singleNumber(nums1),"Input: [2,2,1] Expected output: 1");
       assertTrue(8==singleNumber.singleNumber(nums2),"Input: [2, 2, 1, 1,8] Expected output: 8");
       assertFalse(2==singleNumber.singleNumber(nums2),"Input: [2, 2, 1, 1,8] Expected output: 8");

    }

}