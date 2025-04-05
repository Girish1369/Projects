package com.gbk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gbk.service.IPurchaseOrderMgmtService;

@Component
public class BootMailTestRunner implements CommandLineRunner {
	
	@Autowired
	private IPurchaseOrderMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		String msg = service.purchase(new String[]{"Shirt","Trouser","coat"},new double[] {5000.0,6000.0, 7000.0}, 
							new String[] {"girishkatkamwar.1369@gmail.com"});
		System.out.println(msg);
	}

}
