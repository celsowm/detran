package detran.domain;

public class Infracao {

  private int id;  
  private String descricao;
  private TipoInfracao tipo;
  
  public Infracao(int id, String descricao, TipoInfracao tipo){
    this.id  = id;  
    this.descricao = descricao;
    this.tipo = tipo;
  }

  public Infracao(String descricao, TipoInfracao tipo){
    this.descricao = descricao;
    this.tipo = tipo;
  }

  public String getDescricao(){
    return this.descricao;
  }

  public TipoInfracao getTipo(){
    return this.tipo;
  }
  
  public int getId(){
      return this.id;
  }


}