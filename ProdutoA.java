// ProdutoA.java
import java.util.List;

public interface ProdutoA {
    void cadastrarProduto(Produto produto);
    void editarProduto(int id, Produto produto);
    void deletarProduto(int id);
    List<Produto> listarProdutos();
}
