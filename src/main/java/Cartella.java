import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Cartella extends JFrame implements ActionListener{
    Random rand = new Random();
    JLabel textLabel;
    JPanel body;
    JButton[][] numbers;
    Cartella(){
        this.setTitle("Cartella");
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(900,400));
        textLabel=new JLabel("Cartella",SwingConstants.CENTER);
        textLabel.setBackground(Color.BLACK);
        textLabel.setForeground(new Color(0x123456));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setFont(new Font("JetBrains mono", Font.PLAIN, 62));
        textLabel.setOpaque(true);

        body=new JPanel();
        numbers=new JButton[3][9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                numbers[i][j] = new JButton();
                numbers[i][j].setFont(new Font("JetBrains mono", Font.BOLD, 24));
                numbers[i][j].setSize(30, 30);
                numbers[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 2));
                numbers[i][j].setOpaque(true);
                numbers[i][j].setFocusable(false);
                numbers[i][j].addActionListener(this);
                body.add(numbers[i][j]);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                int n;
                do{
                    n = rand.nextInt(0, 10);
                    n = n == 0 && i == 0 ? n + 1 : n;
                    n = n + (i * 10);
                }while(String.valueOf(n).equals(numbers[0][i].getText())||
                        String.valueOf(n).equals(numbers[1][i].getText())||
                        String.valueOf(n).equals(numbers[2][i].getText()));

                numbers[j][i].setText(String.valueOf(n));
            }
        }

        for(int j=0;j<3;j++) {
            for (int i = 0; i < 4; i++) {
                int r;
                do {
                    r = rand.nextInt(0, 9);
                } while (numbers[j][r].getText() == "");

                numbers[j][r].setText("");
                numbers[j][r].setEnabled(false);
            }
        }
        body.setLayout(new GridLayout(3,9));
        this.add(textLabel,BorderLayout.NORTH);
        this.add(body,BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if(e.getSource()==numbers[i][j]){
                    if(numbers[i][j].getBackground()!=(Color.green)){
                        numbers[i][j].setBackground(Color.green);
                    }else{
                        numbers[i][j].setBackground(null);
                    }
                }
            }
        }
    }
}
