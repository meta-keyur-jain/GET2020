//This function is used to remove duplicate string.
//if input is eeabcddcbfgf then
//eeabcddcbfgf->abcddcbfgf->abccbfgf->abbfgf->afg
function findString(inputString) {
    var consecutiveRepeated = false;
    console.log(inputString);
    var str;
    for (var index = 1; index < inputString.length; index++) {
        if (inputString[index] == inputString[index - 1]) {
            consecutiveRepeated = true;
            break;
        }
    }
    if (consecutiveRepeated == true) {
        str = inputString.substring(0, index - 1);
        console.log("str1" + str)
        str += inputString.substring(index + 1, inputString.length);
        console.log("str2" + str)
        return findString(str);
    } else {
        return inputString;
    }
}