package com.lansmancai.lanviewer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * ���������
 */
public class ViewerFrame extends JFrame {
	// ���ö�ͼ���Ŀ�͸�
	private int width = 800;
	private int height = 600;
	// ��һ��JLabel����ͼƬ
	JLabel label = new JLabel();
	ViewerService service = ViewerService.getInstance();

	// �Ӹ��˵����¼�������
	ActionListener menuListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			service.menuDo(ViewerFrame.this, e.getActionCommand());
		}
	};

	/**
	 * ������
	 */
	public ViewerFrame() {
		super();
		// ��ʼ�����JFrame
		init();
	}

	/**
	 * ��ʼ��
	 * 
	 * @return void
	 */
	public void init() {
		// ���ñ���
		this.setTitle("��ͼ����");
		// ���ô�С
		this.setPreferredSize(new Dimension(width, height));
		// �����˵�
		createMenuBar();
		// ����������
		JPanel toolBar = createToolPanel();
		// �ѹ������Ͷ�ͼ���ӵ�JFrame����
		this.add(toolBar, BorderLayout.NORTH);
		this.add(new JScrollPane(label), BorderLayout.CENTER);
		// ����Ϊ�ɼ�
		this.setVisible(true);
		this.pack();
	}

	/**
	 * ��ȡJLabel
	 * 
	 * @return JLabel
	 */
	public JLabel getLabel() {
		return this.label;
	}

	/**
	 * ����������
	 * 
	 * @return JPanel
	 */
	public JPanel createToolPanel() {
		// ����һ��JPanel
		JPanel panel = new JPanel();
		// ����һ������Ϊ"����"�Ĺ�����
		JToolBar toolBar = new JToolBar("����");
		// ����Ϊ�����϶�
		toolBar.setFloatable(false);
		// ���ò��ַ�ʽ
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		// ��������
		String[] toolarr = { "com.lansmancai.lanviewer.action.OpenAction", 
				"com.lansmancai.lanviewer.action.LastAction", 
				"com.lansmancai.lanviewer.action.NextAction", 
				"com.lansmancai.lanviewer.action.BigAction", 
				"com.lansmancai.lanviewer.action.SmallAction" };
		for (int i = 0; i < toolarr.length; i++) {
			ViewerAction action = new ViewerAction(new ImageIcon("img/"
					+ toolarr[i] + ".gif"), toolarr[i], this);
			// ��ͼ�괴��һ���µ�button
			JButton button = new JButton(action);
			// ��button�ӵ���������
			toolBar.add(button);
		}
		panel.add(toolBar);
		// ����
		return panel;
	}

	/**
	 * �����˵���
	 * 
	 * @return void
	 */
	public void createMenuBar() {
		// ����һ��JMenuBar���ò˵�
		JMenuBar menuBar = new JMenuBar();
		// �˵��������飬�������menuItemArrһһ��Ӧ
		String[] menuArr = { "�ļ�(F)", "����(T)", "����(H)" };
		// �˵�����������
		String[][] menuItemArr = { { "��(O)", "-", "�˳�(X)" },
				{ "�Ŵ�(M)", "��С(O)", "-", "��һ��(X)", "��һ��(P)" }, { "��������", "����" } };
		// ����menuArr��menuItemArrȥ�����˵�
		for (int i = 0; i < menuArr.length; i++) {
			// �½�һ��JMenu�˵�
			JMenu menu = new JMenu(menuArr[i]);
			for (int j = 0; j < menuItemArr[i].length; j++) {
				// ���menuItemArr[i][j]����"-"
				if (menuItemArr[i][j].equals("-")) {
					// ���ò˵��ָ�
					menu.addSeparator();
				} else {
					// �½�һ��JMenuItem�˵���
					JMenuItem menuItem = new JMenuItem(menuItemArr[i][j]);
					menuItem.addActionListener(menuListener);
					// �Ѳ˵���ӵ�JMenu�˵�����
					menu.add(menuItem);
				}
			}
			// �Ѳ˵��ӵ�JMenuBar��
			menuBar.add(menu);
		}
		// ����JMenubar
		this.setJMenuBar(menuBar);
	}
}