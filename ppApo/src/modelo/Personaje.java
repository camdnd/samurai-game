package modelo;

/**
 * esta clase define los atributos de los personajes del juego 
 * */

public class Personaje {

	/** 
	 * Constante que define al primer personaje y lo diferencia del segundo.
	 * */
	public static final String PRIMER_PERSONAJE = "PRIMER_PERSONAJE";
	/** 
	 * Constante que define al segundo personaje y lo diferencia del primero.
	 * */
	public static final String SEGUNDO_PERSONAJE = "SEGUNDO_PERSONAJE";
	
	/** 
	 * define la cantidad de vida que tiene el personaje. 
	 * */
	private int vida; 
	/** 
	 * define si el personaje ha muerto o sigue vivo si es derrotado este atributo cambia a false.
	 * */
	private boolean esVivo;
	/**
	 * define la poscición en X del personaje en pantalla.
	 * */
	private int posX; 
	/** 
	 * define la poscición en Y del personaje en pantalla.
	 * */
	private int posY; 
	/** 
	 * define la distancia que hay desde posX hasta el ancho del personaje 
	 * */
	private int areaX; 
	/** 
	 * define la distancia que hay desde posY hasta el alto del personaje 
	 * */
	private int areaY;
	/**
	 * define de que personaje se trata toma el valor de un ade las constantes
	 * */
	private String id; 
	
	/**
	 * constructor de la clase inicializa los atributos del personaje.
	 * */
	public Personaje(int vida, boolean esVivo, int posX, int posY, int areaX, int areaY, String id) {
		this.vida = vida;
		this.esVivo = esVivo;
		this.posX = posX;
		this.posY = posY;
		this.areaX = areaX;
		this.areaY = areaY;
		this.id = id; 
	}

	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public boolean isEsVivo() {
		return esVivo;
	}

	public void setEsVivo(boolean esVivo) {
		this.esVivo = esVivo;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getAreaX() {
		return areaX;
	}

	public void setAreaX(int areaX) {
		this.areaX = areaX;
	}

	public int getAreaY() {
		return areaY;
	}

	public void setAreaY(int areaY) {
		this.areaY = areaY;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int moverEnX(int deltaX, int deltaXdx) {
		return deltaX += deltaXdx;
	}

	public int moverEnY(int deltaY, int deltaYdx) {
		return deltaY += deltaYdx;
	}
	
}
