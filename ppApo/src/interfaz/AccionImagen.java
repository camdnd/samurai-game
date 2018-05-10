package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;

public class AccionImagen extends AbstractAction implements ActionListener{

	private int image;
	
	private Animacion animacion;

	
	public AccionImagen(String key,int image, Animacion animacion) {
		super(key);
		this.image = image;
		this.animacion = animacion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
//		animacion.changeImage((String)getValue(NAME), image);
		
	}

}
