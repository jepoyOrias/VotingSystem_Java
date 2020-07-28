/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplevoting;


import samplevoting.MainUI;
import Helpers.Student;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class BallotBox extends javax.swing.JFrame {

   Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String gender ="";
    
    public BallotBox() {
        
        initComponents();
        conn = VotingsystemDB.VotingsystemDB();
        
        populatePositions("President", pres);
        populatePositions("Vice President", vpres);
        populatePositions("Governor", Gov);
        populatePositions("Vice Governor", VGov);
        populatePositions("BEED BM",BM);
        populateBM();
        
        fetch();
    }
    
    
    
    
    
    public void fetch(){
        try {
            String sql = "SELECT  id_numnber firstname, course FROM students where id_number= ? ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
           if(rs.next()){
          JOptionPane.showMessageDialog(null,"Welcome Voter");
                   
                   
                   Student.setFirstname(rs.getString("firstname"));
                   name.setText(rs.getString(""+Student.getFirstname()));
                   Student.setFirstname(rs.getString("lastname"));
                   name.setText(rs.getString(""+Student.getFirstname()));
                   
            }
         
           
        } catch (Exception e) {
            System.err.println(e);
        }
}   

    public void populatePositions(String position, JComboBox combo){
        
        try{
            String sql = "SELECT CONCAT(B.firstname, ' ', B.lastname) 'Student Name', A.partylist 'Party Affiliation'\n" +
                            "	FROM\n" +
                            "    candidates A\n" +
                            "    INNER JOIN students B\n" +
                            "    ON A.id_number = B.id_number\n" +
                            "    INNER JOIN positions C\n" +
                            "    ON A.position_id = C.position_id" +
                            "    WHERE C.position = '"+ position +"'";
            
            String candidateSql = "SELECT COUNT(A.candidate_id)\n" +
                                    "	from \n" +
                                    "   candidates A\n" +
                                    "   INNER JOIN positions B\n" +
                                    "   ON A.position_id = B.position_id\n" +
                                    "   WHERE B.position = '"+ position +"'";
            
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            DefaultComboBoxModel dcm = new DefaultComboBoxModel();
            ResultSet rsCandidate = conn.prepareStatement(candidateSql).executeQuery();
            
            //pag wala pang laman yun positions
            if (rsCandidate.next()) {
                if (rsCandidate.getInt(1) == 0) {
                    dcm.addElement("No candidate yet ...");
                } else {
                    while(rs.next()){
                        dcm.addElement(rs.getString(1)+"( "+rs.getString(2)+")");
                    }
                }
            }
            
            
            combo.setModel(dcm);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
            
    /***
     *  Populate the drop down for board members
     */
    public void populateBM() {
        
        System.out.println(Student.getCourse());
        System.out.println(Student.getPosition());
        
        try{
            String sql = "SELECT CONCAT(B.firstname, ' ', B.lastname) 'Student Name', A.partylist 'Party Affiliation', B.course\n" +
                            "	 FROM\n" +
                            "    candidates A\n" +
                            "    INNER JOIN students B\n" +
                            "    ON A.id_number = B.id_number\n" +
                            "    INNER JOIN positions C\n" +
                            "    ON A.position_id = C.position_id\n" +
                            "    WHERE C.position_type = 'BM'\n";
                           
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
                 
            DefaultComboBoxModel dcm = new DefaultComboBoxModel();
            
            while (rs.next()) {
                if (Student.getCourse().equals(rs.getString(3))) {
                    dcm.addElement(rs.getString(1) + " " + "( "+rs.getString(2)+")");
                }
            }
            BM.setModel(dcm);
            
        }  catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
           System.err.println(e);
            }
    }
    
    
    
    private int getCandidateId(String candidate) {
        int id = 0;
        
        Pattern regex = Pattern.compile("^[^(]*");
        Matcher regexMatcher = regex.matcher(candidate);
        
        if (regexMatcher.find()) {
            System.out.println("Candidates: " + regexMatcher.group());
            try {
                String sql = "SELECT A.candidate_id FROM candidates A "
                                + "INNER JOIN students B ON A.id_number = B.id_number "
                                + "WHERE CONCAT(B.firstname, ' ', B.lastname) = '"+ regexMatcher.group() +"'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        } else {
            System.out.println("No match");
        }
        
        return id;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        pres = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vpres = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        Gov = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        VGov = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        BM = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        vote = new javax.swing.JButton();
        studentnumber = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pres.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        pres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pres.setPreferredSize(new java.awt.Dimension(31, 50));
        pres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("President :");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setText("Vice President : ");

        vpres.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        vpres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vpres.setMinimumSize(new java.awt.Dimension(31, 50));
        vpres.setPreferredSize(new java.awt.Dimension(31, 50));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setText("Governor : ");

        Gov.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Gov.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Gov.setMinimumSize(new java.awt.Dimension(31, 50));
        Gov.setPreferredSize(new java.awt.Dimension(31, 50));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setText("Vice Governor :");

        VGov.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        VGov.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VGov.setMinimumSize(new java.awt.Dimension(31, 50));
        VGov.setPreferredSize(new java.awt.Dimension(31, 50));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setText("Board Member :");

        BM.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        BM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BM.setMinimumSize(new java.awt.Dimension(31, 50));
        BM.setPreferredSize(new java.awt.Dimension(31, 50));
        BM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/samplevoting/bsulogo.png"))); // NOI18N
        jLabel6.setText("jLabel1");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("BULACAN STATE UNIVERSITY");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SARMIENTO CAMPUS");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("LOCAL STUDENT COUNCIL");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/samplevoting/bsusc.png"))); // NOI18N
        jLabel10.setText("jLabel5");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("City of San Jose Del Monte, Bulacan");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Republic of the Philippines");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel8)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel11)))
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addGap(32, 32, 32))
        );

        vote.setBackground(new java.awt.Color(153, 153, 255));
        vote.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        vote.setText("Vote");
        vote.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voteActionPerformed(evt);
            }
        });

        studentnumber.setEditable(false);
        studentnumber.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        studentnumber.setBorder(null);
        studentnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentnumberActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel13.setText("WELCOME,");

        name.setEditable(false);
        name.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        name.setBorder(null);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        status.setEditable(false);
        status.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        status.setBorder(null);
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel14.setText("Log-out");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("BulSU-SC LSC Voting System 2018");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(287, 287, 287)
                                .addComponent(vote))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(VGov, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Gov, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(vpres, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pres, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name))
                            .addComponent(studentnumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vpres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Gov, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(VGov, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(vote, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void presActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_presActionPerformed

    private void BMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BMActionPerformed

    private void voteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to submit this vote ?", "Confirm vote", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            try {
                String sql = "INSERT into voting_tally (candidate_id, id_number) VALUES (?, ?), (?, ?), (?, ?), (?, ?), (?, ?)";
                PreparedStatement stmt =  conn.prepareStatement(sql);

                stmt.setInt(1, getCandidateId(pres.getSelectedItem().toString()));
                stmt.setString(2, Student.getIdNumber());

                stmt.setInt(3, getCandidateId(vpres.getSelectedItem().toString()));
                stmt.setString(4, Student.getIdNumber());

                stmt.setInt(5, getCandidateId(Gov.getSelectedItem().toString()));
                stmt.setString(6, Student.getIdNumber());

                stmt.setInt(7, getCandidateId(VGov.getSelectedItem().toString()));
                stmt.setString(8, Student.getIdNumber());

                stmt.setInt(9, getCandidateId(BM.getSelectedItem().toString()));
                stmt.setString(10, Student.getIdNumber());

                stmt.execute();
                
                String value = (studentnumber.getText());
                sql = "UPDATE students SET status=? where id_number ='"+value+"'";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "VOTED");
                stmt.executeUpdate();
                  
                JOptionPane.showMessageDialog(this, "Vote successfully submitted Thankyou for voting", " Successful Voting", JOptionPane.INFORMATION_MESSAGE);
                MainUI main = new MainUI();
                main.setVisible(true);
               this.dispose();
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Error in submitting vote: " + e, "Voting Error", JOptionPane.ERROR_MESSAGE);
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_voteActionPerformed

    private void studentnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentnumberActionPerformed
       
    }//GEN-LAST:event_studentnumberActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        
    }//GEN-LAST:event_nameActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        MainUI main = new MainUI();
        main.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

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
            java.util.logging.Logger.getLogger(BallotBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BallotBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BallotBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BallotBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BallotBox().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox BM;
    private javax.swing.JComboBox Gov;
    private javax.swing.JComboBox VGov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JTextField name;
    private javax.swing.JComboBox pres;
    public javax.swing.JTextField status;
    public javax.swing.JTextField studentnumber;
    private javax.swing.JButton vote;
    private javax.swing.JComboBox vpres;
    // End of variables declaration//GEN-END:variables

    private void If(boolean next) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
