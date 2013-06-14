import java.io.IOException;
import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args)
	{
		
		ReportLoader loader = new ReportLoader();
		try {
			ArrayList<ReportLoader.TagHandler> h = new ArrayList<ReportLoader.TagHandler>();
			h.add(new WikiHandler());
			ReportLoader.Report[] reports = loader.run("http://en.m.wikipedia.org/wiki/Dell", h);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
}
