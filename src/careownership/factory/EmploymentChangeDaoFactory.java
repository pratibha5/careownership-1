/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package careownership.factory;

import java.sql.Connection;
import careownership.dao.*;
import careownership.jdbc.*;

public class EmploymentChangeDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return EmploymentChangeDao
	 */
	public static EmploymentChangeDao create()
	{
		return new EmploymentChangeDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return EmploymentChangeDao
	 */
	public static EmploymentChangeDao create(Connection conn)
	{
		return new EmploymentChangeDaoImpl( conn );
	}

}