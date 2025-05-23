import java.util.ArrayList;
import java.util.Scanner;

public class atualizar {
    public static void partida(ArrayList<Partidas> partidas, ArrayList<Time> times){
        Scanner input = new Scanner(System.in);
        utils aux = new utils();

        aux.limpar_tela();

        while(true){
            String time1 = "";
            String time2 = "";
            String placar = "";
            String mapa = "";
            int id_partida;
            int id_vencedor;
            int escolha;
            int escolher_vencedor = 0;
            int repetir = 0;
            int escolha_mapa = 0;
            boolean achou_partida = false;

            while (true) {
                try {
                    aux.menu_atualizar_partidas();
                    System.out.println("Escolha alguma das opções acima: ");
                    escolha = input.nextInt();
                    if (escolha >= 0 || escolha <= 0) {
                        break;
                    }
                } catch (Exception e) {
                    aux.limpar_tela();
                    input.nextLine();
                    System.out.println("Ocorreu um Erro! Tente novamente...");
                }
            }


            aux.limpar_tela();

            switch (escolha) {
                case 1:
                    System.out.println("[1] - Definir Vencedor de Partida;");
                    aux.linhas();
                    aux.mostrar_partidas(partidas, 2);

                    System.out.println("Digite o ID da partida que você deseja atualizar: ");
                    id_partida = input.nextInt();

                    for (int i = 0; i < partidas.size(); i++) {
                        if (id_partida == partidas.get(i).getIdPartida()) {
                            achou_partida = true;

                            break;
                        }
                    }

                    if (achou_partida) {
                        time1 = partidas.get(id_partida).getTime1();
                        time2 = partidas.get(id_partida).getTime2();

                        while (true) {
                            try {
                                System.out.println("[1] - " + time1);
                                System.out.println("[2] - " + time2);
                                System.out.println("Escolha o ganhador da partida: ");
                                escolher_vencedor = input.nextInt();
                            } catch (Exception e) {
                                System.out.println("Ocorreu um Erro! Tente novamente...");
                            }
                            if (escolher_vencedor == 1 || escolher_vencedor >= 2) {
                                break;
                            } else {
                                System.out.println("Opção Inválida! Tente novamente...");
                            }
                        }

                    }
                    System.out.println("Digite o placar do jogo: ");
                    placar = input.next();

                    if (escolher_vencedor == 1) {
                        partidas.get(id_partida).setVencedor(time1, placar);
                        for (Time aux2 : times) {
                            if (time1 == aux2.getNomeTime()) {
                                times.get(aux2.getIdTime()).aumentarVitoria();
                            } else if (time2 == aux2.getNomeTime()) {
                                times.get(aux2.getIdTime()).aumentarDerrota();
                            }
                        }

                    } else {
                        partidas.get(id_partida).setVencedor(time2, placar);
                        for (Time aux2 : times) {
                            if (time2 == aux2.getNomeTime()) {
                                times.get(aux2.getIdTime()).aumentarVitoria();
                            } else if (time1 == aux2.getNomeTime()) {
                                times.get(aux2.getIdTime()).aumentarDerrota();
                            }
                        }
                    }

                    break;
                case 2:
                    System.out.println("[2] - Definir Mapas das Partidas;");
                    aux.linhas();
                    aux.mostrar_partidas(partidas, 2);

                    System.out.println("Digite o ID da partida que você deseja atualizar: ");
                    id_partida = input.nextInt();

                    for (int i = 0; i < partidas.size(); i++) {
                        if (id_partida == partidas.get(i).getIdPartida()) {
                            achou_partida = true;
                            break;
                        }
                    }
                    if (achou_partida) {
                        while (true) {
                            try {
                                aux.linhas();
                                System.out.printf("Mapas Disponíveis:\n");
                                aux.linhas();
                                System.out.println("[1] Mirage\n" +
                                        "[2] Train\n" +
                                        "[3] Vertigo\n" +
                                        "[4] Nuke\n" +
                                        "[5] Ancient\n" +
                                        "[6] Inferno\n" +
                                        "[7] Overpass\n" +
                                        "[8] Dust II");
                                aux.linhas();
                                System.out.println("Digite o mapa da partida baseado nos índices acima: ");
                                escolha_mapa = input.nextInt();
                            } catch (Exception e) {
                                aux.limpar_tela();
                                System.out.println("Ocorreu um erro! Tente Novamente...");
                                aux.linhas();

                            }
                            if (escolha_mapa >= 1 && escolha_mapa <= 8) {
                                break;

                            } else {
                                input.nextLine();
                                aux.limpar_tela();
                                System.out.println("Opção Inválida! Escolha uma opção entre 1 a 8");
                                aux.linhas();

                            }
                            switch (escolha_mapa) {
                                case 1:
                                    mapa = "Mirage";
                                    break;

                                case 2:
                                    mapa = "Train";
                                    break;

                                case 3:
                                    mapa = "Vertigo";
                                    break;

                                case 4:
                                    mapa = "Nuke";
                                    break;

                                case 5:
                                    mapa = "Ancient";
                                    break;

                                case 6:
                                    mapa = "Inferno";
                                    break;

                                case 7:
                                    mapa = "Overpass";
                                    break;

                                case 8:
                                    mapa = "Dust II";
                                    break;

                            }
                            partidas.get(id_partida).addMapa(mapa);

                            while (true) {
                                try {
                                    System.out.println("[1] - Sim;\n[2] - Não;\nVocê deseja adicionar mais mapas?: ");
                                    repetir = input.nextInt();
                                    if (repetir != 1 && repetir != 2) {
                                        System.out.println("Opção Inválidas! Tente novamente...");
                                    }
                                } catch (Exception e) {
                                    aux.limpar_tela();
                                    input.nextLine();
                                    System.out.println("Ocorreu um Erro! Tente novamente...");
                                }
                                if (repetir >= 0 || repetir <= 0) {
                                    break;
                                }
                            }

                            if (repetir == 2) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Partida não encontrada!");
                    }

                    break;
                case 0:
                    System.out.println("[0] - Sair do Gerenciador;");

                    break;
                default:
                    System.out.println("Opção Inválida! Tente Novamente...");

            }
            if(escolha==0){
                break;
            }
        }
    }
}
