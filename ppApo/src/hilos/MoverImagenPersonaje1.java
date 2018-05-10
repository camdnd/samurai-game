package hilos;

import javax.swing.ImageIcon;

import interfaz.Principal;

public class MoverImagenPersonaje1 extends Thread{

	
	private Principal principal;
	private int controlImagen;
	private boolean mover = true;
	
	
	public MoverImagenPersonaje1(Principal principal, int controlImagen) {
		
		this.principal = principal;
		this.controlImagen = controlImagen;
//		mover = true;
		
	}
	
	public void run () {
	
		boolean sentinela = false ;
		
		while( mover && !sentinela) {


		
			try {

			for (int i = 0; i < principal.imagenesDerecha().length; i++) {
				
				ImageIcon icon = new ImageIcon(principal.imagenesDerecha()[0]); 
				principal.getLabPersonaje1().setIcon(icon); 
				
			}	
				
				
				
//			principal.pintarImagen();
				Thread.sleep(59);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		
//			ImageIcon icon = new ImageIcon(principal.imagenesDerecha()[controlImagen-1]); 
//			principal.getLabPersonaje1().setIcon(icon);
//			
//			controlImagen++; 
//			if (controlImagen > 9) {
//				controlImagen = 1; 
//			}

		}
		
	}
	
	public void parar() {
		mover = false ;
	}
	
	private boolean detener() {
		return mover;
	}
	
	
	
}
