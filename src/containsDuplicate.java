public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return flag = true;
                }
            }
        }
        return flag;
    }
}

        /*  int n = 0;
        int count = 0;

        while(n < nums.length){

            for(int i = 0; i < nums.length; i++){

                if(nums[n] == nums[i] ){
                    count ++;
                }
            }
            n++;
                }

         if(count > nums.length){
                    return true;
        }else{
             return false;
         }

    }
}
*/

