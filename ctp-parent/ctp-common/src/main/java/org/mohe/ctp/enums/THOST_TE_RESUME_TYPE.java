package org.mohe.ctp.enums;

public enum THOST_TE_RESUME_TYPE {
	/** 从本交易日开始重传 */
	THOST_TERT_RESTART(0, "从本交易日开始重传"),
	/** 从上次收到的续传 */
	THOST_TERT_RESUME(1, "从上次收到的续传 "),
	/** 只传送登录后公共流的内容 */
	THOST_TERT_QUICK(2, "只传送登录后公共流的内容 ");

	private int code;

	private String name;

	THOST_TE_RESUME_TYPE(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
