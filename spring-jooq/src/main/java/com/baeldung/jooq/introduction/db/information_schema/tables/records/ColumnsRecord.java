/**
 * This class is generated by jOOQ
 */
package com.baeldung.jooq.introduction.db.information_schema.tables.records;


import com.baeldung.jooq.introduction.db.information_schema.tables.Columns;

import javax.annotation.Generated;

import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ColumnsRecord extends TableRecordImpl<ColumnsRecord> {

	private static final long serialVersionUID = 1850723283;

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.TABLE_CATALOG</code>.
	 */
	public void setTableCatalog(String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.TABLE_CATALOG</code>.
	 */
	public String getTableCatalog() {
		return (String) getValue(0);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.TABLE_SCHEMA</code>.
	 */
	public void setTableSchema(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.TABLE_SCHEMA</code>.
	 */
	public String getTableSchema() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.TABLE_NAME</code>.
	 */
	public void setTableName(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.TABLE_NAME</code>.
	 */
	public String getTableName() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.COLUMN_NAME</code>.
	 */
	public void setColumnName(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.COLUMN_NAME</code>.
	 */
	public String getColumnName() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.ORDINAL_POSITION</code>.
	 */
	public void setOrdinalPosition(Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.ORDINAL_POSITION</code>.
	 */
	public Integer getOrdinalPosition() {
		return (Integer) getValue(4);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.COLUMN_DEFAULT</code>.
	 */
	public void setColumnDefault(String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.COLUMN_DEFAULT</code>.
	 */
	public String getColumnDefault() {
		return (String) getValue(5);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.IS_NULLABLE</code>.
	 */
	public void setIsNullable(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.IS_NULLABLE</code>.
	 */
	public String getIsNullable() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.DATA_TYPE</code>.
	 */
	public void setDataType(Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.DATA_TYPE</code>.
	 */
	public Integer getDataType() {
		return (Integer) getValue(7);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.CHARACTER_MAXIMUM_LENGTH</code>.
	 */
	public void setCharacterMaximumLength(Integer value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.CHARACTER_MAXIMUM_LENGTH</code>.
	 */
	public Integer getCharacterMaximumLength() {
		return (Integer) getValue(8);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.CHARACTER_OCTET_LENGTH</code>.
	 */
	public void setCharacterOctetLength(Integer value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.CHARACTER_OCTET_LENGTH</code>.
	 */
	public Integer getCharacterOctetLength() {
		return (Integer) getValue(9);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.NUMERIC_PRECISION</code>.
	 */
	public void setNumericPrecision(Integer value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.NUMERIC_PRECISION</code>.
	 */
	public Integer getNumericPrecision() {
		return (Integer) getValue(10);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.NUMERIC_PRECISION_RADIX</code>.
	 */
	public void setNumericPrecisionRadix(Integer value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.NUMERIC_PRECISION_RADIX</code>.
	 */
	public Integer getNumericPrecisionRadix() {
		return (Integer) getValue(11);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.NUMERIC_SCALE</code>.
	 */
	public void setNumericScale(Integer value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.NUMERIC_SCALE</code>.
	 */
	public Integer getNumericScale() {
		return (Integer) getValue(12);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.CHARACTER_SET_NAME</code>.
	 */
	public void setCharacterSetName(String value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.CHARACTER_SET_NAME</code>.
	 */
	public String getCharacterSetName() {
		return (String) getValue(13);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.COLLATION_NAME</code>.
	 */
	public void setCollationName(String value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.COLLATION_NAME</code>.
	 */
	public String getCollationName() {
		return (String) getValue(14);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.TYPE_NAME</code>.
	 */
	public void setTypeName(String value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.TYPE_NAME</code>.
	 */
	public String getTypeName() {
		return (String) getValue(15);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.NULLABLE</code>.
	 */
	public void setNullable(Integer value) {
		setValue(16, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.NULLABLE</code>.
	 */
	public Integer getNullable() {
		return (Integer) getValue(16);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.IS_COMPUTED</code>.
	 */
	public void setIsComputed(Boolean value) {
		setValue(17, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.IS_COMPUTED</code>.
	 */
	public Boolean getIsComputed() {
		return (Boolean) getValue(17);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.SELECTIVITY</code>.
	 */
	public void setSelectivity(Integer value) {
		setValue(18, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.SELECTIVITY</code>.
	 */
	public Integer getSelectivity() {
		return (Integer) getValue(18);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.CHECK_CONSTRAINT</code>.
	 */
	public void setCheckConstraint(String value) {
		setValue(19, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.CHECK_CONSTRAINT</code>.
	 */
	public String getCheckConstraint() {
		return (String) getValue(19);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.SEQUENCE_NAME</code>.
	 */
	public void setSequenceName(String value) {
		setValue(20, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.SEQUENCE_NAME</code>.
	 */
	public String getSequenceName() {
		return (String) getValue(20);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.REMARKS</code>.
	 */
	public void setRemarks(String value) {
		setValue(21, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.REMARKS</code>.
	 */
	public String getRemarks() {
		return (String) getValue(21);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.COLUMNS.SOURCE_DATA_TYPE</code>.
	 */
	public void setSourceDataType(Short value) {
		setValue(22, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.COLUMNS.SOURCE_DATA_TYPE</code>.
	 */
	public Short getSourceDataType() {
		return (Short) getValue(22);
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ColumnsRecord
	 */
	public ColumnsRecord() {
		super(Columns.COLUMNS);
	}

	/**
	 * Create a detached, initialised ColumnsRecord
	 */
	public ColumnsRecord(String tableCatalog, String tableSchema, String tableName, String columnName, Integer ordinalPosition, String columnDefault, String isNullable, Integer dataType, Integer characterMaximumLength, Integer characterOctetLength, Integer numericPrecision, Integer numericPrecisionRadix, Integer numericScale, String characterSetName, String collationName, String typeName, Integer nullable, Boolean isComputed, Integer selectivity, String checkConstraint, String sequenceName, String remarks, Short sourceDataType) {
		super(Columns.COLUMNS);

		setValue(0, tableCatalog);
		setValue(1, tableSchema);
		setValue(2, tableName);
		setValue(3, columnName);
		setValue(4, ordinalPosition);
		setValue(5, columnDefault);
		setValue(6, isNullable);
		setValue(7, dataType);
		setValue(8, characterMaximumLength);
		setValue(9, characterOctetLength);
		setValue(10, numericPrecision);
		setValue(11, numericPrecisionRadix);
		setValue(12, numericScale);
		setValue(13, characterSetName);
		setValue(14, collationName);
		setValue(15, typeName);
		setValue(16, nullable);
		setValue(17, isComputed);
		setValue(18, selectivity);
		setValue(19, checkConstraint);
		setValue(20, sequenceName);
		setValue(21, remarks);
		setValue(22, sourceDataType);
	}
}
