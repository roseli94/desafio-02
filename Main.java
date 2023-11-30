import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ProdutoA produtoA = new ProdutoImpl();

            int opcao;
            do {
                System.out.println("Menu:");
                System.out.println("0 - Sair do sistema");
                System.out.println("1 - Cadastrar produto");
                System.out.println("2 - Editar produto");
                System.out.println("3 - Deletar produto");
                System.out.println("4 - Visualizar lista de produtos");

                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();


                switch (opcao) {
                    case 1:
                        cadastrarProduto(scanner, produtoA);
                        break;
                    case 2:
                        editarProduto(scanner, produtoA);
                        break;
                    case 3:
                        deletarProduto(scanner, produtoA);
                        break;
                    case 4:
                        visualizarProdutos(produtoA);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 0);

            System.out.println("Sistema encerrado.");
        } 
    }

    private static void cadastrarProduto(Scanner scanner, ProdutoA produtoA) {
        System.out.print("Digite o ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        


        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        


        System.out.print("Digite o valor do produto: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 
        

        Date dataCadastro = new Date();
        


        Produto produto = new Produto(id, nome, quantidade, valor, dataCadastro);
        produtoA.cadastrarProduto(produto);
    }

    private static void editarProduto(Scanner scanner, ProdutoA produtoA) {
        System.out.print("Digite o ID do produto a ser editado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        


        Produto produtoExistente = procurarProdutoPorId(id, produtoA);

        if (produtoExistente != null) {
            System.out.print("Digite o novo nome do produto: ");
            String novoNome = scanner.nextLine();

            System.out.print("Digite a nova quantidade do produto: ");
            int novaQuantidade = scanner.nextInt();
            scanner.nextLine(); 
            

            System.out.print("Digite o novo valor do produto: ");
            double novoValor = scanner.nextDouble();
            scanner.nextLine(); 


            Date novaDataCadastro = new Date();
            
            Produto novoProduto = new Produto(id, novoNome, novaQuantidade, novoValor, novaDataCadastro);
            produtoA.editarProduto(id, novoProduto);
        }
    }

    private static void deletarProduto(Scanner scanner, ProdutoA produtoA) {
        System.out.print("Digite o ID do produto a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        

        Produto produtoExistente = procurarProdutoPorId(id, produtoA);

        if (produtoExistente != null) {
            produtoA.deletarProduto(id);
        }
    }

    private static void visualizarProdutos(ProdutoA produtoA) {
        List<Produto> produtos = produtoA.listarProdutos();

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    private static Produto procurarProdutoPorId(int id, ProdutoA produtoA) {
        List<Produto> produtos = produtoA.listarProdutos();

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }

        System.out.println("Produto não encontrado.");
        return null;
    }
}
