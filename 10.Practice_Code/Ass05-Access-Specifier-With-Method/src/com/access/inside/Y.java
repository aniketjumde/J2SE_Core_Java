package com.access.inside;

class X {
    protected void show() {
        System.out.println("Protected method");
    }
}

class Y extends X {
	
    public static void main(String[] args) {
        Y obj = new Y();
        obj.show(); // Allowed
    }
}
