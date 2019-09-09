package fr.diginamic.ia;

import java.time.LocalDate;
import java.util.List;

import org.json.JSONObject;


import fr.diginamic.ia.entite.Bitcoin;

public abstract class BitcoinService {
	
	public static List<Bitcoin> listeDeBitcoins(LocalDate dateDebut,LocalDate dateFin) throws Exception{
		
		JSONObject myResponse = ApiUtils.callApi(
				"https://api.coindesk.com/v1/bpi/historical/close.json?start=" + dateDebut + "&end="+ dateFin);
		List<Bitcoin> listeDeBitcoins = JsonManipulation.obtenirLesBitcoins(myResponse, dateDebut, dateFin);
		

		return listeDeBitcoins;
		
	}

}
