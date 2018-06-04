package akna;
/**
 *
 * @author Sándor
 */


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
/**
 * @see http://stackoverflow.com/questions/7702697
 */
public class GridButtonPanel {
    private JFrame f;   //main JFrame
    JPanel p;           //grid panel
    JPanel n;           //nav panel
    
    /**/
    Mine mine;
    gui gui;
    public GridButtonPanel(Mine mine, gui gui) {
        this.mine = mine;
        this.gui = gui;
    }
    /**/
    
    public static final int N = 6;
    private final List<JButton> list = new ArrayList<JButton>();

    public JButton getGridButton(int r, int c) {
        int index = r * N + c;
        return list.get(index);
    }

    private JButton createGridButton(final int row, final int col) {
        final JButton b = new JButton("r" + row + ",c" + col);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton gb = GridButtonPanel.this.getGridButton(row, col);
                System.out.println("r" + row + ",c" + col
                    + " " + (b == gb)
                    + " " + (b.equals(gb)));
                
                if(mine.isThisNeighbor(new coordinate(row,col))){
                    //NEW STEP
                    //b.setFont(new Font("Arial", Font.PLAIN, 40));
                    gui.recolorTableAndAddStep(row,col);
                } else {
                    //WRONG
                    System.err.println("WRONG BUTTON");
                    //JOptionPane.showMessageDialog(null, "Wronq place for a queen!");    //error msg
                }
            }
        });
        return b;
    }

    private JPanel createGridPanel() {
        p = new JPanel(new GridLayout(N, N));
        for (int i = 0; i < N * N; i++) {
            int row = i / N;
            int col = i % N;
            JButton gb = createGridButton(row, col);
            list.add(gb);
            p.add(gb);
        }
        return p;
    }

    public void display() {
        f = new JFrame("MINE");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.add(createNavPanel(), BorderLayout.NORTH);
        f.add(createGridPanel(), BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setMinimumSize(new Dimension(N*100,N*100));
    }

    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GridButtonPanel().display();
            }
        });
    }*/

    private JPanel createNavPanel() {
        n = new JPanel(new BorderLayout());
        JButton rBtn = gui.reset();
        JButton pBtn = gui.pouse();
        //JButton bBtn = gui.back();
        //JLabel tLabel = gui.timerLabel();
        
        n.add(rBtn, BorderLayout.EAST);
        n.add(pBtn, BorderLayout.WEST);
        //p.add(bBtn, BorderLayout.WEST);
        //p.add(tLabel, BorderLayout.CENTER);
        
        return n;
    }

    /**
     * Set visible grid panel
     */
    void showGameTable() {
        p.setVisible(true);
    }

    /**
     * Hide grid panel.
     */
    void hideGameTable() {
        p.setVisible(false);
    }
}