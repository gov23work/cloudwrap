package org.example;

public class Wrapper {

    public void buildWrapper(String cloudFunction1, String cloudFunction2) {
        System.out.println("buildWrapper starting..");
        System.out.println("Received "+ cloudFunction1 + " and "+ cloudFunction2);
        if(cloudFunction1.endsWith(".py")){
            System.out.println("Python detected, skipping variable modification");
        }else {
            System.out.println("Stub -> Getting variables that need to be configured");
        }
        //TODO
        //apache commons cli implementieren
        //calling of index1.js and index2.js
        //Variable checker of both files :
        //Whatever variables are set in both functions need to avoid reassignment via type, at least in js/ts
        //i.e, avoid two of 'const variable = foo', instead one 'const variable = foo', one 'variable = foo'
        //function call via http needs to be only set once
        //introduce requirement that both functions have the same triggers?

        String fileEnding = "";

        System.out.println("Stub -> Finished building wrapper function");


    }
}
