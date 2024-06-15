import java.util.List;

public class Imovel {

    private String matricula;
    private double valorVenal;
    private String categoriaDoImovel;
    private double area;
    private List<String> proprietarios;

    public Imovel(String matricula, double valorVenal, String categoriaDoImovel, double areaList<String> proprietarios) {
        this.matricula = matricula;
        this.tipoImovel = categoriaDoImovelImovel;
        this.valorVenal = valorVenal;
        this.area = area;
        this.proprietarios = proprietarios;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<String> getProprietarios() {
        return proprietarios;
    }

    public void setProprietarios(List<String> proprietarios) {
        this.proprietarios = proprietarios;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setcategoriaDoImovel(String tipoImovel) {
        this.categoriaDoImovel = categoriaDoImovel;
    }

    public double getValorVenal() {
        return valorVenal;
    }

    public void setValorVenal(double valorVenal) {
        this.valorVenal = valorVenal;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double calcularIPTU() {
        switch (tipoImovel) {
            case "casa":
                if (area <= 200) {
                    return area * 5 + 200 + 0.05 * valorVenal;
                } else {
                    return area * 6 + 350 + 0.08 * valorVenal;
                }
            case "terreno":
                if (area <= 400) {
                    return area * 3 + 500;
                } else {
                    return area * 10 + 500;
                }
            case "apartamento":
                if (area <= 150) {
                    return area * 2 + 200 + 0.03 * valorVenal;
                } else {
                    return area * 4 + 350 + 0.10 * valorVenal;
                }
            default:
                throw new IllegalArgumentException("Tipo de imóvel desconhecido: " + tipoImovel);
        }
    }

    public double calcularIPTUAnual(int anos) {
        double iptu = calcularIPTU();
        for (int i = 0; i < anos; i++) {
            iptu *= 1.07;
        }
        return iptu;
    }
}
