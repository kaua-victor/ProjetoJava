import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
	
	private ArrayList<String> palavrasList = new ArrayList<String>();
	private ArrayList<String> dicasList = new ArrayList<String>();
	private String[] palavraSorteada;
	private ArrayList<String> palavraAdivinhada = new ArrayList<String>();
	private String dica;
	private int acertos = 0;
	private int numeroPenalidade = 0;
	private String[] nomePenalidade = {"Sem penalidades!", "Cabeça", "Tronco", "Braço Direito", "Braço Esquerdo", "Perna Direita", "Perna Esquerda"};
	private boolean terminou = false;
	private ArrayList<Integer> ocorrencias;
	private ArrayList<String> historicoLetras = new ArrayList<>();
	
	
	
	public JogoDaForca() throws Exception {
		InputStream stream = this.getClass().getResourceAsStream("/dados/palavras.txt");
		if (stream == null)
			throw new Exception("Arquivo de palavras inexistente");
		Scanner arquivo = new Scanner(stream);
		
		String linha;
		while (arquivo.hasNext()) {
			linha = arquivo.nextLine().toUpperCase();
			
			this.palavrasList.add(linha.split(";")[0]);
			this.dicasList.add(linha.split(";")[1]);
		}
		arquivo.close();
		//System.out.println(palavrasList);
		//System.out.println(dicasList);
		
		
		
	}
	
	public void iniciar() {
			Random random = new Random();
			int indice = random.nextInt(palavrasList.size());
			this.palavraSorteada = palavrasList.get(indice).split("");
			this.dica = dicasList.get(indice);
			
			for (int i = 0; i < palavraSorteada.length; i++) {
				this.palavraAdivinhada.add("*");
			}
		}
	
		public String getPalavra() {
			String s = "";
			for (int i = 0; i < palavraSorteada.length; i++) {
				s += palavraSorteada[i];
			}
			return s;
			
		}
		
		public String getDica() {
			return this.dica;
		}
		
		public int getTamanho() {
			return this.palavraSorteada.length;
		
		}
		
		public ArrayList<Integer> getOcorrencias (String letra) throws Exception {
			String letraMaiuscula = letra.toUpperCase();
			ocorrencias = new ArrayList<>();
			if (letraMaiuscula == "") 
				throw new Exception("Digite uma letra!");
			
			if (letraMaiuscula.length() > 1)
				throw new Exception("Digite apenas 1 caractere!");
			
			
			if (!letraMaiuscula.matches("[A-Z]"))
				throw new Exception("Digite apenas letras!");
			
			if (historicoLetras.contains(letraMaiuscula))
				throw new Exception("Você já tentou essa letra anteriormente!");
			
			this.historicoLetras.add(letraMaiuscula);
			
			for (int i = 0; i < palavraSorteada.length; i++) {
				if (palavraSorteada[i].equals(letraMaiuscula)) {
					this.acertos += 1;
					this.palavraAdivinhada.set(i, letraMaiuscula);
					this.historicoLetras.add(letraMaiuscula);
					this.ocorrencias.add(i);
				}
				
				
			}
			
			if (this.ocorrencias.size() == 0) {
				this.numeroPenalidade ++;
				
			}
			if (!this.palavraAdivinhada.contains("*") || this.numeroPenalidade == 6)
				this.terminou = true;
			return this.ocorrencias;
			
		}
		
		
		public boolean terminou() {
			return this.terminou;
		}
		
		public String getPalavraAdivinhada() {
			String palavraAdivinhada2 = "";
			for (int i = 0; i < this.palavraAdivinhada.size(); i++) {
				palavraAdivinhada2 += this.palavraAdivinhada.get(i);
			}
			return palavraAdivinhada2;
			
		}
		
		public int getAcertos() {
			return this.acertos;
		}
		
		public int getNumeroPenalidade() {
			return this.numeroPenalidade;
		}
		
		public String getNomePenalidade() {
			return this.nomePenalidade[this.numeroPenalidade];
			
		}
		
		public String getResultado() {
			if (this.acertos == palavraSorteada.length) return "Você venceu!";
			else if (this.numeroPenalidade == 6) return "Você foi enforcado!";
			else return "Jogo em andamento!";
		}
 		
		
		
		
		
	

}
