
import java.util.ArrayList;

public class EquipeController {

	private ArrayList<Equipe> equipes;
	private int id_aux_equipe;
	private int id_util_equipe;

	public EquipeController() {
		this.equipes = new ArrayList<Equipe>();
		this.id_aux_equipe = 0;
	}

	public void addEquipe(Equipe equipe) {
		equipes.add(equipe);
	}

	public void setIdEquipe(int choose){
		
		if(choose == 1){
			this.id_aux_equipe = this.id_aux_equipe+1;
		}else if(choose == -1){
			this.id_aux_equipe = this.id_aux_equipe-1;
		}
	}

	public int getIdEquipe(){
		return this.id_aux_equipe;
	}

	public ArrayList<Equipe> getEquipes() {
		return equipes;
	}

	public Equipe getEquipe(int id) {
		return equipes.get(id);
	}

	public void mostrarEquipesJogadores(int choose) {
		utils util = new utils();
		if(choose == 0){
			for (Equipe auxEquipe : equipes) {
				System.out.printf("Nome do Time: %-25s     |Id do Time: [%d]\n", auxEquipe.getNomeEquipe(), auxEquipe.getIdEquipe());
			}
			
		}else if(choose == 1){
			for (Equipe auxEquipe : equipes) {
				auxEquipe.mostrarInfoEquipe();
			}
			System.out.println("");
		}else if(choose == 2){
			for (Equipe auxEquipe : equipes) {
		
				System.out.println("Nome do Time: "+auxEquipe.getNomeEquipe()+"\n");
				getEquipe(auxEquipe.getIdEquipe()).mostrarJogadores(1);
				
				util.linhas();

			}
		}else if(choose == 3){
			for (Equipe auxEquipe : equipes) {
		
				getEquipe(auxEquipe.getIdEquipe()).mostrarJogadores(2);
				
				util.linhas();

			}
		}
	}

	public boolean nenhumJogador(){
		for(Equipe auxEquipe: equipes){
			if(auxEquipe.getQuantJogador() > 0){
				return false;
			}
		}
		return true;
	}

	public boolean equipeCheia(){
		for(Equipe auxEquipe: equipes){
			if(auxEquipe.getQuantJogador() != 5){
				return false;
			}}
		return true;

	}

}