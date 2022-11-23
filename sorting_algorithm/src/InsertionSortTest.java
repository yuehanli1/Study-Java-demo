import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertionSortTest {

    @Test
    void sort() {
        int[] sourceArrays = {1, 3, 4, 6, 7, 5, 8};
        int[] targetArrays  = {1, 3, 4, 5, 6, 7, 8};
        Assertions.assertArrayEquals(targetArrays, new InsertionSort().sort(sourceArrays));
    }
}