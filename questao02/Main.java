package questao02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double valor;
		int quantidade;
		double totalMoedas = 0.00;
		
		List<PunhadoMoedas> punhado = new ArrayList<>();

		char opcao;
		do {
			System.out.println("\n#### INFORME QUAL FUNÇÃO DESEJA REALIZAR ####");
			System.out.println("\n[A] - CADASTRAR UM NOVO PUNHADO DE MOEDAS");
			System.out.println("[B] - EXIBIÇÃO DO VALOR TOTAL DE MOEDAS SOMANDO TODOS OS PUNHADOS");
			System.out.println("[C] - EXIBIÇÃO DO VALOR DE MOEDA QUE POSSUI MAIOR QUANTIDADE ENTRE TODOS OS PUNHADOS");
			System.out.println("[D] - ENCERRAR O PROGRAMA.");
			opcao = input.nextLine().charAt(0);
			
			switch(opcao) {
			case 'A','a':
				System.out.print("INFORME O VALOR DE MOEDA QUE ESTARÁ NO PUNHADO (VALORES ACEITAVEIS: 0.05, 0.10, 0.25, 0.50, 0.75, 1): ");
				valor = input.nextDouble();
				
				System.out.println("INFORME A QUANTIDADE DE MOEDAS DESTAS QUE ESTARÃO NO PUNHADO: ");
				quantidade = input.nextInt();
				
				PunhadoMoedas punh = new PunhadoMoedas(valor, quantidade);
				punhado.add(punh);
				input.nextLine();
				break;
				
			case 'B', 'b':
				for(int i = 0; i < punhado.size(); i++) {
					totalMoedas += punhado.get(i).getTotalPunhado();
				}
				
				System.out.println("O valor total em moedas em todos os punhados é " + totalMoedas);
				break;
				
			case 'C', 'c':
				double valorMoeda = punhado.get(0).getValor();
				int TotalValor = punhado.get(0).getQuantidade();
				List<Double> valores = new ArrayList<>();
				
				for(int i = 0; i < punhado.size(); i++) {
					if(TotalValor < punhado.get(i).getQuantidade()) {
						valorMoeda = punhado.get(i).getValor();
						TotalValor = punhado.get(i).getQuantidade();
						valores.add((double)punhado.get(i).getValor());
					} else if (TotalValor == punhado.get(i).getQuantidade()) {
						valorMoeda = valorMoeda + punhado.get(i).getValor();
						valores.add((double)punhado.get(i).getValor());
					}
			}
				System.out.println("\nVALOR DE MOEDA EM MAIOR QUANTIDADE ENTRE OS PUNHADOS É: " + valores);
				break;
			}
		} while (opcao != 'D' && opcao != 'd');
	
	
}
}

