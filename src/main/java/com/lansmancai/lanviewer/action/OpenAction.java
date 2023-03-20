package com.lansmancai.lanviewer.action;

import com.lansmancai.lanviewer.ViewerFrame;
import com.lansmancai.lanviewer.ViewerService;

/**
 * 打开图片文件的Action
 * 
 */
public class OpenAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.open(frame);
	}

}
