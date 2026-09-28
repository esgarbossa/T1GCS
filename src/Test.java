import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        App app = new App();

        Scanner in = new Scanner(System.in);

        Pedido pedido = new Pedido();

        ArrayList<ItemPedido> itemPedido = new ArrayList();

        ItemPedido item = new ItemPedido();
        item.cadastroItem(in);

        itemPedido.add(item);

        pedido.setItem(itemPedido);

        ArrayList<Pedido> pedidos = new ArrayList();

        pedidos.add(pedido);

        app.setPedidos(pedidos);

        app.mostrarPedidos();




    }
}
