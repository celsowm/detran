package detran.domain;

public class TipoInfracao {

  private int id;  
  private String grau;
  private float valor;
  private int pontuacao;

  public TipoInfracao(int id, String grau, float valor, int pontuacao){
    this.id   = id;
    this.grau = grau;
    this.valor = valor;
    this.pontuacao = pontuacao;
  }
  
  public TipoInfracao(String grau, float valor, int pontuacao){
    this.grau = grau;
    this.valor = valor;
    this.pontuacao = pontuacao;
  }

  public String getGrau(){
    return this.grau;
  }

  public float getValor(){
    return this.valor;
  }

  public int getPontuacao(){
    return this.pontuacao;
  }

  public int getId(){
      return this.id;
  }

}