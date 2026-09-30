package com.hl.week4.lab2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Interest {
	private BigDecimal principal;
	private BigDecimal rate;
	private int time;
	
	public BigDecimal getPrincipal() {
		return principal;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public int getTime() {
		return time;
	}
	
	public Interest(BigDecimal principal, BigDecimal rate, int time) throws Exception {
	    if (principal.compareTo(BigDecimal.ZERO) <= 0) {
	        throw new Exception("Principal must be positive.");
	    }
	    
	    if (rate.compareTo(BigDecimal.ZERO) <= 0) {
	        throw new Exception("Rate must be positive.");
	    }
	    
	    if (time <= 0) {
	        throw new Exception("Time must be positive.");
	    }

	    this.principal = principal;
	    this.rate = rate;
	    this.time = time;
	}
	
	public BigDecimal calculateSimpleInterest(BigDecimal p, BigDecimal r, int t) {
		//(p * r * t) / 100
        return p.multiply(r).multiply(BigDecimal.valueOf(t))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    public double calculateSimpleInterest(double p, double r, int t) {
        return (p * r * t) / 100.0;
    }
    
    public BigDecimal calculateCompoundInterest(BigDecimal p, BigDecimal r, int t) {
    	//p * (1 + r/100)^t -p
        BigDecimal rateFraction = r.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
        BigDecimal onePlusR = BigDecimal.ONE.add(rateFraction);
        BigDecimal amount = p.multiply(onePlusR.pow(t));
        BigDecimal compoundInterest = amount.subtract(p);
        return compoundInterest.setScale(2, RoundingMode.HALF_UP);
    }

    public double calculateCompoundInterest(double p, double r, int t) {
        double amount = p * Math.pow((1 + r / 100.0), t);
        return amount - p;
    }
}