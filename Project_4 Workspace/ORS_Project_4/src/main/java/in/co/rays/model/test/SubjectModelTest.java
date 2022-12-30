package in.co.rays.model.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.SubjectModel;

//TODO: Auto-generated Javadoc
/**
* The Class SubjectModelTest.
*/
public class SubjectModelTest {

	/* The model. */
	public static SubjectModel model = new SubjectModel();

	/**
	 * Main method to call test methods.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// testAdd();
		// testDelete();
		// testUpdate();
		// testFindByPK();
		// testFindByName();
		// testSearch();
		testList();

	}

	/**
	 * Tests add a Student.
	 *
	 * @throws ParseException
	 *             the parse exception
	 */
	public static void testAdd() {

		try {
			SubjectBean bean = new SubjectBean();

			// bean.setId(1L);
			bean.setSubjectName("c");
			bean.setDescription("basic computer lang");
			bean.setCourseId(1);
			bean.setCourseName("bca");
			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			System.out.println("add method call");
			long pk = model.add(bean);
			System.out.println("data enter");
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests delete a Student.
	 */
	public static void testDelete() {

		try {
			SubjectBean bean = new SubjectBean();
			long pk = 6L;
			bean.setId(pk);
			model.Delete(bean);
			SubjectBean deletedbean = model.FindByPK(pk);
			System.out.println("Subject deleted");
			if (deletedbean != null) {
				System.out.println("Test Delete fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests update a Student.
	 */
	public static void testUpdate() {

		try {
			SubjectBean bean = model.FindByPK(2L);

			bean.setSubjectName("Java");

			model.update(bean);

			SubjectBean updatedbean = model.FindByPK(2L);
			System.out.println("subject updated");
			/*
			 * if (!"c++".equals(updatedbean.getSubjectName())) {
			 * System.out.println("Test Update fail"); }
			 */
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests find a Student by PK.
	 */
	public static void testFindByPK() {
		try {
			SubjectBean bean = new SubjectBean();
			long pk = 1L;
			bean = model.FindByPK(pk);
			if (bean == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getCourseName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getSubjectName());
			System.out.println(bean.getModifiedBy());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test find by name.
	 * 
	 * @throws ApplicationException
	 */
	public static void testFindByName() throws ApplicationException {

		SubjectBean bean = model.findByName("java");
		if (bean == null) {
			System.out.println("Test Find By name fail");
		}

		System.out.println(bean.getId());
		System.out.println(bean.getCourseId());
		System.out.println(bean.getCourseName());
		System.out.println(bean.getDescription());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getSubjectName());
		System.out.println(bean.getModifiedBy());

	}

	/**
	 * Tests get Search.
	 * @throws DatabaseException 
	 */

	public static void testSearch() throws DatabaseException {

		try {
			SubjectBean bean = new SubjectBean();
			List list = new ArrayList();
			bean.setSubjectName("c++");
			list = model.search(bean, 1, 10);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (SubjectBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getSubjectName());
				System.out.println(bean.getCourseId());
				System.out.println(bean.getCourseName());
				System.out.println(bean.getDescription());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests get List.
	 * @throws Exception 
	 */
	public static void testList() throws Exception {

		try {
			SubjectBean bean = new SubjectBean();
			List list = new ArrayList();
			list = model.list(1, 10);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (SubjectBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getCourseId());
				System.out.println(bean.getCourseName());
				System.out.println(bean.getDescription());
				System.out.println(bean.getSubjectName());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
}