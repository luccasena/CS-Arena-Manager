
import java.util.ArrayList;

public class Partida {
    utils aux = new utils();

    private int idPartida;
    private String dia;
    private String horario;
    private String time1;
    private String time2;
    private ArrayList<String> mapas = new ArrayList<String>();
    private String vencedor;
    private String placar;

    public Partida(int idPartida, String dia, String horario, String time1, String time2){
        this.idPartida = idPartida;
        this.dia = dia;
        this.horario = horario;
        this.time1 = time1;
        this.time2 = time2;

    }

    public void setVencedor(String vencedor, String placar){
        this.vencedor = vencedor;
        this.placar = placar;

    }
    public void addMapa(String mapa){
        mapas.add(mapa);

    }


    public void mostrarHistorico(){

        boolean mapa_vazio = false;

        System.out.println("  - ID da partida:  " + idPartida);
        aux.linhas();
        System.out.println("  - "+time1+" X "+time2);
        System.out.println("  - Dia:  " + dia);
        System.out.println("  - Horario:  " + horario);

        if(vencedor != null){
            System.out.println("Vencedor: " + vencedor);
            System.out.println("Placar: " + placar);
        }else{
            System.out.println("Vencendor: A definir");
            System.out.println("Placar: A definir");
        }
        System.out.println("Mapas Jogados:");
        for(int i = 0; i < mapas.size(); i++){
            if(mapas.get(i) == null){
                mapa_vazio = true;
            }
        }
        if (mapa_vazio){
            System.out.println("Nenhum mapa registrado!");
        } else{
            for(String mapa: mapas){
                System.out.println("-" + mapa);
            }
        }
        aux.linhas();

    }

    public int getIdPartida(){
        return this.idPartida;

    }

    public String getTime1(){
        return this.time1;

    }

    public String getTime2(){
        return this.time2;

    }

    public void atualizarPartida(){
        System.out.println("\n Id da partida:" + idPartida);
        System.out.println(time1 + "X" + time2);
        System.out.println("Vencedor: " + vencedor);
        System.out.println("Mapas Jogados: " + mapas);

    }

}
