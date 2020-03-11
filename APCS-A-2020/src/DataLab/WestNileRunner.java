package DataLab;

import java.util.ArrayList;

import core.data.DataSource;

public class WestNileRunner {

	public static void main(String[] args) {

		DataSource ds = DataSource.connect("https://data.cdc.gov/api/views/r7hc-32zu/rows.xml").load();
	      ArrayList<WestNile> allAreas = ds.fetchList(WestNile.class, "response/row/row_id/reporting_area", "response/row/row/row_id/west_nile_virus_disease_neuroinvasive_previous_52_weeks_max");
	      System.out.println("Total Areas: " + allAreas.size());

	}

}
