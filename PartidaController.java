
import java.util.ArrayList;

public class PartidaController {

	private ArrayList<Partida> partidas;
	private int id_aux_partida;

	public PartidaController(Partida partida) {
		this.partidas = new ArrayList<Partida>();
	}
	public PartidaController() {
		this.partidas = new ArrayList<Partida>();
	}

	public void addPartida(Partida partida) {
		partidas.add(partida);
	}

	public void setIdPartida(int id_aux_partida){
		this.id_aux_partida = id_aux_partida;
	}

	public int getIdPartida(){
		return this.id_aux_partida;
	}


	public ArrayList<Partida> getPartidas() {
		return partidas;
	}

	public Partida getPartida(int id) {
		return partidas.get(id);
	}

	public void mostrarPartidas(int choose) {
		if(choose == 1){

		}else if(choose == 2){

		}
		
		
	}

}
