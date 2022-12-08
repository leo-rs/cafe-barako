/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author samadidanas
 */
public class MyVector<T> {

    public static final int DEFAULT_SIZE = 10;

    private T[] mArray;
    private int mSize;
    private int mAssignments;

    public MyVector(Class<T> type) {

        mArray = (T[]) Array.newInstance(type, DEFAULT_SIZE);
        mSize = 0;
        mAssignments = 0;
    }

    public void push_back(final T value) {
        if (mSize >= mArray.length) {
            resize(mSize * 2);
        }
        mArray[mSize] = value;
        mSize++;
        mAssignments++;
    }

    public void resize(int newSize) {
        T[] temp = Arrays.copyOf(mArray, newSize);
        mArray = temp;
    }

    public T at(int index) {
        return mArray[index];
    }
    
    public int getSize(){
        return this.mSize;
    }
    
    

}
