package modelo;

import java.util.ArrayList;

/**
 * claase que representa una partida del juego donde se enfrentaran dos jugadores.
 * */
public class Partida {

	/**
	 * constante que representa la cantidad de personajes que hay en el arreglo. 
	 * */
	public final static int CANT_PERSONAJES = 2; 
	
	/**
	 * ArrayList donde se encuentran todos los jugadores que ingresen al juego.
	 * */
//	private ArrayList<Jugador> jugadores ; 
	/**
	 * arreglo donde se encuentra los dos personajes del juego. 
	 * */
	private Personaje[] personajes; 
	
	
	private Jugador raiz;
//	private Jugador ultimo;
	
	private int numJugadores;
	 
	/**
	 * constructor de la clase inicializa una partida.
	 * */
	public Partida() {
		
		
//		jugadores = new ArrayList<Jugador>();
		this.personajes = new Personaje[CANT_PERSONAJES]; 
		crearPersonajes(); 
	}

//	public ArrayList<Jugador> getJugadores() {
//		return jugadores;
//	}

//	public void setJugadores(ArrayList<Jugador> jugadores) {
//		this.jugadores = jugadores;
//	}

	public Personaje[] getPersonajes() {
		return personajes;
	}

	public Jugador getRaiz() {
		return raiz;
	}

	public void setraiz(Jugador raiz) {
		this.raiz = raiz;
	}

	/**
	 * este m�todo se encarga de inicializar a los personajes del juego 
	 * este m�todo quiza no este definido del todo se esta creando para 
	 * para probar si finciona el movimiento de los personajes 
	 * 
	 * */
	public void crearPersonajes() {
		personajes[0] = new Personaje(1000, true, 0, 200, 50, 50, Personaje.PRIMER_PERSONAJE); 
		personajes[1] = new Personaje(1000, true, 500,200,50,50, Personaje.SEGUNDO_PERSONAJE); 
		
	}
	
	
	public boolean validarExistente() {
			
		return false ;
		
	}
	

	public void agregarderecha(String nickName , Jugador auxRaiz) {
		
		Jugador nuevo = new Jugador(nickName, 0, "");
//		Jugador auxRaiz = raiz;
		boolean agrego = false ;
		while(!agrego){

			if(auxRaiz.getDerecha().compararPorNombre(nuevo.getNickname()) < 0) {
				auxRaiz.setDerecha(nuevo);
				agrego = true;
			}else
				auxRaiz = auxRaiz.getDerecha();
		}
		if(!agrego)
			agregarIzquierda(nickName, auxRaiz);
	}

	public void agregarIzquierda(String nickName, Jugador auxRaiz) {
		
		Jugador nuevo = new Jugador(nickName, 0, "");
//		Jugador auxRaiz = raiz;
		
		boolean agrego = false ;
		while(!agrego){
		
			if(auxRaiz.getIzquierda() ==  null)  
				auxRaiz.setIzquierda(nuevo);
			else
				auxRaiz = auxRaiz.getIzquierda();
		}
		
		if(!agrego)
			agregarderecha(nickName, auxRaiz);
		
	}

	public void agregarNuevoJugador(String nickName) {
		
		Jugador nuevo = new Jugador(nickName, 0, "");
		Jugador auxRaiz = raiz;
		
		if (raiz == null) {
			raiz = nuevo;
			
		} else {
			
			if (auxRaiz.compararPorNombre(nickName) < 0) 
				agregarderecha(nickName, auxRaiz);
			else 
				agregarIzquierda(nickName, auxRaiz);			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * validarJugadorExistente(nickName : String ) : boolean 
	 * 
	 * el metodo valida si un jagador existe o no en la lista de jugadores 
	 * 
	 * pre = la lsta de jugadores no esta vacia (lista != null, o por lo menos tiene un jugador)
	 * 
	 * @param nickName : String = el nombre del jugador a buscar en la lista.
	 * @return existe : boolean = true = si el jugador existe en la lista 
	 * 				 			= false = si el jugador no existe en la lista
	 * */
//	
//	public boolean validarJugadorExistente(String nickName) {
//		
//		Jugador nuevo = new Jugador(nickName, 0, "");
//		Jugador auxprimero = raiz;
//		boolean existe = false ;
//		int contador = 0;
//		
//		while(!existe && (contador < numJugadores+1 )) {
//			if(nuevo.compararPorNombre(auxprimero.getNickname()) == 0) {
//				existe = true;
//				nuevo.setPuntaje(auxprimero.getPuntaje());
//			}
//			else {
//				auxprimero = auxprimero.getSiguiente();
//				contador++;
//			}
//		}
//		
//		return existe;
//	}
//	
	/*
	 * aniadirNuevoJuagdor(nickName : String ): void 
	 * el metodo agrega un nuevo jugador de mayor menor
	 * 
	 * pre = el nuevo jugador no existe dentro de la lista (su nombre no es igual a 
	 * uno que ya existe)
	 * 
	 * pos = el nuevo jugador fue agregado
	 * 
	 * @param = nickname : String - representa el nombre del nuevo jugador a agregar 
	 *  
	 * */
	
//	public void aniadirNuevoJuagdor(String nickName) {
//		
//		Jugador nuevo = new Jugador(nickName, 0, "");
//		Jugador auxprimero = raiz;
//		boolean agregado = false ;
//		
//		//VALIDA SI LA LISTA ESTA VACIA
//		if(primero == null) {
//			primero = nuevo;
//			primero.setAnterior(primero);
//			primero.setSiguiente(primero);
//			ultimo = primero;
//			numJugadores++;
//			agregado = true;
//			
//		}
//		
//		//AGREGA 
//		else {
//			while(!validarJugadorExistente(nickName) && !agregado) {
//			
//			//VALIDA SI ES MAYOR QUE EL PRIMERO
//			if(nuevo.compararPorNombre(primero.getNickname()) > 0) {
//				nuevo.setAnterior(ultimo);
//				nuevo.setSiguiente(primero);
//				setPrimero(nuevo);
//				numJugadores++;
//				agregado = true;
//			}
//			//VALIDA SI ES MENOR QUE EL ULTIMO 
//			else if (nuevo.compararPorNombre(ultimo.getNickname()) < 0) {
//				nuevo.setAnterior(ultimo);
//				nuevo.setSiguiente(primero);
//				setUltimo(nuevo);
//				numJugadores++;
//				agregado = true;
//			}
//			//EL NUEVO JUGADOR ESTARA EN MEDIO DE LA LISTA 
//			else if (nuevo.compararPorNombre(auxprimero.getNickname()) < 0) {
//				nuevo.setAnterior(auxprimero);
//				nuevo.setSiguiente(auxprimero.getSiguiente());
//				numJugadores++;
//				agregado = true;
//			}
//			//SI NO ES MENOR QUE auxPrimero LO COMPARA CON EL SIGUIENTE
//			else 
//				auxprimero = auxprimero.getSiguiente();
//			}
//			
//		}//FIN VALIDACION EXISTE
//	
//	}// FIN DEL METODO
	
	
	
	
	
	
	
	
	
	
	
	
}
