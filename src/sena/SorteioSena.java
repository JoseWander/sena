package sena;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SorteioSena {
	

	public static void main(String[] args) {
		
		List<Jogo> jogos=new ArrayList<Jogo>();
		Processo processo=new Processo();
		Impressao impressao=new Impressao();
		ReadCsv readCsv=new ReadCsv();
		List<Jogo> jogosSalvos=readCsv.readCcv();
		
		int numJogos=1000;
		int numNumeros=6;
		int numMinPares=2;
		int numMaxPares=4;
		int numTercos=3;
		int somaMenos=137;
		int somaMais=228;
		int numMaxIguais=5;
		int numMax3=3;
		int numMax57=2;
		
	
		for (int i=0; i<numJogos; i++) {
			Jogo jogo=new Jogo();
			jogo.concurso=Integer.toString(i+1);
			jogo.numsJogo=processo.sorteioJogo(numNumeros);
			jogo.numPares=processo.contaPares(jogo.numsJogo);
			jogo.soma=processo.soma(jogo.numsJogo);
			jogo.numTercos=processo.numTercos(jogo.numsJogo);
			jogos.add(jogo);
		}

		//17 18 27 32 39 58
		SortedSet<Integer> numsUltJogo=new TreeSet<Integer>();
		numsUltJogo.add(17);
		numsUltJogo.add(18);
		numsUltJogo.add(27);
		numsUltJogo.add(32);
		numsUltJogo.add(39);
		numsUltJogo.add(58);
		List<Jogo> ultJogo=new ArrayList<Jogo>();
		Jogo jogo_=new Jogo();
		jogo_.numsJogo=numsUltJogo;
		ultJogo.add(jogo_);
		
		int numPares;
		int cont=0;
		
		for (Jogo jogo: jogos) {
			

			
			if(processo.numTercos(jogo.numsJogo)!=numTercos){
				jogo.remocao=TipoMotivos.DISTRIB.getValor();
				continue;
			}
			
			if(processo.jaSortedeados(jogo.numsJogo,jogosSalvos,numMaxIguais)){
				jogo.remocao=TipoMotivos.JA_FOI_SORTEADO.getValor();
				continue;
			}
			
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
			
			if(!processo.checaDiv357(jogo.numsJogo, numMax3, numMax57)){
				jogo.remocao=TipoMotivos.DIV357.getValor();
				continue;
			}
			
			numPares=processo.contaPares(jogo.numsJogo);
			if(numPares<numMinPares || numPares>numMaxPares){
				jogo.remocao=TipoMotivos.PARES.getValor();
				continue;
			}
			
			
			if(jogo.soma<somaMenos || jogo.soma>somaMais){
				jogo.remocao=TipoMotivos.MEDIA.getValor();
				continue;
			}
			
			if(processo.jaSortedeados(jogo.numsJogo,ultJogo,5)){
				System.out.println("> " + jogo.numsJogo);
			}
			cont++;
		}
		//System.out.println(cont );
		//System.out.println(cont * 3.5);
		impressao.imprimeJogos(jogos);
			
	}


}
