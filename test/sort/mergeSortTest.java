package sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class mergeSortTest {
@Before
public void setUp(){
    sort.mergeSort ms = new sort.mergeSort();
    System.out.println(Arrays.toString(ms.sort(new int[]{1,7,5,4,3,8,9,1,2},0,8)));
}

    @Test
    public void sort() {
    }
}