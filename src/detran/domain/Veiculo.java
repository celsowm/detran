package detran.domain;

import java.util.*;


public class Veiculo {

  private int id;  
  private String placa;
  private String chassi;
  private ArrayList<Multa> multas;
  private Pessoa proprietario;

  public Veiculo(int id, String placa, String chassi, Pessoa proprietario){

    this.id    = id;  
    this.placa = placa;
    this.chassi = chassi;
    this.proprietario = proprietario;
    this.multas = new ArrayList<Multa>();

  }

  public Veiculo(int id, String placa, String chassi, Pessoa proprietario, ArrayList<Multa> multas){

    this.id    = id;  
    this.placa = placa;
    this.chassi = chassi;
    this.proprietario = proprietario;
    this.multas = multas;

  }
  
  public Veiculo(String placa, String chassi, Pessoa proprietario){

    this.placa = placa;
    this.chassi = chassi;
    this.proprietario = proprietario;
    this.multas = new ArrayList<Multa>();

  }

  public Veiculo(String placa, String chassi, Pessoa proprietario, ArrayList<Multa> multas){

    this.placa = placa;
    this.chassi = chassi;
    this.proprietario = proprietario;
    this.multas = multas;

  }

  public String getPlaca(){
    return this.placa;
  }

  public String getChassi(){
    return this.chassi;
  }

  public Pessoa getProprietario(){
    return this.proprietario;
  }

  public ArrayList<Multa> getMultas(){
    return this.multas;
  }

  public Veiculo addMulta(Multa multa){
    if(multa.getVeiculo() == null){
      multa.setVeiculo(this);
    }
    this.multas.add(multa);
    return this;
  }

  public int getId(){
      return this.id;
  }

}