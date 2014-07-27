package com.goose.spring.spel.test;

import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class RandomText {
	
	private static String[] texts = {
		"I'll be back",
		"Talk to the hand",
		"I lied.",
		null
	};
	
	
	public String getText() {
		Random random = new Random();
		return texts[random.nextInt(texts.length)];
	}
	
}
