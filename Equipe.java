import java.util.ArrayList;

public class Equipe extends Administrador {

	private int idEquipe;
	private String nomeEquipe;
	private String paisOrigem;
	private int numVitorias;
	private int numDerrotas;
	private ArrayList<Jogador> jogadores;
	private int quantidadeJogadores;

	public Equipe(String nomeEquipe, String paisOrigem, int id_aux_equipe) {
		this.nomeEquipe = nomeEquipe;
		this.paisOrigem = paisOrigem;
		this.idEquipe = id_aux_equipe;
		this.numVitorias = 0;
		this.numDerrotas = 0;
		this.quantidadeJogadores = 0;
		this.jogadores = new ArrayList<Jogador>();

	}

	public void addJogador(Jogador jogador) {
		jogadores.add(jogador);
		quantidadeJogadores++;
	}

	public void rmvJogador(Jogador jogador) {
		jogadores.remove(jogador);
		quantidadeJogadores--;
	}

	public void mostrarInfoEquipe() {
		utils util = new utils();

		System.out.printf("Id da Equipe: [%d]\n", idEquipe);
		System.out.printf("- Nome da Equipe:  %s \n",nomeEquipe);
        System.out.println("  - País de Origem:  " + paisOrigem);
        System.out.println("  - Número de Vitórias:  " + numVitorias);
        System.out.println("  - Número de Derrotas:  " + numDerrotas);

        System.out.println("\nIntegrantes da Equipe: ");

        for (int i = 0; i < 5; i++){
            if(i >= jogadores.size() || jogadores.get(i) == null){
                System.out.printf("  - %dº Vaga Vazia  \n", i+1);
            }else{
                System.out.printf("  - %dº Integrante:  %s\n", i+1, jogadores.get(i).getNome());
            }

        }
        util.linhas();
	}

	public void mostrarJogadores(int choose) {
		if(choose == 1){
			for (Jogador aux2 : jogadores) {
					aux2.mostrarJogador(1);
				}
		}else if(choose == 2){
			for (Jogador aux2 : jogadores) {
					aux2.mostrarJogador(2);
				}
		}else if(choose == 3){
			for (Jogador aux2 : jogadores) {
					aux2.mostrarJogador(3);
				}
		}
    }

	public void aumentarVitoria(){
		this.numVitorias += numVitorias;
	}

	public void aumentarDerrota(){
		this.numDerrotas += numDerrotas;
	}

	public String getNomeEquipe(){
		return this.nomeEquipe;

	}

	public int getQuantJogador(){
		return this.quantidadeJogadores;

	}

	public int getIdEquipe(){
        return this.idEquipe;
    }

	public void setIdEquipe(int idEquipe){
        this.idEquipe = idEquipe;
    }

	public String getnomeEquipe(){
		return nomeEquipe;
	}

	public Jogador getJogador(int pos){
		return jogadores.get(pos);
	}

	public ArrayList<Jogador> getJogadores(){
		return jogadores;
	}

}
