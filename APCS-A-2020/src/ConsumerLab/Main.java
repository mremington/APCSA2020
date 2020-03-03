package ConsumerLab;

public class Main {
  public static void main(String[] args)
  {
    System.out.println(Review.totalSentiment("src/ConsumerLab/SimpleReview.txt")); 
    //The above line prints -2.9200000000000004
    
    System.out.println(Review.starRating("src/ConsumerLab/SimpleReview.txt")); 
    //The above line prints 1
    
    System.out.println(Review.totalSentiment2("src/ConsumerLab/SimpleReview.txt"));
    //The above line prints -0.13904761904761906
    
     System.out.println(Review.totalSentiment("src/ConsumerLab/26WestReview.txt")); 
    //The above line prints 29.04999999999999
    
     System.out.println(Review.starRating("src/ConsumerLab/26WestReview.txt")); 
    //The above line prints 4
     
  }
}