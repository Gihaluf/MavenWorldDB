package Main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import DB.Database_connection;

public class WorldDBApp extends Application{
	private Connection con;
	private TableView<ObservableList<String>> table = new TableView<>();
	
	private ComboBox<String> tableSelector = new ComboBox<>();
	
	private List<String> currentColumns = new ArrayList<>();
	private List<String> databaseView = new ArrayList<>();
	
	private Button btnSelect = new Button("Atlasīt (SELECT)");
	private Button btnInsert = new Button("Pievienot (INSERT)");
	private Button btnUpdate = new Button("Atjaunināt (UPDATE)");
	private Button btnDelete = new Button("Dzēst (DELETE)");
	
	
	@Override
	public void start(Stage stage){
		Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());	
		
		//PrimerDark(), NordDard()
		
		try {
			con = Database_connection.getConnection();
			databaseView = ViewManager.getDatabaseViews(con);
			
		}catch (Exception e) {
			showAlert("Savienojuma kļūda: ", e.getMessage());
			return;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
