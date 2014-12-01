package com.danny.vijos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// 总共学生总数
		int n = 0;

		Scanner scanner = new Scanner(System.in);

		String name = "";
		// 总奖学金
		int moneyNums = 0;
		// 最高奖学金
		int maxNums = 0;

		// 读入 总数
		n = scanner.nextInt();

		scanner.nextLine();

		for (int i = 0; i < n; i++) {
			
			String tmpLine = scanner.nextLine();
			Object[] objects = tmpLine.split(" ");

			int tmpMoney = 0;

			// 强制类型转换 将所有的信息 提取处来
			int finalScore = Integer.parseInt((String) objects[1]);

			int classScore = Integer.parseInt((String) objects[2]);

			boolean tou = false;
			if (((String) objects[3]).equals("Y")) {
				tou = true;
			} else {
				tou = false;
			}

			boolean west = false;

			if (((String) objects[4]).equals("Y")) {
				west = true;
			} else {
				west = false;
			}

			int portery = Integer.parseInt((String) objects[5]);
			// 下面进行计算
			if (finalScore > 80 && portery >= 1) {
				tmpMoney += 8000;
			}

			if (finalScore > 85 && classScore > 80) {
				tmpMoney += 4000;
			}
			if (finalScore > 90) {
				tmpMoney += 2000;
			}
			if (finalScore > 85 && west) {
				tmpMoney += 1000;
			}
			if (classScore > 80 && tou) {
				tmpMoney += 850;
			}

			if (tmpMoney > maxNums) {
				maxNums = tmpMoney;
				name = (String) objects[0];
			}
			moneyNums += tmpMoney;
		}

		System.out.println(name);
		System.out.println(maxNums);
		System.out.println(moneyNums);
	}
}
