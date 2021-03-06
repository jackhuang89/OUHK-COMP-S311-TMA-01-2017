import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jack
 */
public class NoWords extends Thread { //implements Runnable
    
    private String filename;
    private int final_count;
    private volatile boolean isRunning = true;
    
    public NoWords(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void run(){
        try {
            //do counting here
            while (isRunning) {
                this.countNumberOfWords(this.filename);
                this.finsihedThread();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(NoWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //lock the methods before a thread finsih the call
    public synchronized void finsihedThread() { 
        isRunning = false;
    }
    
    public synchronized void countNumberOfWords(String filename) throws FileNotFoundException, IOException {
        String current_dir = System.getProperty("user.dir");
        try (BufferedReader br = new BufferedReader(new FileReader( current_dir + "\\" + filename))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            String[] wordArray = everything.trim().split("\\s+");
            int wordCount = wordArray.length;
            this.final_count = wordCount;
        }catch(FileNotFoundException ee){
        	System.out.println("bbb");
        }
    }
    
    public int getFinal_count() {
        return final_count;
    }

    public boolean isIsRunning() {
        return isRunning;
    }
    
    public static void main(String[] args){     

    	if (args.length > 0){

    		NoWords t1 = new NoWords(args[0] + ".txt");
	        NoWords t2 = new NoWords(args[1] + ".txt");
	        NoWords t3 = new NoWords(args[2] + ".txt");
	        	        
	       	int aliveThread;
	        int count = 0;
	        t1.start();
	        t2.start();
	        t3.start();
	        
	        do{
	        	//update the reminding number of thread here
	        	aliveThread = Thread.activeCount();
	            //System.out.println(Thread.activeCount());

	        }while(Thread.activeCount() != 1);
	        
	       
	        while (Thread.activeCount() == 1){ //main thread always here.....
	            // System.out.println("fired");
	            count += t1.getFinal_count();
	            count += t2.getFinal_count();
	            count += t3.getFinal_count();
	            System.out.println("The total number of words in the files is " + count);
	            break; //print out once
	        }
    	}
        
    }
}
