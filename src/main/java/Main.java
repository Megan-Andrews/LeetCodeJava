/**
 *  Main class is used for debugging Solution
 */
public class Main {
    static Solution solution = new Solution();

    //4
    public static void runFindMedianSortedArrays(){
       solution.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
       solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});

    }

    //5
    public static void runLongestPalindrome(){

    }


    public static void main(String[] args) {
        runFindMedianSortedArrays(); //change which helper method is run
    }
}
