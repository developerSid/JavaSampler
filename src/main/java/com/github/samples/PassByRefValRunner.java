package com.github.samples;

import java.util.ArrayList;
import java.util.List;

public class PassByRefValRunner
{
   public static void main(String[] args)
   {
      List<String> list=new ArrayList<String>();
      
      System.out.printf("main id=%s size %d, %s\n", System.identityHashCode(list), list.size(), list.toString());
      addElement(list);
      System.out.printf("main id=%s size %d, %s\n", System.identityHashCode(list), list.size(), list.toString());
      copyListAddElement(list);
      System.out.printf("main id=%s size %d, %s\n", System.identityHashCode(list), list.size(), list.toString());
      addAnotherElement(list);
      System.out.printf("main id=%s size %d, %s\n", System.identityHashCode(list), list.size(), list.toString());
   }
   private static void addElement(List<String> elements)
   {
      elements.add("Element 1");
   }
   private static void addAnotherElement(List<String> elements)
   {
      elements.add("Element 2");
   }
   private static void copyListAddElement(List<String> elements)
   {
      List<String> originalElements=elements; //assign a different variable (pointer to original memory location)
      
      elements=new ArrayList<String>(originalElements); //assign passed in variable to newly instantiated java.util.ArrayList
      
      addAnotherElement(elements); //add an element to our new list
      
      System.out.printf("copy id=%s size %d, %s\n", System.identityHashCode(elements), elements.size(), elements.toString());
   }
}
