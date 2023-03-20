package com.lansmancai.lanviewer.action;

import com.lansmancai.lanviewer.ViewerFrame;
import com.lansmancai.lanviewer.ViewerService;

/**
 * ËõÐ¡Í¼Æ¬µÄAction
 * 
 */
public class SmallAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.zoom(frame, false);
	}

}
