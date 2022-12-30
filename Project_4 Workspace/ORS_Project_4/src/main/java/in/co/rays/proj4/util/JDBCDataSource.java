package in.co.rays.proj4.util;

import in.co.rays.proj4.exception.ApplicationException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*JDBC DataSource is a Data Connection Pool
@author Sonali
@version 1.0
@copyright(c) Sonali*/

public final class JDBCDataSource {

	// JDBC DataBase connection Pool
	// JDBC Datasource static object

	private static JDBCDataSource datasource;

	private JDBCDataSource() {
	}

	// C3P0 database connection pool
	private ComboPooledDataSource cpds = null;

	// Create instance of Connection Pool
	// @return

	public static JDBCDataSource getInstance() {

		if (datasource == null) {

			ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.system");

			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();

			try {

				datasource.cpds.setDriverClass(rb.getString("driver"));
				datasource.cpds.setJdbcUrl(rb.getString("url"));
				datasource.cpds.setUser(rb.getString("username"));
				datasource.cpds.setPassword(rb.getString("password"));

				datasource.cpds.setInitialPoolSize(new Integer((String) rb.getString("initialPoolSize")));
				datasource.cpds.setAcquireIncrement(new Integer((String) rb.getString("acquireIncrement")));
				datasource.cpds.setMaxPoolSize(new Integer((String) rb.getString("maxPoolSize")));
				datasource.cpds.setMaxIdleTime(DataUtility.getInt(rb.getString("timeout")));
				datasource.cpds.setMinPoolSize(new Integer((String) rb.getString("minPoolSize")));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return datasource;
	}

	// Gets the connection from ComboPooledDataSource
	// @return connection
	public static Connection getConnection() throws Exception {
		return getInstance().cpds.getConnection();
	}

	/*
	 * Closes a connection
	 * 
	 * @param connection
	 * 
	 * @throws Exception
	 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {

			}
		}

	}

	public static void trnRollback(Connection connection) throws ApplicationException {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException ex) {
				throw new ApplicationException(ex.toString());
			}
		}
	}

}
