package com.dharma.java8.functionalinterface;

@FunctionalInterface
public interface BaiscFunctional<T> {
    //implicit member (Object class)
//    boolean equals(Object obj);

    //only one abstract non-Object method
    boolean equals(Object obj);
    int compare(T o1, T o2);

//    int m();
//    Object clone();
}

//interface X { int m(Iterable<String> arg); }
//interface Y { int m(Iterable<String> arg); }
//@FunctionalInterface
//interface Z extends X, Y {}

//interface X1 { Iterable m(Iterable<String> arg); }
//interface Y1 { Iterable<String> m(Iterable arg); }
//@FunctionalInterface
//interface Z1 extends X1, Y1 {}

//interface X2 { int m(Iterable<String> arg); }
//interface Y2 { int m(Iterable<Integer> arg); }
//@FunctionalInterface
//interface Z2 extends X2, Y2 {}

//interface X3 { int m(Iterable<String> arg, Class c); }
//interface Y3 { int m(Iterable arg, Class<?> c); }
//@FunctionalInterface
//interface Z3 extends Y3, X3 {}

//interface X4 { long m(); }
//interface Y4 { int m(); }
//@FunctionalInterface
//interface Z4 extends X4, Y4 {}

//interface Foo<T> { void m(T arg); }
//interface Bar<T> { void m(T arg); }
//@FunctionalInterface
//interface FooBar<X, Y> extends Foo<X>, Bar<Y> {}
//类型不同
