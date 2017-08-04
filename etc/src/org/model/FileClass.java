package org.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.model.Feature;
public class FileClass {
	private File file;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

	public String getFileName(){
		return file.getName();
	}
	
	public FileClass() {
		file=null;
	}
	
	public FileClass(String pathString) {
		file=new File(pathString);
	}
	
	public String Upload() throws Exception{
		if(!file.exists()||file.isDirectory()||!file.canRead()){
			 return null;  
	    }
		String savePath = "E:\\myEclipse\\myEclipseWorkispace\\filter\\WebRoot\\WEB-INF\\upload";
		FileInputStream fis = new FileInputStream(file);
		File fileout = new File(savePath,((Long)System.currentTimeMillis()).toString()+".txt");
		FileOutputStream fos = new FileOutputStream(fileout);
		byte[] b = new byte[1024];
		while(fis.read(b)!=-1){
			fos.write(b);
			fos.flush();
		}
		fis.close();
		fos.close();
		return fileout.getAbsolutePath();
	}
	
	public String OpenFile() throws Exception{
		if(!file.exists()||file.isDirectory()||!file.canRead()){
			 return null;  
	    }
		StringBuilder result = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s = null;
		if((s=br.readLine())!=null){	result.append(s);}
		while((s = br.readLine())!=null){	result.append("<br>"+s);}
		br.close();
	    return result.toString();
	}
	
	public String openFileContent() throws Exception{
		String resultString="";
		String temp="";
		if(!file.exists()||file.isDirectory()||!file.canRead()){
			return null;
		}
		Scanner sc = new Scanner(file);
		if(sc.hasNextLine()){
			resultString=sc.nextLine()+"<br>"+"..."+"<br>";
		}
        while(sc.hasNextLine()){  
            temp=sc.nextLine();
        }
        resultString+=temp;
        sc.close(); 
	    return resultString;
	}
	
	/*public String openFileResult() throws Exception{
		if(!file.exists()||file.isDirectory()||!file.canRead()){
			return null;
		}
		String resultString="";
		int count=1;
		Scanner sc = new Scanner(file);
		if(sc.hasNextLine()){
			resultString=sc.nextLine();
		}
        while(sc.hasNextLine()&&count<=10){  
            resultString+="<br>"+sc.nextLine();
            count++;
        }
        resultString+="...";
        sc.close(); 
	    return resultString;
	}*/
	
	public ArrayList<Feature> openFileResultToFeature() throws Exception{
		if(!file.exists()||file.isDirectory()||!file.canRead()){
			return null;
		}
		ArrayList<Feature> flist=new ArrayList<Feature>();
		int count=1;
		Scanner sc = new Scanner(file);
		String []tempdata=null;
        while(sc.hasNextLine()&&count<=10){  
        	tempdata=sc.nextLine().trim().split(" ");
			Feature tempf=new Feature(tempdata[0], Double.parseDouble(tempdata[3]), 
					Integer.parseInt(tempdata[1]), Integer.parseInt(tempdata[2]));
			flist.add(tempf);
            count++;
        }
        sc.close(); 
	    return flist;
	}
	
	public String SaveData(Integer id,String path) throws Exception{
		if(!file.exists()||file.isDirectory()||!file.canRead()){
			return null;
		}
		if(path==null){
			path="E:\\myEclipse\\myEclipseWorkispace\\filter\\userspace\\"+id.toString();
			File dir = new File(path);
			dir.mkdir();
		}
		FileInputStream fis = new FileInputStream(file);
		File fileout = new File(path,"data"+((Long)System.currentTimeMillis()).toString()+".txt");
		FileOutputStream fos = new FileOutputStream(fileout);
		byte[] b = new byte[1024];
		while(fis.read(b)!=-1){
			fos.write(b);
			fos.flush();
		}
		fis.close();
		fos.close();
		return path;
	}
	
	public String SaveResult(Integer id,String path,String modelName,ArrayList<Feature> flist) throws Exception{
		if(path==null){
			path="E:\\myEclipse\\myEclipseWorkispace\\filter\\userspace\\"+id.toString();
			File dir = new File(path);
			dir.mkdir();
		}
		File fileout = new File(path,"result "+((Long)System.currentTimeMillis()).toString()+modelName+".txt");
		FileOutputStream fos = new FileOutputStream(fileout);
		for (int i = 0; i < flist.size(); i++) {
            fos.write((flist.get(i).getName()+" "+flist.get(i).getPosFeq()+" "
            		+flist.get(i).getNegFeq()+" "+flist.get(i).getValue()+"\r\n").getBytes());   
        } 
		fos.close();
		return path;
	}
	
	public void sepFile(ArrayList<FileClass> dataFileList,ArrayList<FileClass> resultFileList){
		if(!file.isDirectory()){
			return;
		}
		String []filelist=file.list();
		if(filelist==null){
			dataFileList=null;
			resultFileList=null;
			return;
		}
		for (int i = 0; i < filelist.length; i++) {
            FileClass readfile = new FileClass(file.getAbsolutePath()+"\\"+filelist[i]);
            if(readfile.getFileName().charAt(0)=='d'){
            	dataFileList.add(readfile);
            }
            else{
            	resultFileList.add(readfile);
            }
		}
		return;
	}
	
	public String download() throws Exception{
		String Dpath="E:\\edge download";
		FileInputStream fis = new FileInputStream(file);
		File fileout = new File(Dpath,"result "+((Long)System.currentTimeMillis()).toString()+".txt");
		FileOutputStream fos = new FileOutputStream(fileout);
		byte[] b = new byte[1024];
		while(fis.read(b)!=-1){
			fos.write(b);
			fos.flush();
		}
		fis.close();
		fos.close();
		return "success";
	}
}
