package in.co.rays.model.test;
/**
 * Student Model Test classes
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.StudentModel;

public class StudentModelTest {
	
	//Model object to  test
	public static StudentModel model = new StudentModel();
	 /**
     * Main method to call test methods.
     * @param args
     * @throws ParseException
     */
	public static void main(String[] args) throws Exception {
		testAdd();
		//testDelete();
		//testUpdate();
		//testFindByPK();
		//testFindByEmailId();
		//testSearch();
		//testlist();
		/*
		 * int i=model.nextPK(); System.out.println(i);
		 */
	}
	/**
     * Tests add a Student
     * @throws ParseException
     */
	public static void testAdd() throws ParseException {
		try {
			StudentBean bean = new StudentBean();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			//bean.setId(1);
			bean.setFirstName("Sonali");
			bean.setLastName("Yadav");
			bean.setDob(sdf.parse("8/7/1997"));
			bean.setMobileNo("8678532777");
			bean.setEmail("Sonali@gmail.com");
			bean.setCollegeId(5L);
			bean.setCreatedBy("Sonali");
			bean.setModifiedBy("Sonali");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long pk= model.add(bean);
			 System.out.println(pk+"Added");
			/*
			 * StudentBean addBean = model.findByPK(1); if(addBean==null) {
			 * System.out.println("Test add fail"); }
			 */
		}catch (ApplicationException e) {
			e.printStackTrace();
		} 
	}
	//Test Delete a Student
	 public static void testDelete() {
			
		 try {
			 StudentBean bean = new StudentBean();
			 long pk = 2L;
			 bean.setId(pk);
			 model.delete(bean);
			 System.out.println("Record Deleted");
			
		 }catch (ApplicationException e) {
			e.printStackTrace();
		}
		}
	 //test update a Student

		public static void testUpdate() {
			try {
				StudentBean bean = model.findByPK(2);
				
				bean.setCollegeId(4L);
				//bean.setFirstName("Aisa");
				//bean.setLastName("Jha");
				try {
					model.update(bean);
				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Record Updated");
				
			}catch (ApplicationException e) {
				e.printStackTrace();
			
			}
		}
		//test find a student by PK
         public static void testFindByPK() {
			try {
				StudentBean bean = new StudentBean();
				long pk = 3L;
				bean = model.findByPK(pk);
				if(bean==null) {
					System.out.println("test find by pk fail");
				}
				System.out.println("ID= "+bean.getId());
				System.out.println("Fname= "+bean.getFirstName());
				System.out.println("Lname= "+bean.getLastName());
				System.out.println("Date of birth= "+bean.getDob());
				System.out.println("MobileNo= "+bean.getMobileNo());
				System.out.println("Email= "+bean.getEmail());
				System.out.println("Clg Id= "+bean.getCollegeId());
			}catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
		//test find a student by email id
     	public static void testFindByEmailId() {
    		try {
    			StudentBean bean = new StudentBean();
    			bean = model.findByEmailId("VM@gmail.com");
    			if(bean!=null) {
    				System.out.println("Test find by email id fail");
    			}
    			System.out.println("ID= "+bean.getId());
    			System.out.println("Fname= "+bean.getFirstName());
    			System.out.println("Lname= "+bean.getLastName());
    			System.out.println("Date of birth= "+bean.getDob());
    			System.out.println("MobileNo= "+bean.getMobileNo());
    			System.out.println("Email= "+bean.getEmail());
    			System.out.println("Clg Id= "+bean.getCollegeId());
    		}catch (ApplicationException e) {
				e.printStackTrace();
			}
       	}
     	//test get search
    	public static void testSearch() {
    		try {
    			StudentBean bean = new StudentBean();
    			List list = new ArrayList();
    			bean.setFirstName("Manav");
    			list = model.search(bean, 0, 0);
    			if(list.size()<0) {
    				System.out.println("Test search fail");
    			}
    			Iterator it = list.iterator();
    			while(it.hasNext()) {
    				bean = (StudentBean)it.next();
    				System.out.println("ID= "+bean.getId());
    				System.out.println("Fname= "+bean.getFirstName());
    				System.out.println("Lname= "+bean.getLastName());
    				System.out.println("Date of birth= "+bean.getDob());
    				System.out.println("MobileNo= "+bean.getMobileNo());
    				System.out.println("Email= "+bean.getEmail());
    				System.out.println("Clg Id= "+bean.getCollegeId());
    			}
    		}catch (ApplicationException e) {
				e.printStackTrace();
			}
    	}
    	//test get list
    	public static void testlist() {
            try {
            	StudentBean bean = new StudentBean();
            	List list = new ArrayList();
            	list = model.list(1, 0);
            	if(list.size()<0) {
            		System.out.println("Test list fail");
            	}
            	Iterator it = list.iterator();
            	while(it.hasNext()) {
            		bean = (StudentBean)it.next();
            		
            		System.out.println("ID= "+bean.getId());
            		System.out.println("Fname= "+bean.getFirstName());
            		System.out.println("Lname= "+bean.getLastName());
            		System.out.println("Date of birth= "+bean.getDob());
            		System.out.println("MobileNo= "+bean.getMobileNo());
            		System.out.println("Email= "+bean.getEmail());
            		System.out.println("Clg Id= "+bean.getCollegeId());
            	}
            }catch (ApplicationException e) {
				e.printStackTrace();
			}
    		
    	}
}
