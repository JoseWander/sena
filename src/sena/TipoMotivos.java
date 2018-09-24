package sena;

public enum TipoMotivos {    
    NENHUM(0),PARES(1),DISTRIB(2), NUM_DUPLOS(3), FIBO(4), SEQUENCIAIS(5), DIV357(6),JA_FOI_SORTEADO(7),MEDIA(8);
    
    private final int valor;
    
    TipoMotivos(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }
}
    