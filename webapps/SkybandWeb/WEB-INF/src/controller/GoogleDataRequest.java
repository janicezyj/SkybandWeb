package controller;

import com.google.gdata.client.ClientLoginAccountType;
import com.google.gdata.client.GoogleService;
import com.google.gdata.client.Service.GDataRequest;
import com.google.gdata.client.Service.GDataRequest.RequestType;

import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class GoogleDataRequest {
	private static final String SERVICE_URL = "https://www.google.com/fusiontables/api/query";

	private static final Pattern CSV_VALUE_PATTERN = Pattern
			.compile("([^,\\r\\n\"]*|\"(([^\"]*\"\")*[^\"]*)\")(,|\\r?\\n)");

	private GoogleService service;

	// authenticate by gmail account & password
	public GoogleDataRequest(String email, String password)
			throws AuthenticationException {
		service = new GoogleService("fusiontables", "fusiontables.ApiExample");
		service.setUserCredentials(email, password,
				ClientLoginAccountType.GOOGLE);
	}

	// authenticate by authToken
	public GoogleDataRequest(String authToken) throws AuthenticationException {
		service = new GoogleService("fusiontables", "fusiontables.ApiExample");
		service.setUserToken(authToken);
	}

	public void getTableID(String TableID) {

	}

	// Select
	public ArrayList<String[]> runSelect(String[] selectitems, String tableid)
			throws IOException, ServiceException {
		String selectQuery = "select ";
		for (int i = 0; i < selectitems.length - 1; i++)
			selectQuery = selectQuery + selectitems[i] + ", ";
		selectQuery = selectQuery + selectitems[selectitems.length - 1]
				+ " from " + tableid;
		URL url = new URL(SERVICE_URL + "?sql="
				+ URLEncoder.encode(selectQuery, "UTF-8"));
		GDataRequest request = service.getRequestFactory().getRequest(
				RequestType.QUERY, url, ContentType.TEXT_PLAIN);

		request.execute();

		// Print
		Scanner scanner = new Scanner(request.getResponseStream(), "UTF-8");
		int i = 0;
		ArrayList<String[]> arraylist = new ArrayList<String[]>();
		String[] strings = new String[selectitems.length];
		while (scanner.hasNextLine()) {
			scanner.findWithinHorizon(CSV_VALUE_PATTERN, 0);
			MatchResult match = scanner.match();
			String quotedString = match.group(2);
			String decoded = quotedString == null ? match.group(1)
					: quotedString.replaceAll("\"\"", "\"");
			strings[i] = decoded;
			if (i == selectitems.length - 1) {
				arraylist.add(strings);
				i = 0;
			}
		}
		return arraylist;
	}

	public ArrayList<String[]> displayTable(String displayQuery, int column_num)
			throws IOException, ServiceException {
		URL url = new URL(SERVICE_URL + "?sql="
				+ URLEncoder.encode(displayQuery, "UTF-8"));
		GDataRequest request = service.getRequestFactory().getRequest(
				RequestType.QUERY, url, ContentType.TEXT_PLAIN);

		request.execute();

		// Print
		Scanner scanner = new Scanner(request.getResponseStream(), "UTF-8");
		int i = 0;
		ArrayList<String[]> arraylist = new ArrayList<String[]>();
		String[] strings = new String[column_num];
		while (scanner.hasNextLine()) {
			scanner.findWithinHorizon(CSV_VALUE_PATTERN, 0);
			MatchResult match = scanner.match();
			String quotedString = match.group(2);
			String decoded = quotedString == null ? match.group(1)
					: quotedString.replaceAll("\"\"", "\"");
			//System.out.print(decoded+"  " );
			strings[i % column_num] = new String(decoded);
			if (i % column_num == column_num-1) {
				arraylist.add(strings);
				strings = new String[column_num];
				//System.out.println();
			}
			++i;
		}
		return arraylist;
	}

	// Update
	public void runUpdate(String updateQuery) throws IOException,
			ServiceException {
		URL url = new URL(SERVICE_URL);
		GDataRequest request = service.getRequestFactory().getRequest(
				RequestType.INSERT, url,
				new ContentType("application/x-www-form-urlencoded"));
		OutputStreamWriter writer = new OutputStreamWriter(
				request.getRequestStream());
		writer.append("sql=" + URLEncoder.encode(updateQuery, "UTF-8"));
		writer.flush();

		request.execute();

		// Print
		Scanner scanner = new Scanner(request.getResponseStream(), "UTF-8");

		while (scanner.hasNextLine()) {
			scanner.findWithinHorizon(CSV_VALUE_PATTERN, 0);
			MatchResult match = scanner.match();
			String quotedString = match.group(2);
			String decoded = quotedString == null ? match.group(1)
					: quotedString.replaceAll("\"\"", "\"");

			System.out.print(", " + decoded);
			if (!match.group(4).equals(",")) {
				System.out.println("");
			}
		}
	}

	// Describe
	public ArrayList<String> runDescribe(String describeQuery)
			throws IOException, ServiceException {
		URL url = new URL(SERVICE_URL + "?sql="
				+ URLEncoder.encode(describeQuery, "UTF-8"));
		GDataRequest request = service.getRequestFactory().getRequest(
				RequestType.QUERY, url, ContentType.TEXT_PLAIN);
		request.execute();

		// Print
		ArrayList<String> column_names = new ArrayList<String>();
		Scanner scanner = new Scanner(request.getResponseStream(), "UTF-8");
		int i = 0;
		while (scanner.hasNextLine()) {
			scanner.findWithinHorizon(CSV_VALUE_PATTERN, 0);
			MatchResult match = scanner.match();
			String quotedString = match.group(2);
			String decoded = quotedString == null ? match.group(1)
					: quotedString.replaceAll("\"\"", "\"");
			if (i % 3 == 1 && i > 2) {
				column_names.add(decoded);
			}
			++i;
		}
		return column_names;
	}
}
