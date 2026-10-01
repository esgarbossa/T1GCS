import java.time.LocalDate;
import java.util.ArrayList;

public class App {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public App() {
        this.pedidos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void buscarPorItem(String descricao) {
        for(int i =0;i < pedidos.size();i++){
            boolean encontrou = false;
            for (int j =0;j < pedidos.get(i).getItem().size();j++) {
                ItemPedido item = pedidos.get(i).getItem().get(j);
                if (item.getNome().equalsIgnoreCase(descricao)) {
                    resumoPedido(pedidos.get(i));
                    break;
                }
            }

        }
    }

    public void buscarPorData(LocalDate data){
        boolean encontrou = false;
        for (int i = 0; i < pedidos.size();i++){
            LocalDate dataPedido = pedidos.get(i).getDataPedido();
            if (dataPedido != null && dataPedido.isEqual(data)){
                resumoPedido(pedidos.get(i));
                encontrou = true;
            }
        }
        if (!encontrou){
            System.out.println("Nenhum pedido na data selecionada!");
        }
    }

    public void resumoPedido(Pedido pedido) {
        System.out.println("ID: " + pedido.getId());
        System.out.println(pedido.getDescricao());
        mostrarItemAux(pedido);
        System.out.println(pedido.getDataPedido());
        System.out.println("Status: " + pedido.getStatus());
    }

    public void adicionarFuncionarios(){
        Usuario adm1 = new Administrador(2712, "Pedro Cristal", "asd123" );
        Usuario adm2 = new Administrador(9374, "Lucas Gargioni", "aka98" );
        Usuario adm3 = new Administrador(7273, "Lucas Neves", "kaka87" );
        Usuario adm4 = new Administrador(4162, "Tiago Audino", "snsba67" );
        Usuario adm5 = new Administrador(2162, "Enzo Sgarbossa", "mamamma90" );

        Usuario rh1 = new RH(3101, "Ana Souza");
        Usuario rh2 = new RH(3102, "Bruno Lima");
        Usuario rh3 = new RH(3103, "Carolina Martins");
        Usuario rh4 = new RH(3104, "Diego Alves");
        Usuario rh5 = new RH(3105, "Eduarda Freitas");

        Usuario limpeza1 = new Limpeza(4201, "Marcos Silva");
        Usuario limpeza2 = new Limpeza(4202, "Juliana Santos");
        Usuario limpeza3 = new Limpeza(4203, "Rafael Oliveira");
        Usuario limpeza4 = new Limpeza(4204, "Camila Rodrigues");
        Usuario limpeza5 = new Limpeza(4205, "Felipe Martins");

        Usuario financeiro1 = new Financeiro(5301, "Fernanda Costa");
        Usuario financeiro2 = new Financeiro(5302, "Gabriel Rocha");
        Usuario financeiro3 = new Financeiro(5303, "Isabela Almeida");
        Usuario financeiro4 = new Financeiro(5304, "Leonardo Mendes");
        Usuario financeiro5 = new Financeiro(5305, "Mariana Nunes");

        Usuario engenheiro1 = new Engenheiro(6401, "João Pereira");
        Usuario engenheiro2 = new Engenheiro(6402, "Matheus Ribeiro");
        Usuario engenheiro3 = new Engenheiro(6403, "Beatriz Ferreira");
        Usuario engenheiro4 = new Engenheiro(6404, "Gustavo Carvalho");
        Usuario engenheiro5 = new Engenheiro(6405, "Laura Moreira");

        Usuario manutencao1 = new Manutencao(7501, "Carlos Mendes");
        Usuario manutencao2 = new Manutencao(7502, "Eduardo Nunes");
        Usuario manutencao3 = new Manutencao(7503, "Larissa Gomes");
        Usuario manutencao4 = new Manutencao(7504, "Henrique Lopes");
        Usuario manutencao5 = new Manutencao(7505, "Patricia Almeida");

    }




    public void mostrarPedidos(){
        for(int i=0;i<pedidos.size();i++){
            System.out.println("Itens: ");
            mostrarItemAux(pedidos.get(i));
        }
    }

    private void mostrarItemAux(Pedido pedido){
        ArrayList<ItemPedido> items = pedido.getItem();
        for(int i=0;i < items.size();i++){
            System.out.println("Descrição: " +  items.get(i).getNome());
            System.out.println("Valor: " +  items.get(i).getValor());
            System.out.println("=========================================");
        }
    }


    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
