package com.terry.kevin.asm.ide.editor;

import java.util.ArrayList;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

public class TKCodeScanner extends RuleBasedScanner {
	private static String[] fgkeywords = { "include", "define", "start_loop",
			"delay_outer", "delay_inner" };
	private static String[] fginstructions = { "loadi", "out", "move", "bne",
			"addi", "cpi" };

	public TKCodeScanner(TKColorProvider cp) {
		super();

		IToken keyword = new Token(new TextAttribute(
				cp.getColor(TKColorProvider.KEYWORD)));
		IToken instruction = new Token(new TextAttribute(
				cp.getColor(TKColorProvider.INSTRUCTION)));
		IToken string = new Token(new TextAttribute(
				cp.getColor(TKColorProvider.STRING)));
		IToken comment = new Token(new TextAttribute(
				cp.getColor(TKColorProvider.SINGLE_LINE_COMMENT)));
		IToken other = new Token(new TextAttribute(
				cp.getColor(TKColorProvider.DEFAULT)));

		ArrayList<IRule> rules = new ArrayList<IRule>();

		rules.add(new EndOfLineRule(";", comment));
		rules.add(new SingleLineRule("\"", "\"", string, '\\'));
		rules.add(new SingleLineRule("'", "'", string, '\\'));
		
		rules.add(new WhitespaceRule(new TKWhitespaceDetector()));
		
		WordRule wordrule = new WordRule(new TKWordDetector(), other);
		for(int i = 0;i<fgkeywords.length;i ++){
			wordrule.addWord(fgkeywords[i], keyword);
		}
		for(int i = 0;i<fginstructions.length;i ++){
			wordrule.addWord(fginstructions[i],instruction);
		}
		rules.add(wordrule);

		IRule[] result = new IRule[rules.size()];
		rules.toArray(result);
		setRules(result);
	}

}
