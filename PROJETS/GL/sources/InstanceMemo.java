public class InstanceMemo {
    public static int number = 0;
    public static InstanceMemo[] tab = new InstanceMemo[255];
    public int num;

    public InstanceMemo()
    {
	num = ++number;
	tab[num - 1] = this;
    }

    public static int nombreInstances()
    {
		return number;
    }

    public static void afficherInstances()
    {
		for(int i = 0; i < number; i++)
	    	{
				System.out.println("Je suis l'instance numéro " + tab[i].num);
	    	}	
    }
}
