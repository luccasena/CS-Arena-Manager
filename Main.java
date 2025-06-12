// Bibliotecas

import java.util.Scanner;

public class Main {
    public static void main(String []args){

        Scanner input = new Scanner(System.in);
        utils aux = new utils();

        String senha;
        int id_equipe;
        boolean achou_equipe = false;
        boolean achou_senha = false;
        Jogador jogador = new Jogador();

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

                    if(equipeController.nenhumJogador()){
                        aux.limpar_tela();
                        System.out.println("Nenhum jogador cadastrado no sistema!...");

                    }else{
                        equipeController.mostrarEquipesJogadores(0);
                        
                        aux.linhas();
                        System.out.println("Digite o índice da equipe que você participa: ");
                        id_equipe = input.nextInt();

                        input.nextLine();

                        System.out.println("Digite sua senha: ");
                        senha = input.nextLine();

                        for(int i = 0; i < equipeController.getEquipes().size(); i++){
                            if(id_equipe == equipeController.getEquipe(i).getIdEquipe()){
                                achou_equipe = true;

                            }
                        }
                        if(achou_equipe){

                            Equipe equipeSelecionada = null;

                            for (Equipe equipe : equipeController.getEquipes()) {
                                if (equipe.getIdEquipe() == id_equipe) {
                                    equipeSelecionada = equipe;
                                    break;
                                }
                            }

                            if (equipeSelecionada != null) {
                                for (Jogador jogadoraux : equipeSelecionada.getJogadores()) {
                                    if (jogadoraux.getSenha().equals(senha)) {
                                        achou_senha = true;
                                        jogador = jogadoraux;
                                        break;
                                    }
                                }

                                if (achou_senha) {
                                    jogador.acessarPerfil(senha, equipeController, partidaController);

                                }else{
                                    aux.limpar_tela();
                                    System.out.println("Senha incorreta ou jogador não pertence à equipe!");
                                }
                            }else {
                                aux.limpar_tela();
                                System.out.println("Equipe não encontrada!");
                            }
                        }
                    }

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