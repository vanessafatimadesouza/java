package principal;

/**
 * Classe abstrata que representa um lutador.
 * Esta classe serve como base para a criação de diferentes tipos de lutadores.
 */
public abstract class Lutador {

    protected String nome;
    protected String categoria;
    protected String apelido;
    protected String nacionalidade;
    protected Double peso;
    protected int golpe;
    protected int defesa;
    /**
     * Construtor da classe Lutador.
     *
     * @param nome          Nome do lutador.
     * @param categoria     Categoria do lutador.
     * @param apelido       Apelido do lutador.
     * @param nacionalidade Nacionalidade do lutador.
     * @param peso          Peso do lutador.
     * @param golpe         Força do golpe do lutador.
     * @param defesa        Capacidade de defesa do lutador.
     */
    public Lutador(String nome, String categoria, String apelido, String nacionalidade, Double peso, int golpe, int defesa) {
        this.nome = nome;
        this.categoria = categoria;
        this.apelido = apelido;
        this.nacionalidade = nacionalidade;
        this.peso = peso;
        this.golpe = golpe;
        this.defesa = defesa;
    }

    /**
     * Obtém o nome do lutador.
     *
     * @return Nome do lutador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a categoria do lutador.
     *
     * @return Categoria do lutador.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Obtém o peso do lutador.
     *
     * @return Peso do lutador.
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * Obtém o apelido do lutador.
     *
     * @return Apelido do lutador.
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * Obtém a força do golpe do lutador.
     *
     * @return Força do golpe do lutador.
     */
    public int getGolpe() {
        return golpe;
    }

    /**
     * Obtém a capacidade de defesa do lutador.
     *
     * @return Capacidade de defesa do lutador.
     */
    public int getDefesa() {
        return defesa;
    }

    /**
     * Obtém a nacionalidade do lutador.
     *
     * @return Nacionalidade do lutador.
     */
    public String getNacionalidade() { 
        return nacionalidade; 
    }

    /**
     * Define a nova capacidade de defesa do lutador após receber dano.
     *
     * @param dano Dano recebido pelo lutador.
     */
    public void setDefesa(int dano) {
        this.defesa -= dano;
        if (this.defesa < 0) {
            this.defesa = 0;
        }
    }

	@Override
	public String toString() {
		return "Lutador [nome=" + nome + ", categoria=" + categoria + ", apelido=" + apelido + ", nacionalidade="
				+ nacionalidade + ", peso=" + peso + ", golpe=" + golpe + ", defesa=" + defesa + "]";
	}
}