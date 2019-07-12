package com.inexture.stack;

import java.util.List;

public interface StackInterface {
	
	public void pushElement(List<Integer> stack);
	
	public void pushElement(List<Integer> stack, int element, int position);
	
	public void popElement(List<Integer> stack);
	
	public void peakElement(List<Integer> stack);
	
	public void printStack(List<Integer> stack);
	
}
