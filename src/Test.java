import java.util.ArrayList;

import java.time.LocalDate;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        EstatisticasMaiorPedidoAberto maiorPedidoAberto = new EstatisticasMaiorPedidoAberto();

        EstatisticasTotais totais = new EstatisticasTotais();

        App app = new App();

        Scanner in = new Scanner(System.in);

        app.adicionarFuncionarios();

        Usuario user1 = app.usuarioAtual(5301);

        Administrador admin = app.getAdmins().get(0);

        ItemPedido item1= new ItemPedido("A", 100);
        ItemPedido item2= new ItemPedido("B", 100);
        ItemPedido item3= new ItemPedido("C", 100);

        ArrayList<ItemPedido> itens1 = new ArrayList<>();

        ArrayList<ItemPedido> itens2 = new ArrayList<>();

        itens2.add(item1);

        itens1.add(item3);

        itens2.add(item2);

        Pedido pedido1 = new Pedido("1",itens1,user1,"a");
        Pedido pedido2 = new Pedido("2", itens2,user1,"b");



        if (pedido1.getItem() != null){
            app.getPedidos().add(pedido1);
        }
        if (pedido2.getItem() != null){
            app.getPedidos().add(pedido2);
        }

        maiorPedidoAberto.mostrar(admin,app.getPedidos());

        app.avaliarPedidos(admin,pedido1,in);
        app.avaliarPedidos(admin,pedido2,in);












    }
}
