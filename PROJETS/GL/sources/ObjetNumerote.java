/** Classe ObjetNumerote */
public class ObjetNumerote
{
    /** attribut itérateur */
    public static int num = 0;
    public int numero;

    /** Constructeur */
    public ObjetNumerote()
    {
	this.numero = num;
	this.num = num + 1;
    }

    public String toString()
    {
	return "instance n°" + num;
    }
    public static void main(String [] arg)
    {
	ObjetNumerote obj1 = new ObjetNumerote();
	System.out.println(obj1.toString());
	ObjetNumerote obj2 = new ObjetNumerote();
	System.out.println(obj2.toString());
	ObjetNumerote obj3 = new ObjetNumerote();
	System.out.println(obj3.toString());
    }
}
    
