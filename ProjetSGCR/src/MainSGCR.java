import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import SGCR_DB.DataBase;
public class MainSGCR extends Application {



	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = FXMLLoader.load(getClass().getResource("infoCentre.fxml"));
		Scene scene = new Scene(root,650,600);
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image("x-rays.png"));
		primaryStage.show();
		primaryStage.setTitle("Centre de Radiologie");
		
		
		
	}

}
