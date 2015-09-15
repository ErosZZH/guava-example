package com.rick.guava_example.math;

import java.math.RoundingMode;

import com.google.common.math.DoubleMath;
import com.google.common.math.IntMath;

public class MathTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		try {
//			IntMath.checkedAdd(Integer.MAX_VALUE, Integer.MAX_VALUE);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		int res = IntMath.checkedAdd(1, 2);
		System.out.println(res);
		
		int res1 = DoubleMath.roundToInt(3.14, RoundingMode.FLOOR);
		System.out.println(res1);
		
		int[] i = {1, 3, 10};
		System.out.println(DoubleMath.mean(i));
	}

}
