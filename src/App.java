import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    private ArrayList<Administrador> admins = new ArrayList<>();

    public App() {

    }

    public void buscarPorItem(String descricao) {
        for(int i =0;i < pedidos.size();i++){
            boolean encontrou = false;
            for (int j =0;j < pedidos.get(i).getItem().size();j++) {
                ItemPedido item = pedidos.get(i).getItem().get(j);
                if (item.getNome().equalsIgnoreCase(descricao)) {
                    resumoPedido(pedidos.get(i));
                    break;
                }
            }

        }
    }

    public Usuario usuarioAtual(int matricula){
        for (int i =0; i < usuarios.size();i++){
            if (matricula == usuarios.get(i).getMatricula()) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    public Administrador administradorAtual(int matricula){
        for (int i =0; i < admins.size();i++){
            if (matricula == admins.get(i).getMatricula()) {
                return admins.get(i);
            }
        }
        return null;
    }

    public void buscaPorFuncionario(int matricula){
        boolean encontrou = false;
        for (int i = 0;i < pedidos.size(); i++){
            if (pedidos.get(i).getFuncionario().getMatricula() == matricula){
                resumoPedido(pedidos.get(i));
                encontrou = true;
            }
        }
        if (!encontrou){
            System.out.println("O funcionário não lançou nenhum pedido");
        }
    }

    public void buscarPorData(LocalDate data){
        boolean encontrou = false;
        for (int i = 0; i < pedidos.size();i++){
            LocalDate dataPedido = pedidos.get(i).getDataPedido();
            if (dataPedido != null && dataPedido.isEqual(data)){
                resumoPedido(pedidos.get(i));
                encontrou = true;
            }
        }
        if (!encontrou){
            System.out.println("Nenhum pedido na data selecionada!");
        }
    }

    public void resumoPedido(Pedido pedido) {
        System.out.println("ID: " + pedido.getId());
        System.out.println("Descrição do pedido: " + pedido.getDescricao());
        System.out.println("Itens do Pedido");
        System.out.println("============");
        mostrarItemAux(pedido);
        System.out.println("Valor Total: R$" + pedido.getValorT());
        System.out.println("Funcionario Solicitante: ");
        System.out.println(pedido.getFuncionario().toString());
        System.out.println(pedido.getDataPedido());
        System.out.println("Status: " + pedido.getStatus());
        System.out.println("\n####################################\n");
    }

    public void adicionarFuncionarios(){
        Administrador adm1 = new Administrador(2712, "Pedro Cristal", "asd123" );
        Administrador adm2 = new Administrador(9374, "Lucas Gargioni", "aka98" );
        Administrador adm3 = new Administrador(7273, "Lucas Neves", "kaka87" );
        Administrador adm4 = new Administrador(4162, "Tiago Audino", "snsba67" );
        Administrador adm5 = new Administrador(2162, "Enzo Sgarbossa", "mamamma90" );

        Usuario rh1 = new RH(3101, "Ana Souza");
        Usuario rh2 = new RH(3102, "Bruno Lima");
        Usuario rh3 = new RH(3103, "Carolina Martins");
        Usuario rh4 = new RH(3104, "Diego Alves");
        Usuario rh5 = new RH(3105, "Eduarda Freitas");

        Usuario limpeza1 = new Limpeza(4201, "Marcos Silva");
        Usuario limpeza2 = new Limpeza(4202, "Juliana Santos");
        Usuario limpeza3 = new Limpeza(4203, "Rafael Oliveira");
        Usuario limpeza4 = new Limpeza(4204, "Camila Rodrigues");
        Usuario limpeza5 = new Limpeza(4205, "Felipe Martins");

        Usuario financeiro1 = new Financeiro(5301, "Fernanda Costa");
        Usuario financeiro2 = new Financeiro(5302, "Gabriel Rocha");
        Usuario financeiro3 = new Financeiro(5303, "Isabela Almeida");
        Usuario financeiro4 = new Financeiro(5304, "Leonardo Mendes");
        Usuario financeiro5 = new Financeiro(5305, "Mariana Nunes");

        Usuario engenheiro1 = new Engenheiro(6401, "João Pereira");
        Usuario engenheiro2 = new Engenheiro(6402, "Matheus Ribeiro");
        Usuario engenheiro3 = new Engenheiro(6403, "Beatriz Ferreira");
        Usuario engenheiro4 = new Engenheiro(6404, "Gustavo Carvalho");
        Usuario engenheiro5 = new Engenheiro(6405, "Laura Moreira");

        Usuario manutencao1 = new Manutencao(7501, "Carlos Mendes");
        Usuario manutencao2 = new Manutencao(7502, "Eduardo Nunes");
        Usuario manutencao3 = new Manutencao(7503, "Larissa Gomes");
        Usuario manutencao4 = new Manutencao(7504, "Henrique Lopes");
        Usuario manutencao5 = new Manutencao(7505, "Patricia Almeida");

        usuarios.add(adm1);
        usuarios.add(adm2);
        usuarios.add(adm3);
        usuarios.add(adm4);
        usuarios.add(adm5);

        admins.add(adm1);
        admins.add(adm2);
        admins.add(adm3);
        admins.add(adm4);
        admins.add(adm5);

        usuarios.add(rh1);
        usuarios.add(rh2);
        usuarios.add(rh3);
        usuarios.add(rh4);
        usuarios.add(rh5);

        usuarios.add(limpeza1);
        usuarios.add(limpeza2);
        usuarios.add(limpeza3);
        usuarios.add(limpeza4);
        usuarios.add(limpeza5);

        usuarios.add(financeiro1);
        usuarios.add(financeiro2);
        usuarios.add(financeiro3);
        usuarios.add(financeiro4);
        usuarios.add(financeiro5);

        usuarios.add(engenheiro1);
        usuarios.add(engenheiro2);
        usuarios.add(engenheiro3);
        usuarios.add(engenheiro4);
        usuarios.add(engenheiro5);

        usuarios.add(manutencao1);
        usuarios.add(manutencao2);
        usuarios.add(manutencao3);
        usuarios.add(manutencao4);
        usuarios.add(manutencao5);
    }
    public void instanciarPedidos() {
        ArrayList<ItemPedido> itens1 = new ArrayList<>();
        ItemPedido item1 = new ItemPedido("Cadeira", 500.0);
        ItemPedido item2 = new ItemPedido("Mesa", 700.0);
        itens1.add(item1);
        itens1.add(item2);
        Usuario funcionario1 = usuarios.get(5);
        Pedido pedido1 = new Pedido("P001", itens1, funcionario1, "Materiais para o RH");
        pedido1.setValorT(pedido1.calculaValor());

        ArrayList<ItemPedido> itens2 = new ArrayList<>();
        ItemPedido item3 = new ItemPedido("Detergente", 50.0);
        ItemPedido item4 = new ItemPedido("Vassoura", 40.0);
        itens2.add(item3);
        itens2.add(item4);
        Usuario funcionario2 = usuarios.get(10);
        Pedido pedido2 = new Pedido("P002", itens2, funcionario2, "Materiais de limpeza");

        ArrayList<ItemPedido> itens3 = new ArrayList<>();
        ItemPedido item5 = new ItemPedido("Calculadora", 120.0);
        ItemPedido item6 = new ItemPedido("Monitor", 900.0);
        itens3.add(item5);
        itens3.add(item6);
        Usuario funcionario3 = usuarios.get(15);
        Pedido pedido3 = new Pedido("P003", itens3, funcionario3, "Equipamentos para o financeiro");

        ArrayList<ItemPedido> itens4 = new ArrayList<>();
        ItemPedido item7 = new ItemPedido("Notebook", 3500.0);
        ItemPedido item8 = new ItemPedido("Mouse", 150.0);
        itens4.add(item7);
        itens4.add(item8);
        Usuario funcionario4 = usuarios.get(20);
        Pedido pedido4 = new Pedido("P004", itens4, funcionario4, "Equipamentos para engenharia");

        ArrayList<ItemPedido> itens5 = new ArrayList<>();
        ItemPedido item9 = new ItemPedido("Furadeira", 600.0);
        ItemPedido item10 = new ItemPedido("Caixa de ferramentas", 350.0);
        itens5.add(item9);
        itens5.add(item10);
        Usuario funcionario5 = usuarios.get(25);
        Pedido pedido5 = new Pedido("P005", itens5, funcionario5, "Ferramentas para manutenção");


        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
        pedidos.add(pedido4);
        pedidos.add(pedido5);
    }


    private void mostrarItemAux(Pedido pedido){
        ArrayList<ItemPedido> items = pedido.getItem();
        for(int i=0;i < items.size();i++){
            System.out.println("Descrição: " +  items.get(i).getNome());
            System.out.println("Valor: " +  items.get(i).getValor());
            System.out.println("============");
        }
    }

    public void mostrarPedidos(){
        for(int i=0;i<pedidos.size();i++){
            resumoPedido(pedidos.get(i));
        }
    }

    public void avaliarPedidos(Administrador administrador, Pedido pedido, Scanner in){
        if(pedido.isAvaliado() == true){
            System.out.println("Pedido ja avaliado");
            return;
        }
        if(administrador.getTipo().equalsIgnoreCase("Administração")){
            System.out.println("Digite a senha");
            String senha = in.nextLine();
            if(senha.equalsIgnoreCase(administrador.getSenha())){
                resumoPedido(pedido);
                System.out.println("[1] Aprovar pedido");
                System.out.println("[2] Reprovar pedido");
                int op;

                while (true){
                    try {
                        op = Integer.parseInt(in.nextLine().trim());
                        if (op == 1 || op == 2){
                            break;
                        }
                        System.out.println("Opção inválida. Digite 1 ou 2:");
                    } catch (NumberFormatException erro) {
                        System.out.println("Entrada inválida. Digite 1 ou 2:");
                    }
                }
                switch (op){
                    case 1:
                        pedido.setStatus("Aprovado");
                        System.out.println("Pedido aprovado com sucesso!");
                        pedido.setAvaliado(true);
                        break;
                    case 2:
                        pedido.setStatus("Reprovado");
                        System.out.println("Pedido reprovado com sucesso!");
                        pedido.setAvaliado(true);
                        break;
                    default:
                        System.out.println("Opcao nao valida!");
                        break;
                }
            }else{
                System.out.println("Senha incorreta");
                return;
            }
        }else{
            System.out.println("Usuario nao autorizado.");
            return;
        }
    }

    public void excluirPedidos(Pedido pedido, Usuario usuario){
        if(usuario.equals(pedido.getFuncionario())){
            pedidos.remove(pedido);
        } else {
            System.out.println("Usuario nao autorizado.");
        }
    }

    public ArrayList<Administrador> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Administrador> admins) {
        this.admins = admins;
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
