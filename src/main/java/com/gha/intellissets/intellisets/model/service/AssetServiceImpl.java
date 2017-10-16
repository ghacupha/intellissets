package com.gha.intellissets.intellisets.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gha.intellissets.intellisets.model.Asset;
import com.gha.intellissets.intellisets.model.repo.AssetRepository;

@Service
public class AssetServiceImpl implements AssetService {
	
	private final Logger log = LoggerFactory.getLogger(AssetServiceImpl.class);

	@Autowired private AssetRepository assetRepository;
	
	
	@Override
	public void addAsset(Asset asset) {
		
		log.debug("Saving a new asset : {} ", asset);

		assetRepository.save(asset);
	}
	
	
	@Override
	public Asset findById(int id) {
		
		log.info("Fetching asset # : {}",id);
		
		return (Asset) assetRepository.findById(id).get();
	}
	
	
	@Override
	public List<Asset> findAll(){
		
		log.debug("Fetcing the assets list");
		
		return (List<Asset>) assetRepository.findAll();
	}

	@Override
	public void deleteAsset(Integer id) {
		
		assetRepository.deleteById(id);
	}
	
	
}
