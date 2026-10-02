import java.util.List;

public class EstatisticasTotais {

    public void mostrar(Usuario usuarioAtual, List<Pedido> pedidos) {
        if (!(usuarioAtual instanceof Administrador)) {
            System.out.println("Acesso permitido apenas a administradores.");
            return;
        }

        int total = pedidos.size();
        int aprovados = 0;
        int reprovados = 0;

        for (Pedido pedido : pedidos) {
            if ("Aprovado".equalsIgnoreCase(pedido.getStatus())) {
                aprovados++;
            } else if ("Reprovado".equalsIgnoreCase(pedido.getStatus())) {
                reprovados++;
            }
        }

        double percentualAprovados = 0;
        double percentualReprovados = 0;

        if (total > 0) {
            percentualAprovados = aprovados * 100.0 / total;
            percentualReprovados = reprovados * 100.0 / total;
        }

        System.out.println("Total de pedidos: " + total);

        System.out.printf(
                "Aprovados: %d (%.2f%%)%n",
                aprovados,
                percentualAprovados);

        System.out.printf(
                "Reprovados: %d (%.2f%%)%n",
                reprovados,
                percentualReprovados);
    }
}
