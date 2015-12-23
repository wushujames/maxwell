package com.zendesk.maxwell.producer;

import com.zendesk.maxwell.MaxwellContext;
import com.zendesk.maxwell.RowMap;
import com.zendesk.maxwell.RowWithEvent;

public abstract class AbstractJsonProducer extends AbstractProducer {

	public AbstractJsonProducer(MaxwellContext context) {
		super(context);
	}

	abstract public void push(RowMap r) throws Exception;

	@Override
	public void push(RowWithEvent r) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
