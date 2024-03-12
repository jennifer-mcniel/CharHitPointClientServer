/**
 A bank consisting of multiple bank accounts.
 */
public class CharacterList
{
    private CharHitPoint[] characters;

    /**
     Constructs a character list with a given number of characters.
     @param size the number of accounts
     */
    public CharacterList(int size)
    {
        characters = new CharHitPoint[size];
        for (int i = 0; i < characters.length; i++)
        {
            characters[i] = new CharHitPoint();
        }
    }

    /**
     Heals a character by a given amount up to their max HP.
     @param charIDNUM the character ID number
     @param amount the amount to heal
     */
    public void heal(int charIDNUM, double amount)
    {
        CharHitPoint charID = characters[charIDNUM];
        charID.heal(amount);
    }

    /**
     Reduces a character's current HP to a minimum of 0.
     @param charIDNum the character ID number
     @param amount the amount to withdraw
     */
    public void damage(int charIDNum, double amount)
    {
        CharHitPoint account = characters[charIDNum];
        account.damage(amount);
    }

    /**
     Heals a character to their max HP.
     @param charIDNUM the character ID number
     */
    public void restore(int charIDNUM)
    {
        CharHitPoint charID = characters[charIDNUM];
        charID.restore();
    }

    /**
     Increases a character's max HP by a given amount.
     @param charIDNUM the character ID number
     @param amount the amount to increase
     */
    public void increaseMax(int charIDNUM, double amount)
    {
        CharHitPoint charID = characters[charIDNUM];
        charID.increaseMax(amount);
    }

    /**
     Gets the current HP of a character.
     @param charIDNum the account number
     @return the account balance
     */
    public double getCurrentHP(int charIDNum)
    {
        CharHitPoint charID = characters[charIDNum];
        return charID.getCurrentHP();
    }
}