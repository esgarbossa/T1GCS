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
        for (int i = 0; i < pedidos.size() -1;i++){
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
        mostrarItemAux(pedido);
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
