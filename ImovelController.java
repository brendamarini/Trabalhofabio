

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImovelController {
    private List<Imovel> imoveis;

    public ImovelController() {
        this.imoveis = new ArrayList<>();
    }
    public void cadastro(Imovel imovel) {
        imoveis.add(imovel);
    }
    public List<Imovel> listar() {
        return imoveis;
    }
    public Optional<Imovel> consultaa(String matricula) {
        return imoveis.stream().filter(imovel -> imovel.getMatricula().equals(matricula)).findFirst();
    }
    public void remover(String matricula) {
        imoveis.removeIf(imovel -> imovel.getMatricula().equals(matricula));
    }
    public double calcularTudo(String categoiriaDoImovelImovel) {
        return imoveis.stream()
                .filter(imovel -> imovel.getcategoriaDoImovel().equals(categoiriaDoImovel))
                .mapToDouble(Imovel::getValorVenal)
                .sum();
    }
}
