
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

public class HtmlParse {

   public static void main(String[] args) throws IOException,SAXException, TikaException {

      //detecting the file type
      BodyContentHandler handler = new BodyContentHandler(-1);
      Metadata metadata = new Metadata();
     
      ParseContext pcontext = new ParseContext();
      
      FileWriter writer = null;
		try {
			writer = new FileWriter("src/big1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		HtmlParser htmlparser = new HtmlParser();
	   
      
     File dir = new File("src/CNNDownloadData/");
     File[] directoryListing = dir.listFiles();
     
     if(directoryListing !=null)
     {
    	 for(File child : directoryListing)
    	 {
    		 FileInputStream inputstream = new FileInputStream(child);
    		 htmlparser.parse(inputstream, handler, metadata,pcontext);
    	 }
     }
      
		
		try {
			writer.write(handler.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
      
     
      
      try {
			writer.flush();
			 writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
   }
}