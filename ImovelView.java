

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ImovelView {
    private ImovelController controller;
    private Scanner scanner;

    public ImovelView(ImovelController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarmenu() {
        while (true) {
            System.out.println("\n1. Cadatrar Imovel");
            System.out.println("2. Mostrar Imovel");
            System.out.println("3. Consulta por matricula");
            System.out.println("4. Remover por Matrícula");
            System.out.println("5. Calcular IPTU");
            System.out.println("6. Calcular IPTU prox 5 anos");
            System.out.println("7. Mostrar valor total dos imóveis por tipo");
            System.out.println("8. Sair");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastro();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    consultaa();
                    break;
                case 4:
                    remover();
                case 5:
                    calcularIPTU();
                    break;
                case 6:
                    calcularIPTUProximosAnos();
                    break;
                case 7:
                    ValorTotalTipo();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.\n____________________________");
            }
        }
    }

    private void cadastro() {
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.println("Proprietários: ");
        List<String> proprietarios = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
        System.out.println("Tipo de Imóvel (casa, apartamento, terreno): ");
        String tipoImovel = scanner.nextLine();
        System.out.println("Valor Venal: ");
        double valorVenal = Double.parseDouble(scanner.nextLine());
        System.out.println("Área em m²: ");
        double area = Double.parseDouble(scanner.nextLine());

        Imovel imovel = new Imovel(matricula, proprietarios, tipoImovel, valorVenal, area);
        controller.cadastro(imovel);
        System.out.println("Imóvel cadastrado com sucesso!\n____________________________");
    }

    private void listar() {
        List<Imovel> imoveis = controller.listar();
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.\n____________________________");
        } else {
            imoveis.forEach(imovel -> {
                System.out.println("Matrícula: " + imovel.getMatricula() + 
                                   ", Tipo: " + imovel.getTipoImovel() + 
                                   ", Valor Venal: " + imovel.getValorVenal() + 
                                   ", Área: " + imovel.getArea());
            });
        }
    }

    private void consultaa() {
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        Optional<Imovel> imovelOpt = controller.consultaa(matricula);
        if (imovelOpt.isPresent()) {
            Imovel imovel = imovelOpt.get();
            System.out.println("Matrícula: " + imovel.getMatricula() + 
                               ", Tipo: " + imovel.getTipoImovel() + 
                               ", Valor Venal: " + imovel.getValorVenal() + 
                               ", Área: " + imovel.getArea());
        } else {
            System.out.println("Imóvel não encontrado.\n____________________________");
        }
    }

    private void remover() {
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        controller.remover(matricula);
        System.out.println("Imóvel removido com sucesso.\n____________________________");
    }

    private void calcularIPTU() {
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        Optional<Imovel> imovelOpt = controller.consultaa(matricula);
        if (imovelOpt.isPresent()) {
            Imovel imovel = imovelOpt.get();
            System.out.println("IPTU: " + imovel.calcularIPTU());
        } else {
            System.out.println("Imóvel não encontrado.\n____________________________");
        }
    }

    private void calcularIPTUProximosAnos() {
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        Optional<Imovel> imovelOpt = controller.consultaa(matricula);
        if (imovelOpt.isPresent()) {
            Imovel imovel = imovelOpt.get();
            for (int i = 1; i <= 5; i++) {
                System.out.println("IPTU ano " + i + ": " + imovel.calcularIPTUAnual(i));
            }
        } else {
            System.out.println("Imóvel não encontrado.\n____________________________");
        }
    }

    private void ValorTotalTipo() {
        System.out.println("Tipo de Imóvel (casa, apartamento, terreno): ");
        String tipoImovel = scanner.nextLine();
        double total = controller.calcularTudo(tipoImovel);
        System.out.println("Valor total dos imóveis do tipo " + tipoImovel + ": " + total);
    }
}
