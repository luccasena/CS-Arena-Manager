import java.util.ArrayList;

public class utils {

    public void linhas() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public void menu() {
        linhas();
        System.out.println("          CS-Arena-Manager            ");
        linhas();
        System.out.println("[1] - Criar Time;");
        System.out.println("[2] - Mostrar Times;");
        System.out.println("[3] - Remover Time;");
        System.out.println("[4] - Cadastrar Jogador;");
        System.out.println("[5] - Remover Jogador;");
        System.out.println("[6] - Mostrar Jogadores");
        System.out.println("[7] - Marcar Partidas;");
        System.out.println("[8] - Histórico de Partidas;");
        System.out.println("[9] - Atualizar Partidas;");
        System.out.println("[0] - Sair;");
        linhas();

    }

    public void menu_atualizar_partidas() {
        linhas();
        System.out.println("          Gerenciador de Partidas           ");
        linhas();
        System.out.println("[1] - Definir Vencedor da Partida e Placar;");
        System.out.println("[2] - Definir Mapas das Partidas;");
        System.out.println("[0] - Sair do Gerenciador;");
        linhas();

    }


    public void limpar_tela() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    }

    public void mostrar_time(ArrayList<Time> times, int choose) {
        if(choose == 1){
            for (Time aux2 : times) {
                aux2.mostrarTime();
            }
        }else if(choose == 2){
            for (Time aux2 : times) {
               System.out.println("Nome do Time: "+aux2.getNomeTime()+"\nID do Time: "+aux2.getIdTime());
               linhas();

            }
        }

    }

    public void mostrar_jogadores(ArrayList<Jogador> jogadores, ArrayList<Time> times, int choose) {
        if(choose == 1) {
            for (Jogador aux2 : jogadores) {
                aux2.mostrarInformacoes(times);
            }
        }else if(choose == 2){
            for (Jogador aux2 : jogadores) {
                System.out.println(aux2.getNome());
                linhas();
            }
        }
    }

    public void mostrar_partidas(ArrayList<Partidas> partidas, int choose) {
        if(choose == 1){
            for (Partidas aux2 : partidas) {
                aux2.mostrarHistorico();
            }
        }else if(choose == 2){
            for (Partidas aux2 : partidas) {
                System.out.println(aux2.getTime1()+" x "+aux2.getTime2()+"\nID da partida: "+aux2.getIdPartida());
                linhas();
            }
        }

    }
}