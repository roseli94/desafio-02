import java.util.ArrayList;
import java.util.List;

public class ProdutoImpl implements ProdutoA {
    private List<Produto> produtos;

    public ProdutoImpl() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    @Override
    public void editarProduto(int id, Produto novoProduto) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produtoAtual = produtos.get(i);
            if (produtoAtual.getId() == id) {
                produtoAtual.setNome(novoProduto.getNome());
                produtoAtual.setQuantidade(novoProduto.getQuantidade());
                produtoAtual.setValor(novoProduto.getValor());
                produtoAtual.setDataCadastro(novoProduto.getDataCadastro());
                System.out.println("Produto editado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado para edição.");
    }

    @Override
    public void deletarProduto(int id) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                produtos.remove(i);
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado para remoção.");
    }

    @Override
    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos);
    }
}
