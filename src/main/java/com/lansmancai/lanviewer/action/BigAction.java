package com.lansmancai.lanviewer.action;

import com.lansmancai.lanviewer.ViewerFrame;
import com.lansmancai.lanviewer.ViewerService;

/**
 * ·Å´óÍ¼Æ¬µÄAction
 * 
 */
public class BigAction implements Action {

	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.zoom(frame, true);
	}

}
