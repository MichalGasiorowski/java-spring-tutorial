package com.goose.spring.aop;

import org.springframework.stereotype.Component;


@Component
public class Fan implements IFan {
	/* (non-Javadoc)
	 * @see com.goose.spring.aop.IFan#activate(int)
	 */
	public void activate(int level) {
		System.out.println("Fan running at level " + level);
	}
}
