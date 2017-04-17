
package juuri.ui;

import juuri.sovelluslogiikka.peli.Peli;
import javax.swing.*;
import juuri.sovelluslogiikka.tapahtumat.Tapahtuma;

public class KayttoliittymaXX extends JFrame {

    private Peli peli = new Peli();

    public KayttoliittymaXX() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        AmmatinValintaGroup = new javax.swing.ButtonGroup();
        KoillinenPaneeli = new javax.swing.JPanel();
        KoillinenAlkuPaneeli = new javax.swing.JPanel();
        KarttaPaneeli = new Piirtoalusta(peli);
        LuodePaneeli = new javax.swing.JPanel();
        HahmonluontiInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ReppuPaneeli = new javax.swing.JPanel();
        LounasPaneeli = new javax.swing.JPanel();
        HahmonluontiSyote = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        HahmonNimiTextField = new javax.swing.JTextField();
        HahmonluontiButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        AmmatinValintaSoturiButton = new javax.swing.JRadioButton();
        AmmatinValintaVelhoButton = new javax.swing.JRadioButton();
        AmmatinValintaDruidiButton = new javax.swing.JRadioButton();
        LiikkkumisPaneeli = new javax.swing.JPanel();
        HahmoLiikkuuYlosButton = new javax.swing.JButton();
        HahmoLiikkuuAlasButton = new javax.swing.JButton();
        HahmoLiikkuuOikealleButton = new javax.swing.JButton();
        HahmoLiikkuuVasemmalleButton = new javax.swing.JButton();
        KaakkoPaneeli = new javax.swing.JPanel();
        TyhjaPaneeliPaalla = new javax.swing.JPanel();
        InfoPaneeli = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TapahtumaText = new javax.swing.JTextArea();
        tapahtumaVaihtoehtoYksiButton = new javax.swing.JButton();
        tapahtumaVaihtoehtoKaksiButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PelinAloitus");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(661, 500));
        setResizable(false);

        KoillinenPaneeli.setBackground(new java.awt.Color(255, 51, 51));
        KoillinenPaneeli.setMaximumSize(new java.awt.Dimension(298, 215));
        KoillinenPaneeli.setMinimumSize(new java.awt.Dimension(298, 215));
        KoillinenPaneeli.setPreferredSize(new java.awt.Dimension(298, 215));
        KoillinenPaneeli.setLayout(new java.awt.CardLayout());

        KoillinenAlkuPaneeli.setMaximumSize(new java.awt.Dimension(298, 215));
        KoillinenAlkuPaneeli.setMinimumSize(new java.awt.Dimension(298, 215));

