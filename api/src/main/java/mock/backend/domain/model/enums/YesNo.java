package mock.backend.domain.model.enums;

public enum YesNo
{
    YES(true),
    NO(false);

    private boolean booleanValue;

    YesNo(boolean booleanValue)
    {
        this.booleanValue = booleanValue;
    }

    public boolean getBooleanValue()
    {
        return booleanValue;
    }

    public static YesNo getFromBooleanValue(boolean booleanValue)
    {
        for(YesNo yesNo : YesNo.values())
        {
            if(yesNo.getBooleanValue() == booleanValue)
            {
                return yesNo;
            }
        }
        return null;
    }
}
