package fr.diginamic.ia;

import java.time.LocalDate;
import java.util.List;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;

import fr.diginamic.ia.entite.Bitcoin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        
//    	MultiLayerPerceptron neuralNetwork = new MultiLayerPerceptron(2, 10, 1);
//    	
//    	// create training set (logical AND function)
//        DataSet trainingSet = new DataSet(2, 1);
//        trainingSet.addRow(new DataSetRow(new double[]{0, 0}, new double[]{0}));
//        //trainingSet.addRow(new DataSetRow(new double[]{0, 1}, new double[]{0}));
//        trainingSet.addRow(new DataSetRow(new double[]{1, 0}, new double[]{0}));
//        trainingSet.addRow(new DataSetRow(new double[]{1, 1}, new double[]{1}));
//
//       
//        neuralNetwork.learn(trainingSet) ;
//        
//        neuralNetwork.setInput(0,1);
//        neuralNetwork.calculate();
//        for (double output: neuralNetwork.getOutput()){
//        System.out.println(output);
//        }
    	
    	
        List<Bitcoin> listeDeBitcoins=BitcoinService.listeDeBitcoins(LocalDate.now().minusDays(60), LocalDate.now().minusDays(50));
        
        MultiLayerPerceptron neuralNetwork = new MultiLayerPerceptron(2, 5, 1);
        
        DataSet dataSet = new DataSet(2, 1);
        for (int i = 0; i < listeDeBitcoins.size()-1; i++) {
        
        listeDeBitcoins.get(i).setEvolution((listeDeBitcoins.get(i+1).getPrix()-listeDeBitcoins.get(i).getPrix())/listeDeBitcoins.get(i).getPrix()*100);
        	
        dataSet.addRow(new DataSetRow(new double[] {listeDeBitcoins.get(i).getPrix(),listeDeBitcoins.get(i).getEvolution()}, new double[]{listeDeBitcoins.get(i+1).getPrix()}));
        System.out.println("ok");
        
        //dataSet.addRow(rFour);
        }
        System.out.println("debut apprentissage");
        neuralNetwork.learn(dataSet) ;
        System.out.println("fin apprentissage");
        
        List<Bitcoin> listeDeBitcoinsdeVerification=BitcoinService.listeDeBitcoins(LocalDate.now().minusDays(50), LocalDate.now().minusDays(70));
        for (Bitcoin bitcoin : listeDeBitcoinsdeVerification) {
        	System.out.println("ouai");
        	System.out.println(bitcoin.getPrix());
        	neuralNetwork.setInput(bitcoin.getPrix(),bitcoin.getEvolution());
            
        
        
        }
        neuralNetwork.calculate();
        for (double output: neuralNetwork.getOutput()){
        System.out.print(output);
	}
  }
}
