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
                    System.out.println("Criar Time");
                    aux.linhas();

                    criar.time(time);
                    times.add(time);

                    aux.limpar_tela();
                    break;
                case 2:
                    // Feature Parcialmente Concluída, falta tratamento.
                    System.out.println("Mostrar Times");
                    aux.linhas();

                    aux.mostrar_time(times);

                    break;
                case 3:
                    // Feature a ser produzida
                    System.out.println("Remover Times");
                    aux.linhas();



                    break;
                case 4:
                    // Feature Parcialmente Concluída, falta tratamento.
                    System.out.println("Cadastrar Jogador");
                    aux.linhas();
                    if(times.isEmpty()){
                        aux.limpar_tela();
                        System.out.println("Adicione algum time no sistema para realizar o cadastro do jogador...");
                        aux.linhas();

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
                    System.out.println("Remover Jogador");
                    aux.linhas();



                    break;
                case 6:
                    // Feature Parcialmente Concluída, falta tratamento.
                    System.out.println("Mostrar Jogadores");
                    aux.linhas();

                    aux.mostrar_jogadores(jogadores);

                    break;
                case 7:
                    // Feature Parcialmente Concluída, falta tratamento.

                    System.out.println("Marcar Partidas");
                    aux.linhas();

                    criar.partida(partida);
                    partidas.add(partida);

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


                    break;
                case 9:
                    // Feature a ser produzida
                    System.out.println("Atualizar Partidas");
                    aux.linhas();



                    break;
                case 0:
                    System.out.println("Sair");
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