        javax.swing.GroupLayout KoillinenAlkuPaneeliLayout = new javax.swing.GroupLayout(KoillinenAlkuPaneeli);
        KoillinenAlkuPaneeli.setLayout(KoillinenAlkuPaneeliLayout);
        KoillinenAlkuPaneeliLayout.setHorizontalGroup(
            KoillinenAlkuPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        KoillinenAlkuPaneeliLayout.setVerticalGroup(
            KoillinenAlkuPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );

        KoillinenPaneeli.add(KoillinenAlkuPaneeli, "card2");

        KarttaPaneeli.setBackground(new java.awt.Color(255, 255, 153));
        KarttaPaneeli.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout KarttaPaneeliLayout = new javax.swing.GroupLayout(KarttaPaneeli);
        KarttaPaneeli.setLayout(KarttaPaneeliLayout);
        KarttaPaneeliLayout.setHorizontalGroup(
                KarttaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 298, Short.MAX_VALUE)
        );
        KarttaPaneeliLayout.setVerticalGroup(
                KarttaPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 215, Short.MAX_VALUE)
        );

        LuodePaneeli.setBackground(new java.awt.Color(255, 255, 51));
        LuodePaneeli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LuodePaneeli.setMaximumSize(new java.awt.Dimension(363, 215));
        LuodePaneeli.setMinimumSize(new java.awt.Dimension(363, 215));
        LuodePaneeli.setPreferredSize(new java.awt.Dimension(363, 215));
        LuodePaneeli.setLayout(new java.awt.CardLayout());

        HahmonluontiInfo.setMaximumSize(new java.awt.Dimension(361, 215));
        HahmonluontiInfo.setMinimumSize(new java.awt.Dimension(361, 215));
        HahmonluontiInfo.setPreferredSize(new java.awt.Dimension(361, 215));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Luola");

        jLabel2.setText("Tervetuloa pelaamaan peliä.");

        javax.swing.GroupLayout HahmonluontiInfoLayout = new javax.swing.GroupLayout(HahmonluontiInfo);
        HahmonluontiInfo.setLayout(HahmonluontiInfoLayout);
        HahmonluontiInfoLayout.setHorizontalGroup(
            HahmonluontiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HahmonluontiInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HahmonluontiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        HahmonluontiInfoLayout.setVerticalGroup(
            HahmonluontiInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HahmonluontiInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        LuodePaneeli.add(HahmonluontiInfo, "card2");

        ReppuPaneeli.setBackground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout ReppuPaneeliLayout = new javax.swing.GroupLayout(ReppuPaneeli);
        ReppuPaneeli.setLayout(ReppuPaneeliLayout);
        ReppuPaneeliLayout.setHorizontalGroup(
            ReppuPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );
        ReppuPaneeliLayout.setVerticalGroup(
            ReppuPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        LuodePaneeli.add(ReppuPaneeli, "card3");

        LounasPaneeli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LounasPaneeli.setMaximumSize(new java.awt.Dimension(363, 255));
        LounasPaneeli.setMinimumSize(new java.awt.Dimension(363, 255));
        LounasPaneeli.setPreferredSize(new java.awt.Dimension(363, 255));
        LounasPaneeli.setLayout(new java.awt.CardLayout());

        HahmonluontiSyote.setMaximumSize(new java.awt.Dimension(363, 255));
        HahmonluontiSyote.setMinimumSize(new java.awt.Dimension(363, 255));
        HahmonluontiSyote.setPreferredSize(new java.awt.Dimension(363, 255));

        jLabel3.setText("Anna hahmollesi nimi:");

        HahmonluontiButton.setText("Aloita seikkailu!");
        HahmonluontiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HahmonluontiButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Valitse ammatti:");

        AmmatinValintaGroup.add(AmmatinValintaSoturiButton);
        AmmatinValintaSoturiButton.setText("Soturi");

        AmmatinValintaGroup.add(AmmatinValintaVelhoButton);
        AmmatinValintaVelhoButton.setText("Velho");

        AmmatinValintaGroup.add(AmmatinValintaDruidiButton);
        AmmatinValintaDruidiButton.setText("Druidi");

        javax.swing.GroupLayout HahmonluontiSyoteLayout = new javax.swing.GroupLayout(HahmonluontiSyote);
        HahmonluontiSyote.setLayout(HahmonluontiSyoteLayout);
        HahmonluontiSyoteLayout.setHorizontalGroup(
            HahmonluontiSyoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HahmonluontiSyoteLayout.createSequentialGroup()
                .addGroup(HahmonluontiSyoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HahmonluontiSyoteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(HahmonNimiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HahmonluontiSyoteLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(HahmonluontiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HahmonluontiSyoteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HahmonluontiSyoteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(HahmonluontiSyoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HahmonluontiSyoteLayout.createSequentialGroup()
                                .addComponent(AmmatinValintaSoturiButton)
                                .addGap(18, 18, 18)
                                .addComponent(AmmatinValintaVelhoButton)
                                .addGap(18, 18, 18)
                                .addComponent(AmmatinValintaDruidiButton))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        HahmonluontiSyoteLayout.setVerticalGroup(
            HahmonluontiSyoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HahmonluontiSyoteLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HahmonNimiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HahmonluontiSyoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmmatinValintaSoturiButton)
                    .addComponent(AmmatinValintaVelhoButton)
                    .addComponent(AmmatinValintaDruidiButton))
                .addGap(13, 13, 13)
                .addComponent(HahmonluontiButton)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        LounasPaneeli.add(HahmonluontiSyote, "card2");

        LiikkkumisPaneeli.setBackground(new java.awt.Color(0, 51, 204));
        LiikkkumisPaneeli.setMaximumSize(new java.awt.Dimension(363, 255));
        LiikkkumisPaneeli.setMinimumSize(new java.awt.Dimension(363, 255));
        LiikkkumisPaneeli.setPreferredSize(new java.awt.Dimension(363, 255));

        HahmoLiikkuuYlosButton.setText("Ylös");
        HahmoLiikkuuYlosButton.setMaximumSize(new java.awt.Dimension(87, 23));
        HahmoLiikkuuYlosButton.setMinimumSize(new java.awt.Dimension(87, 23));
        HahmoLiikkuuYlosButton.setPreferredSize(new java.awt.Dimension(87, 23));
        HahmoLiikkuuYlosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HahmoLiikkuuYlosButtonActionPerformed(evt);
            }
        });

        HahmoLiikkuuAlasButton.setText("Alas");
        HahmoLiikkuuAlasButton.setMaximumSize(new java.awt.Dimension(87, 23));
        HahmoLiikkuuAlasButton.setMinimumSize(new java.awt.Dimension(87, 23));
        HahmoLiikkuuAlasButton.setPreferredSize(new java.awt.Dimension(87, 23));
        HahmoLiikkuuAlasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HahmoLiikkuuAlasButtonActionPerformed(evt);
            }
        });

        HahmoLiikkuuOikealleButton.setText("Oikealle");
        HahmoLiikkuuOikealleButton.setMaximumSize(new java.awt.Dimension(87, 23));
        HahmoLiikkuuOikealleButton.setMinimumSize(new java.awt.Dimension(87, 23));
        HahmoLiikkuuOikealleButton.setPreferredSize(new java.awt.Dimension(87, 23));
        HahmoLiikkuuOikealleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HahmoLiikkuuOikealleButtonActionPerformed(evt);
            }
        });

        HahmoLiikkuuVasemmalleButton.setText("Vasemmalle");
        HahmoLiikkuuVasemmalleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HahmoLiikkuuVasemmalleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LiikkkumisPaneeliLayout = new javax.swing.GroupLayout(LiikkkumisPaneeli);
        LiikkkumisPaneeli.setLayout(LiikkkumisPaneeliLayout);
        LiikkkumisPaneeliLayout.setHorizontalGroup(
            LiikkkumisPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LiikkkumisPaneeliLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(HahmoLiikkuuVasemmalleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(HahmoLiikkuuOikealleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(LiikkkumisPaneeliLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(LiikkkumisPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(HahmoLiikkuuAlasButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HahmoLiikkuuYlosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LiikkkumisPaneeliLayout.setVerticalGroup(
            LiikkkumisPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LiikkkumisPaneeliLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(HahmoLiikkuuYlosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LiikkkumisPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HahmoLiikkuuVasemmalleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HahmoLiikkuuOikealleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HahmoLiikkuuAlasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        LounasPaneeli.add(LiikkkumisPaneeli, "card3");

        KaakkoPaneeli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        KaakkoPaneeli.setMaximumSize(new java.awt.Dimension(298, 255));
        KaakkoPaneeli.setMinimumSize(new java.awt.Dimension(298, 255));
        KaakkoPaneeli.setPreferredSize(new java.awt.Dimension(298, 255));
        KaakkoPaneeli.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout TyhjaPaneeliPaallaLayout = new javax.swing.GroupLayout(TyhjaPaneeliPaalla);
        TyhjaPaneeliPaalla.setLayout(TyhjaPaneeliPaallaLayout);
        TyhjaPaneeliPaallaLayout.setHorizontalGroup(
            TyhjaPaneeliPaallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        TyhjaPaneeliPaallaLayout.setVerticalGroup(
            TyhjaPaneeliPaallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        KaakkoPaneeli.add(TyhjaPaneeliPaalla, "card1");

        InfoPaneeli.setMaximumSize(new java.awt.Dimension(298, 255));
        InfoPaneeli.setMinimumSize(new java.awt.Dimension(298, 255));
        InfoPaneeli.setPreferredSize(new java.awt.Dimension(298, 255));

        TapahtumaText.setColumns(20);
        TapahtumaText.setRows(5);
        jScrollPane1.setViewportView(TapahtumaText);

        tapahtumaVaihtoehtoYksiButton.setText("Vaihtoeht1");
        tapahtumaVaihtoehtoYksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tapahtumaVaihtoehtoYksiButtonActionPerformed(evt);
            }
        });

        tapahtumaVaihtoehtoKaksiButton.setText("Vaihtoeht2");
        tapahtumaVaihtoehtoKaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tapahtumaVaihtoehtoKaksiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InfoPaneeliLayout = new javax.swing.GroupLayout(InfoPaneeli);
        InfoPaneeli.setLayout(InfoPaneeliLayout);
        InfoPaneeliLayout.setHorizontalGroup(
            InfoPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPaneeliLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(InfoPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(InfoPaneeliLayout.createSequentialGroup()
                        .addComponent(tapahtumaVaihtoehtoYksiButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tapahtumaVaihtoehtoKaksiButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        InfoPaneeliLayout.setVerticalGroup(
            InfoPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPaneeliLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(InfoPaneeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tapahtumaVaihtoehtoYksiButton)
                    .addComponent(tapahtumaVaihtoehtoKaksiButton))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        KaakkoPaneeli.add(InfoPaneeli, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LuodePaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LounasPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(KaakkoPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KoillinenPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LuodePaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KoillinenPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LounasPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KaakkoPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>                        

    private void HahmonluontiButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        String hahmonNimi = HahmonNimiTextField.getText();

        //luodaan hahmo ja luolasto
        peli.aloitaPeli(hahmonNimi);

        LounasPaneeli.removeAll();
        LounasPaneeli.repaint();
        LounasPaneeli.revalidate();
        LounasPaneeli.add(LiikkkumisPaneeli);
        LounasPaneeli.repaint();
        LounasPaneeli.revalidate();

        LuodePaneeli.removeAll();
        LuodePaneeli.repaint();
        LuodePaneeli.revalidate();
        LuodePaneeli.add(ReppuPaneeli);
        LuodePaneeli.repaint();
        LuodePaneeli.revalidate();

        KoillinenPaneeli.removeAll();
        KoillinenPaneeli.repaint();
        KoillinenPaneeli.revalidate();
        KoillinenPaneeli.add(KarttaPaneeli);
        KoillinenPaneeli.repaint();
        KoillinenPaneeli.revalidate();
    }                                                  

    private void HahmoLiikkuuOikealleButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                           
        Tapahtuma liikkumisestaAiheutunutTapahtuma = peli.liikutaanJaEtsitaanTapahtumaa("oikea");
        if (!(liikkumisestaAiheutunutTapahtuma == null)) {
            liikkumisestaAiheutunutTapahtuma.valmisteleTapahtuma(peli.getPelaajanHahmo());

            tapahtumaVaihtoehtoYksiButton.setText(liikkumisestaAiheutunutTapahtuma.getVaihtoehtoYksi());
            tapahtumaVaihtoehtoKaksiButton.setText(liikkumisestaAiheutunutTapahtuma.getVaihtoehtoKaksi());
            TapahtumaText.setText(liikkumisestaAiheutunutTapahtuma.getTapahtumateksti());

            KaakkoPaneeli.removeAll();
            KaakkoPaneeli.repaint();
            KaakkoPaneeli.revalidate();
            KaakkoPaneeli.add(InfoPaneeli);
            KaakkoPaneeli.repaint();
            KaakkoPaneeli.revalidate();
        }
        
        KarttaPaneeli.repaint();

        //tähän tulee component.repaint piirtoalustalle

    }                                                          

    private void HahmoLiikkuuYlosButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        Tapahtuma liikkumisestaAiheutunutTapahtuma = peli.liikutaanJaEtsitaanTapahtumaa("ylös");
        if (!(liikkumisestaAiheutunutTapahtuma == null)) {
            liikkumisestaAiheutunutTapahtuma.valmisteleTapahtuma(peli.getPelaajanHahmo());

            tapahtumaVaihtoehtoYksiButton.setText(liikkumisestaAiheutunutTapahtuma.getVaihtoehtoYksi());
            tapahtumaVaihtoehtoKaksiButton.setText(liikkumisestaAiheutunutTapahtuma.getVaihtoehtoKaksi());
            TapahtumaText.setText(liikkumisestaAiheutunutTapahtuma.getTapahtumateksti());

            KaakkoPaneeli.removeAll();
            KaakkoPaneeli.repaint();
            KaakkoPaneeli.revalidate();
            KaakkoPaneeli.add(InfoPaneeli);
            KaakkoPaneeli.repaint();
            KaakkoPaneeli.revalidate();
        }
        
        KarttaPaneeli.repaint();
        //tähän tulee component.repaint piirtoalustalle

    }                                                      

    private void HahmoLiikkuuAlasButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        Tapahtuma liikkumisestaAiheutunutTapahtuma = peli.liikutaanJaEtsitaanTapahtumaa("alas");
        if (!(liikkumisestaAiheutunutTapahtuma == null)) {
            liikkumisestaAiheutunutTapahtuma.valmisteleTapahtuma(peli.getPelaajanHahmo());

            tapahtumaVaihtoehtoYksiButton.setText(liikkumisestaAiheutunutTapahtuma.getVaihtoehtoYksi());
            tapahtumaVaihtoehtoKaksiButton.setText(liikkumisestaAiheutunutTapahtuma.getVaihtoehtoKaksi());
            TapahtumaText.setText(liikkumisestaAiheutunutTapahtuma.getTapahtumateksti());

            KaakkoPaneeli.removeAll();
            KaakkoPaneeli.repaint();
            KaakkoPaneeli.revalidate();
            KaakkoPaneeli.add(InfoPaneeli);
            KaakkoPaneeli.repaint();
            KaakkoPaneeli.revalidate();
        }
        
        KarttaPaneeli.repaint();
        //tähän tulee component.repaint piirtoalustalle

    }                                                      

    private void HahmoLiikkuuVasemmalleButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                             
        Tapahtuma liikkumisestaAiheutunutTapahtuma = peli.liikutaanJaEtsitaanTapahtumaa("vasen");
        if (!(liikkumisestaAiheutunutTapahtuma == null)) {
            liikkumisestaAiheutunutTapahtuma.valmisteleTapahtuma(peli.getPelaajanHahmo());

            tapahtumaVaihtoehtoYksiButton.setText(liikkumisestaAiheutunutTapahtuma.getVaihtoehtoYksi());
            tapahtumaVaihtoehtoKaksiButton.setText(liikkumisestaAiheutunutTapahtuma.getVaihtoehtoKaksi());
            TapahtumaText.setText(liikkumisestaAiheutunutTapahtuma.getTapahtumateksti());

            KaakkoPaneeli.removeAll();
            KaakkoPaneeli.repaint();
            KaakkoPaneeli.revalidate();
            KaakkoPaneeli.add(InfoPaneeli);
            KaakkoPaneeli.repaint();
            KaakkoPaneeli.revalidate();
        }
        
        KarttaPaneeli.repaint();
        //tähän tulee component.repaint piirtoalustalle

    }                                                            

    private void tapahtumaVaihtoehtoYksiButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                              
        Tapahtuma tt = peli.getNykyinenTapahtuma();
        if (tt.getKoodi() == Tapahtuma.TAISTELU) {

        } else {
            tt.toteutaVaihtoehtoYksi(peli.getPelaajanHahmo(), peli.getLuolasto());

            KaakkoPaneeli.removeAll();
            KaakkoPaneeli.repaint();
            KaakkoPaneeli.revalidate();
            KaakkoPaneeli.add(TyhjaPaneeliPaalla);
            KaakkoPaneeli.repaint();
            KaakkoPaneeli.revalidate();
        }
    }                                                             

    private void tapahtumaVaihtoehtoKaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                               
        Tapahtuma tt = peli.getNykyinenTapahtuma();
        if (tt.getKoodi() == Tapahtuma.TAISTELU) {
            
        } else {
            tt.toteutaVaihtoehtoKaksi(peli.getPelaajanHahmo(), peli.getLuolasto());

            KaakkoPaneeli.removeAll();
            KaakkoPaneeli.repaint();
            KaakkoPaneeli.revalidate();
            KaakkoPaneeli.add(TyhjaPaneeliPaalla);
            KaakkoPaneeli.repaint();
            KaakkoPaneeli.revalidate();
        }

    }                                                              

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Kayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KayttoliittymaXX().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JRadioButton AmmatinValintaDruidiButton;
    private javax.swing.ButtonGroup AmmatinValintaGroup;
    private javax.swing.JRadioButton AmmatinValintaSoturiButton;
    private javax.swing.JRadioButton AmmatinValintaVelhoButton;
    private javax.swing.JButton HahmoLiikkuuAlasButton;
    private javax.swing.JButton HahmoLiikkuuOikealleButton;
    private javax.swing.JButton HahmoLiikkuuVasemmalleButton;
    private javax.swing.JButton HahmoLiikkuuYlosButton;
    private javax.swing.JTextField HahmonNimiTextField;
    private javax.swing.JButton HahmonluontiButton;
    private javax.swing.JPanel HahmonluontiInfo;
    private javax.swing.JPanel HahmonluontiSyote;
    private javax.swing.JPanel InfoPaneeli;
    private javax.swing.JPanel KaakkoPaneeli;
    private javax.swing.JPanel KarttaPaneeli;
    private javax.swing.JPanel KoillinenAlkuPaneeli;
    private javax.swing.JPanel KoillinenPaneeli;
    private javax.swing.JPanel LiikkkumisPaneeli;
    private javax.swing.JPanel LounasPaneeli;
    private javax.swing.JPanel LuodePaneeli;
    private javax.swing.JPanel ReppuPaneeli;
    private javax.swing.JTextArea TapahtumaText;
    private javax.swing.JPanel TyhjaPaneeliPaalla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tapahtumaVaihtoehtoKaksiButton;
    private javax.swing.JButton tapahtumaVaihtoehtoYksiButton;
    // End of variables declaration                   
}