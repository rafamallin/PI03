import java.util.Scanner;
import java.util.Random;
 
public class Main {
    public static void main(String[] args){
        Usuario usuario = new Usuario();
        Usuario[] imoveis = new Usuario[4];
        for (int i = 0; i < 4; i++) {
            imoveis[i] = new Usuario();
        }
        String[] perguntas = new String[10];
        double[] distancias = new double[4];
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        imoveis[0].setNome("Residencial Vila Verde");
        imoveis[1].setNome("Edifício Mirante do Sol");
        imoveis[2].setNome("Condomínio Terraço das Águas");
        imoveis[3].setNome("Studio Grand Horizon");
 
        for (int i = 0; i < 4; i++){
            imoveis[i].setPreco(100000 + random.nextInt((10000000 - 100000) + 1));
            imoveis[i].setArea(10 + random.nextInt((5000 - 10) + 1));
            imoveis[i].setNumQuartos(1 + random.nextInt((12 - 1) + 1));
        }
 
        System.out.print("\033[H\033[2J");
        System.out.printf("Bem vindo ao App CadeMeuImóvel\n");
        System.out.printf("Você terá de responder as especificações do imóvel que está procurando...\n");
        System.out.printf("Por favor, responda dentro do intervalo estabelecido.\n\n");
        
        usuario.setPreco(lerDoubleValido(scanner, "Qual o preço do imóvel que você está procurando?\n(R$100.000,00 a R$10.000.000,00)", 100000.0, 10000000.0));
        usuario.setArea(lerDoubleValido(scanner, "Qual a área do imóvel que você está procurando?\n(10 m² a 5.000 m²)", 10.0, 5000.0));
        usuario.setNumQuartos(lerDoubleValido(scanner, "Qual o número de quartos do imóvel que você está procurando?\n(de 1 a 12)", 1.0, 12.0));
 
        for (int i = 0; i < 4; i++){
            distancias[i] = usuario.DistanciaEuclidiana(usuario.getArray(), imoveis[i].getArray());
        }
 
        for (int i = 0; i < 4 - 1; i++) {
            for (int j = 0; j < 4 - i - 1; j++){
                if (distancias[j] > distancias[j + 1]){
                    double tempDist = distancias[j];
                    distancias[j] = distancias[j + 1];
                    distancias[j + 1] = tempDist;
 
                    Usuario tempUser = imoveis[j];
                    imoveis[j] = imoveis[j + 1];
                    imoveis[j + 1] = tempUser;
                }
            }
        }
 
        while (flag) {
            System.out.print("\033[H\033[2J");
            System.out.printf("Eis a lista, em ordem crescente, dos imóveis cadastrados");
            System.out.printf("mais próximos de suas especificações:\n");
 
            for (int i = 0; i < 4; i++) {
                System.out.printf("%d. %s\n", i + 1, imoveis[i].getNome());
            }
 
            System.out.printf("\nDigite o número do imóvel para ver as especificações ou 0 para sair: ");
            int escolha = scanner.nextInt();
 
            if (escolha == 0) {
                flag = false;
            } else if (escolha >= 1 && escolha <= 4) {
 
                System.out.print("\033[H\033[2J");
                Usuario selecionado = imoveis[escolha - 1];
 
                System.out.printf("%s:\n", selecionado.getNome());
                System.out.printf("     -Preço: R$%.2f\n", selecionado.getPreco());
                System.out.printf("     -Área: %.0f m²\n", selecionado.getArea());
                System.out.printf("     -Número de quartos: %.0f\n", selecionado.getNumQuartos());
 
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
    
    public static double lerDoubleValido(Scanner scanner, String mensagem, double min, double max) {
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            System.out.println(mensagem);
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.printf("Erro: O valor deve estar entre %.2f e %.2f.\n\n", min, max);
                }
            } else {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.\n");
                scanner.next();
            }
        }
        return valor;
    }
}