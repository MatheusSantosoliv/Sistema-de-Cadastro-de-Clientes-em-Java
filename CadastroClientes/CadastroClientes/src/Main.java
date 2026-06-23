import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteService service = new ClienteService();

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE CADASTRO DE CLIENTES =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente por nome");
            System.out.println("4 - Atualizar cliente");
            System.out.println("5 - Remover cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n=== CADASTRO DE CLIENTE ===");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    service.cadastrarCliente(nome, cpf, telefone, email);
                    break;

                case 2:
                    service.listarClientes();
                    break;

                case 3:
                    System.out.print("Digite o nome do cliente para buscar: ");
                    String nomeBusca = scanner.nextLine();
                    service.buscarPorNome(nomeBusca);
                    break;

                case 4:
                    System.out.print("Digite o ID do cliente que deseja atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Novo CPF: ");
                    String novoCpf = scanner.nextLine();

                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();

                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();

                    service.atualizarCliente(idAtualizar, novoNome, novoCpf, novoTelefone, novoEmail);
                    break;

                case 5:
                    System.out.print("Digite o ID do cliente que deseja remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();

                    service.removerCliente(idRemover);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
