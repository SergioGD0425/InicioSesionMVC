package dad.javafx.iniciosesionmvc;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


public class View extends GridPane {
	

	private TextField usuario;
	private PasswordField contrasena;
	private Button acceder;
	private Button cancelar;
	private HBox botones;
	
	public View() {
		super();
		
		usuario = new TextField();
		usuario.setPromptText("Introduce usuario");
		usuario.setMaxWidth(130);
		

		contrasena = new PasswordField();
		contrasena.setPromptText("Introduce contraseña");
		contrasena.setMaxWidth(130);
		
		acceder = new Button("Acceder");
		acceder.setDefaultButton(true);
		
		cancelar = new Button("Cancelar");
		
		botones = new HBox(acceder,cancelar);
		botones.setAlignment(Pos.CENTER);
		botones.setSpacing(10);
		
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
		this.setHgap(5);
		this.setVgap(5);
	
		this.addRow(0, new Label("Usuario: "), usuario);
		this.addRow(1, new Label("Contraseña: "),contrasena);
		this.addRow(2,botones);
		this.setColumnSpan(botones,2);
		
		ColumnConstraints [] cols = {
				new ColumnConstraints(),
				new ColumnConstraints(),
		};
		
		cols[0].setHalignment(HPos.LEFT);
		cols[1].setFillWidth(true);
		

		this.getColumnConstraints().setAll(cols);
		
	}

	public TextField getUsuario() {
		return usuario;
	}

	public TextField getContrasena() {
		return contrasena;
	}

	public Button getAcceder() {
		return acceder;
	}

	public Button getCancelar() {
		return cancelar;
	}
	
}
