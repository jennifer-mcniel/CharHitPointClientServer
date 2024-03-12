import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 A character has hp that can be increased to it's maxHP and decreased to zero

 */
public class CharHitPoint
{
    private double currentHP;
    private Lock HPChangeLock;
    private double maxHP;

    /**
     Constructs a character that has current HP and max HP of 50.
     */
    public CharHitPoint()
    {
        currentHP = 50;
        maxHP = 50;
        HPChangeLock = new ReentrantLock();
    }

    /**
     Constructs a character with a given maxHP.
     @param maxHP the initial maxHP
     */
    public CharHitPoint(double maxHP)
    {

        this.maxHP = currentHP = maxHP;
    }

    /**
     Increases currentHP by the given amount up to maxHP.
     @param amount the amount to increase
     */
    public void heal(double amount)
    {
        HPChangeLock.lock();
        try
        {
            double newHP = currentHP + amount;
            if(newHP <= maxHP){
                currentHP = newHP;
            }else{
                currentHP = maxHP;
            }

        }
        finally
        {
            HPChangeLock.unlock();
        }
    }

    /**
     Decreases currentHP by the given amount to a minimum of 0.
     @param amount the amount to withdraw
     */
    public void damage(double amount)
    {
        HPChangeLock.lock();
        try
        {
            double newHP = currentHP - amount;
            if(newHP >= 0){
                currentHP = newHP;
            }else{
                currentHP = 0;
            }
        }
        finally
        {
            HPChangeLock.unlock();
        }
    }

    /**
     "Full Heal" Resets HP to maximumHP.
     */
    public void restore()
    {
        HPChangeLock.lock();
        try
        {
            currentHP = maxHP;
        }
        finally
        {
            HPChangeLock.unlock();
        }
    }

    /**
     Increases maxHP by the given amount.
     @param amount the amount to increase
     */
    public void increaseMax(double amount)
    {
        HPChangeLock.lock();
        try
        {
            double newHP = maxHP + amount;
            maxHP = newHP;
        }
        finally
        {
            HPChangeLock.unlock();
        }
    }

    /**
     Gets the current HP of the character.
     @return the current HP
     */
    public double getCurrentHP()
    {
        return currentHP;
    }
}