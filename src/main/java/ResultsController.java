package com.example.airbnbproject2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ResultsController implements Initializable {
    @FXML
    private WebView view;
    @FXML
    private VBox mainBox;
    @FXML
    private VBox vbox;

    private WebEngine engine;

    private static int pageNo;

    private  ArrayList<Listing> listings;

    private static int maxPage;


    public ResultsController(){
        listings = new ArrayList<Listing>();
        pageNo = 1;
        maxPage = 0;
    }

    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        listings = GUIController.listings;
        maxPage = listings.size()/20;
        engine = view.getEngine();


        //List of properties that are shown at the moment
        ArrayList<Listing> viewList = new ArrayList<>();

        int x = (pageNo - 1) * 20;
        for(int i = x; i<x+20; i++){
            viewList.add(listings.get(i));
            System.out.println("lat: " + listings.get(i).getLongitude() + ", long: " + listings.get(i).getLongitude());
        }

        setVBox(vbox,viewList);

        Button btn = new Button("Next");
        btn.setOnAction(
                (ActionEvent ev) -> {
                    try {
                        pageButton(ev);
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                }
        );
        Label label = new Label("Page: " + pageNo + "/" + maxPage);
        HBox detailsbox = new HBox(btn,label);
        vbox.getChildren().add(detailsbox);
        webButton(viewList);


    }

    @FXML
    public void pageButton(ActionEvent event) throws IOException {
        pageNo++;

        initialize(null,null);

    }



    @FXML
    public void listingButton(String id){
      String web = "https://www.airbnb.co.uk/rooms/" + id;
       engine.load(web);
    }

    public void webButton(ArrayList<Listing> listings){
        try {
            String link = "https://www.mapquestapi.com/staticmap/v5/map?locations=";
            for(Listing listing:listings){
                link = link + listing.getLatitude() + "," + listing.getLongitude() + "||";
            }
            link = link+ "&size=@2x&key=91H0TfFvCSln76hQzCPv5Hbv4XfGgxEg";
            engine.load(link);

        }
        catch(Exception e){

        }
    }

    /**
     *
     * @param listing
     * @return VBox with filled information
     */
    public VBox makeNode(Listing listing){

        VBox vbox = new VBox();
        ImageView view = new ImageView();
        Label label1 = new Label();
        HBox hbox = new HBox();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();

        StackPane sp = new StackPane();
        // Make Button
        Button btn = new Button();
        btn.setPrefHeight(250);
        btn.setPrefWidth(250);
        btn.setVisible(true);
        btn.setId("myButton");
        btn.getStylesheets().add("styleSheet.css");
        btn.setOnAction(
                (ActionEvent ev) -> {
                    try {
                        listingButton(listing.getId());
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
        );


        sp.getChildren().addAll(view,btn);

        vbox.getChildren().addAll(sp,label1,label2,label3,label4);

        if(listing.getRoom_type().equals("Entire home/apt")) {

            Image image = new Image(getClass().getResourceAsStream("1.jpg"));
            view.setImage(image);
            view.setFitHeight(250);
            view.setFitWidth(250);

        }

        if(listing.getRoom_type().equals("Private room")){
            Image image = new Image(getClass().getResourceAsStream("Apartment.jpeg"));
            view.setImage(image);
            view.setFitHeight(250);
            view.setFitWidth(250);
        }
        label1.setText(listing.getRoom_type());
        label2.setText(listing.getName());
        label3.setText(listing.getNeighbourhood());
        label4.setText("£" + listing.getPrice() + " night");

        return vbox;
    }

    /**
     * Sets primary vbox that holds information with the information
     * @param vbox
     * @param viewList
     */
    public void setVBox(VBox vbox, ArrayList<Listing> viewList){
        vbox.getChildren().clear();
        for(int i = 0; i < viewList.size()-2; i = i+2){
            HBox hbox = new HBox();
            VBox box1 = makeNode(viewList.get(i));
            VBox box2 = makeNode(viewList.get(i+1));
            hbox.getChildren().addAll(box1,box2);
            vbox.getChildren().add(hbox);
        }
    }

}
