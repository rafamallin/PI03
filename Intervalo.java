public class Intervalo {
    private double minimo;
    private double maximo;

    public Intervalo(double min, double max){
        this.minimo = min;
        this.maximo = max;
    }

    public Boolean check_in_interval(double valor){
        if (valor < this.maximo && valor > this.minimo){
            return true;
        } else {
            return false;
        }
    }
}