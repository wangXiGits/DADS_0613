package com.cloud.mina.server;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.cloud.mina.util.DownLoadUtil;

public class Test {

	public static void main(String[] args) {

		HttpServletResponse response = new HttpServletResponse() {

			public void setLocale(Locale arg0) {
				// TODO Auto-generated method stub

			}

			public void setContentType(String arg0) {
				// TODO Auto-generated method stub

			}

			public void setContentLength(int arg0) {
				// TODO Auto-generated method stub

			}

			public void setCharacterEncoding(String arg0) {
				// TODO Auto-generated method stub

			}

			public void setBufferSize(int arg0) {
				// TODO Auto-generated method stub

			}

			public void resetBuffer() {
				// TODO Auto-generated method stub

			}

			public void reset() {
				// TODO Auto-generated method stub

			}

			public boolean isCommitted() {
				// TODO Auto-generated method stub
				return false;
			}

			public PrintWriter getWriter() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			public ServletOutputStream getOutputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			public Locale getLocale() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}

			public String getCharacterEncoding() {
				// TODO Auto-generated method stub
				return null;
			}

			public int getBufferSize() {
				// TODO Auto-generated method stub
				return 0;
			}

			public void flushBuffer() throws IOException {
				// TODO Auto-generated method stub

			}

			public void setStatus(int arg0, String arg1) {
				// TODO Auto-generated method stub

			}

			public void setStatus(int arg0) {
				// TODO Auto-generated method stub

			}

			public void setIntHeader(String arg0, int arg1) {
				// TODO Auto-generated method stub

			}

			public void setHeader(String arg0, String arg1) {
				// TODO Auto-generated method stub

			}

			public void setDateHeader(String arg0, long arg1) {
				// TODO Auto-generated method stub

			}

			public void sendRedirect(String arg0) throws IOException {
				// TODO Auto-generated method stub

			}

			public void sendError(int arg0, String arg1) throws IOException {
				// TODO Auto-generated method stub

			}

			public void sendError(int arg0) throws IOException {
				// TODO Auto-generated method stub

			}

			public String encodeUrl(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public String encodeURL(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public String encodeRedirectUrl(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public String encodeRedirectURL(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			public boolean containsHeader(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			public void addIntHeader(String arg0, int arg1) {
				// TODO Auto-generated method stub

			}

			public void addHeader(String arg0, String arg1) {
				// TODO Auto-generated method stub

			}

			public void addDateHeader(String arg0, long arg1) {
				// TODO Auto-generated method stub

			}

			public void addCookie(Cookie arg0) {
				// TODO Auto-generated method stub

			}
		};
		File file = new File("d:/code/haha.txt");
		String filename = "haha.txt";
		System.out.println(DownLoadUtil.downLoadFile(response, filename, file));
		;

	}
}
