package com.nt.Dto;

public class ForgotPassDto {
		private String userName;
		private String password;
		private String confirmPassword;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		@Override
		public String toString() {
			return "ForgotPassDto [userName=" + userName + ", password=" + password + ", confirmPassword="
					+ confirmPassword + ", getUserName()=" + getUserName() + ", getPassword()=" + getPassword()
					+ ", getConfirmPassword()=" + getConfirmPassword() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}
		
		
		
		
		
		
}
