package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Jugador;
import modelo.Partida;

class TestPartida {

	private Partida partida;
	
	void setupEscenario1() {
		partida = new Partida();
	}
	
	void setupEscenario2() {
		setupEscenario1();
		partida.agregarNuevoJugador("jugador1");
		partida.agregarNuevoJugador("jugador0");
	}
	
	void setupEscenario3() {
		setupEscenario1();
		partida.agregarNuevoJugador("jugador1");
		partida.agregarNuevoJugador("jugador0");
		partida.agregarNuevoJugador("jugador5");
	}
	
	void setupEscenario4() {
		setupEscenario1();
		partida.agregarNuevoJugador("jugador1");
		partida.agregarNuevoJugador("jugador3");
		partida.agregarNuevoJugador("jugador5");
		partida.agregarNuevoJugador("jugador6");
		partida.agregarNuevoJugador("jugador9");
		partida.agregarNuevoJugador("jugador7");
		partida.agregarNuevoJugador("jugador8");
		partida.agregarNuevoJugador("jugador0");
		partida.agregarNuevoJugador("jugador4");
		
	}
	
	@Test
	void testAgregarJugador1() {
		setupEscenario1();
		assertNull(partida.getRaiz());
		partida.agregarNuevoJugador("jugador1");
		assertNotNull(partida.getRaiz());
		
	}

	@Test
	void testSAgregarJugador2() {
		setupEscenario1();
		partida.agregarNuevoJugador("jugador1");
		partida.agregarNuevoJugador("jugador0");	
		assertEquals("jugador0", partida.getRaiz().getIzquierda().getNickname());
		
	}
	
	@Test
	void testAgregarJugador3() {
		setupEscenario1();
		partida.agregarNuevoJugador("jugador1");
		partida.agregarNuevoJugador("jugador0");
		partida.agregarNuevoJugador("jugador5");
		
//		Jugador a = new Jugador("jugador5" , 0 , null);
//		Jugador b = new Jugador("jugador0" , 0 , null);
//		System.out.println(a.compararPorNombre(b.getNickname()));

		assertEquals("jugador5", partida.getRaiz().getDerecha().getNickname());
		assertEquals("jugador0", partida.getRaiz().getIzquierda().getNickname());
		assertEquals("jugador1", partida.getRaiz().getNickname());
		
	}
	
//	@Test
//	void testAgregarJugador4() {
//		setupEscenario3();
//		
//		assertTrue(partida.validarJugadorExistente("jugador5"));
//		
//	}
	
	@Test
	void testAgregarJugador5() {
		setupEscenario4();
		assertEquals("jugador1", partida.getRaiz().getNickname());
		assertEquals("jugador0", partida.getRaiz().getIzquierda().getNickname());
		assertEquals("jugador3", partida.getRaiz().getDerecha().getNickname());
		assertEquals("jugador5", partida.getRaiz().getDerecha().getDerecha().getNickname());
		assertEquals("jugador4", partida.getRaiz().getDerecha().getDerecha().getIzquierda().getNickname());
		assertEquals("jugador6", partida.getRaiz().getDerecha().getDerecha().getDerecha().getNickname());
		assertEquals("jugador7", partida.getRaiz().getDerecha().getDerecha().getDerecha().getDerecha().getNickname());
		assertEquals("jugador8", partida.getRaiz().getDerecha().getDerecha().getDerecha().getDerecha().getDerecha().getNickname());
		assertEquals("jugador9", partida.getRaiz().getDerecha().getDerecha().getDerecha().getDerecha().getDerecha().getDerecha().getNickname());
	}
	
	
}
