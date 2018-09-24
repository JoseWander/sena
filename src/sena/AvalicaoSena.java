package sena;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class AvalicaoSena {
	

	public static void main(String[] args) {
		
		List<Jogo> jogos=new ArrayList<Jogo>();
		ReadCsv readCsv=new ReadCsv();
		jogos=readCsv.readCcv();
		Processo processo=new Processo();
		int numDezenas=6;
		double numParesMedia=0;
		double numQuartosMedia=0;
		double numTercosMedia=0;
		double somaMedia=0;

		for (Jogo jogo: jogos) {
			jogo.numPares=processo.contaPares(jogo.numsJogo);
			jogo.soma=processo.soma(jogo.numsJogo);
			jogo.numQuartos=processo.numQuartos(jogo.numsJogo);
			jogo.numTercos=processo.numTercos(jogo.numsJogo);
	
			numParesMedia=numParesMedia+jogo.numPares;
			numQuartosMedia=numParesMedia+jogo.numQuartos;
			numTercosMedia=numParesMedia+jogo.numTercos;
			somaMedia=somaMedia+jogo.soma;
		}
		
		System.out.println("numsorteios " + jogos.size());
		
		numParesMedia=numParesMedia/jogos.size();
		numQuartosMedia=numQuartosMedia/jogos.size();
		numTercosMedia=numTercosMedia/jogos.size();
		somaMedia=somaMedia/jogos.size();
		
		System.out.println("numParesMedia " + numParesMedia);
		System.out.println("numQuartosMedia " + numQuartosMedia);
		System.out.println("numTercosMedia " + numTercosMedia);
		System.out.println("somaMedia " + somaMedia);
		
		//perc numQuartos
		//2 = 6.3968015992003995
		//3 = 50.524737631184415
		//4 = 43.02848575712144


		int numQuarto2=0;
		int numQuarto3=0;
		int numQuarto4=0;
		
		for (Jogo jogo: jogos) {
			
			if(jogo.numQuartos==2) numQuarto2++;
			if(jogo.numQuartos==3) numQuarto3++;
			if(jogo.numQuartos==4) numQuarto4++;
		}
				
		System.out.println("perc numQuartos 2 " + (double)numQuarto2/jogos.size()*100);
		System.out.println("perc numQuartos 3 " + (double)numQuarto3/jogos.size()*100);
		System.out.println("perc numQuartos 4 " + (double)numQuarto4/jogos.size()*100);
		
		//perc numTercos
		//1 = 0.14992503748125938
		//2 = 22.588705647176415
		//3 = 77.26136931534234


		int numTerco1=0;
		int numTerco2=0;
		int numTerco3=0;
		
		for (Jogo jogo: jogos) {
			
			if(jogo.numTercos==1) numTerco1++;
			if(jogo.numTercos==2) numTerco2++;
			if(jogo.numTercos==3) numTerco3++;
		}
				
		System.out.println("perc numTerco 1 " + (double)numTerco1/jogos.size()*100);
		System.out.println("perc numTerco 2 " + (double)numTerco2/jogos.size()*100);
		System.out.println("perc numTerco 3 " + (double)numTerco3/jogos.size()*100);
		
		//perc numPares
		//1 = 9.095452273863067
		//2 = 24.137931034482758
		//3 = 30.284857571214392
		//4 = 24.387806096951525
		//5 = 9.795102448775612


		int numPares2=0;
		int numPares3=0;
		int numPares4=0;
		int numPares1=0;
		int numPares5=0;
		
		for (Jogo jogo: jogos) {
			
			if(jogo.numPares==2) numPares2++;
			if(jogo.numPares==3)numPares3++;
			if(jogo.numPares==4) numPares4++;
			if(jogo.numPares==1) numPares1++;
			if(jogo.numPares==5) numPares5++;
		}
		System.out.println("perc numPares 1 " + (double)numPares1/jogos.size()*100);		
		System.out.println("perc numPares 2 " + (double)numPares2/jogos.size()*100);
		System.out.println("perc numPares 3 " + (double)numPares3/jogos.size()*100);
		System.out.println("perc numPares 4 " + (double)numPares4/jogos.size()*100);
		System.out.println("perc numPares 5 " + (double)numPares5/jogos.size()*100);
		
		//percSomaMedia 
		//+/- % 5 = 17.09145427286357 
		//10 = 33.63318340829585 (16%)
		//15 = 48.87556221889056 (15%)
		//20 = 62.868565717141436 (14%)
		//25 = 74.26286856571714 (12%)
		//	somaMediaMenos 137.140179910045
		//	somaMediaMais 228.56696651674162
		//30 = 82.85857071464268 (8%)
		//35 = 88.75562218890555 (6%)

		double fator=0.25;
		double fatorMenos=1-fator;
		double fatorMais=1+fator;
		double comparadorMenos=somaMedia*fatorMenos;
		double comparadorMais=somaMedia*fatorMais;
		
		System.out.println("somaMediaMenos " + comparadorMenos);
		System.out.println("somaMediaMais " + comparadorMais);
		
		double percSomaMedia=0;
		
		
		for (Jogo jogo: jogos) {
			
			if(jogo.soma>=comparadorMenos && jogo.soma<comparadorMais) {
				percSomaMedia++;
			}
		}
		
		System.out.println("percSomaMedia " + percSomaMedia/jogos.size()*100);
	}


}
