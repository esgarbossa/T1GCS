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
            for (int j =0;j < pedidos.get(i).getItem().size();j++){
                ItemPedido item = pedidos.get(i).getItem().get(j);
                if(item.getNome().equalsIgnoreCase(descricao)){
                    item.resumoItem();
            }
            }
        }
    }

    public void mostrarPedidos(){
        for(int i=0;i<pedidos.size();i++){
            System.out.println("Itens: ");
            mostrarItemAux(pedidos.get(i));
        }
    }

    public void mostrarPedidosPorItem(String descricao){
        for(int i=0;i<pedidos.size();i++){
            ArrayList item = pedidos.get(i).getItem();
            for(int j=0;j<item.size()-1;j++){
                ItemPedido item1 = pedidos.get(i).getItem().get(j);
                if (item1.getNome().equalsIgnoreCase(descricao)){
                    mostrarItemSingle(item1);
                }
            }

        }
    }

    private void mostrarItemSingle(ItemPedido item){
        System.out.println("Nome: "+item.getNome());
        System.out.println("Valor: "+item.getValor());
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
