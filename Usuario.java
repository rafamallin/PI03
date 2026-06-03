import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Usuario {
    private String nome;
    private double[] problemas = new double[10];
    private String[] problemasNomes = new String[10];

    public String getNome(){
        return this.nome;
    }

    public void setNome(String no){
        this.nome = no;
    }

    public double getProblema(int index){
        return this.problemas[index];
    }

    public double[] getArrayProblemas(){
        return Arrays.copyOf(this.problemas, this.problemas.length);
    }

    public void setProblema(int index, double valor){
        this.problemas[index] = valor;
    }

    public String getProblemaNome(int index){
        return this.problemasNomes[index];
    }

    public void setProblemaNome(int index, String prob){
        this.problemasNomes[index] = prob;
    }

    public double DistanciaEuclidiana(double[] v1, double[] v2){
        double soma = 0.0;
        for (int i = 0; i < v1.length; i++) {
            soma += Math.pow(v1[i] - v2[i], 2);
        }
        return Math.sqrt(soma);
    }

    public int gerarNume(){
        Random random = new Random();
        return random.nextInt(2);
    }
}
