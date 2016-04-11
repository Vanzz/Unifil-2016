public class ComprimentoSequencia
{
    public int comprimentoSequencia(int num) {
        int i = 1;
        while (num > 1) {
            if (num %2 == 0) num = num/2; 
            else num = (3*num) + 1;
            i++;
        }
        return i;
    }

    public int comprimentoSequenciaRec(int num) {
        int x = 0;
        
        if (num <= 1)   return ++x;
        if (num%2 == 0) {
            x++;
            num = num/2;
            return cSRH(num, x);
        } else if (num%2 != 0) {
            x++;
            num = (num*3) + 1;
            return cSRH(num, x);
        }

        return x;
    }
    
    public int cSRH (int num, int x) {
        if (num <= 1)   return ++x;
        if (num%2 == 0) {
            x++;
            num = num/2;
            return cSRH(num, x);
        } else if (num%2 != 0) {
            x++;
            num = (num*3) + 1;
            return cSRH(num, x);
        }

        return x;
    }
}
