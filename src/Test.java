import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        App app = new App();

        Scanner in = new Scanner(System.in);

        Pedido pedido = new Pedido();

        ArrayList<ItemPedido> itemPedido = new ArrayList();

        ItemPedido item1= new ItemPedido("A", 100);
        ItemPedido item2= new ItemPedido("A", 100);
        ItemPedido item3= new ItemPedido("A", 100);


        app.mostrarPedidos();




    }
}
