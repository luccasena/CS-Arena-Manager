import java.util.Scanner;

public class Visitante extends Usuario {


    public Visitante(String nomeCompleto){
        super.nomeCompleto = nomeCompleto;
    }

    public void mostrarMenu(){
        utils util = new utils();

    
		util.linhas();    
        System.out.println("                                       CS-Arena                                  ");
        util.linhas();
        System.out.println("[1] - Mostrar Equipes;");
        System.out.println("[2] - Mostrar Jogadores;");
        System.out.println("[3] - Histórico de Partidas;");
        System.out.println("[0] - Sair;");
        util.linhas();
        System.out.printf("Visitante: %s \n",nomeCompleto);
        util.linhas();

    }

    public void acessarPerfil(EquipeController equipeController, PartidaController partidaController){
        utils util = new utils();
        Scanner input = new Scanner(System.in);

        util.limpar_tela();
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
                    System.out.println("[1] - Mostrar Equipes;");
                    util.linhas();


                    if(equipeController.getEquipes().isEmpty()){
							System.out.println("Não existe Equipes a serem exibidos...");

					}else{

                        equipeController.mostrarEquipesJogadores(2);
                        System.out.println("\nPressione Enter para voltar ao menu...");
                        input.nextLine(); 
                        util.limpar_tela();

                    }

                    break;
                case 2:
                    // Feature  Concluída.
                    System.out.println("[2] - Mostrar Jogadores;");
                    util.linhas();

                     if(equipeController.nenhumJogador()){
							System.out.println("Não existe Jogadores a serem exibidas...");

					}else{

                        equipeController.mostrarEquipesJogadores(3);
                        System.out.println("\nPressione Enter para voltar ao menu...");
                        input.nextLine(); 

                        util.limpar_tela();
                    }
                
                    break;
                case 3:
                    // Feature  Concluída.
                    System.out.println("[3] - Histórico de Partidas;");

                    if(partidaController.getPartidas().isEmpty()){
                        util.linhas();
                        System.out.println("Não existe partidas a serem exibidas...");

					}else{
                        partidaController.mostrarPartidas(1);
                        System.out.println("\nPressione Enter para voltar ao menu...");
                        input.nextLine(); 
                        util.limpar_tela();

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

        

    }

}