/**
 * Created by Richard-DT on 10/09/2016.
 */
function verfyText(champ)
{
    if(champ.value.length < 2 || champ.value.length > 20)
    {
        champ.className +=" has-error";
        return false;
    }
    else
    {
        champ.className +=" has-success";
        return true;
    }
}