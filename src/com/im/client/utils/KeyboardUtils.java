package com.im.client.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import com.im.client.ui.MiniLogin;
import com.sun.awt.AWTUtilities;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			2    
* Comments:  			设置软键盘                                         
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.utils                         
* Author：				Ellery                 
* Create Date：			2011-04-30 22:05 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 

@SuppressWarnings("serial")
public class KeyboardUtils extends JDialog implements MouseListener, ActionListener {
	
	//关闭按钮
	private ImageIcon btn_keyboard_close_normalIcon = ImageManageUtils.getImageIcon("images/frame/login/keyboard/btn_keyboard_close_normal.png");
	private ImageIcon btn_keyboard_close_hoverIcon = ImageManageUtils.getImageIcon("images/frame/login/keyboard/btn_keyboard_close_hover.png");
	private ImageIcon btn_keyboard_close_pressIcon = ImageManageUtils.getImageIcon("images/frame/login/keyboard/btn_keyboard_close_press.png");

	@SuppressWarnings("unused")
	//大小写切换
	private boolean flg = false;
	@SuppressWarnings("unused")
	//数字符号切换
	private boolean flgs = false;
	private MiniLogin miniLogin = null;
	private int i = 1;
	private int j = 1;
	private Color fcolor = new Color(27, 148, 218);
	private Color color = Color.BLACK;
	private JLabel t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, Backspace;
	private JLabel Q, W, E, R, T, Y, U, I, O, P, Thr1, Thr2, Thr3;
	private JLabel Caps, A, S, D, F, G, H, J, K, L, FO1, FO2, FO3;
	private JLabel Shift, Z, X, C, V, BS, N, M, FI1, FI2;
	private JButton btn_keyboard_close = null;

	public static String superstr = "";
	
	private Font FONT_12_NOBOLD = new Font("微软雅黑", 0, 12);

	public KeyboardUtils(JFrame frame, int x, int y) {
		super(frame, "屏幕键盘", true);
		start(x, y);
	}

