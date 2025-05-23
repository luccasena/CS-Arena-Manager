
import java.util.ArrayList;

public class Time {
    utils aux = new utils();

    private int idTime;
    private String nomeTime;
    private String paisOrigem;
    private int numVitorias = 0;
    private int numDerrotas = 0;
    private ArrayList<String> jogadores = new ArrayList<String>();
    private int ultimaPosicao = 0;

    public void Time(String nomeTime, String paisOrigem, int id_aux_time){
        this.idTime = id_aux_time;
        this.nomeTime = nomeTime;
        this.paisOrigem = paisOrigem;

    }

    public boolean removerJogador(String nomeJogador) {   // olha a posiçao do jogador
        for (int i = 0; i < ultimaPosicao; i++) {
            if (jogadores.get(i) != null && jogadores.get(i).equalsIgnoreCase(nomeJogador)) { // achou o jogador e joga os outros pra esquerda, o equalsignorecase é pra ignorar letras maiusculas e minusculas
                jogadores.remove(i);
                //for (int j = i; j < ultimaPosicao - 1; j++) {
                //    jogadores[j] = jogadores[j + 1];
                //}
                // jogadores[ultimaPosicao - 1] = null;
                ultimaPosicao--;
                return true;
            }
        }
        return false; // nao encontrou ojogador
    }

    public void adicionarJogador(String jogador){
            if(ultimaPosicao > 4){
                System.out.println("Time está cheio!");
            }else{
                jogadores.add(jogador);
                System.out.printf("Jogador Adicionado no time com sucesso! \n");
                ultimaPosicao++;
            }
    }

    public void mostrarTime(){

        System.out.println("  - Nome do Time:  " + nomeTime);
        System.out.println("  - País de Origem:  " + paisOrigem);
        System.out.println("  - Número de Vitórias:  " + numVitorias);
        System.out.println("  - Número de Derrotas:  " + numDerrotas);
        System.out.println("  - Id do Time:  " + idTime);

        aux.linhas();

        for (int i = 0; i < jogadores.size(); i++){
            if(jogadores.get(i)== null){
                System.out.printf("  - %dº Vaga Vazia  \n", i+1);
            }else{
                System.out.printf("  - %dº Integrante:  %s\n", i+1, jogadores.get(i));
            }

        }
        aux.linhas();
        System.out.printf("\n");

    }

    public String getNomeTime(){

        return this.nomeTime;
    }

    public int getIdTime(){
        return this.idTime;
    }

    public ArrayList<String> getJogadores(){
        return this.jogadores;}

    public void aumentarVitoria(){
        this.numVitorias++;
    }
    public void aumentarDerrota(){
        this.numDerrotas++;
    }
}
