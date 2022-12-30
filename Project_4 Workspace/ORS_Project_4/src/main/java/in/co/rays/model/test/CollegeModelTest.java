package in.co.rays.model.test;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.exception.ApplicationException;

import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.CollegeModel;

/**
 * College Model Test classes
 *
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 *
 */
public class CollegeModelTest {
	/**
     * Model object to test
     */
	public static CollegeModel model = new CollegeModel();
	//public static CollegeBean bean = new CollegeBean();
	 /**
     * Main method to call test methods.
     *
     * @param args
     * @throws DuplicateRecordException
     */
	public static void main(String[] args)throws DuplicateRecordException, Exception {
		
		//testAdd();
		//testDelete();
		//testUpdate();
		//testFindByName();
		//testFindByPK();
		testSearch();
		//testList();
	} 
	/**
     * Tests add a College
    * @throws DuplicateRecordException
    */
    public static void testAdd()throws DuplicateRecordException {
		
		try {
			CollegeBean bean= new CollegeBean();
			bean.setId(2L);
			bean.setName("BARKATULLA");
			bean.setAddress("BHOPAL");
			bean.setState("MP");
			bean.setCity("Bhopal");
			bean.setPhoneNo("9938943437");
			bean.setCreatedBy("MP GOVT");
			bean.setModifiedBy("MP GOVT");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			
			long pk = model.add(bean);
			System.out.println("Added new College in DB");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
  //--------------------***********************-----------------------************--------------------//
  //--------------------***********************-----------------------************--------------------//
    /**
     * Tests delete a College
     */
    public static void testDelete() {
          
	    try {
	    	CollegeBean bean = new CollegeBean();
	    	long pk = 1L;
	    	bean.setId(pk);
	    	model.delete(bean);
	    	System.out.println("Test Delete successful");
	    	CollegeBean deletedBean = model.findByPK(pk);
	    	if(deletedBean!=null) {
	    		System.out.println("Test Delete fail");
	    	}
	    }catch (ApplicationException e) {
	    	e.printStackTrace();
		}
	}
  //--------------------***********************-----------------------************--------------------//
  //--------------------***********************-----------------------************--------------------//
    /**
     * Tests update a College
     */
    public static void testUpdate() {
		try {
			
			CollegeBean bean = new CollegeBean();
			//System.out.println(bean.getName());
			bean.setId(2);
			bean.setName("VIKRAM");
			bean.setAddress("UJJAIN");
			bean.setState("MP");
			bean.setCity("Indore");
			bean.setPhoneNo("0908977665");
		    bean.setCreatedBy("MP_GOVT");
		    bean.setModifiedBy("MP_GOVT");
			bean.setCreatedDatetime(null);
			bean.setModifiedDatetime(null);
			
			model.update(bean);
			
			System.out.println("Test Update successfull");
			
			//CollegeBean updateBean = model.findByPK(2L);
			
			/*
			 * if(!"HOLKARSCIENCE".equals(updateBean.getName())) {
			 * System.out.println("Test Update fail"); }
			 */
		}catch (ApplicationException e) {
			e.printStackTrace();
		}catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}
  //--------------------***********************-----------------------************--------------------//
  //--------------------***********************-----------------------************--------------------//
    /**
     * Tests find a College by Name.
     */
    public static void testFindByName() {
       try {
    	   CollegeBean bean = model.findByName("HSGV");
    	   if(bean ==null) {
    		   System.out.println("Test Find By Name fail");
    	   }
    	   System.out.println("ID= "+bean.getId());
    	   System.out.println("NAME= "+bean.getName());
    	   System.out.println("ADDRESS= "+bean.getAddress());
    	   System.out.println("STATE= "+bean.getState());
    	   System.out.println("CITY= "+bean.getCity());
    	   System.out.println("PHONE_NO= "+bean.getPhoneNo());
    	   System.out.println("CREATED_BY= "+bean.getCreatedBy());
    	   System.out.println("Created_Date= "+bean.getCreatedDatetime());
    	   System.out.println("Modified_By= "+bean.getModifiedBy());
    	   System.out.print("Modified_Date= "+bean.getModifiedDatetime());
       }catch (ApplicationException e) {
		e.printStackTrace();
	}
	}
  //--------------------***********************-----------------------************--------------------//
  //--------------------***********************-----------------------************--------------------//
    /**
     * Tests find a College by PK.
     */

	public static void testFindByPK() {
		
	  
	 // long pk = 2L;
	  CollegeBean bean= model.findByPK(4);
	  if(bean==null) {
		  System.out.println("Test FInd BY PK fail");
	  }
	  System.out.println("ID="+bean.getId());
	  System.out.println("NAME= "+bean.getName());
	  System.out.println("ADD= "+bean.getAddress());
	  System.out.println("STATE= "+bean.getState());
	  System.out.println("CITY= "+bean.getCity());
	  System.out.println("PHONE_NO= "+bean.getPhoneNo());
	  System.out.println("CREATED_BY= "+bean.getCreatedBy());
	  System.out.println("Created_Date= "+bean.getCreatedDatetime());
	  System.out.println("Modified_By= "+bean.getModifiedBy());
	  System.out.println("Modified_Date= "+bean.getModifiedDatetime());
	}
	//--------------------***********************-----------------------************--------------------//
	//--------------------***********************-----------------------************--------------------//
	/**
     * Tests search a College by Name
     */
	public static void testSearch() {
         try {
        	 CollegeBean bean= new CollegeBean();
        	 List list =new ArrayList();
        	
            list = model.search(bean,0,0);
            if(list.size()<0) {
            	System.out.println("Test Search fail");
            }
            Iterator it = list.iterator();
            while(it.hasNext()) {
            	bean = (CollegeBean)it.next();
            	
            	System.out.print("ID="+bean.getId()+" , ");
            	System.out.print("NAME= "+bean.getName()+" , ");
            	System.out.print("ADD= "+bean.getAddress()+" , ");
            	System.out.print("STATE= "+bean.getState()+" , ");
            	System.out.print("CITY= "+bean.getCity()+" , ");
            	System.out.print("PHONE_NO= "+bean.getPhoneNo()+" , ");
            	System.out.print("CREATED_BY= "+bean.getCreatedBy()+" , ");
            	System.out.print("Created_Date= "+bean.getCreatedDatetime()+" , ");
            	System.out.print("Modified_By= "+bean.getModifiedBy()+" , ");
            	System.out.println("Modified_Date= "+bean.getModifiedDatetime());
            }
         }catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//--------------------***********************-----------------------************--------------------//
	//--------------------***********************-----------------------************--------------------//
	   /**
     * Tests get List a College.
     */
	public static void testList() {
			try {
				List list = new ArrayList();
				CollegeBean bean= new CollegeBean();
				list = model.list(1,10);
				if(list.size()<0) {
					System.out.println("Test list fail");
				}
				Iterator it = list.iterator();
				while(it.hasNext()) {
					bean = (CollegeBean)it.next();
					
					System.out.print("ID="+bean.getId()+" , ");
					System.out.print("NAME= "+bean.getName()+" , ");
					System.out.print("ADD= "+bean.getAddress()+" , ");
					System.out.print("STATE= "+bean.getState()+" , ");
					System.out.print("CITY= "+bean.getCity()+" , ");
					System.out.print("PHONE_NO= "+bean.getPhoneNo()+" , ");
					System.out.print("CREATED_BY= "+bean.getCreatedBy()+" , ");
					System.out.print("Created_Date= "+bean.getCreatedDatetime()+" , ");
					System.out.print("Modified_By= "+bean.getModifiedBy()+" , ");
					System.out.println("Modified_Date= "+bean.getModifiedDatetime());
				}
			}catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
	}
