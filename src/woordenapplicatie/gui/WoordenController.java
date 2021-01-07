/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import woordenapplicatie.logic.TextAnalyzer;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {
    
   private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Heb je dan geen hoedje meer\n" +
                                                "Maak er één van bordpapier\n" +
                                                "Eén, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "En als het hoedje dan niet past\n" +
                                                "Zetten we 't in de glazenkas\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";
    
    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
    }
    
    @FXML
    private void aantalAction(ActionEvent event) {
     TextAnalyzer analyzer = new TextAnalyzer(DEFAULT_TEXT);
     System.out.println(analyzer.CountUniqueAndTotalWords());

     taOutput.setText(analyzer.CountUniqueAndTotalWords());
    }

    @FXML
    private void sorteerAction(ActionEvent event) {

     TextAnalyzer analyzer = new TextAnalyzer(DEFAULT_TEXT);
     System.out.println(analyzer.SortWordsDesc());

     taOutput.setText(analyzer.SortWordsDesc().toString());
    }

    @FXML
    private void frequentieAction(ActionEvent event) {

     TextAnalyzer analyzer = new TextAnalyzer(DEFAULT_TEXT);
     System.out.println(analyzer.WordFrequencySort(false));

     taOutput.setText(analyzer.WordFrequencySort(false).toString());
    }

    @FXML
    private void concordatieAction(ActionEvent event) {

     TextAnalyzer analyzer = new TextAnalyzer(DEFAULT_TEXT);
     //System.out.println(analyzer.Concordance());
     analyzer.Concordance();

     taOutput.setText(analyzer.Concordance().toString());
    }
   
}
