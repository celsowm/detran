package detran.domain;

import java.util.*;

class OldMain {
  public static void old_main(String[] args) {
    
    ArrayList<TipoInfracao> tiposInfracao = new ArrayList<TipoInfracao>();

    tiposInfracao.add(new TipoInfracao("leve", 70.00f, 3));
    tiposInfracao.add(new TipoInfracao("média", 80.00f, 4));
    tiposInfracao.add(new TipoInfracao("grave", 100.00f, 5));
    tiposInfracao.add(new TipoInfracao("gravíssima", 150.00f, 7));

    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    pessoas.add(new Pessoa("joão"));
    pessoas.add(new Pessoa("maria"));
    pessoas.add(new Pessoa("thiago"));
    pessoas.add(new Pessoa("zé"));

    pessoas.get(1).setHabilitacao(new Habilitacao(
      "123", "C", null
    ));

    pessoas.get(2).setHabilitacao(new Habilitacao(
      "456", "E", null
    ));

    pessoas.get(3).setHabilitacao(new Habilitacao(
      "789", "AB", null
    ));

    ArrayList<Infracao> infracoes = new ArrayList<Infracao>();

    infracoes.add(new Infracao("dirigir bebasso !", tiposInfracao.get(3)));
    infracoes.add(new Infracao("cantar o guarda", tiposInfracao.get(0)));    
    infracoes.add(new Infracao("sem cinto", tiposInfracao.get(1)));

    ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    veiculos.add(new Veiculo("ABC1234","xpto", pessoas.get(0)));
    veiculos.add(new Veiculo("ERT3333","ghtt", pessoas.get(1)));
    veiculos.add(new Veiculo("OPO5678","gkjy", pessoas.get(2)));    

    veiculos.get(1).addMulta(new Multa(new Date(), "rua são josé", infracoes.get(0)));

    veiculos.get(1).addMulta(new Multa(new Date(), "rua legal", infracoes.get(2)));   

    System.out.println(pessoas.get(1).getNome());
    System.out.println(pessoas.get(1).getHabilitacao().getPontos());  

  }
}