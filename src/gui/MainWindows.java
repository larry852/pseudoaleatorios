package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import Logic.Calculation;
import Logic.Congruential;
import Logic.Histogram;
import Logic.KolmogorovSmirnov;
import Logic.Operation;
import Logic.StreakTest;

public class MainWindows extends JFrame {

	static MainWindows instancia = null;
	private static final long serialVersionUID = 1L;

	ArrayList<Double> list = new ArrayList<Double>();
	JTextArea jtList;

	JLabel varianza, average, KolmogorovSmirnov, StreakTest;
	public JLabel median, streak, z, dalfa, difference;
	JButton jbHistogram, jbMap;

	Border border = BorderFactory.createLineBorder(Color.BLACK);

	public MainWindows() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		setTitle("Números Pseudoaleatorios");
		setIconImage(new ImageIcon("").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}

	public static MainWindows getInstancia() {
		if (instancia == null)
			instancia = new MainWindows();
		return instancia;
	}

	private void init() {
		String[] options = { "Cuadrados medios", "Congruencial multiplicativo", "Congruencial mixto", "Clase Random Java" };

		int option = JOptionPane.showOptionDialog(null, "Elija el método de ejecución:", "Números Pseudoaleatorios",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);

		switch (option) {
		case 0:
			initComponents();

			JLabel jlDigits = new JLabel("Numero de digitos: ");
			jlDigits.setBounds(20, 50, 200, 30);
			add(jlDigits);

			JTextField jtDigits = new JTextField();
			jtDigits.setBounds(200, 50, 200, 30);
			add(jtDigits);

			JLabel jlSeedStart = new JLabel("Semilla: ");
			jlSeedStart.setBounds(20, 100, 200, 30);
			add(jlSeedStart);

			JTextField jtSeedStart = new JTextField();
			jtSeedStart.setBounds(200, 100, 200, 30);
			add(jtSeedStart);

			JButton jbStart0 = new JButton("Iniciar");
			jbStart0.setBounds(20, 150, 380, 30);
			add(jbStart0);
			jbStart0.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Operation operation = new Operation(Integer.parseInt(jtSeedStart.getText()),
							Integer.parseInt(jtDigits.getText()));
					while (operation.validate())
						operation.next();
					list = operation.getLista();
					drawList();
					drawCalcule();
					drawHistogram();
					drawMapPoints();
					drawKolmogorovSmirnov();
					drawStreakTest();
				}
			});
			break;
		case 1:
			initComponents();

			JLabel jlx1 = new JLabel("Semilla (x): ");
			jlx1.setBounds(20, 50, 200, 30);
			add(jlx1);

			JTextField jtx1 = new JTextField();
			jtx1.setBounds(200, 50, 200, 30);
			add(jtx1);

			JLabel jlm1 = new JLabel("Modulo (m): ");
			jlm1.setBounds(20, 100, 200, 30);
			add(jlm1);

			JTextField jtm1 = new JTextField();
			jtm1.setBounds(200, 100, 200, 30);
			add(jtm1);

			JLabel jla1 = new JLabel("Multiplicador (a): ");
			jla1.setBounds(20, 150, 200, 30);
			add(jla1);

			JTextField jta1 = new JTextField();
			jta1.setBounds(200, 150, 200, 30);
			add(jta1);

			JLabel jlc1 = new JLabel("Adicionador (c): ");
			jlc1.setBounds(20, 200, 200, 30);
			add(jlc1);

			JTextField jtc1 = new JTextField();
			jtc1.setBounds(200, 200, 200, 30);
			add(jtc1);

			JButton jbStart1 = new JButton("Iniciar");
			jbStart1.setBounds(20, 250, 380, 30);
			add(jbStart1);
			jbStart1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Congruential congruential1 = new Congruential(Integer.parseInt(jtx1.getText()),
							Integer.parseInt(jta1.getText()), Integer.parseInt(jtc1.getText()),
							Integer.parseInt(jtm1.getText()), 2);
					while (congruential1.validate())
						congruential1.next();
					list = congruential1.getLista();
					drawList();
					drawCalcule();
					drawHistogram();
					drawMapPoints();
					drawKolmogorovSmirnov();
					drawStreakTest();
				}
			});
			break;
		case 2:
			initComponents();

			JLabel jlx2 = new JLabel("Semilla (x): ");
			jlx2.setBounds(20, 50, 200, 30);
			add(jlx2);

			JTextField jtx2 = new JTextField();
			jtx2.setBounds(200, 50, 200, 30);
			add(jtx2);

			JLabel jlm2 = new JLabel("Modulo (m): ");
			jlm2.setBounds(20, 100, 200, 30);
			add(jlm2);

			JTextField jtm2 = new JTextField();
			jtm2.setBounds(200, 100, 200, 30);
			add(jtm2);

			JLabel jla2 = new JLabel("Multiplicador (a): ");
			jla2.setBounds(20, 150, 200, 30);
			add(jla2);

			JTextField jta2 = new JTextField();
			jta2.setBounds(200, 150, 200, 30);
			add(jta2);

			JButton jbStart2 = new JButton("Iniciar");
			jbStart2.setBounds(20, 200, 380, 30);
			add(jbStart2);
			jbStart2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Congruential congruential2 = new Congruential(Integer.parseInt(jtx2.getText()),
							Integer.parseInt(jta2.getText()), Integer.parseInt(jtm2.getText()), 3);
					while (congruential2.validate())
						congruential2.next();
					list = congruential2.getLista();
					drawList();
					drawCalcule();
					drawHistogram();
					drawMapPoints();
					drawKolmogorovSmirnov();
					drawStreakTest();
				}
			});
			break;			
		case 3:
			initComponents();
			while (validateNumberRandom());
			drawList();
			drawCalcule();
			drawHistogram();
			drawMapPoints();
			drawKolmogorovSmirnov();
			drawStreakTest();
			
		default:
			System.exit(0);
		}
	}

	private void initComponents() {
		varianza = new JLabel();
		varianza.setBounds(20, 300, 500, 30);
		add(varianza);

		average = new JLabel();
		average.setBounds(20, 350, 500, 30);
		add(average);

		JLabel nameStreakTest = new JLabel("Test de rachas: ");
		nameStreakTest.setBounds(450, 375, 500, 30);
		add(nameStreakTest);
		
		StreakTest = new JLabel();
		StreakTest.setBounds(450, 390, 500, 30);
		add(StreakTest);
		
		median = new JLabel();
		median.setBounds(450, 405, 500, 30);
		add(median);
		
		streak = new JLabel();
		streak.setBounds(450, 420, 500, 30);
		add(streak);
		
		z = new JLabel();
		z.setBounds(450, 435, 500, 30);
		add(z);
		
		JLabel nameKolmogorovSmirnov = new JLabel("Kolmogorov-Smirnov: ");
		nameKolmogorovSmirnov.setBounds(450, 455, 500, 30);
		add(nameKolmogorovSmirnov);

		KolmogorovSmirnov = new JLabel();
		KolmogorovSmirnov.setBounds(450, 470, 500, 30);
		add(KolmogorovSmirnov);
		
		dalfa = new JLabel();
		dalfa.setBounds(450, 485, 500, 30);
		add(dalfa);
		
		difference = new JLabel();
		difference.setBounds(450, 500, 500, 30);
		add(difference);
		
		z = new JLabel();
		z.setBounds(450, 435, 500, 30);
		add(z);

		JPanel panelLog = new JPanel();
		panelLog.setBounds(450, 50, 300, 300);
		panelLog.setLayout(null);
		panelLog.setBorder(border);
		add(panelLog);

		jtList = new JTextArea();
		jtList.setEditable(false);

		JScrollPane scroll = new JScrollPane(jtList);
		scroll.setBounds(10, 10, 280, 280);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelLog.add(scroll);

		jbHistogram = new JButton("Histograma");
		jbHistogram.setBounds(20, 400, 380, 30);
		add(jbHistogram);
		jbHistogram.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawHistogram();
			}
		});

		jbMap = new JButton("Mapa de puntos");
		jbMap.setBounds(20, 450, 380, 30);
		add(jbMap);
		jbMap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawMapPoints();
			}
		});
	}

	private void drawList() {
		String text = "";
		for (int i = 0; i < list.size(); i++) {
			text += "\n    " + list.get(i);
		}

		jtList.setText("	" + list.size() + " números generados" + text);
	}

	private void drawCalcule() {
		Calculation c = new Calculation(list);
		varianza.setText("Varianza: " + c.calculateVariance());
		average.setText("Promedio: " + c.calculateAverage());

	}

	private void drawKolmogorovSmirnov() {
		ArrayList<Double> ordererlist = (ArrayList<Double>) list.clone();
		Collections.sort(ordererlist);
		KolmogorovSmirnov ks = new KolmogorovSmirnov(ordererlist);
		if (ks.estimateUniformity())
			KolmogorovSmirnov.setText("Hay independencia en los numeros aleatorios");
		else
			KolmogorovSmirnov.setText("No hay independencia en los numeros aleatorios");
	}

	private void drawStreakTest() {
		ArrayList<Double> ordererlist = (ArrayList<Double>) list.clone();
		Collections.sort(ordererlist);
		StreakTest streak = new StreakTest(list, ordererlist);
		if (streak.acceptIndependence())
			StreakTest.setText("Hay independencia en los numeros aleatorios");
		else
			StreakTest.setText("No hay independencia en los numeros aleatorios");
	}

	private void drawHistogram() {
		Histogram h = new Histogram();
		h.prueba(0.1, list);
		if (MainWindowsHistogram.getInstancia().isVisible())
			MainWindowsHistogram.getInstancia().setVisible(false);
		else
			MainWindowsHistogram.getInstancia().setVisible(true);
	}

	private void drawMapPoints() {
		MainWindowsMapPoints.getInstancia().draw(list);
		if (MainWindowsMapPoints.getInstancia().isVisible())
			MainWindowsMapPoints.getInstancia().setVisible(false);
		else
			MainWindowsMapPoints.getInstancia().setVisible(true);
	}

	private boolean validateNumberRandom() {
		double number = Math.random();
		if (list.contains(number))
			return false;
		else
			list.add(number);
		return true;
	}
}