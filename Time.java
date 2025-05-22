
import java.util.ArrayList;


public class Time {
    utils aux = new utils();

    private int idTime;
    private String nomeTime;
    private String paisOrigem;
    private int numVitorias;
    private int numDerrotas;
    private String jogadores[] = new String[5];
    private int ultimaPosicao = 0;
    private int id_aux_time = 0;

    public void Time(String nomeTime, String paisOrigem, int numVitorias, int numDerrotas){
        this.idTime = id_aux_time;
        this.nomeTime = nomeTime;
        this.paisOrigem = paisOrigem;
        this.numVitorias = numVitorias;
        this.numDerrotas = numDerrotas;
        id_aux_time++;
    }

    public void adicionarJogador(String jogador){
            if(ultimaPosicao > 4){
                System.out.println("Time está cheio!");
            }else{
                jogadores[ultimaPosicao] = jogador;
                System.out.printf("Jogador Adicionado no time com sucesso! \n");
                ultimaPosicao++;
            }
    }

    public void mostrarTime(){
        System.out.println("Informações sobre o Time:" );

        aux.linhas();
        System.out.println("  - Id do Time:  " + idTime);
        System.out.println("  - Nome do Time:  " + nomeTime);
        System.out.println("  - País de Origem:  " + paisOrigem);
        System.out.println("  - Número de Vitórias:  " + numVitorias);
        System.out.println("  - Número de Derrotas:  " + numDerrotas);

        aux.linhas();

        for (int i = 0; i < jogadores.length; i++){
            if(jogadores[i] == null){
                System.out.printf("  - %dº Vaga Vazia  \n", i+1);
            }else{
                System.out.printf("  - %dº Integrante:  %s\n", i+1, jogadores[i]);
            }

        }

    }

    public String getNomeTime(){

        return this.nomeTime;
    }

    public int getIdTime(){
        return this.idTime;
    }


}
