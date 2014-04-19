/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import components.Node;

/**
 *
 * @author b1106
 */
public class QueryPanel extends javax.swing.JPanel {

    NodePanel nodePanel;
    ArrayList<ArrayList<Object[]>> datas = new ArrayList<ArrayList<Object[]>>();
    ArrayList<ArrayList<Integer>> ids = new ArrayList<ArrayList<Integer>>();
    ResultModel resultModel = new ResultModel();

    private void init() {
        tbResult.setModel(resultModel);
        genData1();
        genData2();
        genData3();
        genData4();

        tbQuery.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int index = tbQuery.getSelectedRow();
                if (index != -1) {
                    resultModel.setData(datas.get(index));
                    setResultColor(index);
                }
            }
        });
    }

    private void setResultColor(int index) {
        nodePanel.colorResest();
        ArrayList<Integer> idList = ids.get(index);

        for (Integer id : idList) {
            for (Node n : nodePanel.getNodes()) {
                if (n.getId() == id) {
                    n.setBackground(Color.GREEN);
                }
            }
        }
    }

    private void genData1() {
        ArrayList<Object[]> data1 = new ArrayList<Object[]>();
        ArrayList<Integer> id1 = new ArrayList<Integer>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 25);

        cal.set(Calendar.MINUTE, new Random().nextInt(10));
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        String st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        String et = sdf.format(cal.getTime());
        data1.add(new Object[]{"预处理(1)", st, et});
//        id1.add(1);


        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 10);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data1.add(new Object[]{"去污干燥(0)", st, et});
//        id1.add(3);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 20);
        cal.set(Calendar.SECOND, new Random().nextInt(60));

        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data1.add(new Object[]{"器械消毒(1)", st, et});
//        id1.add(6);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 30);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data1.add(new Object[]{"打包灭菌(1)", st, et});
//        id1.add(9);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 40);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
//        et = sdf.format(cal.getTime());
        data1.add(new Object[]{"器械包库存(0)", st, ""});
        id1.add(10);

        datas.add(data1);
        ids.add(id1);
    }

    private void genData2() {
        ArrayList<Object[]> data2 = new ArrayList<Object[]>();
        ArrayList<Integer> id2 = new ArrayList<Integer>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 25);

        cal.set(Calendar.MINUTE, new Random().nextInt(10));
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        String st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        String et = sdf.format(cal.getTime());
        data2.add(new Object[]{"预处理(0)", st, et});
//        id2.add(0);


        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 10);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data2.add(new Object[]{"去污干燥(0)", st, et});
//        id2.add(3);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 20);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data2.add(new Object[]{"器械消毒(0)", st, et});
//        id2.add(5);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 30);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data2.add(new Object[]{"打包灭菌(0)", st, et});
//        id2.add(8);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 40);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data2.add(new Object[]{"器械包库存(1)", st, et});
//        id2.add(11);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 50);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data2.add(new Object[]{"器械包装车(2)", st, et});
//        id2.add(14);


        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) + 1);
        cal.set(Calendar.MINUTE, new Random().nextInt(10));
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
//        et = sdf.format(cal.getTime());
        data2.add(new Object[]{"器械包运输(2)", st, ""});
        id2.add(18);

        datas.add(data2);
        ids.add(id2);
    }

    private void genData3() {
        ArrayList<Object[]> data3 = new ArrayList<Object[]>();
        ArrayList<Integer> id3 = new ArrayList<Integer>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 25);

        cal.set(Calendar.MINUTE, new Random().nextInt(10));
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        String st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        String et = sdf.format(cal.getTime());
        data3.add(new Object[]{"预处理(2)", st, et});
        id3.add(2);


        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 10);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data3.add(new Object[]{"去污干燥(1)", st, et});
        id3.add(4);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 20);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data3.add(new Object[]{"器械消毒(1)", st, et});
        id3.add(6);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 30);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data3.add(new Object[]{"打包灭菌(1)", st, et});
        id3.add(9);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 40);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data3.add(new Object[]{"器械包库存(1)", st, et});
        id3.add(11);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 50);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data3.add(new Object[]{"器械包装车(2)", st, et});
        id3.add(14);


        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) + 1);
        cal.set(Calendar.MINUTE, new Random().nextInt(10));
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data3.add(new Object[]{"器械包运输(2)", st, et});
        id3.add(18);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 10);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data3.add(new Object[]{"器械包申领(2)", st, et});
        id3.add(22);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 20);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data3.add(new Object[]{"器械回收(2)", st, et});
        id3.add(27);

        datas.add(data3);
        ids.add(id3);
    }

    private void genData4() {
        ArrayList<Object[]> data4 = new ArrayList<Object[]>();
        ArrayList<Integer> id4 = new ArrayList<Integer>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 25);

        cal.set(Calendar.MINUTE, new Random().nextInt(10));
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        String st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        String et = sdf.format(cal.getTime());
        data4.add(new Object[]{"预处理(1)", st, et});
        id4.add(1);


        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 10);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data4.add(new Object[]{"去污干燥(0)", st, et});
        id4.add(3);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 20);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data4.add(new Object[]{"器械消毒(1)", st, et});
        id4.add(6);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 30);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data4.add(new Object[]{"打包灭菌(0)", st, et});
        id4.add(8);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 40);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data4.add(new Object[]{"器械包库存(1)", st, et});
        id4.add(11);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 50);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data4.add(new Object[]{"器械包装车(3)", st, et});
        id4.add(15);


        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) + 1);
        cal.set(Calendar.MINUTE, new Random().nextInt(10));
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data4.add(new Object[]{"器械包运输(2)", st, et});
        id4.add(18);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 10);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data4.add(new Object[]{"器械包申领(1)", st, et});
        id4.add(21);

        cal.set(Calendar.MINUTE, new Random().nextInt(10) + 20);
        cal.set(Calendar.SECOND, new Random().nextInt(60));
        st = sdf.format(cal.getTime());
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
        et = sdf.format(cal.getTime());
        data4.add(new Object[]{"器械回收(1)", st, et});
        id4.add(26);

        datas.add(data4);
        ids.add(id4);
    }

    /**
     * Creates new form QueryPanel
     */
    public QueryPanel() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbQuery = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbResult = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "任务信息", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("宋体", 1, 14))); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 406));

        tbQuery.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        tbQuery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"query00000001", "ins0000001251", "追踪"},
                {"query00000002", "ins0000000523", "追踪"},
                {"query00000003", "ins0000023195", "追溯"},
                {"query00000004", "ins0000007520", "追溯"}
            },
            new String [] {
                "查询任务编号", "查询RFID", "查询类型"
            }
        ));
        tbQuery.setRowHeight(30);
        jScrollPane1.setViewportView(tbQuery);

        add(jScrollPane1, java.awt.BorderLayout.WEST);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "查询结果", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("宋体", 1, 14))); // NOI18N

        tbResult.setFont(new java.awt.Font("宋体", 0, 16)); // NOI18N
        tbResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "查询结果"
            }
        ));
        tbResult.setRowHeight(30);
        jScrollPane3.setViewportView(tbResult);

        add(jScrollPane3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbQuery;
    private javax.swing.JTable tbResult;
    // End of variables declaration//GEN-END:variables

    public void setNodePanel(NodePanel nodePanel) {
        this.nodePanel = nodePanel;
    }
}
