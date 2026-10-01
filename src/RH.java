import java.util.Scanner;

public class RH extends Usuario{
    public RH (int matricula,String nome){
        super(matricula, nome);
    }

    public RH(){
        super();
    }

    @Override
    public String getTipo() {
        return "RH";
    }
    @Override
    public Usuario cadastro(Scanner in){
        Usuario cont = new RH();

        System.out.println("Qual o nome do funcionario de RH?: ");
        String nome = in.nextLine();
        super.setNome(nome);

        System.out.println("Qual a matricula do funcionario de RH?: ");
        int matricula = in.nextInt();
        super.setMatricula(matricula);
        return cont;
    }

    public double getLimite(){
        return 300000.00;
    }

}

