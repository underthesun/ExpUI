/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import components.NodeConfDialog;
import components.ResultDialog;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.UIManager;
import components.Node;
import components.NodeProcess;

/**
 *
 * @author shuai
 */
public class NodePanel extends javax.swing.JPanel {
    
    private ArrayList<NodeProcess> nodeProcess;
    private ArrayList<Node> nodes;
    private NodeConfDialog nodeDialog;
    private ResultDialog resultDialog;
    private Point points1[];
    private Point points2[];

    /**
     * Creates new form NodePanel
     */
    public NodePanel() {
        initComponents();
        nodeProcess = new ArrayList<NodeProcess>();
        nodes = new ArrayList<Node>();
        nodeDialog = new NodeConfDialog((Frame) getParent(), true, this);
        resultDialog = new ResultDialog((Frame) getParent(), false, this);
        setLayout(null);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setPreferredSize(new Dimension(getMaxWidth(), getMaxHeight()));
        //draw separation line
        if (!nodeProcess.isEmpty()) {
            int len = nodeProcess.size();
            int x = 0, y = 0;
            for (int i = 0; i < len - 1; i++) {
                x = nodeProcess.get(i).getPoints()[1].x + (nodeProcess.get(i + 1).getPoints()[0].x - nodeProcess.get(i).getPoints()[1].x) / 2;
                y = getSize().height;
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Line2D line2d = new Line2D.Double(new Point(x, 0), new Point(x, y));
                g2d.setColor(Color.gray);
                g2d.draw(line2d);
            }
        }
        //draw lines bewteen nodes
        for (Node node : nodes) {
            ArrayList<Node> postNodes = node.getPostNodes();
            if (!postNodes.isEmpty()) {
                points1 = node.getPoints();
                for (Node pnode : postNodes) {
                    points2 = pnode.getPoints();
                    if (points1[1] != null && points2[0] != null) {
                        Graphics2D g2d = (Graphics2D) g;
                        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        Line2D line2d = new Line2D.Double(points1[1], points2[0]);
                        g2d.setColor(Color.black);
                        g2d.draw(line2d);
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public ArrayList<NodeProcess> getNodeProcess() {
        return nodeProcess;
    }
    
    public void setNodeProcess(ArrayList<NodeProcess> nodeProcess) {
        this.nodeProcess = nodeProcess;
    }
    
    public ArrayList<Node> getNodes() {
        return nodes;
    }
    
    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
    
    public NodeConfDialog getNodeDialog() {
        return nodeDialog;
    }
    
    public void setNodeDialog(NodeConfDialog nodeDialog) {
        this.nodeDialog = nodeDialog;
    }
    
    public ResultDialog getResultDialog() {
        return resultDialog;
    }
    
    public void setResultDialog(ResultDialog resultDialog) {
        this.resultDialog = resultDialog;
    }
    
    public int getMaxWidth() {
        int maxWidth = 0;
        for (NodeProcess np : nodeProcess) {
            int width = np.getLocation().x + np.getSize().width;
            if (width > maxWidth) {
                maxWidth = width;
            }
        }
        for (Node node : nodes) {
            int width = node.getLocation().x + node.getSize().width;
            if (width > maxWidth) {
                maxWidth = width;
            }
        }
        return maxWidth;
    }
    
    public int getMaxHeight() {
        int maxHeight = 0;
        for (NodeProcess np : nodeProcess) {
            int height = np.getLocation().y + np.getSize().height;
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        for (Node node : nodes) {
            int width = node.getLocation().y + node.getSize().height;
            if (width > maxHeight) {
                maxHeight = width;
            }
        }
        return maxHeight;
    }
    
    public void addNodeProcess(NodeProcess np) {
        add(np);
        nodeProcess.add(np);
        int width = getPreferredSize().width;
        int height = getPreferredSize().height;
        int pw = np.getLocation().x + np.getSize().width;
        int ph = np.getLocation().y + np.getSize().height;
        if (pw > width) {
            width = pw;
        }
        if (ph > height) {
            height = ph;
        }
        setPreferredSize(new Dimension(width, height));
        revalidate();
    }
    
    public void addNode(Node n) {
        add(n);
        nodes.add(n);
        int width = getPreferredSize().width;
        int height = getPreferredSize().height;
        int pw = n.getLocation().x + n.getSize().width;
        int ph = n.getLocation().y + n.getSize().height;
        if (pw > width) {
            width = pw;
        }
        if (ph > height) {
            height = ph;
        }
        setPreferredSize(new Dimension(width, height));
        revalidate();
    }
    
    public boolean isAllHaveNodes() {
        boolean flag = true;
        for (NodeProcess np : nodeProcess) {
            if (!np.hasNodes()) {
                flag = false;
                np.setBackground(Color.red);
                repaint();
            }
        }
        return flag;
    }
    
    public boolean isAllAssociated() {
        boolean flag = true;
        if (nodeProcess.size() > 1) {
            for (Node node : nodes) {
                if (!node.checkAssociation()) {
                    flag = false;
                }
            }
        }
        return flag;
    }
    
    public void reset() {
        for (NodeProcess np : nodeProcess) {
            np.reset();
        }
        for (Node node : nodes) {
            remove(node);
        }
        Node.resetCounter();
        nodes.clear();
        repaint();
    }
    
    public void colorResest() {
        for (NodeProcess np : nodeProcess) {
            np.setBackground(UIManager.getColor("Button.ground"));
        }
        for (Node node : nodes) {
            node.setBackground(UIManager.getColor("Button.ground"));
        }
        repaint();
    }
    
    public NodeProcess getPostNodeProcess(int proId) {
        NodeProcess nextNp = null;
        if (proId < nodeProcess.size()) {
            for (NodeProcess np : nodeProcess) {
                if (proId == np.getSerial() - 1) {
                    nextNp = np;
                }
            }
        }        
        return nextNp;
    }
    
    public NodeProcess getPreNodeProcess(int proId) {
        NodeProcess preNp = null;
        if (proId > 0) {
            for (NodeProcess np : nodeProcess) {
                if (proId == np.getSerial() + 1) {
                    preNp = np;
                }
            }
        }
        
        return preNp;
    }
}
