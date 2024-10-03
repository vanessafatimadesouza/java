package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Simulação Boxe Paris 2024 com diferentes categorias.
 * Esta classe gerencia a inicialização dos dados da competição, a realização de batalhas
 * em cada categoria e a determinação dos vencedores em cada etapa.
 */
public class Simulacao {
    /** Lista de lutadores na competição */
    List<Lutador> lutadores = new ArrayList<>();

    /** Lista de categorias de luta */
    List<String> categorias = new ArrayList<>();
    
    HashMap<String, Lutador> lutadoresHash = new HashMap<>();

    /** Scanner para leitura de entradas do usuário */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Construtor que inicializa a simulação com lutadores e categorias padrão.
     */
    public Simulacao() {
        inicializaLutadores();
    }

    /**
     * Inicializa os lutadores e categorias padrão na simulação.
     * 
     * Adiciona lutadores reais que estão participando das Olimpíadas de Paris 2024
     * nas respectivas categorias com atributos como nome, categoria, apelido,
     * nacionalidade, peso, golpe e defesa.
     */
    private void inicializaLutadores() {
        categorias.add("PENA");
        categorias.add("MEDIO");
        categorias.add("PESADO");
        categorias.add("SUPERPESADO");

        // Categoria PENA
        lutadores.add(new Pena("Munarbek Seiitbek Uulu", "PENA", "SEIITBEK UULU", "Quirguiz", 56.5, 79, 74));
        lutadores.add(new Pena("Carlo Paalam", "PENA", "PAALAM", "Filipino", 57.0, 84, 79));
        lutadores.add(new Pena("Makhmud Sabyrkhan", "PENA", "SABYRKHAN", "Cazaque", 57.0, 82, 78));
        lutadores.add(new Pena("Jose Quiles Brotons", "PENA", "QUILES BROTONS", "Espanhol", 56.3, 75, 70));
        lutadores.add(new Pena("Jahmal Harvey", "PENA", "HARVEY", "Americano", 56.7, 83, 77));
        lutadores.add(new Pena("Luiz Gabriel Oliveira", "PENA", "OLIVEIRA", "Brasileiro", 56.5, 78, 72));
        lutadores.add(new Pena("Vasile Usturoi", "PENA", "USTUROI", "Belga", 57.0, 80, 75));
        lutadores.add(new Pena("Charlie Senior", "PENA", "SENIOR", "Australiano", 56.2, 81, 76));

        // Categoria MEDIO
        lutadores.add(new Medio("Hebert Conceicao", "MEDIO", "HEBERT", "Brasileiro", 74.3, 102, 90));
        lutadores.add(new Medio("Arlen Lopez", "MEDIO", "LOPEZ", "Cubano", 74.2, 108, 92));
        lutadores.add(new Medio("Oleksandr Khyzhniak", "MEDIO", "KHYZHNIAK", "Ucraniano", 75.0, 104, 88));
        lutadores.add(new Medio("Gleb Bakshi", "MEDIO", "BAKSHI", "Russo", 75.0, 110, 91));
        lutadores.add(new Medio("Eumir Marcial", "MEDIO", "MARCIAL", "Filipino", 75.0, 105, 87));
        lutadores.add(new Medio("Troy Isley", "MEDIO", "ISLEY", "Americano", 74.6, 107, 89));
        lutadores.add(new Medio("Yuito Moriwaki", "MEDIO", "MORIWAKI", "Japonês", 75.0, 109, 90));
        lutadores.add(new Medio("Aidan Walsh", "MEDIO", "WALSH", "Irlandês", 74.5, 111, 92));


        // Categoria PESADO
        lutadores.add(new Pesado("Bakhodir Jalolov", "PESADO", "JALOLOV", "Uzbeque", 91.0, 8, 8));
        lutadores.add(new Pesado("Richard Torrez Jr.", "PESADO", "TORREZ", "Americano", 91.0, 7, 6));
        lutadores.add(new Pesado("Frazer Clarke", "PESADO", "CLARKE", "Britânico", 91.0, 6, 5));
        lutadores.add(new Pesado("Kamshybek Kunkabayev", "PESADO", "KUNKABAYEV", "Cazaque", 91.0, 5, 4));
        lutadores.add(new Pesado("Justis Huni", "PESADO", "HUNI", "Australiano", 91.0, 4, 4));
        lutadores.add(new Pesado("David Nyika", "PESADO", "NYIKA", "Neozelandês", 91.0, 3, 3));
        lutadores.add(new Pesado("Emmanuel Reyes", "PESADO", "REYES", "Espanhol", 91.0, 2, 2));
        lutadores.add(new Pesado("Abner Teixeira", "PESADO", "TEIXEIRA", "Brasileiro", 91.0, 1, 1));


        // Categoria SUPERPESADO
        lutadores.add(new Superpesado("Bakhodir Jalolov", "SUPERPESADO", "JALOLOV", "Uzbeque", 91.0, 8, 8));
        lutadores.add(new Superpesado("Richard Torrez Jr.", "SUPERPESADO", "TORREZ", "Americano", 91.0, 7, 6));
        lutadores.add(new Superpesado("Frazer Clarke", "SUPERPESADO", "CLARKE", "Britânico", 91.0, 6, 5));
        lutadores.add(new Superpesado("Kamshybek Kunkabayev", "SUPERPESADO", "KUNKABAYEV", "Cazaque", 91.0, 5, 4));
        lutadores.add(new Superpesado("Justis Huni", "SUPERPESADO", "HUNI", "Australiano", 91.0, 4, 4));
        lutadores.add(new Superpesado("David Nyika", "SUPERPESADO", "NYIKA", "Neozelandês", 91.0, 3, 3));
        lutadores.add(new Superpesado("Emmanuel Reyes", "SUPERPESADO", "REYES", "Espanhol", 91.0, 2, 2));
        lutadores.add(new Superpesado("Abner Teixeira", "SUPERPESADO", "TEIXEIRA", "Brasileiro", 91.0, 1, 1));

    
        for(Lutador lutador : lutadores) {
        	lutadoresHash.put(lutador.getNome(), lutador);
        }
    }

