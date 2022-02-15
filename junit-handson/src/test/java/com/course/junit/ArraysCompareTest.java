package com.course.junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	@Test
	public void test() {
		
		int[] numbers = {12,3,4,1};
		int[] expected = {1,3,4,12};
		Arrays.sort(numbers);
		System.out.println("expected - "+Arrays.toString(expected));
		System.out.println("sorted numbers - "+Arrays.toString(numbers));
		assertArrayEquals(expected, numbers);
	}
	
	@Test(timeout=1)
	public void testSortPerformance() {
		int arr[] = {12,23,4};
		for(int i=1;i<.1000000;i++) {
			arr[0]=i;
			Arrays.sort(arr);
		}
	}

}
