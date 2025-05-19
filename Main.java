
import java.util.Scanner;

public class Main {
    public static void main(String []args){

        Scanner input = new Scanner(System.in);
        Jogador jogador = new Jogador();
        Time time = new Time();
        Partidas partida = new Partidas();
        utils aux = new utils();

        while(true){

            aux.menu();

            System.out.println("Escolha alguma das opções acima: ");
            int escolha = input.nextInt();

            aux.limpar_tela();
            switch (escolha){
                case 1:
                    System.out.println("Criar Time");
                    aux.linhas();

                    break;
                case 2:
                    System.out.println("Mostrar Times");
                    aux.linhas();

                    break;
                case 3:
                    System.out.println("Remover Times");
                    aux.linhas();

                    break;
                case 4:
                    System.out.println("Cadastrar Jogador");
                    aux.linhas();

                    break;
                case 5:
                    System.out.println("Remover Jogador");
                    aux.linhas();

                    break;
                case 6:
                    System.out.println("Mostrar Jogadores");
                    aux.linhas();

                    break;
                case 7:
                    System.out.println("Marcar Partidas");
                    aux.linhas();

                    break;
                case 8:
                    System.out.println("Histórico de Partidas");
                    aux.linhas();

                    break;
                case 9:
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
