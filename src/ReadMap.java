import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class ReadMap {

	    private InputStreamReader readMapFile;
	    private BufferedReader bufReader;
	    
	    public ReadMap(int level)
	    {
	    	String filePath="/maps/SKBMap"+level+".txt";
	    	InputStream is = getClass().getResourceAsStream(filePath);
	        
	            readMapFile=new InputStreamReader(is);
	          
	            bufReader=new BufferedReader(readMapFile);
	        
	    }
	    public String readSKBMapFile()
	    {
	        String str="",temp;
	        try
	        {
	            while((temp=bufReader.readLine())!=null)
	                str+=temp;
	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
	        return str;
	    }
}
