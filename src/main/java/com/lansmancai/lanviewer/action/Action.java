package com.lansmancai.lanviewer.action;

import com.lansmancai.lanviewer.ViewerFrame;
import com.lansmancai.lanviewer.ViewerService;

/**
 * ͼƬ�������Action�ӿ�
 * 
 */
public interface Action {
	/**
	 * ����ִ�еķ���
	 * @param service ͼƬ�������ҵ������
	 * @param frame ���������
	 */
	void execute(ViewerService service, ViewerFrame frame);
}
