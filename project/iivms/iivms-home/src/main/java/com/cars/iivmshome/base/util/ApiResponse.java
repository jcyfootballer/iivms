package com.cars.iivmshome.base.util;

import com.google.common.base.Strings;

import java.io.Serializable;

/**
 * API 响应格式 /** 响应为：
 * 
 * <pre>
 * {
 * "status": 200,
 * "message": "\u767b\u5f55\u6210\u529f",
 * "data": {
 * "uid": "10216497",
 * "profile": "18751986615",
 * "session_key": "fa31d3a5d069c6c98cd8c38c3a5f89e6",
 * "vip": 0
 * },
 * }
 * @author Administrator
 */
public class ApiResponse implements Serializable{

	private static final long serialVersionUID = -1223404494339625553L;
	
	private static String DEFAULT_MSG = "操作成功";
	public static int DEFAULT_CODE = 0;
	public static int DEFAULT_SUCCESS_CODE = 200;

	public static final ApiResponse SUCCESS = new ApiResponse();

	private int status;
	private String msg;
	private Object data;

	public ApiResponse() {
		this(DEFAULT_SUCCESS_CODE, DEFAULT_MSG, null);
	}

	public ApiResponse(int status, String message, Object data) {
		this.setStatus(status);
		if (!Strings.isNullOrEmpty(message)) {
			this.setMsg(message);
		}
		this.data = data;
	}


	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 构造响应。 使用方式：
	 * <p/>
	 * 
	 * <pre>
	 * ApiResponse.ApiResponseBuilder builder = new ApiResponse.ApiResponseBuilder();
	 * ApiResponse apiResponse = builder.status(200).msg(&quot;coupons total&quot;)
	 * 		.data(new Total(&quot;0&quot;)).build();
	 * </pre>
	 */
	public static class ApiResponseBuilder {
		ApiResponse apiResponse;

		public ApiResponseBuilder() {
			apiResponse = new ApiResponse();
		}

		/**
		 * 设置错误码。默认200
		 *
		 * @param code
		 *            错误码
		 * @return ApiResponseBuilder
		 */
		public ApiResponseBuilder status(int code) {
			apiResponse.status = code;
			return this;
		}

		/**
		 * 设置消息。默认[操作成功]
		 *
		 * @param message
		 *            错误消息
		 * @return ApiResponseBuilder
		 */
		public ApiResponseBuilder msg(String message) {
			apiResponse.msg = message;
			return this;
		}

		/**
		 * 设置响应的具体内容
		 *
		 * @param data
		 *            响应的具体内容
		 * @return 内容
		 */
		public ApiResponseBuilder data(Object data) {
			apiResponse.data = data;
			return this;
		}

		/**
		 * 构造响应
		 *
		 * @return 响应
		 */
		public ApiResponse build() {
			// 参数校验, 并且设置默认值
			if (this.apiResponse.status <= 0) {
				this.apiResponse.status = DEFAULT_CODE;
			}
			if (Strings.isNullOrEmpty(apiResponse.msg)) {
				this.apiResponse.msg = DEFAULT_MSG;
			}

			return apiResponse;
		}

	}

}
