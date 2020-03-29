package ConsumerLab;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println(Review.totalSentiment("src/ConsumerLab/SimpleReview.txt"));
		// The above line prints -2.9200000000000004

		System.out.println(Review.starRating("src/ConsumerLab/SimpleReview.txt"));
		// The above line prints 1

		System.out.println(Review.totalSentiment2("src/ConsumerLab/SimpleReview.txt"));
		// The above line prints -0.13904761904761906

		System.out.println(Review.totalSentiment("src/ConsumerLab/26WestReview.txt"));
		// The above line prints 29.04999999999999

		System.out.println(Review.starRating("src/ConsumerLab/26WestReview.txt"));
		// The above line prints 4

	}

//
//class Main {
//	public static void main(String[] args) {
//
//		System.out.println(Review.sentimentVal("Happy"));
//		
//		// test reading from files
//		// read in the positive adjectives in postiveAdjectives.txt
//		try {
//			Scanner input = new Scanner(new File("src/ConsumerLab/positiveAdjectives.txt"));
//			while (input.hasNextLine()) {
//				String temp = input.nextLine().trim();
//				System.out.println(temp);
//
//			}
//			input.close();
//		} catch (Exception e) {
//			System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
//		}
//
//	}

}