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