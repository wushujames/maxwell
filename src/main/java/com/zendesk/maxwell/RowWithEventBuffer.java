package com.zendesk.maxwell;

import com.zendesk.maxwell.util.ListWithDiskBuffer;

import java.io.IOException;

public class RowWithEventBuffer extends ListWithDiskBuffer<RowWithEvent> {
	private Long xid;

	public RowWithEventBuffer(long maxInMemoryElements) throws IOException {
		super(maxInMemoryElements);
	}

	public RowWithEvent removeFirst() throws IOException, ClassNotFoundException {
		RowWithEvent r = super.removeFirst();
		r.setXid(this.xid);
		return r;
	}

	public void setXid(Long xid) {
		this.xid = xid;
	}
}
