public class Perfil {
    private Intervalo preferencia_preco;
    private Intervalo preferencia_area;
    private int preferencia_n_quartos;
    private String preferencia_ldk;

    public Perfil() {
    }

    public Perfil(Intervalo preco, Intervalo area, int quartos, String ldk) {
        this.preferencia_preco = preco;
        this.preferencia_area = area;
        this.preferencia_n_quartos = quartos;
        this.preferencia_ldk = ldk;
    }

    public Intervalo get_preco() {
        return this.preferencia_preco;
    }
    
    public Intervalo get_area() {
        return this.preferencia_area;
    }
    
    public int get_n_quartos() {
        return this.preferencia_n_quartos; 
    }
    
    public String get_ldk() {
        return this.preferencia_ldk;
    }

    public void set_preco(Intervalo preco) {
        this.preferencia_preco = preco; 
    }
    
    public void set_area(Intervalo area) {
        this.preferencia_area = area; 
    }
    
    public void set_n_quartos(int quartos) {
        this.preferencia_n_quartos = quartos;
    }
    
    public void set_ldk(String ldk) {
        this.preferencia_ldk = ldk;
    }

    private int converterLdkParaValor(String ldk) {
        switch (ldk.toUpperCase()) {
            case "R": return 1;
            case "K": return 2;
            case "DK": return 3;
            case "LDK": return 4;
            default: return 1;
        }
    }

    private double calcularDistanciaIntervalo(double v, Intervalo intervalo) {
        double min = intervalo.get_min();
        double max = intervalo.get_max();
        
        if (v < min) {
            return (min - v) / (max - min);
        } else if (v > max) {
            return (v - max) / (max - min);
        } else {
            return 0.0;
        }
    }

    public double calc_distancia_euclidiana(Imovel imovel) {
        double d_preco = calcularDistanciaIntervalo(imovel.get_preco(), this.preferencia_preco);
        double d_area = calcularDistanciaIntervalo(imovel.get_area(), this.preferencia_area);
        
        double d_quartos = imovel.get_n_quartos() - this.preferencia_n_quartos;
        
        double d_ldk = converterLdkParaValor(imovel.get_ldk()) - converterLdkParaValor(this.preferencia_ldk);

        double somaQuadrados = Math.pow(d_preco, 2) + Math.pow(d_area, 2) + Math.pow(d_quartos, 2) + Math.pow(d_ldk, 2);
        return Math.sqrt(somaQuadrados);
    }
}