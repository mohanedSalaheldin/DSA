import java.util.Arrays;
import java.util.List;

public class BS {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high) {
            int mid = (low + high) /2;
            if (nums[mid] == target){
                return  mid;
            }else if(nums[low] <= nums[mid]){
                    if (nums[low] <= target && nums[mid] >= target){
                        high = mid - 1;
                    }else {
                        low = mid + 1;
                    }
            }else {
                if (nums[mid] <= target && nums[high] >= target){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return  -1;
    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int  min = nums[0];
        while(low <= high) {
            int mid = (low + high) /2;

            min = Math.min(nums[mid], min);
            if(nums[low] <= nums[mid]){
                min = Math.min(nums[low], min);
                low = mid + 1;
            }else {
                min = Math.min(nums[low], min);
                high = mid - 1;
            }
        }
        return  min;
    }

    public static int findKRotation(List<Integer> arr) {
        int low = 0;
        int high = arr.size()-1;
        int k = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr.get(k) > arr.get(mid)){
                k = mid;
            }
            if(arr.get(mid) >= arr.get(low)){
                if(arr.get(k) > arr.get(low)){
                    k = low;
                }
                low = mid + 1;
            }else{
                if(arr.get(k) > arr.get(high)){
                    k = high;
                }
                high = mid - 1;
            }
        }
        return k;
    }
//    public static void main(String[] args) {
//        int[] arr = {5,6,6,7,1,2,4};
//
//        int re = findKRotation(Arrays.asList(arr));
//        System.out.println(re);
//
//    }
}
