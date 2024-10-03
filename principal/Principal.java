package principal;

import java.util.List;
import java.util.Scanner;

/**
 * Classe principal do programa que gerencia a interação com o usuário e controla o fluxo do sistema de simulação de competições.
 * 
 * O programa oferece um menu para adicionar lutadores, mostrar informações dos lutadores, realizar competições ou sair.
 */
public class Principal {

    /**
     * Método principal que inicia a aplicação e exibe o menu para o usuário interagir.
     * 
     * O método permite ao usuário escolher entre adicionar um lutador, mostrar informações dos lutadores, realizar uma competição
     * ou sair do programa. Dependendo da opção selecionada, o programa executa a ação correspondente.
     * 
     * @param args Argumentos da linha de comando. Este parâmetro é incluído na assinatura do método, mas não é utilizado na implementação.
     */
    public static void main(String[] args) {
        Simulacao simulacao = new Simulacao();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            do {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Adicionar Lutador");
                System.out.println("2. Mostrar Informações dos Lutadores");
                System.out.println("3. Bucar Informações de um Lutador Específico por Nome");
                System.out.println("4. Realizar Competição");
                System.out.println("5. Sair");
                opcao = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (opcao) {
                    case 1 -> simulacao.adicionarLutador(scanner);
                    case 2 -> {
                        System.out.println("Escolha a categoria para exibir os lutadores:");
                        System.out.println("1. PENA");
                        System.out.println("2. MEDIO");
                        System.out.println("3. PESADO");
                        System.out.println("4. SUPERPESADO");
                        System.out.println("5. Todos");
                        int categoriaOpcao = scanner.nextInt();
                        scanner.nextLine(); 

                        String categoria;
                        switch (categoriaOpcao) {
                            case 1 -> categoria = "PENA";
                            case 2 -> categoria = "MEDIO";
                            case 3 -> categoria = "PESADO";
                            case 4 -> categoria = "SUPERPESADO";
                            case 5 -> categoria = ""; // Exibir todos
                            default -> {
                                System.out.println("Opção inválida. Exibindo todos os lutadores.");
                                categoria = "";
                            }
                        }
                        simulacao.infoLutadores(categoria);
                    }
                    case 3 -> {
                    	System.out.println("Digite o nome do lutador: ");
                    	String pugilista = scanner.nextLine();
                    	Lutador resultado = simulacao.buscarLutador(pugilista);
                    	
                    	if (resultado != null) {
                    		System.out.println("-------------------------------");
                        	System.out.println("Lutador Encontrado!");
                        	System.out.println("-------------------------------");
                        	System.out.printf("Nome: %s%n",resultado.getNome());
                        	System.out.printf("Categoria: %s%n",resultado.getCategoria());
                        	System.out.printf("Apelido: %s%n",resultado.getApelido());
                        	System.out.printf("Nacionalidade: %s%n",resultado.getNacionalidade());
                        	System.out.printf("Peso: %.2f%n",resultado.getPeso());
                        	System.out.printf("Golpe: %d%n",resultado.getGolpe());
                        	System.out.printf("Defesa: %d%n",resultado.getGolpe());
                            System.out.println("-------------------------------");
                    	}
                    	else {
                    		System.out.println("Lutador não encontrado.");
                    	}
                    }
                    case 4 -> {
                        System.out.println("Escolha a categoria para a competição:");
                        System.out.println("1. PENA");
                        System.out.println("2. MEDIO");
                        System.out.println("3. PESADO");
                        System.out.println("4. SUPERPESADO");
                        int categoriaCompeticaoOpcao = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        String categoriaCompeticao;
                        switch (categoriaCompeticaoOpcao) {
                            case 1 -> categoriaCompeticao = "PENA";
                            case 2 -> categoriaCompeticao = "MEDIO";
                            case 3 -> categoriaCompeticao = "PESADO";
                            case 4 -> categoriaCompeticao = "SUPERPESADO";
                            default -> {
                                System.out.println("Opção inválida. Competição não realizada.");
                                continue;
                        }
                        }
                        
                        // Verificar se o número de lutadores na categoria é par
                        List<Lutador> lutadoresCategoria = simulacao.getLutadoresPorCategoria(categoriaCompeticao);
                        while (lutadoresCategoria.size() % 2 != 0) {
                            System.out.println("Número ímpar de lutadores na categoria " + categoriaCompeticao + ". Adicione mais um lutador.");
                            simulacao.adicionarLutador(scanner);
                            lutadoresCategoria = simulacao.getLutadoresPorCategoria(categoriaCompeticao);
                        }
                        
                        if (lutadoresCategoria.size() % 2 == 0) {
                            simulacao.competicao(categoriaCompeticao);
                        } else {
                            System.out.println("Ainda há um número ímpar de lutadores na categoria " + categoriaCompeticao + ". Competição não realizada.");
                        }
                    }
                    case 5 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 5);
        }
    }
    
}