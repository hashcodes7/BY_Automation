package com.WMS_Utilities;

import java.io.File;
import java.io.IOException;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WMS_Message_Utilities extends WMS_TestBase{

	String strinfix;
	String strpostfix;
	String PostFix=null;
	String HoldSeed=null;
	private String strPrevSeed;
	
	//get operator position
	public int getOpPos(String infix ) {
		int pos=0;
		while(pos < infix.length()-1) {
			if((!Character.isLetterOrDigit(infix.charAt(pos))) && Character.isLetterOrDigit(infix.charAt(pos-1)) && Character.isLetterOrDigit(infix.charAt(pos+1))) {
				break;
			}
			pos++;
		}
		return pos;
	}
	
	//replace brackets with null string when most expressions are replaced by seeds
	//this also sets the operation precedence as per the purpose as set by user
	public String innerBrReplace(String infix,String OpBr, String ClBr) {
		int pos=0;
		while(pos<infix.length()) {
			
			if((""+infix.charAt(pos)).equals(ClBr) && Character.isLetterOrDigit(infix.charAt(pos-1))) {
				
				if((pos<infix.length()-1)) {
					infix=infix.substring(0, pos)+infix.substring(pos+1);
				}else {
					infix=infix.substring(0, pos);
					pos=pos-1;
				}
					
				
				if(!(""+infix.charAt(pos)).equals(ClBr)){
					pos=pos-1;
				}
			}else {
				if((""+infix.charAt(pos)).equals(OpBr) && Character.isLetterOrDigit(infix.charAt(pos+1))) {
					infix=infix.substring(0, pos)+infix.substring(pos+1);
					pos=pos-1;
				}
			}
			
			pos++;
		}
		return infix;
	}
	
	
	// This is just a reference fn for conversion from infix to postfix
	// Ideally best suited for normal mathematical operations only
	// not to be used for current purpose of message creation
	// kept because it has been done differently (reusing features of java recursion only)
	public String covertInfixtoPostfix(String infix,int seed) {
		boolean returnValue=false;
		if((infix.length()-1)<=getOpPos(infix)){
			if(infix.contains("(")) {
				infix=innerBrReplace(infix,"(",")");
			}else if(infix.contains("{")) {
				infix=innerBrReplace(infix,"{","}");
			}else if(infix.contains("[")) {
				infix=innerBrReplace(infix,"[","]");
			}else {
				returnValue=true;
			}
		}
		if(getOpPos(infix) < infix.length()-1) {
			String strPrevTkn = getPrevToken(infix,getOpPos(infix));
			String strNextTkn = getNextToken(infix,getOpPos(infix));
			String operator=""+infix.charAt(getOpPos(infix));
			seed++;
			
			String strSeed="T"+Integer.toString(seed);
			infix=infix.replace(strPrevTkn+operator+strNextTkn,strSeed);
			strPrevSeed = "T"+Integer.toString(seed-1);
			//PostFix=infix.replace(strSeed," "+strPrevTkn+" "+strNextTkn+" "+operator);
			PostFix=strSeed;
		
			if(!returnValue) {
				PostFix=covertInfixtoPostfix(infix,seed);			
			    PostFix=PostFix.replace(strSeed," "+strPrevTkn+" "+strNextTkn+" "+operator);
			}
		}
		//PostFix=infix.replace(strSeed," "+strPrevTkn+" "+strNextTkn+" "+operator);
		return PostFix;
	}
	
	// This is used for evaluation and creation of message from user provided infix
	// to be used for current purpose of message creation
	// has been done differently (reusing features of java recursion only)
	public String returnMessagefromInfix(String infix,int seed) {
		String strFinalMessage= null;
		boolean returnValue=false;
		if((infix.length()-1)<=getOpPos(infix)){
			if(infix.contains("(")) {
				infix=innerBrReplace(infix,"(",")");
			}else if(infix.contains("{")) {
				infix=innerBrReplace(infix,"{","}");
			}else if(infix.contains("[")) {
				infix=innerBrReplace(infix,"[","]");
			}else {
				returnValue=true;
			}
		}
		if(getOpPos(infix) < infix.length()-1) {
			String strPrevTkn = getPrevToken(infix,getOpPos(infix));
			String strNextTkn = getNextToken(infix,getOpPos(infix));
			String operator=""+infix.charAt(getOpPos(infix));
			seed++;
			
			String strSeed="T"+Integer.toString(seed);
			infix=infix.replace(strPrevTkn+operator+strNextTkn,strSeed);
			
			strFinalMessage =Eval(strFinalMessage,strPrevTkn,strNextTkn,operator,strSeed);
			//String strPrevSeed = "T"+Integer.toString(seed-1);
			//PostFix=infix.replace(strSeed," "+strPrevTkn+" "+strNextTkn+" "+operator);
			HoldSeed=strSeed;
		
			if(!returnValue) {
				
				strFinalMessage=returnMessagefromInfix(infix,seed);
				//PostFix=returnMessagefromInfix(infix,seed);			
				HoldSeed=HoldSeed.replace(strSeed," "+strPrevTkn+" "+strNextTkn+" "+operator);
				//HoldSeed=HoldSeed.replace(strSeed,strFinalMessage);
			}
		}
		//PostFix=infix.replace(strSeed," "+strPrevTkn+" "+strNextTkn+" "+operator);
		//return PostFix;
		return strFinalMessage;
	}
	
	//Interim Hashmap creation
	public String Eval(String strFinalMessage,String strPrevTkn,String strNextTkn,String operator,String strIdSeed) {
		return "("+strPrevTkn+" "+strNextTkn+" "+operator+")";
		
		
	}
	
	//get previous operand
	public String getPrevToken(String infix,int pos) {
		String PrevToken="";
		
		while(--pos>=0 && Character.isLetterOrDigit(infix.charAt(pos))) {
			PrevToken = infix.charAt(pos) + PrevToken;
		};
		
		return PrevToken;
	}
	
	//get next operand
	public String getNextToken(String infix,int pos) {
		String NextToken="";
		
		while(++pos<infix.length() && Character.isLetterOrDigit(infix.charAt(pos))) {
			NextToken = NextToken + infix.charAt(pos);
		};
		
		return NextToken;
	}
	
}
