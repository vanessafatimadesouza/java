package principal;

/**
 * Classe que representa um lutador da categoria Médio.
 * Esta classe é uma extensão da classe abstrata Lutador.
 */
public class Medio extends Lutador {

    /**
     * Construtor da classe Medio.
     *
     * @param nome          Nome do lutador.
     * @param categoria     Categoria do lutador.
     * @param peso          Peso do lutador.
     * @param apelido       Apelido do lutador.
     * @param nacionalidade Nacionalidade do lutador.
     * @param golpe         Força do golpe do lutador.
     * @param defesa        Capacidade de defesa do lutador.
     */
    public Medio(String nome, String categoria, String apelido, String nacionalidade, Double peso, int golpe, int defesa) {
        super(nome, categoria, apelido, nacionalidade, peso, golpe, defesa);
    }

}