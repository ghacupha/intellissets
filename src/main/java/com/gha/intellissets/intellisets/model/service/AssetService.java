package com.gha.intellissets.intellisets.model.service;

import com.gha.intellissets.intellisets.model.Asset;

public interface AssetService {

	void addAsset(Asset asset);

	Asset findById(int id);

	Iterable<Asset> findAll();

	void deleteAsset(Integer id);

}