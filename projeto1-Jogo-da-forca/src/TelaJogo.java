import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaJogo {

	private JFrame frame;
	private JButton button;
	private JLabel label;
	private JLabel label_1;
	private JTextField textField;
	private JLabel label_2;
	private JButton button_1;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JogoDaForca jogo;
	private JLabel label_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogo window = new TelaJogo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaJogo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Jogo da Forca");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		button = new JButton("INICIAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jogo = new JogoDaForca();
					jogo.iniciar();
					textField.setText("");
					textField.setEnabled(true);
					button_1.setEnabled(true);
					label.setText("TAMANHO DA PALAVRA: " + jogo.getTamanho());
					label_1.setText("DICA: " + jogo.getDica());
					label_4.setText("PALAVRA: " + jogo.getPalavraAdivinhada());
					label_3.setText(jogo.getResultado());
					label_5.setText("acertos = 0");
					label_6.setText("penalidades = 0");
					ImageIcon icon = new ImageIcon(TelaJogo.class.getResource("/imagens/6.png"));
						icon.setImage(icon.getImage().getScaledInstance(
			  	        label_7.getWidth(),
			  	        label_7.getHeight(),
			  	        Image.SCALE_DEFAULT));
			  	    label_7.setIcon(icon);
			          
			        }
				catch(Exception erro) {
			          label_3.setText(erro.getMessage());
			          textField.setText(null);
			    }
			}
		});
		button.setBounds(10, 10, 85, 21);
		frame.getContentPane().add(button);
		
		label = new JLabel("TAMANHO DA PALAVRA:");
		label.setBounds(10, 52, 153, 13);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("DICA:");
		label_1.setBounds(10, 75, 288, 13);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(45, 98, 71, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
		label_2 = new JLabel("Letra:");
		label_2.setBounds(10, 101, 55, 13);
		frame.getContentPane().add(label_2);
		
		button_1 = new JButton("ADIVINHAR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String letraDigitada = textField.getText();
				ArrayList<Integer> ocorrencias = new ArrayList<>();
				try {
					ocorrencias = jogo.getOcorrencias(letraDigitada);
					label_3.setText(jogo.getResultado());
					if (jogo.terminou()) {
						button_1.setEnabled(false);
						textField.setEnabled(false);
					}
					textField.setText(null);
					label_4.setText("PALAVRA: " + jogo.getPalavraAdivinhada());
					label_5.setText("acertos = " + jogo.getAcertos());
					label_6.setText("penalidades: " + jogo.getNumeroPenalidade() + " - " + jogo.getNomePenalidade());
					
					if (jogo.getNumeroPenalidade() == 0) {
						ImageIcon icon = new ImageIcon(TelaJogo.class.getResource("/imagens/6.png"));
			  	    	icon.setImage(icon.getImage().getScaledInstance(
			  	        label_7.getWidth(),
			  	        label_7.getHeight(),
			  	        Image.SCALE_DEFAULT));
			  	    label_7.setIcon(icon);
					}
					
					else if (jogo.getNumeroPenalidade() == 1) {
						ImageIcon icon = new ImageIcon(TelaJogo.class.getResource("/imagens/5.png"));
			  	    	icon.setImage(icon.getImage().getScaledInstance(
			  	        label_7.getWidth(),
			  	        label_7.getHeight(),
			  	        Image.SCALE_DEFAULT));
			  	    label_7.setIcon(icon);
					}
					
					else if (jogo.getNumeroPenalidade() == 2) {
						ImageIcon icon = new ImageIcon(TelaJogo.class.getResource("/imagens/4.png"));
			  	    	icon.setImage(icon.getImage().getScaledInstance(
			  	        label_7.getWidth(),
			  	        label_7.getHeight(),
			  	        Image.SCALE_DEFAULT));
			  	    label_7.setIcon(icon);
					}
					
					else if (jogo.getNumeroPenalidade() == 3) {
						ImageIcon icon = new ImageIcon(TelaJogo.class.getResource("/imagens/3.png"));
			  	    	icon.setImage(icon.getImage().getScaledInstance(
			  	        label_7.getWidth(),
			  	        label_7.getHeight(),
			  	        Image.SCALE_DEFAULT));
			  	    label_7.setIcon(icon);
					}
					
					else if (jogo.getNumeroPenalidade() == 4) {
						ImageIcon icon = new ImageIcon(TelaJogo.class.getResource("/imagens/2.png"));
			  	    	icon.setImage(icon.getImage().getScaledInstance(
			  	        label_7.getWidth(),
			  	        label_7.getHeight(),
			  	        Image.SCALE_DEFAULT));
			  	    label_7.setIcon(icon);
					}
					
					else if (jogo.getNumeroPenalidade() == 5) {
						ImageIcon icon = new ImageIcon(TelaJogo.class.getResource("/imagens/1.png"));
			  	    	icon.setImage(icon.getImage().getScaledInstance(
			  	        label_7.getWidth(),
			  	        label_7.getHeight(),
			  	        Image.SCALE_DEFAULT));
			  	    label_7.setIcon(icon);
					}
					
					else {
						ImageIcon icon = new ImageIcon(TelaJogo.class.getResource("/imagens/0.png"));
			  	    	icon.setImage(icon.getImage().getScaledInstance(
			  	        label_7.getWidth(),
			  	        label_7.getHeight(),
			  	        Image.SCALE_DEFAULT));
			  	    label_7.setIcon(icon);
			  	    button_1.setEnabled(false);
					}
				}
				catch (Exception erro) {
					label_3.setText(erro.getMessage());
					textField.setText(null);
				}
			}
		});
		button_1.setBounds(139, 98, 122, 21);
		frame.getContentPane().add(button_1);
		button_1.setEnabled(false);
		
		label_3 = new JLabel("MENSAGEM JOGO");
		label_3.setBounds(10, 168, 251, 13);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("PALAVRA:");
		label_4.setBounds(10, 138, 153, 13);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("acertos:");
		label_5.setBounds(139, 14, 66, 13);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("penalidades:");
		label_6.setBounds(215, 14, 211, 13);
		frame.getContentPane().add(label_6);
		
		label_7 = new JLabel("");
		label_7.setBounds(271, 52, 142, 160);
		frame.getContentPane().add(label_7);
		
	}
}
