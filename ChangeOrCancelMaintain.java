package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import domain.*;
public class ChangeOrCancelMaintain extends JFrame{
    private JButton jbtBack = new JButton(new ImageIcon(getClass().getResource("/images/back.fw.png")));
    private JButton jbtClose = new JButton(new ImageIcon(getClass().getResource("/images/delete.fw.png")));
    private JButton jbtHelp = new JButton(new ImageIcon(getClass().getResource("/images/helpbutton.fw.png")));
    private JButton jbtC = new JButton(new ImageIcon(getClass().getResource("/images/addcocicon.fw.png")));
    private JButton jbtR = new JButton(new ImageIcon(getClass().getResource("/images/retrievecocicon.fw.png")));
    ImageIcon a = new ImageIcon(getClass().getResource("/images/bus_background1.fw.png"));
    Staff staff = new Staff();
    public ChangeOrCancelMaintain(Staff staff){
        setContentPane(new JLabel(a));
        setLayout(new FlowLayout());
        this.staff = staff;
        JPanel topright = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topright.setOpaque(false);
        topright.add(jbtHelp);
        topright.add(jbtClose);
        jbtClose.setBorder(null);
        jbtClose.setContentAreaFilled(false);
        jbtHelp.setBorder(null);
        jbtHelp.setContentAreaFilled(false);
        
        JPanel topleft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topleft.setOpaque(false);
        topleft.add(jbtBack);
        jbtBack.setBorder(null);
        jbtBack.setContentAreaFilled(false);
        
        JPanel jpnorth = new JPanel(new GridLayout(1,2));
        jpnorth.setOpaque(false);
        jpnorth.add(topleft);
        jpnorth.add(topright);
        
        JPanel jpcenter = new JPanel(new GridLayout(1,2));
        jpcenter.setOpaque(false);
        jpcenter.add(jbtC);
        jpcenter.add(jbtR);
        
        jbtC.setBorder(null);
        jbtR.setBorder(null);
        jbtC.setContentAreaFilled(false);
        jbtR.setContentAreaFilled(false);
        
        jbtC.addActionListener(new ButtonListenerClass());
        jbtR.addActionListener(new ButtonListenerClass());
        jbtClose.addActionListener(new ButtonListenerClass());
        jbtHelp.addActionListener(new ButtonListenerClass());
        jbtBack.addActionListener(new ButtonListenerClass());
        
        setLayout(new BorderLayout());
        add(jpnorth,BorderLayout.NORTH);
        add(jpcenter,BorderLayout.CENTER);
        
        setTitle("LightSpeed");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class ButtonListenerClass implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtC){
                setAlwaysOnTop(false);
                new ChangeOrCancelAdd(staff);
            }
            else if(e.getSource()==jbtR){
                setAlwaysOnTop(false);
                new ChangeOrCancelRetrieve();
            }
            else if(e.getSource()==jbtClose){
                setAlwaysOnTop(false);
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you wan to exit?","Exit",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
            else if(e.getSource()==jbtHelp){
                new HelpButton("ChangeOrCancelMaintain");
            }
            else if(e.getSource()==jbtBack){
                        setVisible(false);
            }
        }
     }
    
    public static void main(String[] args) {
        //new PurchaseMaintain();
    }
    
}
