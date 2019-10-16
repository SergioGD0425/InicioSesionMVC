package dad.javafx.iniciosesionmvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {
	
	private Model model = new Model();
	private View root = new View();
	
	public Controller() {
		model.usuarioProperty().bind(root.getUsuario().textProperty());
		
		model.contrasenaProperty().bind(root.getContrasena().textProperty());
		
		root.getAcceder().setOnAction(e->onAccederButton(e));
		root.getCancelar().setOnAction(e->onCancelarbutton(e));
	}

	private void onCancelarbutton(ActionEvent e) {
		Platform.exit();
	}

	private void onAccederButton(ActionEvent e) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Inicio sesion");
		alert.setHeaderText("Acceso denegado");
		alert.setContentText("El usuario y/o la contraseña no son válidos");
		
		File pass = new File("users.csv");
		FileReader fin=null; 
		BufferedReader in=null;
		String[] aux;
		String aux2;
		boolean encontrado=false;
		
		try {
			fin = new FileReader(pass);
			in = new BufferedReader(fin);
			
			while((aux2=in.readLine())!=null && !encontrado) {
				aux=aux2.split(",");
				if(model.getUsuario().equals(aux[0])) {
					if(DigestUtils.md5Hex(model.getContrasena()).toUpperCase().equals(aux[1])) {
						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Inicio sesion");
						alert.setHeaderText("Acceso permitido");
						alert.setContentText("Las credenciales de acceso son válidas");
						encontrado = !encontrado;
						alert.showAndWait();
						Platform.exit();
					}else {
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Inicio sesion");
						alert.setHeaderText("Acceso denegado");
						alert.setContentText("El usuario y/o la contraseña no son válidos");
						alert.show();
						root.getContrasena().setText("");
					}
				}
			}
			if(!encontrado) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Inicio sesion");
				alert.setHeaderText("Acceso denegado");
				alert.setContentText("El usuario y/o la contraseña no son válidos");
				alert.show();
				root.getContrasena().setText("");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			try {
				in.close();
				fin.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public View getRoot() {
		return root;
	}
}
