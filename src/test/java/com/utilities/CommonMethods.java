package com.utilities;

import com.drivers.BaseDriver;

public class CommonMethods extends BaseDriver {

	public void timeout() throws InterruptedException {
		Thread.sleep(3000);
	}

	public void timeout(int time) throws InterruptedException {
		Thread.sleep(time);
	}

}
