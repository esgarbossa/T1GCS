import java.util.Scanner;

public class Limpeza extends Usuario{
    public Limpeza (int matricula,String nome){
        super(matricula, nome);
    }

    public Limpeza(){
        super();
    }

    @Override
    public String getTipo(){
        return "Limpeza";
    }

    @Override
    public Usuario cadastro(Scanner in){
        Usuario cont = new Limpeza();

        System.out.println("Qual o nome do funcionario de limpeza?: ");
        String nome = in.nextLine();
        super.setNome(nome);

        System.out.println("Qual a matricula do funcionario de limpezar?: ");
        int matricula = in.nextInt();
        super.setMatricula(matricula);
        return cont;
    }

    public double getLimite(){
        return 300000.00;
    }
}
