package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Map.GameMap;

public class GameFrame extends JFrame {
	
	
	private GameMap map;
	private JLabel[][] labels;
	private int width, height;
	
	public GameFrame(){
		this.setTitle("Jatekunk");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		this.add(addGamePanel(),BorderLayout.NORTH);
		this.repaint();
	}
	private JPanel addGamePanel(){
		JPanel j = new JPanel();
		map = new GameMap();
		this.width = map.width;
		this.height = map.height;
		j.setLayout(new GridLayout(height, width));
		labels = new JLabel[height][width];
		for(int i=0;i<width;i++){
			for(int k=0;k<height;k++){
				JLabel jl = new JLabel("_");
				j.add(jl);
				labels[i][k]=jl;
			}
			
		}
		return j;
	}
	
	
	

}
