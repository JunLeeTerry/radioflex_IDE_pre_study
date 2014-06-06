package com.asmide.junlee.ui.editor;

import java.util.ArrayList;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

public class ASMCodeScanner extends RuleBasedScanner{
	private static String[] fgkeywords = {"include","define","start_loop","delay_inner"};
	private static String[] fginstructions = {"loadi","out","move","bne","addi","cpi"};
	
	public ASMCodeScanner(ASMColorProvider colorProvider) {
		IToken keyword = new Token(
				new TextAttribute(colorProvider.getColor(ASMColorProvider.KEYWORD)));
		IToken instruction = new Token(
				new TextAttribute(colorProvider.getColor(ASMColorProvider.INSTRUCTION)));
		IToken other = new Token(
				new TextAttribute(colorProvider.getColor(ASMColorProvider.DEFAULT)));
		
		ArrayList<IRule> rules = new ArrayList<IRule>();
	
		rules.add(new WhitespaceRule(new MyWhitespaceDetector()));
		
		WordRule wordRule = new WordRule(new MyWordDecetor(),other);
		for(int i=0;i<fgkeywords.length;i++) {
			wordRule.addWord(fgkeywords[i], keyword);
		}
		for (int i=0;i<fginstructions.length;i++) {
			wordRule.addWord(fginstructions[i], instruction);
		}
		rules.add(wordRule);
		
		IRule[] result = new IRule[rules.size()];
		rules.toArray(result);
		System.out.println("ASMCodeScanner is constructed!");
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
		setRules(result);
	}
}