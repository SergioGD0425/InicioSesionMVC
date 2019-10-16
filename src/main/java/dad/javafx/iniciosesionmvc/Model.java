package dad.javafx.iniciosesionmvc;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	
	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty contrasena = new SimpleStringProperty();
	
	public final StringProperty usuarioProperty() {
		return this.usuario;
	}
	
	public final String getUsuario() {
		return this.usuarioProperty().get();
	}
	
	public final void setUsuario(final String usuario) {
		this.usuarioProperty().set(usuario);
	}
	
	public final StringProperty contrasenaProperty() {
		return this.contrasena;
	}
	
	public final String getContrasena() {
		return this.contrasenaProperty().get();
	}
	
	public final void setContrasena(final String contrasena) {
		this.contrasenaProperty().set(contrasena);
	}
	
	
	
}
