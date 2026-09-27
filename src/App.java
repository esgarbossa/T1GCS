import java.util.ArrayList;

public class App {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public App() {
        this.pedidos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void getPedidoDescricao(String descricao) {
        for(int i =0;i < pedidos.size();i++){
            if(pedidos.get(i).getDescricao().equals(descricao)){
                System.out.println(pedidos.get(i).getDescricao());
            }
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
