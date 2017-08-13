
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

public class BodyContent {

   public static void main(String[] args) throws IOException,SAXException, TikaException {

      //detecting the file type
     
      Metadata metadata = new Metadata();
     
      ParseContext pcontext = new ParseContext();
      
      
		HtmlParser htmlparser = new HtmlParser();
	   
      
     File dir = new File("src/CNNDownloadData/");
     File[] directoryListing = dir.listFiles();
     
     if(directoryListing !=null)
     {
    	 for(File child : directoryListing)
    	 {
    		 BodyContentHandler handler = new BodyContentHandler(-1);
    		 FileInputStream inputstream = new FileInputStream(child);
    		 String name = child.getName().split("\\.")[0];
    		 System.out.println(name);
    		 htmlparser.parse(inputstream, handler, metadata,pcontext);
    		 FileWriter writer = null;
    			try {
    				writer = new FileWriter("src/output/"+name+".txt");
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} 
    			inputstream=null;
				//inputstream.close();
    			
    			
    			
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
      
		

		
     
      
      
   }
}