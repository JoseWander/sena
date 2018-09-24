package sena;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Processo {
	
	public Impressao impressao=new Impressao();

	public SortedSet<Integer> sorteioJogoLotoFacil(int numNumeros){
		SortedSet<Integer> jogo = new TreeSet<Integer>();
		SortedSet<Integer> usados = new TreeSet<Integer>();
		int n;

		jogo.clear();
		for (int i=0; i<numNumeros; i++) {
			// aceita somente números que ainda não foram usados
			do {
				n = (int)Math.round(Math.random() * 24) + 1;
			} while (usados.contains(n));

			jogo.add(n);
			usados.add(n);
		}

		return jogo;
	}
	
	public SortedSet<Integer> sorteioJogo(int numNumeros){
		SortedSet<Integer> jogo = new TreeSet<Integer>();
		SortedSet<Integer> usados = new TreeSet<Integer>();
		int n;

		// cria uma aposta com 6 dezenas
		jogo.clear();
		for (int i=0; i<numNumeros; i++) {
			// aceita somente números que ainda não foram usados
			do {
				// gera um número aleatório entre 1 e 60 (inclusive)
				n = (int)Math.round(Math.random() * 59) + 1;
			} while (usados.contains(n));

			jogo.add(n);
			usados.add(n);
		}

		return jogo;
	}
	
	public boolean jaSortedeados(SortedSet<Integer> jogo, List<Jogo> jogosSalvos, int numMax){
		
		int cont=0;
		
		for (Jogo jogoSalvo: jogosSalvos) {
			cont=0;
			for (Integer numero: jogo) {
				if(jogoSalvo.numsJogo.contains(numero)) {
					cont++;		
					if(cont>=numMax){
						//System.out.println(jogoSalvo.numsJogo);
						//System.out.println(jogo);
						return true;
					}
				}
			}
		}
		
		return false;
	}

	public boolean checaPares(int numMaxPares, int numMaxImpares, SortedSet<Integer> jogo){
		
		int contPares=0;
		int contImpares=0;
		
		for (Integer numero: jogo) {
			if(numero%2==0) contPares++; else contImpares++;
			if(contPares>numMaxPares){
				//System.out.println(">>alerta pares");
				//impressao.imprimeJogo(jogo);
				return false;
			}
			if(contImpares>numMaxImpares){
				//System.out.println(">>alerta impares");
				//impressao.imprimeJogo(jogo);
				return false;
			}
		}

		return true;
	}
	
	public int contaPares(SortedSet<Integer> jogo){
		
		int contPares=0;
		
		for (Integer numero: jogo) {
			if(numero%2==0) contPares++;
		}

		return contPares;
	}
	
	public int soma(SortedSet<Integer> jogo){
		
		int soma=0;
		
		for (Integer numero: jogo) {
			soma=soma+numero;
		}

		return soma;
	}
	
	public int numQuintos(SortedSet<Integer> jogo){
		
		int q1=0;
		int q2=0;
		int q3=0;
		int q4=0;
		int q5=0;
		
		for (Integer numero: jogo) {
			if(numero<=5){
				q1=1; 
				break;
			}
		}
		
		for (Integer numero: jogo) {
			if(numero>5 & numero<=10){
				q2=1; 
				break;
			}
		}
		
		for (Integer numero: jogo) {
			if(numero>10 & numero<=15){
				q3=1; 
				break;
			}
		}
		
		for (Integer numero: jogo) {
			if(numero>15 & numero<=20){
				q4=1; 
				break;
			}
		}
		
		for (Integer numero: jogo) {
			if(numero>20){
				q5=1; 
				break;
			}
		}
		
		return q1 + q2 + q3 + q4 + q5;	
	}
	
	
	public int numQuartos(SortedSet<Integer> jogo){
		
		int q1=0;
		int q2=0;
		int q3=0;
		int q4=0;
		
		for (Integer numero: jogo) {
			if(numero<=15){
				q1=1; 
				break;
			}
		}
		
		for (Integer numero: jogo) {
			if(numero>15 & numero<=30){
				q2=1; 
				break;
			}
		}
		
		for (Integer numero: jogo) {
			if(numero>30 & numero<=45){
				q3=1; 
				break;
			}
		}
		
		for (Integer numero: jogo) {
			if(numero>45){
				q4=1; 
				break;
			}
		}
		
		return q1 + q2 + q3 + q4;	
	}
	
	public int numTercos(SortedSet<Integer> jogo){
		
		int t1=0;
		int t2=0;
		int t3=0;

		for (Integer numero: jogo) {
			if(numero<=20){
				t1=1; 
				break;
			}
		}
		
		for (Integer numero: jogo) {
			if(numero>20 && numero<=40){
				t2=1; 
				break;
			}
		}
		
		for (Integer numero: jogo) {
			if(numero>40){
				t3=1; 
				break;
			}
		}
		
		return t1 + t2 + t3;	
	}
	
	//FALSE SE ACHAR MAIS QUE N DIVISOES
	public boolean checaDiv357(SortedSet<Integer> jogo,int numMax3,int numMax57){
		
		int cont3=0;
		int cont5=0;
		int cont7=0;
		
		for (Integer numero: jogo) {
			if(numero%3==0) cont3++; 
			if(numero%5==0) cont5++; 
			if(numero%7==0) cont7++; 

			if(cont3>numMax3||cont5>numMax57||cont7>numMax57){
				//System.out.println(">>alerta div 3, 5 ou 7");
				//impressao.imprimeJogo(jogo);
				return false;
			}
		}

		return true;
	}
	
	//CHECA SE NAO ESTA ACUMULADO EM 1 DOS 3 TERCOS, ENTAO É PERMITIDO DISTRIBUICAO EM 2 OU E DOS TERCOS
	public boolean checaDistrib2Tercos(SortedSet<Integer> jogo){
		
		int cont1=0;
		int cont2=0;
		int cont3=0;
		
		for (Integer numero: jogo) {
			if(numero<=20) cont1++;
			if(numero>20 && numero<=40) cont2++;
			if(numero>40) cont3++;
		}
				
		if(cont1==6 || cont2==6 || cont3==6) {
			//System.out.println(">>alerta distrib em 2 tercos");
			//impressao.imprimeJogo(jogo);
			return false;
		}
		
		return true;
		
	}
	
	public boolean checaDistrib(int numMinMeio, int numMinTerco, SortedSet<Integer> jogo){

		int cont=0;
	
		for (Integer numero: jogo) {
			if(numero<=30) cont++;
		}
		
		if(cont<numMinMeio){
			//System.out.println(">>alerta distrib em 2");
			//imprimeJogo(jogo);
			return false;
		}
		
		cont=0;
		
		for (Integer numero: jogo) {
			if(numero>30) cont++;
		}
		
		if(cont<numMinMeio){
			//System.out.println(">>alerta distrib em 2");
			//imprimeJogo(jogo);
			return false;
		}
		
		
		cont=0;
		for (Integer numero: jogo) {
			if(numero<=20) cont++;
		}
		
		if(cont<numMinTerco){
			//System.out.println(">>alerta distrib em 3");
			//imprimeJogo(jogo);
			return false;
		}
		
		cont=0;
		for (Integer numero: jogo) {
			if(numero>20 && (numero<=40)) cont++;
		}
		
		if(cont<numMinTerco){
			//System.out.println(">>alerta distrib em 3");
			//imprimeJogo(jogo);
			return false;
		}
		
		cont=0;
		for (Integer numero: jogo) {
			if(numero>40) cont++;
		}
		
		if(cont<numMinTerco){
			//System.out.println(">>alerta distrib em 3");
			//imprimeJogo(jogo);
			return false;
		}
		
		return true;
	}

	//false se achar 3 duplos
	public boolean checaNumDuplos(SortedSet<Integer> jogo){
		
		int cont=0;

		for (Integer numero: jogo) {
			if(numero==11) cont++;
			if(numero==22) cont++;
			if(numero==33) cont++;
			if(numero==44) cont++;
			if(numero==55) cont++;
		}
		
		if(cont>2){
			//System.out.println(">>alerta numeros duplos");
			//imprimeJogo(jogo);
			return false;
		}
		
		return true;
	}
	
	//false se achar 3 fibos
	public boolean checaFibo(SortedSet<Integer> jogo){
		
		int numNumeros=jogo.size();
		
		List<Integer> listNumeros = new ArrayList<Integer>(numNumeros);
		listNumeros.addAll(jogo);
		
		List<Integer> listFibo = Arrays.asList (1, 2, 3, 5, 8, 13, 21, 34, 55);

		for (int i=0;i<=numNumeros-3;i++) {
			for (int j=0;j<=6;j++) {
				if(listNumeros.get(i)==listFibo.get(j)){
					if(listNumeros.get(i+1)==listFibo.get(j+1)){
						if(listNumeros.get(i+2)==listFibo.get(j+2)){
							//System.out.println(">>alerta fibo");
							//imprimeJogo(jogo);
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	//false se encontrar 3 sequenciais
	public boolean checaSeq(SortedSet<Integer> jogo){
		
		int numNumeros=jogo.size();
		List<Integer> listNumeros = new ArrayList<Integer>(numNumeros);
		listNumeros.addAll(jogo);

		for (int i=0;i<=numNumeros-3;i++) {
			if(listNumeros.get(i+1)==listNumeros.get(i)+1){
				if(listNumeros.get(i+2)==listNumeros.get(i)+2){
					//System.out.println("**>>alerta sq");
					//imprimeJogo(jogo);
					return false;
				}
			}
		}
		return true;
	}

	
	public boolean checaUltJogo(SortedSet<Integer> numsJogo, SortedSet<Integer> numsUltJogo, int numMaxIguais){
		
		int cont=0;
		for (Integer numero: numsJogo) {
			if(numsUltJogo.contains(numero)) {
				cont++;
				if(cont>numMaxIguais) {
					//System.out.println("**>>alerta sq ult jogo");
					//impressao.imprimeJogo(numsJogo);
					return false;
				}
			}
		}
							
		return true;
	}
}
