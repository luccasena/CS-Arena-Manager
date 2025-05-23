
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Partidas{

    private int idPartida;
    private String dia;
    private String horario;
    private String time1;
    private String time2;
    private ArrayList<String> mapas = new ArrayList<String>();
    private String vencedor;
    private String placar;

    int id_aux = 0;

    public void Partidas(String dia, String horario, String time1, String time2){
        this.idPartida = id_aux+1;
        this.dia = dia;
        this.horario = horario;
        this.time1 = time1;
        this.time2 = time2;
        this.idPartida = id_aux + 1;

        id_aux++;
    }

    public void setVencedor(String vencedor, String placar){
        this.vencedor = vencedor;
        this.placar = placar
    }
    public void aaddMapa(String mapa){
        this.mapas.add(mapa);
    }
    public void mostrarHistorico(){
        System.out.println("Informações da partida:");
        System.out.println("ID: " + idPartida);
        System.out.println("Dia: " + dia);
        System.out.println("Horario: " + horario);
        System.out.println("Time: " + time1);
        System.out.println("Time: " + time2);

        if(vencedor != null){
            System.out.println("Vencedor: " + vencedor);
        } else {
            System.out.println("Vencendor: A definir");
        }
        System.out.println("Mapas Jogados:");
        if ((mapas.isEmpty())){
            System.out.println("Nenhum mapa registrado!");
        } else{
            for(String mapa: mapas){
                System.out.println("-" + mapa);
            }
        }
        System.out.println("---------------------------");
    }

    public int getIdPartida(){
        return idPartida;
    }

    public String getTime1(){
        return time1;
    }

    public String getTime2(){
        return time2;
    }

    public void atualizarPartida(){
        System.out.println("\n Id da partida:" + idPartida);
        System.out.println(time1 + "X" + time2);
        System.out.println("Vencedor: " + vencedor);
        System.out.println("Mapas Jogados: " + mapas);
    }

}
