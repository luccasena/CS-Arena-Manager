import java.util.ArrayList;

public class Jogador {
    utils aux = new utils();

    private String nomeCompleto;
    private String classe;
    private int experienciaAnos;
    private String preferenciaMapa;

    public void Jogador(String nomeCompleto, String classe, int experienciaAnos, String preferenciaMapa){
        this.nomeCompleto = nomeCompleto;
        this.classe = classe;
        this.experienciaAnos = experienciaAnos;
        this.preferenciaMapa = preferenciaMapa;

    }


    public void mostrarInformacoes(ArrayList<Time> times){
        aux.linhas();
        System.out.println("  - Nome Completo:  " + nomeCompleto);
        System.out.println("  - Classe:  " + classe);
        System.out.println("  - Experiência em Anos:  " + experienciaAnos);
        System.out.println("  - Preferência de Mapa:  " + preferenciaMapa);

        for(int i = 0; i < times.size(); i++){
            if(times.get(i).getJogadores().equals(nomeCompleto)){
                System.out.println("  - Time Atual:  " + times.get(i).getNomeTime());
            }
        }
        aux.linhas();
        System.out.printf("\n");

    }

    public String getNome(){
        return this.nomeCompleto;
    }

    public String getClasse(){
        return this.classe;
    }

}