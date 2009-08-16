package com.boaglio;

public class Termo {

	private String id;
	private String definition;

	private String enTerm;

	private String ptTerm;


	public Termo(String id, String definition, String enTerm, String ptTerm) {
		this.id = id;
		this.definition = definition;
		this.enTerm = enTerm;
		this.ptTerm = ptTerm;
	}

	public Termo(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getEnTerm() {
		return enTerm;
	}

	public void setEnTerm(String enTerm) {
		this.enTerm = enTerm;
	}

	public String getPtTerm() {
		return ptTerm;
	}

	public void setPtTerm(String ptTerm) {
		this.ptTerm = ptTerm;
	}


}
