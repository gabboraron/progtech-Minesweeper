package akna;

import static akna.GridButtonPanel.N;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Sándor
 */
class gui {
    private Mine mine;
    private GridButtonPanel gpanel;
    private boolean poused = false;
    
    public gui() {
        mine = new Mine();
        gpanel = new GridButtonPanel(mine, this);
        gpanel.display();
        
        showInitGame();
    }

    
    /**
     * RESET BUTTON
     * @return 
     */
    public JButton reset() {
        JButton btn = new JButton("RESET");
        btn.setFont(new Font("Arial", Font.PLAIN, 20));

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mine.reset();
                showInitGame();
            }
        });
        
        return btn;
    }
    
    /**
     * POUSE BUTTON
     * @return 
     */
    public JButton pouse() {
        JButton btn = new JButton("POUSE: OFF");
        btn.setFont(new Font("Arial", Font.PLAIN, 20));
        
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(poused){
                   btn.setText("POUSE: OFF");
                   poused = false;
                   gpanel.showGameTable();
                }else{
                    btn.setText("POUSE: ON");
                    poused = true;
                    gpanel.hideGameTable();
                }
            }
        });
        return btn;
    }

    /**
     * Recolor the game table and add a new step to list.
     * @param row
     * @param col 
     */
    public void recolorTableAndAddStep(int row, int col) {
        if(!mine.isThisMine(new coordinate(row,col))){
            gpanel.getGridButton(((coordinate) mine.getRoute().get(mine.getRoute().size()-1)).x , ((coordinate) mine.getRoute().get(mine.getRoute().size()-1)).y).setText("");
            mine.addNewStep(new coordinate(row,col));
                
            gpanel.getGridButton(((coordinate) mine.getRoute().get(mine.getRoute().size()-1)).x , ((coordinate) mine.getRoute().get(mine.getRoute().size()-1)).y).setText("X");
            gpanel.getGridButton(((coordinate) mine.getRoute().get(mine.getRoute().size()-1)).x , ((coordinate) mine.getRoute().get(mine.getRoute().size()-1)).y).setBackground(Color.gray);
            gpanel.getGridButton(((coordinate) mine.getRoute().get(mine.getRoute().size()-1)).x , ((coordinate) mine.getRoute().get(mine.getRoute().size()-1)).y).setFont(new Font("Arial", Font.PLAIN, 40));
            
            if(mine.isGameCompleted()){
                JOptionPane.showMessageDialog(null, "YOU WIN! CONGRATULATIONS!");
                mine.reset();
                showInitGame();
            }
        } else {
            JOptionPane.showMessageDialog(null, "GAME OVER :( ");
        }
    }

    /**
     * Show the game table at start.
     */
    private void showInitGame() {
        for (int i = 0; i < GridButtonPanel.N * GridButtonPanel.N; i++) {
            int row = i / GridButtonPanel.N;
            int col = i % GridButtonPanel.N;
            gpanel.getGridButton(row, col).setBackground(Color.white);
            gpanel.getGridButton(row, col).setText("");
        }
        
        gpanel.getGridButton(((coordinate) mine.getRoute().get(0)).x , ((coordinate) mine.getRoute().get(0)).y).setText("X");
        gpanel.getGridButton(((coordinate) mine.getRoute().get(0)).x , ((coordinate) mine.getRoute().get(0)).y).setBackground(Color.gray);
        gpanel.getGridButton(((coordinate) mine.getRoute().get(0)).x , ((coordinate) mine.getRoute().get(0)).y).setFont(new Font("Arial", Font.PLAIN, 40));
    }


    
}
