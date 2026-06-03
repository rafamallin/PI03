import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Usuario usuario = new Usuario();
        Usuario[] usuarios = new Usuario[4];
        for (int i = 0; i < 4; i++) {
            usuarios[i] = new Usuario();
        }
        String[] perguntas = new String[10];
        double[] distancias = new double[4];
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        usuarios[0].setNome("Isabela Costa Ribeiro");
        usuarios[1].setNome("Lucas Andrade Ferreira");
        usuarios[2].setNome("Felipe Martins Souza");
        usuarios[3].setNome("Camila Rocha Alves");

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 4; j++){
                usuarios[j].setProblema(i, usuario.gerarNume());
            }
        }

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 10; j++){
                if (usuarios[i].getProblema(j) == 1){
                    if (j == 0){
                        usuarios[i].setProblemaNome(j, "Ansiedade Generalizada (TAG)");
                    }
                    if (j == 1){
                        usuarios[i].setProblemaNome(j, "Depressão (Transtorno Depressivo Maior)");
                    }
                    if (j == 2){
                        usuarios[i].setProblemaNome(j, "Fobias Específicas e Ansiedade Social");
                    }
                    if (j == 3){
                        usuarios[i].setProblemaNome(j, "Transtorno de Déficit de Atenção e Hiperatividade (TDAH)");
                    }
                    if (j == 4){
                        usuarios[i].setProblemaNome(j, "Transtorno de Pânico");
                    }
                    if (j == 5){
                        usuarios[i].setProblemaNome(j, "Estresse Pós-Traumático (TEPT)");
                    }
                    if (j == 6){
                        usuarios[i].setProblemaNome(j, "Transtorno Bipolar");
                    }
                    if (j == 7){
                        usuarios[i].setProblemaNome(j, "Transtorno Obsessivo-Compulsivo (TOC)");
                    }
                    if (j == 8){
                        usuarios[i].setProblemaNome(j, "Transtorno de Personalidade Borderline (TPB)");
                    }
                    if (j == 9){
                        usuarios[i].setProblemaNome(j, "Esquizofrenia e Psicoses");
                    }
                }
            }
        }

        System.out.print("\033[H\033[2J");
        System.out.printf("Bem vindo ao App DaUmHelpAqui!\n");
        System.out.printf("Você terá de responder uma série de perguntas antes de prosseguir...\n");
        System.out.printf("Por favor, responda 0 para não e 1 para sim.\n\n");

        perguntas[0] = "Você sofre de Transtorno de Ansiedade Generalizada (TAG)?";
        perguntas[1] = "Você sofre de Depressão (Transtorno Depressivo Maior)?";
        perguntas[2] = "Você sofre de Fobias Específicas e Ansiedade Social?";
        perguntas[3] = "Você sofre de Transtorno de Déficit de Atenção e Hiperatividade (TDAH)?";
        perguntas[4] = "Você sofre de Transtorno de Pânico?";
        perguntas[5] = "Você sofre de Transtorno de Estresse Pós-Traumático (TEPT)?";
        perguntas[6] = "Você sofre de Transtorno Bipolar?";
        perguntas[7] = "Você sofre de Transtorno Obsessivo-Compulsivo (TOC)?";
        perguntas[8] = "Você sofre de Transtorno de Personalidade Borderline (TPB)?";
        perguntas[9] = "Você sofre de Esquizofrenia e Psicoses?";

        for (int i = 0; i < 10; i++){
            System.out.printf("%s ", perguntas[i]);
            usuario.setProblema(i, scanner.nextInt());
        }

        for (int i = 0; i < 4; i++){
            distancias[i] = usuario.DistanciaEuclidiana(usuario.getArrayProblemas(), usuarios[i].getArrayProblemas());
        }

        for (int i = 0; i < 4 - 1; i++) {
            for (int j = 0; j < 4 - i - 1; j++){
                if (distancias[j] > distancias[j + 1]){
            
                    double tempDist = distancias[j];
                    distancias[j] = distancias[j + 1];
                    distancias[j + 1] = tempDist;

                    Usuario tempUser = usuarios[j];
                    usuarios[j] = usuarios[j + 1];
                    usuarios[j + 1] = tempUser;
                }
            }
        }

        while (flag) {
            System.out.print("\033[H\033[2J");
            System.out.printf("Eis a lista, em ordem crescente, das pessoas cadastradas");
            System.out.printf("mais próximas do seu estado mental:\n");

            for (int i = 0; i < 4; i++) {
                System.out.printf("%d. %s\n", i + 1, usuarios[i].getNome());
            }

            System.out.printf("\nDigite o número do usuário para ver o perfil ou 0 para sair: ");
            int escolha = scanner.nextInt();

            if (escolha == 0) {
                flag = false;
            } else if (escolha >= 1 && escolha <= 4) {

                System.out.print("\033[H\033[2J");
                Usuario selecionado = usuarios[escolha - 1];

                System.out.printf("%s diz sofrer de:\n\n", selecionado.getNome());

                for (int i = 0; i < 10; i++) {
                    if (selecionado.getProblema(i) == 1) {
                        System.out.printf("     -%s\n", selecionado.getProblemaNome(i));
                    }
                }

                System.out.print("\nDigite 1 para voltar ou 0 para sair: ");
                int voltar = scanner.nextInt();

                if (voltar == 0) {
                    flag = false;
                }
            } else {
                System.out.printf("Opção inválida!");
            }
        }
    
        scanner.close();
        System.out.print("\033[H\033[2J");
        System.out.printf("Programa finalizado...");
    }   
}
