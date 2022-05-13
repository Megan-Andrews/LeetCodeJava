import java.util.HashMap;

import static java.lang.Math.*;

public class Solution {


    /**
     * 1 Two Sum
     *
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (temp.containsKey(diff)){
                return new int[] {temp.get(diff), i};
            }
            else{
                temp.put(nums[i],i);
            }
        }
        return new int[] {0,0};
    }

    /**
     * 2 Add Two Numbers
     */
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode n1 = l1;
            ListNode n2 = l2;
            int sum = n1.val + n2.val;
            int remainder = sum % 10;
            int carry = sum / 10;
            int tempCarry;
            ListNode l3 = new ListNode(remainder);
            ListNode n3 = l3;
            while(n1.next != null || n2.next != null)
            {
                if(n1.next != null && n2.next != null){
                    n1 = n1.next;
                    n2 = n2.next;
                    sum = n1.val + n2.val;
                }else if(n1.next != null){
                    n1 = n1.next;
                    sum = n1.val;
                }else if(n2.next != null){
                    n2 = n2.next;
                    sum = n2.val;
                }
                remainder = sum % 10;
                tempCarry = remainder + carry;
                ListNode temp = new ListNode(tempCarry%10);
                carry = sum / 10 + tempCarry / 10;
                n3.next = temp;
                n3 = n3.next;
            }
            if(carry!=0){
                n3.next = new ListNode(carry);
            }
            return l3;
      }

    /**
     * 3 Longest Substring Without Repeating Characters
      */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> temp = new HashMap();
        HashMap<Character,Integer> max = new HashMap();

        int startIndex = 0;
        int endIndex = 0;
        while(startIndex < s.length()){
            for(int i= startIndex; i < s.length(); i++){
                if(temp.containsKey(s.charAt(i))){
                    max = (temp.size() > max.size() ? temp : max);
                    startIndex = temp.get(s.charAt(i)) + 1;
                    temp = new HashMap();
                    break;
                }else{
                    temp.put(s.charAt(i),i);
                }
            }
        }

        return max.size();
    }

    /**
     *  4 Find Median Sorted Arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1.length <= nums2.length ? nums1 : nums2;
        int[] b = nums1.length <= nums2.length ? nums2 : nums1;

        //System.out.println(a[0]);
        //System.out.println(b[0]);

        int totalSize = a.length + b.length;
        int halfSize = totalSize / 2;

        int left = 0;
        int right = a.length - 1;

        while(true){
            int i = (int) floor(((double)left + (double) right) / 2.0); //left index of a's partition
            int j = halfSize - i - 2; //left index of b's partition
            //System.out.println(left +" " + right+ " " + i);

            int Aleft = i >= 0 ? a[i] :  (-1000001);
            //System.out.println(a[i]);
            int Aright = (i + 1) < a.length ? a[i +1] : (1000001);
            int Bleft = j >= 0 ? b[j] : (-1000001);
            int Bright = (j + 1) < b.length ? b[j + 1] : (1000001);
            //System.out.println(a[i] + " " + a[i+1] + " " + b[j] + " " + b[j+1]);
            //System.out.println(Aleft + " " + Aright + " " + Bleft + " " + Bright);

            if(Aleft <= Bright & Bleft <= Aright){
                double minRight = Aright <= Bright ? Aright : Bright;
                double maxLeft = Aleft > Bleft ? Aleft : Bleft;
                //System.out.println(minRight + " "+  maxLeft);
                return totalSize % 2 != 0 ? minRight :  (maxLeft + minRight)/2;
            }else if( Aleft > Bright){
                right = i - 1;
            }else{
                left = i + 1;
            }
        }
    }
}
