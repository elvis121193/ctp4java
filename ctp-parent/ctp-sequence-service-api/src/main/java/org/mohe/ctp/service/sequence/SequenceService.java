package org.mohe.ctp.service.sequence;

/**
 * 获取一个全局唯一的序列号服务类
 * @author Elvis
 *
 */
public interface SequenceService {

	/**
	 * 获取序列号
	 * @return
	 */
	public Integer getSequence();
}
