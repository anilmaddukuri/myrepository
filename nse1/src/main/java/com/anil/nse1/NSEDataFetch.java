package com.anil.nse1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NSEDataFetch {
	
	public List<Double> fetchData(int strike, String optionType, String from, String to, String expiry) {
		List<Double> toReturn = new ArrayList<Double>();
		String url = "https://www.nseindia.com/products/dynaContent/common/productsSymbolMapping.jsp?instrumentType=OPTIDX&symbol=NIFTY&segmentLink=9";
		url += "&optionType=" + optionType + "&strikePrice=" + strike + "&dateRange=&fromDate=" + from + "&toDate=" + to + "&expiryDate=" + expiry;
		
		try {
			Document doc = Jsoup.connect(url).get();
			Element table = doc.select("table").get(0);
			Elements rows = table.select("tr");
			for (int i = 2; i < rows.size(); i++) {
				Element row = rows.get(i);
				Elements cols = row.select("td");
				/*for (int j = 0; j < cols.size(); j++) {
					System.out.print(cols.get(j).text() + "\t");
				}*/
				toReturn.add(Double.parseDouble(cols.get(8).text()));
				System.out.println(cols.get(8).text());
				
			}
			System.out.println("Total size of the rows fetched from NSE : " + (rows.size()-2));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

}
