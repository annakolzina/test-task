package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter user id:");
        int id = in.nextInt();
        in.close();

        System.out.println(ServiceParser.getName(ServiceHttp.getJsonString(id)));
    }

}
