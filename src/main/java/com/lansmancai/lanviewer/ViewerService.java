package com.lansmancai.lanviewer;

import javax.swing.ImageIcon;
import java.awt.*;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * ͼƬ�����ҵ����
 * 
 */
public class ViewerService {
	private static ViewerService service = null;
	// �½�һ��ViewerFileChooser
	private ViewerFileChooser fileChooser = new ViewerFileChooser();
	// �Ŵ������С�ı���
	private double range = 0.2;
	// Ŀǰ���ļ���
	private File currentDirectory = null;
	// Ŀǰ�ļ����µ�����ͼƬ�ļ�
	private List<File> currentFiles = null;
	// ĿǰͼƬ�ļ�
	private File currentFile = null;

	/**
	 * ˽�й�����
	 */
	private ViewerService() {
	}

	/**
	 * ��ȡ��̬ʵ��
	 * 
	 * @return ViewerService
	 */
	public static ViewerService getInstance() {
		if (service == null) {
			service = new ViewerService();
		}
		return service;
	}

	/**
	 * ��ͼƬ
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @return void
	 */
	public void open(ViewerFrame frame) {
		// ���ѡ���
		if (fileChooser.showOpenDialog(frame) == ViewerFileChooser.APPROVE_OPTION) {
			// ��Ŀǰ�򿪵��ļ���ֵ
			this.currentFile = fileChooser.getSelectedFile();
			// ��ȡ�ļ�·��
			String name = this.currentFile.getPath();
			//System.out.println(name);
			// ��ȡĿǰ�ļ���
			File cd = fileChooser.getCurrentDirectory();
			//System.out.println(cd.getName());
			// ����ļ����иı�
			if (cd != this.currentDirectory || this.currentDirectory == null) {
				// ����fileChooser������FileFilter
				FileFilter[] fileFilters = fileChooser
						.getChoosableFileFilters();
				File files[] = cd.listFiles();
				this.currentFiles = new ArrayList<File>();
				for (File file : files) {
					for (FileFilter filter : fileFilters) {
						// �����ͼƬ�ļ�
						if (filter.accept(file)) {
							// ���ļ��ӵ�currentFiles��
							this.currentFiles.add(file);
							//System.out.println("for--loop--begin");
							//System.out.println(file.getName());
							//System.out.println(this.currentFiles.size());
							//System.out.println("for--loop--end");
						}
					}
				}
			}
			ImageIcon icon = new ImageIcon(name);
			frame.getLabel().setIcon(icon);
		}
	}

	/**
	 * �Ŵ���С
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @return void
	 */
	public void zoom(ViewerFrame frame, boolean isEnlarge) {
		// ��ȡ�Ŵ������С�ĳ˱�
		double enLargeRange = isEnlarge ? 1 + range : 1 - range;
		// ��ȡĿǰ��ͼƬ
		ImageIcon icon = (ImageIcon) frame.getLabel().getIcon();
		if (icon != null) {
			int width = (int) (icon.getIconWidth() * enLargeRange);
			// ��ȡ�ı��С���ͼƬ
			ImageIcon newIcon = new ImageIcon(icon.getImage()
					.getScaledInstance(width, -1, Image.SCALE_DEFAULT));
			// �ı���ʾ��ͼƬ
			frame.getLabel().setIcon(newIcon);
		}
	}

	/**
	 * ��һ��
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @return void
	 */
	public void last(ViewerFrame frame) {
		// ����д򿪰���ͼƬ���ļ���
		if (this.currentFiles != null && !this.currentFiles.isEmpty()) {
			int index = this.currentFiles.indexOf(this.currentFile);
			//System.out.println(index);
			// ����һ��
			if (index > 0) {
				File file = (File) this.currentFiles.get(index - 1);
				ImageIcon icon = new ImageIcon(file.getPath());
				frame.getLabel().setIcon(icon);
				this.currentFile = file;

			}
			else {
				Dialog dialog = new Dialog(frame, "��ʾ��Ϣ", false);
				dialog.setBounds(100, 100, 400, 200); 
				dialog.setLayout(new GridLayout(2, 1));
				Label lb = new Label("       û����һ��");
				JButton okbut = new JButton("ȷ��");
				okbut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
				}
			    });
				dialog.add(lb);
				dialog.add(okbut);
				dialog.setVisible(true);
				dialog.pack();
			}
		}
	}

	/**
	 * ��һ��
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @return void
	 */
	public void next(ViewerFrame frame) {
		// ����д򿪰���ͼƬ���ļ���
		if (this.currentFiles != null && !this.currentFiles.isEmpty()) {
			Collections.sort(this.currentFiles);
			int index = this.currentFiles.indexOf(this.currentFile);
			//System.out.println(index);
			//File file1 = (File) this.currentFiles.get(index);
			//System.out.println(file1.getPath());
			// ����һ��
			if (index + 1  < this.currentFiles.size()) {
				//System.out.println(index + 1);
				File file = (File) this.currentFiles.get(index + 1);
				ImageIcon icon = new ImageIcon(file.getPath());
				//System.out.println(file.getPath());
				frame.getLabel().setIcon(icon);
				this.currentFile = file;
			}
			else {
				//System.out.println("no next");
				Dialog dialog = new Dialog(frame, "��ʾ��Ϣ", false);
				dialog.setBounds(100, 100, 400, 200); 
				dialog.setLayout(new GridLayout(2, 1));
				Label lb = new Label("       û����һ��");
				JButton okbut = new JButton("ȷ��");
				okbut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
				}
			    });
				dialog.add(lb);
				dialog.add(okbut);
				dialog.setVisible(true);
				dialog.pack();
			}
		}
	}

	/**
	 * ��Ӧ�˵��Ķ���
	 * 
	 * @param frame
	 *            ViewerFrame
	 * @param cmd
	 *            String
	 * @return void
	 */
	public void menuDo(ViewerFrame frame, String cmd) {
		// ��
		if (cmd.equals("��(O)")) {
			open(frame);
		}
		// �Ŵ�
		if (cmd.equals("�Ŵ�(M)")) {
			zoom(frame, true);
		}
		// ��С
		if (cmd.equals("��С(O)")) {
			zoom(frame, false);
		}
		// ��һ��
		if (cmd.equals("��һ��(X)")) {
			last(frame);
		}
		// ��һ��
		if (cmd.equals("��һ��(P)")) {
			next(frame);
		}
		// �˳�
		if (cmd.equals("�˳�(X)")) {
			System.exit(0);
		}
	}
}