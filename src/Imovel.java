package src;

public class Imovel {
    private double preco;
    private double area;
    private int num_quartos;
    private String ldk;

    //Construtor
    public Imovel(double preco, double area, int num_quartos, String ldk){
        this.preco = preco;
        this.area = area;
        this.num_quartos = num_quartos;
        this.ldk = ldk;
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

    public int getNum_quartos() {
        return num_quartos;
    }

    public String getLdk() {
        return ldk;
    }
}
