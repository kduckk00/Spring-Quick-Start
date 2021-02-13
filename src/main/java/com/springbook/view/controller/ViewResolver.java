package com.springbook.view.controller;

public class ViewResolver {
	public String prefix;
	public String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) { // Controller가 리턴한 View 이름에 접두사, 접미사 결합
		return prefix + viewName + suffix; // 최종으로 실행될 View경로와 파일명 완성
	}
}
