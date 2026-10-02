import java.util.Scanner;

public abstract class Usuario {
    public int matricula;
    public String nome;

    public Usuario(){
        this.matricula = 0;
        this.nome = "";
    }

    public Usuario(int matricula,String nome){
        this.nome = nome;
        this.matricula = matricula;
    }


    public String toString(){
        return "Nome: " + this.nome + "\nMatricula: " + this.matricula + "\nDepartamento: " + this.getTipo();
    }

    public abstract Usuario cadastro(Scanner in);

    public abstract String getTipo();

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract double getLimite();
}
