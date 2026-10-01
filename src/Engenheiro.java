import java.util.Scanner;

import java.util.Scanner;

public class Engenheiro extends Usuario{

    public Engenheiro (int matricula,String nome){
        super(matricula, nome);
    }

    public Engenheiro(){
        super();
    }

    @Override
    public String getTipo(){
        return "Engenheiro";
    }

    @Override
    public Usuario cadastro(Scanner in){
        Usuario eng = new Engenheiro();

        System.out.println("Qual o nome do engenheiro?: ");
        String nome = in.nextLine();
        eng.setNome(nome);

        System.out.println("Qual a matricula do engenheiro?: ");
        int matricula = in.nextInt();
        eng.setMatricula(matricula);
        return eng;
    }

    public double getLimite(){
        return 300000.00;
    }

}

