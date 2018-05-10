package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import hilos.MoverImagen;
import modelo.Partida;
import modelo.Personaje;

public class Principal extends JFrame {

	private Partida partida; 
	
	private JLabel fondo;
	
	private JLabel labPersonaje1; 
	private JLabel labPersonaje2; 
	private Animacion animacion1 ; 
	private Animacion animacion2; 
	
	private Personaje personajeActual;
	private Personaje p1;
	private Personaje p2;
	
	
	
	private boolean esprimero;
	private boolean esSegundo;
	
	private MoverImagen hilo1;
	private MoverImagen hilo2;
	
	private int estadoKey1;
	private int estadoKey2;
	
	
	/**
	 * variable de control que ayuda a cambiar las imagenes de los personajes. 
	 * */
	private int controlImagen1;
	private int controlImagen2;
	
	private String derecha1;
	private String izquierda1;
	
	
	private String[] keys1 = new String[4];
	private String[] keys2 = new String[4];
	
	private String derecha2;
	private String izquierda2;
	
	private String keyActual;
	
	private DialogoInicio inicio;
	
	
	public Principal() {
		super(" Jack .VS. Jack ");
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize(800, 375);
				
		labPersonaje1 = new JLabel();
		labPersonaje2 = new JLabel();
		fondo = new JLabel();
		
		fondo.setIcon(new ImageIcon("data/escenarios/3.gif"));
		labPersonaje1.setIcon(new ImageIcon("data/jackImg/derecha/1.png"));
		labPersonaje2.setIcon(new ImageIcon("data/jackImg/izquierda/1.png"));
		
        getContentPane().add(labPersonaje1);
        labPersonaje1.setBounds(20, 530, 50, 106);
        
        getContentPane().add(labPersonaje2);
        labPersonaje2.setBounds(320, 530, 51, 106);
        
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 800, 336);
		
		partida = new Partida(); 
		inicio = new DialogoInicio(this);
		controlImagen1 = 1;
		controlImagen2 = 2;
	
		keysPersonajeUno();
		keysPersonaje2();	
		asignarMovimientos (); 
		
	}
	
	public void asignarEstadoKey(int key, String k)
	{
		determinarPersonaje(k);
		
		if(personajeActual==p1)
		{
			estadoKey1=key;
		}
		else {
			estadoKey2=key;
		}
	}
	
	
	public int darEstadoKey1()
	{
		return estadoKey1;
	}
	
	
	public int darEstadoKey2()
	{
		return estadoKey2;
	}
	

	
	public Personaje[] darPersonajesDeLaPartida() {
		return partida.getPersonajes(); 
	}
	
	public JLabel getLabPersonaje1() {
		return labPersonaje1;
	}

	public void setLabel(JLabel labPersonaje1) {
		this.labPersonaje1 = labPersonaje1;
	}

	public JLabel getlabPersonaje2() {
		return labPersonaje2;
	}

	public void setlabPersonaje2(JLabel labPersonaje2) {
		this.labPersonaje2 = labPersonaje2;
	}

	public DialogoInicio getDialogoInicio() {
		return inicio;
	}


	/**
	 * este metodo define los movimientos de los personajes 
	 * */
	public void asignarMovimientos () {
		
		 p1 = partida.getPersonajes()[0]; 
		 p2 = partida.getPersonajes()[1];
		
		labPersonaje1.setSize(labPersonaje1.getPreferredSize());
		labPersonaje1.setLocation(p1.getPosX(), p1.getPosY());
		
		animacion1 = new Animacion(labPersonaje1, 24,this);

		animacion1.Accion(keysPersonajeUno()[0], -3,  0);
		animacion1.Accion(keysPersonajeUno()[1],  3,  0);
	
		labPersonaje2.setSize( labPersonaje2.getPreferredSize() );
		labPersonaje2.setLocation(p2.getPosX(), p2.getPosY());
		
		animacion2 = new Animacion(labPersonaje2, 24,this);
		animacion2.Accion(keysPersonaje2()[0], -3,  0);
		animacion2.Accion(keysPersonaje2()[1],  3,  0);
		
	}
	
	public int moverX(int deltaX, int deltaXdx) {
	 return partida.getPersonajes()[0].moverEnX(deltaX, deltaXdx);
	}
	
	public int moverY(int deltaY, int deltaYdy) {
		 return partida.getPersonajes()[0].moverEnX(deltaY, deltaYdy);
	}
	
	public int moverX1(int deltaX, int deltaXdx) {
		 return partida.getPersonajes()[0].moverEnX(deltaX, deltaXdx);
	}
		
	public int moverY1(int deltaY, int deltaYdy) {
		return partida.getPersonajes()[0].moverEnX(deltaY, deltaYdy);	
	}
		
	public String[] imagenesDerecha() {		
		String[] derecha = new String[9];
			for (int i = 0; i < derecha.length; i++) {
				derecha[i] = "data/img/derecha/"+i+".gif";
			}
		return derecha;
	}
	
	public void determinarPersonaje(String key)
	{
		boolean terminar = false;
		
		keyActual = key;
		
		for(int i=0;i<darKeys1().length && !terminar;i++)
		{
			if(darKeys1()[i].equals(key))
			{
				personajeActual=p1;
				terminar = true;
			}
			
		}
		
		if(terminar==false)
		{
			personajeActual=p2;
		}
	}
			
	public String[] keysPersonajeUno() {

		String left = "LEFT";
		String right = "RIGHT";
		String up = "UP";
		String down = "DOWN";
		
		
		keys1[0] = left;
		keys1[1] = right;
		keys1[2] = up;
		keys1[3] = down;
		
		return keys1;
	}

	public String[] keysPersonaje2() {

		String a = "A";
		String d = "D";
		String w = "W";
		String s = "S";
		
		keys2[0] = a;
		keys2[1] = d;
		keys2[2] = w;
		keys2[3] = s;

		return keys2;
	}
	
	public String[] darKeys1()
	{
		return keys1;
	}
	
	public String[] darKeys2()
	{
		return keys2;
	}
	
	
	public void moverPersonaje()
	{
		if(personajeActual==p1)
		{
			hilo1 = new MoverImagen(this);
			hilo1.start();
		}
		
		else
		{
			hilo2 = new MoverImagen(this);
			hilo2.start();
		}
	}
	
	public void parar() {
		if(personajeActual==p1)
		{
			hilo1.parar();
		}else
		{
			hilo2.parar();
		}
		
	}

	public boolean getEsPrimero() {
		return esprimero;
	}
	
	public boolean getEsSegundo() {
		return esSegundo;
	}
	
