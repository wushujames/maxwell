package com.zendesk.maxwell.schema.columndef;

import com.google.code.or.common.util.MySQLConstants;

public class FloatColumnDef extends ColumnDef {
	public FloatColumnDef(String tableName, String name, ColumnType type, int pos) {
		super(tableName, name, type, pos);
	}

	@Override
	public boolean matchesMysqlType(int type) {
		if ( getType() == ColumnType.FLOAT )
			return type == MySQLConstants.TYPE_FLOAT;
		else
			return type == MySQLConstants.TYPE_DOUBLE;
	}

	@Override
	public String toSQL(Object value) {
		return value.toString();
	}
}
