import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Administrador extends Usuario implements acessoPlataforma{

	private String senha = " ";	

	public Jogador criarJogador(ArrayList<Equipe> equipes) {
		utils util = new utils();
		Scanner input = new Scanner(System.in);

		int escolha_classe = 0;
        int escolha_mapa = 0;
		int experienciaAnos = -1;
        String classe = "";
        String preferenciaMapa = "";
		String nickname = "";
		boolean nicknameDisponivel = false;

		// Tratamento de Erro: Nome ✅
		while (!nicknameDisponivel) {
			System.out.println("Digite o nickname do Jogador: ");
			nickname = input.nextLine().trim();

			if (nickname.isEmpty()) {
				util.limpar_tela();
				System.out.println("Nickname Inválido! Tente novamente...");
				util.linhas();
				continue; // volta para o início do while
			}

			boolean encontrado = false;

			for (Equipe equipe_aux : equipes) {
				for (Jogador jogador_aux : equipe_aux.getJogadores()) {
					if (jogador_aux.getNome().equalsIgnoreCase(nickname)) {
						encontrado = true;
						util.limpar_tela();
						System.out.println("Nickname não disponível! Tente novamente...");
						util.linhas();
						break;
					}
				}
				if (encontrado) break;
			}

			if (!encontrado) {
				nicknameDisponivel = true;
			}
		}		

		// Tratamento de Erro: Classe ✅
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
									"[6] Rifler");
                util.linhas();
                System.out.println("Digite a classe do Jogador baseado nos índices acima: ");
                escolha_classe = input.nextInt();
            }catch (Exception e) {
                System.out.println("Ocorreu um erro! Tente Novamente...");
                util.linhas();

            }if(escolha_classe >= 1 && escolha_classe <= 6){
                break;

            }else{
                input.nextLine();
                util.limpar_tela();
                System.out.println("Opção Inválida! Escolha uma opção entre 1 a 6");

            }
        }
        switch(escolha_classe){
            case 1: classe = "Entry Fragger"; break;
            case 2: classe = "Lurker"; break;
			case 3: classe = "AWP"; break;
            case 4: classe = "Playmaker"; break;
            case 5: classe = "Support"; break;
			case 6: classe = "Rifler"; break;
        }

		util.linhas();

		// Tratamento de Erro: experienciaAnos ✅
		while(true){
			try {
				System.out.println("Digite os anos de experiência do Jogador: ");
				experienciaAnos = input.nextInt();

			}catch(Exception e){
				util.limpar_tela();
				System.out.println("Ocorreu um erro! Tente Novamente...");
				util.linhas();

			}
			if(experienciaAnos >= 0){
				break;

			}else{
				input.nextLine();
				util.limpar_tela();
				System.out.println("Opção Inválida! tente novamente...");
				util.linhas();

			}
		}

		// Tratamento de Erro: Mapas ✅
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

            }
        }
        switch(escolha_mapa){
				case 1: preferenciaMapa = "Mirage"; break;
				case 2: preferenciaMapa = "Train"; break;
				case 3: preferenciaMapa = "Vertigo"; break;
				case 4: preferenciaMapa = "Nuke"; break;
				case 5: preferenciaMapa = "Ancient"; break;
				case 6: preferenciaMapa = "Inferno"; break;
				case 7: preferenciaMapa = "Overpass"; break;
				case 8: preferenciaMapa = "Dust II"; break;
			}
		
		return new Jogador(nickname, classe, experienciaAnos, preferenciaMapa);
	}

	public Equipe criarEquipe(ArrayList<Equipe> equipes,int id_aux_equipe) {
		utils util = new utils();
		Scanner input = new Scanner(System.in);
		String nomeEquipe = "";
		boolean nomeEquipeDisponivel = false;

		while (!nomeEquipeDisponivel) {
			System.out.println("Digite o nome do Equipe: ");
        	nomeEquipe = input.nextLine();

			if (nomeEquipe.isEmpty()) {
				util.limpar_tela();
				System.out.println("Nome de Equipe Inválido! Tente novamente...");
				util.linhas();
				continue; // volta para o início do while
			}

			boolean encontrado = false;

			for (Equipe equipe_aux : equipes) {
				for (Jogador jogador_aux : equipe_aux.getJogadores()) {
					if (jogador_aux.getNome().equalsIgnoreCase(nomeEquipe)) {
						encontrado = true;
						util.limpar_tela();
						System.out.println("Nome de Equipe não disponível! Tente novamente...");
						util.linhas();
						break;
					}
				}
				if (encontrado) break;
			}

			if (!encontrado) {
				nomeEquipeDisponivel = true;
			}
		}	

        System.out.println("Digite o país de origem: ");
        String paisOrigem = input.nextLine();

		return new Equipe(nomeEquipe, paisOrigem, id_aux_equipe);

	}

	public Partida criarPartida(EquipeController equipes, int id_aux_partida){ 

		utils util = new utils();
        Scanner input = new Scanner(System.in);

		DateTimeFormatter formatter_day = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter formatter_hora = DateTimeFormatter.ofPattern("HH:mm");

        Equipe equipe1 = null;
        int id_equipe1 = 0;
        Equipe equipe2 = null;
        int id_equipe2 = 0;

        boolean achou_equipe = false;

		LocalDate dia = null;
		LocalTime horario = null;

		while(true){
			try {
				System.out.println("Digite a data da partida mm/dd/aaaa: ");
				String diaStr = input.nextLine();
				dia = LocalDate.parse(diaStr, formatter_day);

			}catch(Exception e){
				util.limpar_tela();
				System.out.println("Data inválida! Formato correto: dd/mm/aaaa");
				util.linhas();
			}
			if(dia != null){
				break;
			}

		}

		while(true){
			try {
				System.out.println("Digite o horário da partida HH:MM: ");
				String horarioStr = input.nextLine();
				horario = LocalTime.parse(horarioStr, formatter_hora);

			} catch (Exception e) {
				util.limpar_tela();
				System.out.println("Horário inválido! Formato correto: HH:MM ");
				util.linhas();
			}if(horario != null){
				break;
			}
		}

       	util.linhas();

        while(true) {

			try{
				equipes.mostrarEquipesJogadores(0);
				util.linhas();
				System.out.println("\n1- Digite o ID de um equipe: ");
				id_equipe1 = input.nextInt();

				for (int i = 0; i < equipes.getEquipes().size(); i++) {
					if (id_equipe1 == equipes.getEquipe(i).getIdEquipe()) {
						equipe1 = equipes.getEquipe(i);
						achou_equipe = true;
						break;
					}
				}
				if (achou_equipe) {
					break;

				} else {
					util.limpar_tela();
					System.out.println("Equipe não encontrada! Tente novamente...");
					util.linhas();

				}
			}
			catch(Exception e){
				util.limpar_tela();
					System.out.println("Resposta Inválida! Tente novamente...");
					util.linhas();
			}

        }

       	util.linhas();
		achou_equipe = false;

        while(true){
            try{
				equipes.mostrarEquipesJogadores(0);
				System.out.println("\n2- Digite o ID de um equipe: ");
				id_equipe2 = input.nextInt();

				input.nextLine();

				for (int i = 0; i < equipes.getEquipes().size(); i++) {
					if (id_equipe1 == id_equipe2){
						break;
					}
					if (id_equipe2 == equipes.getEquipe(i).getIdEquipe()) {
						equipe2 = equipes.getEquipe(i);
						achou_equipe = true;
						break;
					}
				}
				if(achou_equipe){
					break;
				}else{
					util.limpar_tela();
					System.out.println("Equipe não encontrada ou ID repetido! Tente novamente...");
					util.linhas();
				}
			}catch(Exception e){
				util.limpar_tela();
					System.out.println("Resposta Inválida! Tente novamente...");
					util.linhas();
			}
    	}

		return new Partida(id_aux_partida, dia, horario, equipe1, equipe2);
	}
	
	public Partida atualizarVencedorPlacar( Partida partida){
		Scanner input = new Scanner(System.in);
		utils util = new utils();

		int escolha_mapa = 0; 
		String preferenciaMapa = "";
		ArrayList<String> mapas = new ArrayList<String>();

		String vencedor = "";
		String placar = "";

		while(true){
			while(true){
				try {
					util.linhas();
					System.out.printf("Mapas Disponíveis: ");

					System.out.println("");
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
					System.out.println("Digite o mapa que será jogado baseado nos índices acima: ");
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
				case 1: preferenciaMapa = "Mirage"; break;
				case 2: preferenciaMapa = "Train"; break;
				case 3: preferenciaMapa = "Vertigo"; break;
				case 4: preferenciaMapa = "Nuke"; break;
				case 5: preferenciaMapa = "Ancient"; break;
				case 6: preferenciaMapa = "Inferno"; break;
				case 7: preferenciaMapa = "Overpass"; break;
				case 8: preferenciaMapa = "Dust II"; break;
			}

			mapas.add(preferenciaMapa);
			util.linhas();
			System.out.printf("Mapas Adicionados: ");
					for(String mapString: mapas){
						if(mapas.size() == 0){
							continue;						
						}else{
							System.out.printf("%s ", mapString);
						}
					}

			int res;
			util.linhas();

			while (true){
				try{
					System.out.println("Deseja adicionar mais mapas? [1] - sim; [0] - [não]");
					res = input.nextInt();
					input.nextLine();

					if(res == 0 || res == 1){
						break;
					}else{
						util.limpar_tela();
						System.out.println("Opção inválida! Tente novamente...");
						util.linhas();
					}
					
				}catch (Exception e){
					util.limpar_tela();
					System.out.println("Opção inválida! Tente novamente...");
					util.linhas();
					input.nextLine();
				}
			}

			util.limpar_tela();
			if(res == 0){
				break;
			}
		}

		int id_vencedor;

		while(true){	
			try{
				partida.mostrarEquipes();
				util.linhas();
				System.out.println("Digite o ID da equipe vencedora: ");
				id_vencedor = input.nextInt();

				if(id_vencedor == partida.getEquipe1().getIdEquipe()){
					break;

				}else if(id_vencedor == partida.getEquipe2().getIdEquipe()){
					break;

				}else{
					util.limpar_tela();
					System.out.println("ID incorreto! Tente novamente...");
					util.linhas();

				}

			}catch(Exception e){
				util.limpar_tela();
				System.out.println("Opção inválida! Tente novamente...");
				util.linhas();

			}
		}

		if (id_vencedor == partida.getEquipe1().getIdEquipe()) {
			vencedor = partida.getEquipe1().getNomeEquipe();	

		} else if (id_vencedor == partida.getEquipe2().getIdEquipe()) {
			vencedor = partida.getEquipe2().getNomeEquipe();	

		}

		input.nextLine();
		util.limpar_tela();

		for(String mapString: mapas){
			if(mapas.size() == 0){
				continue;						
			}else if(mapas.size() == 1){
				util.linhas();
				System.out.printf("Mapas Adicionados: %s ", mapString);

			}else{
				System.out.printf("%s ", mapString);
				}
		}
		
		System.out.println("");
		util.linhas();
		System.out.println("Digite o placar da partida: exemplo -> 3x1");
		placar = input.nextLine();

		partida.setVencedor(vencedor);
		partida.setPlacar(placar);
		partida.setMapas(mapas);
		
		util.limpar_tela();

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

				util.limpar_tela();
				input.nextLine(); 
				switch(escolha){
					
					case 1:
						// Feature  Concluída.
						System.out.println("[1] - Cadastrar Equipe");
						util.linhas();

						equipe = criarEquipe(equipeController.getEquipes(), equipeController.getIdEquipe());

						equipeController.addEquipe(equipe);

						equipeController.setIdEquipe(1);

						util.limpar_tela();
						System.out.printf("Equipe '%s' cadastrada com sucesso {%d}!\n", equipe.getNomeEquipe(), equipe.getIdEquipe());

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
							System.out.println("\nPressione Enter tecla para voltar ao menu...");
            				input.nextLine(); 
							util.limpar_tela();

						}

						break;
					case 3:
						// Feature a ser produzida
						System.out.println("[3] - Remover Equipes");
						util.linhas();

						if(equipeController.getEquipes().isEmpty()){
							System.out.println("Não existe Equipes a serem removidas!...");
							System.out.println("Adicione uma Equipe selecionando a opção [1]!");

						}else{
							if (equipeController.getEquipes().isEmpty()) { // se tiver vazio
								System.out.println("Nenhum Equipe cadastrado para remover.");
							}else{
								while(true){	
									int idRemover = -2;

									try{
										equipeController.mostrarEquipesJogadores(0); // mostra as Equipes para exclusão
										util.linhas();
										System.out.println("Digite o ID da Equipe que deseja remover ou digite [-1] para sair: ");

										idRemover = input.nextInt();
										// limpa

									}catch (Exception e){
										util.limpar_tela();
										System.out.println("Opção Inválida! Tente novamente...");

									}

									if(idRemover == -1){
											util.limpar_tela();
											break;
									}

									boolean removido = false;

									for (int i = 0; i < equipeController.getEquipes().size(); i++) { // se o id que foi pesquisado for igual ao id do Equipe
										if (equipeController.getEquipes().get(i).getIdEquipe() == idRemover) {
											util.limpar_tela();
											System.out.println("Equipe '" + equipeController.getEquipes().get(i).getNomeEquipe() + "' (ID: " + idRemover + ") removido com sucesso!");
											equipeController.getEquipes().remove(i); // AQUI: removemos o Equipe da lista principal
											equipeController.setIdEquipe(-1);
											removido = true;

											for (int j = idRemover; j < equipeController.getEquipes().size(); j++) {
												equipeController.getEquipes().get(j).setIdEquipe(j);
											}

											break;

										}else if(idRemover == -1){
											break;
										}
									}

									// "não removido" depois de olhar todos os Equipes:
									if (!removido) {
										util.limpar_tela();
										System.out.println("ID de Equipe não encontrado! Tente novamente..."); // avisa que não achou o ID.
										util.limpar_tela();
									}else if(removido || idRemover == -1){
										break;
									}

									
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

						}else if(equipeController.equipesCheia()){
							System.out.println("Equipes cheias para o cadastro do Jogador!...");
							System.out.println("Adicione um Equipe selecionando a opção [1]!");
							
						}else{
							boolean encontrou_Equipe = false;
							int escolha_cadastro;

							Jogador jogador = criarJogador(equipeController.getEquipes());
							util.limpar_tela();

							// Tratamento de Erro: Equipes ✅
							while(true){
								System.out.println("Equipes Cadastradas:" );
								util.linhas();
								
								int id_Equipe = -1;

								while(true){	
									try{
										equipeController.mostrarEquipesJogadores(1); 
										System.out.println("Digite o ID do Equipe desejado para o cadastro do jogador: ");
										id_Equipe = input.nextInt();

										if(id_Equipe >= 0 && id_Equipe <= equipeController.getEquipes().getLast().getIdEquipe()){
											break;
										}else{
											util.limpar_tela();
											System.out.println("Índice Incorreto! Tente Novamente...");
											util.linhas();

										}

									}catch(Exception e){
										util.limpar_tela();
										input.nextLine();
										System.out.println("Opção Inválida! Tente Novamente...");
										util.linhas();
									}
								}

								equipeController.getEquipe(id_Equipe);

								util.limpar_tela();

								for (int i = 0; i < equipeController.getEquipes().size(); i++) {
									if (id_Equipe == equipeController.getEquipes().get(i).getIdEquipe() && equipeController.getEquipes().get(i).getQuantJogador() < 5) {

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
									System.out.println("ID não encontrado ou Equipe com limite máximo de integrantes...");
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
						boolean removeu_jogador = false;
						String nomeJogador = "";


						if(equipeController.nenhumJogador() || equipeController.getEquipes().isEmpty()){
							System.out.println("Não existe jogadores a serem removidos!...");
							System.out.println("Adicione um jogador selecionando a opção [4]!");

						}else{
							while(true){		
								equipeController.mostrarEquipesJogadores(2);
								System.out.println("Digite o nome do jogador para remove-lo ou [-1] para sair:");
								nomeJogador = input.nextLine();

								for(int i = 0;i < equipeController.getEquipes().size(); i++){

									equipe = equipeController.getEquipe(i);
									for (int j = 0; j < equipe.getJogadores().size(); j++) {
										if (nomeJogador.equalsIgnoreCase(equipe.getJogador(j).getNome())) {
											util.limpar_tela();

											equipe.rmvJogador(equipe.getJogadores().remove(j));
											System.out.println("Jogador '" + nomeJogador + "' removido com sucesso!");
											removeu_jogador = true;

											break;

										}else if(nomeJogador.equalsIgnoreCase("-1")){
											
											break;
										}else{
											util.limpar_tela();
											System.out.println("ERRO: Jogador '" +nomeJogador+ "' não encontrado!");
										}
									}
								}

								if(removeu_jogador || nomeJogador.equalsIgnoreCase("-1")){
									break;
								}
							}	
						}

						if(removeu_jogador){
							util.limpar_tela();
							System.out.println("Jogador '"+nomeJogador+"' removido com sucesso!");


						}else if(nomeJogador.equalsIgnoreCase("-1")){
							util.limpar_tela();
							
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

							equipeController.mostrarEquipesJogadores(4);
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
							partidaController.setIdPartida(1);

							util.limpar_tela();
							System.out.println("Partida marcada com sucesso!");

						}


						break;
					case 8:
						// Feature concluída
						System.out.println("[8] - Histórico de Partidas");


						if(partidaController.getPartidas().isEmpty()){
							System.out.println("Não existe partidas a serem exibidas...");
							System.out.println("Adicione uma partida selecionando a opção [7]!");

						}else{
							partidaController.mostrarPartidas(1);
							System.out.println("\nPressione Enter tecla para voltar ao menu...");
							input.nextLine();

						}
						util.limpar_tela();

						break;
					case 9:
						// Feature a ser produzida
						System.out.println("[9] - Atualizar Partidas");

						if(partidaController.getPartidas().isEmpty()){
							System.out.println("Não existe partidas a serem atualizadas...");
							System.out.println("Adicione uma partida selecionando a opção [7]!");

						}else{
			
							partidaController.mostrarPartidas(1);
							
							util.linhas();
							System.out.println("Digite o ID da partida que deseja ser modificada: ");
							int idPartida = input.nextInt();
							Partida partida3 = partidaController.getPartida(idPartida);

							partida3 = atualizarVencedorPlacar(partida3);

							util.limpar_tela();
							System.out.printf("Partida {%d} atualizada com sucesso!\n", idPartida);
							
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