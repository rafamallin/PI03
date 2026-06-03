package src;
public class Intervalo {
    private double minimo;
    private double maximo;

    //Construtor  
    public Intervalo(double min, double max){
        this.minimo = min;
        this.maximo = max;
    }

    /*=========
      GETTERS
    =========*/
    public double getMaximo() {
        return maximo;
    }

    public double getMinimo() {
        return minimo;
    }

    //Metodos
    public Boolean check_in_interval(double valor){
        if (valor < this.maximo && valor > this.minimo){
            return true;
        } else {
            return false;
        }
    }
}