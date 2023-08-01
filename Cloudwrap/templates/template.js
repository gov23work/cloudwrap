function get(name){
   if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
      return decodeURIComponent(name[1]);
}

function entry(request){
    //template entry point calling the two cloud functions provided
    //get mode, which then decides what is being executed
    String mode = request
    switch(mode){
        case "A":
            break;
        case "B":
            break;
        case "C":
            break;
        case "D":
            break;
        default:
            break;
    }

    if
}