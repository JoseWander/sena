package sena;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SorteioLotoFacil {
	

	public static void main(String[] args) {
		
		List<Jogo> jogos=new ArrayList<Jogo>();
		Processo processo=new Processo();
		Impressao impressao=new Impressao();
		ReadCsv readCsv=new ReadCsv();
		List<Jogo> jogosSalvos=readCsv.readCcvLotoFacil();
		
		int numJogos=100;
		int numNumeros=15;
		int numMinPares=6;
		int numMaxPares=8;
		int numQuintos=5;
		int somaMenos=137;
		int somaMais=228;
		int numMaxIguais=14;
		int numMax3=6;
		int numMax57=4;
		
	
		for (int i=0; i<numJogos; i++) {
			Jogo jogo=new Jogo();
			jogo.concurso=Integer.toString(i+1);
			jogo.numsJogo=processo.sorteioJogoLotoFacil(numNumeros);
			jogo.numPares=processo.contaPares(jogo.numsJogo);
			//jogo.soma=processo.soma(jogo.numsJogo);
			jogo.numQuintos=processo.numQuintos(jogo.numsJogo);
			jogos.add(jogo);
		}

		/*
		//2001,03/01/2018,20,22,36,42,52,60
		SortedSet<Integer> numsUltJogo=new TreeSet<Integer>();
		numsUltJogo.add(20);
		numsUltJogo.add(22);
		numsUltJogo.add(36);
		numsUltJogo.add(42);
		numsUltJogo.add(52);
		numsUltJogo.add(60);
		*/
		
		int numPares;
		
		for (Jogo jogo: jogos) {
			
			if(!processo.checaDiv357(jogo.numsJogo, numMax3, numMax57)){
				jogo.remocao=TipoMotivos.DIV357.getValor();
				continue;
			}
			
			if(processo.jaSortedeados(jogo.numsJogo,jogosSalvos,numMaxIguais)){
				jogo.remocao=TipoMotivos.JA_FOI_SORTEADO.getValor();
				continue;
			}
			
			numPares=processo.contaPares(jogo.numsJogo);
			if(numPares<numMinPares || numPares>numMaxPares){
				jogo.remocao=TipoMotivos.PARES.getValor();
				continue;
			}
				
			
			if(processo.numQuintos(jogo.numsJogo)!=numQuintos){
				jogo.remocao=TipoMotivos.DISTRIB.getValor();
				continue;
			}
			

			
			/*
			if(!processo.checaNumDuplos(jogo.numsJogo)){
				jogo.remocao=TipoMotivos.NUM_DUPLOS.getValor();
				continue;
			}
			
			if(!processo.checaFibo(jogo.numsJogo)){
				jogo.remocao=TipoMotivos.FIBO.getValor();
				continue;
			}
			
			if(!processo.checaSeq(jogo.numsJogo)){
				jogo.remocao=TipoMotivos.SEQUENCIAIS.getValor();
				continue;
			}
			

			if(jogo.soma<somaMenos || jogo.soma>somaMais){
				jogo.remocao=TipoMotivos.MEDIA.getValor();
				continue;
			}
			*/
		}
		
		impressao.imprimeJogos(jogos);
			
	}


}
