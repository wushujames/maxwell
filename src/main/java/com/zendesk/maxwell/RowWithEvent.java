package com.zendesk.maxwell;

import java.io.Serializable;

import com.google.code.or.common.glossary.Row;
import com.zendesk.maxwell.schema.Table;

public class RowWithEvent implements Serializable {

	private final Row row;
	private final MaxwellAbstractRowsEvent event;
	private Long xid;
	private boolean txCommit;

	public RowWithEvent(Row row, MaxwellAbstractRowsEvent event) {
		// TODO Auto-generated constructor stub
		this.row = row;
		this.event = event;
	}

	public void setXid(Long xid) {
		this.xid = xid;
	}

	public void setTXCommit() {
		this.txCommit = true;
	}

	public Row getRow() {
		// TODO Auto-generated method stub
		return row;
	}

	public Table getTable() {
		return event.table;
	}

}
