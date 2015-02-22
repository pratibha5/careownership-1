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
import java.util.Date;
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

public class FormsDaoImpl extends AbstractDAO implements FormsDao
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
	protected final String SQL_SELECT = "SELECT form_id, mentor_id, mentee_id, meeting_time, meeting_place, meeting_notes, next_meeting_goals, topic_covered, topic_covered_other FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( form_id, mentor_id, mentee_id, meeting_time, meeting_place, meeting_notes, next_meeting_goals, topic_covered, topic_covered_other ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET form_id = ?, mentor_id = ?, mentee_id = ?, meeting_time = ?, meeting_place = ?, meeting_notes = ?, next_meeting_goals = ?, topic_covered = ?, topic_covered_other = ? WHERE form_id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE form_id = ?";

	
	
	
	/** 
	 * Index of column form_id
	 */
	protected static final int COLUMN_FORM_ID = 1;

	/** 
	 * Index of column mentor_id
	 */
	protected static final int COLUMN_MENTOR_ID = 2;

	/** 
	 * Index of column mentee_id
	 */
	protected static final int COLUMN_MENTEE_ID = 3;

	/** 
	 * Index of column meeting_time
	 */
	protected static final int COLUMN_MEETING_TIME = 4;

	/** 
	 * Index of column meeting_place
	 */
	protected static final int COLUMN_MEETING_PLACE = 5;

	/** 
	 * Index of column meeting_notes
	 */
	protected static final int COLUMN_MEETING_NOTES = 6;

	/** 
	 * Index of column next_meeting_goals
	 */
	protected static final int COLUMN_NEXT_MEETING_GOALS = 7;

	/** 
	 * Index of column topic_covered
	 */
	protected static final int COLUMN_TOPIC_COVERED = 8;

	/** 
	 * Index of column topic_covered_other
	 */
	protected static final int COLUMN_TOPIC_COVERED_OTHER = 9;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 9;

	/** 
	 * Index of primary-key column form_id
	 */
	protected static final int PK_COLUMN_FORM_ID = 1;

	/** 
	 * Inserts a new row in the forms table.
	 */
	public FormsPk insert(Forms dto) throws FormsDaoException
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
			stmt.setInt( index++, dto.getFormId() );
			stmt.setInt( index++, dto.getMentorId() );
			stmt.setInt( index++, dto.getMenteeId() );
			stmt.setTimestamp(index++, dto.getMeetingTime()==null ? null : new java.sql.Timestamp( dto.getMeetingTime().getTime() ) );
			stmt.setString( index++, dto.getMeetingPlace() );
			stmt.setString( index++, dto.getMeetingNotes() );
			stmt.setString( index++, dto.getNextMeetingGoals() );
			stmt.setString( index++, dto.getTopicCovered() );
			stmt.setString( index++, dto.getTopicCoveredOther() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setFormId( rs.getInt( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new FormsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the forms table.
	 */
	public void update(FormsPk pk, Forms dto) throws FormsDaoException
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
			stmt.setInt( index++, dto.getFormId() );
			stmt.setInt( index++, dto.getMentorId() );
			stmt.setInt( index++, dto.getMenteeId() );
			stmt.setTimestamp(index++, dto.getMeetingTime()==null ? null : new java.sql.Timestamp( dto.getMeetingTime().getTime() ) );
			stmt.setString( index++, dto.getMeetingPlace() );
			stmt.setString( index++, dto.getMeetingNotes() );
			stmt.setString( index++, dto.getNextMeetingGoals() );
			stmt.setString( index++, dto.getTopicCovered() );
			stmt.setString( index++, dto.getTopicCoveredOther() );
			stmt.setInt( 10, pk.getFormId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new FormsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the forms table.
	 */
	public void delete(FormsPk pk) throws FormsDaoException
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
			stmt.setInt( 1, pk.getFormId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new FormsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the forms table that matches the specified primary-key value.
	 */
	public Forms findByPrimaryKey(FormsPk pk) throws FormsDaoException
	{
		return findByPrimaryKey( pk.getFormId() );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'form_id = :formId'.
	 */
	public Forms findByPrimaryKey(int formId) throws FormsDaoException
	{
		Forms ret[] = findByDynamicSelect( SQL_SELECT + " WHERE form_id = ?", new Object[] {  new Integer(formId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'mentor_id = :mentorId AND mentee_id = :menteeId'.
	 */
	public Forms[] findByMentorMentee(int mentorId, int menteeId) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mentor_id = ? AND mentee_id = ?", new Object[] {  new Integer(mentorId),  new Integer(menteeId) } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'ending_time = :endingTime'.
	 */
	public Forms[] findWhereEndingTimeEquals(Date endingTime) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ending_time = ? ORDER BY ending_time", new Object[] { endingTime==null ? null : new java.sql.Timestamp( endingTime.getTime() ) } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'pre_planned_purpose = :prePlannedPurpose'.
	 */
	public Forms[] findWherePrePlannedPurposeEquals(String prePlannedPurpose) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE pre_planned_purpose = ? ORDER BY pre_planned_purpose", new Object[] { prePlannedPurpose } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'topic_activities = :topicActivities'.
	 */
	public Forms[] findWhereTopicActivitiesEquals(String topicActivities) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE topic_activities = ? ORDER BY topic_activities", new Object[] { topicActivities } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'accomplishment = :accomplishment'.
	 */
	public Forms[] findWhereAccomplishmentEquals(String accomplishment) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE accomplishment = ? ORDER BY accomplishment", new Object[] { accomplishment } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'goals_nextmeeting = :goalsNextmeeting'.
	 */
	public Forms[] findWhereGoalsNextmeetingEquals(String goalsNextmeeting) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE goals_nextmeeting = ? ORDER BY goals_nextmeeting", new Object[] { goalsNextmeeting } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'mentees_next_meeting = :menteesNextMeeting'.
	 */
	public Forms[] findWhereMenteesNextMeetingEquals(String menteesNextMeeting) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mentees_next_meeting = ? ORDER BY mentees_next_meeting", new Object[] { menteesNextMeeting } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'mentors_next_meeting = :mentorsNextMeeting'.
	 */
	public Forms[] findWhereMentorsNextMeetingEquals(String mentorsNextMeeting) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mentors_next_meeting = ? ORDER BY mentors_next_meeting", new Object[] { mentorsNextMeeting } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'time_next_meeting = :timeNextMeeting'.
	 */
	public Forms[] findWhereTimeNextMeetingEquals(Date timeNextMeeting) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE time_next_meeting = ? ORDER BY time_next_meeting", new Object[] { timeNextMeeting==null ? null : new java.sql.Timestamp( timeNextMeeting.getTime() ) } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'place_next_meeting = :placeNextMeeting'.
	 */
	public Forms[] findWherePlaceNextMeetingEquals(String placeNextMeeting) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE place_next_meeting = ? ORDER BY place_next_meeting", new Object[] { placeNextMeeting } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria ''.
	 */
	public Forms[] findAll() throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY form_id", null );
	}
	
	/** 
	 * Returns all rows from the forms table that match the criteria ''.
	 */
	public Forms[] findAllOrderBy(String orderby) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY "+orderby, null );
	}
	
	

	/** 
	 * Returns all rows from the forms table that match the criteria 'mentee_id = :menteeId'.
	 */
	public Forms[] findByMentees(int menteeId) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mentee_id = ?", new Object[] {  new Integer(menteeId) } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'mentor_id = :mentorId'.
	 */
	public Forms[] findByMentors(int mentorId) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mentor_id = ?", new Object[] {  new Integer(mentorId) } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'form_id = :formId'.
	 */
	public Forms[] findWhereFormIdEquals(int formId) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE form_id = ? ORDER BY form_id", new Object[] {  new Integer(formId) } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'mentor_id = :mentorId'.
	 */
	public Forms[] findWhereMentorIdEquals(int mentorId) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mentor_id = ? ORDER BY mentor_id", new Object[] {  new Integer(mentorId) } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'mentee_id = :menteeId'.
	 */
	public Forms[] findWhereMenteeIdEquals(int menteeId) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mentee_id = ? ORDER BY mentee_id", new Object[] {  new Integer(menteeId) } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'meeting_time = :meetingTime'.
	 */
	public Forms[] findWhereMeetingTimeEquals(Date meetingTime) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE meeting_time = ? ORDER BY meeting_time", new Object[] { meetingTime==null ? null : new java.sql.Timestamp( meetingTime.getTime() ) } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'meeting_place = :meetingPlace'.
	 */
	public Forms[] findWhereMeetingPlaceEquals(String meetingPlace) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE meeting_place = ? ORDER BY meeting_place", new Object[] { meetingPlace } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'meeting_notes = :meetingNotes'.
	 */
	public Forms[] findWhereMeetingNotesEquals(String meetingNotes) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE meeting_notes = ? ORDER BY meeting_notes", new Object[] { meetingNotes } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'next_meeting_goals = :nextMeetingGoals'.
	 */
	public Forms[] findWhereNextMeetingGoalsEquals(String nextMeetingGoals) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE next_meeting_goals = ? ORDER BY next_meeting_goals", new Object[] { nextMeetingGoals } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'topic_covered = :topicCovered'.
	 */
	public Forms[] findWhereTopicCoveredEquals(String topicCovered) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE topic_covered = ? ORDER BY topic_covered", new Object[] { topicCovered } );
	}

	/** 
	 * Returns all rows from the forms table that match the criteria 'topic_covered_other = :topicCoveredOther'.
	 */
	public Forms[] findWhereTopicCoveredOtherEquals(String topicCoveredOther) throws FormsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE topic_covered_other = ? ORDER BY topic_covered_other", new Object[] { topicCoveredOther } );
	}

	/**
	 * Method 'FormsDaoImpl'
	 * 
	 */
	public FormsDaoImpl()
	{
	}

	/**
	 * Method 'FormsDaoImpl'
	 * 
	 * @param userConn
	 */
	public FormsDaoImpl(final java.sql.Connection userConn)
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
		return "forms";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Forms fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Forms dto = new Forms();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Forms[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Forms dto = new Forms();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Forms ret[] = new Forms[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Forms dto, ResultSet rs) throws SQLException
	{
		dto.setFormId( rs.getInt( COLUMN_FORM_ID ) );
		dto.setMentorId( rs.getInt( COLUMN_MENTOR_ID ) );
		dto.setMenteeId( rs.getInt( COLUMN_MENTEE_ID ) );
		dto.setMeetingTime( rs.getTimestamp(COLUMN_MEETING_TIME ) );
		dto.setMeetingPlace( rs.getString( COLUMN_MEETING_PLACE ) );
		dto.setMeetingNotes( rs.getString( COLUMN_MEETING_NOTES ) );
		dto.setNextMeetingGoals( rs.getString( COLUMN_NEXT_MEETING_GOALS ) );
		dto.setTopicCovered( rs.getString( COLUMN_TOPIC_COVERED ) );
		dto.setTopicCoveredOther( rs.getString( COLUMN_TOPIC_COVERED_OTHER ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Forms dto)
	{
	}

	/** 
	 * Returns all rows from the forms table that match the specified arbitrary SQL statement
	 */
	public Forms[] findByDynamicSelect(String sql, Object[] sqlParams) throws FormsDaoException
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
			throw new FormsDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the forms table that match the specified arbitrary SQL statement
	 */
	public Forms[] findByDynamicWhere(String sql, Object[] sqlParams) throws FormsDaoException
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
			throw new FormsDaoException( "Exception: " + _e.getMessage(), _e );
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