/**
 * @Title:       Queue.java
 * @Description: 队列 ——循环数组实现
 * @date:        2014-10-8下午2:27:13
 * @version:     V1.0
 */
package com.angel.common.data.structure.queue.circlequeue;


import com.angel.common.data.structure.queue.IQueue;

/**
 * @Description: 队列 ——循环数组实现
 * @author: 	 Lijn
 * @time:        2014-10-8
 */
public class ArrayCircleQueue<T extends Object> implements IQueue<T> {

    /**
     * @Description: 数组大小
     */
    private int size;

    /**
     * @Description: 当前数组已存数多少
     */
    private int currentSize;

    /**
     * @Description: 循环数组
     */
    private transient Object[] circle_array;

    private int first = -1;

    private int last = 0;

    /**
     * @Description: 入队操作
     * @param t
     * @throws Exception
     */
    public void enqueue(T t)
    {
        if(currentSize>=size)
        {
            throw new RuntimeException("full queue");
        }

        currentSize++;
        first=next(first);
        circle_array[first] = t;
    }

    /**
     * @Description:  出队操作
     * @return
     * @throws Exception
     */
    public T dequeue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("empty equeue");
        }
        T t = (T) circle_array[last];
        currentSize--;
        last=next(last);
        return t;
    }

    public boolean isEmpty()
    {
        return currentSize==0 ? true : false;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("out<<");
        if(!isEmpty())
        {
            for(int i =last,tempSize=currentSize;tempSize>0;i=next(i),tempSize--)
            {
                sb.append(circle_array[i]);
                sb.append("<<");
            }
        }
        sb.append("in");
        return sb.toString();
    }

    private int next(int i)
    {
        if(i>=size-1){
            return 0;
        }

        return ++i;
    }

    /**
     * @Description: 获取操作
     * @return
     * @throws Exception
     */
    public T takequeue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("empty equeue");
        }
        return (T) circle_array[last];
    }
    /**
     * @throws Exception
     * @Description: constructor
     */

    public ArrayCircleQueue(int size)
    {
        if(size>0)
        {
            circle_array = new Object[size];
            this.size = size;
        }else{
            throw new RuntimeException("size too small");
        }
    }

    /**
     * @throws Exception
     * @Description: constructor
     */
    public ArrayCircleQueue(){
        this(10);
    }

    /**
     * @description: getter-- size
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @description: getter-- currentSize
     * @return the currentSize
     */
    public int getCurrentSize() {
        return currentSize;
    }

}
