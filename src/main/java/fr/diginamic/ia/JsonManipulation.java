package fr.diginamic.ia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


import fr.diginamic.ia.entite.Bitcoin;

public class JsonManipulation {

	public static List<Bitcoin> obtenirLesBitcoins(JSONObject myResponse,LocalDate dateDebut,LocalDate dateFin) {


		List<Bitcoin> listeDesBitcoins =new ArrayList<Bitcoin>();
		while (!dateDebut.equals(dateFin)) {
			double prix =myResponse.getJSONObject("bpi").getDouble(dateFin.toString());
			
			listeDesBitcoins.add(new Bitcoin(prix,0));
			
			dateFin=dateFin.minusDays(1);
		}
		
		
		
		return listeDesBitcoins;
		
	}

}
