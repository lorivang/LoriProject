package myProj;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortAlgsTest {

	int[][] tests = {{1,0},
			{0,1,2,3,4,5,6,7,8},
			{1,0,8,3,6,7,9},
			{0,6,-1,4,0,3,9,2},
			{2},
			{2,1}	
	};
	
	@Test
	public void testQuickSortIntArrayIntInt() {
		for (int[] test : tests) {
			System.out.println("Before: " + Arrays.toString(test));
			System.out.println("QSort1 : " + Arrays.toString(SortAlgs.quickSort(test)));
			SortAlgs.quickSort(test, 0, test.length - 1);
			System.out.println("QSort2 : " + Arrays.toString(test));

		}
	}

}
