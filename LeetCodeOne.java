public class LeetCodeOne {
    /*  https://leetcode.com/problems/majority-element/
        Problem: Majority Element. Find the majority element (element that appears more than length/2 times in an
        array.
        Input: Array of numbers
        Output: Element that appears more than n/2 times in the array. n = length of array

        Originally solved in O(n) time and O(n) space using a hashmap. The given solution is optimal in O(n) time
        and O(1) space.
     */
    public int majorityElement(int[] nums) {
        int counter = 1;
        int element = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (counter == 0) {
                element = nums[i];
                counter++;
            } else if (element == nums[i]) {
                counter++;
            }
            else {
                counter--;
            }
        }
        return element;
    }

    /*  https://leetcode.com/problems/valid-anagram
        Problem: Valid Anagram. Find whether two strings are anagrams of each other.
        Input: 2 strings.
        Output: True/False

        Solution is in O(n) time and O(1) space. We create an empty array. We go over string s, and increment the
        index corresponding to the character in the letters array.
        We then go over the second string and decrement the index corresponding to the character in the letters array.

        If the two strings are an anagram, each value will be 0 at the end of the loop. If they're not 0, it's not
         an anagram
     */
    public boolean isAnagram(String s, String t) {
        int[] letters = new int[26];
        char c;

        if (s.length() != t.length()) {
            return false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                letters[c - 'a'] = letters[c - 'a'] + 1;
            }
            for (int i = 0; i < t.length(); i++) {
                c = t.charAt(i);
                letters[c - 'a'] = letters[c - 'a'] - 1;
            }
            for (int j : letters) {
                if (j > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /*  https://leetcode.com/problems/merge-sorted-array
        Problem: Merge Sorted Array. Given two sorted arrays, merge them while maintaining a non decreasing sort
        Input: nums1 array and its length n, nums2 array and its length m.
        Output: No output. This is a void function that changes nums1 array in place.

        Solution is in O(m+n) time and O(m+n) space. If element of nums1 is smaller than nums2, we add ane element from
        nums1, otherwise we add from nums2 array. If an array runs out while they other remains, we fill in remaining
        values from the other array.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int arrayLength = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while(arrayLength >= 0 && i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[arrayLength] = nums2[j];
                j--;
            } else if (j < 0) {
                nums1[arrayLength] = nums2[i];
                i--;
            } else if(nums1[i] < nums2[j]) {
                nums1[arrayLength] = nums2[j];
                j--;
            } else {
                nums1[arrayLength] = nums1[i];
                i--;
            }
            arrayLength--;
        }
    }


}
