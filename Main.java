// Bibliotecas

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String []args){

        Scanner input = new Scanner(System.in);

        utils aux = new utils();

        ArrayList<Time> times = new ArrayList<Time>();
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
        ArrayList<Partidas> partidas = new ArrayList<Partidas>();

        while(true){

            Jogador jogador = new Jogador();
            Time time = new Time();
            Partidas partida = new Partidas();

            aux.menu();

            System.out.println("Escolha alguma das opções acima: ");
            int escolha = input.nextInt();

            aux.limpar_tela();
            switch (escolha){
                case 1:
                    // Feature Parcialmente Concluída, falta tratamento.
                    System.out.println("[1] - Criar Time");
                    aux.linhas();

                    criar.time(time);
                    times.add(time);

                    aux.limpar_tela();
                    break;
                case 2:
                    // Feature Parcialmente Concluída, falta tratamento.
                    System.out.println("[2] - Mostrar Times");
                    aux.linhas();
                    if(times.isEmpty()){
                        System.out.println("Não existe times a serem exibidos...");
                        System.out.println("Adicione um time selecionando a opção [1]!");

                    }else{
                        aux.mostrar_time(times);

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

                    }

                    break;
                case 4:
                    // Feature Parcialmente Concluída, falta tratamento.
                    System.out.println("[4] - Cadastrar Jogador");
                    aux.linhas();
                    if(times.isEmpty()){
                        System.out.println("Não existe times para o cadastro do Jogador!...");
                        System.out.println("Adicione um time selecionando a opção [1]!");

                    }else{
                        criar.jogador(jogador);
                        aux.limpar_tela();

                        aux.mostrar_time(times);

                        System.out.println("Digite o ID do time que deseja cadastrar o jogador");

                        int id_time = input.nextInt();
                        aux.limpar_tela();

                        for(int i = 0; i < times.size(); i++){
                            if(id_time == times.get(i).getIdTime()){
                                times.get(i).adicionarJogador(jogador.getNome());
                                jogadores.add(jogador);

                                break;
                            }else{
                                System.out.println("Ocorre um erro ao adicionar o jogador...");
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


                    }


                    break;
                case 6:
                    // Feature Parcialmente Concluída, falta tratamento.
                    System.out.println("[6] - Mostrar Jogadores");
                    aux.linhas();

                    if(jogadores.isEmpty()){
                        System.out.println("Não existe jogadores a serem exibidos!...");
                        System.out.println("Adicione um jogador selecionando a opção [4]!");

                    }else{
                        aux.mostrar_jogadores(jogadores);

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
                        criar.partida(partida);
                        partidas.add(partida);

                    }

                    break;
                case 8:
                    // Feature a ser produzida
                    System.out.println("[8] - Histórico de Partidas");
                    aux.linhas();

                    if(partidas.isEmpty()){
                        System.out.println("Não existe partidas a serem exibidas...");
                        System.out.println("Adicione uma partida selecionando a opção [7]!");

                    }else{
                        criar.partida(partida);
                        partidas.add(partida);

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
