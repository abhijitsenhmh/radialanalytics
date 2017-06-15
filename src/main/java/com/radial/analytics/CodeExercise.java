package com.radial.analytics;


import org.apache.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeExercise {
	private static String zip_code;
	private static int num_facilities = 20;
	private static int min_overall_rating = -1; //If this remains -1 that means it was not supplied
	private static int argumentCount = 0;

	public static void main(String[] args) {
		SpringApplication.run(CodeExercise.class, args);
		System.out.println("args length = " + args.length);
		if (args.length == 0){
			System.out.println("Zip Code is a required command line argument");
		}else{
			for (String arg: args){
				System.out.println("Arg " + argumentCount + " = " +  arg);
				switch(argumentCount){
					case 0:
						//Check if 5 digit
						if (arg.length() != 5){
							System.out.println("Zip code has to be 5 digits");
						}else{
							//ONLY digits allowed
							if (arg.matches("\\d{5}")){
								zip_code = arg;
							}else{
								System.out.println("Zip code should ONLY contain digits");
							}
						}
						break;
						
					case 1:
						if (StringUtils.isNumeric(arg)){
							num_facilities = Integer.parseInt(arg);
						}else{
							System.out.println("Number of facilities needs to be a number");
						}
						break;
					
					case 2:
						if (StringUtils.isNumeric(arg)){
							min_overall_rating = Integer.parseInt(arg);
							if (!((min_overall_rating >=1) && (min_overall_rating <=5))){
								System.out.println("Minimum overall rating should be a number between 1 and 5");
							}
						}else{
							System.out.println("Minimum overall rating should be a number");
						}
						break;

					default:
						break;
				}
				argumentCount++;
			}			
		}
		
		System.exit(0);
	}
}
