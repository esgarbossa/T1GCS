import java.util.Scanner;
import java.time.LocalDate;
public class Menu {
    private App app;
    public Menu() {
        this.app = new App();
    }
    public int LerInteiro(Scanner in){
        while (true){
            String entrada = in.nextLine();
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException erro) {
                System.out.println("Entrada inválida. Digite apenas números:");
            }
        }
    }
    public boolean OpcaoAdministradorDisponivel(int opcao){
        switch (opcao){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
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
            int opcao = LerInteiro(in);
            switch (opcao) {
                case 1:
                    System.out.println("Digite sua matricula:");
                    int matriculaAdm = LerInteiro(in);
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
                    int matriculaFuncionario = LerInteiro(in);
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
            System.out.println("[6] - Cadastrar funcionario" + StatusOpcaoAdministrador(6));
            System.out.println("[7] - Estatísticas totais" + StatusOpcaoAdministrador(7));
            System.out.println("[8] - Estatísticas dos últimos 30 dias" + StatusOpcaoAdministrador(8));
            System.out.println("[9] - Maior pedido aberto" + StatusOpcaoAdministrador(9));
            System.out.println("[0] - Voltar");
            int opcao = LerInteiro(in);
            if (opcao >= 1 && opcao <= 9 && !OpcaoAdministradorDisponivel(opcao)){
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
                    int matricula = LerInteiro(in);
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
                    int numeroPedido = LerInteiro(in);
                    if (numeroPedido < 1 || numeroPedido > app.getPedidos().size()){
                        System.out.println("Pedido inválido!");
                    } else {
                        Pedido pedido = app.getPedidos().get(numeroPedido - 1);
                        app.avaliarPedidos(adm, pedido, in);
                    }
                    break;
                case 6:
                    System.out.println("Selecione o departamento do funcionario:");
                    System.out.println("[1] - RH");
                    System.out.println("[2] - Limpeza");
                    System.out.println("[3] - Financeiro");
                    System.out.println("[4] - Engenharia");
                    System.out.println("[5] - Manutenção");
                    int tipoFuncionario = LerInteiro(in);
                    Usuario novoFuncionario = null;
                    switch (tipoFuncionario){
                        case 1:
                            novoFuncionario = new RH();
                            break;
                        case 2:
                            novoFuncionario = new Limpeza();
                            break;
                        case 3:
                            novoFuncionario = new Financeiro();
                            break;
                        case 4:
                            novoFuncionario = new Engenheiro();
                            break;
                        case 5:
                            novoFuncionario = new Manutencao();
                            break;
                        default:
                            System.out.println("Departamento inválido!");
                            break;
                    }
                    if (novoFuncionario != null){
                        try {
                            novoFuncionario.cadastro(in);
                            in.nextLine();
                        } catch (Exception erro) {
                            System.out.println("Matrícula inválida. O funcionário não foi cadastrado.");
                            in.nextLine();
                            break;
                        }
                        if (app.usuarioAtual(novoFuncionario.getMatricula()) != null){
                            System.out.println("Já existe um funcionário com essa matrícula!");
                        } else {
                            app.getUsuarios().add(novoFuncionario);
                            System.out.println("Funcionário cadastrado com sucesso!");
                        }
                    }
                    break;
                case 7:
                    EstatisticasTotais totais = new EstatisticasTotais();
                    totais.mostrar(adm, app.getPedidos());
                    break;
                case 8:
                    EstatisticasUltimos30Dias ultimos30Dias = new EstatisticasUltimos30Dias();
                    ultimos30Dias.mostrar(adm, app.getPedidos());
                    break;
                case 9:
                    EstatisticasMaiorPedidoAberto maiorPedidoAberto = new EstatisticasMaiorPedidoAberto();maiorPedidoAberto.mostrar(adm, app.getPedidos());
                    break;
                case 0:
                    System.out.println("Voltando para a tela inicial...");
                    menuAberto = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
    public void MenuFuncionario(Scanner in, Usuario funcionario){
        boolean menuAberto = true;
        while (menuAberto){
            System.out.println();
            System.out.println("== Menu funcionario ==");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Departamento: " + funcionario.getTipo());
            System.out.println();
            System.out.println("[1] - Cadastrar pedido");
            System.out.println("[2] - Remover pedido");
            System.out.println("[0] - Voltar");
            int opcao = LerInteiro(in);
            switch (opcao){
                case 1:
                    Pedido novoPedido = new Pedido();
                    novoPedido.cadastroPedido(in, funcionario);
                    if (novoPedido.getItem() == null){
                        System.out.println("O pedido ultrapassou o limite permitido.");
                    } else {
                        app.getPedidos().add(novoPedido);
                        System.out.println("Pedido cadastrado com sucesso!");
                    }
                    break;
                case 2:
                    boolean encontrouPedido = false;
                    System.out.println("Seus pedidos:");
                    for (int i = 0; i < app.getPedidos().size(); i++){
                        Pedido pedidoAtual =
                                app.getPedidos().get(i);
                        if (pedidoAtual.getFuncionario().equals(funcionario)){
                            app.resumoPedido(pedidoAtual);
                            encontrouPedido = true;
                        }
                    }
                    if (!encontrouPedido){
                        System.out.println("Você não possui pedidos cadastrados.");
                        break;
                    }
                    System.out.println("Digite o ID do pedido que deseja remover:");
                    String idPedido = in.nextLine();
                    Pedido pedidoRemover = null;
                    for (int i = 0; i < app.getPedidos().size(); i++){
                        Pedido pedidoAtual =
                                app.getPedidos().get(i);
                        if (pedidoAtual.getId() != null && pedidoAtual.getId().equalsIgnoreCase(idPedido) && pedidoAtual.getFuncionario().equals(funcionario)){pedidoRemover = pedidoAtual;
                            break;
                        }
                    }
                    if (pedidoRemover == null){
                        System.out.println("Pedido não encontrado!");
                    } else {
                        app.excluirPedidos(pedidoRemover, funcionario);
                        System.out.println("Pedido removido com sucesso!");
                    }
                    break;
                case 0:
                    System.out.println("Voltando para a tela inicial...");
                    menuAberto = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}