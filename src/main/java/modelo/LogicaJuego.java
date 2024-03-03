package modelo;

public class LogicaJuego{

	private int[]valor_col,valor_fil;
	private Matriz MatrizJuego;
	
	//matriz por defecto
	public LogicaJuego() {	}

//------------------------------------------------------------GETTERS------------------------------------------------------------
	
	public Matriz getMatrizJuego(){
		return this.MatrizJuego;
	}

	public void setValor_col(int[] valor_col) {
		this.valor_col = valor_col;
	}

	public void setValor_fil(int[] valor_fil) {
		this.valor_fil = valor_fil;
	}

	public void setMatrizJuego(Matriz matrizJuego) {
		MatrizJuego = matrizJuego;
	}

	public int[] getValor_col() {
		
		return valor_col;
				//deevolver arreglo de entero valores.
	}

	public int[] getValor_fil() {
		 
		return this.valor_fil;
		// devolver arreglor de enteros valores
	}
 
	public void setFilasyColumnas(int filas,int columnas) {
		verificarDimensionDelJuego(filas,columnas);
		setMatrizJuego(new Matriz(filas,columnas));
		setValor_fil(new int [filas]);
		setValor_col(new int [columnas]);
		
	}
	public void clearValor_Col_Fil() {
		for(int fila=0;fila<getMatrizJuego().getFilas();fila++)
		{
			this.valor_fil[fila]= 0;
		}
		for(int columna=0;columna<getMatrizJuego().getColumnas();columna++)
		{
			this.valor_col[columna]=0;
		}
	}

	//------------------------------------------------------------CODE DE SEGURIDAD---------------------------------------------------------------------------------------------------------------------------------------------------

	private void verificarDimensionDelJuego(int filas,int columnas) {
		if(filas>8 && columnas>8)
			throw new IllegalArgumentException("El numero de filas y columnas no pueden ser mayor a 8");
		if(filas<4 && columnas<4)
			throw new IllegalArgumentException("El numero de filas y columnas no pueden ser menor a 4");
		if(filas>8 || filas<4)
			throw new IllegalArgumentException("eL numero de filas que puede generar el tablero van desde 4 a 8");
		if(columnas>8 || columnas<4)
			throw new IllegalArgumentException("El numero de columnas que puede generar el tablero van desde 4 a 8.");
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	public void generarValorReferecia() {
			MatrizJuego.GenerarMatrizRandom();
			//------------ -----------CHEAT-------------------------------------------------------
			System.out.print("Ayuda para comprobar ganador\n\n"+this.MatrizJuego.toString()); 
			//----------------------------------------------------------------------------------------			
			for(int fila=0;fila<getMatrizJuego().getFilas();fila++)
			{
				this.valor_fil[fila]= MatrizJuego.Suma_Fila(fila);
			}
			for(int columna=0;columna<getMatrizJuego().getColumnas();columna++)
			{
				this.valor_col[columna]=MatrizJuego.Suma_Columna(columna);
			}
			MatrizJuego.limpiarMatriz();
			
			
		}
 
	public boolean Ganador() {
		boolean ganador=true;
		for(int fila=0;fila<MatrizJuego.getFilas();fila++) { 
			ganador=ganador && MatrizJuego.Suma_Fila(fila)==this.valor_fil[fila];
			
		}
		for(int columna=0;columna<MatrizJuego.getColumnas();columna++) {
			ganador=ganador && MatrizJuego.Suma_Columna(columna)==this.valor_col[columna];
			
		}
		
		
		return ganador;
	}

}