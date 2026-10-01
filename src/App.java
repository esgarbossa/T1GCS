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
