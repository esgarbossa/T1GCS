import java.util.Scanner;

public class Manutencao extends Usuario {
    public Manutencao (int matricula,String nome){
        super(matricula, nome);
    }

    public Manutencao(){
        super();
    }

    @Override
    public String getTipo(){
        return "Manutenção";
    }

    @Override
    public Usuario cadastro(Scanner in){
        Usuario adm = new Administrador();
        //TO DO (Retornar um novo adm cadastrado)
        return adm;
    }

}
