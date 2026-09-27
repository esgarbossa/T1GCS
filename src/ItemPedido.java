import java.util.Scanner;
public class ItemPedido{

private String descricao;
private double valor;

public ItemPedido(String nome, double valor){
    this.descricao=nome;
    this.valor=valor;
}
    public ItemPedido(){
        this.descricao="";
        this.valor=0;
    }
    public void cadastrtoItem(Scanner in){
        System.out.println("Digite a descricao do item: ");
        String nome = in.nextLine();
        this.setNome(nome);

        System.out.println("Digite o valor do item: ");
        double valor=in.nextDouble();
        this.setValor(valor);
    }

    public void resumoItem(){
        System.out.println("Descrição do Item: " + this.getNome());
        System.out.println("Valor do Item: " + this.getValor());
    }

    public String getNome() {
        return descricao;
    }

    public void setNome(String nome) {
        this.descricao = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
