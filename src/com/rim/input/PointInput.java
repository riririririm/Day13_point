package com.rim.input;

import java.util.Scanner;

import com.rim.point.PointDTO;

public class PointInput {

	// 입력 담당
	public PointDTO setPoint() {
		Scanner sc = new Scanner(System.in);
		PointDTO dto = new PointDTO();

		System.out.println("학생번호:");
		dto.setNum(sc.nextInt());
		System.out.println("sid:");
		dto.setSid(sc.next());
		System.out.println("kor:");
		dto.setKor(sc.nextInt());
		System.out.println("eng:");
		dto.setEng(sc.nextInt());
		System.out.println("math:");
		dto.setMath(sc.nextInt());

		dto.setTotal(dto.getKor() + dto.getEng() + dto.getMath());
		dto.setAvg(dto.getTotal() / 3.0);

		System.out.println("반번호:");
		dto.setBnum(sc.nextInt());

		return dto;
	}

	public int setNum(String str) {
		int num = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println(str + "할 번호:");
		num = sc.nextInt();

		return num;
	}
}
