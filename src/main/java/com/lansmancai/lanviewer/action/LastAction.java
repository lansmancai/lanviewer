package com.lansmancai.lanviewer.action;

import com.lansmancai.lanviewer.ViewerFrame;
import com.lansmancai.lanviewer.ViewerService;


/**
 * 上一张图片的Action
 * 
 */
public class LastAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.last(frame);
	}

}
