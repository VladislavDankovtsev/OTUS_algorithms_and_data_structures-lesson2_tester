package lesson2.tester;

import lesson2.ITask;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Tester {
    private ITask task;
    private String path;

    public Tester(ITask task, String path) {
        this.task = task;
        this.path = path;
    }

    public void RunTests(){
        int nr = 0;
        while (true){
            String inFile = path+"/test."+nr+".in" ;
            String outFile =  path+"/test."+nr+".out";
            File fIn = new File(inFile);
            File fOut = new File(outFile);
            if( !fIn.exists() || !fOut.exists()){
                System.out.println("THE END!");
                return;
            }
            long start = System.currentTimeMillis();
            boolean result = RunTests(fIn,fOut);
            long finish = System.currentTimeMillis();
            long elapsed = finish - start;
            System.out.println("Test №"+nr+" - "+result+"     Time(ms): "+elapsed);
            System.out.println("");
            nr++;
        }
    }

    private boolean RunTests(File inFile, File outFile) {
        try{
            String[] data  = readText(inFile);
            String expect = readTextAll(outFile).trim();
            String actual = task.run(data).trim();
            System.out.println("Actual:"+actual+"    Expect:"+expect);
            return actual.equals(expect);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private String[] readText(File file) throws Exception {
        try{
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
            lineNumberReader.skip(Long.MAX_VALUE);
            int lines = lineNumberReader.getLineNumber();
            lineNumberReader.close();
            String data[] = new String[lines+1];
            int num = 0;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                data[num] = line;
                num++;
                line = reader.readLine();
            }
            return data;
        } catch (Exception e) {
            throw new Exception(""+e.getMessage());
        }
    }

    private String readTextAll(File file) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(file.toPath());
            String str = new String(bytes, StandardCharsets.UTF_8);
            return str;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
