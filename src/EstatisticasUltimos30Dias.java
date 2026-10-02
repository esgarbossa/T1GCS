import java.time.LocalDate;
import java.util.List;

public class EstatisticasUltimos30Dias {

    public void mostrar(Usuario usuarioAtual, List<Pedido> pedidos) {
        if (!(usuarioAtual instanceof Administrador)) {
            System.out.println("Acesso permitido apenas a administradores.");
            return;
        }

        LocalDate hoje = LocalDate.now();
        LocalDate inicio = hoje.minusDays(29);

        int quantidade = 0;
        double valorTotal = 0;

        for (Pedido pedido : pedidos) {
            LocalDate data = pedido.getDataPedido();

            if (data != null
                    && !data.isBefore(inicio)
                    && !data.isAfter(hoje)) {
                quantidade++;
                valorTotal += pedido.calculaValor();
            }
        }

        double valorMedio = 0;

        if (quantidade > 0) {
            valorMedio = valorTotal / quantidade;
        }

        System.out.println("Periodo: " + inicio + " ate " + hoje);
        System.out.println("Pedidos nos ultimos 30 dias: " + quantidade);
        System.out.printf("Valor medio dos pedidos: R$ %.2f%n", valorMedio);
    }
}
