package com.zendesk.maxwell.schema.columndef;

public abstract class ColumnDef {
	protected final String tableName;
	protected final String name;
	protected final ColumnType type;
	protected String[] enumValues;
	private int pos;
	public boolean signed;
	public String encoding;

	public ColumnDef(String tableName, String name, ColumnType type, int pos) {
		this.tableName = tableName;
		this.name = name.toLowerCase();
		this.type = type;
		this.pos = pos;
		this.signed = false;
	}

	public abstract boolean matchesMysqlType(int type);
	public abstract String toSQL(Object value);

	public Object asJSON(Object value) {
		return value;
	}

	public ColumnDef copy() {
		return build(this.tableName, this.name, this.encoding, this.type.name(), this.pos, this.signed, this.enumValues);
	}

	public static ColumnDef build(String tableName, String name, String encoding, String typeString, int pos, boolean signed, String enumValues[]) {
		ColumnType type;
		try {
			String upperTypeString = unalias_type(typeString.toUpperCase());
			type = ColumnType.valueOf(upperTypeString);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("unsupported column type " + typeString);
		}

		switch(type) {
		case BOOL:
		case BOOLEAN:
			type = ColumnType.TINYINT;
			// fallthrough
		case TINYINT:
		case SMALLINT:
		case MEDIUMINT:
		case INT:
			return new IntColumnDef(tableName, name, type, pos, signed);
		case BIGINT:
			return new BigIntColumnDef(tableName, name, type, pos, signed);
		case TINYTEXT:
		case TEXT:
		case MEDIUMTEXT:
		case LONGTEXT:
		case VARCHAR:
		case CHAR:
			return new StringColumnDef(tableName, name, type, pos, encoding);
		case TINYBLOB:
		case BLOB:
		case MEDIUMBLOB:
		case LONGBLOB:
		case BINARY:
		case VARBINARY:
			return new StringColumnDef(tableName, name, type, pos, "binary");
		case REAL:
		case NUMERIC:
			type = ColumnType.DOUBLE;
			// fall through
		case FLOAT:
		case DOUBLE:
			return new FloatColumnDef(tableName, name, type, pos);
		case DECIMAL:
			return new DecimalColumnDef(tableName, name, type, pos);
		case DATE:
			return new DateColumnDef(tableName, name, type, pos);
		case DATETIME:
		case TIMESTAMP:
			return new DateTimeColumnDef(tableName, name, type, pos);
		case YEAR:
			return new YearColumnDef(tableName, name, type, pos);
		case TIME:
			return new TimeColumnDef(tableName, name, type, pos);
		case ENUM:
			return new EnumColumnDef(tableName, name, type, pos, enumValues);
		case SET:
			return new SetColumnDef(tableName, name, type, pos, enumValues);
		case BIT:
			return new BitColumnDef(tableName, name, type, pos);
		}

		throw new IllegalArgumentException("unsupported column type " + typeString);
	}

	static private String unalias_type(String type) {
		switch(type) {
			case "INT1":
				return "TINYINT";
			case "INT2":
				return "SMALLINT";
			case "INT3":
				return "MEDIUMINT";
			case "INT4":
			case "INTEGER":
				return "INT";
			case "INT8":
				return "BIGINT";
			default:
				return type;
		}
	}

	public String getName() {
		return name;
	}

	public String getTableName() {
		return tableName;
	}

	public ColumnType getType() {
		return type;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int i) {
		this.pos = i;
	}

	public String getEncoding() {
		return this.encoding;
	}

	public boolean getSigned() {
		return this.signed;
	}

	public String[] getEnumValues() {
		return enumValues;
	}

}
