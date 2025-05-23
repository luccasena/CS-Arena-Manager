
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class criar {
    public static void jogador(Jogador jogador ){
        utils aux = new utils();

        Scanner input = new Scanner(System.in);
        int escolha_classe = 0;
        int escolha_mapa = 0;
        String classe = "";
        String preferenciaMapa = "";

        System.out.println("Digite o nome completo do Jogador: ");
        String nomeCompleto = input.nextLine();

        while(true){
            try {
                aux.linhas();
                System.out.printf("Classes Disponíveis:\n");
                aux.linhas();
                System.out.println("[1] Entry Fragger\n" +
                                   "[2] Lurker\n" +
                                   "[3] AWP\n" +
                                   "[4] Playmaker\n" +
                                   "[5] Support");
                aux.linhas();
                System.out.println("Digite a classe do Jogador baseado nos índices acima: ");
                escolha_classe = input.nextInt();
            }catch (Exception e) {
                aux.limpar_tela();
                System.out.println("Ocorreu um erro! Tente Novamente...");
                aux.linhas();
            }if(escolha_classe >= 1 && escolha_classe <= 5){
                break;
            }else{
                input.nextLine();
                aux.limpar_tela();
                System.out.println("Opção Inválida! Escolha uma opção entre 1 a 5");
                aux.linhas();
            }
        }

        switch(escolha_classe){
            case 1:
                classe = "Entry Fragger";
                break;

            case 2:
                classe = "Lurker";
                break;

            case 3:
                classe = "AWP";
                break;

            case 4:
                classe = "Playmaker";
                break;

            case 5:
                classe = "Support";
                break;
        }

        System.out.println("Digite os anos de experiência do Jogador: ");
        int experienciaAnos = input.nextInt();


        while(true){
            try {
                aux.linhas();
                System.out.printf("Mapas Disponíveis:\n");
                aux.linhas();
                System.out.println( "[1] Mirage\n" +
                                    "[2] Train\n" +
                                    "[3] Vertigo\n" +
                                    "[4] Nuke\n" +
                                    "[5] Ancient\n"+
                                    "[6] Inferno\n"+
                                    "[7] Overpass\n"+
                                    "[8] Dust II");
                aux.linhas();
                System.out.println("Digite o mapa preferido do Jogador baseado nos índices acima: ");
                escolha_mapa = input.nextInt();
            }catch(Exception e){
                aux.limpar_tela();
                System.out.println("Ocorreu um erro! Tente Novamente...");
                aux.linhas();

            }if(escolha_mapa >= 1 && escolha_mapa <= 8){
                break;

            }else{
                input.nextLine();
                aux.limpar_tela();
                System.out.println("Opção Inválida! Escolha uma opção entre 1 a 8");
                aux.linhas();

            }
        }

        switch(escolha_mapa){
            case 1:
                preferenciaMapa = "Mirage";
                break;

            case 2:
                preferenciaMapa = "Train";
                break;

            case 3:
                preferenciaMapa = "Vertigo";
                break;

            case 4:
                preferenciaMapa = "Nuke";
                break;

            case 5:
                preferenciaMapa = "Ancient";
                break;

            case 6:
                preferenciaMapa = "Inferno";
                break;

            case 7:
                preferenciaMapa = "Overpass";
                break;

            case 8:
                preferenciaMapa = "Dust II";
                break;

        }

        jogador.Jogador(nomeCompleto, classe, experienciaAnos, preferenciaMapa);

    }

    public static void time(Time time,int id_aux_time){

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do Time: ");
        String nomeTime = input.nextLine();

        System.out.println("Digite o país de origem: ");
        String paisOrigem = input.nextLine();

        time.Time(nomeTime, paisOrigem, id_aux_time);

    }

    public static Partidas partida(ArrayList<Time> times, int id_aux_partida){
        utils aux = new utils();
        Scanner input = new Scanner(System.in);

        String time1Nome = "";
        int id_time1 = 0;
        String time2Nome = "";
        int id_time2 = 0;
        boolean achou_time = false;

        System.out.println("Digite a data da partida (DD/MM/AAAA): ");
        String dia = input.nextLine();

        System.out.println("Digite o horário da partida (HH:MM): ");
        String horario = input.nextLine();

        aux.linhas();

        while(true) {

            aux.mostrar_time(times, 2);
            System.out.println("1- Digite o ID de um time: ");

            id_time1 = input.nextInt();

            for (int i = 0; i < times.size(); i++) {
                if (id_time1 == times.get(i).getIdTime()) {
                    time1Nome = times.get(i).getNomeTime();
                    achou_time = true;
                    break;
                }
            }
            if (achou_time) {
                break;
            } else {
                aux.limpar_tela();
                System.out.println("Time não encontrado! Tente novamente...");
                aux.linhas();
            }
        }
        aux.linhas();
        while(true){
            aux.limpar_tela();

            aux.mostrar_time(times, 2);
            System.out.println("2- Digite o ID de um time: ");
            id_time2 = input.nextInt();
            input.nextLine();

            for (Time time : times){
                if(id_time2 == time.getIdTime()){
                    achou_time = true;
                    time2Nome = time.getNomeTime();
                    break;
                }
            }
            if(achou_time){
                break;
            }else{
                aux.limpar_tela();
                System.out.println("Time não encontrado! Tente novamente...");
                aux.linhas();
            }

        }

        return new Partidas(id_aux_partida, dia, horario, time1Nome, time2Nome);
        }

}
