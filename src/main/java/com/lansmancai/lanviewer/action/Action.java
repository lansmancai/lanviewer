package com.lansmancai.lanviewer.action;

import com.lansmancai.lanviewer.ViewerFrame;
import com.lansmancai.lanviewer.ViewerService;

/**
 * 图片浏览器的Action接口
 * 
 */
public interface Action {
	/**
	 * 具体执行的方法
	 * @param service 图片浏览器的业务处理类
	 * @param frame 主界面对象
	 */
	void execute(ViewerService service, ViewerFrame frame);
}
