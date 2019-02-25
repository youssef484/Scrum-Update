import java.net.URL; 
import java.util.ResourceBundle;
import java.util.regex.*;
import MyEnumTypes.Country;
import SGCR_FieldCheker.FieldCheckerV1;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FXMLcontrollerInfoCentre implements Initializable,FieldCheckerV1 {
ObservableList<Country> list = FXCollections.observableArrayList(Country.Tunisie,Country.Algerie,Country.Angleterre,Country.France,Country.Egypte,Country.Maroc,Country.Russie); 
    
FileChooser ImgChooser = new FileChooser();
private boolean  isValid[];

    //text fields

@FXML	
private TextField txtNom;

@FXML	
private TextField txtMail;

@FXML	
private TextField txtPhone;

@FXML	
private TextField txtFax;

@FXML	
private TextField txtAdresse;

@FXML	
private TextField txtCP;

   //TextFields'Error messages 
@FXML
private Label errNom;

@FXML
private Label errMail;

@FXML
private Label errPhone;

@FXML
private Label errFax;

@FXML
private Label errAdresse;

@FXML
private Label errCP;

@FXML
private Tooltip tp;
	
	// buttons

@FXML	
private Button btnImporter;

@FXML	
private Button btnAnnuler;

@FXML	
private Button btnValider;
	
@FXML	
private CheckBox chbox;

@FXML	
private ChoiceBox dbPay;
	
@FXML
private ImageView imgC;
	
	
	
	
	@FXML
	public void closeW() {
		Platform.exit();
	}
	
	@FXML
	public void  onClickImportImg(ActionEvent event) {
		
		ImgChooser.setTitle("Choisir image de centre");
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		ImgChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif","*.jpeg"));
		String path = ImgChooser.showOpenDialog(stage).getPath();
		String img = "file:"+ path;
		System.out.println(img);
		Image imgCentre = new Image(img);
		imgC.setImage(imgCentre);
		
		
	}
	
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbPay.setItems(list);
		dbPay.setValue(Country.Tunisie);
		
	}


	@Override
	public void nameFormatCheck(ActionEvent event) {
	String nom = txtNom.getText();
	
	if (nom.isEmpty()) {errNom.setText("ce champ est requis !"); }
	else if (!Pattern.matches("[a-zA-Z]*", nom)) {errNom.setText("Le nom doit contenir des lettres uniquement !");} 
	else {errNom.setText("");}	
	}


	@Override
	public void mailFormatCheck(ActionEvent event) {
		String mail = txtMail.getText();
		if (mail.isEmpty()) {errMail.setText("ce champ est requis !"); }
		else if (!Pattern.matches("[a-zA-Z]{6,16}{0,4}@[a-z]{1,8}.[a-z]{2,12}", mail)) {errMail.setText("le format de votre adresse E-mail est invalide !");} 
		else {errMail.setText("");}
		
	}


	@Override
	public void adressFormatCheck(ActionEvent event) {
		String adr = txtAdresse.getText();
		if (adr.isEmpty()) {errAdresse.setText("ce champ est requis !"); }
		else if (!Pattern.matches("[0-9]*-[a-zA-Z]*", adr)) {errAdresse.setText("le format de votre adresse est invalide !");} 
		else {errAdresse.setText("");}
		
	}


	@Override
	public void phoneFormatCheck(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void postalCodeFormatCheck(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void faxFormatCheck(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
@FXML
public void checkAllfields(ActionEvent event) {
nameFormatCheck(event);
mailFormatCheck(event);
}

}
