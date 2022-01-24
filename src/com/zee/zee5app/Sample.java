package com.zee.zee5app;

import java.util.ArrayList;
import java.util.Optional;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class Sample {

	public static void main(String[] args) {
		ArrayList<Node> nodes=new ArrayList<Node>();
		
		nodes.add(new Node(10, "first"));
		nodes.add(new Node(20, "Second"));
		nodes.add(new Node(30, "third"));
		
		System.out.println("Before");
		nodes.forEach((e)->{System.out.println(e);});
		Optional<Node> nod = null;
		for (Node node : nodes)
			if (node.getData()==10)
				nod = Optional.of(node);
		nod.get().data = 20;
		
		System.out.println("After");
		nodes.forEach((e)->{System.out.println(e);});
		
		
		
	}

}

@AllArgsConstructor
@Getter
@ToString
class Node{
	int data;
	String name;
}
