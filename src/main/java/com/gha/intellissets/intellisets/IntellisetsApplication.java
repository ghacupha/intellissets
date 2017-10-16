/*******************************************************************************
 * Copyright 2017 edwin.njeru
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
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
