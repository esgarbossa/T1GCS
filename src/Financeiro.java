import java.util.Scanner;

public class Financeiro extends Usuario{
    public Financeiro (int matricula,String nome){
        super(matricula, nome);
    }

    public Financeiro(){
        super();
    }

    @Override
    public String getTipo(){
        return "Financeiro";
    }

    @Override
    public Usuario cadastro(Scanner in){
        Usuario cont = new Financeiro();

        System.out.println("Qual o nome do contador?: ");
        String nome = in.nextLine();
        cont.setNome(nome);

        System.out.println("Qual a matricula do contador?: ");
        int matricula = in.nextInt();
        cont.setMatricula(matricula);
        return cont;
    }

    public double getLimite(){
        return 300000.00;
    }

}
}
