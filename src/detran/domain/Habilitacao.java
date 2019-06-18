package detran.domain;

public class Habilitacao {

  private int id;  
  private String numero;
  private String categoria;
  private int pontos;
  private Pessoa pessoa;
  
  public Habilitacao(int id, String numero, String categoria, Pessoa pessoa){

    this.id     = id;  
    this.numero = numero;
    this.categoria = categoria;
    this.pessoa = pessoa;
    this.pontos = 0;

  }

  public Habilitacao(String numero, String categoria, Pessoa pessoa){

    this.numero = numero;
    this.categoria = categoria;
    this.pessoa = pessoa;
    this.pontos = 0;

  }

  public String getNumero(){
    return this.numero;
  }

  public String getCategoria(){
    return this.categoria;
  }

  public Pessoa getPessoa(){
    return this.pessoa;
  }

  public int getPontos(){
    return this.pontos;
  }

  public Habilitacao adicionaPontos(int pontos){
    this.pontos += pontos;
    return this;
  }
  
  public int getId(){
      return this.id;
  }

}