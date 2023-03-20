package com.lansmancai.lanviewer;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * �ļ��Ի������
 * 
 */
public class ViewerFileChooser extends JFileChooser {
	/**
	 * ʹ���û�Ĭ��·������һ��ImageFileChooser
	 * 
	 * @return void
	 */
	public ViewerFileChooser() {
		super();
		setAcceptAllFileFilterUsed(false);
		addFilter();
	}

	/**
	 * ʹ���Զ����·��·������һ��ViewerFileChooser
	 * 
	 * @param currentDirectoryPath
	 *            String �Զ���·��
	 * @return void
	 */
	public ViewerFileChooser(String currentDirectoryPath) {
		super(currentDirectoryPath);
		setAcceptAllFileFilterUsed(false);
		addFilter();
	}

	/**
	 * �����ļ�������
	 * 
	 * @return void
	 */
	private void addFilter() {
		this.addChoosableFileFilter(new MyFileFilter(new String[] { ".BMP",
				".JPG", ".JPEG", ".JPE", ".JFIF", ".GIF", ".TIF", ".TIFF",
				".PNG", ".ICO" }, "����ͼ���ļ�"));
	}

	class MyFileFilter extends FileFilter {
		// ��׺������
		String[] suffarr;
		// ����
		String decription;

		public MyFileFilter() {
			super();
		}

		/**
		 * �ð�����׺������������������һ��MyFileFilter
		 * 
		 * @param suffarr
		 *            String[]
		 * @param decription
		 *            String
		 * @return void
		 */
		public MyFileFilter(String[] suffarr, String decription) {
			super();
			this.suffarr = suffarr;
			this.decription = decription;
		}

		/**
		 * ��дboolean accept( File f )����
		 * 
		 * @paream f File
		 * @return boolean
		 */
		public boolean accept(File f) {
			// ����ļ��ĺ�׺���Ϸ�������true
			for (String s : suffarr) {
				if (f.getName().toUpperCase().endsWith(s)) {
					return true;
				}
			}
			// �����Ŀ¼������true,���߷���false
			return f.isDirectory();
		}

		/**
		 * ��ȡ������Ϣ
		 * 
		 * @return String
		 */
		public String getDescription() {
			return this.decription;
		}
	}

}