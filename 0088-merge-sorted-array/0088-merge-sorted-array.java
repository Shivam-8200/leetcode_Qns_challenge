class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0){
            if(nums1[i] < nums2[j]){
               nums1[k] = nums2[j];
                j--;k--;
            } else {
                
                 nums1[k] = nums1[i];
                i--;k--;
            }
            
        }

        while(j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
// // nums2 ke elements nums1 mein daalo
//for(int i = 0; i < n; i++){
  //  nums1[m + i] = nums2[i];  // 0s ki jagah!
//}

// sort karo!
//Arrays.sort(nums1);