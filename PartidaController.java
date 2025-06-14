
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

	public void setIdPartida(int choose){
		if(choose == 1){
			this.id_aux_partida = this.id_aux_partida+1;
		}else if(choose == -1){
			this.id_aux_partida = this.id_aux_partida-1;
		}
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
			for(Partida aux_partida: partidas){
				aux_partida.mostrarDetalhes();
			}
		}
		
		
	}

	public void menu_atualizar_partidas() {
		utils util = new utils();
        util.linhas();
        System.out.println("          Gerenciador de Partidas           ");
        util.linhas();
        System.out.println("[1] - Definir Vencedor da Partida e Placar;");
        System.out.println("[2] - Definir Mapas das Partidas;");
        System.out.println("[0] - Sair do Gerenciador;");
        util.linhas();

    }
}
