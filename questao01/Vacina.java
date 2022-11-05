package questao01;

// Encapsulamento de dados de vacina
public class Vacina {

	private String nome;				// nome
	private String doencas;				// doenças contra as quais se obtém imunização
	private int dosesIniciais;			// quantidade de doses (ciclo inicial)
	private int dosesReforco;			// quantidade de doses (ciclo de reforço)
	private int meses;					// quantidade de meses após nascido para início de aplicação
	private int imunizacoesCompletas;	// quantidade de indivíduos com imunização completa
	
	// método construtor
	public Vacina(String nome, String doencas, int dosesIniciais, 
			int dosesReforco, int meses) {
		this.nome = nome;
		this.doencas = doencas;
		this.dosesIniciais = dosesIniciais;
		this.dosesReforco = dosesReforco;
		this.meses = meses;
		this.imunizacoesCompletas = 0;
	}

	// métodos getter
	public String getNome() {
		return nome;
	}

	public String getDoencas() {
		return doencas;
	}

	public int getDosesIniciais() {
		return dosesIniciais;
	}

	public int getDosesReforco() {
		return dosesReforco;
	}

	public int getMeses() {
		return meses;
	}

	public int getImunizacoesCompletas() {
		return imunizacoesCompletas;
	}

	// registro de nova conclusão de ciclo de imunização
	public void adicionarConclusaoImunizacao() {
		imunizacoesCompletas++;
	}
	
	// retorno de total de doses incluindo ciclo inicial e ciclo de reforço
	public int getTotalDoses() {
		return dosesIniciais + dosesReforco;
	}
	
}
