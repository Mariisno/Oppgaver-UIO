import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GOLView {
    Timer timer;

    private int rad;
    private int kol;

    private JFrame vindu;
    private JPanel toppPanel;
    private JPanel rutenettPanel;

    //Knapper start/avslutt
    private JButton knappStart;
    private JButton knappAvslutt;

    private JLabel antLevende;
    private JLabel GenNr;

    //Lag verden

    public GOLView(GOLkontroller kontroller){
        rad = kontroller.hentRad();
        kol = kontroller.hentKol();

        kontroller.lagVerden();

        vindu = new JFrame("Game of life");
        vindu.setSize(600, 400);
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        toppPanel = new JPanel();
        vindu.add(toppPanel, BorderLayout.NORTH);

        antLevende = new JLabel("Antall levende: " + 0);
        toppPanel.add(antLevende);
        
        class Start implements ActionListener{

            Start() {
                timer = new Timer(2000, this); //Starter og stopper programmet
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                start();


                    kontroller.model.verden.tegn();
                    kontroller.model.verden.oppdatering();
                    
                    antLevende.setText("Antall levende: " + kontroller.model.verden.rutenett.antallLevende());

                    GenNr.setText("Generasjon nr. " + kontroller.model.verden.hentGenNr());

                    for (int i=0; i<rad; i++) {
                        for (int j=0; j<kol; j++) {
                            if (kontroller.model.verden.rutenett.hentCelle(i, j) == null){
                                continue;
                            }
                            Celle celle = kontroller.model.verden.rutenett.hentCelle(i, j);
                            celle.addActionListener(new settLevende(celle));

                            //Er levende
                            if (celle.erLevende()) {
                                celle.setBackground(Color.CYAN);
                            }
                            //Er død
                            else {
                                celle.setBackground(Color.MAGENTA);
                            }
                            rutenettPanel.add(celle);
                        }   
                    }

                    if(kontroller.model.verden.rutenett.antallLevende() == 0) {
                        timer.stop();;
                    }
            }
        }

        knappStart = new JButton("Start");
        knappStart.addActionListener(new Start());
        toppPanel.add(knappStart);

        class Avslutt implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }   
        }

        knappAvslutt = new JButton("Avslutt");  
        knappAvslutt.addActionListener(new Avslutt());
        toppPanel.add(knappAvslutt);

        GenNr = new JLabel("Generasjon nr. " + 0);
        toppPanel.add(GenNr);

        rutenettPanel = new JPanel();
        rutenettPanel.setSize(600, 600);
        rutenettPanel.setLayout(new GridLayout(rad, kol)); //rad, kol

        vindu.add(rutenettPanel, BorderLayout.CENTER);

        //rutenett med knapper/celler
        for (int i=0; i<rad; i++) {
            for (int j=0; j<kol; j++) {
                if (kontroller.model.verden.rutenett.hentCelle(i, j) == null){
                    continue;
                }
                Celle celle = kontroller.model.verden.rutenett.hentCelle(i, j);
                celle.addActionListener(new settLevende(celle));

                //Er levende
                if (celle.erLevende()) {
                    celle.setBackground(Color.CYAN);
                }
                //Er død
                else {
                    celle.setBackground(Color.magenta);
                }
                rutenettPanel.add(celle);
            }
        }

        vindu.setLocationRelativeTo(null); //midtstille
        vindu.setVisible(true);
    }
    
    class settLevende implements ActionListener{
        Celle celle;
        settLevende(Celle celle) {
            this.celle = celle;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            celle.settLevende();
            erLevende(celle);
        }
    }

    public void erLevende(Celle celle){
        //Er levende
        if (celle.erLevende()) {
            celle.setBackground(Color.CYAN);
        }
        //Er død
        else {
            celle.setBackground(Color.RED);
        }
    }

    public void start() {
        timer.start();
    }
    
}
