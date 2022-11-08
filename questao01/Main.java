package questao01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String nome;
		String doencas;
		int dosesIniciais;
		int dosesReforco;
		int meses;
		int publicoInfantil = 1500;
		final int TOTAL_VACINAS = 6;
		
		List<Vacina> vacines =new ArrayList<>(TOTAL_VACINAS);
		
		System.out.println("### PAINEL ###");
		
		for(int i = 0; i < TOTAL_VACINAS; i++) {
			System.out.print("\nINFORME O NOME DA VACINA #"+(i+1)+": ");
			nome = input.nextLine();
			
			System.out.print("INFORME A DOENÇA QUE SE OBTÉM IMUNIZAÇÃO: ");
			doencas = input.nextLine();
			
			System.out.print("INFORME A QUANTIDADE DE DOSES INICIAIS: ");
			dosesIniciais = input.nextInt();
			
			System.out.print("INFORME A QUANTIDADE DE DOSES DE REFORÇO: ");
			dosesReforco = input.nextInt();
			
			System.out.print("INFORME A QUANTIDADE DE MESES APÓS NASCIDO PARA INÍCIO DA APLICAÇÃO: ");
			meses = input.nextInt();
			input.nextLine();
			
			Vacina vac = new Vacina(nome, doencas, dosesIniciais, dosesReforco, meses);
			vacines.add(vac);
		}
		
		char opcao;
		boolean ligado = true;
		do {
		System.out.println("\n#### INFORME QUAL FUNÇÃO DESEJA REALIZAR ####");
		System.out.println("\n[A] - REGISTRAR NOVA CONCLUSÃO DE CICLO DE APLICAÇÃO DE UMA VACINA");
		System.out.println("[B] - EXIBIR O PERCENTUAL DE COBERTURA DE CADA UMA DAS VACINAS EM RELAÇÃO AO PÚBLICO ESTIMADO");
		System.out.println("[C] - MOSTRAR QUAL VACINA POSSUI O MAIOR QUANTITATIVO DE DOSES PREVISTAS");
		System.out.println("[D] - ENCERRAR O PROGRAMA.");
		opcao = input.nextLine().charAt(0);

		switch (opcao) {
		case 'A','a':
			System.out.println("INFORME QUAL VACINA DESEJA REGISTRAR A NOVA CONCLUSÃO DE CICLO (1-6)");
			int escolha = input.nextInt();
			vacines.get(escolha-1).adicionarConclusaoImunizacao();
			System.out.println("CICLO DA VACINA "+ vacines.get(escolha-1).getNome()+" CONCLUIDO");
			input.nextLine();
			break;
			
		case 'B','b':
			for(int i = 0; i < TOTAL_VACINAS; i++) {
				double porcentagem = ((double)vacines.get(i).getImunizacoesCompletas()/ publicoInfantil)*100;
				System.out.println(porcentagem +"% do público infantil foi imunizado com a vacina " + vacines.get(i).getNome());
			}
			break;
			
		case 'C','c':
			String nomeVacinas = vacines.get(0).getNome();
			int maiorDose = vacines.get(0).getTotalDoses();
			
			for(int i = 1; i < vacines.size(); i++) {
				if(maiorDose < vacines.get(i).getTotalDoses()) {
					nomeVacinas = vacines.get(i).getNome();
					maiorDose = vacines.get(i).getTotalDoses();
				} else if (maiorDose == vacines.get(i).getTotalDoses()) {
					nomeVacinas += ", " + vacines.get(i).getNome();
				}
			}
			System.out.println("\nVACINAS COM MAIOR QUANTIDADE DE DOSES: " + nomeVacinas);
			break;

			default:ligado = false;
		}
		
		} while (ligado);
		
		input.close();
		System.out.println("ENCERRAMENTO DA APLICAÇÃO...");
		
	}
}
