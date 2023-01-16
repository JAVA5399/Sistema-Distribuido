package servidor;

import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author alex
 */
//esta clase es el controlador del servidor
public class ContentForm extends javax.swing.JPanel implements Runnable {
    
    private final Form form;
    private final Server vista;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private Timer TIMER;
    
    public ContentForm(Server vista, DataInputStream dis, DataOutputStream dos) {
        initComponents();
        form = new Form();
        setSize(300, 350);
        this.vista = vista;
        this.dis = dis;
        this.dos = dos;
        initTimer();
        initClientThread();
        content.add(form);
    }
    
    private void initTimer() {
        TIMER = new Timer(10, (ActionEvent e) -> {
            sync();
        });
        TIMER.start();
    }
    
    public void setVelocity(int velocity) {
        TIMER.setDelay(velocity);
    }
    
    private void initClientThread() {
        Thread t = new Thread(this);
        t.start();
    }
    
    public void exitAll() {
        try {
            //envia un 0.02 al cliente para que cierre su programa
            //para que envie un 0 y termine el hilo de esta clase
            dos.writeDouble(0.02);
        } catch (IOException ex) {
            Logger.getLogger(ContentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void exit() {
        try {
            //envia un 0.01 al cliente para que cierre su programa
            dos.writeDouble(0.01);
        } catch (IOException ex) {
            Logger.getLogger(ContentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sync() {
        form.repaint();
        form.nextPosition();
        //form.setPosition(form.getPosition());
        try {
            //envia la posision del triangulo al cliente
            dos.writeDouble(form.getPosition());
        } catch (IOException ex) {
            Logger.getLogger(ContentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setState() {
        if (TIMER.isRunning()) {
            TIMER.stop();
        } else {
            TIMER.start();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        btnRote = new javax.swing.JButton();
        sliiderVelocity = new javax.swing.JSlider();
        btnClose = new javax.swing.JButton();
        btnState = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        btnVisi = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(300, 350));
        setPreferredSize(new java.awt.Dimension(310, 435));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        jPanel2.setToolTipText("");
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(320, 435));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Cliente");
        lbTitle.setPreferredSize(new java.awt.Dimension(37, 18));

        btnRote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotar_Izq.png"))); // NOI18N
        btnRote.setText("Rote");
        btnRote.setContentAreaFilled(false);
        btnRote.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoteActionPerformed(evt);
            }
        });

        sliiderVelocity.setMajorTickSpacing(20);
        sliiderVelocity.setMaximum(150);
        sliiderVelocity.setMinimum(10);
        sliiderVelocity.setPaintLabels(true);
        sliiderVelocity.setPaintTicks(true);
        sliiderVelocity.setValue(10);
        sliiderVelocity.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sliiderVelocity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliiderVelocityStateChanged(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_btn.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.setContentAreaFilled(false);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnState.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pause_button.png"))); // NOI18N
        btnState.setText("Pause");
        btnState.setToolTipText("");
        btnState.setContentAreaFilled(false);
        btnState.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStateActionPerformed(evt);
            }
        });

        content.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        btnVisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/invisible_button.png"))); // NOI18N
        btnVisi.setContentAreaFilled(false);
        btnVisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRote, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnState, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sliiderVelocity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVisi)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(sliiderVelocity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRote)
                    .addComponent(btnClose)
                    .addComponent(btnState))
                .addContainerGap())
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void sliiderVelocityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliiderVelocityStateChanged
        //modifica la velocidad de giro del triangulo
        setVelocity(sliiderVelocity.getValue());
    }//GEN-LAST:event_sliiderVelocityStateChanged

    private void btnRoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoteActionPerformed
        //modifica el sentido de giro del triangulo
        form.setRotate();
        if (form.getRotate()) {
            btnRote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotar_der.png")));
        } else {
            btnRote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotar_izq.png")));
        }
    }//GEN-LAST:event_btnRoteActionPerformed

    private void btnStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStateActionPerformed
        setState();
        if (TIMER.isRunning()) {
            btnState.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pause_button.png")));
            btnState.setText("Pause");
        } else {
            btnState.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play_button.png")));
            btnState.setText("Play");
        }
    }//GEN-LAST:event_btnStateActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        exitAll();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnVisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisiActionPerformed
        if (content.isVisible()) {
            btnVisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/visible_button.png")));
        } else {
            btnVisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/invisible_button.png")));
        }
        content.setVisible(!content.isVisible());
    }//GEN-LAST:event_btnVisiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRote;
    private javax.swing.JButton btnState;
    private javax.swing.JButton btnVisi;
    private javax.swing.JPanel content;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JSlider sliiderVelocity;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        /*
        *modifica el titulo del contolador con el nombre del cliente y
        *cierra el controlador del cliente si recibe un 0 de este
         */
        try {
            lbTitle.setText(dis.readUTF());
            
            if (dis.readInt() == 0) {
                TIMER.stop();
                remove(form);
                vista.deleteContent(this);
            }
        } catch (IOException ex) {
            Logger.getLogger(ContentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
