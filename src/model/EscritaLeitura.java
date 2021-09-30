package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EscritaLeitura {

  public static ArrayList<String> Read(String Caminho) {
    ArrayList<String> conteudo = new ArrayList();
    try {
      FileReader arq = new FileReader(Caminho);
      BufferedReader lerArq = new BufferedReader(arq);
      String linha = "";
      try {
        linha = lerArq.readLine();
        while (linha != null) {
          conteudo.add(linha);
          linha = lerArq.readLine();
        }
        arq.close();
        return conteudo;
      } catch (IOException ex) {
        System.out.println("Erro: Não foi possível ler o arquivo de dados!");
        return conteudo;
      }
    } catch (FileNotFoundException ex) {
      System.out.println("Erro: Arquivo não encontrado!");
      return conteudo;
    }
  }

  public static boolean Write(String Caminho, ArrayList<String> conteudoNovo) {
    try {
      ArrayList<String> conteudoAntigo = new ArrayList();
      conteudoAntigo = Read(Caminho);
      FileWriter arq = new FileWriter(Caminho);
      PrintWriter gravarArq = new PrintWriter(arq);
      for (String aux : conteudoNovo) {
        conteudoAntigo.add(aux);
      }
      for (String aux : conteudoAntigo) {
        gravarArq.println(aux);
      }
      gravarArq.close();
      return true;
    } catch (IOException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

}