	public void start(int x, int y) {
		this.setBounds(x, y, 457, 120);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				setVisible(false);
				dispose();
			}
		});
		//设置字体
		FontUtils.initGlobalFont(FONT_12_NOBOLD); 
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.getContentPane().setBackground(new Color(27, 148, 218));
		
		//定义一个所有圆角都使用 double坐标指定的矩形
		Shape shape = new RoundRectangle2D.Double(0, 0, 
				457, 120, 6.5D, 6.5D);  
		AWTUtilities.setWindowShape(this, shape); 
		
		Border border = BorderFactory.createRaisedBevelBorder();
		
		//设置最小化按钮
		btn_keyboard_close = new JButton();
		btn_keyboard_close.setBounds(new Rectangle(443, 3, 12, 12));
		btn_keyboard_close.setIcon(btn_keyboard_close_normalIcon);
		btn_keyboard_close.setRolloverIcon(btn_keyboard_close_hoverIcon);
		btn_keyboard_close.setPressedIcon(btn_keyboard_close_pressIcon);
		btn_keyboard_close.setBorderPainted(false);
		btn_keyboard_close.setContentAreaFilled(false);
		btn_keyboard_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KeyboardUtils.this.setVisible(false);
			}
		});
		this.getContentPane().add(btn_keyboard_close);

		t1 = new JLabel("1");
		t1.setHorizontalAlignment(JLabel.CENTER);
		t1.setBorder(border);
		t1.setOpaque(true);
		t1.setBackground(Color.white);
		t1.addMouseListener(this);
		t1.setBounds(new Rectangle(2, 2, 25, 25));
		this.getContentPane().add(t1);

		t2 = new JLabel("2");
		t2.setHorizontalAlignment(JLabel.CENTER);
		t2.setBorder(border);
		t2.setOpaque(true);
		t2.setBackground(Color.white);
		t2.addMouseListener(this);
		t2.setBounds(new Rectangle(32, 2, 25, 25));
		this.getContentPane().add(t2);

		t3 = new JLabel("3");
		t3.setHorizontalAlignment(JLabel.CENTER);
		t3.setBorder(border);
		t3.setOpaque(true);
		t3.setBackground(Color.white);
		t3.addMouseListener(this);
		t3.setBounds(new Rectangle(62, 2, 25, 25));
		this.getContentPane().add(t3);

		t4 = new JLabel("4");
		t4.setHorizontalAlignment(JLabel.CENTER);
		t4.setBorder(border);
		t4.setOpaque(true);
		t4.setBackground(Color.white);
		t4.addMouseListener(this);
		t4.setBounds(new Rectangle(92, 2, 25, 25));
		this.getContentPane().add(t4);

		t5 = new JLabel("5");
		t5.setHorizontalAlignment(JLabel.CENTER);
		t5.setBorder(border);
		t5.setOpaque(true);
		t5.setBackground(Color.white);
		t5.addMouseListener(this);
		t5.setBounds(new Rectangle(122, 2, 25, 25));
		this.getContentPane().add(t5);

		t6 = new JLabel("6");
		t6.setHorizontalAlignment(JLabel.CENTER);
		t6.setBorder(border);
		t6.setOpaque(true);
		t6.setBackground(Color.white);
		t6.addMouseListener(this);
		t6.setBounds(new Rectangle(152, 2, 25, 25));
		this.getContentPane().add(t6);

		t7 = new JLabel("7");
		t7.setHorizontalAlignment(JLabel.CENTER);
		t7.setBorder(border);
		t7.setOpaque(true);
		t7.setBackground(Color.white);
		t7.addMouseListener(this);
		t7.setBounds(new Rectangle(182, 2, 25, 25));
		this.getContentPane().add(t7);

		t8 = new JLabel("8");
		t8.setHorizontalAlignment(JLabel.CENTER);
		t8.setBorder(border);
		t8.setOpaque(true);
		t8.setBackground(Color.white);
		t8.addMouseListener(this);
		t8.setBounds(new Rectangle(212, 2, 25, 25));
		this.getContentPane().add(t8);

		t9 = new JLabel("9");
		t9.setHorizontalAlignment(JLabel.CENTER);
		t9.setBorder(border);
		t9.setOpaque(true);
		t9.setBackground(Color.white);
		t9.addMouseListener(this);
		t9.setBounds(new Rectangle(242, 2, 25, 25));
		this.getContentPane().add(t9);

		t0 = new JLabel("0");
		t0.setHorizontalAlignment(JLabel.CENTER);
		t0.setBorder(border);
		t0.setOpaque(true);
		t0.setBackground(Color.white);
		t0.addMouseListener(this);
		t0.setBounds(new Rectangle(272, 2, 25, 25));
		this.getContentPane().add(t0);

		t10 = new JLabel("-");
		t10.setHorizontalAlignment(JLabel.CENTER);
		t10.setBorder(border);
		t10.setOpaque(true);
		t10.setBackground(Color.white);
		t10.addMouseListener(this);
		t10.setBounds(new Rectangle(302, 2, 25, 25));
		this.getContentPane().add(t10);

		t11 = new JLabel("=");
		t11.setHorizontalAlignment(JLabel.CENTER);
		t11.setBorder(border);
		t11.setOpaque(true);
		t11.setBackground(Color.white);
		t11.addMouseListener(this);
		t11.setBounds(new Rectangle(332, 2, 25, 25));
		this.getContentPane().add(t11);

		Backspace = new JLabel("清除文本");
		Backspace.setHorizontalAlignment(JLabel.CENTER);
		Backspace.setBorder(border);
		Backspace.setOpaque(true);
		Backspace.setBackground(Color.white);
		Backspace.addMouseListener(this);
		Backspace.setBounds(new Rectangle(362, 2, 80, 25));
		this.getContentPane().add(Backspace);

		Q = new JLabel("q");
		Q.setHorizontalAlignment(JLabel.CENTER);
		Q.setBorder(border);
		Q.setOpaque(true);
		Q.setBackground(Color.white);
		Q.addMouseListener(this);
		Q.setBounds(new Rectangle(2, 32, 25, 25));
		this.getContentPane().add(Q);

		W = new JLabel("w");
		W.setHorizontalAlignment(JLabel.CENTER);
		W.setBorder(border);
		W.setOpaque(true);
		W.setBackground(Color.white);
		W.addMouseListener(this);
		W.setBounds(new Rectangle(27, 32, 25, 25));
		this.getContentPane().add(W);

		E = new JLabel("e");
		E.setHorizontalAlignment(JLabel.CENTER);
		E.setBorder(border);
		E.setOpaque(true);
		E.setBackground(Color.white);
		E.addMouseListener(this);
		E.setBounds(new Rectangle(52, 32, 25, 25));
		this.getContentPane().add(E);

		R = new JLabel("r");
		R.setHorizontalAlignment(JLabel.CENTER);
		R.setBorder(border);
		R.setOpaque(true);
		R.setBackground(Color.white);
		R.addMouseListener(this);
		R.setBounds(new Rectangle(77, 32, 25, 25));
		this.getContentPane().add(R);

		T = new JLabel("t");
		T.setHorizontalAlignment(JLabel.CENTER);
		T.setBorder(border);
		T.setOpaque(true);
		T.setBackground(Color.white);
		T.addMouseListener(this);
		T.setBounds(new Rectangle(102, 32, 25, 25));
		this.getContentPane().add(T);

		Y = new JLabel("y");
		Y.setHorizontalAlignment(JLabel.CENTER);
		Y.setBorder(border);
		Y.setOpaque(true);
		Y.setBackground(Color.white);
		Y.addMouseListener(this);
		Y.setBounds(new Rectangle(127, 32, 25, 25));
		this.getContentPane().add(Y);

		U = new JLabel("u");
		U.setHorizontalAlignment(JLabel.CENTER);
		U.setBorder(border);
		U.setOpaque(true);
		U.setBackground(Color.white);
		U.addMouseListener(this);
		U.setBounds(new Rectangle(152, 32, 25, 25));
		this.getContentPane().add(U);

		I = new JLabel("i");
		I.setHorizontalAlignment(JLabel.CENTER);
		I.setBorder(border);
		I.setOpaque(true);
		I.setBackground(Color.white);
		I.addMouseListener(this);
		I.setBounds(new Rectangle(177, 32, 25, 25));
		this.getContentPane().add(I);

		O = new JLabel("o");
		O.setHorizontalAlignment(JLabel.CENTER);
		O.setBorder(border);
		O.setOpaque(true);
		O.setBackground(Color.white);
		O.addMouseListener(this);
		O.setBounds(new Rectangle(202, 32, 25, 25));
		this.getContentPane().add(O);

		P = new JLabel("p");
		P.setHorizontalAlignment(JLabel.CENTER);
		P.setBorder(border);
		P.setOpaque(true);
		P.setBackground(Color.white);
		P.addMouseListener(this);
		P.setBounds(new Rectangle(227, 32, 25, 25));
		this.getContentPane().add(P);

		Thr1 = new JLabel("{");
		Thr1.setHorizontalAlignment(JLabel.CENTER);
		Thr1.setBorder(border);
		Thr1.setOpaque(true);
		Thr1.setBackground(Color.white);
		Thr1.addMouseListener(this);
		Thr1.setBounds(new Rectangle(255, 32, 55, 25));
		this.getContentPane().add(Thr1);

		Thr2 = new JLabel("}");
		Thr2.setHorizontalAlignment(JLabel.CENTER);
		Thr2.setBorder(border);
		Thr2.setOpaque(true);
		Thr2.setBackground(Color.white);
		Thr2.addMouseListener(this);
		Thr2.setBounds(new Rectangle(310, 32, 55, 25));
		this.getContentPane().add(Thr2);

		Thr3 = new JLabel("|");
		Thr3.setHorizontalAlignment(JLabel.CENTER);
		Thr3.setBorder(border);
		Thr3.setOpaque(true);
		Thr3.setBackground(Color.white);
		Thr3.addMouseListener(this);
		Thr3.setBounds(new Rectangle(365, 32, 77, 25));
		this.getContentPane().add(Thr3);

		Caps = new JLabel("大写锁定");
		Caps.setHorizontalAlignment(JLabel.CENTER);
		Caps.setBorder(border);
		Caps.setOpaque(true);
		Caps.setBackground(Color.white);
		Caps.setBounds(new Rectangle(227, 92, 110, 25));
		Caps.addMouseListener(this);
		this.getContentPane().add(Caps);

		A = new JLabel("a");
		A.setHorizontalAlignment(JLabel.CENTER);
		A.setBorder(border);
		A.setOpaque(true);
		A.setBackground(Color.white);
		A.addMouseListener(this);
		A.setBounds(new Rectangle(2, 62, 25, 25));
		this.getContentPane().add(A);

		S = new JLabel("s");
		S.setHorizontalAlignment(JLabel.CENTER);
		S.setBorder(border);
		S.setOpaque(true);
		S.setBackground(Color.white);
		S.addMouseListener(this);
		S.setBounds(new Rectangle(27, 62, 25, 25));
		this.getContentPane().add(S);

		D = new JLabel("d");
		D.setHorizontalAlignment(JLabel.CENTER);
		D.setBorder(border);
		D.setOpaque(true);
		D.setBackground(Color.white);
		D.addMouseListener(this);
		D.setBounds(new Rectangle(52, 62, 25, 25));
		this.getContentPane().add(D);

		F = new JLabel("f");
		F.setHorizontalAlignment(JLabel.CENTER);
		F.setBorder(border);
		F.setOpaque(true);
		F.setBackground(Color.white);
		F.addMouseListener(this);
		F.setBounds(new Rectangle(77, 62, 25, 25));
		this.getContentPane().add(F);

		G = new JLabel("g");
		G.setHorizontalAlignment(JLabel.CENTER);
		G.setBorder(border);
		G.setOpaque(true);
		G.setBackground(Color.white);
		G.addMouseListener(this);
		G.setBounds(new Rectangle(102, 62, 25, 25));
		this.getContentPane().add(G);

		H = new JLabel("h");
		H.setHorizontalAlignment(JLabel.CENTER);
		H.setBorder(border);
		H.setOpaque(true);
		H.setBackground(Color.white);
		H.addMouseListener(this);
		H.setBounds(new Rectangle(127, 62, 25, 25));
		this.getContentPane().add(H);

		J = new JLabel("j");
		J.setHorizontalAlignment(JLabel.CENTER);
		J.setBorder(border);
		J.setOpaque(true);
		J.setBackground(Color.white);
		J.addMouseListener(this);
		J.setBounds(new Rectangle(152, 62, 25, 25));
		this.getContentPane().add(J);

		K = new JLabel("k");
		K.setHorizontalAlignment(JLabel.CENTER);
		K.setBorder(border);
		K.setOpaque(true);
		K.setBackground(Color.white);
		K.addMouseListener(this);
		K.setBounds(new Rectangle(177, 62, 25, 25));
		this.getContentPane().add(K);

		L = new JLabel("l");
		L.setHorizontalAlignment(JLabel.CENTER);
		L.setBorder(border);
		L.setOpaque(true);
		L.setBackground(Color.white);
		L.addMouseListener(this);
		L.setBounds(new Rectangle(202, 62, 25, 25));
		this.getContentPane().add(L);

		FO1 = new JLabel(";");
		FO1.setHorizontalAlignment(JLabel.CENTER);
		FO1.setBorder(border);
		FO1.setOpaque(true);
		FO1.setBackground(Color.white);
		FO1.addMouseListener(this);
		FO1.setBounds(new Rectangle(227, 62, 25, 25));
		this.getContentPane().add(FO1);

		FO2 = new JLabel("'");
		FO2.setHorizontalAlignment(JLabel.CENTER);
		FO2.setBorder(border);
		FO2.setOpaque(true);
		FO2.setBackground(Color.white);
		FO2.addMouseListener(this);
		FO2.setBounds(new Rectangle(252, 62, 40, 25));
		this.getContentPane().add(FO2);

		FO3 = new JLabel("确定输入并退出");
		FO3.setHorizontalAlignment(JLabel.CENTER);
		FO3.setBorder(border);
		FO3.setOpaque(true);
		FO3.setBackground(Color.white);
		FO3.addMouseListener(this);
		FO3.setBounds(new Rectangle(292, 62, 150, 25));
		this.getContentPane().add(FO3);

		Shift = new JLabel("符号切换");
		Shift.setHorizontalAlignment(JLabel.CENTER);
		Shift.setBorder(border);
		Shift.setOpaque(true);
		Shift.setBackground(Color.white);
		Shift.addMouseListener(this);
		Shift.setBounds(new Rectangle(337, 92, 105, 25));
		this.getContentPane().add(Shift);

		Z = new JLabel("z");
		Z.setHorizontalAlignment(JLabel.CENTER);
		Z.setBorder(border);
		Z.setOpaque(true);
		Z.setBackground(Color.white);
		Z.addMouseListener(this);
		Z.setBounds(new Rectangle(2, 92, 25, 25));
		this.getContentPane().add(Z);

		X = new JLabel("x");
		X.setHorizontalAlignment(JLabel.CENTER);
		X.setBorder(border);
		X.setOpaque(true);
		X.setBackground(Color.white);
		X.addMouseListener(this);
		X.setBounds(new Rectangle(27, 92, 25, 25));
		this.getContentPane().add(X);

		C = new JLabel("c");
		C.setHorizontalAlignment(JLabel.CENTER);
		C.setBorder(border);
		C.setOpaque(true);
		C.setBackground(Color.white);
		C.addMouseListener(this);
		C.setBounds(new Rectangle(52, 92, 25, 25));
		this.getContentPane().add(C);

		V = new JLabel("v");
		V.setHorizontalAlignment(JLabel.CENTER);
		V.setBorder(border);
		V.setOpaque(true);
		V.setBackground(Color.white);
		V.addMouseListener(this);
		V.setBounds(new Rectangle(77, 92, 25, 25));
		this.getContentPane().add(V);

		BS = new JLabel("b");
		BS.setHorizontalAlignment(JLabel.CENTER);
		BS.setBorder(border);
		BS.setOpaque(true);
		BS.setBackground(Color.white);
		BS.addMouseListener(this);
		BS.setBounds(new Rectangle(102, 92, 25, 25));
		this.getContentPane().add(BS);

		N = new JLabel("n");
		N.setHorizontalAlignment(JLabel.CENTER);
		N.setBorder(border);
		N.setOpaque(true);
		N.setBackground(Color.white);
		N.addMouseListener(this);
		N.setBounds(new Rectangle(127, 92, 25, 25));
		this.getContentPane().add(N);

		M = new JLabel("m");
		M.setHorizontalAlignment(JLabel.CENTER);
		M.setBorder(border);
		M.setOpaque(true);
		M.setBackground(Color.white);
		M.addMouseListener(this);
		M.setBounds(new Rectangle(152, 92, 25, 25));
		this.getContentPane().add(M);

		FI1 = new JLabel(",");
		FI1.setHorizontalAlignment(JLabel.CENTER);
		FI1.setBorder(border);
		FI1.setOpaque(true);
		FI1.setBackground(Color.white);
		FI1.addMouseListener(this);
		FI1.setBounds(new Rectangle(177, 92, 25, 25));
		this.getContentPane().add(FI1);

		FI2 = new JLabel(".");
		FI2.setHorizontalAlignment(JLabel.CENTER);
		FI2.setBorder(border);
		FI2.setOpaque(true);
		FI2.setBackground(Color.white);
		FI2.addMouseListener(this);
		FI2.setBounds(new Rectangle(202, 92, 25, 25));
		this.getContentPane().add(FI2);
		//this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		// 鼠标进入到组件上时调用
		// 设置颜色
		if (e.getSource() == Shift) {
			Shift.setForeground(fcolor);
		}
		if (e.getSource() == Z) {
			Z.setForeground(fcolor);
		}
		if (e.getSource() == X) {
			X.setForeground(fcolor);
		}
		if (e.getSource() == C) {
			C.setForeground(fcolor);
		}
		if (e.getSource() == V) {
			V.setForeground(fcolor);
		}
		if (e.getSource() == BS) {
			BS.setForeground(fcolor);
		}
		if (e.getSource() == N) {
			N.setForeground(fcolor);
		}
		if (e.getSource() == M) {
			M.setForeground(fcolor);
		}
		if (e.getSource() == FI1) {
			FI1.setForeground(fcolor);
		}
		if (e.getSource() == FI2) {
			FI2.setForeground(fcolor);
		}
		if (e.getSource() == W) {
			W.setForeground(fcolor);
		}
		if (e.getSource() == E) {
			E.setForeground(fcolor);
		}
		if (e.getSource() == R) {
			R.setForeground(fcolor);
		}
		if (e.getSource() == T) {
			T.setForeground(fcolor);
		}
		if (e.getSource() == Y) {
			Y.setForeground(fcolor);
		}
		if (e.getSource() == U) {
			U.setForeground(fcolor);
		}
		if (e.getSource() == I) {
			I.setForeground(fcolor);
		}
		if (e.getSource() == O) {
			O.setForeground(fcolor);
		}
		if (e.getSource() == P) {
			P.setForeground(fcolor);
		}
		if (e.getSource() == Thr1) {
			Thr1.setForeground(fcolor);
		}
		if (e.getSource() == Thr2) {
			Thr2.setForeground(fcolor);
		}
		if (e.getSource() == Thr3) {
			Thr3.setForeground(fcolor);
		}
		if (e.getSource() == A) {
			A.setForeground(fcolor);
		}
		if (e.getSource() == S) {
			S.setForeground(fcolor);
		}
		if (e.getSource() == D) {
			D.setForeground(fcolor);
		}
		if (e.getSource() == F) {
			F.setForeground(fcolor);
		}
		if (e.getSource() == G) {
			G.setForeground(fcolor);
		}
		if (e.getSource() == H) {
			H.setForeground(fcolor);
		}
		if (e.getSource() == J) {
			J.setForeground(fcolor);
		}
		if (e.getSource() == K) {
			K.setForeground(fcolor);
		}
		if (e.getSource() == L) {
			L.setForeground(fcolor);
		}
		if (e.getSource() == FO1) {
			FO1.setForeground(fcolor);
		}
		if (e.getSource() == FO2) {
			FO2.setForeground(fcolor);
		}
		if (e.getSource() == FO3) {
			FO3.setForeground(fcolor);
		}
		if (e.getSource() == Caps) {
			Caps.setForeground(fcolor);
		}
		if (e.getSource() == t0) {
			t0.setForeground(fcolor);
		}
		if (e.getSource() == t1) {
			t1.setForeground(fcolor);
		}
		if (e.getSource() == t2) {
			t2.setForeground(fcolor);
		}
		if (e.getSource() == t3) {
			t3.setForeground(fcolor);
		}
		if (e.getSource() == t4) {
			t4.setForeground(fcolor);
		}
		if (e.getSource() == t5) {
			t5.setForeground(fcolor);
		}
		if (e.getSource() == t6) {
			t6.setForeground(fcolor);
		}
		if (e.getSource() == t7) {
			t7.setForeground(fcolor);
		}
		if (e.getSource() == t8) {
			t8.setForeground(fcolor);
		}
		if (e.getSource() == t9) {
			t9.setForeground(fcolor);
		}
		if (e.getSource() == t10) {
			t10.setForeground(fcolor);
		}
		if (e.getSource() == t11) {
			t11.setForeground(fcolor);
		}
		if (e.getSource() == Backspace) {
			Backspace.setForeground(fcolor);
		}
		if (e.getSource() == Q) {
			Q.setForeground(fcolor);
		}
		if (e.getSource() == W) {
			W.setForeground(fcolor);
		}
	}

	public void mouseExited(MouseEvent e) {
		// 鼠标离开组件时调用
		// 恢复颜色
		if (e.getSource() == Shift) {
			Shift.setForeground(color);
		}
		if (e.getSource() == Z) {
			Z.setForeground(color);
		}
		if (e.getSource() == X) {
			X.setForeground(color);
		}
		if (e.getSource() == C) {
			C.setForeground(color);
		}
		if (e.getSource() == V) {
			V.setForeground(color);
		}
		if (e.getSource() == BS) {
			BS.setForeground(color);
		}
		if (e.getSource() == N) {
			N.setForeground(color);
		}
		if (e.getSource() == M) {
			M.setForeground(color);
		}
		if (e.getSource() == FI1) {
			FI1.setForeground(color);
		}
		if (e.getSource() == FI2) {
			FI2.setForeground(color);
		}
		if (e.getSource() == W) {
			W.setForeground(color);
		}
		if (e.getSource() == E) {
			E.setForeground(color);
		}
		if (e.getSource() == R) {
			R.setForeground(color);
		}
		if (e.getSource() == T) {
			T.setForeground(color);
		}
		if (e.getSource() == Y) {
			Y.setForeground(color);
		}
		if (e.getSource() == U) {
			U.setForeground(color);
		}
		if (e.getSource() == I) {
			I.setForeground(color);
		}
		if (e.getSource() == O) {
			O.setForeground(color);
		}
		if (e.getSource() == P) {
			P.setForeground(color);
		}
		if (e.getSource() == Thr1) {
			Thr1.setForeground(color);
		}
		if (e.getSource() == Thr2) {
			Thr2.setForeground(color);
		}
		if (e.getSource() == Thr3) {
			Thr3.setForeground(color);
		}
		if (e.getSource() == A) {
			A.setForeground(color);
		}
		if (e.getSource() == S) {
			S.setForeground(color);
		}
		if (e.getSource() == D) {
			D.setForeground(color);
		}
		if (e.getSource() == F) {
			F.setForeground(color);
		}
		if (e.getSource() == G) {
			G.setForeground(color);
		}
		if (e.getSource() == H) {
			H.setForeground(color);
		}
		if (e.getSource() == J) {
			J.setForeground(color);
		}
		if (e.getSource() == K) {
			K.setForeground(color);
		}
		if (e.getSource() == L) {
			L.setForeground(color);
		}
		if (e.getSource() == FO1) {
			FO1.setForeground(color);
		}
		if (e.getSource() == FO2) {
			FO2.setForeground(color);
		}
		if (e.getSource() == FO3) {
			FO3.setForeground(color);
		}
		if (e.getSource() == Caps) {
			Caps.setForeground(color);
		}
		if (e.getSource() == t0) {
			t0.setForeground(color);
		}
		if (e.getSource() == t1) {
			t1.setForeground(color);
		}
		if (e.getSource() == t2) {
			t2.setForeground(color);
		}
		if (e.getSource() == t3) {
			t3.setForeground(color);
		}
		if (e.getSource() == t4) {
			t4.setForeground(color);
		}
		if (e.getSource() == t5) {
			t5.setForeground(color);
		}
		if (e.getSource() == t6) {
			t6.setForeground(color);
		}
		if (e.getSource() == t7) {
			t7.setForeground(color);
		}
		if (e.getSource() == t8) {
			t8.setForeground(color);
		}
		if (e.getSource() == t9) {
			t9.setForeground(color);
		}
		if (e.getSource() == t10) {
			t10.setForeground(color);
		}
		if (e.getSource() == t11) {
			t11.setForeground(color);
		}
		if (e.getSource() == Backspace) {
			Backspace.setForeground(color);
		}
		if (e.getSource() == Q) {
			Q.setForeground(color);
		}
		if (e.getSource() == W) {
			W.setForeground(color);
		}
	}

	@SuppressWarnings("static-access")
	public void mousePressed(MouseEvent e) {
		// 鼠标按键在组件上按下时调用
		// 监听大小写并且切换
		if (e.getSource() == Caps) {
			if (i == 1) {
				flg = true;
				W.setText("W");
				E.setText("E");
				R.setText("R");
				T.setText("T");
				Y.setText("Y");
				U.setText("U");
				I.setText("I");
				O.setText("O");
				P.setText("P");
				A.setText("A");
				S.setText("S");
				D.setText("D");
				F.setText("F");
				G.setText("G");
				H.setText("H");
				J.setText("J");
				K.setText("K");
				L.setText("L");
				Z.setText("Z");
				X.setText("X");
				C.setText("C");
				V.setText("V");
				BS.setText("B");
				N.setText("N");
				M.setText("M");
				Q.setText("Q");
				//JOptionPane.showMessageDialog(null, "注意：键盘字符已经锁定大写！");
				Caps.setText("恢复小写");
				i = 2;
			} else {
				flg = false;
				W.setText("w");
				E.setText("e");
				R.setText("r");
				T.setText("t");
				Y.setText("y");
				U.setText("u");
				I.setText("i");
				O.setText("o");
				P.setText("p");
				A.setText("a");
				S.setText("s");
				D.setText("d");
				F.setText("f");
				G.setText("g");
				H.setText("h");
				J.setText("j");
				K.setText("k");
				L.setText("l");
				Z.setText("z");
				X.setText("x");
				C.setText("c");
				V.setText("v");
				BS.setText("b");
				N.setText("n");
				M.setText("m");
				Q.setText("q");
				//JOptionPane.showMessageDialog(null, "注意：键盘字符已经锁定小写！");
				Caps.setText("大写锁定");
				i = 1;
			}
		}
		/**
		 * 监听数字与符号并且相互切换
		 * */
		if (e.getSource() == Shift) {
			if (j == 1) {
				flgs = true;
				t0.setText("!");
				t1.setText("@");
				t2.setText("#");
				t3.setText("$");
				t4.setText("%");
				t5.setText("^");
				t6.setText("&");
				t7.setText("*");
				t8.setText("(");
				t9.setText(")");
				t10.setText("_");
				t11.setText("+");
				Thr1.setText("[");
				Thr2.setText("]");
				Thr3.setText("\\");
				FO1.setText(":");
				FO2.setText("'");
				FI1.setText("<");
				FI2.setText(">");
				Shift.setText("恢复数字");
				j = 2;
			} else {
				flgs = false;
				t0.setText("0");
				t1.setText("1");
				t2.setText("2");
				t3.setText("3");
				t4.setText("4");
				t5.setText("5");
				t6.setText("6");
				t7.setText("7");
				t8.setText("8");
				t9.setText("9");
				t10.setText("-");
				t11.setText("=");
				Thr1.setText("{");
				Thr2.setText("}");
				Thr3.setText("|");
				FO1.setText(";");
				FO2.setText("”");
				FI1.setText(",");
				FI2.setText(".");
				Shift.setText("符号切换");
				j = 1;
			}
		}
		/**
		 * 设置按键的字母字符
		 * */
		if (e.getSource() == Q) {
			String s = getstring();
			miniLogin.password_field.setText(s + Q.getText());
		}
		if (e.getSource() == W) {
			String s = getstring();
			miniLogin.password_field.setText(s + W.getText());
		}
		if (e.getSource() == E) {
			String s = getstring();
			miniLogin.password_field.setText(s + E.getText());
		}
		if (e.getSource() == R) {
			String s = getstring();
			miniLogin.password_field.setText(s + R.getText());
		}
		if (e.getSource() == T) {
			String s = getstring();
			miniLogin.password_field.setText(s + T.getText());
		}
		if (e.getSource() == Y) {
			String s = getstring();
			miniLogin.password_field.setText(s + Y.getText());
		}
		if (e.getSource() == U) {
			String s = getstring();
			miniLogin.password_field.setText(s + U.getText());
		}
		if (e.getSource() == I) {
			String s = getstring();
			miniLogin.password_field.setText(s + I.getText());
		}
		if (e.getSource() == O) {
			String s = getstring();
			miniLogin.password_field.setText(s + O.getText());
		}
		if (e.getSource() == P) {
			String s = getstring();
			miniLogin.password_field.setText(s + P.getText());
		}
		if (e.getSource() == A) {
			String s = getstring();
			miniLogin.password_field.setText(s + A.getText());
		}
		if (e.getSource() == S) {
			String s = getstring();
			miniLogin.password_field.setText(s + S.getText());
		}
		if (e.getSource() == D) {
			String s = getstring();
			miniLogin.password_field.setText(s + D.getText());
		}
		if (e.getSource() == F) {
			String s = getstring();
			miniLogin.password_field.setText(s + F.getText());
		}
		if (e.getSource() == G) {
			String s = getstring();
			miniLogin.password_field.setText(s + G.getText());
		}
		if (e.getSource() == H) {
			String s = getstring();
			miniLogin.password_field.setText(s + H.getText());
		}
		if (e.getSource() == J) {
			String s = getstring();
			miniLogin.password_field.setText(s + J.getText());
		}
		if (e.getSource() == K) {
			String s = getstring();
			miniLogin.password_field.setText(s + K.getText());
		}
		if (e.getSource() == L) {
			String s = getstring();
			miniLogin.password_field.setText(s + L.getText());
		}
		if (e.getSource() == Z) {
			String s = getstring();
			miniLogin.password_field.setText(s + Z.getText());
		}
		if (e.getSource() == X) {
			String s = getstring();
			miniLogin.password_field.setText(s + X.getText());
		}
		if (e.getSource() == C) {
			String s = getstring();
			miniLogin.password_field.setText(s + C.getText());
		}
		if (e.getSource() == V) {
			String s = getstring();
			miniLogin.password_field.setText(s + V.getText());
		}
		if (e.getSource() == BS) {
			String s = getstring();
			miniLogin.password_field.setText(s + BS.getText());
		}
		if (e.getSource() == N) {
			String s = getstring();
			miniLogin.password_field.setText(s + N.getText());
		}
		if (e.getSource() == M) {
			String s = getstring();
			miniLogin.password_field.setText(s + M.getText());
		}
		/**
		 * 设置按键的符号
		 * */
		if (e.getSource() == t0) {
			String s = getstring();
			miniLogin.password_field.setText(s + t0.getText());
		}
		if (e.getSource() == t1) {
			String s = getstring();
			miniLogin.password_field.setText(s + t1.getText());
		}
		if (e.getSource() == t2) {
			String s = getstring();
			miniLogin.password_field.setText(s + t2.getText());
		}
		if (e.getSource() == t3) {
			String s = getstring();
			miniLogin.password_field.setText(s + t3.getText());
		}
		if (e.getSource() == t4) {
			String s = getstring();
			miniLogin.password_field.setText(s + t4.getText());
		}
		if (e.getSource() == t5) {
			String s = getstring();
			miniLogin.password_field.setText(s + t5.getText());
		}
		if (e.getSource() == t6) {
			String s = getstring();
			miniLogin.password_field.setText(s + t6.getText());
		}
		if (e.getSource() == t7) {
			String s = getstring();
			miniLogin.password_field.setText(s + t7.getText());
		}
		if (e.getSource() == t8) {
			String s = getstring();
			miniLogin.password_field.setText(s + t8.getText());
		}
		if (e.getSource() == t9) {
			String s = getstring();
			miniLogin.password_field.setText(s + t9.getText());
		}
		if (e.getSource() == t10) {
			String s = getstring();
			miniLogin.password_field.setText(s + t10.getText());
		}
		if (e.getSource() == t11) {
			String s = getstring();
			miniLogin.password_field.setText(s + t11.getText());
		}
		if (e.getSource() == Thr1) {
			String s = getstring();
			miniLogin.password_field.setText(s + Thr1.getText());
		}
		if (e.getSource() == Thr2) {
			String s = getstring();
			miniLogin.password_field.setText(s + Thr2.getText());
		}
		if (e.getSource() == Thr3) {
			String s = getstring();
			miniLogin.password_field.setText(s + Thr3.getText());
		}
		if (e.getSource() == FO1) {
			String s = getstring();
			miniLogin.password_field.setText(s + FO1.getText());
		}
		if (e.getSource() == FO2) {
			String s = getstring();
			miniLogin.password_field.setText(s + FO2.getText());
		}
		if (e.getSource() == FI1) {
			String s = getstring();
			miniLogin.password_field.setText(s + FI1.getText());
		}
		if (e.getSource() == FI2) {
			String s = getstring();
			miniLogin.password_field.setText(s + FI2.getText());
		}
		/**
		 * 逐个清除字符
		 * */
		if (e.getSource() == Backspace) {
			String s = getstring();
			if (s.length() > 0) {
				//System.out.println(s);
				s = s.substring(0, s.length() - 1);
				miniLogin.password_field.setText(s);
			}
		}
		/**
		 * 关闭键盘
		 * */
		if (e.getSource() == FO3) {
			this.setVisible(false);
		}
		//System.out.println(getstring());
	}

	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * <br>
	 * 返回password_field的字符串 return superstr;
	 * */
	@SuppressWarnings("static-access")
	public String getstring() {
		superstr = String.valueOf(miniLogin.password_field.getPassword());
		if ("".equals(superstr) || superstr.equals(null)) {
			superstr = "";
		}
		return superstr;
	}
}
