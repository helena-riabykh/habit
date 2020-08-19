package com.example.android.habittracker;

/**
 * Created by Anton on 09.07.2020.
 */
 class Vector {
    private double x, y, z;

    private Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double vectorLength(){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }
    public double scalarProduct(Vector vector){
        return this.x*vector.x + this.y*vector.y + this.z*vector.z;
    }
    public double angleBetweenVectors(Vector vector){
        return scalarProduct(vector)/this.vectorLength()*vector.vectorLength();
    }
    public Vector sum(Vector vector){
        return new Vector(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }
    public Vector difference (Vector vector){
        return new Vector(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }
    public static Vector[] randomVectors(int n){
        Vector[] array = new Vector[n];
        for (int i = 0; i < n; i++){
            array[i] = new Vector(Math.random(), Math.random(),Math.random());
            System.out.println(array[i]);
        }
        return array;
    }
    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
   }
    public static void main(String[] args) {
        Vector vectorOne = new Vector(2, 4.3, 0.9);
        Vector vectorTwo = new Vector(3, 5, 1);
        System.out.println("Длина вектора 1: " + vectorOne.vectorLength() + ", длина вектора 2: " + vectorTwo.vectorLength());
        System.out.println("Скалярное произведение вектров = " + vectorOne.scalarProduct(vectorTwo));
        vectorTwo.angleBetweenVectors(vectorOne);
        System.out.println("Косинус угла между векторами = " + vectorTwo.angleBetweenVectors(vectorOne));
        System.out.println("Сумма векторов = " + vectorOne.sum(vectorTwo) + ", разность векторов = " + vectorTwo.difference(vectorOne));
        System.out.println("Массив векторов: " + Vector.randomVectors(5));
    }
}