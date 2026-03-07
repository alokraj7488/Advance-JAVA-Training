package com.storage.service.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StorageServiceSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StorageServiceSystemApplication.class, args);
		
//		Storage storage1 = context.getBean(Storage.class);
//		storage1.storeFile("File1.txt");
		
		Storage storage2 = context.getBean(LocalStorageService.class);
		storage2.storeFile("File2.txt");
		
//		Storage storage3 = context.getBean(CloudStorageService.class);
//		storage3.storeFile("File3.txt");
		
		((ConfigurableApplicationContext)context).close();
	}

}
