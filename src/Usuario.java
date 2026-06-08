package src;
import java.lang.Math;

public class Usuario {
    private String nome;
    private double preferencia_preco;
    private double preferencia_area;
    private double preferencia_num_quartos;

    //Construtor
    public Usuario(String nome, double preco, double area, double quartos){
        this.nome = nome;
        this.preferencia_preco = preco;
        this.preferencia_area = area;
        this.preferencia_num_quartos = quartos;
    }

    /*=====================
        GETTERS E SETTERS
    =====================*/
    public double getPreferencia_preco() {
        return preferencia_preco;
    }

    public double getPreferencia_area() {
        return preferencia_area;
    }

    public double getPreferencia_num_quartos() {
        return preferencia_num_quartos;
    }

    public void setPreferencia_preco(double preferencia_preco) {
        this.preferencia_preco = preferencia_preco;
    }

    public void setPreferencia_area(double preferencia_area) {
        this.preferencia_area = preferencia_area;
    }

    public void setPreferencia_num_quartos(double preferencia_num_quartos) {
        this.preferencia_num_quartos = preferencia_num_quartos;
    }

    //Metodos
    public double DistanciaEuclidiana(double[] v1, double[] v2){
        double soma = 0.0;
        for (int i = 0; i < v1.length; i++) {
            soma += Math.pow(v1[i] - v2[i], 2);
        }
        return Math.sqrt(soma);
    }
}
