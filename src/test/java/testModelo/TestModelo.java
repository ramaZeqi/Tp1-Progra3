package testModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.LogicaJuego;
import modelo.Matriz;

public class TestModelo {


	@Test(expected=IllegalArgumentException.class)
	public void DimensionMayorAlRequeridoTest() {
		LogicaJuego aux=new LogicaJuego();		
		aux.setFilasyColumnas(12, 12);
		 
	}
	@Test(expected=IllegalArgumentException.class)
	public void MasFilasRequeridasTest() {
		LogicaJuego aux=new LogicaJuego();
		aux.setFilasyColumnas(9, 5);
		 
	}
	@Test(expected=IllegalArgumentException.class)
	public void MenosFilasRequeridasTest() {
		LogicaJuego aux=new LogicaJuego();
		aux.setFilasyColumnas(3, 5);

	}
	@Test(expected=IllegalArgumentException.class)
	public void MasColumnasRequeridasTest() {
		LogicaJuego aux=new LogicaJuego();	
		aux.setFilasyColumnas(5, 9);
	}
	@Test(expected=IllegalArgumentException.class)
	public void MenosColumnasRequeridasTest() {
		LogicaJuego aux=new LogicaJuego();
		aux.setFilasyColumnas(5,3);
	}	
	@Test
	public void ganadorTest() {
		LogicaJuego aux=new LogicaJuego();
		aux.setFilasyColumnas(4, 4);
		aux.getMatrizJuego().IngresarValor(0,0, 5);
		aux.getMatrizJuego().IngresarValor(1,0, 4);
		aux.getMatrizJuego().IngresarValor(2,0, 3);
		aux.getMatrizJuego().IngresarValor(3,0, 3);
		aux.clearValor_Col_Fil();
		aux.getValor_col()[0]=15;
		aux.getValor_fil()[0]=5;
		aux.getValor_fil()[1]=4;
		aux.getValor_fil()[2]=3;
		aux.getValor_fil()[3]=3;
		assertTrue(aux.Ganador());
		
	}

	
	@Test
	public void TomarValorTest() {
		Matriz aux=new Matriz(3,3);
		aux.IngresarValor(2,2,1);
		assertEquals(1,aux.TomarValor(2,2));
		
	}
	@Test
	public void ValorDespuesDeAgregar2IndexTest() {
		Matriz aux=new Matriz(3,3);
		aux.IngresarValor(2,1,1);
		aux.IngresarValor(2,2,3);
		assertEquals(1,aux.TomarValor(2,1));
		
	}
	@Test
	public void ValorDespuesDeActualizarIndexTest() {
		Matriz aux=new Matriz(3,3);
		aux.IngresarValor(2,2,3);
		aux.IngresarValor(2,2,1);
		assertEquals(1,aux.TomarValor(2,2));
		
	}
	
	@Test
	public void TomarValorNoAgregadoTest() {
		Matriz aux=new Matriz(3,3);
		int valor=aux.TomarValor(2,2);
		assertEquals(0,valor);
		
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void TomarValorFueraDeIndice() {
		Matriz aux=new Matriz(3,3);
		int valor=aux.TomarValor(2,3);
	}
	@Test
	public void SumaFilaTest() {
		Matriz aux=new Matriz(3,3);
		aux.IngresarValor(0,0,2);
		aux.IngresarValor(0,1,2);
		aux.IngresarValor(0,2,2);
		assertEquals(6,aux.Suma_Fila(0));
		
	}
	@Test
	public void SumaFilaConUnAgregarOmitidoTest() {
		Matriz aux=new Matriz(3,3);
		aux.IngresarValor(0,0,2);
		//aux.AgregarValor(0,1,2);
		aux.IngresarValor(0,2,2);
		assertEquals(4,aux.Suma_Fila(0));
		
	}
	@Test
	public void SumaColumnaTest() {
		Matriz aux=new Matriz(3,3);
		aux.IngresarValor(0,1,2);
		aux.IngresarValor(1,1,2);
		aux.IngresarValor(2,1,2);
		assertEquals(6,aux.Suma_Columna(1));
		
	}
	@Test
	public void SumaColumnaConUnAgregarOmitidoTest() {
		Matriz aux=new Matriz(3,3);
		aux.IngresarValor(0,1,2);
		//aux.AgregarValor(0,1,2);
		aux.IngresarValor(2,1,2);
		assertEquals(4,aux.Suma_Columna(1));
		
	}



}
