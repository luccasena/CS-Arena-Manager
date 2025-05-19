
import java.util.ArrayList;


public class Time {
    utils aux = new utils();

    private int idTime;
    private String nomeTime;
    private String paisOrigem;
    private int numVitorias;
    private int numDerrotas;
    private Jogador jogadores[] = new Jogador[5];
    private int ultimaPosicao = 0;

    public void Time(int idTime ,String nomeTime, String paisOrigem, int numVitorias, int numDerrotas){
        this.idTime = idTime;
        this.nomeTime = nomeTime;
        this.paisOrigem = paisOrigem;
        this.numVitorias = numVitorias;
        this.numDerrotas = numDerrotas;
        ultimaPosicao++;
    }

    public void adicionarJogador(Jogador jogador){
            if(ultimaPosicao == 4){
                System.out.println("Time está cheio!");
            }else{
                this.jogadores[ultimaPosicao] = jogador;
                ultimaPosicao++;
            }
    }

    public void mostrarTime(){
        System.out.println("Informações sobre o Time:" );

        aux.linhas();
        System.out.println("  - Nome do Time:  " + nomeTime);
        System.out.println("  - País de Origem:  " + paisOrigem);
        System.out.println("  - Número de Vitórias:  " + numVitorias);
        System.out.println("  - Número de Derrotas:  " + numDerrotas);

        aux.linhas();

        for (int i = 0; i < jogadores.length; i++){
            System.out.printf("  - %dº Integrante:  %s\n  - Classe: %s\n", i+1, jogadores[i].getNome(), jogadores[i].getClasse());
        }

        aux.linhas();
    }

    public String getNomeTime(){
        return this.nomeTime;
    }



}
