// Bibliotecas

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String []args){

        Scanner input = new Scanner(System.in);
        utils aux = new utils();
        String senha;

        EquipeController equipeController = new EquipeController();
        PartidaController partidaController = new PartidaController();

        while(true){

            int escolha;


            while(true) {
                try {
                    aux.menu_cadastro();
                    System.out.println("Escolha alguma das opções acima: ");
                    escolha = input.nextInt();
                    if (escolha >= 0 || escolha <= 0){
                        break;
                    }
                }catch (Exception e){
                    aux.limpar_tela();
                    input.nextLine();
                    System.out.println("Ocorreu um Erro! Tente novamente...");
                }
            }

            input.nextLine();

            aux.limpar_tela();
            switch(escolha){
                case 1:
                    // Feature  Concluída.
                    System.out.println("[1] - Administrador;");
                    aux.linhas();

                    Administrador adm = new Administrador();
                    System.out.println("Digite sua senha: ");
                    senha = input.nextLine();

                    adm.acessarPerfil(senha, equipeController, partidaController);

                    break;
                case 2:
                    // Feature  Concluída.
                    System.out.println("[2] - Jogador;");
                    aux.linhas();

                    Jogador jogador = new Jogador();
                    System.out.println("Digite sua senha: ");
                    senha = input.nextLine();

                    jogador.acessarPerfil(senha, equipeController, partidaController);

                    break;
                case 3:
                    // Feature a ser produzida
                    System.out.println("[3] - Visitante;");
                    aux.linhas();


                    System.out.println("Digite seu nome: ");
                    String nomeCompleto = input.nextLine();
                    Visitante visitante = new Visitante(nomeCompleto);
                

                    visitante.acessarPerfil(equipeController, partidaController);


                    break;
                
                case 0:
                    System.out.println("[0] - Sair");
                    aux.linhas();

                    break;

                default:
                    System.out.println("Opção Inválida! Tente Novamente...");

            }
            if(escolha == 0){
                aux.limpar_tela();
                break;
            }
        }
    }
}