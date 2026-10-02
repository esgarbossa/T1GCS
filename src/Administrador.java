import java.util.Scanner;

public class Administrador extends Usuario {
    private String senha;

    public Administrador (int matricula,String nome, String senha){
        super(matricula, nome);
        this.senha = senha;
    }

    public Administrador(){
        super();
        this.senha = null;
    }

    public Usuario cadastro(Scanner in){
        Usuario adm = new Administrador();
        System.out.println("Qual o nome do administrador?: ");
        String nome = in.nextLine();
        super.setNome(nome);

        System.out.println("Qual a matricula do administrador?: ");
        int matricula = in.nextInt();
        super.setMatricula(matricula);

        System.out.println("Qual a senha do administrador?: ");
        String senha = in.nextLine();
        this.senha = senha;
        return adm;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String getTipo() {
        return "Administrador";
    }
}
