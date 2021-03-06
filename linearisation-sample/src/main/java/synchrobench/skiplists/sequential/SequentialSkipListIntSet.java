package synchrobench.skiplists.sequential;

import synchrobench.contention.abstractions.CompositionalIntSet;
import synchrobench.contention.abstractions.CompositionalIterator;

import java.util.Collection;
import java.util.Random;
import java.util.Stack;


/**
 * A sequential skiplist-based implementation of the integer set
 */
public class SequentialSkipListIntSet implements CompositionalIntSet {

    /** The probability to increase level */
    final private double probability;
    /** The maximum number of levels */
    final private int maxLevel;
    /** The first element of the list */
    final public Node head;
    /** The thread-private PRNG */
    final private static ThreadLocal<Random> s_random = new ThreadLocal<Random>() {
        @Override
        protected synchronized Random initialValue() {
            return new Random();
        }
    };
	
    public SequentialSkipListIntSet() {
        this(6, 0.25);
    }
    
    public SequentialSkipListIntSet(final int maxLevel, final double probability) {
	this.maxLevel = maxLevel;
	this.probability = probability;
	this.head = new Node(maxLevel, Integer.MIN_VALUE);
	final Node tail = new Node(maxLevel, Integer.MAX_VALUE);
	for (int i = 0; i <= maxLevel; i++) {
	    head.setNext(i, tail);
	}
    }	
    
    public void fill(final int range, final long size) {
	while (this.size() < size) {
	    this.addInt(s_random.get().nextInt(range));
	}
    }
    
    protected int randomLevel() {
	int l = 0;
	while (l < maxLevel && s_random.get().nextDouble() < probability) {
	    l++;
	}
	return l;
    }
    
    @Override
    public boolean containsInt(final int value) { 
	boolean result;
	
	Node node = head;
	
	for (int i = maxLevel; i >= 0; i--) {
	    Node next = node.getNext(i);
	    while (next.getValue() < value) {
		node = next;
		next = node.getNext(i);
	    }
	}
	node = node.getNext(0);
	
	result = (node.getValue() == value);
	
	return result;
    }
    
    @Override
    public boolean addInt(final int value){
	boolean result;
	
	Node[] update = new Node[maxLevel + 1];
	Node node = head;
	
	for (int i = maxLevel; i >= 0; i--) {	        
	    Node next = node.getNext(i);
	    while (next.getValue() < value) {	               
		node = next;
		next = node.getNext(i);
	    }
	    update[i] = node;
	}
	node = node.getNext(0);
	
	if (node.getValue() == value) {
	    result = false;
	} else {
	    int level = randomLevel();
	    node = new Node(level, value);
	    for (int i = 0; i <= level; i++) {
		node.setNext(i, update[i].getNext(i));
		update[i].setNext(i, node);
	    }
	    result = true;
	}
	return result;
    }
    
    @Override
    public boolean removeInt(int value) {
	boolean result;
	
	Node[] update = new Node[maxLevel + 1];
	Node node = head;
	
	for (int i = maxLevel; i >= 0; i--) {
	    Node next = node.getNext(i);
	    while (next.getValue() < value) {
		node = next;
		next = node.getNext(i);
	    }
	    update[i] = node;
	}
	node = node.getNext(0);
	
	if (node.getValue() != value) {
	    result = false;
	} else {
	    int maxLevel = node.getLevel();
	    for (int i = 0; i <= maxLevel; i++) {
		update[i].setNext(i, node.getNext(i));
	    }
	    result = true;
	}
	
	return result;
    }
    
    @Override
    public boolean addAll(Collection<Integer> c) {
        boolean result = true;
        for (int x : c) result &= this.addInt(x);
        return result;
    }
    
    @Override
    public boolean removeAll(Collection<Integer> c) {
        boolean result = true;
        for (int x : c) result &= this.removeInt(x);
        return result;
    }

    @Override
    public int size() {        
	int s = 0;
	Node node = head.getNext(0).getNext(0);
	
	while (node != null) {
	    node = node.getNext(0);
	    s++;
	}
	return s;
    }
    
    @Override
    public String toString() {
	String str = new String();
	Node curr = head;
	int i, j;
	final int[] arr = new int[maxLevel+1];
	
	for (i=0; i<= maxLevel; i++) arr[i] = 0;
	
	do {
	    str += curr.toString();
	    arr[curr.getLevel()]++;
	    curr = curr.getNext(0);
	} while (curr != null); 
	for (j=0; j < maxLevel; j++)
	    str += arr[j] + " nodes of level " + j;
	return str;
    }
    
    
    public class Node {
	
        final private int value;
        final private Node[] next;
	
        public Node(final int level, final int value) {
            this.value = value;
            next = new Node[level + 1];
        }
	
        public int getValue() {
            return value;
        }
	
        public int getLevel() {
            return next.length - 1;
        }
	
        public void setNext(final int level, final Node succ) {
            next[level] = succ;
        }
	
        public Node getNext(final int level) {
            return next[level];
        }
	
        @Override
	public String toString() {
            String result = "";
            result += "<l=" + getLevel() + ",v=" + value + ">:";
            for (int i = 0; i <= getLevel(); i++) {
                result += " @[" + i + "]=";
                if (next[i] != null) {
                    result += next[i].getValue();
                } else {
                    result += "null";
                }
            }
            return result;
        }
    }
    
    public class SLIterator implements CompositionalIterator<Integer> {
        Node next = head;
        Stack<Node> stack = new Stack<Node>();
        
        SLIterator() {
        	while (next != null) {
        		stack.push(next.next[0]);
        	}
        }

        public boolean hasNext() {
        	return next != null;
        }

        public void remove() {
        	throw new UnsupportedOperationException();
        }

        public Integer next() {
        	Node node = next;
        	next = stack.pop();
        	return node.getValue();
        }
    }

    /** 
     * This is called after the JVM warmup phase
     * to make sure the data structure is well initalized.
     * No need to do anything for this.
     */
    public void clear() {
    	return;	
    }
    
    @Override
    public Object getInt(int value) {
	Node node = head;
	
	for (int i = maxLevel; i >= 0; i--) {
	    Node next = node.getNext(i);
	    while (next.getValue() < value) {
		node = next;
		next = node.getNext(i);
	    }
	}
	node = node.getNext(0);
	
	if (node.getValue() == value) return node;
	return null;
    }
    
    @Override
    public Object putIfAbsent(int x, int y) {
	if (!containsInt(x)) removeInt(y);
	return null;
    }
}
