import java.util.ArrayList;

public class utils {

    public void linhas(){
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public void menu(){
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
    public void limpar_tela(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    }

    public void mostrar_time(ArrayList<Time> times){
        for(Time aux2:times){
            aux2.mostrarTime();
        }
    }

    public void mostrar_jogadores(ArrayList<Jogador> jogadores){
        for(Jogador aux2:jogadores){
            aux2.mostrarInformacoes();
        }
    }



}
