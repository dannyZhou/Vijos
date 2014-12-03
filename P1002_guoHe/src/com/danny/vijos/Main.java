package com.danny.vijos;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		/**
		 * 数量
		 */
		int n = 0;

		// begin and end span
		int beginSpan = 0;
		int endSpan = 0;

		int tmpNumber = 0;

		// 这里 的 0 是用来添加最新的, 这里的 12 是 没有用, 为了防止 溢出
		int process[] = { Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE };

		// 临时 变量存储地
		String[] tmpStoneLocate;

		// 真实 存储
		int[] stoneLocate = new int[102];

		// 石头 数量 更改数量
		int stoneNums = 0;

		// flag
		boolean flag = true;

		// scanner
		Scanner scanner = new Scanner(System.in);
		String tmplineString = scanner.nextLine().split(" ")[0];

		// convert string to long
		n = Integer.parseInt(tmplineString);

		tmplineString = scanner.nextLine();
		String[] tmpStrings = tmplineString.split(" ");

		beginSpan = Integer.parseInt(tmpStrings[0]);
		endSpan = Integer.parseInt(tmpStrings[1]);
		tmpNumber = Integer.parseInt(tmpStrings[2]);

		tmplineString = scanner.nextLine();

		tmpStoneLocate = tmplineString.split(" ");

		for (int i = 0; i < tmpStoneLocate.length; i++) {
			stoneLocate[i] = Integer.parseInt(tmpStoneLocate[i]);
		}
		Arrays.sort(stoneLocate, 0, tmpStoneLocate.length);

		for (int i = endSpan - beginSpan + 1; i >= 1; i--) {

			// 看看当前 有没有石头
			if (stoneLocate[stoneNums] == endSpan + 1 - i) {
				process[i] = 1;
				stoneNums++;
				if (stoneNums == tmpNumber) {
					flag = false;
				}
			} else {
				process[i] = 0;
			}

		}
		// 固定 i
		int tmpLimit = 0;
		
		int i = endSpan + 1;
		while (i <= n + 10) {

			if (flag) {

				// 看看当前 有没有石头
				if (stoneLocate[stoneNums] == i) {
					process[0] = 1;
					stoneNums++;
					if (stoneNums == tmpNumber) {
						flag = false;
					}
				} else {
					process[0] = 0;
				}

			} else {
				process[0] = 0;
			}

			int tmpInt = Integer.MAX_VALUE;

			// 取最小 区间内
			for (int j = beginSpan; j <= endSpan; j++) {
				if (tmpInt > process[j]) {
					tmpInt = process[j];
				}
			}

			if (tmpInt == Integer.MAX_VALUE) {

				process[0] = Integer.MAX_VALUE;

			} else {

				process[0] += tmpInt;

			}
			// 所有元素后移一位
			for (int j = 10; j >= 0; j--) {
				process[j + 1] = process[j];
			}
			process[0] = 0;

			// 计算 这个石子 和下一个石子的 距离
//
//			if (stoneNums != 0
//					&& stoneLocate[stoneNums] - stoneLocate[stoneNums - 1] > 2520) {
//				i = i + 2520;
//				 stoneLocate[stoneNums - 1] +=2520;
//			}
			int tmp;
			if (stoneNums !=0 && ( stoneLocate[stoneNums] - i )>2520 ) {
				i = i+ 2520;
			}
			i++;
		}
		tmpNumber = Integer.MAX_VALUE;
		for (i = 1; i <= endSpan; i++) {
			if (process[i] < tmpNumber && process[i] != 0) {
				tmpNumber = process[i];
			}
		}

		System.out.println(tmpNumber);
	}
}
