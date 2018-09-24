package sena;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;

public class Impressao {
	public void imprimeJogos(List<Jogo> jogos){
		
		System.out.println("*******************************");
		System.out.println("CRITICAS %");
		System.out.println("Num total exemplares sorteados: " + jogos.size());
		
		ArrayList<Integer> listMotivos = new ArrayList<Integer>(Collections.nCopies(9, 0));

		for (Jogo jogo: jogos) {
			//System.out.println(jogo.remocao);
			//System.out.println(listMotivos.get(jogo.remocao));
			listMotivos.set(jogo.remocao, listMotivos.get(jogo.remocao)+1);
		}
		
		float perc=0;
		float contJogos=jogos.size();
		float contMotivos=0;
		
		for (int i=0;i<listMotivos.size();i++) {
			contMotivos=listMotivos.get(i);
			perc=contMotivos/contJogos*100;
			System.out.printf("Motivo %d (%s): %,f (%f exemplares)\n",i,TipoMotivos.values()[i],perc,contMotivos);
			
		}
		
		/*
		System.out.println("*******************************");
		System.out.println("APOSTAS premiadas");
		
		for (Jogo jogo: jogos) {
			if(jogo.remocao==0 && jogo.premiada==true){
				System.out.printf("Concurso %s : ", jogo.concurso);
				imprimeJogo(jogo.numsJogo);
			
			}
		}
		*/
		
		
		System.out.println("*******************************");
		System.out.println("APOSTAS");
		
		for (Jogo jogo: jogos) {
			if(jogo.remocao==0){
				//System.out.printf("Concurso %s : ", jogo.concurso);
				imprimeJogo(jogo.numsJogo);
			
			}
		}
		
		
	}
	
	public void imprimeJogo(SortedSet<Integer> jogo){
		for (Integer numero: jogo) {
			System.out.printf("%2d ", numero);
		}
		System.out.printf("\n");
	}
}
