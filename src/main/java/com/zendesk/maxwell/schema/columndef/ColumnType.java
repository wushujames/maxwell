package com.zendesk.maxwell.schema.columndef;

public enum ColumnType {
    BOOL("bool"),
    BOOLEAN("boolean"),
    TINYINT("tinyint"),
    SMALLINT("smallint"),
    MEDIUMINT("mediumint"),
    INT("int"),
    BIGINT("bigint"),
    TINYTEXT("tinytext"),
    TEXT("text"),
    MEDIUMTEXT("mediumtext"),
    LONGTEXT("longtext"),
    VARCHAR("varchar"),
    CHAR("char"),
    TINYBLOB("tinyblog"),
    BLOB("blob"),
    MEDIUMBLOB("mediumblob"),
    LONGBLOB("longblob"),
    BINARY("binary"),
    VARBINARY("varbinary"),
    REAL("real"),
    NUMERIC("numeric"),
    FLOAT("float"),
    DOUBLE("double"),
    DECIMAL("decimal"),
    DATE("date"),
    DATETIME("datetime"),
    TIMESTAMP("timestamp"),
    YEAR("year"),
    TIME("time"),
    ENUM("enum"),
    SET("set"),
    BIT("bit"),
    
    INT1("int1"),
    INT2("int2"),
    INT3("int3"),
    INT4("int4"),
    INTEGER("integer"),
    INT8("int8")
    ;
    
    private String sqlType;
    
    private ColumnType(String s) {
        this.sqlType = s;
    }
    
}
