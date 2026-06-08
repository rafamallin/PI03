package src;

public class Imovel {
    private double preco;
    private double area;
    private double num_quartos;

    //Construtor
    public Imovel(double preco, double area, double num_quartos){
        this.preco = preco;
        this.area = area;
        this.num_quartos = num_quartos;
    }

    /*===========
        GETTERS
    ============*/
    public double getPreco() {
        return preco;
    }

    public double getArea() {
        return area;
    }

    public double getNum_quartos() {
        return num_quartos;
    }
}
