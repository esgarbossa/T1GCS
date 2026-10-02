import java.util.List;

public class EstatisticasMaiorPedidoAberto {

    public EstatisticasMaiorPedidoAberto(){
    }

    public void mostrar(Usuario usuarioAtual, List<Pedido> pedidos) {
        if (!(usuarioAtual instanceof Administrador)) {
            System.out.println("Acesso permitido apenas a administradores.");
            return;
        }

        Pedido maiorPedido = null;
        double maiorValor = 0;

        for (Pedido pedido : pedidos) {
            if ("Aberto".equalsIgnoreCase(pedido.getStatus())) {
                double valor = pedido.calculaValor();

                if (maiorPedido == null || valor > maiorValor) {
                    maiorPedido = pedido;
                    maiorValor = valor;
                }
            }
        }

        if (maiorPedido == null) {
            System.out.println("Nenhum pedido aberto encontrado.");
            return;
        }

        System.out.println("Pedido aberto de maior valor:");
        System.out.println("ID: " + maiorPedido.getId());
        System.out.println("Descricao: " + maiorPedido.getDescricao());

        Usuario solicitante = maiorPedido.getFuncionario();

        if (solicitante != null) {
            System.out.println("Solicitante: " + solicitante.getNome());
            System.out.println("Matricula: " + solicitante.getMatricula());
            System.out.println("Departamento: " + solicitante.getTipo());
        }

        System.out.println("Status: " + maiorPedido.getStatus());
        System.out.println("Data do pedido: " + maiorPedido.getDataPedido());
        System.out.println(
                "Data de conclusao: "
                        + (maiorPedido.getDataConclusao() == null
                                ? "Nao concluido"
                                : maiorPedido.getDataConclusao()));

        System.out.println("Itens:");

        for (ItemPedido item : maiorPedido.getItem()) {
            System.out.printf(
                    "- %s: R$ %.2f%n",
                    item.getNome(),
                    item.getValor());
        }

        System.out.printf("Valor total: R$ %.2f%n", maiorValor);
    }
}
