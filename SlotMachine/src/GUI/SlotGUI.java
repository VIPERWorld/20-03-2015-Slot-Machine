/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Starter.SlotMachine;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import javax.swing.Timer;

/**
 *
 * @author Loek
 */
@SuppressWarnings("serial")
public class SlotGUI extends javax.swing.JFrame {

    private final SlotMachine slotMachine;
    private Timer stopwatch;

    /**
     * Creates new form SlotGUI
     *
     * @param sm
     */
    public SlotGUI(SlotMachine sm) {
        this.slotMachine = sm;
        initComponents();
        this.slot1.setIcon(sm.getSlotManager().getSlot1().getIcon());
        this.slot2.setIcon(sm.getSlotManager().getSlot2().getIcon());
        this.slot3.setIcon(sm.getSlotManager().getSlot3().getIcon());

        stopwatch = new Timer(3000, new MyTimerListener(playButton));
        stopwatch.setRepeats(false);
        this.playButton.addActionListener((ActionEvent e) -> {
            playButton.setEnabled(false);
            stopwatch.start();
        });
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public void click(AbstractButton button) {
        button.doClick();
    }

    public JToggleButton getSlot1Hold() {
        return slot1Hold;
    }

    public JToggleButton getSlot2Hold() {
        return slot2Hold;
    }

    public JToggleButton getSlot3Hold() {
        return slot3Hold;
    }

    
    static class MyTimerListener implements ActionListener {

        JComponent target;

        MyTimerListener(JComponent target) {
            this.target = target;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            target.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "deprecation"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slot1Hold = new javax.swing.JToggleButton();
        slot2Hold = new javax.swing.JToggleButton();
        slot3Hold = new javax.swing.JToggleButton();
        playButton = new javax.swing.JButton();
        slot3 = new javax.swing.JLabel();
        slot1 = new javax.swing.JLabel();
        slot2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Slot Machines");
        setBackground(new java.awt.Color(255, 102, 102));
        setForeground(java.awt.Color.black);
        setResizable(false);

        slot1Hold.setLabel("Hold");
        slot1Hold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot1HoldActionPerformed(evt);
            }
        });

        slot2Hold.setLabel("Hold");
        slot2Hold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot2HoldActionPerformed(evt);
            }
        });

        slot3Hold.setActionCommand("Hold");
        slot3Hold.setLabel("Hold");
        slot3Hold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slot3HoldActionPerformed(evt);
            }
        });

        playButton.setLabel("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        slot3.setText("jLabel2");

        slot1.setText("slot1");

        slot2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(slot1Hold, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(slot2Hold, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(slot3Hold, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(slot1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(slot2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(slot3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slot3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slot1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slot2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slot3Hold)
                    .addComponent(slot2Hold)
                    .addComponent(slot1Hold))
                .addGap(55, 55, 55)
                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        slot1Hold.getAccessibleContext().setAccessibleName("slot1Hold");
        slot2Hold.getAccessibleContext().setAccessibleName("slot2Hold");
        slot3Hold.getAccessibleContext().setAccessibleName("slot3Hold");
        playButton.getAccessibleContext().setAccessibleName("playButton");
        playButton.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed

        this.slotMachine.getSlotManager().spin();
        this.slot1.setIcon(slotMachine.getSlotManager().getSlot1().getIcon());
        this.slot2.setIcon(slotMachine.getSlotManager().getSlot2().getIcon());
        this.slot3.setIcon(slotMachine.getSlotManager().getSlot3().getIcon());


    }//GEN-LAST:event_playButtonActionPerformed

    private void slot1HoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot1HoldActionPerformed
        if (slotMachine.getSlotManager().getSlot1().isHold()) {
            slotMachine.getSlotManager().getSlot1().setHold(false);
            return;
        }
        slotMachine.getSlotManager().getSlot1().setHold(true);
    }//GEN-LAST:event_slot1HoldActionPerformed

    private void slot2HoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot2HoldActionPerformed
        if (slotMachine.getSlotManager().getSlot2().isHold()) {
            slotMachine.getSlotManager().getSlot2().setHold(false);
            return;
        }
        slotMachine.getSlotManager().getSlot2().setHold(true);
    }//GEN-LAST:event_slot2HoldActionPerformed

    private void slot3HoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slot3HoldActionPerformed
        if (slotMachine.getSlotManager().getSlot3().isHold()) {
            slotMachine.getSlotManager().getSlot3().setHold(false);
            return;
        }
        slotMachine.getSlotManager().getSlot3().setHold(true);
    }//GEN-LAST:event_slot3HoldActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton playButton;
    private javax.swing.JLabel slot1;
    private javax.swing.JToggleButton slot1Hold;
    private javax.swing.JLabel slot2;
    private javax.swing.JToggleButton slot2Hold;
    private javax.swing.JLabel slot3;
    private javax.swing.JToggleButton slot3Hold;
    // End of variables declaration//GEN-END:variables

}
