package poly;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class implements evaluate, add and multiply for polynomials.
 * 
 * @author runb-cs112
 *
 */
public class Polynomial {
	
	/**
	 * Reads a polynomial from an input stream (file or keyboard). The storage format
	 * of the polynomial is:
	 * <pre>
	 *     <coeff> <degree>
	 *     <coeff> <degree>
	 *     ...
	 *     <coeff> <degree>
	 * </pre>
	 * with the guarantee that degrees will be in descending order. For example:
	 * <pre>
	 *      4 5
	 *     -2 3
	 *      2 1
	 *      3 0
	 * </pre>
	 * which represents the polynomial:
	 * <pre>
	 *      4*x^5 - 2*x^3 + 2*x + 3 
	 * </pre>
	 * 
	 * @param sc Scanner from which a polynomial is to be read
	 * @throws IOException If there is any input error in reading the polynomial
	 * @return The polynomial linked list (front node) constructed from coefficients and
	 *         degrees read from scanner
	 */
	public static Node read(Scanner sc) 
	throws IOException {
		Node poly = null;
		while (sc.hasNextLine()) {
			Scanner scLine = new Scanner(sc.nextLine());
			poly = new Node(scLine.nextFloat(), scLine.nextInt(), poly);
			scLine.close();
		}
		return poly;
	}
	
	/**
	 * Returns the sum of two polynomials - DOES NOT change either of the input polynomials.
	 * The returned polynomial MUST have all new nodes. In other words, none of the nodes
	 * of the input polynomials can be in the result.
	 * 
	 * @param poly1 First input polynomial (front of polynomial linked list)
	 * @param poly2 Second input polynomial (front of polynomial linked list
	 * @return A new polynomial which is the sum of the input polynomials - the returned node
	 *         is the front of the result polynomial
	 */
	private static Node insert(Node head, float coeff, int degree) {
		//For this method, I insert my new node at the end of the Linked List
		if(head==null) {
			head=new Node(coeff,degree,null);
			return head;
		}else {
			Node ptr=head;
			while(ptr.next!=null) {
				ptr=ptr.next;
			}
			ptr.next=new Node(coeff,degree,null);
			return head;
		}
	}
	public static Node add(Node poly1, Node poly2) {
		/** COMPLETE THIS METHOD **/
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		Node ptr1 = poly1;
		Node ptr2 = poly2;
		Node sum =null;
		while(ptr1 != null && ptr2 != null) {
			if (ptr1.term.degree == ptr2.term.degree) {
			float co = ptr1.term.coeff + ptr2.term.coeff;
			if (co != 0)
			sum = insert(sum, co, ptr1.term.degree);
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
			} else if (ptr1.term.degree > ptr2.term.degree) {
				if (ptr2.term.coeff != 0)
				sum = insert(sum, ptr2.term.coeff,ptr2.term.degree);
				ptr2= ptr2.next;
			} else {
				if (ptr1.term.coeff != 0)
				sum = insert(sum, ptr1.term.coeff,ptr1.term.degree);
				ptr1= ptr1.next;
			}
		}
		Node ptr=sum;
		while(ptr!=null &&ptr.next!=null) {
			ptr=ptr.next;
		}
		if (ptr!=null && ptr1 != null && ptr2 == null) {
			ptr.next=ptr1;
		}else if(ptr==null && ptr1 != null && ptr2 == null) {
			return ptr1;
		}
		if (ptr!=null && ptr1 == null && ptr2 != null) {
			ptr.next=ptr2;
		}else if(ptr==null &&ptr1 == null && ptr2 != null) {
			return ptr2;
		}
		return sum;
	}
	
	/**
	 * Returns the product of two polynomials - DOES NOT change either of the input polynomials.
	 * The returned polynomial MUST have all new nodes. In other words, none of the nodes
	 * of the input polynomials can be in the result.
	 * 
	 * @param poly1 First input polynomial (front of polynomial linked list)
	 * @param poly2 Second input polynomial (front of polynomial linked list)
	 * @return A new polynomial which is the product of the input polynomials - the returned node
	 *         is the front of the result polynomial
	 */
	public static Node multiply(Node poly1, Node poly2) {
		/** COMPLETE THIS METHOD **/
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		Node ptr1 = poly1;
		Node result =null;
		while(ptr1 !=null) {
			Node ptr2 = poly2;
			Node multi = null;
			while (ptr2 != null) {
				 multi = insert(multi,ptr1.term.coeff * ptr2.term.coeff,ptr1.term.degree + ptr2.term.degree);
				 ptr2= ptr2.next;
			}
			ptr1=ptr1.next;
			result = add(result, multi);
		}
		return result;
	}
		
	/**
	 * Evaluates a polynomial at a given value.
	 * 
	 * @param poly Polynomial (front of linked list) to be evaluated
	 * @param x Value at which evaluation is to be done
	 * @return Value of polynomial p at x
	 */
	public static float evaluate(Node poly, float x) {
		/** COMPLETE THIS METHOD **/
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		Node ptr = poly;
		float xx=0;
		while (ptr != null) {
			xx+=ptr.term.coeff*Math.pow(x, ptr.term.degree);
			ptr = ptr.next;
		}
		return xx;
	}
	
	/**
	 * Returns string representation of a polynomial
	 * 
	 * @param poly Polynomial (front of linked list)
	 * @return String representation, in descending order of degrees
	 */
	public static String toString(Node poly) {
		if (poly == null) {
			return "0";
		} 
		
		String retval = poly.term.toString();
		for (Node current = poly.next ; current != null ;
		current = current.next) {
			retval = current.term.toString() + " + " + retval;
		}
		return retval;
	}	
}
