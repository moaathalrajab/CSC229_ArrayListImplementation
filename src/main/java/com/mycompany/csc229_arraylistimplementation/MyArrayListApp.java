
package com.mycompany.csc229_arraylistimplementation;

/**
 *
 * @author MoaathAlrajab
 */
interface MyList{
   public void add(Object t) throws Exception;
   public void add(int i, Object t) throws Exception;
   public void remove(Object t) throws Exception;
   public void remove(int i) throws Exception;
   public Object get() throws Exception;
   public Object get(int i) throws Exception;
   public int getSize() throws Exception;
    
}

class MyArrayList implements MyList{

	private static final int SIZE_FACTOR=5;
	
	private Object data[];
	
	private int index;
	
	private int size;
	
	public MyArrayList(){
		this.data=new Object[SIZE_FACTOR];
		this.size=SIZE_FACTOR;
	}
	    @Override
    public void add(int i, Object t) throws Exception {
        Object[] tmp= new Object[this.size];
              for(int j=0;j < index;j++)
                  tmp[j]=data[j];
        
        if(this.index==this.size-1){
			//we need to increase the size of data[]
			increaseSizeAndReallocate();
		}
                for(int j=0, k=0;j<=index;j++, k++){
                    System.out.println(j+"  "+k);
                    if(i!=j)
                        data[j]=tmp[k];
                    else
                    {
                        data[j]=t;k--;
                    }
                }
		
		this.index++;   
    }
    
	public void add(Object obj) throws Exception{
		if(this.index==this.size-1){
			//we need to increase the size of data[]
			increaseSizeAndReallocate();
		}
		data[this.index]=obj;
		this.index++;
		
	}
	
	private void increaseSizeAndReallocate() {
		this.size=this.size+SIZE_FACTOR;
		Object newData[]=new Object[this.size];
		for(int i=0; i<data.length;i++){
			newData[i]=data[i];
		}
		this.data=newData;
		System.out.println("***index:"+this.index+"size:"+
                        this.size+"data size:"+this.data.length);
	}
	
	public Object get(int i) throws Exception{
		if(i>this.index-1){
			throw new Exception("ArrayIndexOutOfBound");
		}
		if(i<0){
			throw new Exception("Negative Value");
		}
		return this.data[i];
		
	}
	
	public void remove(int i) throws Exception{
		if(i>this.index-1){
			throw new Exception("ArrayIndexOutOfBound");
		}
		if(i<0){
			throw new Exception("Negative Value");
		}
		System.out.println("Object getting removed:"+this.data[i]);
		for(int x=i; x<this.data.length-1;x++){
			data[x]=data[x+1];
		}
		this.index--;
	}

    @Override
    public void remove(Object t) throws Exception {
        for(int i=0; i<this.size; i++){
            if(data[i].equals(t)){
                remove(i);
                
                return;
            }
        }
        
    }

    @Override
    public Object get() throws Exception {
        return get(0);
    }

    @Override
    public int getSize() throws Exception {
        return index+1;
    }

    @Override
    public String toString() {
        String tmp="";
        for(int i=0; i<index;i++){
            tmp+=" "+data[i];
        }
        return tmp;
    }


 
	

}

public class MyArrayListApp {
    public static void main(String[] args) throws Exception {
		MyList mal = new MyArrayList();
		mal.add("4");
		mal.add("5");
                mal.add("0");
		mal.add("89");
                System.out.println("The size is "+mal.getSize());
		mal.add("2");
		mal.add("3");
		mal.add("9");
                System.out.println("The size is "+mal.getSize());
                mal.add("7");
		mal.add("6");
		
		mal.add("8");
                System.out.println("The size is "+mal.getSize());


                 mal.add(7, "M");
                System.out.println("The size is "+mal.getSize());
		System.out.println(mal);
	}
}
