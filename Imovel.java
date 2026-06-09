public class Imovel {
    private String nome;
    private double preco;
    private double area;
    private int n_quartos;
    private String ldk;

    public Imovel(String nome, double preco, double area, int n_quartos, String ldk) {
        this.nome = nome;
        this.preco = preco;
        this.area = area;
        this.n_quartos = n_quartos;
        this.ldk = ldk;
    }

    public String getNome() {
        return this.nome;
    }

    public double get_preco() {
        return this.preco;
    }

    public double get_area() {
        return this.area;
    }

    public int get_n_quartos() {
        return this.n_quartos;
    }

    public String get_ldk() {
        return this.ldk;
    }
}