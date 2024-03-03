package modelo;

import java.util.Random;

public class Matriz {

	int [][] matriz;
	int Filas;
	int Columnas;
	public Matriz(int filas, int columnas) {
		Filas=filas;
		Columnas=columnas;
		matriz=new int[filas][columnas];				
	}
	
	public int[][] getMatriz() {
		return matriz;
	}
	
	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	public void setFilas(int filas) {
	Filas = filas;
	}	
	public void setColumnas(int columnas) {
	Columnas = columnas;
	}	
	public int getFilas() {
		return Filas;
	}
	public int getColumnas() {
		return Columnas;
	}

 
//--------------------------------------------------------------------------
	
	public void IngresarValor(int fila,int columna,int value) {
		matriz[fila][columna]= value;
	}
	public int TomarValor(int fila,int columna) {
		return matriz[fila][columna];
	}
	public int Suma_Columna(int columna) {
		 
		int suma=0;
		for(int Fila=0;Fila<this.getFilas();Fila++) 
		{
			suma+=TomarValor(Fila,columna);
		}
		return suma;

	}
	public int Suma_Fila(int fila) {
		 
			int suma=0;
			for(int Columna=0;Columna<this.getColumnas();Columna++)
			{
				suma+=TomarValor(fila,Columna);
			}
			return suma;
		
	}
	public void GenerarMatrizRandom() 
	{
		Random random=new Random();
		for(int fila=0;fila<getFilas();fila++)
		{
			for(int columna=0;columna<getColumnas();columna++)
			{
				IngresarValor(fila, columna, random.nextInt(9)+1);
			}
		}
		
	}
	public void limpiarMatriz() 
	{
		
		for(int fila=0;fila<getFilas();fila++)
		{
			for(int columna=0;columna<getColumnas();columna++)
			{
				IngresarValor(fila, columna, 0);
			}
		}
	}
	@Override
	public String toString()
	{
		StringBuilder aux=new StringBuilder();
		for(int fila=0;fila<this.Filas;fila++)
		{
			for(int columna=0;columna<this.Columnas;columna++)
			{
				aux.append(this.TomarValor(fila, columna));
				aux.append("	");
			}
			aux.append("\n");
		}
		return aux.toString();
	}
}
