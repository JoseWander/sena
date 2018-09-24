package sena;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class AvalicaoLotoFacil {
	

	public static void main(String[] args) {
		
		List<Jogo> jogos=new ArrayList<Jogo>();
		ReadCsv readCsv=new ReadCsv();
		jogos=readCsv.readCcvLotoFacil();
		Processo processo=new Processo();
		int numDezenas=15;
		double numParesMedia=0;
		double numQuartosMedia=0;
		double numTercosMedia=0;
		double somaMedia=0;

		for (Jogo jogo: jogos) {
			jogo.numPares=processo.contaPares(jogo.numsJogo);
			jogo.numQuintos=processo.numQuintos(jogo.numsJogo);
		}
		
		
		System.out.println("ANALISE QUINTOS");

		int numQuintos[] = new int[5]; 
		
		for (Jogo jogo: jogos) {
			//System.out.println(jogo.numQuintos);
			numQuintos[jogo.numQuintos-1]++; 
		}
		
		
		for (int i=0;i<numQuintos.length;i++) {
			System.out.println("perc numQuintos  " + (i+1) + ":" + numQuintos[i] + "(" + ((double)numQuintos[i]/jogos.size()*100) + "%)");
		}
		
		System.out.println("ANALISE PARES");

		int numPares[] = new int[15]; 
		
		for (Jogo jogo: jogos) {
			numPares[jogo.numPares-1]++; 
		}
		
		
		for (int i=0;i<numPares.length;i++) {
			System.out.println("perc numPares  " + (i+1) + ":" + numPares[i] + "(" + ((double)numPares[i]/jogos.size()*100) + "%)");
		}
		
		
		
	}


}
