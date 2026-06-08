import java.util.Scanner;
import java.util.Random;

import src.Imovel;
import src.Usuario;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        /*=======
        CABECARIO
        ========*/
        System.out.print("\033[H\033[2J");
        System.out.printf("Bem vindo ao App!\n");
        System.out.printf("Você terá de responder uma série de perguntas antes de prosseguir...\n");

        /*============================
        DEFININDO VALORES DOS USUÁRIOS
        ============================*/        
        System.out.printf("Qual o teu nome? ");
        String user_nome = scanner.nextLine();

        System.out.printf("Qual a tua preferência de preço? ");
        double user_preco = scanner.nextDouble();

        System.out.printf("Qual a tua preferência de área? (m²) ");
        double user_area = scanner.nextDouble();

        System.out.printf("Qual a tua preferência de número de quartos? ");
        double user_num_quartos = scanner.nextDouble();

        Usuario usuario = new Usuario(user_nome, user_preco, user_area, user_num_quartos);


        /*=============
        CRIANDO IMÓVEIS
        =============*/
        Random random = new Random();
        /*Min e Max*/
        double min_preco = 100000.00;
        double max_preco = 3000000.00;

        double min_area = 10.00;
        double max_area = 1000.00;

        double min_num_quartos = 1.00;
        double max_num_quartos = 10.00;
        
        /*Cria 4 imóveis*/
        Imovel[] imovel = new Imovel[4];
        for (int i = 0; i < 4; i++) {

            /*Sortear preco*/
            double imovel_preco = min_preco + (max_preco - min_preco) * random.nextDouble();
            
            /*Sortear area*/
            double imovel_area = min_area + (max_area - min_area) * random.nextDouble();

            /*Sortear numero de quartos*/
            double imovel_num_quartos = min_num_quartos + (max_num_quartos - min_num_quartos) * random.nextDouble();
            imovel[i] = new Imovel(imovel_preco, imovel_area, imovel_num_quartos);
        }

        //Var para distância euclidiana
        double[] distancias = new double[4];
        
        //Loop da interface
        boolean flag = true;

        for (int i = 0; i < 4; i++){
            distancias[i] = usuario.DistanciaEuclidiana(usuario.getArrayProblemas(), imovel[i].getArrayProblemas());
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
