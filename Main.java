public class Main {
    public static void main(String[] args) {
        ImovelController controller = new ImovelController();
        ImovelView view = new ImovelView(controller);
        view.mostrarmenu();
    }
}
