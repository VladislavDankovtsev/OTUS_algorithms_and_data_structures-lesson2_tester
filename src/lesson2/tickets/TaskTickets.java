package lesson2.tickets;

import lesson2.ITask;

public class TaskTickets implements ITask {

    @Override
    public String run(String[] data) {
        int n = Integer.parseInt(data[0]);
        long[] array = new long[n*9+2];
        long[] arrayBase = new long[n*9+2];
        for(int i = 0; i<=9;i++){
            arrayBase[i]=1;
        }
        if( n== 1) return String.valueOf(10);

        else {
            return String.valueOf(next(n,arrayBase,array));
        }
    }

    private long next(int num,long[] arrayBase,long[] array){
        int numNext=2;

        while (true){

            for(int i=0;i<numNext*9+1;i++){
                array[i]=getNewElSum(i,arrayBase);
            }

            for (int i = 0; i < arrayBase.length; i++) {
                arrayBase[i] = array[i];
            }
            if (numNext==num){
                return sumPow(num,array);
            }
            numNext++;
        }
    }

    private long sumPow(int num,long[] array){
        long count=0;
        for(int i=0;i<=num*9;i++){
            count+=array[i]*array[i];
        }
        return count;
    }

    private int getNewElSum(int el, long[] arrayBase){
        int newElSum=0;
        if(el<=9){
            for(int i=0;i<=el;i++){
                newElSum+=arrayBase[i];
            }
        }else {
            for(int i=el-9; i<=el;i++){
                newElSum+=arrayBase[i];
            }
        }
        return newElSum;
    }
}
