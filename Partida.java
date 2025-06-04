
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Partida extends Administrador {

	private int id_aux_partida;
	private LocalDate dia;
	private LocalTime horario;
	private String equipe1;
	private String equipe2;
	private ArrayList<String> mapas;
	private String vencedor;
	private String placar;

	public Partida(int id_aux_partida, LocalDate dia, LocalTime horario, String equipe1, String equipe2){
		this.id_aux_partida = id_aux_partida;
		this.dia = dia;
		this.horario = horario;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.mapas = new ArrayList<String>();
	}

	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}

	public void setPlacar(String placar) {
		this.placar = placar;
	}

	public void mostrarDetalhes() {
		utils util = new utils();
		boolean mapa_vazio = false;

		System.out.printf("[%d] - Identificador da Partida:", id_aux_partida);
		System.out.println(equipe1+" X "+equipe2);
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
		util.linhas();

	}


}
