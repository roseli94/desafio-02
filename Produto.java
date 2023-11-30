// Produto.java
import java.util.Date;
//Atributos 
public class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private double valor;
    private Date dataCadastro;


    //#region construtores
    
    public Produto(int id, String nome, int quantidade, double valor, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
    }
    //#endregion

//#region getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
//#endregion 

//#region override 
    @Override
    public String toString() {
        // Implemente conforme necessário para a exibição dos dados do produto
        return "ID: " + id + ", Nome: " + nome + ", Quantidade: " + quantidade + ", Valor: " + valor + ", Data de Cadastro: " + dataCadastro;
    }//#endregion
}
