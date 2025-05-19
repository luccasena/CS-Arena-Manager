
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Partidas{

    private int idPartida;
    private LocalDate dia;
    private LocalTime horario;
    private Time time1;
    private Time time2;
    private ArrayList<String> mapas = new ArrayList<String>();
    private Time vencedor;

    int id_aux = 0;

    public void Partidas(LocalDate dia, LocalTime horario, Time time1, Time time2){
        this.idPartida = id_aux+1;
        this.dia = dia;
        this.horario = horario;
        this.time1 = time1;
        this.time2 = time2;
    }

    public void setVencedor(Time vencedor){
        this.vencedor = vencedor;
    }
    public void mostrarHistorico(){

    }

}
