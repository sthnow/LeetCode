import java.util.Scanner;

public class binary_search {


    int[] num = new int[]{1,2,3,4,5,6,7,8,9,10,12,13,14,15,16,17};

    public static void main(String[] args){
        binary_search bs = new binary_search();
        bs.search(bs.input(),bs.num);

    }

    public int input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
        String s = sc.next();
        System.out.println("您输入的数字为" + s);
        sc.close();
        int num = Integer.valueOf(s);
        return num;
    }

    public void search(int target,int[] num){

        int low = 0;
        int counter = 0;
        int high = num.length-1;

        while(low <= high){


            counter = counter + 1;

            int mid = (low + high)/2;
            int guess = num[mid];
            if(guess == target){
                System.out.println("已找到该数字,迭代了：" + counter + " 次" );
                break;
            } else if(guess < target && guess < num[high]){
                low = mid + 1;
            } else if(guess > target && guess > num[low]){
                high = mid - 1;
            } else{
                System.out.println("未能找到该数字");
                break;

            }

        }
    }
}
