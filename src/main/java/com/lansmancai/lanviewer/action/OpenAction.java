package com.lansmancai.lanviewer.action;

import com.lansmancai.lanviewer.ViewerFrame;
import com.lansmancai.lanviewer.ViewerService;

/**
 * ��ͼƬ�ļ���Action
 * 
 */
public class OpenAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.open(frame);
	}

}
