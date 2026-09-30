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
            ItemPedido item = pedidos.get(i).getItem().get(i);
            if(item.getNome().equals(descricao)){
                item.resumoItem();
            }
        }
    }

    public void mostrarPedidos(){
        for(int i=0;i<pedidos.size();i++){
            System.out.println("Itens: ");
            mostrarItem(pedidos.get(i));
        }
    }

    private void mostrarItem(Pedido pedido){
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
