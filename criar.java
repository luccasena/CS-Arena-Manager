
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class criar {
    public static void jogador(Jogador jogador ){

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome completo do Jogador: ");
        String nomeCompleto = input.nextLine();

        System.out.println("Digite a classe do Jogador: ");
        String classe = input.nextLine();

        System.out.println("Digite os anos de experiência do Jogador: ");
        int experienciaAnos = input.nextInt();

        input.nextLine();

        System.out.println("Digite o mapa preferido do Jogador: ");
        String preferenciaMapa = input.nextLine();

        jogador.Jogador(nomeCompleto, classe, experienciaAnos, preferenciaMapa);


    }
    public static void time(Time time){

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do Time: ");
        String nomeTime = input.nextLine();

        System.out.println("Digite o país de origem: ");
        String paisOrigem = input.nextLine();

        System.out.println("Digite o número de vitórias: ");
        int numVitorias = input.nextInt();
        input.nextLine();

        System.out.println("Digite o número de derrotas: ");
        int numDerrotas = input.nextInt();
        input.nextLine();

        time.Time(nomeTime, paisOrigem, numVitorias, numDerrotas);


    }
    public static void partida(Partidas partida){


        Scanner input = new Scanner(System.in);

        System.out.println("Digite o dia da partida: ");
        String dia = input.nextLine();

        System.out.println("Digite o horário da partida: ");
        String horario = input.nextLine();

        System.out.println("Digite o nome do time 1: ");
        String time1 = input.nextLine();

        System.out.println("Digite o nome do time 2: ");
        String time2 = input.nextLine();

        partida.Partidas( dia,  horario,  time1,  time2);


    }

}
