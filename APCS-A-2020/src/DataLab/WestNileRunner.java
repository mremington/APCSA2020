package DataLab;

import java.util.ArrayList;
import java.util.Scanner;

import core.data.DataSource;

public class WestNileRunner {

	public static void main(String[] args) {

		DataSource ds = DataSource.connect("https://data.cdc.gov/api/views/r7hc-32zu/rows.xml").load();

		ds.printUsageString();

		ArrayList<WestNile> allAreas = ds.fetchList(WestNile.class, "row/row/reporting_area",
				"row/row/west_nile_virus_disease_neuroinvasive_previous_52_weeks_max");
		System.out.println("Total Areas: " + allAreas.size());

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a state abbreviation: ");
		String state = sc.next();
		int max = 0;
		for (WestNile wn : allAreas) {
			if (wn.getArea().equalsIgnoreCase(state)) {
				if (wn.getVirusTotal() > max)
					max = wn.getVirusTotal();
			}
		}

		System.out.println(
				"The max number of WestNile Virus cases in the state of: " + state.toUpperCase() + " is: " + max);

	}

}
