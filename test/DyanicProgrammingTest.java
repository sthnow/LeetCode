import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DyanicProgrammingTest {
@Before
public void setUp(){
    DyanicProgramming dp = new DyanicProgramming();
    System.out.println(dp.rec_opt(new int[]{1,2,4,1,7,8,3}, 6));
}

    @Test
    public void rec_opt() {
    }
}