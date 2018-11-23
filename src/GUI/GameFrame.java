package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Levels.ImageManager;
import Map.GameMap;
import Player.Item;

public class GameFrame extends JFrame implements ActionListener {
	
	
	private GameMap map;
	private JLabel[][] labels;
	private int width, height;
	private ImageManager im;
	private JButton[] inventoryitems;
	private JLabel energy;
	private JLabel money;
	
	public GameFrame(){
		this.setTitle("Jatekunk v1");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(addGamePanel(),BorderLayout.NORTH);
		this.setSize(50*width,50*height+100);
		this.add(addButtonPanel(),BorderLayout.CENTER);
		this.add(addInventoryPanel(),BorderLayout.SOUTH);
		this.add(addStatusPanel(),BorderLayout.EAST);
		this.im = new ImageManager();
		this.drawMap();
		this.setResizable(false);
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
				JLabel jl = new JLabel();
				j.add(jl);
				labels[i][k]=jl;
			}
			
		}
		return j;
	}
	private JPanel addButtonPanel(){
		JPanel j = new JPanel();
		j.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton up = new JButton("up");
		JButton down = new JButton("down");
		JButton left = new JButton("left");
		JButton right = new JButton("right");
		up.addActionListener(this);
		down.addActionListener(this);
		left.addActionListener(this);
		right.addActionListener(this);
		j.add(up);
		j.add(down);
		j.add(left);
		j.add(right);
		
		return j;
	}
	
	private JPanel addInventoryPanel(){
		JPanel j = new JPanel();
		j.setLayout(new GridLayout(2, 4));
		inventoryitems = new JButton[8];
		for(int i=0;i<8;i++){
			JButton it = new JButton("Empty slot");
			j.add(it);
			inventoryitems[i]=it;
		}
		return j;
	}
	
	private JPanel addStatusPanel(){
		JPanel j = new JPanel();
		j.setLayout(new GridLayout(2,1));
		money = new JLabel();
		j.add(money);
		energy = new JLabel();
		j.add(energy);
		return j;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton act = (JButton)e.getSource();
		System.out.println(act.getActionCommand());
		map.doStep(act.getActionCommand());
		drawMap();
		
	}
	
	private void drawMap(){
		energy.setText("Életerõ: " + map.player.energy);
		money.setText("Pénz: " + map.player.money);
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				labels[i][j].setIcon(im.getImage(map.map[i][j]));
			}
		}
		int buttonindex = 0;
		for(Item e : map.player.inventory){
			inventoryitems[buttonindex].setText(e.getName());
			inventoryitems[buttonindex].setEnabled(true);
			buttonindex++;
		}
		for(int i=buttonindex;i<8;i++){
			inventoryitems[i].setEnabled(false);

		}
	}
	
	
	
	

}
