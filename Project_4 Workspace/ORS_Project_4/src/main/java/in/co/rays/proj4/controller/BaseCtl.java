package in.co.rays.proj4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.ServletUtility;


/**
 * Base controller class of project. It contain (1) Generic operations (2)
 * Generic constants (3) Generic work flow
 * @author Sonali Yadav
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public abstract class BaseCtl extends HttpServlet {
	
	    public static final String OP_SAVE = "Save";
	    public static final String OP_CANCEL = "Cancel";
	    public static final String OP_UPDATE = "Update";
	    public static final String OP_RESET = "Reset";
	    public static final String OP_DELETE = "Delete";
	    public static final String OP_LIST = "List";
	    public static final String OP_SEARCH = "Search";
	    public static final String OP_VIEW = "View";
	    public static final String OP_NEXT = "Next";
	    public static final String OP_PREVIOUS = "Previous";
	    public static final String OP_NEW = "New";
	    public static final String OP_GO = "Go";
	    public static final String OP_BACK = "Back";
	    public static final String OP_LOG_OUT = "Logout";
	    
	    //Success message key constant
	    public static final String MSG_SUCCESS = "success";
	    
	    //Error message key constant
	    public static final String MSG_ERROR = "error";
	    
	    /**
		 * Validates input data entered by User.
		 * @param request the request
		 * @return true, if successful
		 */
		protected boolean validate(HttpServletRequest request) {
			return true;
		}

		/**
		 * Loads list and other data required to display at HTML form.
		 * @param request the request
		 */
		protected void preload(HttpServletRequest request) {
		}

		/**
		 * Populates bean object from request parameters.
		 * @param request the request
		 * @return the base bean
		 */
		protected BaseBean populateBean(HttpServletRequest request) {
			
			return null;
		}

		/**
		 * Populates Generic attributes in DTO.
		 * @param dto the dto
		 * @param request the request
		 * @return  object of the bean
		 */
		protected BaseBean populateDTO(BaseBean dto, HttpServletRequest request) {
			
			System.out.println("BaseCtl method PopulateDTO 1");

			String createdBy = request.getParameter("createdBy");
			String modifiedBy = null;

			UserBean userbean = (UserBean) request.getSession().getAttribute("user");
			if (userbean == null) {
				// If record is created without login
				createdBy = "root";
				modifiedBy = "root";
			} else {
				modifiedBy = userbean.getLogin();
				// If record is created first time
				if ("null".equalsIgnoreCase(createdBy) || DataValidator.isNull(createdBy)) {
					createdBy = modifiedBy;
				}
			}
			dto.setCreatedBy(createdBy);
			dto.setModifiedBy(modifiedBy);

			long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));
			if (cdt > 0) {
				dto.setCreatedDatetime(DataUtility.getTimestamp(cdt));
			} else {
				dto.setCreatedDatetime(DataUtility.getCurrentTimestamp());
			}
			dto.setModifiedDatetime(DataUtility.getCurrentTimestamp());
			
			System.out.println("BaseCtl method PopulateDTO 2");
			
			return dto;
			
		}


		/**
		 * Call the service method of this Controller.
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			
            preload(request);
			
			String op = DataUtility.getString(request.getParameter("operation"));
			
			// Check if operation is not DELETE, VIEW, CANCEL, and NULL then
		     if (DataValidator.isNotNull(op) && !OP_CANCEL.equalsIgnoreCase(op) && !OP_VIEW.equalsIgnoreCase(op)
					&& !OP_DELETE.equalsIgnoreCase(op) && !OP_RESET.equalsIgnoreCase(op)) { 
				
				if (!validate(request)) {
					
					BaseBean bean = (BaseBean) populateBean(request);
				
					ServletUtility.setBean(bean, request);
					ServletUtility.forward(getView(), request, response);
					return;
				}
			}	
			
			super.service(request, response);

		}

		/**
		 * Returns the VIEW page of this Controller.
		 * @return the view
		 */
		
		protected abstract String getView();

	}