package ExamPrep;

public class Practice1_2 {
	
	private int[] rateTable = {50,60,160,60,80,100,100,120,150,150,150,200,40,240,220,220,200,200,180,180,140,100,80,60};
	
	public int getChargingCost(int startHour, int chargeTime) {
		
		int endHour = startHour + chargeTime;
		int cost = 0;
		
		if(endHour > rateTable.length) {
				for(int i=startHour; i <  rateTable.length; i++) {
					cost += rateTable[i];
					chargeTime--;
				}
				while(chargeTime > 24) {
					for(int i=0; i <  rateTable.length; i++) {
						cost += rateTable[i];
						chargeTime--;
					}
				}
				if(chargeTime > 0) {
					for(int i=0; i < chargeTime; i++) {
						cost += rateTable[i];
					}
				}
				return cost;
		}
		else {
			for(int i=startHour; i < endHour; i++) {
				cost += rateTable[i];
			}
			return cost;
		}
			
	}

}
