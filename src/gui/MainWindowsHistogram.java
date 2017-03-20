package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindowsHistogram extends JFrame {
	
	static MainWindowsHistogram instancia = null;
	private static final long serialVersionUID = 2L;

	public MainWindowsHistogram() {
		setSize(1150, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setTitle("Histograma");
		setIconImage(new ImageIcon("").getImage());
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	
	public static MainWindowsHistogram getInstancia() {
		if (instancia == null)
			instancia = new MainWindowsHistogram();
		return instancia;
	}

	public void draw(String name, int size, int line) {
		
		JButton jbLine = new JButton(""+size);
		jbLine.setBounds((line*100), 80, 80, (size*100));
		jbLine.setForeground(Color.WHITE);
		jbLine.setBackground(Color.BLUE);
		jbLine.setFocusable(false);
		add(jbLine);

		JLabel jlName = new JLabel(name);
		jlName.setBounds((line*100)+5, 0, 100, 100);
		add(jlName);
		repaint();
	}
}