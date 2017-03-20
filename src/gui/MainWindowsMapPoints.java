package gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindowsMapPoints extends JFrame {
	
	static MainWindowsMapPoints instancia = null;
	private static final long serialVersionUID = 1L;

	public MainWindowsMapPoints() {
		setSize(1200, 300);
		setLocationRelativeTo(null);
		setLayout(null);
		setTitle("Mapas de puntos");
		setIconImage(new ImageIcon("").getImage());
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	
	public static MainWindowsMapPoints getInstancia() {
		if (instancia == null)
			instancia = new MainWindowsMapPoints();
		return instancia;
	}

	public void draw(ArrayList<Double> list) {
		for (int i = 0; i < list.size(); i++) {
			JLabel jlName = new JLabel("" + (i + 1));
			jlName.setBounds((i * 50)+10, 0, 100, 100);
			add(jlName);
	
			JButton jbLine = new JButton();
			jbLine.setBounds((i * 50)+10, (int) (list.get(i) * 100)+100, 10, 10);
			jbLine.setForeground(Color.WHITE);
			jbLine.setBackground(Color.RED);
			jbLine.setFocusable(false);
			add(jbLine);
		}

		repaint();
	}
}