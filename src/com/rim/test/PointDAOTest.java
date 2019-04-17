package com.rim.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.rim.control.PointController;
import com.rim.point.PointDAO;
import com.rim.point.PointDTO;
import com.rim.view.PointView;

public class PointDAOTest {

	//@Test
	public void testInsert() throws Exception {
		PointDAO dao = new PointDAO();
		PointDTO dto = new PointDTO();
		
		int result;
		
		dto.setNum(10);
		dto.setSid("10");
		result = dao.insert(dto);		
		assertEquals(1, result);
	}
	
	//@Test
	public void testDelete() throws Exception{
		PointDAO dao = new PointDAO();
		PointDTO dto = new PointDTO();
		
		int result;
		result = dao.delete(1);
		assertEquals(1, result);
	}
	
	//@Test
	public void testSelect() throws Exception{
		PointDAO dao = new PointDAO();
		PointDTO dto = new PointDTO();
		PointView pv = new PointView();
		
		dto = dao.select(123);
		assertNotNull(dto);
		//pv.view(dto);
	}
	
	//@Test
	public void testSelectList() throws Exception{
		PointDAO dao = new PointDAO();
		PointView pv = new PointView();
		
		ArrayList<PointDTO> arr = dao.selectList();
		
		assertNotEquals(0, arr.size());
		
		//pv.view(arr);
		
		
	}
	
	//@Test
	public void testMain() throws Exception{
		PointController controller = new PointController();
		controller.start();
	}
	
}