package fr.diginamic.ia.entite;

public class Bitcoin {
	
	public double prix;
	public double evolution;
	
	public Bitcoin(double prix, double evolution) {
		super();
		this.prix = prix;
		this.evolution = evolution;
	}
	//public double volumeAchatJournalier;
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getEvolution() {
		return evolution;
	}
	public void setEvolution(double evolution) {
		this.evolution = evolution;
	}
	
	

}
