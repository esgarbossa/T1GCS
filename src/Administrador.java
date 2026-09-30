import java.util.Scanner;

public class Administrador extends Usuario {

    public Administrador (int matricula,String nome){
        super(matricula, nome);
    }

    public Administrador(){
        super();
    }

    public Usuario cadastro(Scanner in){
        Usuario adm = new Administrador();
        //TO DO (Retornar um novo adm cadastrado)
        return adm;
    }

    @Override
    public String getTipo() {
        return "Administrador";
    }
}
