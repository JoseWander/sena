package sena;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {

    public List<Jogo> readCcv() {

        String csvFile = "C:\\Users\\JoseWander\\Google Drive\\eclipse\\sena\\resources\\megasena.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        List<Jogo> jogos=new ArrayList<Jogo>();
        Jogo jogo;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] megasena = line.split(cvsSplitBy);
                
                jogo=new Jogo();
                jogo.concurso=megasena[0];
                jogo.numsJogo.add(Integer.parseInt(megasena[2]));
                jogo.numsJogo.add(Integer.parseInt(megasena[3]));
                jogo.numsJogo.add(Integer.parseInt(megasena[4]));
                jogo.numsJogo.add(Integer.parseInt(megasena[5]));
                jogo.numsJogo.add(Integer.parseInt(megasena[6]));
                jogo.numsJogo.add(Integer.parseInt(megasena[7]));
                jogos.add(jogo);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return jogos;

    }

    public List<Jogo> readCcvLotoFacil() {

        String csvFile = "C:\\Users\\JoseWander\\Google Drive\\eclipse\\sena\\resources\\lotofacil.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        List<Jogo> jogos=new ArrayList<Jogo>();
        Jogo jogo;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] lotofacil = line.split(cvsSplitBy);
                
                jogo=new Jogo();
                jogo.concurso=lotofacil[0];
                jogo.numsJogo.add(Integer.parseInt(lotofacil[2]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[3]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[4]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[5]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[6]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[7]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[8]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[9]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[10]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[11]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[12]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[13]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[14]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[15]));
                jogo.numsJogo.add(Integer.parseInt(lotofacil[16]));
                jogos.add(jogo);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return jogos;

    }
}