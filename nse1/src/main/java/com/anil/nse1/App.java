package com.anil.nse1;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://www.nseindia.com/products/dynaContent/common/productsSymbolMapping.jsp?instrumentType=OPTIDX&symbol=NIFTY&expiryDate=30-06-2016&optionType=CE&strikePrice=8300&dateRange=&fromDate=01-Apr-2016&toDate=23-Jun-2016&segmentLink=9").get();
			Element table = doc.select("table").get(0);
			Elements rows = table.select("tr");
			for (int i = 2; i < rows.size(); i++) {
				Element row = rows.get(i);
				Elements cols = row.select("td");
				for (int j = 0; j < cols.size(); j++) {
					System.out.print(cols.get(j).text() + "\t");
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
