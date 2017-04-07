package com.ampel.drugsearch.model;

import javax.validation.constraints.NotNull;


public class Drug {

	
	@NotNull
	private int id;
	
	@NotNull
	private String drug_name;
	
	@NotNull
	private String target;
	
	@NotNull
	private String gene_id;
	
	@NotNull
	private String gene_syn;
	
	@NotNull
	private String drug_syn;
	
	public Drug(){
		
	}

	public Drug(int id,String drug_name, String target,String gene_id,String gene_syn,String drug_syn) {
		super();
		this.drug_name = drug_name;
		this.target = target;
		this.id = id;
		this.gene_id = gene_id;
		this.gene_syn = gene_syn;
		this.drug_syn = drug_syn;
	}

	public String getGene_id() {
		return gene_id;
	}

	public void setGene_id(String gene_id) {
		this.gene_id = gene_id;
	}

	public String getGene_syn() {
		return gene_syn;
	}

	public void setGene_syn(String gene_syn) {
		this.gene_syn = gene_syn;
	}

	public String getDrug_syn() {
		return drug_syn;
	}

	public void setDrug_syn(String drug_syn) {
		this.drug_syn = drug_syn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDrug_name() {
		return drug_name;
	}

	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	

}
