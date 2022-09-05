package com.example.airbnbproject2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUIController implements Initializable{
    public Parser parser;
    public static ArrayList<Listing> listings;
    private Scene scene;
    private final CommandWords commandWords;

    @FXML
    private TextField text1;

    @FXML
    private Button btn1;

    @FXML
    private AnchorPane pane;

    @FXML
    private AnchorPane node;

    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Label tempLabel;

    public GUIController() {
        parser = new Parser();
        commandWords = new CommandWords();
        listings = parser.load();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    comboBox.setItems(FXCollections.observableArrayList("1", "2", "3", "4"));
    }

    @FXML
    public void setComboText(){
        tempLabel.setVisible(false);
    }

    @FXML
    public void btnMouseEntered() {
        DropShadow shadow = new DropShadow();
        btn1.setEffect(shadow);
    }

    @FXML
    public void btnMouseExit() {
        btn1.setEffect(null);
    }

    /**
     * Action when search button is pressed.
     * Opens new page with filtered results.
     * @throws IOException
     */
    @FXML
    public void searchAction() throws IOException {
        listings = parser.load();
        searchText(text1.getText());
        if(!(comboBox.getValue() == null)){
            filterGuests(Integer.parseInt(comboBox.getValue()));
        }

          Stage stage = (Stage) btn1.getScene().getWindow();

          Stage mainStage = new Stage();

          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Results.fxml"));

          Parent root = fxmlLoader.load();

          ResultsController controller = fxmlLoader.getController();

          Scene scene = new Scene(root);
          mainStage.setScene(scene);
          mainStage.initModality(Modality.WINDOW_MODAL);
          mainStage.show();

    }

    /**
     * Filter listings via input text.
     * @param text
     */
    public void searchText(String text) {
        String[] commands = text.split(" ");
        for (String string : commands) {

            if (commandWords.isAreaCommand(string)) {
                string = commandWords.getArea(string);
                listings = parser.filterNeighbourhood(listings, string);
            }

        }
    }

    /**
     * Filter listings by number of guests
     */
    public void filterGuests(int x)
    {

        listings = parser.filterRooms(listings,x);
    }
}
