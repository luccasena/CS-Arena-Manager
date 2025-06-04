
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Administrador extends Usuario implements acessoPlataforma{

	private String senha = " ";	

	public Jogador criarJogador() {
		utils util = new utils();
		Scanner input = new Scanner(System.in);

		int escolha_classe = 0;
        int escolha_mapa = 0;
        String classe = "";
        String preferenciaMapa = "";

        System.out.println("Digite o nome completo do Jogador: ");
        String nomeCompleto = input.nextLine();

        while(true){
            try {
                util.linhas();
                System.out.printf("Classes Disponíveis:\n");
                util.linhas();
				System.out.println(	"[1] Entry Fragger\n" +
									"[2] Lurker\n" +
									"[3] AWP\n" +
									"[4] Playmaker\n" +
									"[5] Support\n"+
									"[6] Rifler\n");
                util.linhas();
                System.out.println("Digite a classe do Jogador baseado nos índices acima: ");
                escolha_classe = input.nextInt();
            }catch (Exception e) {
                util.limpar_tela();
                System.out.println("Ocorreu um erro! Tente Novamente...");
                util.linhas();
            }if(escolha_classe >= 1 && escolha_classe <= 6){
                break;
            }else{
                input.nextLine();
                util.limpar_tela();
                System.out.println("Opção Inválida! Escolha uma opção entre 1 a 6");
                util.linhas();
            }
        }

        switch(escolha_classe){
            case 1:
                classe = "Entry Fragger";
                break;

            case 2:
                classe = "Lurker";
                break;

            case 3:
                classe = "AWP";
                break;

            case 4:
                classe = "Playmaker";
                break;

            case 5:
                classe = "Support";
                break;

			case 6:
				classe = "Rifler";
				break;
        }

        System.out.println("Digite os anos de experiência do Jogador: ");
        int experienciaAnos = input.nextInt();


        while(true){
            try {
                util.linhas();
                System.out.printf("Mapas Disponíveis:\n");
                util.linhas();
                System.out.println( "[1] Mirage\n" +
                        "[2] Train\n" +
                        "[3] Vertigo\n" +
                        "[4] Nuke\n" +
                        "[5] Ancient\n"+
                        "[6] Inferno\n"+
                        "[7] Overpass\n"+
                        "[8] Dust II");
                util.linhas();
                System.out.println("Digite o mapa preferido do Jogador baseado nos índices acima: ");
                escolha_mapa = input.nextInt();
            }catch(Exception e){
                util.limpar_tela();
                System.out.println("Ocorreu um erro! Tente Novamente...");
                util.linhas();

            }if(escolha_mapa >= 1 && escolha_mapa <= 8){
                break;

            }else{
                input.nextLine();
                util.limpar_tela();
                System.out.println("Opção Inválida! Escolha uma opção entre 1 a 8");
                util.linhas();

            }
        }

        switch(escolha_mapa){
            case 1:
                preferenciaMapa = "Mirage";
                break;

            case 2:
                preferenciaMapa = "Train";
                break;

            case 3:
                preferenciaMapa = "Vertigo";
                break;

            case 4:
                preferenciaMapa = "Nuke";
                break;

            case 5:
                preferenciaMapa = "Ancient";
                break;

            case 6:
                preferenciaMapa = "Inferno";
                break;

            case 7:
                preferenciaMapa = "Overpass";
                break;

            case 8:
                preferenciaMapa = "Dust II";
                break;

        }
		return new Jogador(nomeCompleto, classe, experienciaAnos, preferenciaMapa);
	}

	public Equipe criarEquipe(int id_aux_equipe) {
		Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do Equipe: ");
        String nomeEquipe = input.nextLine();

        System.out.println("Digite o país de origem: ");
        String paisOrigem = input.nextLine();

		return new Equipe(nomeEquipe, paisOrigem, id_aux_equipe);

	}

	public Partida criarPartida(EquipeController equipes, int id_aux_partida){ 

		utils aux = new utils();
        Scanner input = new Scanner(System.in);

        String equipe1Nome = "";
        int id_equipe1 = 0;
        String equipe2Nome = "";
        int id_equipe2 = 0;

        boolean achou_equipe = false;

        System.out.println("Digite a data da partida (MM/DD/AAAA): ");
        String diaStr = input.nextLine();
		LocalDate dia = LocalDate.parse(diaStr);

        System.out.println("Digite o horário da partida (HH:MM): ");
        String horarioStr = input.nextLine();
		LocalDateTime horario = LocalDateTime.parse(horarioStr);

        aux.linhas();

        while(true) {

			equipes.mostrarEquipesJogadores(2);
            System.out.println("1- Digite o ID de um equipe: ");
            id_equipe1 = input.nextInt();

            for (int i = 0; i < equipes.getEquipes().size(); i++) {
                if (id_equipe1 == equipes.getEquipe(i).getIdEquipe()) {
                    equipe1Nome = equipes.getEquipe(i).getNomeEquipe();
                    achou_equipe = true;
                    break;
                }
            }
            if (achou_equipe) {
                break;
            } else {
                aux.limpar_tela();
                System.out.println("equipe não encontrado! Tente novamente...");
                aux.linhas();
            }
        }

        aux.linhas();
        while(true){
            aux.limpar_tela();

            equipes.mostrarEquipesJogadores(2);
            System.out.println("2- Digite o ID de um equipe: ");
            id_equipe2 = input.nextInt();

            input.nextLine();

            for (int i = 0; i < equipes.getEquipes().size(); i++) {
                if (id_equipe2 == equipes.getEquipe(i).getIdEquipe()) {
                    equipe2Nome = equipes.getEquipe(i).getNomeEquipe();
                    achou_equipe = true;
                    break;
                }
            }
            if(achou_equipe){
                break;
            }else{
                aux.limpar_tela();
                System.out.println("equipe não encontrado! Tente novamente...");
                aux.linhas();
            }

        }

		return new Partida(id_aux_partida, dia, horario, equipe1Nome, equipe2Nome);
	}
	
	public Partida atualizarVencedorPlacar(Partida partida, String vencedor, String placar){
		partida.setVencedor(vencedor);
		partida.setPlacar(placar);

		return partida;

	}
	
	public void mostrarMenu() {
		utils util = new utils();

		util.linhas();
        System.out.println("                                  CS-Arena-Manager                                ");
        util.linhas();
        System.out.println("[1] - Criar Equipe;");
        System.out.println("[2] - Mostrar Equipes;");
        System.out.println("[3] - Remover Equipe;");
        System.out.println("[4] - Cadastrar Jogador;");
        System.out.println("[5] - Remover Jogador;");
        System.out.println("[6] - Mostrar Jogadores");
        System.out.println("[7] - Marcar Partidas;");
        System.out.println("[8] - Histórico de Partidas;");
        System.out.println("[9] - Atualizar Partidas;");
        System.out.println("[0] - Sair;");
        util.linhas();

	}

	public void menuAtualizarPartida() {
        utils util = new utils();
		util.linhas();
        System.out.println("          Gerenciador de Partidas           ");
        util.linhas();
        System.out.println("[1] - Definir Vencedor da Partida e Placar;");
        System.out.println("[2] - Definir Mapas das Partidas;");
        System.out.println("[0] - Sair do Gerenciador;");
        util.linhas();

    }

	public void acessarPerfil(String senha, EquipeController equipeController, PartidaController partidaController){
		utils util = new utils();
		if(senha.equals(this.senha)){


			util.limpar_tela();
			System.out.println("Nível de Acesso - Administrador;");
			Scanner input = new Scanner(System.in);

			Equipe equipe;

			int id_util_equipe = 0;
			int id_util_partida = 0;
	
			while(true){

				Partidas partida;
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

				util.limpar_tela();
				input.nextLine(); 
				switch(escolha){
					
					case 1:
						// Feature  Concluída.
						System.out.println("[1] - Cadastrar Equipe");
						util.linhas();

						equipe = criarEquipe(equipeController.getIdEquipe());
						equipeController.addEquipe(equipe);

						equipeController.setIdEquipe(1);

						util.limpar_tela();
						System.out.printf("Equipe %s cadastrada com sucesso {%d}!\n", equipe.getNomeEquipe(), equipe.getIdEquipe());

						break;
					case 2:
						// Feature  Concluída.
						System.out.println("[2] - Mostrar Equipes");
						util.linhas();

						if(equipeController.getEquipes().isEmpty()){
							System.out.println("Não existe Equipes a serem exibidas...");
							System.out.println("Adicione uma Equipe selecionando a opção [1]!");

						}else{
							System.out.println("Informações sobre as Equipes:" );
							util.linhas();
							equipeController.mostrarEquipesJogadores(1);
							System.out.println("\nPressione qualquer tecla para voltar ao menu...");
            				input.nextLine(); 
							util.limpar_tela();

						}

						break;
					case 3:
						// Feature a ser produzida
						System.out.println("[3] - Remover Equipes");
						util.linhas();

						if(equipeController.getEquipes().isEmpty()){
							System.out.println("Não existe Equipes a serem removidos!...");
							System.out.println("Adicione um Equipe selecionando a opção [1]!");

						}else{
							if (equipeController.getEquipes().isEmpty()) { // se tiver vazio
								System.out.println("Nenhum Equipe cadastrado para remover.");
							} else {
								equipeController.mostrarEquipesJogadores(0); // mostra as Equipes para exclusão
								System.out.println("Digite o ID do Equipe que deseja remover: ");

								int idRemover = input.nextInt();
								input.nextLine(); // limpa

								boolean removido = false;
								for (int i = 0; i < equipeController.getEquipes().size(); i++) { // se o id que foi pesquisado for igual ao id do Equipe
									if (equipeController.getEquipes().get(i).getIdEquipe() == idRemover) {
										util.limpar_tela();
										System.out.println("Equipe '" + equipeController.getEquipes().get(i).getNomeEquipe() + "' (ID: " + idRemover + ") removido com sucesso!");
										equipeController.getEquipes().remove(i); // AQUI: removemos o Equipe da lista principal
										equipeController.setIdEquipe(-1);

										for (int j = idRemover; j < equipeController.getEquipes().size(); j++) {
            								equipeController.getEquipes().get(j).setIdEquipe(j);
        								}

										break;
									}
								}
								// "não removido" depois de olhar todos os Equipes:
								if (!removido) {
									System.out.println("ID de Equipe não encontrado."); // avisa que não achou o ID.
								}

							}

						}

						break;
					case 4:
						// Feature  Concluída.
						System.out.println("[4] - Cadastrar Jogador");
						util.linhas();

						if(equipeController.getEquipes().isEmpty()){
							System.out.println("Não existe Equipes para o cadastro do Jogador!...");
							System.out.println("Adicione um Equipe selecionando a opção [1]!");

						}else if(equipeController.equipeCheia()){
							System.out.println("Equipes cheias para o cadastro do Jogador!...");
							System.out.println("Adicione um Equipe selecionando a opção [1]!");
							
						}else{
							boolean encontrou_Equipe = false;
							int escolha_cadastro;

							Jogador jogador = criarJogador();
							util.limpar_tela();

							while(true){
								System.out.println("Equipes Cadastrados:" );
								util.linhas();

								equipeController.mostrarEquipesJogadores(1); 

								System.out.println("Digite o ID do Equipe desejado para o cadastro do jogador: ");

								int id_Equipe = input.nextInt();
								util.limpar_tela();

								for (int i = 0; i < equipeController.getEquipes().size(); i++) {
									if (id_Equipe == equipeController.getEquipes().get(i).getIdEquipe()) {

										equipeController.getEquipe(i).addJogador(jogador);
										jogador.setEquipe(equipeController.getEquipe(i));
										encontrou_Equipe = true;

										util.limpar_tela();
										System.out.printf("Jogador '%s' adicionado na equipe '%s' com sucesso!\n", jogador.getNome(), jogador.getEquipe().getNomeEquipe());

										break;
									}
								}
								if (!encontrou_Equipe) {
									util.limpar_tela();
									System.out.println("ID não encontrado...");
									util.linhas();
									System.out.println("[1]- Cancelar Cadastro;\n[2]- Adicionar em outro Equipe;");
									util.linhas();
									System.out.println("Você deseja adicionar em outro Equipe ou cancelar o cadastro?");
									escolha_cadastro = input.nextInt();

								}else{
									break;
								}

								util.limpar_tela();
								if(escolha_cadastro == 1){
									System.out.println("Cadastro Cancelado...");
									break;
								}

							}
						}

						break;
					case 5:
						// Feature a ser produzida
						System.out.println("[5] - Remover Jogador");
						util.linhas();


						if(equipeController.nenhumJogador() || equipeController.getEquipes().isEmpty()){
							System.out.println("Não existe jogadores a serem removidos!...");
							System.out.println("Adicione um jogador selecionando a opção [4]!");

						}else{
							equipeController.mostrarEquipesJogadores(2);
							System.out.println("Digite o nome do jogador para remove-lo:");
							String nomeJogador = input.nextLine();

							for(int i = 0;i < equipeController.getEquipes().size(); i++){

								equipe = equipeController.getEquipe(i);
								for (int j = 0; j < equipe.getJogadores().size(); j++) {
									if (nomeJogador.equalsIgnoreCase(equipe.getJogador(j).getNome())) {
										util.limpar_tela();

										equipe.rmvJogador(equipe.getJogadores().remove(j));
										System.out.println("Jogador " + nomeJogador + " removido com sucesso!");
										break;

									}else{
										equipeController.nenhumJogador();
										util.limpar_tela();
										System.out.println("ERRO: Jogador '" +nomeJogador+ "' não encontrado!");

									}


    }
							}

						}

						break;
					case 6:
						// Feature  Concluída.
						System.out.println("[6] - Mostrar Jogadores");
						util.linhas();

						if(equipeController.nenhumJogador()){
							System.out.println("Não existe jogadores a serem exibidos!...");
							System.out.println("Adicione um jogador selecionando a opção [4]!");

						}else{

							equipeController.mostrarEquipesJogadores(3);
							System.out.println("\nPressione Enter para voltar ao menu...");
            				input.nextLine();

							util.limpar_tela();

						}

						break;
					case 7:
						// Feature Parcialmente Concluída, falta tratamento.

						System.out.println("[7] - Marcar Partidas");
						util.linhas();

						if(equipeController.getEquipes().isEmpty() || equipeController.getEquipes().size() < 2){
							System.out.println("Não existe Equipes o suficiente para marcar uma partida...");
							System.out.println("Adicione um Equipe selecionando a opção [1]!");

						}else{
							
							Partida partida_aux = criarPartida(equipeController, partidaController.getIdPartida());
							
							partidaController.addPartida(partida_aux);

							id_util_partida++;
							util.limpar_tela();
							System.out.println("Partida marcada com sucesso!");

						}


						break;
					case 8:
						// Feature concluída
						System.out.println("[8] - Histórico de Partidas");
						util.linhas();

						if(partidaController.getPartidas().isEmpty()){
							System.out.println("Não existe partidas a serem exibidas...");
							System.out.println("Adicione uma partida selecionando a opção [7]!");

						}else{
							partidaController.mostrarPartidas(2);

						}

						break;
					case 9:
						// Feature a ser produzida
						System.out.println("[9] - Atualizar Partidas");
						util.linhas();

						if(partidaController.getPartidas().isEmpty()){
							System.out.println("Não existe partidas a serem atualizadas...");
							System.out.println("Adicione uma partida selecionando a opção [7]!");

						}else{
							
							
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
					// equipeController.setIdEquipe(id_aux_equipe);
					// partidaController.setIdPartida(id_aux_partida);

					break;
				}
				}
			}else{
				util.limpar_tela();
				System.out.println("Senha inválida! Tente novamente...");
		}
	}

}
