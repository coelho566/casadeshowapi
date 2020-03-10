package br.com.gft.casadeshowapi.domain;

public enum MusicCategory {
	
	ROCK("Rock"),
	SERTANEJO("Sertanejo"),
	ELETRONICO("Eletrônico"),
	FUNK("Funk"),
	AXE("Axé"),
	POP("Pop");
	
	private String description;
	
	MusicCategory(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