    /**
     * Exibe informações dos lutadores em uma categoria específica.
     * 
     * @param categoria Categoria dos lutadores a serem exibidos. Se vazio, exibe todos os lutadores.
     */
    public void infoLutadores(String categoria) {
        System.out.println("\nInformações dos Lutadores:");
        for (Lutador lutador : lutadores) {
            if (categoria.isEmpty() || lutador.getCategoria().equals(categoria)) {
                System.out.printf("Nome: %s%nCategoria: %s%nApelido: %s%nNacionalidade: %s%nPeso: %.2f%nGolpe: %d%n",
                        lutador.getNome(), lutador.getCategoria(), lutador.getApelido(),
                        lutador.getNacionalidade(), lutador.getPeso(), lutador.getGolpe(), lutador.getDefesa());
                System.out.println("-------------------------------");
            }
        }
    }
    
    public Lutador buscarLutador(String nome) {
    	return lutadoresHash.get(nome);
    }
    
    
    /**
     * Adiciona um novo lutador à lista de lutadores.
     * 
     * @param scanner Scanner para leitura da entrada do usuário.
     */
    public void adicionarLutador(Scanner scanner) {
        System.out.print("Digite o nome do lutador: ");
        String nome = scanner.nextLine();

        System.out.println("Digite a categoria do lutador (PENA, MEDIO, PESADO, SUPERPESADO):");
        String categoria = scanner.nextLine().toUpperCase();

        System.out.print("Digite o apelido do lutador: ");
        String apelido = scanner.nextLine();

        System.out.print("Digite a nacionalidade do lutador: ");
        String nacionalidade = scanner.nextLine();

        System.out.print("Digite o peso do lutador: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite o golpe do lutador: ");
        int golpe = scanner.nextInt();

        System.out.print("Digite a defesa do lutador: ");
        int defesa = scanner.nextInt();
        scanner.nextLine();
        
        Lutador lutador;

        switch (categoria) {
            case "PENA" -> lutador = new Pena(nome, categoria, apelido, nacionalidade, peso, golpe, defesa);
            case "MEDIO" -> lutador = new Medio(nome, categoria, apelido, nacionalidade, peso, golpe, defesa);
            case "PESADO" -> lutador = new Pesado(nome, categoria, apelido, nacionalidade, peso, golpe, defesa);
            case "SUPERPESADO" -> lutador = new Superpesado(nome, categoria, apelido, nacionalidade, peso, golpe, defesa);
            default -> {
                System.out.println("Categoria inválida!");
                return;
            }
        }

        lutadores.add(lutador);
        lutadoresHash.put(nome, lutador);
        System.out.println("Lutador adicionado com sucesso!");
    }


    /**
     * Retorna uma lista de lutadores que pertencem a uma categoria específica.
     * 
     * Este método percorre a lista de todos os lutadores e seleciona aqueles cuja categoria corresponde
     * à categoria fornecida. A lista resultante contém apenas os lutadores que atendem ao critério de
     * categoria especificado.
     * 
     * @param categoria a categoria dos lutadores a serem retornados. Deve ser uma string que representa
     *                  uma das categorias válidas.
     * @return uma lista de lutadores que pertencem à categoria especificada. Se nenhum lutador corresponder
     *         à categoria, será retornada uma lista vazia.
     */
    public List<Lutador> getLutadoresPorCategoria(String categoria) {
        List<Lutador> lutadoresCategoria = new ArrayList<>();
        for (Lutador lutador : lutadores) {
            if (lutador.getCategoria().equals(categoria)) {
                lutadoresCategoria.add(lutador);
            }
        }
        return lutadoresCategoria;
    }

