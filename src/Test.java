import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        App app = new App();

        Scanner in = new Scanner(System.in);


        ArrayList<ItemPedido> itemPedido = new ArrayList();

        ItemPedido item1= new ItemPedido("A", 100);
        ItemPedido item2= new ItemPedido("B", 100);
        ItemPedido item3= new ItemPedido("C", 100);

        ArrayList<ItemPedido> itens1 = new ArrayList<>();

        ArrayList<ItemPedido> itens2 = new ArrayList<>();

        itens2.add(item1);

        itens1.add(item3);

        itens2.add(item2);

        Pedido pedido1 = new Pedido();

        Pedido pedido2 = new Pedido();

        pedido1.setItem(itens1);

        pedido2.setItem(itens2);

        ArrayList<Pedido> pedidos = new ArrayList<>();

        pedidos.add(pedido1);
        pedidos.add(pedido2);

        app.setPedidos(pedidos);

        app.mostrarPedidos();




    }
}
