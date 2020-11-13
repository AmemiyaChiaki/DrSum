import java.util.*;
class randomDrSum{

    int[][] haichi;
    int[] rsum;
    int[] csum;
    int height;
    int width;
    int B;
    Random r=new Random();

    randomDrSum(int h,int w,int b){
	height=h;
	width=w;
	B=b;
	haichi=new int[h][w];
	rsum=new int[h];
	csum=new int[w];
    }
    void randomFill(){
	for(int i=0;i<height;i++){
	    for(int j=0;j<width;j++){
		haichi[i][j]=(int)Math.floor(B*r.nextDouble())+1;
		rsum[i]+=haichi[i][j];
		csum[j]+=haichi[i][j];
	    }
	}
    }
    void printHaichi(){
	System.out.print("rsums:[");
	for(int i=0;i<height;i++){
	    System.out.print(rsum[i]+",");
	}
	System.out.println("],");
	System.out.print("csums:[");

	for(int j=0;j<width;j++){
	    System.out.print(csum[j]+",");
	}
	System.out.println("],");
	System.out.print("haichi:[");

	for(int i=0;i<height;i++){
	    for(int j=0;j<width;j++){
		System.out.println("{r:"+(i+1)+",c:"+(j+1)+",d:"+haichi[i][j]+"},");
	    }
	}
	System.out.println("],");

    }
    void shuffle(){
	ArrayList<int[]> indices=new ArrayList<int[]>();
	ArrayList<int[]> original=new ArrayList<int[]>();
	int[][] b=new int[height][width];
	for(int i=0;i<height;i++){
	    for(int j=0;j<width;j++){
		int[] index=new int[2];
		index[0]=i;
		index[1]=j;
		indices.add(index);
	    }
	}
	for(int i=0;i<height;i++){
	    for(int j=0;j<width;j++){
		int[] index=new int[2];
		index[0]=i;
		index[1]=j;
		original.add(index);
	    }
	}
	Collections.shuffle(indices);
	for(int i=0;i<height*width;i++){
	    int[] index=indices.get(i);
	    int[] o=original.get(i);
	    b[o[0]][o[1]]=haichi[index[0]][index[1]];
	}
	haichi=b;
    }
    
    public static void main(String[] args){
	randomDrSum rds=new randomDrSum(3,3,5);
	rds.randomFill();
	//rbs.shuffle(haichi[][]);
	rds.printHaichi();
	rds.shuffle();
	rds.printHaichi();
    }
}
