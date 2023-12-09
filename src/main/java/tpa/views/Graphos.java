/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tpa.views;
import tpa.app.Aluno;
import tpa.app.ComparadorLivrosPorNome;
import tpa.app.GeradorDeArvores;
import arvores.lib.ArvoreAVL;
import arvores.lib.IArvoreBinaria;
import graphos.lib.Grapho;
import java.util.List;
/**
 *
 * @author breno
 */
public class Graphos extends javax.swing.JFrame {
    public Insert insert_viewer;
    public String graphoMontado;
    public Init inicio_viewer;
    public AdicionarAresta adiciona_aresta;
    public AdicionarVertice adiciona_vertice;

    Grapho grapho = new Grapho();

    /**
     * Creates new form SistemaAcademico
     */
    public Graphos() {
        initComponents();
        this.setLocationRelativeTo(null);
        insert_viewer = new Insert();

        grapho.adicionarVertice("sapato");
        grapho.adicionarVertice("meia");
        grapho.adicionarVertice("tenis");

        grapho.adicionarAresta("sapato", "meia");
        grapho.adicionarAresta("sapato", "tenis");
        grapho.adicionarAresta("meia", "tenis");

        System.out.println(grapho.populaVizualizacao());
        DemonstracaoGrapho.setText(grapho.populaVizualizacao()); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DemonstracaoGrapho = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        Volta = new javax.swing.JButton();
        AdicionaVertice = new javax.swing.JButton();
        AdicionaAresta = new javax.swing.JButton();
        VerificaCiclo = new javax.swing.JButton();
        OrdenaGrapho = new javax.swing.JButton();
        VizualizaVerificacao = new javax.swing.JLabel();

        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setText("Visualização");

        DemonstracaoGrapho.setColumns(20);
        DemonstracaoGrapho.setRows(5);
        jScrollPane1.setViewportView(DemonstracaoGrapho);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel2.setText("Graphos");

        Volta.setText("< Voltar");
        Volta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VoltaMouseClicked(evt);
            }
        });

        AdicionaVertice.setText("Adicionar Vertice");
        AdicionaVertice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdicionaVerticeMouseClicked(evt);
            }
        });

        AdicionaAresta.setText("Adiciona Aresta");
        AdicionaAresta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdicionaArestaMouseClicked(evt);
            }
        });

        VerificaCiclo.setText("Verifica Ciclo");
        VerificaCiclo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerificaCicloMouseClicked(evt);
            }
        });

        OrdenaGrapho.setText("Ordenar");
        OrdenaGrapho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrdenaGraphoMouseClicked(evt);
            }
        });

        VizualizaVerificacao.setText("Verificação nao realizada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Volta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VizualizaVerificacao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VerificaCiclo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(OrdenaGrapho)
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AdicionaVertice)
                            .addComponent(AdicionaAresta, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Volta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VerificaCiclo)
                            .addComponent(OrdenaGrapho))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AdicionaVertice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdicionaAresta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VizualizaVerificacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jLabel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void VoltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoltaMouseClicked
        inicio_viewer = new Init();
        inicio_viewer.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_VoltaMouseClicked

    private void AdicionaArestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionaArestaMouseClicked
             adiciona_aresta = new AdicionarAresta(grapho,DemonstracaoGrapho);
             adiciona_aresta.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_AdicionaArestaMouseClicked

    private void VerificaCicloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerificaCicloMouseClicked
        if (grapho.contemCiclo()) 
        {
            VizualizaVerificacao.setText("Contem ciclo");        // TODO add your handling code here:
        }
        else
        {
            VizualizaVerificacao.setText("Não contem ciclo");        // TODO add your handling code here:
        }
               // TODO add your handling code here:
    }//GEN-LAST:event_VerificaCicloMouseClicked

    private void AdicionaVerticeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionaVerticeMouseClicked
        // TODO add your handling code here:
        adiciona_vertice = new AdicionarVertice(grapho,DemonstracaoGrapho);
        adiciona_vertice.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_AdicionaVerticeMouseClicked

    private void OrdenaGraphoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdenaGraphoMouseClicked
        // TODO add your handling code here:
        grapho = grapho.ordenacaoTopologica();
        DemonstracaoGrapho.setText(grapho.populaVizualizacao());        // TODO add your handling code here:
    }//GEN-LAST:event_OrdenaGraphoMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Graphos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graphos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graphos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graphos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graphos().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionaAresta;
    private javax.swing.JButton AdicionaVertice;
    private javax.swing.JTextArea DemonstracaoGrapho;
    private javax.swing.JButton OrdenaGrapho;
    private javax.swing.JButton VerificaCiclo;
    private javax.swing.JLabel VizualizaVerificacao;
    private javax.swing.JButton Volta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
