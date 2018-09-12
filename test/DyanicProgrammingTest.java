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
    System.out.println(dp.dp_subset(new int[]{3,0,4,12,5,2}, 8));
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
}