import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Imovel[] imoveis = new Imovel[4];
        String[] siglasLdk = {"R", "K", "DK", "LDK"};
        
        imoveis[0] = new Imovel("Residencial Vila Verde", 450000.0, 120.0, 3, "DK");
        imoveis[1] = new Imovel("Edifício Mirante do Sol", 850000.0, 250.0, 4, "LDK");
        imoveis[2] = new Imovel("Condomínio Terraço das Águas", 250000.0, 65.0, 2, "K");
        imoveis[3] = new Imovel("Studio Grand Horizon", 180000.0, 35.0, 1, "R");

        System.out.print("\033[H\033[2J");
        System.out.println("Bem vindo ao App CadeMeuImóvel");
        System.out.println("Defina os intervalos de sua preferência para busca por similaridade.\n");

        System.out.println("--- Preferência de Preço ---");
        double precoMin = lerDoubleValido(scanner, "Digite o preço MÍNIMO desejado (R$) (mín: R$100.000): ", 100000.0, 10000000.0);
        double precoMax = lerDoubleValido(scanner, "Digite o preço MÁXIMO desejado (R$) (mín: R$10.000.000): ", precoMin, 10000000.0);
        Intervalo intPreco = new Intervalo(precoMin, maxPrecoValido(precoMin, precoMax));

        System.out.println("\n--- Preferência de Área ---");
        double areaMin = lerDoubleValido(scanner, "Digite a área MÍNIMA desejada (m²) (mín: 10 m²): ", 10.0, 5000.0);
        double areaMax = lerDoubleValido(scanner, "Digite a área MÁXIMA desejada (m²) (mín 5.000 m²): ", areaMin, 5000.0);
        Intervalo intArea = new Intervalo(areaMin, maxAreaValida(areaMin, areaMax));

        System.out.println("\n--- Outros Atributos ---");
        System.out.println("Qual o número de quartos ideal? (1 a 12)");
        int quartos = (int) lerDoubleValido(scanner, "Quantidade: ", 1.0, 12.0);

        String ldk = "";
        boolean ldkValido = false;
        while (!ldkValido) {
            System.out.println("Qual a configuração de cômodos desejada? (R, K, DK, LDK)");
            ldk = scanner.next().toUpperCase();
            if (ldk.equals("R") || ldk.equals("K") || ldk.equals("DK") || ldk.equals("LDK")) {
                ldkValido = true;
            } else {
                System.out.println("Opção inválida. Digite novamente.");
            }
        }

        Perfil perfilUsuario = new Perfil(intPreco, intArea, quartos, ldk);

        double[] distancias = new double[4];
        for (int i = 0; i < 4; i++) {
            distancias[i] = perfilUsuario.calc_distancia_euclidiana(imoveis[i]);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 - i; j++) {
                if (distancias[j] > distancias[j + 1]) {
                    double tempDist = distancias[j];
                    distancias[j] = distancias[j + 1];
                    distancias[j + 1] = tempDist;

                    Imovel tempImovel = imoveis[j];
                    imoveis[j] = imoveis[j + 1];
                    imoveis[j + 1] = tempImovel;
                }
            }
        }

        boolean flag = true;
        while (flag) {
            System.out.print("\033[H\033[2J");
            System.out.println("Eis a lista de imóveis por ordem de similaridade (mais próximos):");

            for (int i = 0; i < 4; i++) {
                System.out.printf("%d. %s (Distância: %.4f)\n", i + 1, imoveis[i].getNome(), distancias[i]);
            }

            System.out.print("\nDigite o número do imóvel para ver os detalhes ou 0 para sair: ");
            int escolha = scanner.nextInt();

            if (escolha == 0) {
                flag = false;
            } else if (escolha >= 1 && escolha <= 4) {
                System.out.print("\033[H\033[2J");
                Imovel selecionado = imoveis[escolha - 1];

                System.out.printf("%s:\n", selecionado.getNome());
                System.out.printf("     - Preço: R$ %.2f\n", selecionado.get_preco());
                System.out.printf("     - Área: %.2f m²\n", selecionado.get_area());
                System.out.printf("     - Número de quartos: %d\n", selecionado.get_n_quartos());
                System.out.printf("     - Tipo de cômodos (Padrão JP): %s\n", selecionado.get_ldk());

                System.out.print("\nDigite 1 para voltar ou 0 para sair: ");
                int voltar = scanner.nextInt();

                if (voltar == 0) {
                    flag = false;
                }
            } else {
                System.out.println("Opção inválida! Pressione Enter para continuar...");
                scanner.nextLine();
                scanner.nextLine();
            }
        }
        scanner.close();
        System.out.print("\033[H\033[2J");
        System.out.println("Programa finalizado...");
    }

    public static double lerDoubleValido(Scanner scanner, String mensagem, double min, double max) {
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensagem);
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.printf("Erro: O valor deve estar dentro do intervalo estipulado\n\n");
                }
            } else {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.\n");
                scanner.next();
            }
        }
        return valor;
    }

    private static double maxPrecoValido(double min, double max) {
        return max < min ? min + 100000 : max;
    }

    private static double maxAreaValida(double min, double max) {
        return max < min ? min + 10 : max;
    }
}