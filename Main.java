// Bibliotecas

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String []args){

        Scanner input = new Scanner(System.in);

        utils aux = new utils();

        ArrayList<Time> times = new ArrayList<Time>();
        int id_aux_time = 0;
        int id_aux_partida = 0;

        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
        ArrayList<Partidas> partidas = new ArrayList<Partidas>();

        while(true){

            Jogador jogador = new Jogador();
            Time time = new Time();
            Partidas partida;
            int escolha;


            while(true) {
                try {
                    aux.menu();
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

            aux.limpar_tela();
            switch(escolha){
                case 1:
                    // Feature  Concluída.
                    System.out.println("[1] - Cadastrar Time");
                    aux.linhas();

                    criar.time(time, id_aux_time);
                    times.add(time);
                    id_aux_time++;

                    aux.limpar_tela();
                    System.out.printf("Time %s cadastrado com sucesso!\n", time.getNomeTime());

                    break;
                case 2:
                    // Feature  Concluída.
                    System.out.println("[2] - Mostrar Times");
                    aux.linhas();

                    if(times.isEmpty()){
                        System.out.println("Não existe times a serem exibidos...");
                        System.out.println("Adicione um time selecionando a opção [1]!");

                    }else{
                        System.out.println("Informações sobre o Time:" );
                        aux.linhas();
                        aux.mostrar_time(times, 1);

                    }

                    break;
                case 3:
                    // Feature a ser produzida
                    System.out.println("[3] - Remover Times");
                    aux.linhas();

                    if(times.isEmpty()){
                        System.out.println("Não existe times a serem removidos!...");
                        System.out.println("Adicione um time selecionando a opção [1]!");

                    }else{
                        if (times.isEmpty()) { // se tiver vazio
                            System.out.println("Nenhum time cadastrado para remover.");
                        } else {
                            aux.mostrar_time(times, 2); // mostra os times para excluir
                            System.out.println("Digite o ID do time que deseja remover: ");
                            int idRemover = input.nextInt();
                            input.nextLine(); // limpa

                            boolean removido = false;
                            for (int i = 0; i < times.size(); i++) { // se o id que foi pesquisado for igual ao id do time
                                if (times.get(i).getIdTime() == idRemover) {
                                    aux.limpar_tela();
                                    System.out.println("Time '" + times.get(i).getNomeTime() + "' (ID: " + idRemover + ") removido com sucesso!");
                                    times.remove(i); // AQUI: removemos o time da lista principal
                                    removido = true; //"removido com sucesso!".
                                    id_aux_time--;
                                    break;
                                }
                            }
                            // "não removido" depois de olhar todos os times:
                            if (!removido) {
                                System.out.println("ID de time não encontrado."); // avisa que não achou o ID.
                            }

                        }

                    }

                    break;
                case 4:
                    // Feature  Concluída.
                    System.out.println("[4] - Cadastrar Jogador");
                    aux.linhas();

                    if(times.isEmpty()){
                        System.out.println("Não existe times para o cadastro do Jogador!...");
                        System.out.println("Adicione um time selecionando a opção [1]!");

                    }else{
                        boolean encontrou_time = false;
                        int escolha_cadastro;

                        criar.jogador(jogador);
                        aux.limpar_tela();

                        while(true){
                            System.out.println("Times Cadastrados:" );
                            aux.linhas();

                            aux.mostrar_time(times, 1);

                            System.out.println("Digite o ID do time desejado para o cadastro do jogador: ");

                            int id_time = input.nextInt();
                            aux.limpar_tela();

                            for (int i = 0; i < times.size(); i++) {
                                if (id_time == times.get(i).getIdTime()) {

                                    times.get(i).adicionarJogador(jogador.getNome());
                                    jogadores.add(jogador);
                                    encontrou_time = true;

                                    break;
                                }
                            }
                            if (!encontrou_time) {
                                aux.limpar_tela();
                                System.out.println("ID não encontrado...");
                                aux.linhas();
                                System.out.println("[1]- Cancelar Cadastro;\n[2]- Adicionar em outro Time;");
                                aux.linhas();
                                System.out.println("Você deseja adicionar em outro time ou cancelar o cadastro?");
                                escolha_cadastro = input.nextInt();

                            }else{
                                break;
                            }

                            aux.limpar_tela();
                            if(escolha_cadastro == 1){
                                System.out.println("Cadastro Cancelado...");
                                break;
                            }

                        }
                    }

                    break;
                case 5:
                    // Feature a ser produzida
                    System.out.println("[5] - Remover Jogador");
                    aux.linhas();

                    if(jogadores.isEmpty()){
                        System.out.println("Não existe jogadores a serem removidos!...");
                        System.out.println("Adicione um jogador selecionando a opção [4]!");

                    }else{
                        aux.mostrar_jogadores(jogadores, times, 2);
                        System.out.println("Digite o nome do jogador para remove-lo:");
                        input.nextLine();
                        String nomeJogador = input.nextLine();
                        for(int i = 0;i < jogadores.size(); i++){
                            for(int j = 0; i <= 4; j++){
                                if(nomeJogador.equals(jogadores.get(i).getNome()) && nomeJogador.equals(times.get(i).getJogadores().get(j))){
                                    aux.limpar_tela();
                                    jogadores.remove(i);
                                    times.get(i).removerJogador(nomeJogador);
                                    System.out.println("Jogador "+nomeJogador+" removido com sucesso!");
                                    break;
                                }
                            }
                        }

                    }

                    break;
                case 6:
                    // Feature  Concluída.
                    System.out.println("[6] - Mostrar Jogadores");
                    aux.linhas();

                    if(jogadores.isEmpty()){
                        System.out.println("Não existe jogadores a serem exibidos!...");
                        System.out.println("Adicione um jogador selecionando a opção [4]!");

                    }else{

                        aux.mostrar_jogadores(jogadores, times, 1);

                    }

                    break;
                case 7:
                    // Feature Parcialmente Concluída, falta tratamento.

                    System.out.println("[7] - Marcar Partidas");
                    aux.linhas();

                    if(times.isEmpty() || times.size() < 2){
                        System.out.println("Não existe times o suficiente para marcar uma partida...");
                        System.out.println("Adicione um time selecionando a opção [1]!");

                    }else{
                        partida = criar.partida(times, id_aux_partida);

                        partidas.add(partida);
                        id_aux_partida++;

                        aux.limpar_tela();
                        System.out.println("Partida marcada com sucesso!");

                    }


                    break;
                case 8:
                    // Feature concluída
                    System.out.println("[8] - Histórico de Partidas");
                    aux.linhas();

                    if(partidas.isEmpty()){
                        System.out.println("Não existe partidas a serem exibidas...");
                        System.out.println("Adicione uma partida selecionando a opção [7]!");

                    }else{
                        aux.mostrar_partidas(partidas, 1);

                    }

                    break;
                case 9:
                    // Feature a ser produzida
                    System.out.println("[9] - Atualizar Partidas");
                    aux.linhas();

                    if(partidas.isEmpty()){
                        System.out.println("Não existe partidas a serem atualizadas...");
                        System.out.println("Adicione uma partida selecionando a opção [7]!");

                    }else{
                        atualizar.partida(partidas, times);

                    }

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
