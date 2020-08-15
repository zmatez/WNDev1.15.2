package com.matez.wildnature.world.gen.noise.another;

public abstract class Noise {
    public Noise(long seed) {}
    
    public abstract double sample(double x, double z);
    
    public abstract double sample(double x, double y, double z);
    
    // Dont know if we'd use these but I put them in just in case
    
    private static final int CHAR_BIT = 8;
    private static final int SIZE_INT = 8;
    
    public static double fastSqrt(double d)
    {
    	return Double.longBitsToDouble(((Double.doubleToLongBits(d) - (1L << 52)) >> 1) + (1L << 61));
    }
    
    public static int fastAbs(int n)
    {
    	int mask = n >> (SIZE_INT * CHAR_BIT - 1);
    	return ((n + mask) ^ mask);
    }
    
    public static long fastAbs(long n)
    {
    	long mask = n >> (SIZE_INT * CHAR_BIT - 1);
    	return ((n + mask) ^ mask);
    }
    
    protected static int factorial(int n)
    {
    	if (n == 1)
    	{
    		return 1;
    	}
    	else
    	{
    		return n * factorial(n - 1);
    	}
    }
    
    protected double clamp(double value)
    {
    	return (value > 1) ? 1 : (value < -1) ? -1 : value;
    }
    
    protected double clampPositive(double value) 
    {
		return (value < 0) ? 0 : value;
	}

	protected static double lerp(double progress, double start, double end) 
	{
		return start + progress * (end - start);
	}

	protected static double sigmoid(double x) 
	{
		return (1 / ( 1 + Math.exp(-x)));
	}
}