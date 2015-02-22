/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package careownership.jdbc;

import careownership.dao.*;
import careownership.factory.*;
import careownership.dto.*;
import careownership.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class InitialDebtDaoImpl extends AbstractDAO implements InitialDebtDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT initial_debt_id, initial_debt_total, initial_debt_type, initial_debt_amount, initial_debt_description, mentee_id FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( initial_debt_id, initial_debt_total, initial_debt_type, initial_debt_amount, initial_debt_description, mentee_id ) VALUES ( ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET initial_debt_id = ?, initial_debt_total = ?, initial_debt_type = ?, initial_debt_amount = ?, initial_debt_description = ?, mentee_id = ? WHERE initial_debt_id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE initial_debt_id = ?";

	/** 
	 * Index of column initial_debt_id
	 */
	protected static final int COLUMN_INITIAL_DEBT_ID = 1;

	/** 
	 * Index of column initial_debt_total
	 */
	protected static final int COLUMN_INITIAL_DEBT_TOTAL = 2;

	/** 
	 * Index of column initial_debt_type
	 */
	protected static final int COLUMN_INITIAL_DEBT_TYPE = 3;

	/** 
	 * Index of column initial_debt_amount
	 */
	protected static final int COLUMN_INITIAL_DEBT_AMOUNT = 4;

	/** 
	 * Index of column initial_debt_description
	 */
	protected static final int COLUMN_INITIAL_DEBT_DESCRIPTION = 5;

	/** 
	 * Index of column mentee_id
	 */
	protected static final int COLUMN_MENTEE_ID = 6;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 6;

	/** 
	 * Index of primary-key column initial_debt_id
	 */
	protected static final int PK_COLUMN_INITIAL_DEBT_ID = 1;

	/** 
	 * Inserts a new row in the initial_debt table.
	 */
	public InitialDebtPk insert(InitialDebt dto) throws InitialDebtDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			int index = 1;
			stmt.setInt( index++, dto.getInitialDebtId() );
			if (dto.isInitialDebtTotalNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getInitialDebtTotal() );
			}
		
			stmt.setString( index++, dto.getInitialDebtType() );
			if (dto.isInitialDebtAmountNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getInitialDebtAmount() );
			}
		
			stmt.setString( index++, dto.getInitialDebtDescription() );
			stmt.setInt( index++, dto.getMenteeId() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setInitialDebtId( rs.getInt( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new InitialDebtDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the initial_debt table.
	 */
	public void update(InitialDebtPk pk, InitialDebt dto) throws InitialDebtDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setInt( index++, dto.getInitialDebtId() );
			if (dto.isInitialDebtTotalNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getInitialDebtTotal() );
			}
		
			stmt.setString( index++, dto.getInitialDebtType() );
			if (dto.isInitialDebtAmountNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getInitialDebtAmount() );
			}
		
			stmt.setString( index++, dto.getInitialDebtDescription() );
			stmt.setInt( index++, dto.getMenteeId() );
			stmt.setInt( 7, pk.getInitialDebtId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new InitialDebtDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the initial_debt table.
	 */
	public void delete(InitialDebtPk pk) throws InitialDebtDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setInt( 1, pk.getInitialDebtId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new InitialDebtDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the initial_debt table that matches the specified primary-key value.
	 */
	public InitialDebt findByPrimaryKey(InitialDebtPk pk) throws InitialDebtDaoException
	{
		return findByPrimaryKey( pk.getInitialDebtId() );
	}

	/** 
	 * Returns all rows from the initial_debt table that match the criteria 'initial_debt_id = :initialDebtId'.
	 */
	public InitialDebt findByPrimaryKey(int initialDebtId) throws InitialDebtDaoException
	{
		InitialDebt ret[] = findByDynamicSelect( SQL_SELECT + " WHERE initial_debt_id = ?", new Object[] {  new Integer(initialDebtId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the initial_debt table that match the criteria ''.
	 */
	public InitialDebt[] findAll() throws InitialDebtDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY initial_debt_id", null );
	}

	/** 
	 * Returns all rows from the initial_debt table that match the criteria 'mentee_id = :menteeId'.
	 */
	public InitialDebt[] findByMentees(int menteeId) throws InitialDebtDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mentee_id = ?", new Object[] {  new Integer(menteeId) } );
	}

	/** 
	 * Returns all rows from the initial_debt table that match the criteria 'initial_debt_id = :initialDebtId'.
	 */
	public InitialDebt[] findWhereInitialDebtIdEquals(int initialDebtId) throws InitialDebtDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE initial_debt_id = ? ORDER BY initial_debt_id", new Object[] {  new Integer(initialDebtId) } );
	}

	/** 
	 * Returns all rows from the initial_debt table that match the criteria 'initial_debt_total = :initialDebtTotal'.
	 */
	public InitialDebt[] findWhereInitialDebtTotalEquals(int initialDebtTotal) throws InitialDebtDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE initial_debt_total = ? ORDER BY initial_debt_total", new Object[] {  new Integer(initialDebtTotal) } );
	}

	/** 
	 * Returns all rows from the initial_debt table that match the criteria 'initial_debt_type = :initialDebtType'.
	 */
	public InitialDebt[] findWhereInitialDebtTypeEquals(String initialDebtType) throws InitialDebtDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE initial_debt_type = ? ORDER BY initial_debt_type", new Object[] { initialDebtType } );
	}

	/** 
	 * Returns all rows from the initial_debt table that match the criteria 'initial_debt_amount = :initialDebtAmount'.
	 */
	public InitialDebt[] findWhereInitialDebtAmountEquals(int initialDebtAmount) throws InitialDebtDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE initial_debt_amount = ? ORDER BY initial_debt_amount", new Object[] {  new Integer(initialDebtAmount) } );
	}

	/** 
	 * Returns all rows from the initial_debt table that match the criteria 'initial_debt_description = :initialDebtDescription'.
	 */
	public InitialDebt[] findWhereInitialDebtDescriptionEquals(String initialDebtDescription) throws InitialDebtDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE initial_debt_description = ? ORDER BY initial_debt_description", new Object[] { initialDebtDescription } );
	}

	/** 
	 * Returns all rows from the initial_debt table that match the criteria 'mentee_id = :menteeId'.
	 */
	public InitialDebt[] findWhereMenteeIdEquals(int menteeId) throws InitialDebtDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mentee_id = ? ORDER BY mentee_id", new Object[] {  new Integer(menteeId) } );
	}

	/**
	 * Method 'InitialDebtDaoImpl'
	 * 
	 */
	public InitialDebtDaoImpl()
	{
	}

	/**
	 * Method 'InitialDebtDaoImpl'
	 * 
	 * @param userConn
	 */
	public InitialDebtDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "initial_debt";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected InitialDebt fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			InitialDebt dto = new InitialDebt();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected InitialDebt[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			InitialDebt dto = new InitialDebt();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		InitialDebt ret[] = new InitialDebt[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(InitialDebt dto, ResultSet rs) throws SQLException
	{
		dto.setInitialDebtId( rs.getInt( COLUMN_INITIAL_DEBT_ID ) );
		dto.setInitialDebtTotal( rs.getInt( COLUMN_INITIAL_DEBT_TOTAL ) );
		if (rs.wasNull()) {
			dto.setInitialDebtTotalNull( true );
		}
		
		dto.setInitialDebtType( rs.getString( COLUMN_INITIAL_DEBT_TYPE ) );
		dto.setInitialDebtAmount( rs.getInt( COLUMN_INITIAL_DEBT_AMOUNT ) );
		if (rs.wasNull()) {
			dto.setInitialDebtAmountNull( true );
		}
		
		dto.setInitialDebtDescription( rs.getString( COLUMN_INITIAL_DEBT_DESCRIPTION ) );
		dto.setMenteeId( rs.getInt( COLUMN_MENTEE_ID ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(InitialDebt dto)
	{
	}

	/** 
	 * Returns all rows from the initial_debt table that match the specified arbitrary SQL statement
	 */
	public InitialDebt[] findByDynamicSelect(String sql, Object[] sqlParams) throws InitialDebtDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new InitialDebtDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the initial_debt table that match the specified arbitrary SQL statement
	 */
	public InitialDebt[] findByDynamicWhere(String sql, Object[] sqlParams) throws InitialDebtDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new InitialDebtDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}