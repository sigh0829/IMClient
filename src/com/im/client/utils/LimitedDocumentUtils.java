package com.im.client.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/** 
* CopyRright (c)2013:	InstantMessage                          
* Project:				InstantMessageClient                                          
* Module ID:			1    
* Comments:  			设置输入框最大长度及输入类型                                         
* JDK version used:		JDK 1.7                              
* NameSpace:			com.im.client.utils                        
* Author：				Ellery                 
* Create Date：			2011-04-03 23:31 
* Modified By：			                                        
* Modified Date:		                                    
* Why&What is modified:    
* Version:				0.1                       
*/ 

@SuppressWarnings("serial")
public class LimitedDocumentUtils extends PlainDocument {

	private int _maxLength = -1;

	private String _allowCharAsString = null;

	public LimitedDocumentUtils() {
		super();
	}

	public LimitedDocumentUtils(int maxLength) {
		super();
		this._maxLength = maxLength;
	}

	public void insertString(int offset, String str, AttributeSet attrSet)
			throws BadLocationException {

		if (str == null) {
			return;
		}

		if (_allowCharAsString != null && str.length() == 1) {
			if (_allowCharAsString.indexOf(str) == -1) {
				return;
			}
		}

		char[] charVal = str.toCharArray();
		String strOldValue = getText(0, getLength());
		byte[] tmp = strOldValue.getBytes();

		if (_maxLength != -1 && (tmp.length + charVal.length > _maxLength)) {
			return;
		}

		super.insertString(offset, str, attrSet);
	}

	public void setAllowChar(String str) {
		_allowCharAsString = str;
	}
}
