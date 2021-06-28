import java.util.*;
class searchElement {
    public int search(int[] nums, int target) {
        
      //binary search
        int n = nums.length;
        int start = rotate_index(nums);
        int end = start + n;
        int mid;
        while (end >= start){
            mid = (start + end) / 2; // requires modulus
            if (nums[mid % n] == target) return mid % n;
            else if (nums[mid % n] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    
    public int rotate_index(int[] nums){
        int hi = nums.length - 1;
        int lo = 0;
        int mid = (hi + lo) / 2;
        while (hi >= lo){
            mid = (hi + lo) / 2;
            if (nums[mid] < nums[hi]){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int target=sc.nextInt();
        System.out.println(search(arr,target));
    }
}