package com.gha.intellissets.intellisets.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@MappedSuperclass
public class AbstractDomainClass implements DomainObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@Version
	private Integer version;
	
	private LocalDate dateCreated;
	private LocalDate lastUpdated;
	
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public LocalDate getLastUpdated() {
		return lastUpdated;
	}
	
	@PreUpdate
	@PrePersist
	public void updateTimeStamps() {
		
		lastUpdated = LocalDate.now();
		
		if(dateCreated == null) {
			dateCreated = LocalDate.now();
		}
	}
}
