/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detran;

import detran.conexao.Conexao;
import detran.dao.InfracaoDao;
import detran.dao.PessoaDao;
import detran.dao.TipoInfracaoDao;
import detran.domain.Infracao;
import detran.domain.Pessoa;
import detran.domain.TipoInfracao;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author celso
 */
public class Detran {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        //testeCriarComScanner();
        //testarPessoas();
        //testeCriarPessoa();
        testeCadastrarInfracao();
        
    }
    
    public static void testeCadastrarInfracao() throws Exception {
        
        var dao = new TipoInfracaoDao();
        var daoInfracao = new InfracaoDao();
        var tipos = dao.recuperar();
        
        System.out.println("Escolha o tipo da infração:");
        for(var tipo: tipos){
            System.out.println("ID:"+tipo.getId()+" "+tipo.getGrau());
        }
         System.out.println();
        var scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        var id = scanner.nextInt();
        
        var tipoSelecionado = dao.recuperar(id);
        if(tipoSelecionado == null){
            System.out.println("selecione novamente");
        }else{
            
            System.out.println("Digite a descrição da infração");
            scanner.nextLine();
            var descricao = scanner.nextLine();
            var infracao = new Infracao(descricao, tipoSelecionado);
            var sucesso = daoInfracao.criar(infracao);
            
        }
        
        
        
    }
    
    public static void testeCriarPessoa() throws Exception {
        
        var dao = new PessoaDao();
        var scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        
        System.out.println("Digite o nome da pessoa:");
        var nome = scanner.nextLine();
        var id = dao.criar(new Pessoa(nome));
        
        System.out.println("Nova pessoa com id"+id+" cadastrada com sucesso!");
                
        
    }

    public static void testeCriarComScanner() throws Exception {
        
        var tipoInfracaoDao = new TipoInfracaoDao();

        var scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("Digite o grau: ");
        var grau = scanner.nextLine();
        System.out.println("Digite a pontuação : ");
        var pontuacao = scanner.nextInt();
        System.out.println("Digite o valor : ");
        var valor = scanner.nextDouble();

        var id = tipoInfracaoDao.criar(new TipoInfracao(grau, pontuacao, pontuacao));

        System.out.println("Novo tipo de infração " + id + " cadastrado com sucesso");

    }
    
    public static void testarPessoas() throws Exception {
        
        var dao = new PessoaDao();
        for(var pessoa: dao.recuperar()){
            System.out.print(pessoa.getNome());
            if(pessoa.getHabilitacao() != null){
                System.out.print(pessoa.getHabilitacao().getNumero() + " " + pessoa.getHabilitacao().getCategoria());
            }
            System.out.println();
        }
        
    }

    public static void testeORMBusca() throws Exception {

        //Detran.teste();
        var tipoInfracaoDao = new TipoInfracaoDao();
        var tipoInfracoes = tipoInfracaoDao.recuperar();

        for (var tipoInfracao : tipoInfracoes) {
            System.out.print(tipoInfracao.getGrau());
            System.out.println(tipoInfracao.getPontuacao());
        }

        var infracaoDao = new InfracaoDao();
        var infracoes = infracaoDao.recuperar();

        for (var infracao : infracoes) {
            System.out.print(infracao.getDescricao());
            System.out.println(infracao.getTipo().getGrau());
        }

    }

    public static void testeSemORM() throws Exception {

        // TODO code application logic here
        var statement = Conexao.getInstance().getConnection().prepareStatement("SELECT * FROM tipo_infracao");
        var result = statement.executeQuery();

        while (result.next()) {
            System.out.print(result.getString("grau"));
            System.out.println(result.getString("pontuacao"));
        }

    }

}
