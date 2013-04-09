package com.im.client.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
 
import javax.swing.BorderFactory;
import javax.swing.CellRendererPane;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.Document;
 
@SuppressWarnings("serial")
public class MainSearchTextField extends JTextField {
 
    public static void main(String[] args) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        MainSearchTextField comp = new MainSearchTextField(20);
        comp = new MainSearchTextField(20);
        comp.setIconPosition(SwingConstants.RIGHT);
        comp.setBorder(BorderFactory.createEmptyBorder());
        //comp.setOpaque(false);
        p.add(comp);
        p.setBackground(Color.black);
        Dimension d = new Dimension();
        d.width = 180;
        d.height = 30;
        p.setPreferredSize(d);
        JFrame frame = new JFrame();
        frame.setTitle("www.wiui.net");
        //frame.setContentPane(p);
        frame.add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
 
    public MainSearchTextField() {
        initTextField();
    }
 
    public MainSearchTextField(String text) {
        super(text);
        initTextField();
    }
 
    public MainSearchTextField(int columns) {
        super(columns);
        initTextField();
    }
 
    public MainSearchTextField(String text, int columns) {
        super(text, columns);
        initTextField();
    }
 
    public MainSearchTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
        initTextField();
    }
 
    private JLabel iconLabel = new JLabel(new ImageIcon("images/frame/main/search/main_search_normal.png"));
    private JLabel clearLabel = new JLabel(new ImageIcon("images/frame/main/search/main_search_delhighlight.png"));
    private JLabel infoLabel = new JLabel("search");
    private Dimension iconSize;
    private Dimension infoSize;
 
    private int iconPosition = SwingConstants.LEFT;
    private boolean showClearIcon = true;
 
    private CellRendererPane cellRendererPane = new CellRendererPane();
 
    private void initTextField() {
        iconLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        iconLabel.setToolTipText("Search");
        clearLabel.setToolTipText("Clear");
        clearLabel.setOpaque(true);
        //clearLabel.setBackground(Color.RED);
        this.setToolTipText("hhhhhhhhhhhh");
        iconSize = iconLabel.getPreferredSize();
        infoSize = infoLabel.getPreferredSize();
        infoLabel.setEnabled(false);
        this.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
                setMouseComponent(null);
            }
 
            public void mouseClicked(MouseEvent e) {
                if (mouseCom == clearLabel) {
                    setText("");
                } else if (mouseCom == iconLabel) {
                    handleIconClick();
                }
            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
                JComponent com = getComponentAtPoint(e.getPoint());
                setMouseComponent(com);
            }
 
            public void mouseDragged(MouseEvent e) {
            }
        });
        this.addFocusListener(new FocusListener() {
 
            public void focusLost(FocusEvent e) {
                repaint();
            }
 
            public void focusGained(FocusEvent e) {
                repaint();
            }
        });
    }
 
    private void handleIconClick() {
        System.out.println("===");
    }
 
    public String getToolTipText(MouseEvent event) {
        event.getPoint();
        if (mouseCom == null) {
            return null;
        }
        if (mouseCom == this) {
            return super.getToolTipText(event);
        }
        return mouseCom.getToolTipText(event);
    }
 
    private int iconGap = 3;
 
    public Insets getInsets() {
        Insets insets = super.getInsets();
        if (iconPosition == SwingConstants.LEFT) {
            insets.left += iconSize.width + iconGap + 2;
            if (this.getText() != null && this.getText().length() != 0 && showClearIcon) {
                insets.right += iconSize.width + iconGap + 2;
            } else {
                insets.right += iconGap;
            }
        } else {
            insets.left += iconGap;
            if (this.getText() != null && this.getText().length() != 0 && showClearIcon) {
                insets.right += iconSize.width + iconGap + 2;
            } else {
                insets.right += iconGap;
            }
        }
        return insets;
    }
 
    private JComponent getComponentAtPoint(Point point) {
        int x = (int) point.getX();
        int y = (int) point.getY();
        if (contains(x, y) == false) {
            return null;
        }
 
        if (iconPosition == SwingConstants.LEFT) {
            if (x < iconSize.width + iconGap + 2) {
                return iconLabel;
            }
            if (getText() != null && getText().length() != 0 && showClearIcon) {
                if (x > getWidth() - iconSize.width - iconGap) {
                    return clearLabel;
                }
            }
        } else {
            if (this.getText() == null || this.getText().length() == 0) {
                if (x > getWidth() - iconSize.width - iconGap - 2) {
                    return iconLabel;
                }
            }
            if (getText() != null && getText().length() != 0 && showClearIcon) {
                if (x > getWidth() - iconSize.width - iconGap - 2) {
                    return clearLabel;
                }
            }
 
        }
        return this;
    }
 
    private JComponent mouseCom;
 
    private void setMouseComponent(JComponent com) {
        if (mouseCom == com) {
            return;
        }
        if (mouseCom != null && mouseCom instanceof JLabel) {
            mouseCom.setBorder(null);
        }
        mouseCom = com;
        if (mouseCom != null && mouseCom instanceof JLabel) {
            mouseCom.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 1));
        }
        this.repaint();
        if (mouseCom == null || mouseCom == clearLabel) {
            setCursor(Cursor.getDefaultCursor());
            return;
        }
        if (mouseCom == this) {
            setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            return;
        }
        if (mouseCom == iconLabel) {
            setCursor(iconLabel.getCursor());
            return;
        }
    }
 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int y = (int) (this.getHeight() / 2.0 - iconSize.getHeight() / 2);
        if (iconPosition == SwingConstants.LEFT) {
            cellRendererPane.paintComponent(g2d, iconLabel, this, iconGap, y, iconSize.width, iconSize.height);
            if (this.getText() != null && this.getText().length() != 0 && showClearIcon) {
                cellRendererPane.paintComponent(g2d, clearLabel, this, this.getWidth() - iconSize.width - iconGap, y, iconSize.width, iconSize.height);
            }
        } else {
            if (this.getText() == null || this.getText().length() == 0) {
                cellRendererPane.paintComponent(g2d, iconLabel, this, this.getWidth() - iconSize.width - iconGap, y, iconSize.width, iconSize.height);
            } else {
                if (showClearIcon) {
                    cellRendererPane.paintComponent(g2d, clearLabel, this, this.getWidth() - iconSize.width - iconGap, y, iconSize.width, iconSize.height);
                }
            }
        }
 
        if (!this.isFocusOwner()) {
            if (this.getText() == null || this.getText().length() == 0) {
                int x = iconGap + 2;
                if (iconPosition == SwingConstants.LEFT) {
                    x = iconSize.width + iconGap + 2;
                }
                y = (int) (this.getHeight() / 2.0 - infoSize.getHeight() / 2);
                cellRendererPane.paintComponent(g2d, infoLabel, this, x, y, infoSize.width, infoSize.height);
            }
        }
    }
 
    public Dimension getPreferredSize() {
        Insets s = super.getInsets();
        Insets t = this.getInsets();
        Dimension preferredSize = super.getPreferredSize();
        preferredSize.setSize(preferredSize.width - (t.left + t.right - s.left - s.right), preferredSize.height + 2);
        return preferredSize;
    }
 
   /* protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (this.isFocusOwner()) {
            g2d.setStroke(new BasicStroke(1.5f));
        } else {
            g2d.setStroke(new BasicStroke(1f));
        }
        RoundRectangle2D.Double rect = new RoundRectangle2D.Double(0, 0, this.getWidth() - 2, this.getHeight() - 2, 4, 4);
        g2d.setColor(new Color(0, 100, 100, 150));
        g2d.draw(rect);
    }*/
 
    public int getIconPosition() {
        return iconPosition;
    }
 
    public void setIconPosition(int iconPosition) {
        this.iconPosition = iconPosition;
        this.invalidate();
        this.repaint();
    }
 
    public boolean isShowClearIcon() {
        return showClearIcon;
    }
 
    public void setShowClearIcon(boolean showClearIcon) {
        this.showClearIcon = showClearIcon;
        this.repaint();
    }
 
}
