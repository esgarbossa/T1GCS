import java.util.Scanner;
import java.util.ArrayList;

public class Pedido implements IntPedidos {
    private ArrayList<ItemPedido> item;
    private Usuario funcionario;
    private String descricao;
    private String dataConclusao;
    private String status;



    public Pedido(ArrayList<ItemPedido> item,Usuario funcionario,String descricao,String dataConclusao,String status){
        this.item=item;
        this.funcionario=funcionario;
        this.descricao=dataConclusao;
        this.dataConclusao=dataConclusao;
        this.status=status;
    }
    public Pedido(){
        this.item= new ArrayList<ItemPedido>();
        this.funcionario=null;//TO DO
        this.descricao=null;
        this.dataConclusao="";
        this.status="";
    }
    public void changeStatus(){

    }

    public void cadastroItem(Scanner in){
        System.out.println("Digite a descricao do item: ");
        String nome = in.nextLine();

        System.out.println("Digite o valor do item: ");
        double valor = in.nextDouble();

        ItemPedido item = new ItemPedido(nome,valor);
        this.item.add(item);

        System.out.println("1 - Cadastrar novo item");
        System.out.println("2 - Sair");
        int opcao = in.nextInt();

        switch(opcao){
            case 1:
                cadastroItem(in);
                break;
            case 2:
                break;
        }

    }

    public void cadastroPedido(Scanner in){
        this.cadastroItem(in);
        //TO DO cadastro funcionario

        System.out.println("Digite a data de conclusao: ");
        String dataConclusao=in.nextLine();
        this.setDataConclusao(dataConclusao);

        System.out.println("Escreva uma breve descrição do pedido");
        String descricao=in.nextLine();
        this.setDescricao(descricao);

        this.setStatus("Aberto");

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<ItemPedido> getItem() {
        return item;
    }

    public void setItem(ArrayList<ItemPedido> item) {
        this.item = item;
    }

    public Usuario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Usuario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
