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
package com.gha.intellissets.intellisets.model.service;

import com.gha.intellissets.intellisets.model.Asset;

public interface AssetService {

	void addAsset(Asset asset);

	Asset findById(int id);

	Iterable<Asset> findAll();

	void deleteAsset(Integer id);

	/**
	 * Checks if a given asset exists
	 * 
	 * @param asset
	 * @return
	 */
	boolean exists(Asset asset);

	/**
	 * Takes a given asset it and copies the details from the form
	 * 
	 * @param asset
	 */
	void updateAsset(Asset asset);

}
