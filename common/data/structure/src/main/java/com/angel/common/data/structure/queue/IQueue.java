/**
 * @Title:       QueueIntf.java
 * @Description: IQueue
 * @date:        2014-10-8下午4:59:07
 * @version:     V1.0
 */
package com.angel.common.data.structure.queue;

/**
 * @Description: 队列接口
 * @author: 	 Lijn
 * @time:        2014-10-8
 */
public interface IQueue<T extends Object> {

    public void enqueue(T t);
    public T dequeue();
    public boolean isEmpty();
    public T takequeue();
    public int getCurrentSize();
}