     /**
     * Realiza a competição entre lutadores na categoria especificada e exibe o resultado das lutas.
     * 
     * @param categoria a categoria dos lutadores que participarão da competição.
     */
    public void competicao(String categoria) {
        System.out.println("\nIniciando competição na categoria " + categoria);
        List<Lutador> lutadoresCategoria = getLutadoresPorCategoria(categoria);
        
        if (lutadoresCategoria.size() < 8) {
            System.out.println("Não há lutadores suficientes na categoria " + categoria);
            return;
        }
        
        Collections.shuffle(lutadoresCategoria);
        
        List<Lutador> vencedores;
        if (lutadoresCategoria.size() > 8) {
            System.out.println("************ Oitavas de Finais ************");
            vencedores = roundsLuta(lutadoresCategoria, "Oitavas de Finais");
            System.out.println("************ Quartas de Finais ************");
            vencedores = roundsLuta(vencedores, "Quartas de Finais");
        } else {
            System.out.println("************ Quartas de Finais ************");
            vencedores = roundsLuta(lutadoresCategoria, "Quartas de Finais");
        }
        
        System.out.println("************ Semifinais ************");
        vencedores = roundsLuta(vencedores, "Semifinais");
        
        List<Lutador> semifinalistas = new ArrayList<>(vencedores); // Armazena os semifinalistas
        
        // Determina o 3º lugar
        System.out.println("************ 3º Lugar ************");
        List<Lutador> naoAvancaramParaFinal = new ArrayList<>(lutadoresCategoria);
        naoAvancaramParaFinal.removeAll(semifinalistas);
        List<Lutador> terceiro = roundsLuta(naoAvancaramParaFinal, "3º Lugar");
        
        // Adiciona o 3º lugar à lista de vencedores
        if (!terceiro.isEmpty()) {
            vencedores.add(terceiro.get(0));
        }
    
        // Exibe o pódio
        System.out.println("\nPódio da categoria " + categoria + ":");
        for (int i = 0; i < Math.min(3, vencedores.size()); i++) {
            String posicao = (i + 1) + "º lugar";
            String nome = vencedores.get(i).getNome();
            System.out.printf("%s: %s%n", posicao, nome);
        }
        
        // Adiciona um espaço e uma mensagem de prompt
        System.out.println("\nPressione Enter para voltar ao menu...");
        scanner.nextLine(); // Espera o usuário pressionar Enter
    }

    /**
     * Executa uma rodada de lutas entre os lutadores fornecidos e determina os vencedores.
     * 
     * Este método organiza uma tabela de competições para a fase especificada da competição, onde
     * cada luta é entre dois lutadores. Os resultados de cada luta são exibidos, e os vencedores são
     * adicionados à lista de vencedores que é retornada ao final.
     
     * 
     * @param lutadoresCategoria a lista de lutadores que participarão das lutas. A lista deve conter
     *                           um número par de lutadores para formar os pares de competição.
     * @param fase a fase da competição para a qual as lutas estão sendo realizadas (por exemplo, "Oitavas de Finais",
     *             "Quartas de Finais", "Semifinais" ou "3º Lugar").
     * @return uma lista de lutadores que venceram suas respectivas lutas na fase especificada. Se a fase for "3º Lugar",
     *         a lista pode conter um número menor de lutadores, dependendo dos resultados das lutas.
     */
    private List<Lutador> roundsLuta(List<Lutador> lutadoresCategoria, String fase) {
        List<Lutador> vencedores = new ArrayList<>();
        System.out.println("\nChave da competição - " + fase + ":");
        System.out.println(" ");
        
        // Exibe a tabela dos jogos
        System.out.printf("%-20s %-10s %-10s %-20s %-10s %-10s %-20s%n", 
                "Lutador 1", "Golpe 1", "Defesa 1", "Lutador 2", "Golpe 2", "Defesa 2", "Resultado");
        System.out.println("---------------------------------------------------------------------------------------------");
    
        for (int i = 0; i + 1 < lutadoresCategoria.size(); i += 2) {
            Lutador lutador1 = lutadoresCategoria.get(i);
            Lutador lutador2 = lutadoresCategoria.get(i + 1);
    
            // Armazena as estatísticas originais dos lutadores
            int golpe1Original = lutador1.getGolpe();
            int defesa1Original = lutador1.getDefesa();
            int golpe2Original = lutador2.getGolpe();
            int defesa2Original = lutador2.getDefesa();
    
            Luta luta = new Luta(lutador1, lutador2);
            Lutador resultado = luta.Lutar();
    
            if (resultado != null) {
                vencedores.add(resultado);
                // Atualiza a tabela com o nome do vencedor
                System.out.printf("%-20s %-10d %-10d %-20s %-10d %-10d %-20s%n",
                    lutador1.getNome(), golpe1Original, defesa1Original,
                    lutador2.getNome(), golpe2Original, defesa2Original,
                    resultado.getNome() + " venceu");
            } else {
                System.out.printf("%-20s %-10d %-10d %-20s %-10d %-10d %-20s%n",
                    lutador1.getNome(), golpe1Original, defesa1Original,
                    lutador2.getNome(), golpe2Original, defesa2Original,
                    "Empate");
            }
        }
    
        if (!fase.equals("3º Lugar")) {
            System.out.println("\nPressione Enter para continuar para a próxima fase...");
            scanner.nextLine(); // Espera o usuário pressionar Enter
        }
    
        return vencedores;
    }
}