package com.rim.point;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.rim.util.DBConnector;

public class PointDAO {

	//DB Access
	//접근지정자 [그 외 지정자] 리턴타입 메서드명([매개변수명]){   }
	
	//insert
	public int insert(PointDTO dto) throws Exception{
		int result =0;
		Connection conn = DBConnector.getConnection();
		//1. 4가지 정보
		//2. 드라이버 로딩
		//3. 연결
		//----->여기까지는 DBConnector가 수행하도록함
		
		//4. sql문 작성
		String sql = "insert into Point values (?,?,?,?,?,?,?,?)";
		//5. 미리 보내기
		PreparedStatement pst = conn.prepareStatement(sql);
		//6. ? 셋팅
		pst.setInt(1, dto.getNum());
		pst.setString(2, dto.getSid());
		pst.setInt(3, dto.getKor());
		pst.setInt(4, dto.getEng());
		pst.setInt(5, dto.getMath());
		pst.setInt(6, dto.getTotal());
		pst.setDouble(7, dto.getAvg());
		pst.setInt(8, dto.getBnum());
		//7. 최종 전송 후 결과처리
		result = pst.executeUpdate();
		
		DBConnector.disConnect(pst,conn);
		
		return result;
	}
	
	//delete
	public int delete(int num) throws Exception {
		int result =0; Scanner sc = new Scanner(System.in);
		Connection conn = DBConnector.getConnection();
		
		String sql = "delete point where num = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		
		//System.out.println("삭제할 학생의 번호:");
		//int num = sc.nextInt();
		
		pst.setInt(1, num);
		
		result = pst.executeUpdate();
		DBConnector.disConnect(pst,conn);
		
		return result;
	}
	
	
	//select
	public PointDTO select(int num) throws Exception {
		PointDTO dto = null;
		
		Connection conn = DBConnector.getConnection();
		String sql = "select * from point where num = ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setInt(1, num);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			dto = new PointDTO();
			dto.setNum(rs.getInt(1));
			dto.setSid(rs.getString(2));
			dto.setKor(rs.getInt(3));
			dto.setEng(rs.getInt(4));
			dto.setMath(rs.getInt(5));
			dto.setTotal(rs.getInt(6));
			dto.setAvg(rs.getDouble(7));
			dto.setBnum(rs.getInt(8));
		}
		
		DBConnector.disConnect(pst, conn);
		
		return dto;
	}
	
	public ArrayList<PointDTO> selectList() throws Exception {
		ArrayList<PointDTO> dtoArr = new ArrayList<PointDTO>();
		
		Connection conn = DBConnector.getConnection();
		
		String sql = "select * from point order by num asc";
		PreparedStatement pst = conn.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			PointDTO dto = new PointDTO();
			dto.setNum(rs.getInt(1));
			dto.setSid(rs.getString(2));
			dto.setKor(rs.getInt(3));
			dto.setEng(rs.getInt(4));
			dto.setMath(rs.getInt(5));
			dto.setTotal(rs.getInt(6));
			dto.setAvg(rs.getDouble(7));
			dto.setBnum(rs.getInt(8));
			
			dtoArr.add(dto);
		}
		
		return dtoArr;
		
		
	}
	
	
	
	
	
}
