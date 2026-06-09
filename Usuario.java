import java.util.Arrays;
import java.lang.Math;
 
public class Usuario {
    private String nome;
    private double preco;
    private double area;
    private double numQuartos;
 
    public String getNome(){
        return this.nome;
    }
 
    public void setNome(String no){
        this.nome = no;
    }
 
    public double getPreco(){
        return this.preco;
    }
    public void setPreco(double pr){
        this.preco = pr;
    }
    public double getArea(){
        return this.area;
    }
    public void setArea(double ar){
        this.area = ar;
    }
    public double getNumQuartos(){
        return this.numQuartos;
    }
    
    public void setNumQuartos(double nq){
        this.numQuartos = nq;
    }
    
    public double[] getArray() {
        return new double[]{this.preco, this.area, this.numQuartos};
    }
 
    public double DistanciaEuclidiana(double[] v1, double[] v2){
        double soma = 0.0;
        for (int i = 0; i < v1.length; i++) {
            soma += Math.pow(v1[i] - v2[i], 2);
        }
        return Math.sqrt(soma);
    }
}