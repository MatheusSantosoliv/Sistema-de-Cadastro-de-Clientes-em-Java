import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public void cadastrarCliente(String nome, String cpf, String telefone, String email) {
        Cliente cliente = new Cliente(proximoId++, nome, cpf, telefone, email);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("\n===== LISTA DE CLIENTES =====");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void buscarPorNome(String nome) {
        boolean encontrado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getNome().toLowerCase().contains(nome.toLowerCase())) {
                System.out.println(cliente);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente não encontrado.");
        }
    }

    public Cliente buscarPorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public void atualizarCliente(int id, String novoNome, String novoCpf, String novoTelefone, String novoEmail) {
        Cliente cliente = buscarPorId(id);

        if (cliente != null) {
            cliente.setNome(novoNome);
            cliente.setCpf(novoCpf);
            cliente.setTelefone(novoTelefone);
            cliente.setEmail(novoEmail);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void removerCliente(int id) {
        Cliente cliente = buscarPorId(id);

        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
