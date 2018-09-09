import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DyanicProgrammingTest {
@Before
public void setUp(){
    DyanicProgramming dp = new DyanicProgramming();
//    System.out.println(dp.rec_opt(new int[]{1,2,4,1,7,8,3}, 6));
    System.out.println(dp.rec_opt_dp(new int[]{4,1,1,9,3}, 4));
}

    @Test
    public void rec_opt() {
    }

    @Test
    public void rec_opt_dp() {
    }
}