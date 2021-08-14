import java.util.Scanner;

public class Test2 {

    public static CurrencyType currencycount(Long amount) {
        Long hundreds  = new Long(0);
        Long fiveHundread = new Long(0);
        Long twoThousands = new Long(0);

        if (amount > 2000) {
            if (amount % 2000 == 0) {
                return new  CurrencyType(hundreds, fiveHundread,twoThousands);
            }else{
                Long remainingValue2000 = amount % 2000;
                 twoThousands = (amount - remainingValue2000) / 2000;
                 if(remainingValue2000 >= 500){
                     if (remainingValue2000 % 500 == 0) {
                       //  Long remainingValue500 = remainingValue % 500;
                         fiveHundread = remainingValue2000 / 500;
                         return new  CurrencyType(hundreds, fiveHundread,twoThousands);
                     }else {
                         Long remainingValue500 = remainingValue2000 % 500;
                         fiveHundread = (remainingValue2000 - remainingValue500) /500;
                         hundreds = remainingValue500/100;
                         return new  CurrencyType(hundreds, fiveHundread,twoThousands);
                     }
                 }else {
                    hundreds = remainingValue2000/100;
                 }
            }
        } else if (amount >= 500) {
            if (amount % 500 == 0) {
                fiveHundread = amount/500;
                return new  CurrencyType(hundreds, fiveHundread,twoThousands);
            }else{
                Long remainingValue500 = amount % 500;
                fiveHundread = (amount - remainingValue500) / 500;
                hundreds = remainingValue500 / 100;
            }
        } else if (amount >= 100) {
            if (amount % 100 == 0) {
                hundreds = amount/100;
                return new  CurrencyType(hundreds, fiveHundread,twoThousands);
            }
        }
        return new  CurrencyType(hundreds, fiveHundread,twoThousands);

    }

    public static void main(String args[]) {
        while(true) {
            Scanner sc= new Scanner(System.in);
            System.out.println("Please Enter the Amount Priyachels");
            Long amt= sc.nextLong();
            currencycount(new Long(amt));
        }

    }

    public static class CurrencyType {


        Long hundred;
        Long fiveHundread;
        Long twoThousand;

        public CurrencyType(Long hundred, Long fiveHundread, Long twoThousand) {
            this.hundred = hundred;
            this.fiveHundread = fiveHundread;
            this.twoThousand = twoThousand;
            System.out.println("CurrencyType{" +
                    "hundred=" + hundred +
                    ", fiveHundread=" + fiveHundread +
                    ", twoThousand=" + twoThousand +
                    '}');
        }

        public Long getHundred() {
            return hundred;
        }

        public void setHundred(Long hundred) {
            this.hundred = hundred;
        }

        public Long getThousand() {
            return fiveHundread;
        }

        public void setThousand(Long thousand) {
            this.fiveHundread = thousand;
        }

        public Long getTwoThousand() {
            return twoThousand;
        }

        public void setTwoThousand(Long twoThousand) {
            this.twoThousand = twoThousand;
        }
    }

}
