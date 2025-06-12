import java.util.Scanner;
import java.util.Random;

public class Jogador extends Usuario implements acessoPlataforma {

	private Equipe equipe;
	private String senha;
	private String classe;
	private int experienciaAnos;
	private String preferenciaMapa;

	public Jogador(String nomeCompleto, String classe, int experienciaAnos, String preferenciaMapa) {
		super.nomeCompleto = nomeCompleto;
		this.classe = classe;
		this.experienciaAnos = experienciaAnos;
		this.preferenciaMapa = preferenciaMapa;

        Random rand = new Random();
        String especiais = "!@#$%&*";
        char caractere1 = especiais.charAt(rand.nextInt(especiais.length()));
        char caractere2 = especiais.charAt(rand.nextInt(especiais.length()));

        this.senha = caractere1 + classe.substring(0,3) + experienciaAnos + preferenciaMapa.substring(0, 3)+rand.nextInt(100) + caractere2;

	}

	public Jogador() {
		super.nomeCompleto = null;
		this.classe = null;
		this.preferenciaMapa = null;
        this.experienciaAnos = 0;
        this.senha = null;
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
        System.out.printf("                             Área do Jogador: %s                                 \n", super.nomeCompleto);
        util.linhas();
        System.out.println("[1] - Informações da Equipe;");
        System.out.println("[2] - Partidas Marcadas;");
        System.out.println("[3] - Atualizar dados;");
        System.out.println("[0] - Sair;");
        util.linhas();

	}
	
	public void mostrarJogador(int choose) {
        if (choose == 1){
		    System.out.printf("Jogador: %-25s       |       Classe: %s \n", nomeCompleto, classe);
            
        }else if(choose == 2){
            System.out.printf("Jogador: %s\nClasse: %s\nMapa Favorito: %s\nAnos de Experiência: %d\nEquipe Atualmente: %s\n\n", nomeCompleto, classe, preferenciaMapa, experienciaAnos, equipe.getNomeEquipe());

        }else if(choose == 3){
            System.out.printf("Jogador: %s\nClasse: %s\nMapa Favorito: %s\nAnos de Experiência: %d\nEquipe Atualmente: %s\nSenha: [%s]\n\n", nomeCompleto, classe, preferenciaMapa, experienciaAnos, equipe.getNomeEquipe(), senha);
        }

	}

    public Equipe getEquipe(){
        return this.equipe;
    }

    public String getSenha(){
        return this.senha;
    }

    public void atualizarSenha(String senha){
        this.senha = senha;

    }

	/**
	 * @see acessoPlataforma#acessarPerfil(String)
	 */

	public void acessarPerfil(String senha, EquipeController equipeController, PartidaController partidaController){
		utils util = new utils();

		if(this.senha.equals(senha)){

			util.limpar_tela();
			System.out.println("Nível de Acesso - Jogador;");
            System.out.printf("Seja Bem-vindo %s! \n",super.nomeCompleto);
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

                        equipe.mostrarInfoEquipe();
                        System.out.println("\nPressione Enter para voltar ao menu...");
                        input.nextLine(); 
                        util.limpar_tela();


                        break;
                    case 2:
                        // Feature  Concluída.
                        System.out.println("[2] - Partidas Marcadas;");

                        boolean achou_equipe = false;

                        for(Partida partida: partidaController.getPartidas()){
                            if(equipe == partida.getEquipe1()){
                                achou_equipe = true;
                                break;

                            }else if(equipe == partida.getEquipe2()){
                                achou_equipe = true;
                                break;
                            }
                        }

                       if(achou_equipe){
                            for(Partida partida: partidaController.getPartidas()){
                                if (partida.getEquipe1() == equipe){
                                    partida.mostrarDetalhes();

                                }else if(partida.getEquipe2() == equipe){
                                    partida.mostrarDetalhes();

                                }

                        }

                        System.out.println("\nPressione Enter para voltar ao menu...");
                        input.nextLine(); 
                        util.limpar_tela();
                    }else{
                        util.limpar_tela();
                        System.out.println("Não há partidas a serem exibidas...");
                    }

                        break;
                    case 3:
                        // Feature a ser produzida
                        System.out.println("[3] - Atualizar Senha;");
                        util.linhas();

                        System.out.println("Digite sua senha atual para seguir: ");
                        String senha_atual = input.nextLine();

                        if(senha_atual.equals(this.senha)){

                            System.out.println("Digite sua nova senha: ");
                            String senha_mod = input.nextLine();
                            atualizarSenha(senha_mod);
                            
                            util.limpar_tela();
                            System.out.println("Senha Alterada com Sucesso!");

                        }else{
                            util.limpar_tela();
                            System.out.println("Senha Incorreta! Tente novamente ou fale com o Administrador...");
                        }

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