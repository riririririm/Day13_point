package com.rim.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.rim.input.PointInput;
import com.rim.point.PointDAO;
import com.rim.point.PointDTO;
import com.rim.view.PointView;

public class PointController {
	private Scanner sc;
	private PointInput input;
	private PointDTO dto;
	private PointDAO dao;
	private PointView pv;

	public PointController() {
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		input = new PointInput();
		dao = new PointDAO();
		pv = new PointView();
	}

	public void start() throws Exception {

		int num = 0;
		int result = 0;
		while (true) {
			System.out.println("1.정보추가 / 2.정보 삭제 / 3.번호 조회 / 4.전체 조회 / 5.종료");
			int select = sc.nextInt();

			if (select == 1) {
				dto = input.setPoint();
				result = dao.insert(dto);
				if (result > 0)
					pv.view("정보 추가 완료");
				else
					pv.view("정보 추가 실패");

			} else if (select == 2) {
				num = input.setNum("삭제");
				result = dao.delete(num);
				if (result > 0)
					pv.view("삭제 완료");
				else
					pv.view("삭제 실패");

			} else if (select == 3) {
				num = input.setNum("조회");
				dto = dao.select(num);
				if(dto!=null)
					pv.view(dto);
				else
					pv.view("없는 번호");

			} else if (select == 4) {
				ArrayList<PointDTO> arr = new ArrayList<PointDTO>();
				arr = dao.selectList();
				pv.view(arr);

			} else if (select == 5) {
				pv.view("프로그램 종료");
				break;
			} else
				System.out.println("1~5번중에 고르세요.");
		}//end of while
	}

}
