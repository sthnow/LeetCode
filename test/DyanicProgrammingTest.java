import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DyanicProgrammingTest {
@Before
public void setUp(){
    DyanicProgramming dp = new DyanicProgramming();
//    System.out.println(dp.rec_opt(new int[]{1,2,4,1,7,8,3}, 6));
//    System.out.println(dp.opt_dp(new int[]{4,1,1,9,3}, 4));
//    System.out.println(dp.rec_subset(new int[]{3,0,4,12,5,2}, 5,0));
//    System.out.println(dp.dp_subset(new int[]{3,0,4,12,5,2}, 8));
//    System.out.println(dp.climbStairs(10));
 //   System.out.println(dp.rob(new int[]{2,1,5,2}));
 //   System.out.println(dp.maxSubArray(new int[]{-2,-1}));
    System.out.println(dp.coinChange(new int[]{2,5,186,419,89,408},6249));
}




    @Test
    public void rec_opt() {
    }

    @Test
    public void opt_dp() {
    }

    @Test
    public void rec_subset() {
    }

    @Test
    public void dp_subset() {
    }

    @Test
    public void climbStairs() {
    }

    @Test
    public void rob() {
    }

    @Test
    public void maxSubArray() {
    }

    @Test
    public void coinChange() {
    }
}