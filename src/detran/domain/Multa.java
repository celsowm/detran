package detran.domain;

import java.util.Date;

public class Multa {

  private int id;  
  private Date dataHora;
  private String local;
  private Infracao infracao;
  private Veiculo veiculo;
  
  public Multa(int id, Date dataHora, String local, Infracao infracao, Veiculo veiculo){

    this.id       = id;
    this.dataHora = dataHora;
    this.local = local;
    this.infracao = infracao;
    this.veiculo = veiculo;

  }

  public Multa(int id, Date dataHora, String local, Infracao infracao){

    this.id       = id;  
    this.dataHora = dataHora;
    this.local = local;
    this.infracao = infracao;

  }

  public Multa(Date dataHora, String local, Infracao infracao, Veiculo veiculo){

    this.dataHora = dataHora;
    this.local = local;
    this.infracao = infracao;
    this.veiculo = veiculo;

  }

  public Multa(Date dataHora, String local, Infracao infracao){

    this.dataHora = dataHora;
    this.local = local;
    this.infracao = infracao;

  }

  public Date getDataHora(){
    return this.dataHora;
  }

  public String getLocal(){
    return this.local;
  }

  public Infracao getInfracao(){
    return this.infracao;
  }

  public Veiculo getVeiculo(){
    return this.veiculo;
  }

  public Multa setVeiculo(Veiculo veiculo){
    this.veiculo = veiculo;

    if(this.veiculo != null){
      this.veiculo.getProprietario().getHabilitacao().adicionaPontos(this.infracao.getTipo().getPontuacao());
    }
    return this;
  }
  
  public int getId(){
      return this.id;
  }



}