package com.example.airbnbproject2;

import java.util.ArrayList;
import javafx.fxml.*;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;

public class GUIController {
    public Parser parser;
    public ArrayList<Listing> listings;
    private Scene scene;
    private CommandWords commandWords;

    @FXML
    private TextField text1;

    @FXML
    private Button btn1;

    public GUIController(){
        parser = new Parser();
        commandWords = new CommandWords();
       listings = parser.load();

    }

@FXML
    public void btnMouseEntered (){
      DropShadow shadow = new DropShadow();
       btn1.setEffect(shadow);
       //scene.setCursor(Cursor.OPEN_HAND);

    }

    @FXML
    public void btnMouseExit(){
        btn1.setEffect(null);
        //scene.setCursor(Cursor.DEFAULT);
    }

    @FXML
    public void btnAction(){
        searchText(text1.getText());

    }

    public void searchText(String text){
        String[] commands = text.split(" ");
        for(String string: commands){
            if(commandWords.isAreaCommand(string)){
                listings = parser.filterArea(listings,string);
                System.out.println(listings.get(0).getNeighbourhood());
            }
        }

    }



}
