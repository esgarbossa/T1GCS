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
        Usuario man = new Manutencao();
        System.out.println("Qual o nome do funcionario da manutenção?: ");
        String nome = in.nextLine();
        super.setNome(nome);

        System.out.println("Qual a matricula do funcionario da manutenção?: ");
        int matricula = in.nextInt();
        super.setMatricula(matricula);
        return man;
    }

    public double getLimite(){
        return 100000;
    }

}
