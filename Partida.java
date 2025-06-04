
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Partida extends Administrador {

	private int id_aux_partida;
	private LocalDate dia;
	private LocalDateTime horario;
	private String equipe1;
	private String equipe2;
	private ArrayList<String> mapas;
	private String vencedor;
	private String placar;

	public Partida(int id_aux_partida, LocalDate dia, LocalDateTime horario, String equipe1, String equipe2){
		this.id_aux_partida = id_aux_partida;
		this.dia = dia;
		this.horario = horario;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
	}

	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}

	public void setPlacar(String placar) {
		this.placar = placar;
	}

	public void mostrarDetalhes() {

	}

}
