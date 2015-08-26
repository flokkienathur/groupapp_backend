package net.justf.groupapp.misc;

import java.util.Random;

public class NameGenerator {
	
	static String[] pre = {
		"Fo", "To", "Ma", "Lau", "La", "St", "Th"	
	};
	
	static String[] mid = {
		"lk", "m", "rijn", "r", "rs", "an", "om"
	};
	
	static String[] end = {
		"", "", "", "ert", "ens"
	};
	
	public static String randomName(){
		Random random = new Random();
		
		return pre[random.nextInt(pre.length)] + mid[random.nextInt(mid.length)] + end[random.nextInt(end.length)];
	}
}
