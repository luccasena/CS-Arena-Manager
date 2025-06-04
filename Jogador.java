import java.util.ArrayList;
import java.util.Scanner;

public class Jogador extends Usuario implements acessoPlataforma {

	private Equipe equipe;
	private String senha = " ";
	private String classe;
	private int experienciaAnos;
	private String preferenciaMapa;

	public Jogador(String nomeCompleto, String classe, int experienciaAnos, String preferenciaMapa) {
		super.nomeCompleto = nomeCompleto;
		this.classe = classe;
		this.experienciaAnos = experienciaAnos;
		this.preferenciaMapa = preferenciaMapa;
	}

	public Jogador() {
		super.nomeCompleto = null;
		this.classe = null;
		this.preferenciaMapa = null;
	}

	public void setEquipe(Equipe equipe){
		this.equipe = equipe;
	}

	public String getNome() {
		return super.nomeCompleto;
	}

	public void mostrarMenu() {
		utils util = new utils();

		util.linhas();
        System.out.println("          Área do Jogador            ");
        util.linhas();
        System.out.println("[1] - Informações da Equipe;");
        System.out.println("[2] - Partidas Marcadas;");
        System.out.println("[3] - Atualizar dados;");
        System.out.println("[0] - Sair;");
        util.linhas();

	}
	
	public void mostrarJogador(int choose) {
        if (choose == 1){
		    System.out.printf("Nome do Integrante: %-25s       |       Classe: %s \n", nomeCompleto, classe);
            
        }else if(choose == 2){
            System.out.printf("Nome do Integrante: %s\nMapa Favorito: %s\nAnos de Experiência: %d\nEquipe Atualmente: %s\n\n", nomeCompleto, preferenciaMapa, experienciaAnos, equipe.getNomeEquipe());
        } 
	}

    public Equipe getEquipe(){
        return this.equipe;
    }


	/**
	 * @see acessoPlataforma#acessarPerfil(String)
	 */
	public void acessarPerfil(String senha, EquipeController equipeController, PartidaController partidaController){
		utils util = new utils();
		if(this.senha.equals(senha)){

			util.limpar_tela();
			System.out.println("Nível de Acesso - Jogador;");
			Scanner input = new Scanner(System.in);

			while(true){

                int escolha;


                while(true) {
                    try {
                        mostrarMenu();
                        System.out.println("Escolha alguma das opções acima: ");
                        escolha = input.nextInt();
                        if (escolha >= 0 || escolha <= 0){
                            break;
                        }
                    }catch (Exception e){
                        util.limpar_tela();
                        input.nextLine();
                        System.out.println("Ocorreu um Erro! Tente novamente...");
                    }
                }

                input.nextLine();

                util.limpar_tela();
                switch(escolha){
                    case 1:
                        // Feature  Concluída.
                        System.out.println("[1] - Informações da Equipe;");
                        util.linhas();



                        break;
                    case 2:
                        // Feature  Concluída.
                        System.out.println("[2] - Partidas Marcadas;");
                        util.linhas();


                    

                        break;
                    case 3:
                        // Feature a ser produzida
                        System.out.println("[3] - Atualizar dados;");
                        util.linhas();



                        break;
                    
                    case 0:
                        System.out.println("[0] - Sair");
                        util.linhas();

                        break;

                    default:
                        System.out.println("Opção Inválida! Tente Novamente...");

                }
                if(escolha == 0){
                    util.limpar_tela();
                    break;
                }
            }

		}else{
			util.limpar_tela();
			System.out.println("Senha inválida! Tente novamente...");
		}

	}

	

}
