package com.gha.intellissets.intellisets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gha.intellissets.intellisets.model.Asset;
import com.gha.intellissets.intellisets.model.service.AssetService;

@SpringBootApplication
public class IntellisetsApplication implements CommandLineRunner {
	
	@Autowired private AssetService assetService;

	public static void main(String[] args) {
		SpringApplication.run(IntellisetsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		assetService.addAsset(new Asset("Table","Head Office","Furniture","12/10/2017",15000.00)); 
		assetService.addAsset(new Asset("Chair","Finance","Furniture","12/10/2017",8000.00));
		assetService.addAsset(new Asset("TV","Treasury","Electronics","12/10/2017",85000.00));
	}
	
	
}
