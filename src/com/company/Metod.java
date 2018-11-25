package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Metod {

    private  double[] y;
    private int a;
    private int m;
    private double[] ksi;
    private double[] mas_int;
    private int[] mas_kol;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public double[] getY() {
        return y;
    }

    public void setY(double[] y) {
        this.y = y;
    }

    public double[] getKsi() {
        return ksi;
    }

    public void setKsi(double[] ksi) {
        this.ksi = ksi;
    }

    public double[] getMas_int() {
        return mas_int;
    }

    public void setMas_int(double[] mas_int) {
        this.mas_int = mas_int;
    }

    public int[] getMas_kol() {
        return mas_kol;
    }

    public void setMas_kol(int[] mas_kol) {
        this.mas_kol = mas_kol;
    }

    Metod()
    {
        this.a = 15133;
        this.m = 27119;
        this.y = new double[1000];
        this.ksi = new double[1000];
        this.mas_int = new double[11];
        this.mas_kol = new int[10];
        mas_int[0] = 0.0;
        mas_int[1] = 0.1;
        mas_int[2] = 0.2;
        mas_int[3] = 0.3;
        mas_int[4] = 0.4;
        mas_int[5] = 0.5;
        mas_int[6] = 0.6;
        mas_int[7] = 0.7;
        mas_int[8] = 0.8;
        mas_int[9] = 0.9;
        mas_int[10] = 1.0;

    }

    public void GetY() throws IOException {
        Random r = new Random();
        FileWriter f = new FileWriter("C:/Users/21091/Downloads/SM_1/Ksi.csv");
        double sum = 0;
        double MO = 0;
        double SKO;
        double Disp = 0;
        double min = 1000;
        double max = -1000;
        double dx;
        int k = 0;

        y[0] = 30;
        ksi[0] = y[0] / m;

        for(int i = 1; i < 1000; i++) {
            sum += y[i - 1] * getA();
            y[i] = (sum + 0.4) % getM();
            ksi[i] = y[i] / m;
        }

        for(int i = 0; i < 1000; i++)
        {
            MO += ksi[i];
            f.write(ksi[i] + "\n" );
            System.out.print(ksi[i]);
        }

        MO = MO / 100;

        for(int i = 0; i < 1000; i++)
        {
            Disp += Math.pow(ksi[i] - MO, 2);
        }

        Disp = Disp / 100;

        SKO = Math.sqrt(Disp);

        System.out.println("\n MO = " + MO + "\n DISP = " + Disp + "\n SKO = " + SKO);

        for(int i = 0; i < 1000; i++)
        {
            if(ksi[i] < min)
            {
                min = ksi[i];
            }

            else if(ksi[i] > max)
            {
                max = ksi[i];
            }

            dx = (max - min) / 10;
        }

        for(int j = 9; j >=0; j--) {
            k = 0;
            for (int i = 0; i < 1000; i++) {
                if(ksi[i] >= mas_int[j] && ksi[i] <= mas_int[j + 1])
                {
                    k++;
                    mas_kol[j] = k;
                }
                else continue;
            }
            f.write(";" + mas_kol[j] + "\n");
        }
        f.close();
    }

    /*public void GetInterval() throws IOException {
        double min = 1000;
        double max = -1000;
        double dx;
        int k = 0;
        FileWriter f = new FileWriter("C:/Users/Ярослав/Downloads/Ksi.csv");

        for(int i = 0; i < 100; i++)
        {
            if(ksi[i] < min)
            {
                min = ksi[i];
            }

            else if(ksi[i] > max)
            {
                max = ksi[i];
            }

            dx = (max - min) / 5;
        }
        for(int j = 4; j >=0; j--) {
            k = 0;
            for (int i = 0; i < 100; i++) {
            if(ksi[i] >= mas_int[j] && ksi[i] <= mas_int[j + 1])
                {
                    k++;
                    mas_kol[j] = k;
                }
                else continue;
            }
            f.write(";" + mas_kol[j]);
        }
        f.close();
    }*/








}
