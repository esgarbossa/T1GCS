import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;


public class Pedido implements IntPedidos {
    private String  id;
    private ArrayList<ItemPedido> item;
    private double valorT;
    private Usuario funcionario;
    private String descricao;
    private LocalDate dataConclusao;
    private String status;
    private LocalDate dataPedido;
    private boolean avaliado;




    public Pedido(String id,ArrayList<ItemPedido> item, Usuario funcionario, String descricao) {
        this.id = id;
        this.item = item;
        this.valorT = 0;
        this.funcionario = funcionario;
        this.descricao = descricao;
        this.dataPedido = LocalDate.now();
        this.dataConclusao = null;
        this.status = "Aberto";
    }
    public Pedido() {
        this.id = null;
        this.item = new ArrayList<ItemPedido>();
        this.valorT =0;
        this.funcionario = null;
        this.descricao = null;
        this.dataPedido = null;
        this.dataConclusao = null;
        this.status = "";
    }
    public void changeStatus(){

    }

    public void cadastroItem(Scanner in){
        System.out.println("Digite a descricao do item: ");
        String nome = in.nextLine();

        System.out.println("Digite o valor do item: ");
        double valor = Double.parseDouble(in.nextLine());

        ItemPedido item = new ItemPedido(nome,valor);
        this.item.add(item);

        System.out.println("1 - Cadastrar novo item");
        System.out.println("2 - Sair");
        int opcao = Integer.parseInt(in.nextLine());

        switch(opcao) {
            case 1:
                cadastroItem(in);
                break;
            case 2:
                break;
        }
    }

    public double calculaValor(){
        double valor = 0;
        for (int i = 0; i < item.size();i++){
            valor += item.get(i).getValor();
        }
        return valor;
    }

    public void cadastroPedido(Scanner in, Usuario usuarioAtual) {
        System.out.println("Digite o id do pedido");
        String id = in.nextLine();
        this.id = id;

        this.cadastroItem(in);

        this.funcionario = usuarioAtual;

        valorT = calculaValor();

        if (valorT > funcionario.getLimite()){
            item = null;
            return;
        }

        this.dataPedido = LocalDate.now();

        System.out.println("Escreva uma breve descrição do pedido");
        String descricao = in.nextLine();
        this.setDescricao(descricao);

        this.setStatus("Aberto");
    }
    public void concluirPedido() {
        if(this.avaliado == false){
            System.out.println("Pedido nao pode ser executado pois foi reprovado.");
            return;
        }
        this.dataConclusao = LocalDate.now();
        this.status = "Concluido";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDate getDataPedido() {return dataPedido;}

    public void setDataPedido(LocalDate dataPedido) {this.dataPedido = dataPedido;}

    public boolean isAvaliado() {
        return avaliado;
    }

    public void setAvaliado(boolean avaliado) {
        this.avaliado = avaliado;
    }

    public double getValorT() {
        return valorT;
    }

    public void setValorT(double valorT) {
        this.valorT = valorT;
    }
}

