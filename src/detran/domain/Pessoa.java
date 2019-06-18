package detran.domain;

public class Pessoa{

  private int id;  
  private String nome;
  private Habilitacao habilitacao;

  public Pessoa(int id, String nome){
    this.id   = id;
    this.nome = nome;
  }
  
  public Pessoa(String nome){
    this.nome = nome;
  }

  public String getNome(){
    return this.nome;
  }

  public Pessoa setHabilitacao(Habilitacao habilitacao){

    this.habilitacao = habilitacao;
    return this;

  }

  public Habilitacao getHabilitacao(){
    return this.habilitacao;

  }
  
  public int getId(){
      return this.id;
  }

}