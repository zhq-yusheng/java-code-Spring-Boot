
package com.exception;
 
@SuppressWarnings("all")
public class CustomException extends Exception {
		private String message;
		
		public CustomException(String message) {
			this.message=message;
		}
 
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
}
