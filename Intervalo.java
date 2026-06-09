public class Intervalo {
    private double min;
    private double max;

    public Intervalo(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double get_max() {
        return this.max;
    }

    public double get_min() {
        return this.min;
    }

    public boolean check_limites(double valor) {
        return valor >= this.min && valor <= this.max;
    }
}