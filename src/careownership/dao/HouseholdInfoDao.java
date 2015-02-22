/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package careownership.dao;

import java.util.Date;
import careownership.dto.*;
import careownership.exceptions.*;

public interface HouseholdInfoDao
{
	/** 
	 * Inserts a new row in the household_info table.
	 */
	public HouseholdInfoPk insert(HouseholdInfo dto) throws HouseholdInfoDaoException;

	/** 
	 * Updates a single row in the household_info table.
	 */
	public void update(HouseholdInfoPk pk, HouseholdInfo dto) throws HouseholdInfoDaoException;

	/** 
	 * Deletes a single row in the household_info table.
	 */
	public void delete(HouseholdInfoPk pk) throws HouseholdInfoDaoException;

	/** 
	 * Returns the rows from the household_info table that matches the specified primary-key value.
	 */
	public HouseholdInfo findByPrimaryKey(HouseholdInfoPk pk) throws HouseholdInfoDaoException;

	/** 
	 * Returns all rows from the household_info table that match the criteria 'household_info_id = :householdInfoId'.
	 */
	public HouseholdInfo findByPrimaryKey(int householdInfoId) throws HouseholdInfoDaoException;

	/** 
	 * Returns all rows from the household_info table that match the criteria ''.
	 */
	public HouseholdInfo[] findAll() throws HouseholdInfoDaoException;

	/** 
	 * Returns all rows from the household_info table that match the criteria 'mentee_id = :menteeId'.
	 */
	public HouseholdInfo[] findByMentees(int menteeId) throws HouseholdInfoDaoException;

	/** 
	 * Returns all rows from the household_info table that match the criteria 'household_info_id = :householdInfoId'.
	 */
	public HouseholdInfo[] findWhereHouseholdInfoIdEquals(int householdInfoId) throws HouseholdInfoDaoException;

	/** 
	 * Returns all rows from the household_info table that match the criteria 'household_info_name = :householdInfoName'.
	 */
	public HouseholdInfo[] findWhereHouseholdInfoNameEquals(String householdInfoName) throws HouseholdInfoDaoException;

	/** 
	 * Returns all rows from the household_info table that match the criteria 'household_info_date_of_birth = :householdInfoDateOfBirth'.
	 */
	public HouseholdInfo[] findWhereHouseholdInfoDateOfBirthEquals(Date householdInfoDateOfBirth) throws HouseholdInfoDaoException;

	/** 
	 * Returns all rows from the household_info table that match the criteria 'household_info_adult = :householdInfoAdult'.
	 */
	public HouseholdInfo[] findWhereHouseholdInfoAdultEquals(String householdInfoAdult) throws HouseholdInfoDaoException;

	/** 
	 * Returns all rows from the household_info table that match the criteria 'household_info_relationship = :householdInfoRelationship'.
	 */
	public HouseholdInfo[] findWhereHouseholdInfoRelationshipEquals(String householdInfoRelationship) throws HouseholdInfoDaoException;

	/** 
	 * Returns all rows from the household_info table that match the criteria 'household_info_notes = :householdInfoNotes'.
	 */
	public HouseholdInfo[] findWhereHouseholdInfoNotesEquals(String householdInfoNotes) throws HouseholdInfoDaoException;

	/** 
	 * Returns all rows from the household_info table that match the criteria 'mentee_id = :menteeId'.
	 */
	public HouseholdInfo[] findWhereMenteeIdEquals(int menteeId) throws HouseholdInfoDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the household_info table that match the specified arbitrary SQL statement
	 */
	public HouseholdInfo[] findByDynamicSelect(String sql, Object[] sqlParams) throws HouseholdInfoDaoException;

	/** 
	 * Returns all rows from the household_info table that match the specified arbitrary SQL statement
	 */
	public HouseholdInfo[] findByDynamicWhere(String sql, Object[] sqlParams) throws HouseholdInfoDaoException;

}