package com.rim.view;

import java.util.ArrayList;

import com.rim.point.PointDTO;

public class PointView {

	// 출력 담당
	public void view(PointDTO dto) {
		System.out.println("학생번호:" + dto.getNum());
		System.out.println("sid:" + dto.getSid());
		System.out.println("kor:" + dto.getKor());
		System.out.println("eng:" + dto.getEng());
		System.out.println("math:" + dto.getMath());
		System.out.println("total:" + dto.getTotal());
		System.out.println("avg:" + dto.getAvg());
		System.out.println("bnum:" + dto.getBnum());
		System.out.println();
	}

	public void view(ArrayList<PointDTO> arr) {

		for (PointDTO dto : arr)
			this.view(dto);

	}

	public void view(String str) {
		System.out.println(str);
	}

}
