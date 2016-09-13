/**
 * Created by Richard-DT on 10/09/2016.
 */
function verfyText(champ)
{
    if(champ.value.length < 2 || champ.value.length > 20)
    {
        if (!$(champ.parentNode.parentNode).hasClass("has-error")){
            $(champ.parentNode.parentNode).addClass("has-error");
            $(champ.parentNode.parentNode).removeClass("has-success");
        }
        return false;
    }
    else
    {

        if (!$(champ.parentNode.parentNode).hasClass("has-success")){
            $(champ.parentNode.parentNode).addClass("has-success");
            $(champ.parentNode.parentNode).removeClass("has-error");
        }
        return true;
    }
}
function VerifyDate(date) {
    var d;
    try {
        d =date.value;
    }
    catch (TypeError){
        if (!$(date.parentNode.parentNode).hasClass("has-error")){
            $(date.parentNode.parentNode).addClass("has-error");
            $(date.parentNode.parentNode).removeClass("has-success");
        }
        return false;
    }

    var separateur="/"; // separateur entre jour/mois/annee

    var a=parseInt(d.substring(0,4));
    var m=parseInt(d.substring(5,7));
    var j=parseInt(d.substring(8,10));
    var ok=1;
    if ( ((isNaN(j))||(j<1)||(j>31)) && (ok==1) ) {
        ok=0;
    }
    if ( ((isNaN(m))||(m<1)||(m>12)) && (ok==1) ) {
        ok=0;
    }
    if ( ((isNaN(a))||(a>10000)||(a<1900)) && (ok==1) ) {
        ok=0;
    }
    if (ok==1) {
        if (!$(date.parentNode.parentNode).hasClass("has-success")){
            $(date.parentNode.parentNode).addClass("has-success");
            $(date.parentNode.parentNode).removeClass("has-error");
        }
        return true;

    }
    if (!$(date.parentNode.parentNode).hasClass("has-error")){
        $(date.parentNode.parentNode).addClass("has-error");
        $(date.parentNode.parentNode).removeClass("has-success");
    }
    return false;
}
function VerifyAll() {
    var inputs = this.getElementsByClassName("input");
    for (input in inputs){
        if(input.type == "text"){
            if(verfyText(input)==false){
                return false;
            }
        }
        if(input.type == "date"){
            var val = input.value();
            return false;
        }
    }
}
function confirmDelete() {
    if (confirm("Etes-vous sur de vouloir supprimer cet ordinateur?")) {
        document.getElementById("computerDelete").submit();
    }
    return false;
}