//	public void detenerHilo()
//	{
//
//		if(personajeActual==p1)
//		{
//			if(estadoKey1==0)
//			{
//				
//				hilo1.interrupt();
//			}
//		}
//		
//		else
//		{
//			if(estadoKey2==0)
//			{
//				
//				hilo2.interrupt();
//			}
//		}
//	}
	
	public void pintarImagen() {
		
		if(personajeActual==p1)
		{		
			if(keyActual.equals(keysPersonajeUno()[1]))
			{
				ImageIcon icon = new ImageIcon("data/jackImg/derecha/"+controlImagen1+".png");
				labPersonaje1.setIcon(icon);
				controlImagen1++; 
				if (controlImagen1 > 6) {
					
					controlImagen1 = 1; 
				}
				
			}
			else if(keyActual.equals(keysPersonajeUno()[0]))
			{
				ImageIcon icon = new ImageIcon("data/jackImg/izquierda/"+controlImagen1+".png");
				labPersonaje1.setIcon(icon);
				controlImagen1++; 
				if (controlImagen1 > 6) {
					controlImagen1 = 1; 
				}
			}
			
//			detenerHilo();
			
		}
		

		else
		{
			if(keyActual.equals(keysPersonaje2()[1]))
			{
				ImageIcon icon = new ImageIcon("data/jackImg/derecha/"+controlImagen2+".png");
				labPersonaje2.setIcon(icon);
				controlImagen2++; 
				if (controlImagen2 > 6) {
					controlImagen2 = 1; 
				}
			}
			else if(keyActual.equals(keysPersonaje2()[0]))
			{
				ImageIcon icon = new ImageIcon("data/jackImg/izquierda/"+controlImagen2+".png");
				labPersonaje2.setIcon(icon);
				controlImagen2++; 
				if (controlImagen2 > 6) {
					controlImagen2 = 1; 
				}
			}
//			detenerHilo();
		}
		
	}
		
	public static void main(String[] args)
	{
		Principal p = new Principal();
		DialogoInicio comenzar = p.getDialogoInicio();
		
		comenzar.setVisible(true);
		
	}	
	
}