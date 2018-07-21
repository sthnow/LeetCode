import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * MoveZeroes Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÆßÔÂ 20, 2018</pre>
 */
public class MoveZeroesTest {

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {

    }

    /**
     * Method: moveZeroes(int[] nums)
     */
    @Test
    public void testMoveZeroes() throws Exception {
//TODO: Test goes here...
        MoveZeroes mz = new MoveZeroes();
        int[] nums = new int[]{1, 2, 3, 4, 0, 6, 5};
        mz.moveZeroes(nums);
    }


} 
