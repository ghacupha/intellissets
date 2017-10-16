package com.gha.intellissets.intellisets.model.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gha.intellissets.intellisets.model.Asset;

@Repository
public interface AssetRepository extends CrudRepository<Asset, Integer> {

}
