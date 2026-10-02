import java.util.Scanner;
import java.time.LocalDate;
public class Menu {
    private App app;
    public Menu() {
        this.app = new App();
    }
    public boolean OpcaoAdministradorDisponivel(int opcao){
        switch (opcao){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }
    public String StatusOpcaoAdministrador(int opcao){
        if (OpcaoAdministradorDisponivel(opcao)){
            return "";
        }
        return " [INDISPONÍVEL]";
    }
    public void MenuPrincipal(Scanner in) {
        if (app.getUsuarios().isEmpty()) {
            app.adicionarFuncionarios();
            app.instanciarPedidos();
        }
        while (true) {
            System.out.println("== Tela inicial ==");
            System.out.println("[1] - Entrar como administrador");
            System.out.println("[2] - Entrar como funcionario");
            int opcao = in.nextInt();
            in.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite sua matricula:");
                    int matriculaAdm = in.nextInt();
                    in.nextLine();
                    Administrador adm = app.administradorAtual(matriculaAdm);
                    if (adm == null) {
                        System.out.println("Administrador não encontrado!");
                    } else {
                        System.out.println("Digite sua senha:");
                        String senha = in.nextLine();
                        if (adm.validarSenha(senha)) {
                            System.out.println("Acesso autorizado!");
                            MenuAdministrador(in, adm);
                        } else {
                            System.out.println("Senha incorreta!");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Digite sua matricula:");
                    int matriculaFuncionario = in.nextInt();
                    in.nextLine();
                    Usuario funcionario = app.usuarioAtual(matriculaFuncionario);
                    if (funcionario == null){
                        System.out.println("Funcionario não encontrado!");
                    } else if (funcionario instanceof Administrador){
                        System.out.println(
                                "Essa matricula pertence a um administrador."
                        );
                    } else {
                        MenuFuncionario(in, funcionario);
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
    public void MenuAdministrador(Scanner in, Administrador adm){
        boolean menuAberto = true;

        while (menuAberto){
            System.out.println();
            System.out.println("== Menu administrador ==");
            System.out.println("Nome: " + adm.getNome());
            System.out.println();
            System.out.println("[1] - Visualizar pedidos" + StatusOpcaoAdministrador(1));
            System.out.println("[2] - Buscar pedido por funcionario" + StatusOpcaoAdministrador(2));
            System.out.println("[3] - Buscar pedido por item" + StatusOpcaoAdministrador(3));
            System.out.println("[4] - Buscar pedido por data" + StatusOpcaoAdministrador(4));
            System.out.println("[5] - Avaliar pedido" + StatusOpcaoAdministrador(5));
            System.out.println("[0] - Voltar");
            int opcao = in.nextInt();
            in.nextLine();
            if (opcao >= 1 && opcao <= 5 && !OpcaoAdministradorDisponivel(opcao)){
                System.out.println("Essa opção ainda está indisponível.");
                continue;
            }
            switch (opcao){
                case 1:
                    if (app.getPedidos().isEmpty()){
                        System.out.println("Nenhum pedido cadastrado.");
                    } else {
                        app.mostrarPedidos();
                    }
                    break;
                case 2:
                    System.out.println("Digite a matricula do funcionario:");
                    int matricula = in.nextInt();
                    in.nextLine();
                    app.buscaPorFuncionario(matricula);
                    break;
                case 3:
                    System.out.println("Digite a descrição do item:");
                    String descricao = in.nextLine();
                    app.buscarPorItem(descricao);
                    break;
                case 4:
                    System.out.println("Digite a data no formato AAAA-MM-DD:");
                    String dataInformada = in.nextLine();
                    try {
                        LocalDate data = LocalDate.parse(dataInformada);
                        app.buscarPorData(data);
                    } catch (Exception erro) {
                        System.out.println("Data inválida!");
                    }
                    break;
                case 5:
                    if (app.getPedidos().isEmpty()){
                        System.out.println("Nenhum pedido disponível para avaliação.");
                        break;
                    }
                    for (int i = 0; i < app.getPedidos().size(); i++){
                        System.out.println();
                        System.out.println("[" + (i + 1) + "] - Pedido");
                        app.resumoPedido(app.getPedidos().get(i));
                    }
                    System.out.println("Escolha o número do pedido:");
                    int numeroPedido = in.nextInt();
                    in.nextLine();
                    if (numeroPedido < 1 || numeroPedido > app.getPedidos().size()){
                        System.out.println("Pedido inválido!");
                    } else {
                        Pedido pedido = app.getPedidos().get(numeroPedido - 1);
                        app.avaliarPedidos(adm, pedido, in);
                    }
                    break;
                case 0:
                    System.out.println(
                            "Voltando para a tela inicial..."
                    );
                    menuAberto = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
    public void MenuFuncionario(Scanner in, Usuario funcionario){
        System.out.println("== Menu funcionario ==");
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Departamento: " + funcionario.getTipo());
        System.out.println("Opções:");
    }
}