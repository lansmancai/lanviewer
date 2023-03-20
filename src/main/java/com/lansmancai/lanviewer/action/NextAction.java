package com.lansmancai.lanviewer.action;

import com.lansmancai.lanviewer.ViewerFrame;
import com.lansmancai.lanviewer.ViewerService;

/**
 * 下一张图片的Action
 * 
 */
public class NextAction implements Action {

	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.next(frame);
	}

}
