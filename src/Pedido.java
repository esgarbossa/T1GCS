import java.util.Scanner;
public class Pedido implements IntPedidos {
    private ItemPedido item;
    private Usuario funcionario;
    private String descricao;
    private String dataConclusao;
    private String status;



    public Pedido(ItemPedido item,Usuario funcionario,String descricao,String dataConclusao,String status){
        this.item=item;
        this.funcionario=funcionario;
        this.descricao=dataConclusao;
        this.dataConclusao=dataConclusao;
        this.status=status;
    }
    public Pedido(){
        this.item= new ItemPedido();
        this.funcionario=null;//TO DO
        this.descricao=null;
        this.dataConclusao="";
        this.status="";
    }
    public void changeStatus(){

    }
    public void cadastroPedido(Scanner in){
        this.item.cadastrtoItem(in);
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

    public ItemPedido getItem() {
        return item;
    }

    public void setItem(ItemPedido item) {
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
