import java.util.Scanner;
public class ItemPedido{

private String nome;
private double valor;

public ItemPedido(String nome, double valor){
    this.nome=nome;
    this.valor=valor;
}
    public ItemPedido(){
        this.nome="";
        this.valor=0;
    }
    public void cadastrtoItem(Scanner in){
        System.out.println("Digite o nome do item: ");
        String nome = in.nextLine();
        this.setNome(nome);

        System.out.println("Digite o valor do item: ");
        double valor=in.nextDouble();
        this.setValor(valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }
0
    public void setValor(double valor) {
        this.valor = valor;
    }
}
