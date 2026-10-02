import java.util.Scanner;
public class Menu {
    private App app;
    public Menu() {
        this.app = new App();
    }

    public void MenuPrincipal(Scanner in) {
        if (app.getUsuarios().isEmpty()) {
            app.adicionarFuncionarios();
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
        System.out.println("== Menu administrador ==");
        System.out.println("Nome: " + adm.getNome());
        System.out.println("Opções:");
    }
    public void MenuFuncionario(Scanner in, Usuario funcionario){
        System.out.println("== Menu funcionario ==");
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Departamento: " + funcionario.getTipo());
        System.out.println("Opções:");
    }
}