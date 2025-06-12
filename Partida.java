import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class Partida extends Administrador {

	private int id_aux_partida;
	private LocalDate dia;
	private LocalTime horario;
	private Equipe equipe1;
	private Equipe equipe2;
	private ArrayList<String> mapas;
	private String vencedor;
	private String placar;

	public Partida(int id_aux_partida, LocalDate dia, LocalTime horario, Equipe equipe1, Equipe equipe2){
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

	public void setMapas(ArrayList<String> mapas) {
		this.mapas = mapas;
	}

	public void mostrarDetalhes() {
		utils util = new utils();
		boolean mapa_vazio = false;

		util.linhas();
		System.out.printf("Identificador da Partida - [%d]:\n", id_aux_partida);
		util.linhas();
		System.out.println("Partida: "+equipe1.getNomeEquipe()+" X "+equipe2.getNomeEquipe());
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
				System.out.println("- " + mapa);
			}
		}
	}

	public void mostrarEquipes(){
		System.out.printf("[%d] - %s \n[%d] - %s\n",equipe1.getIdEquipe(),equipe1.getNomeEquipe(), equipe2.getIdEquipe(), equipe2.getNomeEquipe());
	}

	public Equipe getEquipe1(){
		return equipe1;
	}

	public Equipe getEquipe2(){
		return equipe2;
	}

}