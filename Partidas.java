
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
    private Time vencedor;

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

    public void setVencedor(Time vencedor){
        this.vencedor = vencedor;
    }
    public void mostrarHistorico(){

    }

}
